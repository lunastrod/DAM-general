package com.dam.model;

import java.util.ArrayList;

public class ListaEncuestas{
    ArrayList<Encuesta> lista;

    public ListaEncuestas() {
        this.lista = new ArrayList<>();
    }
    
    public void addEncuesta(Encuesta e){
        this.lista.add(e);
    }

    public void limpiarLista(){
        this.lista.clear();
    }

    public ArrayList<Encuesta> getLista(){
        return this.lista;
    }
}