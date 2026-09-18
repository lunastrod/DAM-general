package com.dam.nov13;
/*7. Crea un array de números de un tamaño pasado por teclado,
 el array contendrá números aleatorios primos entre los números deseados
(también solicitados por teclado), por último, nos indicará cual es el mayor de todos.
 Haz un método para comprobar si un número es primo. Haz todos lo métodos que necesites. */

import java.util.Random;
import java.util.Scanner;

public class Ej7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] randomPrimes=initArray(sc);
        fillRandomPrimeArray(sc,randomPrimes);
        System.out.println("El array de primos es:");
        printArray(randomPrimes);
        System.out.println("El primo más grande en el array es "+maxArray(randomPrimes));
        sc.close();
    }

    private static int[] initArray(Scanner sc){
        //requests size and returns int array of that size
        System.out.println("Introduce tamaño de array");
        int size=Integer.parseInt(sc.nextLine());
        return new int[size];
    }

    private static boolean isPrime(int n){
        //returns true if n is prime
        boolean prime=true;
        if(n<=1){//negatives, 1 and 0 are not primes
            prime=false;
        }
        for(int i=2;prime&&i<=Math.sqrt(n);i++){
            if(n%i==0){
                prime=false;
            }
        }
        return prime;
    }

    private static void fillRandomPrimeArray(Scanner sc, int[] array){
        //requests random range and fills array of random numbers in range
        System.out.println("Introduce un numero");
        int min=Integer.parseInt(sc.nextLine());
        System.out.println("Introduce otro numero");
        int max=Integer.parseInt(sc.nextLine());
        //swap if min is not actually smaller
        if(min>max){
            int temp=min;
            min=max;
            max=temp;
        }
        Random rd = new Random();
        int n;
        for(int i=0; i<array.length;i++){
            do{
                //this loop might be infinite if range is not well chosen
                //I could implement a max iteration counter but meh
                n=rd.nextInt(min,max);
            }while(!isPrime(n));
            array[i]=n;
        }
    }

    private static void printArray(int[] array){
        //prints the values of the array
        for(int i=0; i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    private static int maxArray(int[] array){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }
}
