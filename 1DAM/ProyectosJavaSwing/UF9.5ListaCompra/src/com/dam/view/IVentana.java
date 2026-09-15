package com.dam.view;

import com.dam.control.CAgregarProducto;
import com.dam.control.CEliminarProducto;

public interface IVentana {
	
	public void configurarVentana();
	
	public void crearComponentes();
	
	public void setControlador(CAgregarProducto c);
	public void setControlador(CEliminarProducto c);
	
	public void hacerVisible();

}
