package com.dam.ej1;

import java.util.Scanner;

/*El programa recibirá por teclado la información de 250 latas. 

De cada lata se informará primero el producto: 
-	1 para indicar que la lata es de mejillones, 
-	2 para indicar que la lata es de atún. 

Después del producto, se informará del tipo: 
-	11 para mejillones al natural, 
-	12 para mejillones en escabeche, 
-	21 para atún en aceite de girasol 
-	y 22 para atún en aceite de oliva. 

El programa deberá calcular:
-	las ganancias que obtendrá la empresa cuando se vendan las latas de mejillones sabiendo que: 
-	el precio de la lata de mejillones al natural es 1.45 euros 
-	y el de la lata de mejillones en escabeche es 2.05 euros, 
-	y las ganancias que obtendrá con la venta de las latas de atún sabiendo que: 
-	el precio de la lata de atún en aceite de girasol es 1,15 euros 
-	y el de la lata de atún en aceite de oliva es 1.35 euros.

Además deberá indicar cuántas latas de mejillones y cuántas de atún se han procesado.
 */

public class GananciasConservas {
    private static final int N_LATAS=250;
    private static final double PRECIO_MEJILLONES=1.45;
    private static final double PRECIO_MEJILLONES_ESCABECHE=2.05;
    private static final double PRECIO_ATUN_GIRASOL=1.15;
    private static final double PRECIO_ATUN_OLIVA=1.35;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int producto;
        int tipo;
        double gananciasMejillones=0;
        double gananciasMejillonesEscabeche=0;
        double gananciasAtunGirasol=0;
        double gananciasAtunOliva=0;

        int mejillones=0;
        int atun=0;
        for(int i=0; i<N_LATAS;i++){
            System.out.println("Introduce el producto de la lata 1: (1) mejillones, (2) atún");
            producto=Integer.parseInt(sc.nextLine());
            if(producto==1){
                System.out.println("Introduce el tipo de la lata 1: (11) mejillones al natural, (12) mejillones en escabeche");
                tipo=Integer.parseInt(sc.nextLine());
                if(tipo==11){
                    gananciasMejillones+=PRECIO_MEJILLONES;
                    mejillones++;
                }
                else if(tipo==12){
                    gananciasMejillonesEscabeche+=PRECIO_MEJILLONES_ESCABECHE;
                    mejillones++;
                }
                else{
                    System.out.println("Error");
                }
            }
            else if(producto==2){
                System.out.println("Introduce el tipo de la lata 3: (21) atún en aceite de girasol, (22) atún en aceite de oliva");
                tipo=Integer.parseInt(sc.nextLine());
                if(tipo==21){
                    gananciasAtunGirasol+=PRECIO_ATUN_GIRASOL;
                    atun++;
                }
                else if(tipo==22){
                    gananciasAtunOliva+=PRECIO_ATUN_OLIVA;
                    atun++;
                }
                else{
                    System.out.println("Error");
                }
            }
            else{
                System.out.println("Error");
            }
        }
        sc.close();

        System.out.println();
        System.out.println("Las ganancias por la venta de las latas de mejillones al natural será de "+gananciasMejillones+" euros\n" +
                        "Las ganancias por la venta de las latas de mejillones en escabeche será de "+gananciasMejillonesEscabeche+" euros\n" +
                        "Las ganancias por la venta de las latas de atún en aceite de girasol será de "+gananciasAtunGirasol+" euros\n" +
                        "Las ganancias por la venta de las latas de atún en aceite de oliva será de "+gananciasAtunOliva+" euros\n"
        );

        System.out.println("Se han procesado: \n" +
                        "\t"+mejillones+" latas de mejillones\n" +
                        "\t"+atun+" latas de atún\n"
        );
    }
}
