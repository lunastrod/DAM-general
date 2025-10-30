package com.dam.sintaxis;

public class Ejercicio4 {
    public static void main(String[] args) {
        Clase4 obj1 = new Clase4(7);
        Clase4 obj2 = new Clase4(9);

        obj2 = obj1;
        System.out.println();
        System.out.print(obj1.valorprop()+" ");
        System.out.print(obj2.valorprop()+" ");
    }
}

