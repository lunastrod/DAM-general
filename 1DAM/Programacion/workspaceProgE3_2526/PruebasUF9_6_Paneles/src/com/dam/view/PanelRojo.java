package com.dam.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelRojo extends JPanel {
	
	private static final int ANCHO = VentanaPrincipalPruebas.ANCHO 
			- VentanaPrincipalPruebas.insetsL - VentanaPrincipalPruebas.insetsR;
	private static final int ALTO = VentanaPrincipalPruebas.ALTO 
			- VentanaPrincipalPruebas.insetsT - VentanaPrincipalPruebas.insetsB 
			- VentanaPrincipalPruebas.menuH;
	
	public static final String ACTION_COMMAND_PROBAR = "Probar";
	
	private JButton btnProbar;
	
	public PanelRojo() {
		setSize(ANCHO, ALTO);
		
		crearComponentes();
	}

	private void crearComponentes() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Este es el panel rojo");
		lblTitulo.setForeground(Color.RED);
		lblTitulo.setBounds(25, 25, 150, 20);
		add(lblTitulo);
		
		JPanel pnlInterior = new JPanel();
		pnlInterior.setBackground(Color.RED);
		pnlInterior.setBounds(25, 60, 900, 300);
		add(pnlInterior);
		
		btnProbar = new JButton(ACTION_COMMAND_PROBAR);
		btnProbar.setBounds(450, 375, 100, 20);
		add(btnProbar);
		
		
	}

}
