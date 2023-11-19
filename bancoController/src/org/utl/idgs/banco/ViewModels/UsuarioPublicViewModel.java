/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.ViewModels;

/**
 *
 * @author iamra
 */
public class UsuarioPublicViewModel {
    private int usrId;
    private int usrNoTarjeta;
    private String usrNip; 
    private float usrSaldo; 

    public UsuarioPublicViewModel(int usrId, int usrNoTarjeta, String usrNip, float usrSaldo) {
        this.usrId = usrId;
        this.usrNoTarjeta = usrNoTarjeta;
        this.usrNip = usrNip;
        this.usrSaldo = usrSaldo;
    }
    
    
}
