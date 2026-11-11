package tren;

import java.io.Serializable;

public class Tren implements Serializable {

    // Atributos
    private String modelo;
    private int fabricante;
    private short numeroVagones;
    private int capacidadPasajeros;
    private double velocidadMaxima;
    private double velocidadActual;
    private String tipoCombustible;
    private boolean enMarcha;

    // Constructor
    public Tren(String modelo, int fabricante, short numeroVagones,
                int capacidadPasajeros, double velocidadMaxima,
                double velocidadActual, String tipoCombustible,
                boolean enMarcha) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.numeroVagones = numeroVagones;
        this.capacidadPasajeros = capacidadPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = velocidadActual;
        this.tipoCombustible = tipoCombustible;
        this.enMarcha = enMarcha;
    }

    // Getters
    public String getModelo() { return modelo; }
    public int getFabricante() { return fabricante; }
    public short getNumeroVagones() { return numeroVagones; }
    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public double getVelocidadMaxima() { return velocidadMaxima; }
    public double getVelocidadActual() { return velocidadActual; }
    public String getTipoCombustible() { return tipoCombustible; }
    public boolean isEnMarcha() { return enMarcha; }

    // Setters
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setFabricante(int fabricante) { this.fabricante = fabricante; }
    public void setNumeroVagones(short numeroVagones) { this.numeroVagones = numeroVagones; }
    public void setCapacidadPasajeros(int capacidadPasajeros) { this.capacidadPasajeros = capacidadPasajeros; }
    public void setVelocidadMaxima(double velocidadMaxima) { this.velocidadMaxima = velocidadMaxima; }
    public void setVelocidadActual(double velocidadActual) { this.velocidadActual = velocidadActual; }
    public void setTipoCombustible(String tipoCombustible) { this.tipoCombustible = tipoCombustible; }
    public void setEnMarcha(boolean enMarcha) { this.enMarcha = enMarcha; }

    // toString
    @Override
    public String toString() {
        return "Tren{" +
                "modelo='" + modelo + '\'' +
                ", fabricante=" + fabricante +
                ", numeroVagones=" + numeroVagones +
                ", capacidadPasajeros=" + capacidadPasajeros +
                ", velocidadMaxima=" + velocidadMaxima +
                ", velocidadActual=" + velocidadActual +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", enMarcha=" + enMarcha +
                '}';
    }
}

