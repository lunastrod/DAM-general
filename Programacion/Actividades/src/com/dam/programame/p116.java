package com.dam.programame;

import java.util.Scanner;
//aceptado
public class p116 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        byte n=Integer.parseInt(sc.nextLine());
        sc.close();
        for(byte i=0; i<n; i++){
            System.out.println("Hola mundo.");
        }
    }
}
