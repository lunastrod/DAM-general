/*Crea un paquete dam.ej2.main y dentro crea una clase
ejecutable, GestorEstaciones, en la que:
• Se solicite la cantidad de estaciones que se van a introducir.
• Rellenar e inicializar un array para almacenar la información de las
estaciones, de manera que, para cada estación se solicitarán los datos
necesarios.
• Y cuando se haya acabado de introducir estaciones, muestre los datos
de las estaciones para poder comprobar el resultado. Mostrar también
el porcentaje de km esquiables para cada estación ABIERTA.
• El programa deberá informar de cuántas estaciones abiertas se han
introducido y cuántas tienen más de 20 km esquiables abiertos.
• Mostrar la estación abierta con menor porcentaje de km esquiables. */

package com.dam.nov20;

import java.util.Scanner;

public class GestorEstaciones {
    private static boolean PRUEBA=true;
    public static void main(String[] args) {
        Estacion [] estaciones;
        if(!PRUEBA){
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce la cantidad de estaciones a introducir: ");
            int cantidadEstaciones = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea
            estaciones = solicitaEstaciones(sc, cantidadEstaciones);
            sc.close();
        }
        else{
            estaciones= arrayPruebaEstaciones();
        }
        muestraEstaciones(estaciones);
    }

    private static Estacion[] solicitaEstaciones(Scanner sc, int cantidad) {
        Estacion[] estaciones = new Estacion[cantidad];
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Introduce los datos de la estación " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Provincia: ");
            String provincia = sc.nextLine();
            System.out.print("Estado (ABIERTA/CERRADA): ");
            String estado = sc.nextLine();
            System.out.print("Número de remontes (abiertos/total): ");
            String numRemontes = sc.nextLine();
            System.out.print("Número de pistas (abiertas/total): ");
            String numPistas = sc.nextLine();
            System.out.print("Número de km esquiables (abiertos/total): ");
            String numKmEsquiables = sc.nextLine();
            estaciones[i] = new Estacion(nombre, provincia, estado, numRemontes, numPistas, numKmEsquiables);
        }
        return estaciones;
    }

    private static Estacion[] arrayPruebaEstaciones(){
        Estacion[] estaciones = new Estacion[7];
        estaciones[0] = new Estacion("E1", "Prov1", "ABIERTA", "10/20", "15/30", "25/100");
        estaciones[1] = new Estacion("E2", "Prov2", "CERRADA", "5/15", "10/25", "0/80");
        estaciones[2] = new Estacion("E3", "Prov3", "ABIERTA", "20/25", "30/40", "50/120");
        estaciones[3] = new Estacion("E4", "Prov4", "ABIERTA", "15/20", "20/30", "10/90");
        estaciones[4] = new Estacion("E5", "Prov5", "CERRADA", "0/10", "0/20", "0/70");
        estaciones[5] = new Estacion("E6", "Prov6", "ABIERTA", "18/22", "25/35", "30/110");
        estaciones[6] = new Estacion("E7", "Prov7", "ABIERTA", "12/18", "15/28", "22/95");
        return estaciones;
    }

/*
• muestre los datos de las estaciones para poder comprobar el resultado. Mostrar también
el porcentaje de km esquiables para cada estación ABIERTA.
• El programa deberá informar de cuántas estaciones abiertas se han
introducido y cuántas tienen más de 20 km esquiables abiertos.
• Mostrar la estación abierta con menor porcentaje de km esquiables.
*/

    private static void muestraEstaciones(Estacion[] estaciones) {
        int contadorAbiertas=0;
        int contadorMas20Km=0;
        Estacion estacionMenorPorcentaje=null;

        for(int i=0; i<estaciones.length; i++){
            if(i==0){
                estacionMenorPorcentaje=estaciones[i];
            }
            System.out.println(estaciones[i]);
            if(estaciones[i].isAbierta()){
                //mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm printf (no se para que lo uso he tenido que mirar cómo se escribe un %)
                System.out.printf("Porcentaje de km esquiables: %f%%\n", estaciones[i].porcentajeKmEsquiables());
                contadorAbiertas++;
                if(estaciones[i].porcentajeKmEsquiables()<estacionMenorPorcentaje.porcentajeKmEsquiables()){
                    estacionMenorPorcentaje=estaciones[i];
                }
            }
            if(estaciones[i].kmEsquiablesAbiertos()>20){
                contadorMas20Km++;
            }
        }
        System.out.println("======================================");
        System.out.println("Número de estaciones abiertas: " + contadorAbiertas);
        System.out.println("Número de estaciones con más de 20 km esquiables abiertos: " + contadorMas20Km);
        System.out.println("Estación abierta con menor porcentaje de km esquiables: " + estacionMenorPorcentaje);
    }
}
