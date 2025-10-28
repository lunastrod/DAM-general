package com.dam.ejercicio2.pojo;

public class Libro {
    private String nombre;
    private int numPag;
    private int tamLetra;
    private static final int TIEMPO_PEQUE=8;
    private static final int TIEMPO_GRANDE=5;
    private static final int LETRA_PEQUE=1;
    private static final int LETRA_GRANDE=2;//esto lo haría con un enum pero constantes valen

    public Libro(String nombre, int numPag, int tamLetra){
        this.nombre=nombre;
        this.numPag=numPag;
        this.tamLetra=tamLetra;
    }

    public int getNumPag() {
        return numPag;
    }

    public int calcularTpoLectura(){
        if(tamLetra==LETRA_PEQUE){
            return TIEMPO_PEQUE*numPag;
        }
        if(tamLetra==LETRA_GRANDE){
            return TIEMPO_GRANDE*numPag;
        }
        return -1;
    }

    @Override
    public String toString() {
        String textoTam;
        if(tamLetra==LETRA_PEQUE){
            textoTam="pequeña";
        }else if(tamLetra==LETRA_GRANDE){
            textoTam="grande";
        }else{
            textoTam="error";
        }
        return nombre+" - "+numPag+" páginas con letra "+textoTam+".";
    }
}
