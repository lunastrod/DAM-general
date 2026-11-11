package actividadMultihilo;
/*
Crear un proceso que lance dos hilos.
Cada uno de ellos hace pausas de duración aleatoria de entre
10 y 500 ms, utilizando el método sleep de la clase Thread.
El hilo principal tiene que esperar a que finalicen los dos hilos
que ha lanzado, por lo que siempre terminará en último lugar.
Dado que, se va a pausar la ejecución de los dos hilos, durante
ese periodo de tiempo se podrían interrumpir. Si esto llegase a
pasar se debería lanzar la interrupción que la capture y
mostrar un mensaje.
*/

public class Multihilo1 extends Thread {
    public static void main(String[] args) {
        Multihilo1 hilo1 = new Multihilo1();
        Multihilo1 hilo2 = new Multihilo1();
        hilo1.start();
        hilo2.start();
        
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("El proceso ha sido interrumpido.");
        }
        System.out.println("El proceso ha finalizado.");
    }

    @Override
    public void run() {
        try {
            interrupt();
            Thread.sleep((int) (Math.random() * 490) + 10);
        } catch (InterruptedException e) {
            System.out.println("El hilo ha sido interrumpido.");
        }
    }
}
