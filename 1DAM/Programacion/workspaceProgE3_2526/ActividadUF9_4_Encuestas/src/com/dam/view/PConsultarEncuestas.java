package com.dam.view;

import javax.swing.JPanel;

import com.dam.control.ControladorEncuestas;
import com.dam.model.Encuesta;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PConsultarEncuestas extends JPanel implements IPaneles {

	private static final int ANCHO = VPrincipalEncuestas.ANCHO 
			- VPrincipalEncuestas.insetsL - VPrincipalEncuestas.insetsR;
	private static final int ALTO = VPrincipalEncuestas.ALTO 
			- VPrincipalEncuestas.insetsT - VPrincipalEncuestas.insetsB 
			- VPrincipalEncuestas.menuH;
	public static final String ACTION_COMMAND_VER = "Ver Encuestas Realizadas";
	
	private JButton btnVer;
	private JTextArea taEncuestas;
	
	public PConsultarEncuestas() {
		setSize(ANCHO, ALTO);
		
		crearComponentes();
	}
	
	@Override
	public void crearComponentes() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Consultar Encuestas");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(44, 33, 225, 22);
		add(lblTitulo);
		
		btnVer = new JButton(ACTION_COMMAND_VER);
		btnVer.setBounds(150, 79, 199, 22);
		add(btnVer);
		
		JScrollPane scrpEncuestas = new JScrollPane();
		scrpEncuestas.setBounds(56, 132, 389, 383);
		add(scrpEncuestas);
		
		taEncuestas = new JTextArea();
		taEncuestas.setEditable(false);
		scrpEncuestas.setViewportView(taEncuestas);

	}

	@Override
	public void setControlador(ControladorEncuestas control) {
		btnVer.addActionListener(control);

	}

	public void mostrarEncuestas(ArrayList<Encuesta> listaEncuestas) {
		String datos = "";
		
		for (Encuesta encuesta : listaEncuestas) {
			datos += encuesta + "\n\n";
		}
		
		taEncuestas.setText("** ENCUESTAS REALIZADAS ** \n" + datos);
		
	}
}
