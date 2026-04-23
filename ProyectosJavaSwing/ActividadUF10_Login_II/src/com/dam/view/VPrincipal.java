package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class VPrincipal extends JFrame {
	
	private static final int ANCHO = 600;
	private static final int ALTO = 400;
	
	public VPrincipal() {
		configurarVentana();
		
		crearComponentes();
	}

	private void crearComponentes() {
		getContentPane().setLayout(null);
		
		JLabel lblBienvenida = new JLabel("¡Bienvenido!, has accedido con éxito");
		lblBienvenida.setBounds(175, 180, 250, 20);
		getContentPane().add(lblBienvenida);	
		
	}

	private void configurarVentana() {
		setTitle("** Mi aplicación **");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(ANCHO, ALTO);
		centrarVentana();
	}
	
	private void centrarVentana() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

}
