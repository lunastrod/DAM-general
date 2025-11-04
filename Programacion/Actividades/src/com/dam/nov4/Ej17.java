package com.dam.nov4;
/*17. Crea un programa para el control del empaquetado de 200 manzanas.
Las manzanas se empaquetan en bandejas de 5 manzanas. El programa
deberá solicitar el peso de cada manzana e irlo sumando de manera que
cuando llegue a 5 indique el precio del paquete teniendo en cuenta que el kg
está a 1,85€*/

import java.util.Scanner;

public class Ej17 {
    private static final int N_MANZANAS=200;
    private static final int MANZANAS_POR_BANDEJA=5;
    private static final double PRECIO_KG=1.85;

    public static void main(String[] args) {
        double pesoManz;
        double pesoBand;
        Scanner sc=new Scanner(System.in);

        for(int band=0; band<N_MANZANAS/MANZANAS_POR_BANDEJA;band++){
                pesoBand=0;
            for(int manz=0; manz<MANZANAS_POR_BANDEJA; manz++){
                System.out.println("Introduce peso manzana");
                pesoManz=Double.parseDouble(sc.nextLine());
                pesoBand+=pesoManz;
            }
            System.out.println("\tPrecio del paquete: "+pesoBand*PRECIO_KG+"euros");
        }
        sc.close();
    }
}
