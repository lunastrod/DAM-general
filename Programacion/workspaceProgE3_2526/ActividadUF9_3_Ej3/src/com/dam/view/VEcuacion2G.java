package com.dam.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.dam.control.Ecuacion2GListener;
import com.dam.model.Ecuacion2G;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VEcuacion2G extends JFrame {
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JButton btnResolver;
	private JLabel lblSolucion1;
	private JLabel lblSolucion2;
	
	public VEcuacion2G() {
		configurarVentana();
	}

	private void configurarVentana() {
		setTitle("Ejercicio3: Ecuación 2º grado");
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(350, 200);
		
		// provisional
		setLocationRelativeTo(null);
		
		crearComponentes();
	}

	private void crearComponentes() {
		getContentPane().setLayout(null);
		
		JLabel lblSolicitud = new JLabel("Introduce los términos de una ecuación de 2º grado");
		lblSolicitud.setBounds(16, 13, 300, 14);
		getContentPane().add(lblSolicitud);
		
		txtA = new JTextField();
		txtA.setBounds(16, 40, 34, 20);
		getContentPane().add(txtA);
		txtA.setColumns(10);
		
		JLabel lblX2 = new JLabel("x^2 +");
		lblX2.setBounds(66, 43, 41, 14);
		getContentPane().add(lblX2);
		
		txtB = new JTextField();
		txtB.setBounds(123, 40, 34, 20);
		getContentPane().add(txtB);
		txtB.setColumns(10);
		
		JLabel lblX = new JLabel("x +");
		lblX.setBounds(173, 43, 34, 14);
		getContentPane().add(lblX);
		
		txtC = new JTextField();
		txtC.setBounds(223, 40, 34, 20);
		getContentPane().add(txtC);
		txtC.setColumns(10);
		
		JLabel lblIgual = new JLabel("= 0");
		lblIgual.setBounds(273, 43, 41, 14);
		getContentPane().add(lblIgual);
		
		btnResolver = new JButton("Resolver");
		btnResolver.setBounds(123, 73, 88, 22);
		getContentPane().add(btnResolver);
		
		lblSolucion1 = new JLabel("");
		lblSolucion1.setBounds(20, 108, 275, 14);
		getContentPane().add(lblSolucion1);
		
		lblSolucion2 = new JLabel("");
		lblSolucion2.setBounds(20, 135, 275, 14);
		getContentPane().add(lblSolucion2);
			
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setListener(Ecuacion2GListener l) {
		btnResolver.addActionListener(l);
	}
	
	public Ecuacion2G obtenerDatos() {
		Ecuacion2G e2g = null;
		
		// recoger los valores y validarlos
		String sA, sB, sC;
		sA = txtA.getText();
		sB = txtB.getText();
		sC = txtC.getText();
		
		try {
			int a = Integer.parseInt(sA);
			int b = Integer.parseInt(sB);
			int c = Integer.parseInt(sC);
			
			e2g = new Ecuacion2G(a, b, c);
			
		} catch (NumberFormatException e) {
			mostrarError("ERROR: Los valores deben ser enteros");
		}
		
		return e2g;
	}

	private void mostrarError(String error) {
		lblSolucion1.setText(error);
		lblSolucion1.setForeground(Color.RED);
		
	}

	public void mostrarSoluciones(Double[] soluciones) {
		if (soluciones[0] != null && soluciones[1] != null) {
			mostrarMensaje(lblSolucion1, "Solución 1: " + soluciones[0]);
			mostrarMensaje(lblSolucion2, "Solución 2: " + soluciones[1]);
		} else {
			mostrarMensaje(lblSolucion1, "La ecuación no tiene solución");
			mostrarMensaje(lblSolucion2, "");
		}
		
	}

	private void mostrarMensaje(JLabel lbl, String mensaje) {
		lbl.setText(mensaje);
		lbl.setForeground(Color.MAGENTA);
		
	}
}
