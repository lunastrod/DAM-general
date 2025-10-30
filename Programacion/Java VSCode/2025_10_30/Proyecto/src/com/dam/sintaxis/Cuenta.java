package com.dam.sintaxis;

public class Cuenta {
    protected int numeroCuenta;
    protected double saldo;

    public Cuenta(int cuenta, double inicial) {
        numeroCuenta = cuenta;
        saldo = inicial;
    }

    public void depositar(double cantidad) {
        saldo = saldo + cantidad;
    }

    public double saldo() {
        return saldo;
    }
}

    
