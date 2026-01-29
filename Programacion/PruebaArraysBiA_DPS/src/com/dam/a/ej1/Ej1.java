package com.dam.a.ej1;

import java.util.Random;
import java.util.Scanner;

//java D:\DAM-general\Programacion\PruebaArraysBiA_DPS\src\com\dam\a\ej1\Ej1.java

public class Ej1 {
    private static final int MIN_RANDOM=20;
    private static final int MAX_RANDOM=80;
    private static final int MULTIPLOS=3;
    private static final int FACTOR_I=5;
    private static final int FACTOR_J=10;
    private static final int COLUMNAS_EXTRA=2;
    public static void main(String[] args) {
        Random rd= new Random();
        Scanner sc=new Scanner(System.in);

        System.out.println("Introduce valor de n:");
        int n=Integer.parseInt(sc.nextLine());

        int[][] mat=new int[n][n+COLUMNAS_EXTRA];

        rellenaMatriz(mat, rd);
        System.out.println("Matriz:");
        muestraIntMatriz(mat);
        imprimeSumaColumnasParesImpares(mat);

        sc.close();
    }

    public static void muestraIntMatriz(int[][] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[i].length; j++){
                System.out.print(nums[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void rellenaMatriz(int[][]nums, Random rd){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[i].length; j++){
                if(i%2==0){
                    do{
                        nums[i][j]=rd.nextInt(MIN_RANDOM,MAX_RANDOM);
                    }while(nums[i][j]%MULTIPLOS!=0);
                }
                else{
                    nums[i][j]=i*FACTOR_I+j*FACTOR_J;
                }
                
            }
        }
    }

    public static void imprimeSumaColumnasParesImpares(int[][]nums){
        int accColumnasPares=0;
        int accColumnasImpares=0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[i].length; j++){
                if(j%2==0){
                    accColumnasPares+=nums[i][j];
                }
                else{
                    accColumnasImpares+=nums[i][j];
                }
            }
        }
        System.out.println("Suma de las columnas pares:");
        System.out.println(accColumnasPares);
        System.out.println("Suma de las columnas impares:");
        System.out.println(accColumnasImpares);
    }
}
