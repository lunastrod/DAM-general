package com.dam.feb10;

public class NoticiaEconomia extends Noticia{
    private String sector;

    public NoticiaEconomia(String titulo, String fecha, String sector) {
        super(titulo, fecha);
        this.sector = sector;
    }

    @Override
    public String toString() {
        return super.toString()+" Sector: "+sector;
    }

}
