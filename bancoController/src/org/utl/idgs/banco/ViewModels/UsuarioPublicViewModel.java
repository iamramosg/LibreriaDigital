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

    public UsuarioPublicViewModel() {
    }

    public UsuarioPublicViewModel(int usrNoTarjeta, String usrNip, float usrSaldo) {
        this.usrNoTarjeta = usrNoTarjeta;
        this.usrNip = usrNip;
        this.usrSaldo = usrSaldo;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getUsrNoTarjeta() {
        return usrNoTarjeta;
    }

    public void setUsrNoTarjeta(int usrNoTarjeta) {
        this.usrNoTarjeta = usrNoTarjeta;
    }

    public String getUsrNip() {
        return usrNip;
    }

    public void setUsrNip(String usrNip) {
        this.usrNip = usrNip;
    }

    public float getUsrSaldo() {
        return usrSaldo;
    }

    public void setUsrSaldo(float usrSaldo) {
        this.usrSaldo = usrSaldo;
    }
    
    
    
    
}
