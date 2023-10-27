/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.idgs.libreria.CQRS.UsuarioCQRS;
import org.utl.idgs.libreria.controller.ControllerLogin;
import org.utl.idgs.libreria.model.Usuario;
import org.utl.idgs.libreria.dao.usuarioDao;

/**
 *
 * @author garni
 */
@Path("restlibreria")
public class LoginRest extends Application {

    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response acceder(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario u = new Usuario();
        //Alumno a = new Alumno();
        u = gson.fromJson(datosUsuario, Usuario.class);
        ControllerLogin objCA = new ControllerLogin();
        try {
            u = objCA.entrarUsuario(u);
        } catch (Exception ex) {
            Logger.getLogger(LoginRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String out = gson.toJson(u);
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("loginAdministrador")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response entrarAdministrador(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario u = new Usuario();
        //Alumno a = new Alumno();
        u = gson.fromJson(datosUsuario, Usuario.class);
        ControllerLogin objCA = new ControllerLogin();
        try {
            u = objCA.entrarAdministrdor(u);
            String out = gson.toJson(u);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }

    @Path("loginCliente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response entrarCliente(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario u = new Usuario();
        //Alumno a = new Alumno();
        u = gson.fromJson(datosUsuario, Usuario.class);
        ControllerLogin objCA = new ControllerLogin();
        try {
            u = objCA.entrarCliente(u);
            String out = gson.toJson(u);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }

    @Path("loginVendedor")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response entrarVendedor(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario u = new Usuario();
        //Alumno a = new Alumno();
        u = gson.fromJson(datosUsuario, Usuario.class);
        ControllerLogin objCA = new ControllerLogin();
        try {
            u = objCA.entrarVendedor(u);
            String out = gson.toJson(u);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }

    @Path("insertarCliente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarCliente(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario u = new Usuario();
        //Alumno a = new Alumno();
        u = gson.fromJson(datosUsuario, Usuario.class);
        //UsuarioCQRS cq = new UsuarioCQRS();
        ControllerLogin ca = new ControllerLogin();
        try {
            u = ca.insertarCliente(u);
            //u = cq.insertar(u);
            String out = gson.toJson(u);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }

}
