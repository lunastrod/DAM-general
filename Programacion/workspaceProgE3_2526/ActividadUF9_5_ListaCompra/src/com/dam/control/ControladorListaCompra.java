package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.dam.model.ListaCompra;
import com.dam.model.Producto;
import com.dam.view.VListaCompra;

public class ControladorListaCompra implements ActionListener {

	private VListaCompra vlc;
	private ListaCompra datos;
		
	public ControladorListaCompra(VListaCompra vlc, ListaCompra datos) {
		super();
		this.vlc = vlc;
		this.datos = datos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			
			if (e.getActionCommand().equals(VListaCompra.BTN_ADD)) {
				aniadirProducto();
				
			} else if (e.getActionCommand().equals(VListaCompra.BTN_DEL)) {
				eliminarProducto();
				
			}
			
		}		

	}

	private void eliminarProducto() {
		int iProdSel = vlc.getIndiceProdSelec();
		
		if (iProdSel == -1) {
			// mostrar error
			// vlc.getLblError().setText("ERROR: Debe seleccionar el producto que desea eliminar");
			vlc.mostrarError("Debe seleccionar el producto que desea eliminar");
			
		} else {
			// mostrar mensaje de confirmación
			int respuesta = JOptionPane.showConfirmDialog(vlc, 
					"Se va a eliminar el producto seleccionado ¿Desea continuar?", 
					"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			
			if (respuesta == JOptionPane.YES_OPTION) {
				datos.getListaProductos().remove(iProdSel);
				vlc.mostrarLista(datos.getListaProductos());
				vlc.mostrarInfo("El producto se ha eliminado de la lista de la compra");
				vlc.getLblError().setText("");
			}
		}
			
		
	}

	private void aniadirProducto() {
		// pedimos a la ventana los datos del producto
		Producto prod = vlc.obtenerProducto();
		
		// si prod es distinto de null es porque los datos son válidos
		if (prod != null) {
			datos.addProducto(prod);
			
			// debemos visualizarlo en la lista de productos
			vlc.mostrarLista(datos.getListaProductos());
			vlc.mostrarInfo("El producto se ha añadido a la lista de la compra");
			
			// limpiar los componentes de la ventana
			vlc.limpiarComponentes();
			
		}
	}

}
