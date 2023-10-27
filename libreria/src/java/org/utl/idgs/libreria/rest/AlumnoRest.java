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
import java.util.List;
import org.utl.idgs.libreria.controller.ControllerAlumno;
import org.utl.idgs.libreria.model.Alumno;

/**
 *
 * @author garni
 */
@Path("restlibreria")
public class AlumnoRest extends Application{
    @Path("insertarAlumno")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarAlumno (@FormParam ("datosAlumno") @DefaultValue ("") String datosAlumno) {
        Gson gson = new Gson();
        Alumno alumno = new Alumno();
        alumno = gson.fromJson(datosAlumno, Alumno.class);
        ControllerAlumno objCl = new ControllerAlumno();
        String out = "";  
        try{
            objCl.insertar(alumno);
        }catch (Exception ex){
            out = "{\"error\":" + ex.toString()+"}";
        }
        out = gson.toJson(alumno);
        return Response.status(Response.Status.OK).entity(out).build();        
    }
    
    @Path("actualizarAlumno")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmpleado(@FormParam ("datosAlumno") @DefaultValue ("") String datosAlumno){
        Gson gson = new Gson();
        Alumno alumno = new Alumno();
        alumno = gson.fromJson(datosAlumno, Alumno.class);
        ControllerAlumno objCl = new ControllerAlumno();
        String out = "";
        try {
            objCl.actualizar(alumno);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString()+"}";
        }
        out = gson.toJson(alumno);
        return Response.status(Response.Status.OK).entity(out).build();
    }    
    @Path("getAllAlumno")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAlumno(@FormParam("estatus") @DefaultValue("1") String estatus){
        String out = "";
        Gson gson = new Gson();
        try{
            ControllerAlumno objCl = new ControllerAlumno();
            List<Alumno> alumnos;
            alumnos = objCl.getAll(estatus);
            out = gson.toJson(alumnos);
        }catch(Exception ex){
            out="{\"error\":" + ex.toString()+"}";
            
        }
        return Response.status(Response.Status.OK).entity(out).build();
        
    }    
    @Path("eliminarAlumno")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarAlumno(@FormParam ("datosAlumno") @DefaultValue ("") String datosAlumno){
        Gson gson = new Gson();
        Alumno alumno = new Alumno();
        alumno = gson.fromJson(datosAlumno, Alumno.class);
        ControllerAlumno objCl = new ControllerAlumno();
        String out = "";
        try {
            objCl.eliminar(alumno);
        } catch (Exception ex) {
            out = "{\"error\":" + ex.toString()+"}";
        }
        out = gson.toJson(alumno);
        return Response.status(Response.Status.OK).entity(out).build();
    }       
    
}