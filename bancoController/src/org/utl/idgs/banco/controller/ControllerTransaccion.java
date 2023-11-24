/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.controller;
import org.utl.idgs.banco.AppService.TransaccionService;
import org.utl.idgs.banco.ViewModels.AprobarTransaccionPublicViewModel;
import org.utl.idgs.banco.ViewModels.RetiroPublicViewModel;
import org.utl.idgs.banco.model.*;
import org.utl.idgs.banco.ViewModels.*;
/**
 *
 * @author iamra
 */
public class ControllerTransaccion {
    //Usuario propio que retira desde cajero externo
    public TransaccionPublicViewModel insertarSolicitud(TransaccionPublicViewModel tr) throws Exception{
        TransactionRequest request = new TransactionRequest();
        Customer c = new Customer();
        c.setCardNumber(tr.getTransacUsuario().getUsrNoTarjeta());
        c.setPin(tr.getTransacUsuario().getUsrNip());
        
        request.setCustomer(c);
        request.setCantidad(tr.getTransacMonto());
        request.setBank(tr.getTransacBanco());
  
        
        TransaccionService appS = new TransaccionService();
        TransactionRequest tr1 = appS.insertarSolicitud(request);
        tr.setCodigo(request.getKeyCode());
        
        return tr;
    }
    public AprobarTransaccionPublicViewModel insertarAprobacion(AprobarTransaccionPublicViewModel at) throws Exception{
        TransaccionService appS = new TransaccionService();
        Customer c = new Customer();
        ApproveTransaction transaction = new ApproveTransaction();
        c.setIdCustomer(at.getAprUsuario().getUsrId());
        c.setCardNumber(at.getAprUsuario().getUsrNoTarjeta());
        
        transaction.setCustomer(c);
        transaction.setCantidad(at.getAprMonto());
        transaction.setKeyCode(at.getAprCodigo());
        
        ApproveTransaction at1 = appS.insertarAprobacion(transaction);
        
        return at;
    } 
    public RetiroPublicViewModel insertarRetiro(RetiroPublicViewModel rpvm) throws Exception{
        TransaccionService appS = new TransaccionService();
        Withdraw w = new Withdraw();
        Customer c = new Customer();
        c.setCardNumber(rpvm.getRetUsuario().getUsrNoTarjeta());
        c.setPin(rpvm.getRetUsuario().getUsrNip());
        w.setCantidad(rpvm.getRetMonto());
        w.setCustomer(c);
        
        Withdraw w1 = appS.insertarRetiro(w);
        
        return rpvm;
    }    
}
