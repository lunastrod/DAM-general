package com.dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.dam.control.Controlador;
import com.dam.model.data.Restaurante;
import com.dam.model.data.Texto;

public class PConsultarRestaurantes extends JPanel {

	private static final int ANCHO = VPRestaurantes.ANCHO
			- VPRestaurantes.insetsL - VPRestaurantes.insetsR;
	private static final int ALTO = VPRestaurantes.ALTO
			- VPRestaurantes.insetsT - VPRestaurantes.insetsB
			- VPRestaurantes.menuH;

	private JTable tblRestaurantes;
	private JComboBox<String> cmbRegion;
	private JComboBox<String> cmbDist;
	private JButton btnConsultar;
	private JScrollPane scrpRestaurantes;
	private DefaultComboBoxModel<String> dcbmDist;
	private DefaultComboBoxModel<String> dcbmReg;
	private JButton btnEliminar;
	private JLabel lblListado;
	private DefaultTableModel dtmRestaurantes;

	public PConsultarRestaurantes() {
		setSize(ANCHO, ALTO);
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		JLabel lblConsulta = new JLabel(Texto.LBL_TIT_CONSULTA);
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConsulta.setBounds(15, 16, 300, 20);
		add(lblConsulta);

		JLabel lblFiltro = new JLabel(Texto.LBL_FILTRO);
		lblFiltro.setBounds(35, 52, 149, 20);
		add(lblFiltro);

		JLabel lblRegion = new JLabel(Texto.LBL_REGION);
		lblRegion.setBounds(61, 85, 64, 20);
		add(lblRegion);

		JLabel lblCocina = new JLabel(Texto.LBL_DISTINCION);
		lblCocina.setBounds(400, 85, 69, 20);
		add(lblCocina);

		cmbRegion = new JComboBox<String>();
		dcbmReg = new DefaultComboBoxModel<String>();
		cmbRegion.setModel(dcbmReg);
		cmbRegion.setBounds(140, 82, 212, 26);
		add(cmbRegion);

		cmbDist = new JComboBox<String>();
		dcbmDist = new DefaultComboBoxModel<String>();
		// TODO: añadir "TODAS" al modelo del combo de distinción con dcbmDist.addElement(Texto.TODAS)
		// TODO: añadir las distinciones del array Restaurante.DISTINCIONES con un bucle for
		cmbDist.setModel(dcbmDist);
		cmbDist.setBounds(484, 82, 140, 26);
		add(cmbDist);

		btnConsultar = new JButton(Texto.BTN_CONSULTAR);
		btnConsultar.setBounds(525, 125, 133, 29);
		add(btnConsultar);

		lblListado = new JLabel(Texto.LBL_LISTADO);
		lblListado.setVisible(false);
		lblListado.setBounds(35, 134, 218, 20);
		add(lblListado);

		scrpRestaurantes = new JScrollPane();
		scrpRestaurantes.setVisible(false);
		scrpRestaurantes.setBounds(61, 169, 597, 175);
		add(scrpRestaurantes);

		tblRestaurantes = new JTable();
		tblRestaurantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrpRestaurantes.setViewportView(tblRestaurantes);

		// TODO: llamar a configurarTabla()

		btnEliminar = new JButton(Texto.BTN_ELIMINAR);
		btnEliminar.setBounds(525, 360, 133, 29);
		btnEliminar.setVisible(false);
		btnEliminar.setEnabled(false);
		add(btnEliminar);
	}

	private void configurarTabla() {
		// TODO: crear el DefaultTableModel sobreescribiendo isCellEditable para que devuelva false
		//       (así las celdas no son editables por el usuario)
		// TODO: asignar el modelo a la tabla con tblRestaurantes.setModel(dtmRestaurantes)
		// TODO: añadir las columnas al modelo con dtmRestaurantes.addColumn():
		//       Texto.CLM_NOMBRE, Texto.CLM_CIUDAD, Texto.CLM_DISTINCION, Texto.CLM_COCINA, Texto.CLM_PRECIO
		// TODO: ajustar el ancho preferido de cada columna con tblRestaurantes.getColumn(...).setPreferredWidth(...)
	}

	public void cargarTabla(ArrayList<Restaurante> listaRestaurante) {
		// TODO: limpiar la selección con tblRestaurantes.clearSelection()
		// TODO: limpiar las filas actuales con dtmRestaurantes.getDataVector().clear()
		// TODO: recorrer la lista con un for-each y por cada restaurante:
		//       - crear un Object[] fila de 5 posiciones
		//       - fila[0] = nombre, fila[1] = ciudad
		//       - fila[2] = distinción en estrellas (bucle que añade "*" tantas veces como distincion)
		//       - fila[3] = cocina
		//       - fila[4] = precio (precioMin, y si precioMax > 0 añadir " - " + precioMax)
		//       - añadir la fila al modelo con dtmRestaurantes.addRow(fila)
	}

	public void setVisibleTabla(boolean b) {
		// TODO: hacer visibles o invisibles los componentes asociados a que haya datos:
		//       scrpRestaurantes, lblListado, btnEliminar (visible y enabled)
	}

	public void cargarCombo(ArrayList<String> regiones) {
		// TODO: limpiar el modelo del combo con dcbmReg.removeAllElements()
		// TODO: añadir "TODAS" con dcbmReg.addElement(Texto.TODAS)
		// TODO: añadir todas las regiones de la lista con dcbmReg.addAll(regiones)
	}

	public void limpiarConsulta() {
		// TODO: ocultar la tabla con setVisibleTabla(false)
		// TODO: resetear ambos combos al índice 0 con setSelectedIndex(0)
	}

	public String getNombreRegSel() {
		// TODO: obtener la fila seleccionada con tblRestaurantes.getSelectedRow()
		//       si filaSel != -1 --> devolver (String) dtmRestaurantes.getValueAt(filaSel, 0)
		//       si filaSel == -1 --> devolver null (no hay nada seleccionado)
		return null;
	}

	public void setControlador(Controlador controlador) {
		// TODO: registrar el controlador como ActionListener de btnConsultar y btnEliminar
	}

	public JButton getBtnConsultar() {
		return btnConsultar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JTable getTblRestaurantes() {
		return tblRestaurantes;
	}

	public DefaultTableModel getDtmRestaurantes() {
		return dtmRestaurantes;
	}

	public JComboBox<String> getCmbDist() {
		return cmbDist;
	}

	public JComboBox<String> getCmbRegion() {
		return cmbRegion;
	}

}
