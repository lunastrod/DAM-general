package com.dam.control;

import com.dam.view.VEncuestador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dam.model.Encuesta;
import com.dam.model.ListaEncuestas;

public class EncuestadorControlador implements ActionListener{
    private VEncuestador v;
    private ListaEncuestas m;
    public EncuestadorControlador(VEncuestador v, ListaEncuestas m) {
        this.v = v;
        this.m = m;
    }

    private void guardarEncuesta(){
        Encuesta e=v.getEncuesta();
        if(e!=null){
            m.addEncuesta(e);
            v.mostrarMensaje("Encuesta guardada correctamente.");
            v.limpiaFormulario();
        }
    }

    private void verEncuestas(){
        v.mostrarListaEncuestas(m);
    }

    private void limpiarEncuestas(){
        m.limpiarLista();
        v.mostrarListaEncuestas(m);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(VEncuestador.TEXTO_BOTON_GUARDAR)){
            guardarEncuesta();
        }
        else if (e.getActionCommand().equals(VEncuestador.TEXTO_BOTON_LIMPIAR)){
            limpiarEncuestas();
        }
        else if (e.getActionCommand().equals(VEncuestador.TEXTO_BOTON_VER_ENCUESTAS)){
            verEncuestas();
        }
        else{
            v.mostrarError("Acción no reconocida");
        }
    }

}
