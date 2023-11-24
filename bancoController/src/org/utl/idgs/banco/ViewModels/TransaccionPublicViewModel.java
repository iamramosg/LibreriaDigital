/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.ViewModels;

/**
 *
 * @author iamra
 */

public class TransaccionPublicViewModel {
    private int transacId;
    private UsuarioPublicViewModel transacUsuario;
    private float transacMonto;
    private String transacFecha;
    private String transacBanco; 
    private String codigo; //Agregue este atributo

    public TransaccionPublicViewModel() {
    }

    public TransaccionPublicViewModel(UsuarioPublicViewModel transacUsuario, float transacMonto, String transacFecha, String transacBanco, String codigo) {
        this.transacUsuario = transacUsuario;
        this.transacMonto = transacMonto;
        this.transacFecha = transacFecha;
        this.transacBanco = transacBanco;
        this.codigo = codigo;
    }

    public TransaccionPublicViewModel(int transacId, UsuarioPublicViewModel transacUsuario, float transacMonto, String transacFecha, String transacBanco, String codigo) {
        this.transacId = transacId;
        this.transacUsuario = transacUsuario;
        this.transacMonto = transacMonto;
        this.transacFecha = transacFecha;
        this.transacBanco = transacBanco;
        this.codigo = codigo;
    }
    
    
    

    public int getTransacId() {
        return transacId;
    }

    public void setTransacId(int transacId) {
        this.transacId = transacId;
    }

    

    public float getTransacMonto() {
        return transacMonto;
    }

    public void setTransacMonto(float transacMonto) {
        this.transacMonto = transacMonto;
    }

    public String getTransacFecha() {
        return transacFecha;
    }

    public void setTransacFecha(String transacFecha) {
        this.transacFecha = transacFecha;
    }

    public String getTransacBanco() {
        return transacBanco;
    }

    public void setTransacBanco(String transacBanco) {
        this.transacBanco = transacBanco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public UsuarioPublicViewModel getTransacUsuario() {
        return transacUsuario;
    }

    public void setTransacUsuario(UsuarioPublicViewModel transacUsuario) {
        this.transacUsuario = transacUsuario;
    }
    
    


    
    
    
    
    
    
}
