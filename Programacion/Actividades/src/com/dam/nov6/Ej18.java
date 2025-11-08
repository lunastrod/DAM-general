/*18. En una estación de esquí hay 15 personas esperando en fila para coger un telesilla.
 Para que un telesilla pueda salir deben haber subido 4 personas o alcanzar un peso mínimo de 150 kg. 
 Se debe solicitar el peso de las 15 personas que están esperando y después de que la persona 
 suba al telesilla indicar si “Debe subir otra persona” o “El telesilla puede salir ya”.
Si tras la última persona el telesilla no tiene un mínimo de 4 personas o no alcanza los
 150 kg de peso se deberá indicar "El telesilla no puede salir"
 */
package com.dam.nov6;
import java.util.Scanner;

public class Ej18 {
    private static final int N_PERS=15;
    private static final int MIN_PERS=4;
    private static final int MIN_KG=150;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int telesillaPers=0;
        int telesillaKg=0;
        int pesoPers=0;

        for(int i=0; i<N_PERS; i++){
            System.out.println("Introduzca peso de persona");
            pesoPers=Integer.parseInt(sc.nextLine());
            telesillaKg+=pesoPers;
            telesillaPers++;
            if(telesillaKg>MIN_KG || telesillaPers>MIN_PERS){
                System.out.println("El telesilla puede salir ya");
                System.out.println("telesilla con "+telesillaPers+" personas y con peso "+telesillaKg+"Kg");
                telesillaKg=0;
                telesillaPers=0;
            }else{
                System.out.println("Debe subir otra persona");
                System.out.println("telesilla con "+telesillaPers+" personas y con peso "+telesillaKg+"Kg");
            }
        }
        if(telesillaPers!=0){
            System.out.println("El telesilla no puede salir");
        }
        System.out.println("telesilla con "+telesillaPers+" personas y con peso "+telesillaKg+"Kg");
        sc.close();
    }
}
