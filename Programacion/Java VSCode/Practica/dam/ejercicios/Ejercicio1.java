
/*Crea un paquete dam.ejercicio1 y dentro: (2 puntos)
- Crea una clase, Ejercicio1, que imprima por consola, usando un bucle, los 10
primeros términos de la serie 5 – 8 – 11 – 14 – 17 – 20 – 23 ..., que sean
múltiplos de 2 o 5.*/

public class Ejercicio1 {
    public static void main(String[] args) {
        int numerosImpresos=0;
        int n=5;
        while(numerosImpresos<10){
            if(n%2==0 || n%5==0){
                numerosImpresos++;
                System.out.println(n);
            }
            n+=3;
        }
    }
}
