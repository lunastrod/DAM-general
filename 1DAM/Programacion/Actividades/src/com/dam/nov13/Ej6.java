package com.dam.nov13;
/*Crea un array de números donde le indicamos por teclado el tamaño del
array, rellenaremos el array con números aleatorios entre 0 y 9, al
final muestra por pantalla el valor de cada posición y la suma de todos
los valores. Haz un método para rellenar el array (que tenga como
parámetros los números entre los que tenga que generar), para
mostrar el contenido y la suma del array y un método privado para
generar número aleatorio (lo puedes usar para otros ejercicios). */

import java.util.Random;
import java.util.Scanner;

public class Ej6 {
    private static final int MIN_ALEATORIO=0;
    private static final int MAX_ALEATORIO=9;

    public static void main(String[] args) {
        int[] aleatorios=inicializarArray(solicitarCuantos());
        generaAleatorios(aleatorios);
        printArray(aleatorios);
        System.out.println("La suma es "+sumaArray(aleatorios));
    }

    private static int solicitarCuantos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce numero de aleatorios en el array");
        int size=Integer.parseInt(sc.nextLine());
        sc.close();
        return size;
    }

    private static int[] inicializarArray(int size){
        int[] aleatorios=new int[size];
        return aleatorios;
    }

    private static void generaAleatorios(int[] aleatorios){
        Random rd=new Random();
        for(int i=0; i<aleatorios.length; i++){
            aleatorios[i]=rd.nextInt(MIN_ALEATORIO,MAX_ALEATORIO+1);
        }
    }

    private static void printArray(int[] array){
        for(int i=0; i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    private static int sumaArray(int[] array){
        int accum=0;
        for(int i=0; i<array.length; i++){
            accum+=array[i];
        }
        return accum;
    }
}
