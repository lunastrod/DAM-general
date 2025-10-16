package com.dam.comparadores.main;
/*
 * 
 * Enunciado 3
Crear una clase ejecutable, CompararHelipuertos, para comparar el área de aterrizaje de dos
helipuertos circulares.

Para ello debemos crear una clase POJO, Helipuerto con las siguientes características:
- dos atributos para almacenar la información del nombre del helipuerto y su radio.
- una constante: PI = 3.1416
- métodos de acceso de los atributos (get y set)
- método que calcule el área del helipuerto (a = PI * r * r)
En la clase ejecutable solicitaremos los datos por teclado, generaremos dos objetos de tipo
Helipuerto y compararemos sus áreas indicando cual es el que mayor área tiene.

*/

import java.util.Scanner;

import com.dam.comparadores.pojo.Helipuerto;

class CompararHelipuertos{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre;
        int area;

        System.out.println("Introduce nombre");
        nombre = sc.nextLine();
        System.out.println("Introduce area");
        area = Integer.parseInt(sc.nextLine());
        Helipuerto h1=new Helipuerto(nombre, area);

        System.out.println("Introduce nombre");
        nombre = sc.nextLine();
        System.out.println("Introduce area");
        area = Integer.parseInt(sc.nextLine());
        Helipuerto h2=new Helipuerto(nombre, area);

        sc.close();

        if(h1.calcularArea()>h2.calcularArea()){
            System.out.println(h1+" es más grande");
        }
        else{
            System.out.println(h2+" es más grande");
        }
    }
}