/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.model;

/**
 *
 * @author iamra
 * Equivalente a cajero
 */
public class Atm {
    private int idATM;
    private float saldoDisponible;

    public Atm() {
    }

    public Atm(float saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public Atm(int idATM, float saldoDisponible) {
        this.idATM = idATM;
        this.saldoDisponible = saldoDisponible;
    }

    public int getIdATM() {
        return idATM;
    }

    public void setIdATM(int idATM) {
        this.idATM = idATM;
    }

    public float getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(float saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public String toString() {
        return "Atm{" + "idATM=" + idATM + ", saldoDisponible=" + saldoDisponible + '}';
    }
    
    
}
