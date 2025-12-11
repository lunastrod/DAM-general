package com.dam.programame;

import java.util.Scanner;
//aceptado
public class p191 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nCasos=sc.nextInt();
        int compartimentos;
        int capacidad;
        int diferencia;
        int total;
        for (int i = 0; i < nCasos; i++) {
            compartimentos=sc.nextInt();
            capacidad=sc.nextInt();
            diferencia=sc.nextInt();
            total=0;
            for (int j = 0; j < compartimentos; j++) {
                total+=capacidad;
                capacidad-=diferencia;
            }
            System.out.println(total);
        }
        sc.close();
    }
}
