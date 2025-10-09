/*

Realiza un programa que calcule la potencia, para ello pide por teclado la base y
el exponente. Pueden ocurrir tres cosas:
El exponente sea positivo, sólo tienes que imprimir la potencia.
El exponente sea 0, el resultado es 1.
El exponente sea negativo, el resultado es 1/potencia con el exponente positivo.

*/

import java.util.Scanner;

public class Ejif7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca base");
        double b = Double.parseDouble(sc.nextLine());
        System.out.println("Introduzca exponente");
        double e = Double.parseDouble(sc.nextLine());
        sc.close();
        double result;
        if(e==0){
            result=1;
        }
        else if (e>=0){
            result=Math.pow(b,e);
        }
        else{
            result=1/Math.pow(b,-e);
        }
        System.out.println(b+"^"+e+"="+result);
    }
}
