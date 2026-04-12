package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.dam.model.DatosEncuestas;
import com.dam.model.Encuesta;
import com.dam.view.PConsultarEncuestas;
import com.dam.view.PRealizarEncuesta;
import com.dam.view.VPrincipalEncuestas;

public class ControladorEncuestas implements ActionListener {
	
	private VPrincipalEncuestas vpe;
	// Crear atributos que representen los paneles
	private PRealizarEncuesta pre;
	private PConsultarEncuestas pce;
	private DatosEncuestas datos;

	public ControladorEncuestas(VPrincipalEncuestas vpe, PRealizarEncuesta pre, 
			PConsultarEncuestas pce, DatosEncuestas datos) {
		this.vpe = vpe;
		this.pre = pre;
		this.pce = pce;
		this.datos = datos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JMenuItem) {
			
			if (e.getSource().equals(vpe.getMntmRealizar())) {
				vpe.cargarPanel(pre);
				
			} else if (e.getSource().equals(vpe.getMntmConsultar())) {
				vpe.cargarPanel(pce);
				
			}
			
		} else if (e.getSource() instanceof JButton) {
			
			if (e.getActionCommand().equals(PRealizarEncuesta.ACTION_COMMAND_GUARDAR)) {
				Encuesta encuesta = pre.obtenerDatos();
				
				if (encuesta != null) {
					datos.addEncuesta(encuesta);
					
					JOptionPane.showMessageDialog(pre, "Se ha almacenado la encuesta con éxito", 
							"Resultado de operación", 
							JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			} else if (e.getActionCommand().equals(PRealizarEncuesta.ACTION_COMMAND_LIMPIAR)) {
				pre.limpiarComponentes();
				
			} else if (e.getActionCommand().equals(PConsultarEncuestas.ACTION_COMMAND_VER)) {
				pce.mostrarEncuestas(datos.getListaEncuestas());
				
			}
			
		}

	}
	

}
