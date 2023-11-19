/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.idgs.banco.db.ConexionMySQL;
import org.utl.idgs.banco.model.*;

/**
 *
 * @author iamra
 */
public class TransaccionDao {
    public int insertarSolicitud(TransactionRequest request) throws Exception{
        String query = "call insertarSolicitud(?,?,?,?,?)";
        String keyCode = "";
        int idTransaccion = 0;
        
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        CallableStatement cstmt = conn.prepareCall(query);
        
        cstmt.setInt(1, request.getCustomer().getIdCustomer());
        cstmt.setFloat(2, request.getCantidad());
        cstmt.setString(3, request.getBank());
      
        cstmt.registerOutParameter(4, Types.VARCHAR);
        cstmt.registerOutParameter(5, Types.INTEGER);
        
        cstmt.executeUpdate();
        keyCode = cstmt.getString(4);
        idTransaccion = cstmt.getInt(5);

        request.setKeyCode(keyCode);
        request.setIdTransaction(idTransaccion);
        
        cstmt.close();
        conn.close();
        conexion.close();

        return idTransaccion;
    }    
    
    public int insertarAprobacion(ApproveTransaction approveTransaction) throws Exception{
        String query = "call insertarAprobacion(?,?,?,?)";
        int idTransaccion = 0;
        
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        CallableStatement cstmt = conn.prepareCall(query);
        
        cstmt.setInt(1, approveTransaction.getCustomer().getIdCustomer());
        cstmt.setFloat(2, approveTransaction.getCantidad());
        cstmt.setString(3, approveTransaction.getKeyCode());
      
        cstmt.registerOutParameter(4, Types.INTEGER);
 
        
        cstmt.executeUpdate();
        idTransaccion = cstmt.getInt(4);
        
        approveTransaction.setIdTransaction(idTransaccion);
        
        cstmt.close();
        conn.close();
        conexion.close();

        return idTransaccion;
    }   
    
    public int insertarRetiro(Withdraw withdraw) throws Exception{
        String query = "call insertarRetiro(?,?,?)";
        int idTransaccion = 0;
        
        
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();
        
        CallableStatement cstmt = conn.prepareCall(query);
        
        cstmt.setInt(1, withdraw.getCustomer().getIdCustomer());
        cstmt.setFloat(2, withdraw.getCantidad());
      
        cstmt.registerOutParameter(3, Types.INTEGER);
 
        
        cstmt.executeUpdate();
        idTransaccion = cstmt.getInt(3);
        
        withdraw.setIdWithdraw(idTransaccion);
        
        cstmt.close();
        conn.close();
        conexion.close();

        return idTransaccion;
    }       
}
