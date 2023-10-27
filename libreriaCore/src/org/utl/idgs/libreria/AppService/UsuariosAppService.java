package org.utl.idgs.libreria.AppService;
import java.sql.SQLException;
import org.utl.idgs.libreria.model.Usuario;
import org.utl.idgs.libreria.CQRS.UsuarioCQRS;
import org.utl.idgs.libreria.dao.usuarioDao;
/**
 *
 * @author iamra
 */
public class UsuariosAppService {
    //crear un metodo que se llame registro cliente,
    //recibimos el modelo de nuestro tipo de usuario
    //llamamos una instancia de cqrs el de registro
    public Usuario registroCliente(Usuario usuario) throws Exception{
        UsuarioCQRS cq = new UsuarioCQRS();
        Usuario us = cq.insertar(usuario);
        //instancia del emailservice llamamos el de enviar correo
        //usuario email y confirma tu cuenta
        EmailService es = new EmailService();
        es.enviarCorreo(us.getCorreo(), "");
        return us;
    }
    
    //String contra
    public void RecuperarContraseña(Usuario u) throws SQLException, usuarioDao.ContraseñaIncorrectaException, Exception{
        //llamar al dao que buscar usuario por correo
        usuarioDao dao = new usuarioDao();
        Usuario us = dao.getByCorreo(u);
        
        if(us == null){
            throw new Exception("El usuario no existe");
        }
        EmailService emailService = new EmailService();
        emailService.enviarCorreo(u.getCorreo(), "Ten para que lo recuperes");
    }
    
    //Quizas considera quitarle la contraseña 
    public void RestablecerContraseña(Usuario u, String Contraseña) throws Exception{
        UsuarioCQRS cqrs = new UsuarioCQRS();
        cqrs.restablecerContraseña(u, Contraseña);
    }
}
