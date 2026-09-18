package com.dam.programame;

import java.util.Scanner;
//aceptado
public class p368 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean running=true;
        int huevos;
        int capacidad;
        int tiempo;
        while(running){
            huevos=sc.nextInt();
            capacidad=sc.nextInt();
            tiempo=0;
            if(huevos==0&&capacidad==0){
                running=false;
            }
            else{
                while(huevos>0){
                    huevos-=capacidad;
                    tiempo+=10;
                }
                System.out.println(tiempo);
            }
        }
        sc.close();
    }
}
