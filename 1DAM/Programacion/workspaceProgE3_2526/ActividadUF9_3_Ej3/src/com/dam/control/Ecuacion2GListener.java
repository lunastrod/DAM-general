package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dam.model.Ecuacion2G;
import com.dam.view.VEcuacion2G;

public class Ecuacion2GListener implements ActionListener {

	// crear atributos que representen las ventanas a las que el listener va a escuchar
	private VEcuacion2G v;
	
	public Ecuacion2GListener(VEcuacion2G v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// especificar qué va a ocurrir cuando se detecte un evento de tipo Action en la interfaz gráfica
		System.out.println("Se ha pulsado el botón");
		Ecuacion2G e2g = v.obtenerDatos();
		if (e2g != null) {
			Double[] soluciones = e2g.resolverEcuacion();
			v.mostrarSoluciones(soluciones);
		}
	}

}
