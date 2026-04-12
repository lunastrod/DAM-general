package com.dam.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import com.dam.control.ControladorEncuestas;

public class VPrincipalEncuestas extends JFrame 
implements IVPrincipalEncuestas {
	
	public static final int ANCHO = 500;
	public static final int ALTO = 700;
	
	public static int insetsR;
	public static int insetsL;
	public static int insetsT;
	public static int insetsB;
	public static int menuH;
	
	private JMenuItem mntmRealizar;
	private JMenuItem mntmConsultar;
	private JScrollPane scrpContenedor;
	
	public VPrincipalEncuestas() {
		configurarVentana();
		
		crearComponentes();
	}

	@Override
	public void configurarVentana() {
		setTitle("Encuestas COVID");
		
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
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuH = menuBar.getPreferredSize().height;
		
		JMenu mnEncuestas = new JMenu("Encuestas");
		menuBar.add(mnEncuestas);
		
		mntmRealizar = new JMenuItem("Realizar Encuesta");
		mnEncuestas.add(mntmRealizar);
		
		mntmConsultar = new JMenuItem("Consultar Encuestas");
		mnEncuestas.add(mntmConsultar);
		
	}

	// métodos get de los atributos opciones de menu (JMenuItem)
	// para poder compararlos desde el controlador
	public JMenuItem getMntmRealizar() {
		return mntmRealizar;
	}

	public JMenuItem getMntmConsultar() {
		return mntmConsultar;
	}

	@Override
	public void crearComponentes() {	
		// la forma de agrupar el contenido va a ser siguiendo un BorderLayout
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		
	}

	@Override
	public void hacerVisible() {
		setVisible(true);
		
	}
	
	

	@Override
	public void setControlador(ControladorEncuestas ce) {
		mntmRealizar.addActionListener(ce);
		mntmConsultar.addActionListener(ce);
		
	}

	@Override
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
		
	}

}
