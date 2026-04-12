package com.dam.view;

import javax.swing.JPanel;

import com.dam.control.ControladorEncuestas;
import com.dam.model.Encuesta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

public class PRealizarEncuesta extends JPanel implements IPaneles {

	private static final int ANCHO = VPrincipalEncuestas.ANCHO 
			- VPrincipalEncuestas.insetsL - VPrincipalEncuestas.insetsR;
	private static final int ALTO = VPrincipalEncuestas.ALTO 
			- VPrincipalEncuestas.insetsT - VPrincipalEncuestas.insetsB 
			- VPrincipalEncuestas.menuH;
	public static final String ACTION_COMMAND_GUARDAR = "Guardar";
	public static final String ACTION_COMMAND_LIMPIAR = "Limpiar";
	
	private final ButtonGroup btngNiveles = new ButtonGroup();
	private JSpinner spnEdad;
	private JComboBox<String> cmbHaPasado;
	private JCheckBox chkbSintoma1;
	private JCheckBox chkbSintoma5;
	private JCheckBox chkbSintoma2;
	private JCheckBox chkbSintoma6;
	private JCheckBox chkbSintoma3;
	private JCheckBox chkbSintoma7;
	private JCheckBox chkbSintoma4;
	private JCheckBox chkbSintoma8;
	private JRadioButton rdbtnNivel1;
	private JRadioButton rdbtnNivel2;
	private JRadioButton rdbtnNivel3;
	private JRadioButton rdbtnNivel4;
	private JRadioButton rdbtnNivel5;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	
	public PRealizarEncuesta() {
		setSize(ANCHO, ALTO);
		
		crearComponentes();
	}
	
	@Override
	public void crearComponentes() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Realizar encuesta");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(35, 28, 331, 24);
		add(lblTitulo);
		
