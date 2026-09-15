package com.dam.sintaxis;

public class Ejercicio2 {
    public static void main(String[] args) {
        Clase2 obj1= new Clase2(5,4);
        System.out.print(obj1.modificar(4)+"(main) ");
        Clase2 obj2= new Clase2(5,4);
        System.out.print(obj2.modificar(5)+"(main) ");
        obj2 = obj1;
        System.out.println(obj1.modificar(5)+"(main) ");
    }
}