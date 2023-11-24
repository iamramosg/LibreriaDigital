/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.ViewModels;

/**
 *
 * @author iamra
 */
public class RetiroPublicViewModel {
    private int retId;
    private UsuarioPublicViewModel retUsuario;
    private float retMonto;
    private String retFecha;    

    public RetiroPublicViewModel() {
    }

    public RetiroPublicViewModel(UsuarioPublicViewModel retUsuario, float retMonto, String retFecha) {
        this.retUsuario = retUsuario;
        this.retMonto = retMonto;
        this.retFecha = retFecha;
    }

    public RetiroPublicViewModel(int retId, UsuarioPublicViewModel retUsuario, float retMonto, String retFecha) {
        this.retId = retId;
        this.retUsuario = retUsuario;
        this.retMonto = retMonto;
        this.retFecha = retFecha;
    }

    public int getRetId() {
        return retId;
    }

    public void setRetId(int retId) {
        this.retId = retId;
    }

    public UsuarioPublicViewModel getRetUsuario() {
        return retUsuario;
    }

    public void setRetUsuario(UsuarioPublicViewModel retUsuario) {
        this.retUsuario = retUsuario;
    }

    public float getRetMonto() {
        return retMonto;
    }

    public void setRetMonto(float retMonto) {
        this.retMonto = retMonto;
    }

    public String getRetFecha() {
        return retFecha;
    }

    public void setRetFecha(String retFecha) {
        this.retFecha = retFecha;
    }

    
    
    
}
