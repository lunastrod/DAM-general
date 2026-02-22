package com.dam.feb10;

public class NoticiaDeportes extends Noticia{
    private String deporte;

    public NoticiaDeportes(String titulo, String fecha, String deporte) {
        super(titulo, fecha);
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return super.toString()+" Deporte: "+deporte;
    }
}
