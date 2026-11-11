package actividadMultihilo;

public class Multihilo2 extends Thread{
    String empleado;
    int pedidosNecesarios = 5;
    int prioridad;
    public Multihilo2(String empleado, int prioridad) {
        this.empleado = empleado;
        this.prioridad = prioridad;
    }

    public void prepararPedidos(String empleado, int prioridad) {
        System.out.println("El empleado " + empleado + " ha empezado a preparar los pedidos.");
        for (int i = 0; i < pedidosNecesarios; i++) {
            System.out.println("El empleado " + empleado + " ha preparado el pedido " + i + " con prioridad " + prioridad);
            /*try {
                Thread.sleep((int) (Math.random() * 490) + 10);
            } catch (InterruptedException e) {
                System.out.println("El hilo ha sido interrumpido.");
            }*/
        }
        System.out.println("El empleado " + empleado + " ha terminado de preparar los pedidos.");
    }

    public void run() {
        prepararPedidos(empleado, prioridad);
    }

}
