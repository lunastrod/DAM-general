package com.dam.view;

import com.dam.control.ControladorListaCompra;

public interface IVListaCompra {
	
	public void configurarVentana();
	
	public void crearComponentes();
	
	public void setControlador(ControladorListaCompra ch);
	
	public void hacerVisible();

}
