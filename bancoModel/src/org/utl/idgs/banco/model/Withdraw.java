/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.model;

/**
 *
 * @author iamra
 * Es el equivalente a retiro
 */
public class Withdraw {
    private int idWithdraw;
    private Customer customer;
    private float cantidad;
    private String transactionDate;

    public Withdraw() {
    }

    public Withdraw(Customer customer, float cantidad, String transactionDate) {
        this.customer = customer;
        this.cantidad = cantidad;
        this.transactionDate = transactionDate;
    }

    public Withdraw(int idWithdraw, Customer customer, float cantidad, String transactionDate) {
        this.idWithdraw = idWithdraw;
        this.customer = customer;
        this.cantidad = cantidad;
        this.transactionDate = transactionDate;
    }

    public int getIdWithdraw() {
        return idWithdraw;
    }

    public void setIdWithdraw(int idWithdraw) {
        this.idWithdraw = idWithdraw;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Withdraw{" + "idWithdraw=" + idWithdraw + ", customer=" + customer + ", cantidad=" + cantidad + ", transactionDate=" + transactionDate + '}';
    }
    
    
}
