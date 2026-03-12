package com.dam.mar12;

import java.awt.EventQueue;

public class ListaCompraMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                VListaCompra ventana=new VListaCompra();
                ventana.hacerVisible();
            }
        });
    }

}
