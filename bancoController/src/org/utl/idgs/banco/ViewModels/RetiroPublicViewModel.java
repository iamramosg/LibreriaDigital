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
    private int retUsuario;
    private float retMonto;
    private String retFecha;    

    public RetiroPublicViewModel(int retId, int retUsuario, float retMonto, String retFecha) {
        this.retId = retId;
        this.retUsuario = retUsuario;
        this.retMonto = retMonto;
        this.retFecha = retFecha;
    }
    
    
}
