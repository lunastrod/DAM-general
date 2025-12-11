package com.dam.programame;

import java.util.Scanner;
//aceptado
public class p217 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        do{
            n=sc.nextInt();
            if(n!=0){
                if(n%2==0){
                    System.out.println("DERECHA");
                }
                else{
                    System.out.println("IZQUIERDA");
                }
            }
        }while(n!=0);
        sc.close();
    }
}
