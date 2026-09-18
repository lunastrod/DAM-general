package com.dam.programame;

import java.util.Scanner;
//aceptado
public class p313 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nCasos=sc.nextInt();
        int saldo;
        int cambio;
        for(int i=0; i<nCasos; i++){
            saldo=sc.nextInt();
            cambio=sc.nextInt();
            if(saldo+cambio>=0){
                System.out.println("SI");
            }
            else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
