package com.dam.control;

import com.dam.view.VAddEncuesta;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
    private VAddEncuesta v;
    //TODO: declarar modelo
    //private Modelo m;
    public Controlador() {
        //TODO: asignar modelo
        //this.m = m;
    }

    public Controlador(VAddEncuesta v) {
        this.v = v;
        //TODO: asignar modelo
        //this.m = m;
        v.setControlador(this);
    }

}
