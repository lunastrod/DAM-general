package com.dam.a.view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.dam.a.control.ControladorEncuestas;
import com.dam.a.model.Encuesta;

public class PVisualizarEncuestas extends JPanel implements IPaneles {

	private static final int ANCHO = VPrincipalEncuestas.ANCHO 
			- VPrincipalEncuestas.insetsL - VPrincipalEncuestas.insetsR;
	private static final int ALTO = VPrincipalEncuestas.ALTO 
			- VPrincipalEncuestas.insetsT - VPrincipalEncuestas.insetsB 
			- VPrincipalEncuestas.menuH;
	public static final String AC_BTN_RESULTADOS = "Ver Resultados";
	
	private JList<Object> lstEncuestas;
	private DefaultListModel<Object> lstModel;
	private JButton btnVer;
	
	public PVisualizarEncuestas() {
		setSize(ANCHO, ALTO);
		
		crearComponentes();
	}

	@Override
	public void crearComponentes() {
		setLayout(null);
		
		JLabel lblLista = new JLabel("Listado de Encuestas");
		lblLista.setBounds(25, 20, 160, 20);
		lblLista.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblLista);
		
		JScrollPane scrpLista = new JScrollPane();
		scrpLista.setBounds(45, 55, 480, 200);
		scrpLista.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrpLista);
		
		lstEncuestas = new JList<Object>();
		scrpLista.setViewportView(lstEncuestas);
		lstModel = new DefaultListModel<Object>();
		lstEncuestas.setModel(lstModel);
		
		btnVer = new JButton(AC_BTN_RESULTADOS);
		btnVer.setBounds(225, 275, 150, 22);
		add(btnVer);

	}
	
	public void hacerVisibleBtnVer(boolean b) {
		btnVer.setVisible(b);
	}

	@Override
	public void setControlador(ControladorEncuestas control) {
		btnVer.addActionListener(control);

	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void cargarEncuestas(ArrayList<Encuesta> listaEncuestas) {
		lstModel.clear();
		
		for (Encuesta e : listaEncuestas) {
			lstModel.addElement(e);
		}
	}

}
