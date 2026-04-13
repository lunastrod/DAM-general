package com.dam.model;

public class Entidad {
    /* esto es un pojo que normalmente vas a rellenar con los datos de la vista*/
    String texto1;
    String texto2;
    String texto3;
    String texto4;
    int numero1;

    public Entidad(String texto1, String texto2, String texto3, String texto4, int numero1) {
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.texto3 = texto3;
        this.texto4 = texto4;
        this.numero1 = numero1;
    }

    @Override
    public String toString() {
        return "Entidad [texto1=" + texto1 + ", texto2=" + texto2 + ", texto3=" + texto3 + ", texto4=" + texto4
                + ", numero1=" + numero1 + "]";
    }

}
