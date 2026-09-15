package agregacion;
import java.util.ArrayList;

public class Taxi {
    private String marca;
    private String modelo;
    ArrayList<Pasajero> pasajeros;

    public Taxi(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.pasajeros = new ArrayList<>();
    }

    public void addPasajero(Pasajero p) {
        pasajeros.add(p);
    }

    public void eliminarPasajero(Pasajero p) {
        pasajeros.remove(p);
    }

    public void saludarPasajeros() {
        for (Pasajero p : pasajeros) {
            System.out.println("¡Hola " + p.getNombre() + " " + p.getApellido() + "!");
        }
    }
}
