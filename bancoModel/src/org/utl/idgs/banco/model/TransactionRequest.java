/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.model;

/**
 *
 * @author iamra
 * Es el equivalente a solicitudTransaccion
 */
public class TransactionRequest {
    private int idTransaction;
    private Customer customer;
    private float cantidad;
    private String transactionDate;
    private String bank;
    private String keyCode;

    public TransactionRequest() {
    }

    public TransactionRequest(Customer customer, float cantidad, String transactionDate, String bank, String keyCode) {
        this.customer = customer;
        this.cantidad = cantidad;
        this.transactionDate = transactionDate;
        this.bank = bank;
        this.keyCode = keyCode;
    }

    public TransactionRequest(int idTransaction, Customer customer, float cantidad, String transactionDate, String bank, String keyCode) {
        this.idTransaction = idTransaction;
        this.customer = customer;
        this.cantidad = cantidad;
        this.transactionDate = transactionDate;
        this.bank = bank;
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" + "idTransaction=" + idTransaction + ", customer=" + customer + ", cantidad=" + cantidad + ", transactionDate=" + transactionDate + ", bank=" + bank + '}';
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }
    
    
}
