package com.dam.control;

import com.dam.model.ListaCompra;
import com.dam.view.VListaCompra;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CEliminarProducto implements ActionListener {
    private ListaCompra modelo;
    private VListaCompra vista;

    public CEliminarProducto(ListaCompra modelo, VListaCompra vista){
        this.modelo=modelo;
        this.vista=vista;
    }

    // callback
    public void actionPerformed(ActionEvent e) {
        int i=vista.getProductoSeleccionado();
        if(i==-1){
            vista.mostrarError("Selecciona un producto");
        }
        else{
            modelo.eliminaProducto(i);
            vista.eliminaProducto(i);
        }
    }
}