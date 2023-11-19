/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.CQRS;
import java.util.List;
import org.utl.idgs.libreria.dao.LibroDao;
import org.utl.idgs.libreria.model.Libro;
/**
 *
 * @author iamra
 */
public class LibroCQRS {
    public Libro insertarLibro(Libro l) throws Exception{
        if(l.getArchivo() == null || l.getArchivo().isEmpty()){
            throw new Exception("Error: Archivo vacio");
        }
        if(l.getAutor()== null || l.getAutor().isEmpty()){
            throw new Exception("Error: Autor vacio");
        }
        if(l.getGenero()== null || l.getGenero().isEmpty()){
            throw new Exception("Error: Genero vacio");
        }
        if(l.getIdioma()== null || l.getIdioma().isEmpty()){
            throw new Exception("Error: Idioma vacio");
        }
        if(l.getTitulo()== null || l.getTitulo().isEmpty()){
            throw new Exception("Error: Título vacio");
        }
        l.setEstatus(1);
        LibroDao dao = new LibroDao();
        int lbrid = dao.insertarLibro(l);
        return l;
    }
    
    public void actualizarLibro(Libro l) throws Exception{
        if(l.getArchivo() == null || l.getArchivo().isEmpty()){
            throw new Exception("Error: Archivo vacio");
        }
        if(l.getAutor()== null || l.getAutor().isEmpty()){
            throw new Exception("Error: Autor vacio");
        }
        if(l.getGenero()== null || l.getGenero().isEmpty()){
            throw new Exception("Error: Genero vacio");
        }
        if(l.getIdioma()== null || l.getIdioma().isEmpty()){
            throw new Exception("Error: Idioma vacio");
        }
        if(l.getTitulo()== null || l.getTitulo().isEmpty()){
            throw new Exception("Error: Título vacio");
        }
        LibroDao dao = new LibroDao();
        dao.actualizarLibro(l);
    }
    
}