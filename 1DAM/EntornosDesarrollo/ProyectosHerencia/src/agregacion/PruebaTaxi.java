package agregacion;

public class PruebaTaxi {
    public static void main(String[] args) {
        Taxi taxi = new Taxi("Toyota", "Corolla");
        Pasajero p1 = new Pasajero("Juan", "Pérez");
        Pasajero p2 = new Pasajero("María", "Gómez");

        taxi.addPasajero(p1);
        taxi.addPasajero(p2);

        taxi.saludarPasajeros();

        taxi.eliminarPasajero(p1);

        taxi.saludarPasajeros();
    }
}
