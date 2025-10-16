package com.dam.comparadores.pojo;



public class CampoFutbol {
    private String nombre;
    private double largo;//m
    private double ancho;//m
    private int capacidad;//espectadores

    private final int MIN_LARGO_OFICIAL=100;
    private final int MIN_ANCHO_OFICIAL=64;
    private final int MAX_LARGO_OFICIAL=110;
    private final int MAX_ANCHO_OFICIAL=75;


    public CampoFutbol(String nombre, double largo, double ancho, int capacidad){
        this.nombre=nombre;
        this.largo=largo;
        this.ancho=ancho;
        this.capacidad=capacidad;
        
    }
    public int getCapacidad(){
        return capacidad;
    }
    //-------------------------------------

    public double calculaArea(){
        return largo*ancho;
    }

    public double calculaPerimetro(){
        return 2*largo+2*ancho;
    }

    public boolean esOficial(){
        boolean result=true;
        if(largo<=MIN_LARGO_OFICIAL||largo>=MAX_LARGO_OFICIAL){
            result=false;
        }
        if(ancho<=MIN_ANCHO_OFICIAL||ancho>=MAX_ANCHO_OFICIAL){
            result=false;
        }
        return result;
    }

    //-------------------------------------

    public String toString(){
        return "Campo de futbol "+nombre+":\t"+largo+"m x "+ancho+"m\tcapacidad="+capacidad;
    }
}
