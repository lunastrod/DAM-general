/*

El director de una escuela está organizando un viaje de estudios, y requiere
determinar cuánto debe cobrar a cada alumno y cuánto debe pagar a la compañía
de viajes por el servicio. La forma de cobrar es la siguiente: si son 100 alumnos o
más, el costo por cada alumno es de 65 euros; de 50 a 99 alumnos, el costo es de
70 euros, de 30 a 49, de 95 euros, y si son menos de 30, el costo de la renta del
autobús es de 4000 euros, sin importar el número de alumnos.
Realice un algoritmo que permita determinar el pago a la compañía de autobuses
y lo que debe pagar cada alumno por el viaje.

*/

import java.util.Scanner;

public class Ejif9 {
    static final int COSTE_MAS_100=65;
    static final int COSTE_MAS_50=70;
    static final int COSTE_MAS_30=95;
    static final int COSTE_MENOS_30_TOTAL=4000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca número de alumnos");
        int alumnos=Integer.parseInt(sc.nextLine());
        sc.close();
        int precio;

        if(alumnos>=100){
            precio=COSTE_MAS_100*alumnos;
        }
        else if(alumnos>=50){
            precio=COSTE_MAS_50*alumnos;
        }
        else if(alumnos>=30){
            precio=COSTE_MAS_30*alumnos;
        }
        else{
            precio=COSTE_MENOS_30_TOTAL;
        }
        System.out.println("Pago a la compañía: " + precio);
    }
}
