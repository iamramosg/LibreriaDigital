/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.idgs.banco.db.ConexionMySQL;
import org.utl.idgs.banco.model.*;
import org.utl.idgs.banco.dao.TransaccionDao;
import org.utl.idgs.banco.AppService.TransaccionService;
import org.utl.idgs.banco.ViewModels.RetiroPublicViewModel;
import org.utl.idgs.banco.dao.AtmDao;
import org.utl.idgs.banco.ViewModels.*;

/**
 *
 * @author iamra
 */
public class Prueba {

    public static void main(String[] args) {
        //probarConexion();
        probarInsertarSolicitud();
        //probarInsertarAprobacion();
        //probarInsertarRetiro();
        //buscar();
        //buscarAtm();

    }

    public static void probarConexion() {
        try {
            ConexionMySQL objConexion = new ConexionMySQL();
            Connection conexion = objConexion.open();
            System.out.println(conexion.toString());
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void buscar() {
        TransaccionService service = new TransaccionService();
        Customer  c = new Customer();
        c.setCardNumber(1103);
        c.setPin("1111");
        try {
            //cq.insertar(u);
            c = service.buscarUsuario(c);
            System.out.println(c.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }    
    public static void buscarAtm() {
        Atm a = new Atm();
        AtmDao dao = new AtmDao();
        try {
            //cq.insertar(u);
            a = dao.buscarCajero();
            a.getSaldoDisponible();
            System.out.println( a.getSaldoDisponible());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }    

    public static void probarInsertarSolicitud() {
        TransaccionPublicViewModel t = new TransaccionPublicViewModel();
        ControllerTransaccion ct = new ControllerTransaccion();
        UsuarioPublicViewModel c = new UsuarioPublicViewModel();
        c.setUsrNoTarjeta(1103);
        c.setUsrNip("1111");
        t.setTransacBanco("Bank of America");
        t.setTransacUsuario(c);
        t.setTransacMonto(80);
        try {
            ct.insertarSolicitud(t);
            System.out.println(t.getCodigo());
            System.out.println("Transacción exitosa");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }    
//    public static void probarInsertarAprobacion() {
//        ApproveTransaction at = new ApproveTransaction();
//        Customer c = new Customer();
//        c.setCardNumber(1200);
//        
//        at.setCustomer(c); // Inicializar la propiedad customer
//        at.setCantidad(8000);
//        at.setKeyCode("00189");
//
//        ControllerTransaccion td = new ControllerTransaccion();
//        try {
//            //cq.insertar(u);
//            td.insertarAprobacion(at);
//            System.out.println("Transaccion Coorecta");
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//    } 
    public static void probarInsertarRetiro() {
        Withdraw w = new Withdraw();
        Customer c = new Customer();
        c.setCardNumber(1103);
        c.setPin("1111");

        
        w.setCustomer(c); // Inicializar la propiedad customer
        w.setCantidad(800);

        ControllerTransaccion ct = new ControllerTransaccion();
        try {
            //cq.insertar(u);
            //ct.insertarRetiro(w);
            System.out.println("Transaccion Coorecta");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }      
}
