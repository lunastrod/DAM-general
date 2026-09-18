package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.dam.model.data.Restaurante;
import com.dam.model.data.Texto;
import com.dam.model.db.RestaurantesDAO;
import com.dam.view.PConsultarRestaurantes;
import com.dam.view.PModificarRestaurante;
import com.dam.view.PRegistrarRestaurante;
import com.dam.view.VPRestaurantes;

public class RestaurantesListener implements ActionListener {

	private VPRestaurantes vp;
	private PConsultarRestaurantes pcr;
	private PRegistrarRestaurante prr;
	private PModificarRestaurante pmr;

	private RestaurantesDAO datosRestaurantes;

	public RestaurantesListener(VPRestaurantes vp, PConsultarRestaurantes pcr, PRegistrarRestaurante prr, PModificarRestaurante pmr, RestaurantesDAO datosRestaurantes) {
		this.vp = vp;
		this.pcr = pcr;
		this.prr = prr;
		this.pmr = pmr;
		this.datosRestaurantes = datosRestaurantes;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		System.out.println(ev.getActionCommand());

		if (ev.getSource() instanceof JMenuItem) {

			if (ev.getSource().equals(vp.getMntmConsulta())) {
				pcr.cargarCombo(datosRestaurantes.consultarRegiones());
				pcr.limpiarConsulta();
				pcr.configurarTabla();
				vp.cargarPanel(pcr);

			} else if (ev.getSource().equals(vp.getMntmAlta())) {
				vp.cargarPanel(prr);

			} else if (ev.getSource().equals(vp.getMntmSalir())) {
				// TODO: llamar a vp.confirmarSalida()

			} else {
				vp.cargarPanel(pmr);
			}

		} else if (ev.getSource() instanceof JButton) {

			if (ev.getSource().equals(pcr.getBtnConsultar())) {
				// TODO: llamar al método privado consultarRestaurantes()
				consultarRestaurantes();

			} else if (ev.getSource().equals(pcr.getBtnEliminar())) {
				// TODO: llamar al método privado eliminarRestaurante()

			} else if (ev.getSource().equals(prr.getBtnGuardarDatos())) {
				// TODO: llamar al método privado registrarRestaurante()

			} else if (ev.getSource().equals(prr.getBtnLimpiarDatos())) {
				// TODO: llamar a prr.limpiarDatos()

			} else if (ev.getSource().equals(pmr.getBtnBuscar())) {
				// TODO: llamar al método privado buscarRestaurante()

			} else if (ev.getSource().equals(pmr.getBtnGuardarDatos())) {
				// TODO: llamar al método privado modificarRestaurantes()

			} else if (ev.getSource().equals(pmr.getBtnCancelar())) {
				// TODO: llamar a pmr.limpiarDatos()
				// TODO: llamar a pmr.habilitarModif(false) para volver al estado inicial del panel
			}
		}
	}

	private void consultarRestaurantes() {
		String region=(String)pcr.getCmbRegion().getSelectedItem();
		// TODO: recuperar la distinción seleccionada del combo con pcr.getCmbDist().getSelectedItem()
		//       hacer cast a String
		String dist=(String)pcr.getCmbDist().getSelectedItem();

		ArrayList<Restaurante> lista = datosRestaurantes.consultarRestaurantes();
		if(lista.isEmpty()) {
			JOptionPane.showMessageDialog(vp, "No hay restaurantes", "Alerta", JOptionPane.WARNING_MESSAGE);
			pcr.setVisibleTabla(false);
		}
		else {
			pcr.cargarTabla(lista);
			pcr.setVisibleTabla(true);
		}
		
		
		// TODO: llamar a datosRestaurantes.selectRestaurantesFiltro(reg, dist)
		//       y guardar el resultado en un ArrayList<Restaurante>
		
		// TODO: si la lista no está vacía --> pcr.cargarTabla(lista) y pcr.setVisibleTabla(true)
		// TODO: si la lista está vacía    --> mostrar JOptionPane informativo y pcr.setVisibleTabla(false)

	}

	private void eliminarRestaurante() {
		// TODO: recuperar el nombre del registro seleccionado con pcr.getNombreRegSel()
		// TODO: si nom NO es null --> mostrar JOptionPane de confirmación (YES_NO_OPTION)
		//                            si el usuario confirma --> llamar a datosRestaurantes.deleteRestaurante(nom)
		//                                                       si resultado == 1 --> mensaje de éxito
		//                                                                         --> volver a llamar a consultarRestaurantes()
		// TODO: si nom ES null --> mostrar JOptionPane de error indicando que no hay nada seleccionado
	}

	private void registrarRestaurante() {
		// TODO: llamar a prr.obtenerDatos() para recuperar y validar los datos del formulario
		//       obtenerDatos() devuelve null si hay algún error de validación
		// TODO: si rest NO es null --> llamar a datosRestaurantes.insertRestaurante(rest)
		//                             si resultado == 1 --> mensaje de éxito y prr.limpiarDatos()
		//                             si resultado != 1 --> mensaje de error (nombre duplicado)
	}

	private void buscarRestaurante() {
		// TODO: recuperar el texto del campo nombre con pmr.getTxtNombre().getText().trim()
		// TODO: si nombre NO está vacío --> llamar a datosRestaurantes.selectRestauranteNombre(nombre)
		//                                  si restaurante != null --> pmr.cargarRestaurante(restaurante)
		//                                                         --> pmr.habilitarModif(true)
		//                                  si restaurante == null --> mensaje informativo (no encontrado)
		// TODO: si nombre ESTÁ vacío    --> mensaje de error (campo obligatorio)
	}

	private void modificarRestaurantes() {
		// TODO: llamar a pmr.obtenerDatos() para recuperar y validar los datos del formulario
		//       obtenerDatos() devuelve null si hay algún error de validación
		// TODO: si restaurante NO es null --> llamar a datosRestaurantes.updateRestaurante(restaurante)
		//                                    si resultado == 1 --> mensaje de éxito
	}

}
