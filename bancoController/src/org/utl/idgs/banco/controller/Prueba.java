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

/**
 *
 * @author iamra
 */
public class Prueba {

    public static void main(String[] args) {
        //probarConexion();
        //probarInsertarSolicitud();
        //probarInsertarAprobacion();
        probarInsertarRetiro();

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

    public static void probarInsertarSolicitud() {
        TransactionRequest tr = new TransactionRequest();
        Customer c = new Customer();
        c.setIdCustomer(1);
        
        tr.setCustomer(c); // Inicializar la propiedad customer
        tr.getCustomer().getIdCustomer();
        tr.setCantidad(100);
        tr.setBank("BBVA");

        TransaccionDao td = new TransaccionDao();
        try {
            //cq.insertar(u);
            td.insertarSolicitud(tr);
            System.out.println("Transaccion Coorecta");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static void probarInsertarAprobacion() {
        ApproveTransaction at = new ApproveTransaction();
        Customer c = new Customer();
        c.setIdCustomer(1);
        
        at.setCustomer(c); // Inicializar la propiedad customer
        at.setCantidad(50);
        at.setKeyCode("00189");

        TransaccionDao td = new TransaccionDao();
        try {
            //cq.insertar(u);
            td.insertarAprobacion(at);
            System.out.println("Transaccion Coorecta");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    } 
    public static void probarInsertarRetiro() {
        Withdraw w = new Withdraw();
        Customer c = new Customer();
        c.setIdCustomer(1);
        
        w.setCustomer(c); // Inicializar la propiedad customer
        w.setCantidad(80);

        TransaccionDao td = new TransaccionDao();
        try {
            //cq.insertar(u);
            td.insertarRetiro(w);
            System.out.println("Transaccion Coorecta");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }      
}
