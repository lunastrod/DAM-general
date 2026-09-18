package com.dam.nov13;

import java.util.Scanner;

/*Programa Java que lea 10 números enteros por teclado y los guarde en
un array. Calcula y muestra la media de los números que estén en las
posiciones pares del array.
Considera la primera posición del array (posición 0) como par. */

public class Ej4 {
    private static final int N_NUMS=10;
    public static void main(String[] args) {
        int [] nums=new int[N_NUMS];
        solicitar(nums);
        System.out.println(media(nums));
    }

    private static void solicitar(int[] nums){
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<nums.length; i++){
            System.out.println("Introduce numero "+i);
            nums[i]=Integer.parseInt(sc.nextLine());
        }
        sc.close();
    }

    private static double media(int[] nums){
        double accum=0;
        int contador=0;
        for(int i=0; i<nums.length;i+=2){
            accum+=nums[i];
            contador++;
        }
        return accum/contador;
    }

}
