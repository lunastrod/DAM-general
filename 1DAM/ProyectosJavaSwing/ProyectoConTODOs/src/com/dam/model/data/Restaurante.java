package com.dam.model.data;

/*
15. El combo Región deberá contener las siguientes opciones:
Andalucía
Aragón
Asturias
Islas Baleares
Cantabria
Islas Canarias
Castilla - La Mancha
Castilla y León
Cataluña
Galicia
Extremadura
Madrid
Murcia
Navarra
País Vasco
La Rioja
Comunidad Valenciana
16. El combo Cocina deberá contener las siguientes opciones:
Creativa
Moderna
Tradicional
Regional
Fusión
*/

public class Restaurante {
    public static final String[] COLUMNAS = {"Nombre", "Ciudad", "Distinción", "Cocina", "Precio"};
    public static final String[] REGIONES = {
        "Andalucía", "Aragón", "Asturias", "Islas Baleares", "Cantabria", "Islas Canarias",
        "Castilla - La Mancha", "Castilla y León", "Cataluña", "Galicia", "Extremadura",
        "Madrid", "Murcia", "Navarra", "País Vasco", "La Rioja", "Comunidad Valenciana"
    };
    public static final String[] COCINAS = {
        "Creativa", "Moderna", "Tradicional", "Regional", "Fusión"
    };

    private int id;
    private String nombre;
    private String region;
    private String ciudad;
    private int distincion;
    private String direccion;
    private double precioMinimo;
    private double precioMaximo;
    private String cocina;
    private String telefono;
    private String web;

    public Restaurante(int id, String nombre, String region, String ciudad, int distincion, String direccion,
            double precioMinimo, double precioMaximo, String cocina, String telefono, String web) {
        this.id = id;
        this.nombre = nombre;
        this.region = region;
        this.ciudad = ciudad;
        this.distincion = distincion;
        this.direccion = direccion;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
        this.cocina = cocina;
        this.telefono = telefono;
        this.web = web;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getRegion() {
        return region;
    }
    public String getCiudad() {
        return ciudad;
    }
    public int getDistincion() {
        return distincion;
    }
    public String getDireccion() {
        return direccion;
    }
    public double getPrecioMinimo() {
        return precioMinimo;
    }
    public double getPrecioMaximo() {
        return precioMaximo;
    }
    public String getCocina() {
        return cocina;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getWeb() {
        return web;
    }

    public String[] getFila(){
        String[] fila = new String[5];
        fila[0]=nombre;
        fila[1]=ciudad;
        fila[2]="";
        for(int i=0;i<distincion;i++){
            fila[2]+="★";
        }
        fila[3]=cocina;
        if(precioMaximo==0){
            fila[4]=String.valueOf(precioMinimo);
        }
        else{
            fila[4]=precioMinimo+" - "+precioMaximo;
        }
        return fila;
    }

    @Override
    public String toString() {
        return "Restaurante [id=" + id + ", nombre=" + nombre + ", region=" + region + ", ciudad=" + ciudad
                + ", distincion=" + distincion + ", direccion=" + direccion + ", precioMinimo=" + precioMinimo
                + ", precioMaximo=" + precioMaximo + ", cocina=" + cocina + ", telefono=" + telefono + ", web=" + web
                + "]";
    }




}
