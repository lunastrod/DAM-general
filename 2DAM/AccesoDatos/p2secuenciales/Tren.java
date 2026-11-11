
package p2secuenciales;

import java.io.Serializable;

public class Tren implements Serializable {

    private static final long serialVersionUID = 1L;

    // Atributos
    private String modelo;
    private int fabricante;
    private short numeroVagones;
    private int capacidadPasajeros;
    private double velocidadMaxima;
    private String tipoCombustible;
    private boolean borrado;

    // Constructor
    public Tren(String modelo, int fabricante, short numeroVagones,
                int capacidadPasajeros, double velocidadMaxima,
                String tipoCombustible, boolean borrado) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.numeroVagones = numeroVagones;
        this.capacidadPasajeros = capacidadPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.tipoCombustible = tipoCombustible;
        this.borrado = borrado;
    }

    // Getters
    public String getModelo() { return modelo; }
    public int getFabricante() { return fabricante; }
    public short getNumeroVagones() { return numeroVagones; }
    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public double getVelocidadMaxima() { return velocidadMaxima; }
    public String getTipoCombustible() { return tipoCombustible; }
    public boolean isBorrado() { return borrado; }

    // Setters
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setFabricante(int fabricante) { this.fabricante = fabricante; }
    public void setNumeroVagones(short numeroVagones) { this.numeroVagones = numeroVagones; }
    public void setCapacidadPasajeros(int capacidadPasajeros) { this.capacidadPasajeros = capacidadPasajeros; }
    public void setVelocidadMaxima(double velocidadMaxima) { this.velocidadMaxima = velocidadMaxima; }
    public void setTipoCombustible(String tipoCombustible) { this.tipoCombustible = tipoCombustible; }
    public void setBorrado(boolean borrado) { this.borrado = borrado; }

    // toString
    @Override
    public String toString() {
        return "Tren{" +
                "modelo='" + modelo + '\'' +
                ", fabricante=" + fabricante +
                ", numeroVagones=" + numeroVagones +
                ", capacidadPasajeros=" + capacidadPasajeros +
                ", velocidadMaxima=" + velocidadMaxima +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", borrado=" + borrado +
                '}';
    }
}

