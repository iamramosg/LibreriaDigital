/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.AppService;
import org.utl.idgs.banco.CQRS.TransaccionCQRS;
import org.utl.idgs.banco.model.*;
/**
 *
 * @author iamra
 */
public class TransaccionService {
    public TransactionRequest insertarSolicitud(TransactionRequest tr) throws Exception{
        TransaccionCQRS cqrs = new TransaccionCQRS();
        TransactionRequest tr1 = cqrs.insertarSolicitud(tr);
        if (tr == null) {
            throw new Exception("Error al insertar la transaccion");
        } 
        return tr1;
    }
    public ApproveTransaction insertarAprobacion(ApproveTransaction at) throws Exception{
        TransaccionCQRS cqrs = new TransaccionCQRS();
        ApproveTransaction at1 = cqrs.insertarAprobacion(at);
        if (at == null) {
            throw new Exception("Error al insertar la transaccion");
        } 
        return at1;
    }    
    public Withdraw insertarRetiro(Withdraw w) throws Exception{
        TransaccionCQRS cqrs = new TransaccionCQRS();
        Withdraw w1 = cqrs.insertarRetiro(w);
        if (w == null) {
            throw new Exception("Error al insertar la transaccion");
        } 
        return w1;
    }      
}
