/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.idgs.libreria.db.ConexionMySQL;
import org.utl.idgs.libreria.model.Alumno;
import org.utl.idgs.libreria.model.Libro;
import org.utl.idgs.libreria.model.Usuario;
import org.utl.idgs.libreria.dao.usuarioDao;
import jakarta.ws.rs.core.Response;
import org.utl.idgs.libreria.CQRS.UsuarioCQRS;


/**
 *
 * @author garni
 */
public class Prueba {

    public static void main(String[] args) {
        //probarInseratar();
        //probarBuscar();
//        probarConexion();
          //probarAcceso2();
          probarInsertarC();
    }

    public static void probarConexion() {
        try {
            ConexionMySQL objConexion = new ConexionMySQL();
            Connection conexion = objConexion.open();
            System.out.println(conexion.toString());
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    public static void probarAcceso(){
        Usuario u = new Usuario();
        u.setContrasenia("15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225");
        u.setCorreo("iamramosg@gmail.com");
    
        ControllerLogin ca = new ControllerLogin();
        try{
            //Empleado e = ca.entrar(u);
            Alumno a = ca.entrarAlumno(u);
            u.toString();
            System.out.println("Acceso Concedido");
            System.out.println(a.getIdAlumno());
        }catch(Exception ex){
            System.out.println("Acceso Denegado");
        }
    }
//    
        public static void probarBuscar(){

 
    
        ControllerLibro ca = new ControllerLibro();
        try{
            //Empleado e = ca.entrar(u);
            ca.buscarLibro("cracking");
            System.out.println("Acceso Concedido");
        }catch(Exception ex){
            System.out.println("Acceso Denegado");
        }
    }
    public static void probarAcceso2() {
        Usuario u = new Usuario();
        u.setContrasenia("15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225");
        u.setCorreo("iamramosg@gmail.com");

        usuarioDao ca = new usuarioDao();
        ControllerLogin objca = new ControllerLogin();
        try {
            //Empleado e = ca.entrar(u);
            //u = ca.getByCorreo(u);
            u = objca.entrarAdministrdor(u);
            u.toString();
            System.out.println("Acceso Concedido");
            System.out.println(u.getIdUsuario());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static void probarInsertarC(){
        Usuario u = new Usuario();
        u.setNombre("Maria");
        u.setApellidoP("Torres");
        u.setApellidoM("Rojas");
        u.setGenero("F");
        u.setCorreo("maria@gmail.com");
        u.setContrasenia("15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225");
        
        //UsuarioCQRS cq = new UsuarioCQRS();
        ControllerLogin ca = new ControllerLogin();
        try{
            //cq.insertar(u);
            ca.insertarCliente(u);
            System.out.println("Usuario Insertado");
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

}
