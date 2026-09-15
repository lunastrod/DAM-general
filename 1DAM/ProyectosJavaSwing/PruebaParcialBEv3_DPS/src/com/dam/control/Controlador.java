package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dam.model.DatosAlbumes;
import com.dam.view.PanelConsultar;
import com.dam.view.VentanaPrincipal;

public class Controlador implements ActionListener {
    private VentanaPrincipal v;
    private PanelConsultar p1;
    private DatosAlbumes m;

    public Controlador(VentanaPrincipal v, PanelConsultar p1, DatosAlbumes m) {
        this.v = v;
        this.m = m;
        this.p1 = p1;
    }

    public void actionPerformed(ActionEvent e) {
        String comando= e.getActionCommand();
        System.out.println(comando);
        if(comando.equals(VentanaPrincipal.MENU_CONSULTAR)){
            v.cargarPanel(p1);
        }
        else if(comando.equals(VentanaPrincipal.MENU_SALIR)){
            p1.mensajeSalir();
        }
        else if(comando.equals(PanelConsultar.AC_BTN_VER)){
            p1.escribirTextArea(m.toString());
            p1.mostrarBotonAnalisis(true);
        }
        else if(comando.equals(PanelConsultar.AC_BTN_ANALISIS)){
            p1.mostrarAnalisis(m.realizarAnalisis());
        }
    }

}