		JLabel lblEdad = new JLabel(Encuesta.PREGUNTAS[0]);
		lblEdad.setBounds(55, 73, 36, 14);
		add(lblEdad);
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(0, 0, 115, 1));
		spnEdad.setBounds(122, 70, 50, 20);
		add(spnEdad);
		
		JLabel lblHaPasado = new JLabel(Encuesta.PREGUNTAS[1]);
		lblHaPasado.setBounds(55, 119, 207, 14);
		add(lblHaPasado);
		
		cmbHaPasado = new JComboBox<String>();
		cmbHaPasado.setBounds(281, 115, 60, 22);
		add(cmbHaPasado);
		
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>(Encuesta.HA_PASADO_COVID_RESP);
		
		cmbHaPasado.setModel(dcbm);
		
		JLabel lblSintomas = new JLabel(Encuesta.PREGUNTAS[2]);
		lblSintomas.setBounds(55, 164, 176, 14);
		add(lblSintomas);
		
		chkbSintoma1 = new JCheckBox(Encuesta.POSIBLES_SINTOMAS[0]);
		chkbSintoma1.setBounds(74, 200, 176, 22);
		add(chkbSintoma1);
		
		chkbSintoma2 = new JCheckBox(Encuesta.POSIBLES_SINTOMAS[1]);
		chkbSintoma2.setBounds(74, 242, 139, 22);
		add(chkbSintoma2);
		
		chkbSintoma3 = new JCheckBox(Encuesta.POSIBLES_SINTOMAS[2]);
		chkbSintoma3.setBounds(74, 286, 139, 22);
		add(chkbSintoma3);
		
		chkbSintoma4 = new JCheckBox(Encuesta.POSIBLES_SINTOMAS[3]);
		chkbSintoma4.setBounds(74, 335, 139, 22);
		add(chkbSintoma4);
		
		chkbSintoma5 = new JCheckBox(Encuesta.POSIBLES_SINTOMAS[4]);
		chkbSintoma5.setBounds(287, 200, 139, 22);
		add(chkbSintoma5);
		
		chkbSintoma6 = new JCheckBox(Encuesta.POSIBLES_SINTOMAS[5]);
		chkbSintoma6.setBounds(287, 242, 139, 22);
		add(chkbSintoma6);
		
		chkbSintoma7 = new JCheckBox(Encuesta.POSIBLES_SINTOMAS[6]);
		chkbSintoma7.setBounds(287, 286, 139, 22);
		add(chkbSintoma7);
		
		chkbSintoma8 = new JCheckBox(Encuesta.POSIBLES_SINTOMAS[7]);
		chkbSintoma8.setBounds(287, 335, 139, 22);
		add(chkbSintoma8);
		
		JLabel lblNivelGravedad = new JLabel(Encuesta.PREGUNTAS[3]);
		lblNivelGravedad.setBounds(55, 383, 128, 14);
		add(lblNivelGravedad);
		
		rdbtnNivel1 = new JRadioButton(Encuesta.NIVELES_DE_GRAVEDAD[0] 
				+ " - " + Encuesta.NIVELES_DE_GRAVEDAD_S[0]);
		btngNiveles.add(rdbtnNivel1);
		rdbtnNivel1.setSelected(true);
		rdbtnNivel1.setBounds(42, 422, 110, 22);
		add(rdbtnNivel1);
		
		rdbtnNivel2 = new JRadioButton(Encuesta.NIVELES_DE_GRAVEDAD[1] 
				+ " - " + Encuesta.NIVELES_DE_GRAVEDAD_S[1]);
		btngNiveles.add(rdbtnNivel2);
		rdbtnNivel2.setBounds(194, 422, 110, 22);
		add(rdbtnNivel2);
		
		rdbtnNivel3 = new JRadioButton(Encuesta.NIVELES_DE_GRAVEDAD[2] 
				+ " - " + Encuesta.NIVELES_DE_GRAVEDAD_S[2]);
		btngNiveles.add(rdbtnNivel3);
		rdbtnNivel3.setBounds(346, 422, 110, 22);
		add(rdbtnNivel3);
		
		rdbtnNivel4 = new JRadioButton(Encuesta.NIVELES_DE_GRAVEDAD[3] 
				+ " - " + Encuesta.NIVELES_DE_GRAVEDAD_S[3]);
		btngNiveles.add(rdbtnNivel4);
		rdbtnNivel4.setBounds(81, 466, 110, 22);
		add(rdbtnNivel4);
		
		rdbtnNivel5 = new JRadioButton(Encuesta.NIVELES_DE_GRAVEDAD[4] 
				+ " - " + Encuesta.NIVELES_DE_GRAVEDAD_S[4]);
		btngNiveles.add(rdbtnNivel5);
		rdbtnNivel5.setBounds(272, 466, 147, 22);
		add(rdbtnNivel5);
		
		btnGuardar = new JButton(ACTION_COMMAND_GUARDAR);
		btnGuardar.setBounds(108, 518, 88, 22);
		add(btnGuardar);
		
		btnLimpiar = new JButton(ACTION_COMMAND_LIMPIAR);
		btnLimpiar.setBounds(304, 518, 88, 22);
		add(btnLimpiar);

	}

	@Override
	public void setControlador(ControladorEncuestas control) {
		btnGuardar.addActionListener(control);
		btnLimpiar.addActionListener(control);

	}

	public void limpiarComponentes() {
		spnEdad.setValue(0);
		cmbHaPasado.setSelectedIndex(0);
		
		chkbSintoma1.setSelected(false);
		chkbSintoma2.setSelected(false);
		chkbSintoma3.setSelected(false);
		chkbSintoma4.setSelected(false);
		chkbSintoma5.setSelected(false);
		chkbSintoma6.setSelected(false);
		chkbSintoma7.setSelected(false);
		chkbSintoma8.setSelected(false);
		
		rdbtnNivel1.setSelected(true);
		
	}

	public Encuesta obtenerDatos() {
		Encuesta en = null;
		
		int edad = (int) spnEdad.getValue();
		
		String haPasado = (String) cmbHaPasado.getSelectedItem();
		
		String sintomas = obtenerSintomas();
		
		int contS = sintomas.isEmpty()? 0 : 1;
		
		int nivelGravedad = obtenerNivelGravedad();
		
		if (haPasado.equals(Encuesta.HA_PASADO_COVID_RESP[1]) && contS > 0) {
			JOptionPane.showMessageDialog(this, 
					"Si no ha pasado el COVID no debería haber síntomas seleccionados",
					"Error de datos", JOptionPane.ERROR_MESSAGE);
		} else if (haPasado.equals(Encuesta.HA_PASADO_COVID_RESP[0]) && contS == 0) {
			JOptionPane.showMessageDialog(this, 
					"Si ha pasado el COVID debería seleccionar algún síntomas",
					"Error de datos", JOptionPane.ERROR_MESSAGE);
		} else if (haPasado.equals(Encuesta.HA_PASADO_COVID_RESP[1]) 
				&& nivelGravedad != Encuesta.NIVELES_DE_GRAVEDAD[0]) {
			JOptionPane.showMessageDialog(this, 
					"Si no ha pasado el COVID no debería tener un nivel de gravedad superior a " 
							+ Encuesta.NIVELES_DE_GRAVEDAD_S[0],
					"Error de datos", JOptionPane.ERROR_MESSAGE);
		} else {
			en = new Encuesta(edad, haPasado, sintomas, nivelGravedad);
		}
		
		return en;
	}

	private int obtenerNivelGravedad() {
		int nivelGravedad = Encuesta.NIVELES_DE_GRAVEDAD[0];
		if (rdbtnNivel2.isSelected()) {
			nivelGravedad = Encuesta.NIVELES_DE_GRAVEDAD[1];
			
		} else if (rdbtnNivel3.isSelected()) {
			nivelGravedad = Encuesta.NIVELES_DE_GRAVEDAD[2];
			
		} else if (rdbtnNivel4.isSelected()) {
			nivelGravedad = Encuesta.NIVELES_DE_GRAVEDAD[3];
			
		} else if (rdbtnNivel5.isSelected()) {
			nivelGravedad = Encuesta.NIVELES_DE_GRAVEDAD[4];
			
		}
		return nivelGravedad;
	}

	private String obtenerSintomas() {
		String sintomas = "";
		int contSint = 0;
		
		if (chkbSintoma1.isSelected()) {
			sintomas += chkbSintoma1.getText();
			contSint++;
		}
		
		if (chkbSintoma2.isSelected()) {
			if (contSint > 0) {
				sintomas += ", ";
			}
			sintomas += chkbSintoma2.getText();
			contSint++;
		}
		
		if (chkbSintoma3.isSelected()) {
			if (contSint > 0) {
				sintomas += ", ";
			}
			sintomas += chkbSintoma3.getText();
			contSint++;
		}
		
		if (chkbSintoma4.isSelected()) {
			if (contSint > 0) {
				sintomas += ", ";
			}
			sintomas += chkbSintoma4.getText();
			contSint++;
		}
		
		if (chkbSintoma5.isSelected()) {
			if (contSint > 0) {
				sintomas += ", ";
			}
			sintomas += chkbSintoma5.getText();
			contSint++;
		}
		
		if (chkbSintoma6.isSelected()) {
			if (contSint > 0) {
				sintomas += ", ";
			}
			sintomas += chkbSintoma6.getText();
			contSint++;
		}
		
		if (chkbSintoma7.isSelected()) {
			if (contSint > 0) {
				sintomas += ", ";
			}
			sintomas += chkbSintoma7.getText();
			contSint++;
		}
		
		if (chkbSintoma8.isSelected()) {
			if (contSint > 0) {
				sintomas += ", ";
			}
			sintomas += chkbSintoma8.getText();
			contSint++;
		}
		return sintomas;
	}
}
