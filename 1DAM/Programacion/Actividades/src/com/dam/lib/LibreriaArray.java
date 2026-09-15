package com.dam.lib;

import java.util.Random;
import java.util.Scanner;

import com.dam.lib.Validacion;

public class LibreriaArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rd=new Random();
        int[][]nums=creaIntMatriz(sc, "nums");
        rellenaRandomIntMatriz(rd, nums, -20000, 10000);
        muestraIntMatriz(nums);
        muestraIntArray(nums[0]);
    }

    public static int[] creaIntArray(Scanner sc, String msg){
        int m=Validacion.validaInt(sc, "longitud de array "+msg, 0, Integer.MAX_VALUE);
        return new int[m];
    }
    public static int[][] creaIntMatriz(Scanner sc, String msg){
        int filas=Validacion.validaInt(sc, "numero de filas de array "+msg, 0, Integer.MAX_VALUE);
        int columnas=Validacion.validaInt(sc, "numero de columnas de array "+msg, 0, Integer.MAX_VALUE);
        return new int[filas][columnas];
    }
    public static String[] creaStringArray(Scanner sc, String msg){
        int m=Validacion.validaInt(sc, "longitud de array "+msg, 0, Integer.MAX_VALUE);
        return new String[m];
    }

    public static void rellenaRandomIntArray(Random rd, int[] nums, int min, int max){
        for(int i=0; i<nums.length; i++){
            nums[i]=rd.nextInt(min,max+1);
        }
    }
    public static void rellenaRandomIntMatriz(Random rd, int[][] nums, int min, int max){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[i].length; j++){
                nums[i][j]=rd.nextInt(min,max+1);
            }
        }
    }

    public static void muestraIntArray(int[] nums){
        System.out.print("[");
        for(int i=0; i<nums.length; i++){
            if(i==nums.length-1){
                System.out.print(nums[i]);
            }
            else{
                System.out.print(nums[i]+", ");
            }
        }
        System.out.println("]");
    }
    public static void muestraIntMatriz(int[][] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[i].length; j++){
                System.out.print(nums[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void muestraStringArray(String[]array){
        System.out.println(String.join(", ",array));
    }
}
