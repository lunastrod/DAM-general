package com.dam.ejerciciorepeticion;
/*(while o for) Escribe un programa que, dados dos números, uno real (base) y un
entero positivo (exponente), saque por pantalla el resultado de la potencia. No se
puede utilizar la función Math.pow. */

import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce base");
        int base=Integer.parseInt(sc.nextLine());
        System.out.println("Introduce exponente");
        int exp=Integer.parseInt(sc.nextLine());

        int resultado=1;
        sc.close();
        for(int i=0; i<exp;i++){
            resultado*=base;
        }
        System.out.println(base+"^"+exp+"="+resultado);
    }

}
