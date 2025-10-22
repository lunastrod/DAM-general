package dam.ejercicio3.main;

import java.util.Scanner;

import dam.ejercicio3.pojo.EquipoFutbol;

/*
 * Crea otra clase ejecutable, CompararResultados, en la que: (3 puntos)
- Se soliciten los datos de dos equipos.
- Y se informe de cuál es el equipo que lleva más puntos.
*/

public class CompararResultados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Primer equipo");
        EquipoFutbol e1=generaEquipoFutbol(sc);
        System.out.println("Segundo equipo");
        EquipoFutbol e2=generaEquipoFutbol(sc);
        sc.close();
        if(e1.calcularPuntos()>e2.calcularPuntos()){
            System.out.println("El equipo con más puntos es");
            System.out.println(e1);
        }else if(e1.calcularPuntos()<e2.calcularPuntos()){
            System.out.println("El equipo con más puntos es");
            System.out.println(e2);
        }
        else{
            System.out.println(e1);
            System.out.println("Está empatado con");
            System.out.println(e2);
        }
    }
    private static EquipoFutbol generaEquipoFutbol(Scanner sc){
        System.out.println("Introduce nombre del equipo:");
        String n=sc.nextLine();
        System.out.println("Introduce ciudad del equipo:");
        String c=sc.nextLine();
        System.out.println("Introduce numero de partidos ganados:");
        int g=Integer.parseInt(sc.nextLine());
        System.out.println("Introduce numero de partidos empatados:");
        int x=Integer.parseInt(sc.nextLine());
        System.out.println("Introduce numero de partidos perdidos:");
        int p=Integer.parseInt(sc.nextLine());
        return new EquipoFutbol(n, c, g, x, p);
    }
}
