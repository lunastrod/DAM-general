package com.dam.view;

import com.dam.control.Controlador;

public interface IVentana {
	
	public void configurarVentana();
	
	public void crearComponentes();
	
	public void setControlador(Controlador ch);
	
	public void hacerVisible();

}
