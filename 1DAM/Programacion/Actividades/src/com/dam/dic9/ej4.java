package com.dam.dic9;

import java.util.Random;
import java.util.Scanner;

public class ej4 {
    final static int MIN=10;
    final static int MAX=100;
    final static int MULTIPLOS_DE=5;
    public static void main(String[] args){
        /*4. Realiza un programa en el que se cree una matriz nxm,
         solicita n y m por teclado, se rellene con enteros aleatorios entre 10 y 100
          que sean múltiplos de 5, muestra la matriz por consola y calcula y muestra su traspuesta.
           La matriz traspuesta se obtiene cambiando las filas por las columnas, es decir, la fila 1 pasa a
            ser la columna 1, la fila 2, la columna 2, y así sucesivamente.*/

        
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce n");
        int n=Integer.parseInt(sc.nextLine());
        System.out.println("Introduce m");
        int m=Integer.parseInt(sc.nextLine());
        sc.close();
        int[][] enteros=new int[n][m];

        Random rd=new Random();
        rellenaArrayAleatorio(enteros, rd, MIN/MULTIPLOS_DE, MAX/MULTIPLOS_DE);
        multiplicaArray(enteros,MULTIPLOS_DE);

        muestraArrayBi(enteros);
        System.out.println("Matriz transpuesta");
        muestraArrayBi(matrizTranspuesta(enteros));
    }

    private static int[][] matrizTranspuesta(int[][] m){
        int[][] t=new int[m[0].length][m.length];
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[0].length; j++){
                t[j][i]=m[i][j];
            }
        }
        return t;
    }

    private static void multiplicaArray(int[][]array, int n){
        for(int fila=0; fila<array.length; fila++){
            for(int item=0; item<array[fila].length; item++){
                array[fila][item]=array[fila][item]*n;
            }
        }
    }

    private static void rellenaArrayAleatorio(int [][] array, Random rd, int min, int max){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length;j++){
                array[i][j]=rd.nextInt(min, max);
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
