package com.dam.ejerciciorepeticion;
/*(do-while) Escribe un programa que pida el límite inferior y superior de un
intervalo. Si el límite superior es menor que el inferior lo tiene que volver a pedir.

A continuación se van introduciendo números hasta que introduzcamos el 0.
Cuando termine el programa dará las siguientes informaciones:
• La suma de los números que están dentro del intervalo (intervalo abierto).
• Cuantos números están fuera del intervalo.
• E informe si se ha introducido algún número igual a los límites del intervalo. */

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limInf=0;
        int limSup=0;
        do{
            System.out.println("Introduce limite inferior");
            limInf=Integer.parseInt(sc.nextLine());
            System.out.println("Introduce limite superior");
            limSup=Integer.parseInt(sc.nextLine());
        } while(limInf>limSup);

        int suma=0;
        int cFueraInt=0;
        int n=0;
        do{
            System.out.println("Introduce numero (para con el 0)");
            n=Integer.parseInt(sc.nextLine());
            if(n>limInf && n<limSup){
                suma+=n;
            }
            else if(n==limInf || n==limSup){
                System.out.println(n+ " en el límite del intervalo");
            }
            else{
                cFueraInt++;
            }
        }while(n!=0);
        sc.close();
        System.out.println("suma: "+suma);
        System.out.println(cFueraInt+ " numeros fuera del intervalo");
    }
}
