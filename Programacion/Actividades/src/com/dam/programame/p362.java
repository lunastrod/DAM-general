package com.dam.programame;

import java.util.Scanner;
//aceptado
public class p362 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nfechas=sc.nextInt();
        int dia;
        int mes;
        for(int i=0; i<nfechas; i++){
            dia=sc.nextInt();
            mes=sc.nextInt();
            if(dia==25&&mes==12){
                System.out.println("SI");
            }
            else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
