package com.dam.model;

import java.util.ArrayList;

public class ListaEntidad {
    ArrayList<Entidad> entidades;

    public ListaEntidad(){
        entidades = new ArrayList<Entidad>();
    }

    public ArrayList<Entidad> getEntidades() {
        return entidades;
    }

    public void add(Entidad e){
        entidades.add(e);
    }

    @Override
    public String toString() {
        String resultado="";
        for (Entidad entidad : entidades) {
            resultado += entidad.toString()+"\n";
        }
        return resultado;
    }
}
