/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.idgs.libreria.AppService.LibroAppService;
import org.utl.idgs.libreria.controller.ControllerLibro;
import org.utl.idgs.libreria.model.Libro;
import org.utl.idgs.libreria.ViewModels.LibroPublicViewModel;

/**
 *
 * @author garni
 */
@Path("restlibreria")
public class LibroRest extends Application {

    @Path("getAllLibro")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLibro() {
        Gson gson = new Gson();
        ControllerLibro objCl = new ControllerLibro();
        try {
            List<Libro> libros = objCl.getAllLibro();
            String out = gson.toJson(libros);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }

    @Path("getAllLibroPublic")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLibroPublic() {
        Gson gson = new Gson();
        ControllerLibro objCl = new ControllerLibro();
        try {

            List<LibroPublicViewModel> lbr = objCl.getAllLibroPublic();
            String out = gson.toJson(lbr);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }

//    @Path("insertarLibro")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response insertarLibro(@FormParam("datosLibro") @DefaultValue("") String datosLibro) {
//        try {
//            Gson gson = new Gson();
//            Libro libro = new Libro();
//            libro = gson.fromJson(datosLibro, Libro.class);
//            ControllerLibro objAr = new ControllerLibro();
//            String out = "";
//            try {
//                objAr.insertar(libro);
//            } catch (Exception ex) {
//                out = "{\"error\":" + ex.toString() + "}";
//            }
//            out = gson.toJson(libro);
//            return Response.status(Response.Status.OK).entity(out).build();
//
//        } catch (Exception ex) {
//            Logger.getLogger(LibroRest.class.getName()).log(Level.SEVERE, null, ex);
//            String out = "{\"error\":'Acceso no valido'}";
//            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
//        }
//    }
//
//    @Path("actualizarLibro")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response actualizarLibro(@FormParam("datosLibro") @DefaultValue("") String datosLibro) {
//        try {
//            Gson gson = new Gson();
//            Libro libro = new Libro();
//            libro = gson.fromJson(datosLibro, Libro.class);
//            ControllerLibro objCA = new ControllerLibro();
//            String out = "";
//            try {
//                objCA.actualizar(libro);
//            } catch (Exception ex) {
//                out = "{\"error\":" + ex.toString() + "}";
//                return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
//            }
//            out = gson.toJson(libro);
//            return Response.status(Response.Status.OK).entity(out).build();
//        } catch (Exception ex) {
//            Logger.getLogger(LibroRest.class.getName()).log(Level.SEVERE, null, ex);
//            String out = "{\"error\":'Acceso no valido'}";
//            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
//        }
//    }
//
//    @Path("getAllLibro")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAllLibro() {
//        try {
//            String out = "";
//            Gson gson = new Gson();
//            try {
//                ControllerLibro objCE = new ControllerLibro();
//                List<Libro> libro;
//                libro = objCE.getAll();
//                out = gson.toJson(libro);
//            } catch (Exception ex) {
//                out = "{\"error\":\"" + ex.toString() + "\"}";
//            }
//            return Response.status(Response.Status.OK).entity(out).build();
//        } catch (Exception ex) {
//            Logger.getLogger(LibroRest.class.getName()).log(Level.SEVERE, null, ex);
//            String out = "{\"error\":'Acceso no valido'}";
//            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
//        }
//    }
//    
//    @Path("eliminarLibro")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response eliminarLibro(@FormParam("idLibro") @DefaultValue("") String idLibro){
//        try{
//                        Gson gson = new Gson();
//            Libro libro = new Libro();
//            libro = gson.fromJson(idLibro, Libro.class);
//            ControllerLibro objA = new ControllerLibro();
//            String out = "";
//            try{
//                objA.eliminar(idLibro);
//            }catch (Exception ex){
//                out = "{\"error\":\"" + ex.toString() + "\"}";
//            }
//            out = gson.toJson(libro);
//            return Response.status(Response.Status.OK).entity(out).build();
//        } catch (Exception ex) {
//            Logger.getLogger(LibroRest.class.getName()).log(Level.SEVERE, null, ex);
//            String out = "{\"error\":'Acceso no valido'}";
//            return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
//        }
//    }
//    
//    @Path("buscarLibro")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response buscarLibro(@FormParam("titulo") @DefaultValue("") String titulo) throws Exception {
//        String out = "";
//        Gson gson = new Gson();
//        
//            try {
//                ControllerLibro ca = new ControllerLibro();
//                List<Libro> libros;
//                libros = ca.buscarLibro(titulo);
//                out = gson.toJson(libros);
//
//            } catch (Exception ex) {
//                out = "{\"error\": \"" + ex.toString() + "\"}";
//            }
//        
//
//        // return Response.status(Response.Status.OK).entity(out).build();
//          return Response
//                .status(Response.Status.OK)
//                .entity(out)
//                .header("Content-Type", "application/json") // Set Content-Type header
//                .header("Access-Control-Allow-Origin", "*") // Set Access-Control-Allow-Origin header
//                .header("X-Content-Type-Options", "no-sniff")
//                .build();
//    }
    @Path("insertarLibro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarLibro(@FormParam("datosLibro") @DefaultValue("") String datosLibro) {
        Gson gson = new Gson();
        Libro libro = new Libro();
        libro = gson.fromJson(datosLibro, Libro.class);
        ControllerLibro objCl = new ControllerLibro();
        try {
            libro = objCl.insertarLibro(libro);
            String out = gson.toJson(libro);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }

    @Path("restablecerLibro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response restablecerLibro(@FormParam("datosLibro") @DefaultValue("") String datosLibro) {
        Gson gson = new Gson();
        Libro libro = new Libro();
        libro = gson.fromJson(datosLibro, Libro.class);
        LibroAppService objCl = new LibroAppService();
        try {
            libro = objCl.restablecerLibro(libro);
            String out = gson.toJson(libro);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }

    @Path("buscarLibro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarLibro(@FormParam("datosLibro") @DefaultValue("") String datosLibro) {
        Gson gson = new Gson();
        Libro libro = new Libro();
        libro = gson.fromJson(datosLibro, Libro.class);
        ControllerLibro objCl = new ControllerLibro();
        try {
            List<Libro> libros = objCl.buscarLibro(libro);
            String out = gson.toJson(libros);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }

    @Path("buscarLibroPublic")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarLibroPublic(@FormParam("datosLibro") @DefaultValue("") String datosLibro) {
        Gson gson = new Gson();
        Libro libro = new Libro();
        libro = gson.fromJson(datosLibro, Libro.class);
        ControllerLibro objCl = new ControllerLibro();
        try {

            List<LibroPublicViewModel> lbr = objCl.buscarLibroPublic(libro);
            String out = gson.toJson(lbr);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }
}
