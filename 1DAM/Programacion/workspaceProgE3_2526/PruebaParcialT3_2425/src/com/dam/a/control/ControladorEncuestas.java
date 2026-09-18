package com.dam.a.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.dam.a.model.DatosEncuestas;
import com.dam.a.model.Encuesta;
import com.dam.a.view.PRealizarEncuestas;
import com.dam.a.view.PVisualizarEncuestas;
import com.dam.a.view.VPrincipalEncuestas;

public class ControladorEncuestas implements ActionListener {
	
	private VPrincipalEncuestas vpe;
	private PRealizarEncuestas pre;
	private PVisualizarEncuestas pve;
	private DatosEncuestas datos;

	public ControladorEncuestas(VPrincipalEncuestas vpe, PRealizarEncuestas pre, PVisualizarEncuestas pve, DatosEncuestas datos) {
		this.vpe = vpe;
		this.pre = pre;
		this.pve = pve;
		this.datos = datos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		if (componente instanceof JMenuItem) {
			if (componente.equals(vpe.getMntmRealizar())) {
				vpe.cargarPanel(pre);
				
			} else if (componente.equals(vpe.getMntmVisualizar())) {
				if (datos.getListaEncuestas().isEmpty()) {
					pve.mostrarMensaje("No hay encuestas almacenadas");
					pve.hacerVisibleBtnVer(false);
				} else {
					pve.hacerVisibleBtnVer(true);
					pve.cargarEncuestas(datos.getListaEncuestas());
				}
				vpe.cargarPanel(pve);
				
			}
		} else if (componente instanceof JButton) {
			
			if (e.getActionCommand().equals(PRealizarEncuestas.AC_BTN_ADD)) {
				// recuperar los datos, guardarlos y dar feedback
				Encuesta enc = pre.obtenerDatosEncuesta();
				
				datos.addEncuesta(enc);
				
				pre.mostrarMensaje("Se ha guardado la encuesta con éxito");
				pre.limpiarEncuesta();
				
			} else if (e.getActionCommand().equals(PVisualizarEncuestas.AC_BTN_RESULTADOS)) {
				String analisis = datos.realizarAnalisis();
				pve.mostrarMensaje(analisis);
			}
			
		}

	}

}
