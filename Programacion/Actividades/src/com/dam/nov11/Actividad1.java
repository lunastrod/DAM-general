package com.dam.nov11;

import java.util.Scanner;

/*Crea un array de 10 posiciones de números con valores pedidos por
teclado. Muestra por consola el índice y el valor al que corresponde.
Haz dos métodos, uno para rellenar valores y otro para mostrar. */

public class Actividad1 {
    private static final int N_NUMS=10;
    public static void main(String[] args) {
        int [] nums=new int[N_NUMS];
        solicitar(nums);
        mostrar(nums);
    }
    private static void solicitar(int[] nums){
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<nums.length; i++){
            System.out.println("Introduce numero "+i);
            nums[i]=Integer.parseInt(sc.nextLine());
        }
        sc.close();
    }

    private static void mostrar(int[] nums){
        for(int i=0; i<nums.length;i++){
            System.out.println(i+": "+nums[i]);
        }
    }
}
