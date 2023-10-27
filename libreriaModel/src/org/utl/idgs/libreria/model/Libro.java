/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.model;

/**
 *
 * @author iamra
 */
public class Libro {
    private int idLibro;
    private String titulo;
    private String archivo;
    private String autor;
    private String idioma;
    private String genero;
    private int estatus;

    public Libro() {
    }

    public Libro(String titulo, String archivo, String autor, String idioma, String genero, int estatus) {
        this.titulo = titulo;
        this.archivo = archivo;
        this.autor = autor;
        this.idioma = idioma;
        this.genero = genero;
        this.estatus = estatus;
    }

    public Libro(int idLibro, String titulo, String archivo, String autor, String idioma, String genero, int estatus) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.archivo = archivo;
        this.autor = autor;
        this.idioma = idioma;
        this.genero = genero;
        this.estatus = estatus;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", archivo=" + archivo + ", autor=" + autor + ", idioma=" + idioma + ", genero=" + genero + ", estatus=" + estatus + '}';
    }
    
    
    
    
}
