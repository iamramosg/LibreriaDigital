package org.utl.idgs.banco.rest;
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
import org.utl.idgs.banco.AppService.*;
import org.utl.idgs.banco.model.*;
import org.utl.idgs.banco.controller.ControllerTransaccion;
/**
 *
 * @author iamra
 */
@Path("restbanco")
public class TransaccionRest extends Application{
    @Path("insertarSolicitud")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarSolicitud(@FormParam("datosTransaccion") @DefaultValue("") String datosTransaccion) {
        Gson gson = new Gson();
        TransactionRequest request = new TransactionRequest();
        request = gson.fromJson(datosTransaccion, TransactionRequest.class);
        ControllerTransaccion objCl = new ControllerTransaccion();
        try {
            request = objCl.insertarSolicitud(request);
            String out = gson.toJson(request);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }   
    @Path("insertarAprobacion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarAprobacion(@FormParam("datosTransaccion") @DefaultValue("") String datosTransaccion) {
        Gson gson = new Gson();
        ApproveTransaction approveTransaction = new ApproveTransaction();
        approveTransaction = gson.fromJson(datosTransaccion, ApproveTransaction.class);
        ControllerTransaccion objCl = new ControllerTransaccion();
        try {
            approveTransaction = objCl.insertarAprobacion(approveTransaction);
            String out = gson.toJson(approveTransaction);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }  
    
    @Path("insertarRetiro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarRetiro(@FormParam("datosTransaccion") @DefaultValue("") String datosTransaccion) {
        Gson gson = new Gson();
        Withdraw withdraw = new Withdraw();
        withdraw = gson.fromJson(datosTransaccion, Withdraw.class);
        ControllerTransaccion objCl = new ControllerTransaccion();
        try {
            withdraw = objCl.insertarRetiro(withdraw);
            String out = gson.toJson(withdraw);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorMessage).build();

        }
    }      
}
