/*Crea un paquete dam.ejercicio2 y dentro: (3 puntos)
- Crea una clase java Ejercicio2 que solicite 5 valores enteros e indique cuantos
divisores tiene cada uno de ellos sin contar con el 1 y él mismo.
Ejemplo:
Introduce el 1º número
32
32 tiene 4 divisores
Introduce el 2º número
41
41 tiene 0 divisores
Introduce el 3º número
14
14 tiene 2 divisores
Introduce el 4º número
67
67 tiene 0 divisores
Introduce el 5º número
80
80 tiene 8 divisores
Pista: Recuerda que podemos utilizar un bucle dentro de otro. */

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int contadorDivisores;
        for(int i=0; i<5; i++){
            System.out.println("Introduce el siguiente numero");
            n=Integer.parseInt(sc.nextLine());
            contadorDivisores=0;
            for(int j=2; j<n; j++){
                if(n%j==0){
                    contadorDivisores++;
                }
            }
            System.out.println(n+" tiene "+contadorDivisores+" divisores");
        }
        sc.close();
    }
}
