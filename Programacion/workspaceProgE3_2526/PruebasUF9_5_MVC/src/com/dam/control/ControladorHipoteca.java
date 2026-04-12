package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dam.model.DatosHipoteca;
import com.dam.view.VentanaHipoteca;

public class ControladorHipoteca implements ActionListener {

	// Definir atributos que represnten al modelo y a la 
	// interfaz gráfica
	private VentanaHipoteca vh; // view
	private DatosHipoteca dh;   // model
	
	public ControladorHipoteca(VentanaHipoteca vh) {
		this.vh = vh;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// implementar la actividad de la aplicación
		// 1. controlador pide a la ventana los datos de la hipoteca
		dh = vh.getDatosHipoteca();
		
		// 2. comprobar que lo datos sean correctos
		if (dh != null) {
			// 3. pedimos al model que realice el cálculo
			double cuotaM = dh.calcularCuota();
			// 4. pedimos a la ventana que muestre el resultado
			vh.mostrarCuota(cuotaM);
		}

	}

}
