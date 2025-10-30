package com.dam.sintaxis;

public class Banco {
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta(12345, 505.4);
        double totalCuenta = cuenta1.saldo;
        System.out.println("Total actual en la cuenta:"+totalCuenta+" Euros");
    }
}
