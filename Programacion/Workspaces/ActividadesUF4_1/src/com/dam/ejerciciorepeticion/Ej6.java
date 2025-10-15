package com.dam.ejerciciorepeticion;
/*(while o for) Desarrollar un programa que muestre los primos menores que un
número introducido por teclado.*/

import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce numero");
        int n=Integer.parseInt(sc.nextLine());
        sc.close();

        for(int candidatoPrimo=2; candidatoPrimo<n; candidatoPrimo++){
            boolean esPrimo=true;
            for(int divisor=2; esPrimo&&divisor<=Math.sqrt(candidatoPrimo); divisor++){
                if(candidatoPrimo%divisor==0){//tiene mas de 2 divisores
                    esPrimo=false;
                }
            }
            if(esPrimo){
                System.out.print(candidatoPrimo+" ");
            }
        }
    }
}
