package com.dam.ejercicio2.main;

import java.util.Scanner;

import com.dam.ejercicio2.pojo.Libro;

public class EleccionLibro {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca los datos del libro 1:");
        Libro l1=generaLibro(sc);
        System.out.println("Introduzca los datos del libro 2:");
        Libro l2=generaLibro(sc);
        System.out.println("Introduzca los datos del libro 3:");
        Libro l3=generaLibro(sc);
        sc.close();

        int tiempo1=l1.calcularTpoLectura();
        int tiempo2=l2.calcularTpoLectura();
        int tiempo3=l3.calcularTpoLectura();

        System.out.println(l1+" tardaría "+tiempo1+" minutos en leerlo");
        System.out.println(l2+" tardaría "+tiempo2+" minutos en leerlo");
        System.out.println(l3+" tardaría "+tiempo3+" minutos en leerlo");

        System.out.println("El libro que tardaré más en leer es:");
        //no voy a comprobar empates a páginas ni a tiempo de lectura
        //si empatan dirá uno de ellos
        if(tiempo1>tiempo2 && tiempo1>tiempo3){
            System.out.println(l1);
        }else if(tiempo2>tiempo3){
            System.out.println(l2);
        }else{
            System.out.println(l3);
        }

        System.out.println("El libro que tiene más páginas es:");
        if(l1.getNumPag()>l2.getNumPag() && l1.getNumPag()>l3.getNumPag()){
            System.out.println(l1);
        }else if(l2.getNumPag()>l3.getNumPag()){
            System.out.println(l2);
        }else{
            System.out.println(l3);
        }

    }
    private static Libro generaLibro(Scanner sc){
        System.out.println("\tnombre");
        String nombre=sc.nextLine();
        System.out.println("\tnúmero de páginas");
        int numPag=Integer.parseInt(sc.nextLine());
        System.out.println("\ttamaño de letra (1 pequeña, 2 grande)");
        int tamLetra=Integer.parseInt(sc.nextLine());

        

        return new Libro(nombre,numPag,tamLetra);
    }
}
