package com.dam.feb10;

public class NoticiaPolitica extends Noticia{
    private String partido;
    public static final String [] PARTIDOS={"Partido Socialista Obrero Espanol", "Alianza Popular", "Izquierda Unida", "Centro Democratico Social"};

    public NoticiaPolitica(String titulo, String fecha, String partido) {
        super(titulo, fecha);
        this.partido = partido;
    }

    public String obtenerInicialesPartido(){
        String [] iniciales=partido.split(" ");
        for (int i = 0; i < iniciales.length; i++) {
            iniciales[i]=(Character.toString(iniciales[i].charAt(0))).toUpperCase();
        }
        return String.join("",iniciales);
    }

    public String toString(){
        return super.toString()+" Partido: "+partido+" Iniciales: "+obtenerInicialesPartido();
    }
}
