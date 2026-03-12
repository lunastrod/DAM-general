package com.dam.mar12;

import java.util.ArrayList;

/*
- necesitaremos una clase ListaCompra con un atributo listaProductos para
almacenar los productos que se vayan añadiendo desde la interfaz.
*/

public class ListaCompra {
    private ArrayList<Producto> listaProductos;

    public ListaCompra(){
        listaProductos=new ArrayList<>();
    }

    public void nuevoProducto(){
        //TODO
    }

    public void eliminaProducto(){
        //TODO
    }

    @Override
    public String toString() {
        String resultado="";
        resultado += "Lista de la compra:\n";
        for (Producto p : listaProductos) {
            resultado+=p.toString();
        }
        return resultado;
    }

    


}
