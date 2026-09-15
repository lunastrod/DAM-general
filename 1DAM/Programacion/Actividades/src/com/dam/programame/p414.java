package com.dam.programame;

import java.util.Scanner;

public class p414 {
    public static void factoresPrimos(int n,int[]factores){
        for (int i=0; n>1; i++){
            factores[i]=calculaMenorFactor(n);
            n=n/factores[i];
            System.out.print(factores[i]+" ");
        }
        System.out.println();
    }
    
    public static int calculaMenorFactor(int n){
        int j;
        for (j = 2; true; j++) {
            if(n%j==0){
                return j;
            }
        }
    }

    public static int calculaFactorCuadrado(int[]factores){
        int n=1;

        for (int i = 0; i < factores.length; i++) {
            factores[i]
        }
        return n;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int nCasos=sc.nextInt();
        int n;
        int[]factores=new int[31];
        for (int i = 0; i < nCasos; i++) {
            n=sc.nextInt();
            factoresPrimos(n,factores);
        }
        sc.close();
    }

}
