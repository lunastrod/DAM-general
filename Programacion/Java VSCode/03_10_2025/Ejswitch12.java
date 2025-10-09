/*

Escribe un programa que pida un número entero entre uno y doce e imprima el
número de días que tiene el mes correspondiente.

*/

import java.util.Scanner;

public class Ejswitch12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el número de mes");
        int mes = Integer.parseInt(sc.nextLine());
        sc.close();
        int dias;

        switch (mes) {
            case 1,3,5,7,8,10,12:
                dias=31;
                break;
            case 4,6,9,11:
                dias=30;
                break;
            case 2:
                dias=28;
                break;
            default:
                dias=0;
                break;
        }

        System.out.println("El número de días del mes "+ mes+" es "+dias);


    }
}
