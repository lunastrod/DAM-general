package com.dam.a.view;

import javax.swing.JPanel;

import com.dam.a.control.ControladorEncuestas;

public interface IVPrincipalEncuestas {
	
	public void configurarVentana();
	
	public void crearComponentes();
	
	public void crearMenu();
	
	public void setControlador(ControladorEncuestas ce);
	
	public void hacerVisible();
	
	public void cargarPanel(JPanel panel);

}
