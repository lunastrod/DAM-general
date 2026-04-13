package com.dam.view;


import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEj1 extends JFrame {
	private JTextField txtNumero;
	private JButton btnComprobar;
	private JLabel lblResultado;

	public VentanaEj1() {
		configurarVentana();
	}

	private void configurarVentana() {
		setTitle("Ejercicio1: Par o Impar");
		
		crearComponentes();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(320, 200);
		
		setLocationRelativeTo(null);
		
	}

	private void crearComponentes() {
		getContentPane().setLayout(null);
		
		JLabel lblSolicitud = new JLabel("Introduce un número");
		lblSolicitud.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSolicitud.setBounds(25, 22, 200, 20);
		getContentPane().add(lblSolicitud);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(103, 50, 100, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					int num = Integer.parseInt(txtNumero.getText());
					
					if (num % 2 == 0) {
						mostrarMensaje("El número es par");
					} else {
						mostrarMensaje("El número es impar");
					}
					
				} catch (NumberFormatException ex) {
					mostrarError("El valor introducido debe un número entero");
				}
			}

			
		});
		btnComprobar.setBounds(103, 80, 100, 20);
		getContentPane().add(btnComprobar);
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultado.setBounds(25, 110, 275, 20);
		getContentPane().add(lblResultado);
		
	}	
	
	protected void mostrarMensaje(String mensaje) {
		lblResultado.setText(mensaje);
		lblResultado.setForeground(Color.BLACK);
		
	}

	private void mostrarError(String error) {
		lblResultado.setText(error);
		lblResultado.setForeground(Color.RED);
		
	}

	public void hacerVisible() {
		setVisible(true);
	}
}
