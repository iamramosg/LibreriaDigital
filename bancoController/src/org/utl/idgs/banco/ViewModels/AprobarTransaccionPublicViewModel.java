/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.ViewModels;

/**
 *
 * @author iamra
 */
public class AprobarTransaccionPublicViewModel {
    private int aprId;
    private UsuarioPublicViewModel aprUsuario;
    private float aprMonto;
    private String aprFecha;
    private String aprCodigo; 

    public AprobarTransaccionPublicViewModel() {
    }

    public AprobarTransaccionPublicViewModel(UsuarioPublicViewModel aprUsuario, float aprMonto, String aprFecha, String aprCodigo) {
        this.aprUsuario = aprUsuario;
        this.aprMonto = aprMonto;
        this.aprFecha = aprFecha;
        this.aprCodigo = aprCodigo;
    }
    
    

    public AprobarTransaccionPublicViewModel(int aprId, UsuarioPublicViewModel aprUsuario, float aprMonto, String aprFecha, String aprCodigo) {
        this.aprId = aprId;
        this.aprUsuario = aprUsuario;
        this.aprMonto = aprMonto;
        this.aprFecha = aprFecha;
        this.aprCodigo = aprCodigo;
    }
    
    


    public int getAprId() {
        return aprId;
    }

    public void setAprId(int aprId) {
        this.aprId = aprId;
    }
    

    public float getAprMonto() {
        return aprMonto;
    }

    public void setAprMonto(float aprMonto) {
        this.aprMonto = aprMonto;
    }

    public String getAprFecha() {
        return aprFecha;
    }

    public void setAprFecha(String aprFecha) {
        this.aprFecha = aprFecha;
    }

    public String getAprCodigo() {
        return aprCodigo;
    }

    public void setAprCodigo(String aprCodigo) {
        this.aprCodigo = aprCodigo;
    }

    public UsuarioPublicViewModel getAprUsuario() {
        return aprUsuario;
    }

    public void setAprUsuario(UsuarioPublicViewModel aprUsuario) {
        this.aprUsuario = aprUsuario;
    }
    
    
    
    
}
