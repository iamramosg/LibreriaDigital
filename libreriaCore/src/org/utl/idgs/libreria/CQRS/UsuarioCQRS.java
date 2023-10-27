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
    public Usuario insertar(Usuario u) throws Exception{
        if (u.getCorreo() == null || u.getCorreo().isEmpty()) {
            throw new Exception("Error: El correo esta vacio");
        }
        // Validar que la contraseña no esté vacía
        if (u.getContrasenia() == null || u.getContrasenia().isEmpty()) {
            throw new Exception("Error: La contraseña esta vacia");
        }
        u.setEstatus(0);
        u.setRol("Cliente");
        usuarioDao dao = new usuarioDao();
        int usrid = dao.insertarCliente(u);
        
        Usuario usr = dao.getByCorreo(u);
        return usr;           
    }
    
    //usuario y contraseña
    //Quizas considera quitarle la contraseña y ponerle getContraseña()
    public void restablecerContraseña(Usuario u, String Contraseña) throws Exception{
        usuarioDao dao = new usuarioDao();
        Usuario us = dao.getByCorreo(u);
        //llamar el dao 
        // llamar al dao get by correo
        //actualizar al usuario al que le estas metiendo contraseña
        us.setContrasenia(Contraseña);
        dao.actualizarUsuario(us);
        //llamas al actualizarUsuario
        
        //mandar un correo de confirmacion  
        
    }
    
    
    
}
