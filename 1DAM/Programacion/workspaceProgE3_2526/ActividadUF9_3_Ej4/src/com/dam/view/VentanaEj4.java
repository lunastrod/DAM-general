package com.dam.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class VentanaEj4 extends JFrame {
	static final int CANT_DIGITOS = 3;
	private JTextField txtNumero;
	private JButton btnComprobar;
	private JLabel lblResultado;
	
	public VentanaEj4() {
		configurarVentana();
	}

	private void configurarVentana() {
		setTitle("Ejercicio4: Capicúa");
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(320, 200);
		
		// provisional
		setLocationRelativeTo(null);
		
		crearComponentes();
	}

	private void crearComponentes() {
		getContentPane().setLayout(null);
		
		JLabel lblSolicitud = new JLabel("Introduce un número de 3 cifras");
		lblSolicitud.setBounds(22, 22, 197, 14);
		getContentPane().add(lblSolicitud);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(123, 47, 60, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarNumero();
			}
		});
		btnComprobar.setBounds(98, 78, 110, 22);
		getContentPane().add(btnComprobar);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(22, 111, 250, 14);
		getContentPane().add(lblResultado);
	}

	protected void validarNumero() {
		String sNum = txtNumero.getText().trim();
		
		// validamos que sea numérico y que tenga 3 dígitos
		try {
			int num = Integer.parseInt(sNum);
			
			if (sNum.length() != CANT_DIGITOS) {
				mostrarError("ERROR: El número debe tener " + CANT_DIGITOS + " dígitos");
			} else {
				// si el número es válido comprobamos si el num es capicúa
				if (comprobarCapicua(sNum)) {
					mostrarResultado("El número es capicúa");
				} else {
					mostrarResultado("El número no es capicúa");
				}
			}
			
		} catch (NumberFormatException e) {
			mostrarError("ERROR: El valor debe ser entero");
		}
		
	}

	private void mostrarResultado(String mensaje) {
		lblResultado.setText(mensaje);
		lblResultado.setForeground(Color.GREEN);
		
	}

	private boolean comprobarCapicua(String sNum) {
		return sNum.charAt(0) == sNum.charAt(CANT_DIGITOS - 1);
		
	}

	private void mostrarError(String error) {
		lblResultado.setText(error);
		lblResultado.setForeground(Color.RED);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
