package com.dam.control;

import com.dam.model.Encuesta;
import com.dam.model.ListaEncuestas;
import com.dam.view.PAddEncuesta;
import com.dam.view.PVerEncuestas;
import com.dam.view.VPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncuestadorControlador implements ActionListener{
    private VPrincipal v;
    
    private ListaEncuestas m;

    public EncuestadorControlador(VPrincipal v, ListaEncuestas m) {
        this.v = v;
        this.m = m;
    }

    public void actionPerformed(ActionEvent e) {
        String comando= e.getActionCommand();
        if(comando.equals(VPrincipal.REALIZAR_ENCUESTA)){
            v.cargarPanel(v.getPAddEncuesta());
        }
        else if(comando.equals(VPrincipal.VISUALIZAR_ENCUESTAS)){
            v.getPVerEncuestas().mostrarEncuestas(m);
            if(m.getEncuestas().size()>0){
                v.getPVerEncuestas().mostrarBoton();
            }
            else{
                v.getPVerEncuestas().esconderBoton();
            }
            v.cargarPanel(v.getPVerEncuestas());

        }else if(comando.equals(PAddEncuesta.BTN_ADD_PRODUCTO)){
            Encuesta encuesta = v.getPAddEncuesta().getEncuesta();
            System.out.println(encuesta);
            m.addEncuesta(encuesta);
            v.getPAddEncuesta().limpiarFormulario();
            v.getPAddEncuesta().mostrarMensaje("Encuesta añadida");
        }else if(comando.equals(PVerEncuestas.BTN_RESULTADOS)){
            v.getPVerEncuestas().mostrarResultados(m.analisis());
        }else{
            System.out.println("ERROR:"+comando);
        }
    }

}
