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
public class UsuarioDao {
    public Customer buscarUsuario(Customer c) throws SQLException{
        String query = "SELECT * FROM customer WHERE cardNumber = '" + c.getCardNumber() + "'";
        
        ConexionMySQL objConexion = new ConexionMySQL();
        // Abro la conexion
        Connection conn = objConexion.open();
        // Preparo el envio
        PreparedStatement pstmt = conn.prepareStatement(query);
        // nos devuelve la informacion
        ResultSet rs = pstmt.executeQuery(); 
        Customer customer = new Customer();
        if(rs.next()){
            customer.setIdCustomer(rs.getInt("idCustomer"));
            customer.setCardNumber(rs.getInt("cardNumber"));
            customer.setBalance(rs.getFloat("balance"));
            customer.setPin(rs.getString("pin"));

            return customer;
 
        }
        rs.close();
        pstmt.close();
        conn.close();
        return null;          
    }
}
