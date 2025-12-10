package com.dam.dic2;

import java.util.Random;
import java.util.Scanner;

public class arraysbi {
    public static void main(String[] args) {
        ej4();
    }
    public static void ej1(){
        final int FILAS=4;
        final int COLUMNAS=4;
        int[][] enteros=new int[FILAS][COLUMNAS];
        rellenaArrayBi(enteros);
        muestraArrayBi(enteros);
    }

    public static void ej2(){
        final int FILAS=4;
        final int COLUMNAS=4;
        int[][] enteros=new int[FILAS][COLUMNAS];

        rellenaArrayBi(enteros);
        muestraArrayBi(enteros);
        System.out.println(esSimetrica(enteros));

        rellenaArraySimetrica(enteros);
        muestraArrayBi(enteros);
        System.out.println(esSimetrica(enteros));
    }

    private static boolean esSimetrica(int [][] array){
        boolean simetrica=true;
        for(int i=0; simetrica && i<array.length-1; i++){
            for(int j=i+1; simetrica && j<array[i].length;j++){
                if(array[i][j]!=array[j][i]){
                    simetrica=false;
                }
            }
        }
        return simetrica;
    }

    public static void ej3(){
        final int FILAS=3;
        final int COLUMNAS=4;
        int[][] enteros=new int[FILAS][COLUMNAS];
        rellenaArrayBi(enteros);
        muestraArrayBi(enteros);
        imprimeMayorElemento(enteros);
    }

    private static void imprimeMayorElemento(int [][] array){
        int iMayor=0;
        int jMayor=0;
        int mayor=Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length;j++){
                if(array[i][j]>mayor){
                    mayor=array[i][j];
                    iMayor=i;
                    jMayor=j;
                }
            }
        }
        System.out.println("El elemento mayor es "+mayor+" y esta en la fila "+iMayor+" y en la columna "+jMayor);
    }

    public static void ej4(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce n");
        int n=Integer.parseInt(sc.nextLine());
        System.out.println("Introduce m");
        int m=Integer.parseInt(sc.nextLine());
        sc.close();
        int[][] enteros=new int[n][m];

        Random rd=new Random();
        rellenaArrayAleatorio(enteros, rd, 0, 10);

        muestraArrayBi(enteros);
        System.out.println("Despues del cambio de fila");
        cambiaFilas(enteros,0,1);
        muestraArrayBi(enteros);
    }

    public static void ej5(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce n");
        int n=Integer.parseInt(sc.nextLine());
        System.out.println("Introduce m");
        int m=Integer.parseInt(sc.nextLine());
        sc.close();

        int[][] enteros=new int[n][m];
        Random rd=new Random();
        rellenaArrayAleatorio(enteros, rd, 0, 10);

        muestraArrayBi(enteros);
        imprimeVertices(enteros);
    }

    private static void imprimeVertices(int[][] array){
        System.out.println(array[0][0]+"-"+array[0][array[0].length-1]);
        System.out.println(array[array.length-1][0]+"-"+array[array.length-1][array[0].length-1]);
    }

    private static void cambiaFilas(int[][] array, int f1, int f2){
        int[] temp=array[f1];
        array[f1]=array[f2];
        array[f2]=temp;
    }

    private static void ej6(){
        int[][] enteros=new int[3][3];
        Random rd=new Random();
        rellenaArrayAleatorio(enteros, rd, 0, 2);

        muestraArrayBi(enteros);

        for(int i=0; i<enteros.length; i++){
            System.out.println("suma columna "+i+": "+sumaColumna(enteros, i));
        }

        for(int i=0; i<enteros[0].length; i++){
            System.out.println("suma fila "+i+": "+sumaFila(enteros, i));
        }
    }

    private static int sumaFila(int [][] array, int fila){
        int suma=0;
        for(int i=0; i<array[fila].length; i++){
            suma+=array[fila][i];
        }
        return suma;
    }

    private static int sumaColumna(int [][] array, int columna){
        int suma=0;
        for(int i=0; i<array.length; i++){
            suma+=array[i][columna];
        }
        return suma;
    }



    private static void rellenaArrayBi(int [][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length;j++){
                array[i][j]=i-j+5;
            }
        }
    }

    private static void rellenaArraySimetrica(int [][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length;j++){
                array[i][j]=i+j;
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
