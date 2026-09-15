package com.dam.dic9;

import java.util.Random;
import java.util.Scanner;

public class ej6 {
    final static int MIN=0;
    final static int MAX=10;
    public static void main(String[] args) {
        //6. Realiza un programa en el que se cree una matriz nxn, 
        // solicita n por teclado, se rellene de enteros aleatorios entre 0 y 10
        //  y determine si la matriz es triangular superior, es decir, si i > j entonces a[i][j] = 0

        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce n");
        int n=Integer.parseInt(sc.nextLine());
        sc.close();

        int[][] enteros=new int[n][n];
        Random rd=new Random();
        enteros[0][0]=MAX-1;
        muestraMatriz(enteros);
        System.out.println("es triangular superior? "+esTriangularSuperior(enteros));

        rellenaArrayAleatorio(enteros,rd,MIN,MAX);
        muestraMatriz(enteros);
        System.out.println("es triangular superior? "+esTriangularSuperior(enteros));
    }

    private static boolean esTriangularSuperior(int[][] m){
        boolean triangularSuperior=true;
        for(int i=0;triangularSuperior&& i<m.length; i++){
            for(int j=0;triangularSuperior&& j<i;j++){
                if(m[i][j]!=0){
                    triangularSuperior=false;
                }
            }
        }
        return triangularSuperior;
    }
    private static void muestraMatriz(int[][] m){
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rellenaArrayAleatorio(int [][] array, Random rd, int min, int max){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length;j++){
                array[i][j]=rd.nextInt(min, max);
            }
        }
    }
}
