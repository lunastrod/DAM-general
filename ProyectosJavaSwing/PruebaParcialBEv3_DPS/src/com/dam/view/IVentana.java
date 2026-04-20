package com.dam.view;

import javax.swing.JPanel;

import com.dam.control.Controlador;

public interface IVentana {
	
	public void configurarVentana();
	public void crearComponentes();
	public void setControlador(Controlador c);
    public void cargarPanel(JPanel panel);
	public void hacerVisible();
}
