package com.dam.model;

public class Album {
    private String titulo;
    private String autor;
    private int publicacion;
    private String genero;
    private int millonesCopias;

    public Album(String titulo, String autor, int publicacion, String genero, int millonesCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.genero = genero;
        this.millonesCopias = millonesCopias;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getMillonesCopias() {
        return millonesCopias;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Título: ").append(titulo);
        sb.append(" - ").append(autor).append(", ");
        sb.append("Año de publicación: ").append(publicacion).append(", ");
        sb.append("Género: ").append(genero).append("\n");
        sb.append("Número aproximado de copias vendidas: ").append(millonesCopias).append(".0 M copias");
        return sb.toString();
    }

}
