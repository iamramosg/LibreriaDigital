package org.utl.idgs.libreria.AppService;
import java.sql.SQLException;
import org.utl.idgs.libreria.model.Usuario;
import org.utl.idgs.libreria.CQRS.UsuarioCQRS;
import org.utl.idgs.libreria.ViewModels.UsuarioPublicViewModel;
import org.utl.idgs.libreria.dao.usuarioDao;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author iamra
 */
public class UsuariosAppService {
    public Usuario registroCliente(Usuario u) throws Exception{
        UsuarioCQRS cqrs = new UsuarioCQRS();
        Usuario usr = cqrs.insertarCliente(u);
        EmailService emailS = new EmailService();
        emailS.enviarCorreo(usr.getCorreo(), "Tu registro ha concluido exitosamente.");

        return usr;
    }
    
    public void recuperarContrasenia(String correo) throws Exception{
        usuarioDao dao = new usuarioDao();
        Usuario u = dao.getByCorreo(correo);
        if(u == null){
            throw new Exception("El usuario no existe");
        }
        EmailService emailS = new EmailService();
        emailS.enviarCorreo(u.getCorreo(), "Recupera tu contraseña");
    }
    
    public Usuario restablecerContrasenia(Usuario u) throws Exception{
        UsuarioCQRS cqrs = new UsuarioCQRS();
        cqrs.restablecerContrasenia(u);
        return u;
    }
    
    public Usuario buscarUsuarioByCorreo(Usuario u) throws SQLException{
        usuarioDao dao = new usuarioDao();
        Usuario usr = dao.getByCorreo(u.getCorreo());
        return usr;
    }
    
    public UsuarioPublicViewModel buscarByCorreoPublic(Usuario u) throws Exception {
        usuarioDao dao = new usuarioDao();
        Usuario usr = dao.getByCorreo(u.getCorreo());
        
        UsuarioPublicViewModel uvm = new UsuarioPublicViewModel(String.valueOf(usr.getIdUsuario()),usr.getCorreo());
        
        
        return uvm;
    }
    
    public List<Usuario> getAllUsuario() throws SQLException {
        usuarioDao dao = new usuarioDao();
        List<Usuario> usr = dao.getAll();
        return usr;
    }

    public List<UsuarioPublicViewModel> getAllUsuarioPublic() throws Exception {
        usuarioDao dao = new usuarioDao();
        List<Usuario> usr = dao.getAll();
        List<UsuarioPublicViewModel> list_lvm = new ArrayList<>();

        for (int i = 0; i < usr.size(); i++) {
            UsuarioPublicViewModel lvm = new UsuarioPublicViewModel(String.valueOf(usr.get(i).getIdUsuario()),usr.get(i).getCorreo());
            list_lvm.add(lvm);
        }

        return list_lvm;
    }
}
