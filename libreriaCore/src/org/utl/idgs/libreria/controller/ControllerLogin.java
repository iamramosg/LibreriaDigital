/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.controller;

import org.utl.idgs.libreria.db.ConexionMySQL;
import org.utl.idgs.libreria.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.utl.idgs.libreria.model.Alumno;
import org.utl.idgs.libreria.model.Universidad;
import org.utl.idgs.libreria.dao.usuarioDao;
import org.utl.idgs.libreria.CQRS.UsuarioCQRS;
import org.utl.idgs.libreria.dao.usuarioDao.ContraseñaIncorrectaException;
import org.utl.idgs.libreria.AppService.UsuariosAppService;

/**
 *
 * @author garni
 */
public class ControllerLogin {

    public Usuario entrarUsuario(Usuario u) throws Exception {
        String query = "SELECT * FROM usuario WHERE correo = '" + u.getCorreo() + "' AND contrasenia = '" + u.getContrasenia() + "'";

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        u = new Usuario();
        if (rs.next()) {
            u = fillU(rs);
        }
        rs.close();
        stmt.close();
        conn.close();
        conexion.close();
        System.out.println(query);
        return u;
    }

    public Usuario fillU(ResultSet rs) throws Exception {
        Usuario u = new Usuario();
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNombre(rs.getString("nombre"));
        u.setApellidoP(rs.getString("apellidoP"));
        u.setApellidoM(rs.getString("apellidoM"));
        u.setGenero(rs.getString("genero"));
        u.setCorreo(rs.getString("correo"));
        u.setContrasenia(rs.getString("contrasenia"));
        u.setRol(rs.getString("rol"));
        u.setEstatus(rs.getInt("estatus"));

        return u;
    }

    public Alumno entrarAlumno(Usuario u) throws Exception {
        String query = "SELECT * FROM vista_a WHERE correo = '" + u.getCorreo() + "' AND contrasenia = '" + u.getContrasenia() + "'";

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        Alumno a = new Alumno();
        if (rs.next()) {
            a = fillA(rs);
        }
        rs.close();
        stmt.close();
        conn.close();
        conexion.close();
        System.out.println(query);
        return a;
    }

    public Alumno fillA(ResultSet rs) throws Exception {
        Usuario u = new Usuario();
        Alumno a = new Alumno();
        Universidad un = new Universidad();
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNombre(rs.getString("nombre"));
        u.setApellidoP(rs.getString("apellidoP"));
        u.setApellidoM(rs.getString("apellidoM"));
        u.setGenero(rs.getString("genero"));
        u.setCorreo(rs.getString("correo"));
        u.setContrasenia(rs.getString("contrasenia"));
        u.setRol(rs.getString("rol"));
        u.setEstatus(rs.getInt("estatus"));

        un.setIdUniversidad(rs.getInt("idUniversidad"));
        un.setNombre(rs.getString("nombreU"));
        un.setPais(rs.getString("pais"));
        un.setEstatus(rs.getInt("estatusU"));

        a.setIdAlumno(rs.getInt("idAlumno"));
        a.setUsuario(u);
        a.setMatricula(rs.getString("matricula"));
        a.setUniversidad(un);

        return a;
    }

    public void guardarToken(Usuario usuario) throws SQLException {
        String query = "UPDATE usuario SET lastToken=?,dateLastToken=NOW() WHERE idUsuario=?";

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        PreparedStatement pstmt = conn.prepareCall(query);

        pstmt.setString(1, usuario.getLastToken());
        pstmt.setInt(2, usuario.getIdUsuario());

        pstmt.execute();

        pstmt.close();
        conn.close();
        conexion.close();
    }

    public boolean eliminarToken(Usuario u) throws Exception {
        boolean r = false;
        String query = "UPDATE usuario SET lastToken='' WHERE idUsuario=?";

        ConexionMySQL conexionMySQL = new ConexionMySQL();

        Connection connection = conexionMySQL.open();

        PreparedStatement pstmt = connection.prepareCall(query);

        pstmt.setInt(1, u.getIdUsuario());

        pstmt.execute();
        r = true;

        pstmt.close();
        connection.close();
        conexionMySQL.close();

        return r;
    }

