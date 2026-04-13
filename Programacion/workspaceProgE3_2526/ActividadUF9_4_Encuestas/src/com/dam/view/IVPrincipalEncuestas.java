package com.dam.view;

import javax.swing.JPanel;

import com.dam.control.ControladorEncuestas;

public interface IVPrincipalEncuestas {
	
	public void configurarVentana();
	
	public void crearComponentes();
	
	public void setControlador(ControladorEncuestas ce);
	
	public void hacerVisible();
	
	public void cargarPanel(JPanel panel);

}
