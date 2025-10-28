package com.dam.ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce cuantos numeros");
        int nNums=Integer.parseInt(sc.nextLine());
        

        int a;
        System.out.println("Introduce "+nNums+ " numeros separados por espacios");
        for(int i=0; i<nNums; i++){
            a=sc.nextInt();
            //no pongo nextline porque quiero que el usuario me introduzca
            //todos los numeros en la misma linea
            if(a%2==0&&a%7==0){
                System.out.print(a+" ");
            }
        }
        sc.nextLine();
        sc.close();
    }
}
