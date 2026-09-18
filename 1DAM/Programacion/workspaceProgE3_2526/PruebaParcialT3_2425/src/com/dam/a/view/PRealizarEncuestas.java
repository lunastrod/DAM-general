package com.dam.a.view;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.dam.a.control.ControladorEncuestas;
import com.dam.a.model.Encuesta;

public class PRealizarEncuestas extends JPanel implements IPaneles {

	private static final int ANCHO = VPrincipalEncuestas.ANCHO 
			- VPrincipalEncuestas.insetsL - VPrincipalEncuestas.insetsR;
	private static final int ALTO = VPrincipalEncuestas.ALTO 
			- VPrincipalEncuestas.insetsT - VPrincipalEncuestas.insetsB 
			- VPrincipalEncuestas.menuH;
	
	public static final String AC_BTN_ADD = "Añadir Encuesta";
	
	public PRealizarEncuestas() {
		setSize(ANCHO, ALTO);
		
		crearComponentes();
	}
	
	private final ButtonGroup btngEdad = new ButtonGroup();
	private JRadioButton rdbtn517;
	private JRadioButton rdbtn1830;
	private JRadioButton rdbtn3140;
	private JRadioButton rdbtn4165;
	private JRadioButton rdbtn65;
	private JComboBox<String> cmbFrecuencia;
	private JCheckBox chckJdT;
	private JCheckBox chckV;
	private JCheckBox chckBB;
	private JCheckBox chckST;
	private JCheckBox chckECdlC;
	private JCheckBox chckDB;
	private JCheckBox chck7V;
	private JButton btnAddProducto;
	
	
	
	@Override
	public void crearComponentes() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Realizar encuesta");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(25, 20, 150, 25);
		add(lblTitulo);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(45, 55, 70, 14);
		add(lblEdad);
		
		rdbtn517 = new JRadioButton(Encuesta.RANGOS_EDAD[0]);
		btngEdad.add(rdbtn517);
		rdbtn517.setBounds(125, 53, 100, 20);
		rdbtn517.setSelected(true);
		add(rdbtn517);
		
		rdbtn1830 = new JRadioButton(Encuesta.RANGOS_EDAD[1]);
		btngEdad.add(rdbtn1830);
		rdbtn1830.setBounds(235, 53, 100, 20);
		add(rdbtn1830);
		
		rdbtn3140 = new JRadioButton(Encuesta.RANGOS_EDAD[2]);
		btngEdad.add(rdbtn3140);
		rdbtn3140.setBounds(345, 53, 100, 20);
		add(rdbtn3140);
		
		rdbtn4165 = new JRadioButton(Encuesta.RANGOS_EDAD[3]);
		btngEdad.add(rdbtn4165);
		rdbtn4165.setBounds(125, 80, 100, 20);
		add(rdbtn4165);
		
		rdbtn65 = new JRadioButton(Encuesta.RANGOS_EDAD[4]);
		btngEdad.add(rdbtn65);
		rdbtn65.setBounds(235, 80, 100, 20);
		add(rdbtn65);
		
		JLabel lblFrecuencia = new JLabel("Frecuencia:");
		lblFrecuencia.setBounds(45, 115, 80, 14);
		add(lblFrecuencia);
		
		cmbFrecuencia = new JComboBox<String>();
		DefaultComboBoxModel<String> cmbModel = new
		DefaultComboBoxModel<String>(Encuesta.FRECUENCIAS);
		cmbFrecuencia.setModel(cmbModel);
		cmbFrecuencia.setBounds(150, 113, 175, 20);
		add(cmbFrecuencia);
		
		JLabel lblSeries = new JLabel("Series:");
		lblSeries.setBounds(45, 150, 80, 14);
		add(lblSeries);
		
		chckJdT = new JCheckBox(Encuesta.SERIES[0]);
		chckJdT.setBounds(125, 148, 150, 22);
		add(chckJdT);
		
		chckV = new JCheckBox(Encuesta.SERIES[1]);
		chckV.setBounds(305, 148, 150, 22);
		add(chckV);
		
		chckBB = new JCheckBox(Encuesta.SERIES[2]);
		chckBB.setBounds(125, 175, 150, 22);
		add(chckBB);
		
		chckST = new JCheckBox(Encuesta.SERIES[3]);
		chckST.setBounds(305, 175, 150, 22);
		add(chckST);
		
		chckECdlC = new JCheckBox(Encuesta.SERIES[4]);
		chckECdlC.setBounds(125, 202, 175, 22);
		add(chckECdlC);
		
		chckECdlC = new JCheckBox(Encuesta.SERIES[5]);
		chckECdlC.setBounds(305, 202, 150, 22);
		add(chckECdlC);
		
		chckDB = new JCheckBox(Encuesta.SERIES[6]);
		chckDB.setBounds(125, 229, 150, 22);
		add(chckDB);
		
		chck7V = new JCheckBox(Encuesta.SERIES[7]);
		chck7V.setBounds(305, 229, 150, 22);
		add(chck7V);
		
		btnAddProducto = new JButton(AC_BTN_ADD);
		btnAddProducto.setBounds(225, 275, 150, 22);
		add(btnAddProducto);

	}

	@Override
	public void setControlador(ControladorEncuestas control) {
		btnAddProducto.addActionListener(control);

	}

	public Encuesta obtenerDatosEncuesta() {
		String rangoEdad = "";
		
		boolean continuar = true;
		Component[] arrayComponentes = getComponents();
		for (int i = 0; i < arrayComponentes.length && continuar; i++) {
			if (arrayComponentes[i] instanceof JRadioButton) {
				if (((JRadioButton) arrayComponentes[i]).isSelected()) {
					rangoEdad = ((JRadioButton) arrayComponentes[i]).getText();
					continuar = false;
				}
			} 
		}
		
		String frecuencia = (String) cmbFrecuencia.getSelectedItem();
		
		ArrayList<String> listaSeriesVistas = new ArrayList<String>();
		for (Component component : arrayComponentes) {
			if (component instanceof JCheckBox) {
				if (((JCheckBox) component).isSelected()) {
					listaSeriesVistas.add(((JCheckBox) component).getText());
				}
			}
		}
		
		return new Encuesta(rangoEdad, frecuencia, listaSeriesVistas);
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Resultado de la operación", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void limpiarEncuesta() {
		rdbtn517.setSelected(true);
		cmbFrecuencia.setSelectedIndex(0);
		
		Component[] arrayComponentes = getComponents();
		
		for (Component component : arrayComponentes) {
			if (component instanceof JCheckBox) {
				((JCheckBox) component).setSelected(false);
			}
		}
	}

}
