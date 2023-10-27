/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.model;

/**
 *
 * @author iamra
 */
public class Universidad {
    private int idUniversidad;
    private String nombre;
    private String pais;
    private int estatus;

    public Universidad() {
    }

    public Universidad(String nombre, String pais, int estatus) {
        this.nombre = nombre;
        this.pais = pais;
        this.estatus = estatus;
    }

    public Universidad(int idUniversidad, String nombre, String pais, int estatus) {
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.pais = pais;
        this.estatus = estatus;
    }

    public int getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(int idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Universidad{" + "idUniversidad=" + idUniversidad + ", nombre=" + nombre + ", pais=" + pais + ", estatus=" + estatus + '}';
    }
    
    
}
