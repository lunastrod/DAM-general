package com.dam.view;

import javax.swing.JFrame;

import com.dam.control.Controlador;

public class Ventana extends JFrame implements IVentana {
    //TODO: rellenar titulo, ancho y alto
    private static final String TITULO="Titulo";
    private static final int ANCHO=500;
    private static final int ALTO=500;

    public Ventana(){
        configurarVentana();
        crearComponentes();
    }

    public void configurarVentana(){
		setTitle(TITULO);
        setSize(ANCHO, ALTO);
        //TODO: configurar JFrame
    }
	
	public void crearComponentes(){
        //TODO: crear componentes
    }
	
	public void setControlador(Controlador ch){
        //TODO: configurar controlador (addActionListener)
    }
	
	public void hacerVisible(){
        this.setVisible(true);
    }

}
