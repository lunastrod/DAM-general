package com.dam.nov13;

import java.util.Scanner;

/*Programa Java para leer la altura de N personas y calcular la altura
media. Calcular cuántas personas tienen una altura superior a la media
y cuántas tienen una altura inferior a la media. El valor de N se pide
por teclado y debe ser entero positivo. */

public class Ej5 {
    public static void main(String[] args) {
        double[] personas=solicitar();
        double media=media(personas);
        int personasSuperiorMedia=cuantosMayores(personas, media);
        System.out.println(personasSuperiorMedia+" personas más altas que la media");
        //como estoy usando doubles, estoy asumiendo que nunca una persona va a ser exactamente igual que la media
        //si se diera el caso pues diré que es menor.
        System.out.println(personas.length-personasSuperiorMedia+" personas más bajas que la media");
    }

    private static double[] solicitar(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce numero de personas");
        int size=Integer.parseInt(sc.nextLine());
        double[] personas=new double[size];

        for(int i=0; i<personas.length; i++){
            System.out.println("Introduce altura en metros de persona "+i);
            personas[i]=Double.parseDouble(sc.nextLine());
        }
        sc.close();
        return personas;
    }

    private static double media(double[] nums){
        double accum=0;
        for(int i=0; i<nums.length; i++){
            accum+=nums[i];
        }
        return accum/nums.length;
    }

    private static int cuantosMayores(double[] nums, double valor){
        int cont=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>valor){
                cont++;
            }
        }
        return cont;
    }

}
