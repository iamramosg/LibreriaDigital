/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.model;

/**
 *
 * @author iamra
 */
public class Alumno {
    private int idAlumno;
    private Usuario usuario;
    private String matricula;
    private Universidad universidad;

    public Alumno() {
    }

    public Alumno(Usuario usuario, String matricula, Universidad universidad) {
        this.usuario = usuario;
        this.matricula = matricula;
        this.universidad = universidad;
    }

    public Alumno(int idAlumno, Usuario usuario, String matricula, Universidad universidad) {
        this.idAlumno = idAlumno;
        this.usuario = usuario;
        this.matricula = matricula;
        this.universidad = universidad;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", usuario2=" + usuario + ", matricula=" + matricula + ", universidad=" + universidad + '}';
    }
    
    

   
}
