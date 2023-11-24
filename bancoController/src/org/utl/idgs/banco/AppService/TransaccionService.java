/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.AppService;
import org.utl.idgs.banco.CQRS.TransaccionCQRS;
import org.utl.idgs.banco.model.*;
import org.utl.idgs.banco.dao.*;
/**
 *
 * @author iamra
 */
public class TransaccionService {
    public Customer buscarUsuario(Customer c) throws Exception{
        UsuarioDao dao = new UsuarioDao();
        Customer usr = dao.buscarUsuario(c);
        if(!usr.getPin().equals(c.getPin())){
            throw new Exception("Error: PIN incorrecto");
        }      
        return usr;        
    }
    public Atm consultarSaldo() throws Exception{
        AtmDao dao = new AtmDao();
        Atm a = dao.buscarCajero();
        return a;        
    }    
    
    public TransactionRequest insertarSolicitud(TransactionRequest tr) throws Exception{
        Customer c = new Customer();
        c = buscarUsuario(tr.getCustomer());  
        if(tr.getCantidad()>c.getBalance()){
            throw new Exception("Error: Cantidad Insuficiente");
        }
        tr.getCustomer().setIdCustomer(c.getIdCustomer());        
        
        TransaccionCQRS cqrs = new TransaccionCQRS();
        TransactionRequest tr1 = cqrs.insertarSolicitud(tr);
        
        if (tr == null) {
            throw new Exception("Error al insertar la transaccion");
        } 
        return tr1;
    }
    public ApproveTransaction insertarAprobacion(ApproveTransaction at) throws Exception{
        Atm a = new Atm();
        a = consultarSaldo();
        if(a.getSaldoDisponible()<at.getCantidad()){
            throw new Exception("Error cantidad insuficiente cajero");
        }
        TransaccionCQRS cqrs = new TransaccionCQRS();
        ApproveTransaction at1 = cqrs.insertarAprobacion(at);
        if (at == null) {
            throw new Exception("Error al insertar la transaccion");
        } 
        return at1;
    }    
    public Withdraw insertarRetiro(Withdraw w) throws Exception{
        Customer c = new Customer();
        Atm a = new Atm();
        c = buscarUsuario(w.getCustomer());
        if(w.getCantidad()>c.getBalance()){
            throw new Exception("Error: Cantidad Insuficiente");
        }        
        w.getCustomer().setIdCustomer(c.getIdCustomer());
        a = consultarSaldo();
        if(a.getSaldoDisponible()<w.getCantidad()){
            throw new Exception("Error cantidad insuficiente cajero");
        }
        TransaccionCQRS cqrs = new TransaccionCQRS();
        Withdraw w1 = cqrs.insertarRetiro(w);
        if (w == null) {
            throw new Exception("Error al insertar la transaccion");
        } 
        return w1;
    }      
}
