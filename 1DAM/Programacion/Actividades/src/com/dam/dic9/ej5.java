package com.dam.dic9;

import java.util.Random;
import java.util.Scanner;

public class ej5 {
    final static int MIN=-9;
    final static int MAX=10;
    public static void main(String[] args){
        //5. Realiza un programa en el que se cree una matriz nxn, 
        // solicita n por teclado, y se rellene de enteros aleatorios 
        // entre 0 y 10 de manera que sea antisimétrica. Una matriz es antisimétrica
        // si los elementos de la diagonal son 0 y todo elemento que no pertenezca 
        // a la diagonal cumpla que a[i][j] = -a[j][i]

        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce n");
        int n=Integer.parseInt(sc.nextLine());
        sc.close();


        int[][] enteros=new int[n][n];
        Random rd=new Random();
        rellenaMatrizAleatoriaAntisimetrica(enteros, rd, MIN,MAX);
        muestraArrayBi(enteros);
    }

    private static void rellenaMatrizAleatoriaAntisimetrica(int [][] m, Random rd, int min, int max){
        for(int i=0; i<m.length; i++){
            for(int j=i; j<m[i].length;j++){
                if(i==j){
                    m[i][j]=0;
                }else{
                    m[i][j]=rd.nextInt(min,max);
                    m[j][i]=-m[i][j];
                }
            }
        }
    }

    private static void muestraArrayBi(int[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
