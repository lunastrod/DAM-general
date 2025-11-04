/*19. En un edificio hay 14 personas esperando en fila el ascensor, en el
ascensor caben hasta 6 personas o un máximo 500 kg de peso. Se debe
solicitar el peso de las 14 personas que están esperando y a cada persona,
antes de subir al ascensor, indicarle si “Puede entrar en el ascensor” o
“Debe esperar al siguiente”. (A la persona a la que se le dice que Debe
esperar al siguiente se supone que entra directamente al siguiente
ascensor)
Tras la última persona se informará de cuántas personas y cuánto peso
sumaban en el último ascensor. */

package com.dam.nov4;

import java.util.Scanner;

public class Ej19 {
    //me dan ganas de hacer clase persona y clase ascensor aunque no haga falta
    private static final int N_PERS=14;
    private static final double PESO_MAX_ASCENS=500;
    private static final int N_PERS_MAX_ASCENS=6;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double pesoPers=-1;
        double pesoAscensor=0;
        int persAscensor=0;

        for(int pers=0; pers<N_PERS; pers++){
            System.out.println("Introduzca peso persona "+pers+":\t");
            pesoPers=Double.parseDouble(sc.nextLine());

            if(pesoAscensor+pesoPers<PESO_MAX_ASCENS && persAscensor<N_PERS_MAX_ASCENS){
                System.out.println("Puede entrar en el ascensor");
                pesoAscensor+=pesoPers;
                persAscensor++;
            }
            else{
                System.out.println("Debe esperar al siguiente");
                System.out.println("ascensor subiendo con "+persAscensor+ " personas y peso "+pesoAscensor+"kg");
                pesoAscensor=pesoPers;
                persAscensor=1;
            }
        }
        System.out.println("ultimo ascensor subiendo con "+persAscensor+ " personas y peso "+pesoAscensor+"kg");
        sc.close();
    }

}
