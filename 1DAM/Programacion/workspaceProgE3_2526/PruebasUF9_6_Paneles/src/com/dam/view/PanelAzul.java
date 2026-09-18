package com.dam.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.dam.control.ControladorPruebas;

public class PanelAzul extends JPanel {
	
	private static final int ANCHO = VentanaPrincipalPruebas.ANCHO - VentanaPrincipalPruebas.insetsL - VentanaPrincipalPruebas.insetsR;
	private static final int ALTO = VentanaPrincipalPruebas.ALTO 
			- VentanaPrincipalPruebas.insetsT - VentanaPrincipalPruebas.insetsB - VentanaPrincipalPruebas.menuH;
	
	public static final String ACTION_COMMAND_SALUDAR = "Saludar";
	
	private JButton btnSaludar;
	
	public PanelAzul() {
		setSize(ANCHO, ALTO);
		
		crearComponentes();
	}

	private void crearComponentes() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Este es el panel azul");
		lblTitulo.setForeground(Color.BLUE);
		lblTitulo.setBounds(25, 25, 150, 20);
		add(lblTitulo);
		
		JPanel pnlInterior = new JPanel();
		pnlInterior.setBackground(Color.BLUE);
		pnlInterior.setBounds(25, 60, 900, 300);
		add(pnlInterior);
		
		btnSaludar = new JButton(ACTION_COMMAND_SALUDAR);
		btnSaludar.setBounds(450, 375, 100, 20);
		add(btnSaludar);
		
		
	}
	
	public void setControlador(ControladorPruebas control) {
		btnSaludar.addActionListener(control);
	}

}
