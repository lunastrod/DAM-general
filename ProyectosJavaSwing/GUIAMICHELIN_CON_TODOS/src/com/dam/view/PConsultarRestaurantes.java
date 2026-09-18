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

import com.dam.control.RestaurantesListener;
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
		dcbmDist.addElement(Texto.TODAS);
		for (int i = 0; i < Restaurante.DISTINCIONES.length; i++) {
			dcbmDist.addElement(Restaurante.DISTINCIONES[i]);
		}

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

		btnEliminar = new JButton(Texto.BTN_ELIMINAR);
		btnEliminar.setBounds(525, 360, 133, 29);
		btnEliminar.setVisible(false);
		btnEliminar.setEnabled(false);
		add(btnEliminar);
	}

	public void configurarTabla() {
		// TODO: crear el DefaultTableModel sobreescribiendo isCellEditable para que devuelva false
		//       (así las celdas no son editables por el usuario)
		dtmRestaurantes = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblRestaurantes.setModel(dtmRestaurantes);
		dtmRestaurantes.addColumn(Texto.CLM_NOMBRE);
		dtmRestaurantes.addColumn(Texto.CLM_CIUDAD);
		dtmRestaurantes.addColumn(Texto.CLM_COCINA);
		dtmRestaurantes.addColumn(Texto.CLM_PRECIO);
	}

	public void cargarTabla(ArrayList<Restaurante> listaRestaurante) {
		tblRestaurantes.clearSelection();
		dtmRestaurantes.getDataVector().clear();
		String[]fila=new String[5];
		for (Restaurante restaurante : listaRestaurante) {
			fila[0]=restaurante.getNombre();
			fila[1]=restaurante.getCiudad();
			fila[2]="";
			for (int i = 0; i < restaurante.getDistincion(); i++) {
				fila[2]+="*";
			}
			fila[3]=restaurante.getCocina();
			fila[4]=restaurante.getPrecioMin()+" - "+restaurante.getPrecioMax();
			dtmRestaurantes.addRow(fila);
		}
		System.out.println(dtmRestaurantes.getRowCount());
		tblRestaurantes.setModel(dtmRestaurantes);
	}

	public void setVisibleTabla(boolean b) {
		scrpRestaurantes.setVisible(b);
		lblListado.setVisible(b);
		btnEliminar.setVisible(b);
		btnEliminar.setEnabled(b);
	}

	public void cargarCombo(ArrayList<String> regiones) {
		dcbmReg.removeAllElements();
		dcbmReg.addElement(Texto.TODAS);
		dcbmReg.addAll(regiones);
	}

	public void limpiarConsulta(){
		tblRestaurantes.setVisible(false);
		cmbRegion.setSelectedIndex(0);
		cmbDist.setSelectedIndex(0);
	}

	public String getNombreRegSel() {
		// TODO: obtener la fila seleccionada con tblRestaurantes.getSelectedRow()
		//       si filaSel != -1 --> devolver (String) dtmRestaurantes.getValueAt(filaSel, 0)
		//       si filaSel == -1 --> devolver null (no hay nada seleccionado)
		int fila=tblRestaurantes.getSelectedRow();
		if(fila!=-1){
			return (String) dtmRestaurantes.getValueAt(fila, 0);
		}
		return null;
	}

	public void setControlador(RestaurantesListener controlador) {
		btnConsultar.addActionListener(controlador);
		btnEliminar.addActionListener(controlador);
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
