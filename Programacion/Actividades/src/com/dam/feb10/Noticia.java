package com.dam.feb10;

public class Noticia {
    protected String titulo;
    protected String fecha;
    protected String estado;

    public static final String [] ESTADOS={"BORRADOR","PUBLICADA","ARCHIVADA"};
    public static final String [] TIPOS={"POLITICA","ECONOMIA","DEPORTES"};


    public Noticia(String titulo, String fecha){
        this.titulo=titulo;
        this.fecha=fecha;
        this.estado=ESTADOS[0];
    }

    public boolean cambiarEstado(){
        if(estado.equals(ESTADOS[0])){
            estado=ESTADOS[1];
        }else if(estado.equals(ESTADOS[1])){
            estado=ESTADOS[2];
        }else if(estado.equals(ESTADOS[2])){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Noticia other = (Noticia) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        return true;
    }

    public String toString(){
        return "Titulo: "+titulo+" Fecha: "+fecha+" Estado: "+estado;
    }



}
