package com.dam.nov4;

/*10. Crea un programa que solicite 10 valores enteros e indique cuantos de ellos son mayores que el anterior y cuantos menores que el anterior.
Ejemplo:
Si se introdujeran los siguientes números: 3, 5, 8, 2, 6, 1, 4, 7, 9, 2
Se debería mostrar: 6 números son mayores que el anterior y 3
menores que el anterior
 */

import java.util.Scanner;

public class Ej10 {
    private static final int N_NUMS=10;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int menoresAnterior=0;
        int mayoresAnterior=0;
        int n;
        int anterior;
        System.out.println("Introduzca el primer numero");
        anterior=Integer.parseInt(sc.nextLine());
        for(int i=0; i<N_NUMS-1;i++){
            System.out.println("Introduzca numero");
            n=Integer.parseInt(sc.nextLine());
            if(n>anterior){
                mayoresAnterior++;
            }
            else if(n<anterior){
                menoresAnterior++;
            }
            anterior=n;
        }
        System.out.println(mayoresAnterior+" numeros son mayores que el anterior y "+menoresAnterior+" menores que el anterior");
        sc.close();
    }
}
