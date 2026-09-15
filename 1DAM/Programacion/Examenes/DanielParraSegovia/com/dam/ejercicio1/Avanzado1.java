package com.dam.ejercicio1;

import java.util.Scanner;

public class Avanzado1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca numero");
        int num=Integer.parseInt(sc.nextLine());
        sc.close();
        for(int linea=1; linea<=num; linea++){
            for(int espacio=0;espacio<num-linea;espacio++){
                System.out.print(" ");
            }
            for(int ascendente=1; ascendente<=linea;ascendente++){
                System.out.print(ascendente);
            }
            for(int descendente=linea-1; descendente>0; descendente--){
                System.out.print(descendente);
            }
            System.out.println();
        }
    }
}
