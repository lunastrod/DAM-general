package com.dam.view;

import com.dam.control.EncuestadorControlador;

public interface IVentana {
	
	public void configurarVentana();
	
	public void crearComponentes();
	
	public void setControlador(EncuestadorControlador ch);
	
	public void hacerVisible();

}
