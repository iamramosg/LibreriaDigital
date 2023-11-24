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
public class AtmDao {
    public Atm buscarCajero() throws SQLException{
        String query = "SELECT * FROM ATM WHERE idATM = 1";
        
        ConexionMySQL objConexion = new ConexionMySQL();
        // Abro la conexion
        Connection conn = objConexion.open();
        // Preparo el envio
        PreparedStatement pstmt = conn.prepareStatement(query);
        // nos devuelve la informacion
        ResultSet rs = pstmt.executeQuery(); 
        Atm a = new Atm();
        if(rs.next()){
            a.setIdATM(rs.getInt("idATM"));
            a.setSaldoDisponible(rs.getFloat("saldoDisponible"));
            return a;
 
        }
        rs.close();
        pstmt.close();
        conn.close();
        return null;          
    }    
}
