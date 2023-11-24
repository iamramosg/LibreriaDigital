/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.ViewModels;

/**
 *
 * @author iamra
 */
public class CajeroPublicViewModel {
    private int caId;
    private float caSaldo; 

    public CajeroPublicViewModel(int caId, float caSaldo) {
        this.caId = caId;
        this.caSaldo = caSaldo;
    }

    public CajeroPublicViewModel() {
    }

    public CajeroPublicViewModel(float caSaldo) {
        this.caSaldo = caSaldo;
    }

    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    public float getCaSaldo() {
        return caSaldo;
    }

    public void setCaSaldo(float caSaldo) {
        this.caSaldo = caSaldo;
    }
    
    
    
    
}
