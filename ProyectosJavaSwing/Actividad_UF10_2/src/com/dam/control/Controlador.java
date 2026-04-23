package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dam.model.ListaEntidad;
import com.dam.view.RegistraRestaurante;
import com.dam.view.ConsultaRestaurantes;
import com.dam.view.ModificaRestaurante;
import com.dam.view.VentanaPrincipal;

public class Controlador implements ActionListener {
    private VentanaPrincipal v;
    private ConsultaRestaurantes p1;
    private RegistraRestaurante p2;
    private ModificaRestaurante p3;
    private ListaEntidad m;

    public Controlador(VentanaPrincipal v, ConsultaRestaurantes p1,RegistraRestaurante p2, ModificaRestaurante p3, ListaEntidad m) {
        this.v = v;
        this.m = m;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public void actionPerformed(ActionEvent e) {
        String comando= e.getActionCommand();
        System.out.println(comando);
    }

}
