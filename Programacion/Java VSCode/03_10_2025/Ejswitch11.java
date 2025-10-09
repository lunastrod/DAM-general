/*

Realiza un programa que pida el día de la semana (del 1 al 7) y escriba el día
correspondiente. Si introducimos otro número nos da un error.

*/

import java.util.Scanner;

public class Ejswitch11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el día de la semana (1-7)");
        int diaSemana = Integer.parseInt(sc.nextLine());
        sc.close();

        String texto="El día de la semana "+ diaSemana+ " es el ";

        switch (diaSemana) {
            case 1:
                System.out.println(texto+"Lunes");
                break;
            case 2:
                System.out.println(texto+"Martes");
                break;
            case 3:
                System.out.println(texto+"Miércoles");
                break;
            case 4:
                System.out.println(texto+"Jueves");
                break;
            case 5:
                System.out.println(texto+"Viernes");
                break;
            case 6:
                System.out.println(texto+"Sábado");
                break;
            case 7:
                System.out.println(texto+"Domingo");
                break;
            default:
                System.out.println("El día de la semana debe ser un número entre 1 y 7");
        }
    }
}
