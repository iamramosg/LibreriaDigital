/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.controller;
import org.utl.idgs.banco.AppService.TransaccionService;
import org.utl.idgs.banco.model.*;
/**
 *
 * @author iamra
 */
public class ControllerTransaccion {
    public TransactionRequest insertarSolicitud(TransactionRequest tr) throws Exception{
        TransaccionService appS = new TransaccionService();
        TransactionRequest tr1 = appS.insertarSolicitud(tr);
        
        return tr1;
    }
    public ApproveTransaction insertarSolicitud(ApproveTransaction at) throws Exception{
        TransaccionService appS = new TransaccionService();
        ApproveTransaction at1 = appS.insertarAprobacion(at);
        
        return at1;
    } 
    public Withdraw insertarSolicitud(Withdraw w) throws Exception{
        TransaccionService appS = new TransaccionService();
        Withdraw w1 = appS.insertarRetiro(w);
        
        return w1;
    }    
}