    public boolean validarToken(String t) throws Exception {
        boolean r = false;
        String query = "SELECT * FROM usuario WHERE lastToken='" + t + "'";
        ConexionMySQL conexionMySQL = new ConexionMySQL();
        Connection connection = conexionMySQL.open();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            r = true;
        }

        stmt.close();
        connection.close();
        conexionMySQL.close();

        return r;
    }

    public Usuario entrarAdministrdor(Usuario u) throws Exception {
        // Validar que el correo no esté vacío
        if (u.getCorreo() == null || u.getCorreo().isEmpty()) {
            throw new Exception("Error: El correo esta vacio");
        }
        // Validar que la contraseña no esté vacía
        if (u.getContrasenia() == null || u.getContrasenia().isEmpty()) {
            throw new Exception("Error: La contraseña esta vacia");
        }

        usuarioDao dao = new usuarioDao();
        Usuario usr;
        try {
            usr = dao.getByCorreo(u);
        } catch (ContraseñaIncorrectaException e) {
            throw new Exception("Error: Contraseña incorrecta");
        } catch (SQLException e) {
            throw new Exception("Error: Usuario no encontrado");
        }

        if (usr.getEstatus() == 0) {
            throw new Exception("Error: Usuario inactivo");
        }

        if (!usr.getRol().equals("Administrador")) {
            throw new Exception("Error: El usuario no es administrador");
        }

        return usr;
    }

    public Usuario entrarVendedor(Usuario u) throws Exception {
        // Validar que el correo no esté vacío
        if (u.getCorreo() == null || u.getCorreo().isEmpty()) {
            throw new Exception("Error: El correo esta vacio");
        }
        // Validar que la contraseña no esté vacía
        if (u.getContrasenia() == null || u.getContrasenia().isEmpty()) {
            throw new Exception("Error: La contraseña esta vacia");
        }

        usuarioDao dao = new usuarioDao();
        Usuario usr;
        try {
            usr = dao.getByCorreo(u);
        } catch (ContraseñaIncorrectaException e) {
            throw new Exception("Error: Contraseña incorrecta");
        } catch (SQLException e) {
            throw new Exception("Error: Usuario no encontrado");
        }

        if (usr.getEstatus() == 0) {
            throw new Exception("Error: Usuario inactivo");
        }

        if (!usr.getRol().equals("Vendedor")) {
            throw new Exception("Error: El usuario no es vendedor");
        }

        return usr;
    }

    public Usuario entrarCliente(Usuario u) throws Exception {
        // Validar que el correo no esté vacío
        if (u.getCorreo() == null || u.getCorreo().isEmpty()) {
            throw new Exception("Error: El correo esta vacio");
        }
        // Validar que la contraseña no esté vacía
        if (u.getContrasenia() == null || u.getContrasenia().isEmpty()) {
            throw new Exception("Error: La contraseña esta vacia");
        }
        
        usuarioDao dao = new usuarioDao();
        Usuario usr;
        try {
            usr = dao.getByCorreo(u);
        } catch (ContraseñaIncorrectaException e) {
            throw new Exception("Error: Contraseña incorrecta");
        } catch (SQLException e) {
            throw new Exception("Error: Usuario no encontrado");
        }

        if (usr.getEstatus() == 0) {
            throw new Exception("Error: Usuario inactivo");
        }

        if (!usr.getRol().equals("Cliente")) {
            throw new Exception("Error: El usuario no es cliente");
        }

        return usr;
    }

    public Usuario insertarCliente(Usuario u) throws Exception {
        //llamar appService
        //UsuarioCQRS dao = new UsuarioCQRS();
        UsuariosAppService uas = new UsuariosAppService();
        Usuario usr = uas.registroCliente(u);

        return usr;
    }
}
