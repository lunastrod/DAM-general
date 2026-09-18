package com.dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.dam.control.RestaurantesListener;
import com.dam.model.data.Restaurante;
import com.dam.model.data.Texto;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class PRegistrarRestaurante extends JPanel {

	private static final int ANCHO = VPRestaurantes.ANCHO
			- VPRestaurantes.insetsL - VPRestaurantes.insetsR;
	private static final int ALTO = VPRestaurantes.ALTO
			- VPRestaurantes.insetsT - VPRestaurantes.insetsB
			- VPRestaurantes.menuH;

	private JTextField txtCiudad;
	private JTextField txtNombre;
	private JSpinner spnDist;
	private JButton btnGuardarDatos;
	private JButton btnLimpiarDatos;
	private JLabel lblEstrellas;
	private JComboBox<String> cmbRegion;
	private DefaultComboBoxModel<String> dcbmReg;
	private JTextField txtPrecioMin;
	private JTextField txtPrecioMax;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtWeb;
	private JLabel lblCocina;
	private JComboBox<String> cmbCocina;
	private DefaultComboBoxModel<String> dcbmCoc;

	public PRegistrarRestaurante() {
		setSize(ANCHO, ALTO);
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		JLabel lblNombre = new JLabel(Texto.LBL_NOMBRE);
		lblNombre.setBounds(43, 70, 69, 20);
		add(lblNombre);

		JLabel lblCiudad = new JLabel(Texto.LBL_CIUDAD);
		lblCiudad.setBounds(360, 115, 69, 20);
		add(lblCiudad);

		JLabel lblRegion = new JLabel(Texto.LBL_REGION);
		lblRegion.setBounds(43, 115, 58, 20);
		add(lblRegion);

		JLabel lblRegistrar = new JLabel(Texto.LBL_TIT_REGISTRO);
		lblRegistrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistrar.setBounds(15, 16, 271, 20);
		add(lblRegistrar);

		txtNombre = new JTextField();
		txtNombre.setBounds(127, 67, 271, 26);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtCiudad = new JTextField();
		txtCiudad.setBounds(437, 112, 231, 26);
		add(txtCiudad);
		txtCiudad.setColumns(10);

		JLabel lblDistincion = new JLabel(Texto.LBL_DISTINCION);
		lblDistincion.setBounds(43, 205, 94, 20);
		add(lblDistincion);

		spnDist = new JSpinner();
		spnDist.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		spnDist.setBounds(139, 202, 42, 26);
		add(spnDist);

		cmbRegion = new JComboBox<String>();
		dcbmReg = new DefaultComboBoxModel<String>();
		// TODO: rellenar dcbmReg con las regiones del array Restaurante.REGIONES usando un bucle for
		cmbRegion.setModel(dcbmReg);
		cmbRegion.setBounds(116, 112, 212, 26);
		add(cmbRegion);

		btnGuardarDatos = new JButton(Texto.BTN_REGISTRAR);
		btnGuardarDatos.setBounds(175, 311, 153, 29);
		add(btnGuardarDatos);

		btnLimpiarDatos = new JButton(Texto.BTN_LIMPIAR);
		btnLimpiarDatos.setBounds(360, 311, 153, 29);
		add(btnLimpiarDatos);

		lblEstrellas = new JLabel(Texto.LBL_ESTRELLAS);
		lblEstrellas.setVisible(false);
		lblEstrellas.setBounds(196, 205, 69, 20);
		add(lblEstrellas);

		JLabel lblPrecioMin = new JLabel(Texto.LBL_PRECIO_MIN);
		lblPrecioMin.setBounds(298, 205, 125, 20);
		add(lblPrecioMin);

		JLabel lblPrecioMax = new JLabel(Texto.LBL_PRECIO_MAX);
		lblPrecioMax.setBounds(514, 205, 86, 20);
		add(lblPrecioMax);

		txtPrecioMin = new JTextField();
		txtPrecioMin.setBounds(430, 202, 69, 26);
		add(txtPrecioMin);
		txtPrecioMin.setColumns(10);

		txtPrecioMax = new JTextField();
		txtPrecioMax.setColumns(10);
		txtPrecioMax.setBounds(598, 202, 69, 26);
		add(txtPrecioMax);

		JLabel lblDireccion = new JLabel(Texto.LBL_DIRECCION);
		lblDireccion.setBounds(43, 160, 94, 20);
		add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(139, 157, 413, 26);
		add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblTelfono = new JLabel(Texto.LBL_TELEFONO);
		lblTelfono.setBounds(43, 250, 86, 20);
		add(lblTelfono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 247, 138, 26);
		add(txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblWeb = new JLabel(Texto.LBL_WEB);
		lblWeb.setBounds(308, 250, 58, 20);
		add(lblWeb);

		txtWeb = new JTextField();
		txtWeb.setBounds(367, 247, 301, 26);
		add(txtWeb);
		txtWeb.setColumns(10);

		lblCocina = new JLabel(Texto.LBL_COCINA);
		lblCocina.setBounds(430, 70, 69, 20);
		add(lblCocina);

		cmbCocina = new JComboBox<String>();
		dcbmCoc = new DefaultComboBoxModel<String>();
		// TODO: rellenar dcbmCoc con los tipos de cocina del array Restaurante.TIPOS_COCINA usando un bucle for
		cmbCocina.setModel(dcbmCoc);
		cmbCocina.setBounds(504, 67, 147, 26);
		add(cmbCocina);
	}

	public JButton getBtnGuardarDatos() {
		return btnGuardarDatos;
	}

	public JButton getBtnLimpiarDatos() {
		return btnLimpiarDatos;
	}

	public void limpiarDatos() {
		// TODO: vaciar todos los campos de texto con setText("")
		// TODO: resetear ambos combos al índice 0 con setSelectedIndex(0)
		// TODO: resetear el spinner a 1 con spnDist.setValue(1)
	}

	public void setControlador(RestaurantesListener controlador) {
		// TODO: registrar el controlador como ActionListener de btnGuardarDatos y btnLimpiarDatos
	}

	public Restaurante obtenerDatos() {
		Restaurante restaurante = null;

		// TODO: recuperar todos los valores de los campos del formulario:
		//       String nom = txtNombre.getText().trim()
		//       String reg = (String) cmbRegion.getSelectedItem()
		//       String ciu = txtCiudad.getText().trim()
		//       int dist   = (int) spnDist.getValue()
		//       String dir, sPrecMin, sPrecMax, coc, tel, web ...

		// TODO: validar que nom no está vacío --> JOptionPane de error y no construir el objeto
		// TODO: validar que ciu no está vacía --> JOptionPane de error y no construir el objeto
		// TODO: dentro de un try/catch(NumberFormatException):
		//       si sPrecMin no está vacío --> precMin = Double.parseDouble(sPrecMin)
		//       si sPrecMax no está vacío --> precMax = Double.parseDouble(sPrecMax)
		//       si precMax != 0 && precMin > precMax --> JOptionPane de error y no construir el objeto
		//       si todo es correcto --> restaurante = new Restaurante(-1, nom, reg, ciu, dist, dir, precMin, precMax, coc, tel, web)
		//       en el catch --> JOptionPane de error de formato numérico

		return restaurante;
	}

}
