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
    private int aprUsuario;
    private float aprMonto;
    private String aprFecha;
    private String aprCodigo; 

    public AprobarTransaccionPublicViewModel(int aprId, int aprUsuario, float aprMonto, String aprFecha, String aprCodigo) {
        this.aprId = aprId;
        this.aprUsuario = aprUsuario;
        this.aprMonto = aprMonto;
        this.aprFecha = aprFecha;
        this.aprCodigo = aprCodigo;
    }
    
    
}
