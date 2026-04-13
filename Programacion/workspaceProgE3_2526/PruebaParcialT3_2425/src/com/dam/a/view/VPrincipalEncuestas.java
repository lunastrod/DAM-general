package com.dam.a.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import com.dam.a.control.ControladorEncuestas;

public class VPrincipalEncuestas extends JFrame implements IVPrincipalEncuestas {

	public static final int ANCHO = 600;
	public static final int ALTO = 400;
	
	public static int insetsR;
	public static int insetsL;
	public static int insetsT;
	public static int insetsB;
	public static int menuH;
	
	private JScrollPane scrpContenedor;
	private JMenuItem mntmRealizar;
	private JMenuItem mntmVisualizar;
	
	public VPrincipalEncuestas() {
		configurarVentana();
		
		crearComponentes();
	}

	@Override
	public void configurarVentana() {
		setTitle("E N C U E S T A S");
		
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
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
	}

	@Override
	public void crearComponentes() {
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);

	}

	@Override
	public void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuH = menuBar.getPreferredSize().height;
		
		JMenu mnEncuestas = new JMenu("Encuestas A");
		menuBar.add(mnEncuestas);
		
		mntmRealizar = new JMenuItem("Realizar Encuesta");
		mnEncuestas.add(mntmRealizar);
		
		mntmVisualizar = new JMenuItem("Visualizar Encuestas");
		mnEncuestas.add(mntmVisualizar);

	}

	@Override
	public void setControlador(ControladorEncuestas ce) {
		mntmRealizar.addActionListener(ce);
		mntmVisualizar.addActionListener(ce);

	}

	@Override
	public void hacerVisible() {
		setVisible(true);

	}

	@Override
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);

	}

	public JMenuItem getMntmRealizar() {
		return mntmRealizar;
	}

	public JMenuItem getMntmVisualizar() {
		return mntmVisualizar;
	}

	
}
