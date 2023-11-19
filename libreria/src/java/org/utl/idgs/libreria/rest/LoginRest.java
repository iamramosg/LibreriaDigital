/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.rest;

import com.google.gson.Gson;
import java.util.List;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Level;
import jakarta.ws.rs.GET;
import java.util.logging.Logger;
import org.utl.idgs.libreria.CQRS.UsuarioCQRS;
import org.utl.idgs.libreria.ViewModels.UsuarioPublicViewModel;
import org.utl.idgs.libreria.controller.ControllerLogin;
import org.utl.idgs.libreria.model.Usuario;
import org.utl.idgs.libreria.dao.usuarioDao;
import org.utl.idgs.libreria.AppService.UsuariosAppService;
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
    public Response loginAdministrador(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario u = new Usuario();
        //Alumno a = new Alumno();
        u = gson.fromJson(datosUsuario, Usuario.class);
        ControllerLogin objCA = new ControllerLogin();
        try {
            u = objCA.loginAdministrador(u);
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
    public Response loginVendedor(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario u = new Usuario();
        //Alumno a = new Alumno();
        u = gson.fromJson(datosUsuario, Usuario.class);
        ControllerLogin objCA = new ControllerLogin();
        try {
            u = objCA.loginVendedor(u);
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
    public Response loginCliente(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario u = new Usuario();
        //Alumno a = new Alumno();
        u = gson.fromJson(datosUsuario, Usuario.class);
        ControllerLogin objCA = new ControllerLogin();
        try {
            u = objCA.loginCliente(u);
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
        Usuario usuario = new Usuario();
        usuario = gson.fromJson(datosUsuario, Usuario.class);
        ControllerLogin objCl = new ControllerLogin();
        try {
            usuario = objCl.insertarCliente(usuario);
            String out = gson.toJson(usuario);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }
    
    @Path("restablecerContra")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response restablecerContra(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario usuario = new Usuario();
        usuario = gson.fromJson(datosUsuario, Usuario.class);
        UsuariosAppService objCl = new UsuariosAppService();
        try {
            usuario = objCl.restablecerContrasenia(usuario);
            String out = gson.toJson(usuario);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }
    
    @Path("buscarByCorreo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarByCorreo(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario usuario = new Usuario();
        usuario = gson.fromJson(datosUsuario, Usuario.class);
        ControllerLogin objCl = new ControllerLogin();
        try {
            usuario = objCl.buscarByCorreo(usuario);
            String out = gson.toJson(usuario);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }
    
    @Path("buscarByCorreoPublic")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarByCorreoPublic(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        Gson gson = new Gson();
        Usuario usuario = new Usuario();
        usuario = gson.fromJson(datosUsuario, Usuario.class);
        ControllerLogin objCl = new ControllerLogin();
        try {
            
            UsuarioPublicViewModel usr = objCl.buscarByCorreoPublic(usuario);
            String out = gson.toJson(usr);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }
    
    @Path("getAllUsuario")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsuario() {
        Gson gson = new Gson();
        ControllerLogin objCl = new ControllerLogin();
        try {
            List<Usuario> libros = objCl.getAllUsuario();
            String out = gson.toJson(libros);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }
    
    @Path("getAllUsuarioPublic")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsuarioPublic() {
        Gson gson = new Gson();
        ControllerLogin objCl = new ControllerLogin();
        try {
            
            List<UsuarioPublicViewModel> lbr = objCl.getAllLibroPublic();
            String out = gson.toJson(lbr);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }

}
