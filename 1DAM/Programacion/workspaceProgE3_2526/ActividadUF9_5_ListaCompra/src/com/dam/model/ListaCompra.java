package com.dam.model;

import java.util.ArrayList;

public class ListaCompra {

	private ArrayList<Producto> listaProductos;
	
	public ListaCompra() {
		listaProductos = new ArrayList<Producto>();
	}
	
	public void addProducto(Producto producto) {
		listaProductos.add(producto);
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	
}
