/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.CQRS;
import org.utl.idgs.banco.dao.TransaccionDao;
import org.utl.idgs.banco.model.*;

/**
 *
 * @author iamra
 */
public class TransaccionCQRS {
    public TransactionRequest insertarSolicitud(TransactionRequest tr) throws Exception{
        if(tr.getCustomer().getIdCustomer()== 0 ){
            throw new Exception("Error: Usuario no encontrado");
        }
        if(tr.getCantidad() <= 0){
            throw new Exception("Error: Cantidad Incorrecta");
        }      
        if(tr.getBank()== null || tr.getBank().isEmpty()){
            throw new Exception("Error: Banco no encontrado");
        }      
        TransaccionDao td = new TransaccionDao();
        int tdId = td.insertarSolicitud(tr);
        return tr;
    }
    
    public ApproveTransaction insertarAprobacion(ApproveTransaction at) throws Exception{
        if(at.getCustomer().getIdCustomer()== 0 ){
            throw new Exception("Error: Usuario no encontrado");
        }
        if(at.getCantidad() <= 0){
            throw new Exception("Error: Cantidad Incorrecta");
        }      
        if(at.getKeyCode()== null || at.getKeyCode().isEmpty()){
            throw new Exception("Error: Codigo Incorrecto");
        }      
        TransaccionDao td = new TransaccionDao();
        int atId = td.insertarAprobacion(at);
        return at;
    } 
    
    public Withdraw insertarRetiro(Withdraw w) throws Exception{
        if(w.getCustomer().getIdCustomer()== 0 ){
            throw new Exception("Error: Usuario no encontrado");
        }
        if(w.getCantidad() <= 0){
            throw new Exception("Error: Cantidad Incorrecta");
        }      
        TransaccionDao td = new TransaccionDao();
        int wId = td.insertarRetiro(w);
        return w;
    }    
    
}
