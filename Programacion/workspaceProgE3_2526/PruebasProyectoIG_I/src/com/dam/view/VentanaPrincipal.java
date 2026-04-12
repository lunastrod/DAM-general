package com.dam.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	
	private JTextField txtNombre;
	private JButton btnSaludar;
	private JLabel lblSaludo;
	
	public VentanaPrincipal() {
		configurarVentana();
	}

	private void configurarVentana() {
		// configuración del marco 
		setTitle("Primera Prueba de IG");
		
		crearComponentes();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(300, 200);
		
		setLocationRelativeTo(null);
	}

	private void crearComponentes() {
		getContentPane().setBackground(new Color(144, 238, 144));
		getContentPane().setLayout(null);
		
		JLabel lblEtiqueta1 = new JLabel("Bienvenido, introduce tu nombre");
		lblEtiqueta1.setForeground(new Color(0, 128, 0));
		lblEtiqueta1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEtiqueta1.setBounds(15, 25, 250, 15);
		getContentPane().add(lblEtiqueta1);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setBounds(65, 50, 160, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		btnSaludar = new JButton("Saludar");
		btnSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				lblSaludo.setText("¡¡Hola " + nombre + "!!");
			}
		});
		btnSaludar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSaludar.setBounds(100, 80, 90, 20);
		getContentPane().add(btnSaludar);
		
		lblSaludo = new JLabel("");
		lblSaludo.setForeground(new Color(220, 20, 60));
		lblSaludo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSaludo.setBounds(40, 120, 215, 15);
		getContentPane().add(lblSaludo);
	}

	public void hacerVisible() {
		setVisible(true);
	}
}
