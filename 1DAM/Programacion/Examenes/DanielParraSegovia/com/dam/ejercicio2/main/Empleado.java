package com.dam.ejercicio2.main;

public class Empleado {
    private static final int SALARIO_BASE=1200;
    private static final int AUMENTO_1=100;
    private static final int TRIENIOS_CAMBIO_AUMENTO=2;
    private static final int AUMENTO_2=150;
    
    private String nombre;
    private String dni;//string para poder guardar mezcla de numeros y letras
    private int numAnio;


    public Empleado(String nombre, String dni, int numAnio) {
        this.nombre = nombre;
        this.dni = dni;
        this.numAnio = numAnio;
    }

    public int calcularSalario(){
        int euros=SALARIO_BASE;
        int nTrienios=numAnio/3;//redondeado a la baja por defecto
        if(nTrienios<=TRIENIOS_CAMBIO_AUMENTO){
            euros+=AUMENTO_1*nTrienios;
        }else{
            //primero aumento los 2 primeros trienios
            euros+=AUMENTO_1*TRIENIOS_CAMBIO_AUMENTO;
            //aumento el resto de trienios
            euros+=AUMENTO_2*(nTrienios-TRIENIOS_CAMBIO_AUMENTO);
        }
        return euros;
    }

    public int getNumAnio() {
        return numAnio;
    }

    @Override
    public String toString() {
        return nombre+ " con dni: "+dni+"\nAntigüedad: "+numAnio+" años\nSalario: "+calcularSalario();
    }
}
