package tren;

import java.io.Serializable;

public class Fabricante implements Serializable {

    // Atributos
    private int id;
    private String nombre;
    private String pais;
    private String ciudad;
    private int anioFundacion;
    private int numeroEmpleados;
    private String especialidad;
    private boolean activo;

    // Constructor
    public Fabricante(int id, String nombre, String pais, String ciudad,
                      int anioFundacion, int numeroEmpleados,
                      String especialidad, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.anioFundacion = anioFundacion;
        this.numeroEmpleados = numeroEmpleados;
        this.especialidad = especialidad;
        this.activo = activo;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPais() { return pais; }
    public String getCiudad() { return ciudad; }
    public int getAnioFundacion() { return anioFundacion; }
    public int getNumeroEmpleados() { return numeroEmpleados; }
    public String getEspecialidad() { return especialidad; }
    public boolean isActivo() { return activo; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPais(String pais) { this.pais = pais; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public void setAnioFundacion(int anioFundacion) { this.anioFundacion = anioFundacion; }
    public void setNumeroEmpleados(int numeroEmpleados) { this.numeroEmpleados = numeroEmpleados; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public void setActivo(boolean activo) { this.activo = activo; }

    // toString
    @Override
    public String toString() {
        return "Fabricante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", anioFundacion=" + anioFundacion +
                ", numeroEmpleados=" + numeroEmpleados +
                ", especialidad='" + especialidad + '\'' +
                ", activo=" + activo +
                '}';
    }
}