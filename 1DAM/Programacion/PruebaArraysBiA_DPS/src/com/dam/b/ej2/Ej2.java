package com.dam.b.ej2;

import java.util.Scanner;

public class Ej2 {
    private static final String EEUU="Estados Unidos";
    private static final String UK="Reino Unido";
    private static final String[][] cantantes={
        {"Aretha Franklin",EEUU},
        {"Elvis Presley",EEUU},
        {"Paul McCartney",UK},
        {"Mick Jagger",UK},
        {"Tina Turner",EEUU},
        {"Freddie Mercury",UK},
        {"Bob Marley","Jamaica"},
        {"David Bowie",UK},
        {"Van Morrison",UK},
        {"Michael Jackson",EEUU},
        {"Prince",EEUU},
        {"Bono","Irlanda"},
        {"Whitney Houston",EEUU},
        {"Bruce Springsteen",EEUU},
        {"Elton John",UK}
    };

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un pais");
        muestraCantantesDePais(sc.nextLine());
        sc.close();
    }
    public static void muestraCantantesDePais(String pais){
        int cont=0;
        System.out.println("Cantantes de "+pais+":");
        for (int i = 0; i < cantantes.length; i++) {
            if(pais.equalsIgnoreCase(cantantes[i][1])){
                cont++;
                System.out.println("  - "+cantantes[i][0]);
            }
        }
        if (cont==0) {
            System.out.println("    El pais no se encuentra en el array");
        }
    }
}
