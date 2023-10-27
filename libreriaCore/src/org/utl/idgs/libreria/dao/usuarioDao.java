package org.utl.idgs.libreria.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.idgs.libreria.db.ConexionMySQL;
import org.utl.idgs.libreria.model.Alumno;
import org.utl.idgs.libreria.model.Universidad;
import org.utl.idgs.libreria.model.Usuario;

/**
 *
 * @author iamra
 */
public class usuarioDao {

    //Metodo para buscar un usuario por correo 
    public Usuario getByCorreo(Usuario u) throws SQLException, ContraseñaIncorrectaException {
        String query = "SELECT * FROM usuario WHERE correo = '" + u.getCorreo() + "' AND contrasenia = '" + u.getContrasenia() + "'";
        String contraseña = u.getContrasenia();

        ConexionMySQL objConexion = new ConexionMySQL();
        // Abro la conexion
        Connection conn = objConexion.open();
        // Preparo el envio
        PreparedStatement pstmt = conn.prepareStatement(query);
        //Declaramos la lista
        List<Usuario> usuarios = new ArrayList<>();
        // nos devuelve la informacion
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombre(rs.getString("nombre"));
            u.setApellidoP(rs.getString("apellidoP"));
            u.setApellidoM(rs.getString("apellidoM"));
            u.setGenero(rs.getString("genero"));
            u.setCorreo(rs.getString("correo"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));
            u.setEstatus(rs.getInt("estatus"));

            usuarios.add(u);

        }
        rs.close();
        pstmt.close();
        conn.close();

        // Verificar la contraseña
        for (Usuario usuarioEncontrado : usuarios) {
            if (contraseña.equals(usuarioEncontrado.getContrasenia())) {
                return usuarioEncontrado;
            }
        }
         throw new ContraseñaIncorrectaException("Contraseña Incorrecta");
    }

    public int insertarCliente(Usuario usuario) throws Exception {
        String query = "call insertarCliente(?,?,?,?,?,?,?,?,?)";
        int idUsuario = 0;

        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();

        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setString(1, usuario.getNombre());
        cstmt.setString(2, usuario.getApellidoP());
        cstmt.setString(3, usuario.getApellidoM());
        cstmt.setString(4, usuario.getGenero());
        cstmt.setString(5, usuario.getCorreo());
        cstmt.setString(6, usuario.getContrasenia());
        cstmt.setString(7, usuario.getRol());
        cstmt.setInt(8, usuario.getEstatus());

        cstmt.registerOutParameter(9, Types.INTEGER);

        cstmt.executeUpdate();
        idUsuario = cstmt.getInt(9);

        usuario.setIdUsuario(idUsuario);

        cstmt.close();
        conn.close();
        conexion.close();

        return idUsuario;
    }

    public class ContraseñaIncorrectaException extends Exception {

        public ContraseñaIncorrectaException(String message) {
            super(message);
        }
    }
    
    //metodo para actualizar el usuario todos los campos 
    public void actualizarUsuario(Usuario usuario) throws Exception{
        String query = "call actualizarAlumno(?,?,?,?,?,?)";
        ConexionMySQL conexion = new ConexionMySQL();
        Connection conn = conexion.open();     
        
        CallableStatement cstmt = conn.prepareCall(query);
        
        cstmt.setString(1, usuario.getNombre());
        cstmt.setString(2, usuario.getApellidoP());
        cstmt.setString(3, usuario.getApellidoM());
        cstmt.setString(4, usuario.getGenero());
        cstmt.setString(5, usuario.getContrasenia());
        cstmt.setInt(6, usuario.getIdUsuario());
        cstmt.executeUpdate();
        
        cstmt.close();
        conn.close();
        conexion.close();         
    }    
}
