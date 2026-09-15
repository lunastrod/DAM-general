/*

10. Realiza un programa que pida por teclado el resultado (dato entero) obtenido al
lanzar un dado de seis caras y muestre por pantalla el número en letras (dato
cadena) de la cara opuesta al resultado obtenido.
• Nota 1: En las caras opuestas de un dado de seis caras están los números: 1-6, 2-
5 y 3-4.
• Nota 2: Si el número del dado introducido es menor que 1 o mayor que 6, se
mostrará el mensaje: “ERROR: número incorrecto.”

*/

import java.util.Scanner;

public class Ejswitch10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca número del dado:");
        int dado = Integer.parseInt(sc.nextLine());
        sc.close();

        System.out.print("En la cara opuesta está el \"");
        switch (dado) {
            case 1:
                System.out.print("seis");
                break;
            case 2:
                System.out.print("cinco");
                break;
            case 3:
                System.out.print("cuatro");
                break;
            case 4:
                System.out.print("tres");
                break;
            case 5:
                System.out.print("dos");
                break;
            case 6:
                System.out.print("uno");
                break;
        }
        System.out.println("\".");
    }
}
