package dam.ejercicio2;

/*Crea una clase, Ejercicio2, que solicite dos enteros positivos, genere y muestre
10 números aleatorios entre dichos números, y muestre cuantos son pares y
cuantos impares. */

import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    static final int N_NUMS=10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce numero entero");
        int mayor = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce numero entero");
        int menor = Integer.parseInt(sc.nextLine());
        sc.close();
        
        if(mayor<menor){
            int temp=menor;
            menor=mayor;
            mayor=temp;
        }

        Random rd = new Random();
        int n;
        int pares=0;
        for(int i=0; i<N_NUMS; i++){
            n=rd.nextInt(menor,mayor);
            System.out.println("generado: "+n);
            if(n%2==0){
                pares++;
            }
        }
        System.out.println("Generados "+pares+" pares y "+(N_NUMS-pares)+" impares");
        
    }
}
