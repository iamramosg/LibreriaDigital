/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.banco.model;

/**
 *
 * @author iamra
 * Es el equivalente a usuario
 */
public class Customer {
    private int idCustomer;
    private int cardNumber;
    private String pin;
    private float balance;

    public Customer() {
    }

    public Customer(int cardNumber, String pin, float balance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public Customer(int idCustomer, int cardNumber, String pin, float balance) {
        this.idCustomer = idCustomer;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" + "idCustomer=" + idCustomer + ", cardNumber=" + cardNumber + ", pin=" + pin + ", balance=" + balance + '}';
    }
    
    
}
