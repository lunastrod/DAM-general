package com.dam.view;

import com.dam.control.ControladorHipoteca;

public interface IVentanaHipoteca {
	
	public void configurarVentana();
	
	public void crearComponentes();
	
	public void setControlador(ControladorHipoteca ch);
	
	public void hacerVisible();

}
