package actividadMultihilo;
/*
Se pretende simular la gestión de pedidos de una tienda en la
que tres personas preparan pedidos al mismo tiempo. Utilizar
tres nombres ficticios, por ejemplo, Susana, Pedro y Juan. El
encargado será el hilo principal del programa y tendrá que
esperar a que los tres acaben antes de cerrar. Es importante el
orden de preparación de los pedidos, por lo que, cada uno de
ellos debe tener asignada una prioridad diferente.

Se deben crear dos clases diferentes:
– Una clase que recibirá el nombre del empleado y se lo pasará al
constructor.
– Una clase para crear los objetos, cada uno de ellos con el nombre del/de la
trabajador/a.
– Cada empleado debe preparar 5 pedidos, indicando en cada pedido
realizado el nombre del/de la empleado/a y su prioridad. Al terminar de
prepararlos 5 pedidos indicará que ha finalizado su trabajo. Asignar
diferentes prioridades a cada empleado antes de comenzar.
– Antes de comenzar a preparar los pedidos hay que mostrar un mensaje de
apertura de la tienda.
– Una vez que hayan terminado de preparar los pedidos tod@s los
empleados hay que notificarlo mediante un único mensaje.
– Gestionar las posibles interrupciones que puedan ocurrir, de modo que no
se muestre error si esto sucede

*/

import java.util.Scanner;

public class Multihilo2Main {
    public static void main(String[] args) {
        //recibir nombre de empleado y pasarlo al constructor
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el nombre del empleado: ");
        String nombre1 = sc.nextLine();
        Multihilo2 empleado1 = new Multihilo2(nombre1, 1);
        empleado1.setPriority(1);

        System.out.println("Introduzca el nombre del empleado: ");
        String nombre2 = sc.nextLine();
        Multihilo2 empleado2 = new Multihilo2(nombre2, 2);
        empleado2.setPriority(2);

        System.out.println("Introduzca el nombre del empleado: ");
        String nombre3 = sc.nextLine();
        Multihilo2 empleado3 = new Multihilo2(nombre3, 3);
        empleado3.setPriority(3);

        sc.close();
        System.out.println("La tienda ha abierto.");
        empleado1.start();
        empleado2.start();
        empleado3.start();

        try {
            empleado1.join();
            empleado2.join();
            empleado3.join();
        } catch (InterruptedException e) {
            System.out.println("El proceso ha sido interrumpido.");
        }
        System.out.println("La tienda ha cerrado.");


    }
}
