/*

Crea un programa que pida al usuario dos números y muestre su división si el
segundo no es cero, o un mensaje de aviso en caso contrario.

*/

import java.util.Scanner;

public class Ejif6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca dividendo");
        double a = Double.parseDouble(sc.nextLine());
        System.out.println("Introduzca divisor");
        double b = Double.parseDouble(sc.nextLine());
        sc.close();
        if(b==0){
            System.out.println("divisor no puede ser 0");
        }
        else{
            System.out.println(a+"/"+b+"="+(a/b));
        }
    }
}
