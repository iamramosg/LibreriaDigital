/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.ViewModels;

/**
 *
 * @author iamra
 */
import org.utl.idgs.banco.model.Customer;
public class TransaccionPublicViewModel {
    private int transacId;
    private int transacUsuario;
    private float transacMonto;
    private String transacFecha;
    private String transacBanco; 
    private String transKeyCode; //Agregue este atributo

    public TransaccionPublicViewModel(int transacId, int transacUsuario, float transacMonto, String transacFecha, String transacBanco, String transKeyCode) {
        this.transacId = transacId;
        this.transacUsuario = transacUsuario;
        this.transacMonto = transacMonto;
        this.transacFecha = transacFecha;
        this.transacBanco = transacBanco;
        this.transKeyCode = transKeyCode;
    }
    
    
    
    
}
