/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.model;

/**
 *
 * @author iamra
 * Es el equivalente a aprobar transaccion
 */
public class ApproveTransaction {
    private int idTransaction;
    private Customer customer;
    private float cantidad;
    private String transactionDate;
    private String keyCode;

    public ApproveTransaction() {
    }

    public ApproveTransaction(Customer customer, float cantidad, String transactionDate, String keyCode) {
        this.customer = customer;
        this.cantidad = cantidad;
        this.transactionDate = transactionDate;
        this.keyCode = keyCode;
    }

    public ApproveTransaction(int idTransaction, Customer customer, float cantidad, String transactionDate, String keyCode) {
        this.idTransaction = idTransaction;
        this.customer = customer;
        this.cantidad = cantidad;
        this.transactionDate = transactionDate;
        this.keyCode = keyCode;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
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

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public String toString() {
        return "ApproveTransaction{" + "idTransaction=" + idTransaction + ", customer=" + customer + ", cantidad=" + cantidad + ", transactionDate=" + transactionDate + ", keyCode=" + keyCode + '}';
    }
    
    
}
