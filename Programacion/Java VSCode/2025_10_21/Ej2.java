import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        //Crea una clase, Ejercicio2, que solicite la cantidad de números enteros que se
        //van a introducir. A continuación, solicite los números enteros positivos e
        //imprima cuántos son múltiplos de 7 y cuántos divisores de 150.
        Scanner sc = new Scanner(System.in);
        int multiplos=0;
        int divisores=0;
        int nNums=Integer.parseInt(sc.nextLine());
        for(int i=0; i<nNums; i++){
            int n=Integer.parseInt(sc.nextLine());
            if(n%7==0){
                multiplos++;
            }
            if(150%n==0){
                divisores++;
            }
        }
        sc.close();
        System.out.println(multiplos+" "+divisores);

    }
}
