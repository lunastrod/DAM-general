package com.dam.nov11;

import java.util.Scanner;

/*Programa Java que guarda en un array 10 números enteros que se leen
por teclado. A continuación se recorre el array y calcula cuántos
números son positivos, cuántos negativos y cuántos ceros. */

public class Actividad2 {
    private static final int N_NUMS=10;
    public static void main(String[] args) {
        int [] nums=new int[N_NUMS];
        solicitar(nums);
        calculaSigno(nums);
    }
    private static void solicitar(int[] nums){
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<nums.length; i++){
            System.out.println("Introduce numero "+i);
            nums[i]=Integer.parseInt(sc.nextLine());
        }
        sc.close();
    }

    private static void calculaSigno(int[] nums){
        int positivos=0;
        int negativos=0;
        int ceros=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]<0){
                negativos++;
            }else if(nums[i]>0){
                positivos++;
            }else{//0
                ceros++;
            }
        }
        System.out.println(positivos + " numeros positivos");
        System.out.println(negativos + " numeros negativos");
        System.out.println(ceros + " ceros");
    }
}
