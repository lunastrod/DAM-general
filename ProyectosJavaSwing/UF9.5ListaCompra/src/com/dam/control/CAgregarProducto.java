package com.dam.control;


import com.dam.model.ListaCompra;
import com.dam.model.Producto;
import com.dam.view.VListaCompra;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CAgregarProducto implements ActionListener {
    private ListaCompra modelo;
    private VListaCompra vista;

    public CAgregarProducto(ListaCompra modelo, VListaCompra vista){
        this.modelo=modelo;
        this.vista=vista;
    }

    public void actionPerformed(ActionEvent e) {
        String n=vista.getNombre();
        int c=vista.getCantidad();
        if(n.length()==0){
            vista.mostrarError("Introduce nombre de producto");
        }
        else{
            vista.mostrarError("");
            String u=vista.getUnidadMedida();
            
            Producto p=new Producto(n,c,u);
            modelo.nuevoProducto(p);
            vista.nuevoProducto(p);
        }
    }
}