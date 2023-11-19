/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.controller;

/**
 *
 * @author iamra
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.idgs.libreria.db.ConexionMySQL;
import org.utl.idgs.libreria.model.Libro;
import org.utl.idgs.libreria.dao.LibroDao;
import org.utl.idgs.libreria.AppService.LibroAppService;
import org.utl.idgs.libreria.ViewModels.LibroPublicViewModel;

/**
 *
 * @author garni
 */
public class ControllerLibro {

    public Libro insertarLibro(Libro l) throws Exception {
        LibroAppService appS = new LibroAppService();
        Libro lbr = appS.registroLibro(l);

        return lbr;
    }

    public void actualizar(Libro libro) throws Exception {
        String query = "call actualizarLibro(?,?,?,?,?,?,?)";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setString(1, libro.getTitulo());
        cstmt.setString(2, libro.getArchivo());
        cstmt.setString(3, libro.getAutor());
        cstmt.setString(4, libro.getIdioma());
        cstmt.setString(5, libro.getGenero());
        cstmt.setInt(6, libro.getEstatus());
        cstmt.setInt(7, libro.getIdLibro());
        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        conexion.close();
    }

    public void eliminar(String libro) throws Exception {
        String query = "call eliminarLibro(?)";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        //Paso 3: Generar un objeto que permita preparar la llamada al procedure
        PreparedStatement cstmt = conn.prepareCall(query);
        cstmt.setInt(1, Integer.parseInt(libro));
        cstmt.executeUpdate();
        cstmt.close();
        conn.close();
        conexion.close();
    }

    public List<Libro> getAll() throws SQLException {
        String query = "SELECT * FROM vista_L WHERE idLibro = '+universidad_libro_id+';";
        ConexionMySQL objConexion = new ConexionMySQL();
        Connection conn = objConexion.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        List<Libro> libros = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Libro libro = new Libro();

            libro.setIdLibro(rs.getInt("No_Libro"));
            libro.setTitulo(rs.getString("Titulo"));
            libro.setArchivo(rs.getString("Archivo"));
            libro.setAutor(rs.getString("Autor"));
            libro.setIdioma(rs.getString("Idioma"));
            libro.setGenero(rs.getString("Genero"));
            libro.setEstatus(rs.getInt("Estatus"));
            libros.add(libro);
        }
        rs.close();
        pstmt.close();
        conn.close();

        return libros;
    }

//    public List<Libro> buscarLibro(String buscar) throws SQLException{
//        String query = "SELECT * FROM vista_L WHERE Titulo LIKE '%"+buscar+"%'";
//        
//        ConexionMySQL objConexion = new ConexionMySQL();
//        Connection conn = objConexion.open();
//        PreparedStatement pstmt = conn.prepareStatement(query);
//        List<Libro> libros = new ArrayList<>();
//        ResultSet rs = pstmt.executeQuery();
//        while (rs.next()){
//            Libro l = new Libro();
//            
//            l.setIdLibro(rs.getInt("No_Libro"));
//            l.setTitulo(rs.getString("Titulo"));
//            l.setAutor(rs.getString("Autor"));
//            l.setIdioma(rs.getString("Idioma"));
//            l.setGenero(rs.getString("Genero"));
//            l.setEstatus(rs.getInt("Estatus"));
//            l.setArchivo(rs.getString("Archivo"));
//            
//            
//            libros.add(l);
//        }
//        rs.close();
//        pstmt.close();
//        conn.close();
//        
//        return libros;
//    }
    public List<Libro> buscarLibro(Libro l) throws Exception {
        LibroAppService appS = new LibroAppService();
        List<Libro> lbr = appS.buscarLibro(l);

        return lbr;
    }

    public List<LibroPublicViewModel> buscarLibroPublic(Libro l) throws Exception {
        LibroAppService appS = new LibroAppService();
        List<LibroPublicViewModel> lbr = appS.buscarLibroPublic(l);

        return lbr;
    }

    public List<Libro> getAllLibro() throws Exception {
        LibroAppService appS = new LibroAppService();
        List<Libro> lbr = appS.getAllLibro();

        return lbr;
    }

    public List<LibroPublicViewModel> getAllLibroPublic() throws Exception {
        LibroAppService appS = new LibroAppService();
        List<LibroPublicViewModel> lbr = appS.getAllLibroPublic();

        return lbr;
    }

}
