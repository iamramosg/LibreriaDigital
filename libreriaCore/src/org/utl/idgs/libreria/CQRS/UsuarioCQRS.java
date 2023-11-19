/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.CQRS;
import org.utl.idgs.libreria.dao.usuarioDao;
import org.utl.idgs.libreria.model.Usuario;

/**
 *
 * @author iamra
 */
public class UsuarioCQRS {
    public Usuario insertarCliente(Usuario u) throws Exception{
        if(u.getNombre() == null || u.getCorreo().isEmpty()){
            throw new Exception("Error: Correo vacio");
        }
        if(u.getContrasenia()== null || u.getContrasenia().isEmpty()){
            throw new Exception("Error: Contraseña vacia");
        }
        u.setEstatus(0);
        u.setRol("Alumno");
        usuarioDao dao = new usuarioDao();
        int usrid = dao.insertarCliente(u);
        Usuario usr = dao.getByCorreo(u.getCorreo());
        return usr;
    }
    
    public void restablecerContrasenia(Usuario u) throws Exception{
        usuarioDao dao = new usuarioDao();
        Usuario usr = dao.getByCorreo(u.getCorreo());
        usr.setContrasenia(u.getContrasenia());
        dao.actualizarCliente(usr);

    }
    
    
}
