package com.dam.model;

import java.util.ArrayList;

public class ListaCompra {
    private ArrayList<Producto> listaProductos;

    public ListaCompra(){
        listaProductos=new ArrayList<>();
    }

    public void nuevoProducto(Producto p){
        listaProductos.add(p);
    }

    public void eliminaProducto(int i){
        listaProductos.remove(i);
    }

    @Override
    public String toString() {
        String resultado="";
        resultado += "Lista de la compra:\n";
        for (Producto p : listaProductos) {
            resultado+=p.toString()+"\n";
        }
        return resultado;
    }

    


}
