package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.dam.control.ControladorPruebas;

import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class VentanaPrincipalPruebas extends JFrame implements IVentanaPruebas {
	
	public static final int ANCHO = 1000;
	public static final int ALTO = 800;
	
	public static int insetsR;
	public static int insetsL;
	public static int insetsT;
	public static int insetsB;
	public static int menuH;
	private JScrollPane scrpContenedor;
	private JMenuItem mntmRojo;
	private JMenuItem mntmAzul;
	private JMenuItem mntmAmarillo;
	private JMenuItem mntmMorado;
	private JMenuItem mntmVerde;
	private JMenuItem mntmNaranja;
	private JMenuItem mntmNegro;
	private JMenuItem mntmBlanco;

	public VentanaPrincipalPruebas() {
		configurarVentana();
		
		crearComponentes();
	}

	@Override
	public void configurarVentana() {
		setTitle("Pruebas con Menú y Paneles");
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		insetsR = this.getInsets().right;
		insetsL = this.getInsets().left;
		insetsT = this.getInsets().top;
		insetsB = this.getInsets().bottom;
		
		// centrar la ventana en la pantalla
		centrarVentana();
		
		crearMenu();

	}

	private void centrarVentana() {
		// Se obtienen las dimensiones en pixels de la pantalla.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = new Dimension(ANCHO, ALTO);
		// Una cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
		
	}

	private void crearMenu() {
		// mover aquí el código referente a la creación del menú
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuH = menuBar.getPreferredSize().height;
		
		JMenu mnColores = new JMenu("Colores");
		menuBar.add(mnColores);
		
		JMenu mnPrimarios = new JMenu("Primarios");
		mnColores.add(mnPrimarios);
		
		mntmRojo = new JMenuItem("Rojo");
		mnPrimarios.add(mntmRojo);
		
		mntmAzul = new JMenuItem("Azul");
		mnPrimarios.add(mntmAzul);
		
		mntmAmarillo = new JMenuItem("Amarillo");
		mnPrimarios.add(mntmAmarillo);
		
		JMenu mnSecundarios = new JMenu("Secundarios");
		mnColores.add(mnSecundarios);
		
		mntmMorado = new JMenuItem("Morado");
		mnSecundarios.add(mntmMorado);
		
		mntmVerde = new JMenuItem("Verde");
		mnSecundarios.add(mntmVerde);
		
		mntmNaranja = new JMenuItem("Naranja");
		mnSecundarios.add(mntmNaranja);
		
		mntmNegro = new JMenuItem("Negro");
		mnColores.add(mntmNegro);
		
		JMenu mnNoColores = new JMenu("No colores");
		menuBar.add(mnNoColores);
		
		mntmBlanco = new JMenuItem("Blanco");
		mnNoColores.add(mntmBlanco);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
	}

	@Override
	public void crearComponentes() {
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);

	}

	@Override
	public void hacerVisible() {
		setVisible(true);

	}

	public void setControlador(ControladorPruebas control) {
		mntmRojo.addActionListener(control);
		mntmAzul.addActionListener(control);
		mntmAmarillo.addActionListener(control);
		mntmNaranja.addActionListener(control);
		mntmMorado.addActionListener(control);
		mntmVerde.addActionListener(control);
		mntmNegro.addActionListener(control);
		// mntmBlanco.addActionListener(control);
		
	}
	
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}

	public JMenuItem getMntmRojo() {
		return mntmRojo;
	}

	public JMenuItem getMntmAzul() {
		return mntmAzul;
	}

	public JMenuItem getMntmAmarillo() {
		return mntmAmarillo;
	}

	public JMenuItem getMntmMorado() {
		return mntmMorado;
	}

	public JMenuItem getMntmVerde() {
		return mntmVerde;
	}

	public JMenuItem getMntmNaranja() {
		return mntmNaranja;
	}

	public JMenuItem getMntmNegro() {
		return mntmNegro;
	}

	public JMenuItem getMntmBlanco() {
		return mntmBlanco;
	}
	
	
}
