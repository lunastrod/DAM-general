package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.dam.model.Entidad;
import com.dam.model.ListaEntidad;
import com.dam.view.PanelMostrar;
import com.dam.view.PanelSolicitar;
import com.dam.view.VentanaPrincipal;

public class Controlador implements ActionListener {
    private VentanaPrincipal v;
    private PanelSolicitar p1;
    private PanelMostrar p2;
    private ListaEntidad m;
    //TODO añadir paneles

    public Controlador(VentanaPrincipal v, PanelSolicitar p1,PanelMostrar p2, ListaEntidad m) {
        this.v = v;
        this.m = m;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void actionPerformed(ActionEvent e) {
        String comando= e.getActionCommand();
        System.out.println(comando);
        if(comando.equals(VentanaPrincipal.COMANDO_MENU1)){
            v.cargarPanel(p1);
        }
        else if(comando.equals(VentanaPrincipal.COMANDO_MENU2)){
            v.cargarPanel(p2);
        }
        else if(comando.equals(PanelMostrar.COMANDO_BTN1)){
            Entidad ent=p2.leerValores();
            m.add(ent);
            JOptionPane.showMessageDialog(v, m.toString());
        }
        else if(comando.equals(PanelSolicitar.COMANDO_BTN2)){
            p1.escribirTextArea(m.toString());
        }
    }

}
