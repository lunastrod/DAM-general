package com.dam.feb17;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Vista extends JFrame{
	private JTextField textNumero;
	private JLabel lblResultado;
	public Vista() {
		configurarVentana();
	}
	
	
	private void configurarVentana() {
		setTitle("Ejercicio1");
		getContentPane().setBackground(new Color(250, 230, 255));
		getContentPane().setLayout(null);
		
		configurarComponentes();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		setSize(300,200);
		setVisible(true);
	}
	
	private void configurarComponentes() {
		JLabel lblIntroduceNum = new JLabel("Introduce un numero");
		lblIntroduceNum.setBounds(29, 25, 111, 35);
		getContentPane().add(lblIntroduceNum);
		
		textNumero = new JTextField();
		textNumero.setBounds(29, 71, 86, 20);
		getContentPane().add(textNumero);
		textNumero.setColumns(10);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBounds(29, 121, 89, 23);
		getContentPane().add(btnComprobar);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(145, 125, 129, 14);
		getContentPane().add(lblResultado);
		
		
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n=Integer.parseInt(textNumero.getText());
					if(n%2==0){
						lblResultado.setText("Par");
					}
					else {
						lblResultado.setText("Impar");
					}
				}catch(NumberFormatException ex) {
					lblResultado.setText("Formato de numero erroneo");
				}

			}
		});
		
		
	}
	
}
