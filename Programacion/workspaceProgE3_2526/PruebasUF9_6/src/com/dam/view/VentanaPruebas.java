package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.dam.control.ControladorPruebas;
import com.dam.model.Alumno;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPruebas extends JFrame implements IVentanaPruebas {
	
	private static final int ANCHO = 1000;
	private static final int ALTO = 800;
	private static final String COLUMN_NOM = "NOMBRE";
	private static final String COLUMN_APE = "APELLIDOS";
	private static final String COLUMN_DNI = "DNI";
	private static final String COLUMN_EDAD = "EDAD";
	
	private JTable tblAlumnos;
	private DefaultTableModel dtmAlumnos;
	private JMenuItem mntmOpcion11;
	private JMenuItem mntmOpcion12;
	private JMenuItem mntmOpcion2;

	public VentanaPruebas() {
		configurarVentana();
		
		crearComponentes();
	}

	@Override
	public void configurarVentana() {
		setTitle("Pruebas con componentes swing");
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		// centrar la ventana en la pantalla
		// Se obtienen las dimensiones en pixels de la pantalla.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = new Dimension(ANCHO, ALTO);
		// Una cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
		crearMenu();

	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpcion1 = new JMenu("Opción 1");
		menuBar.add(mnOpcion1);
		
		mntmOpcion11 = new JMenuItem("Opción 1.1");
		mnOpcion1.add(mntmOpcion11);
		
		mntmOpcion12 = new JMenuItem("Opción 1.2");
		mnOpcion1.add(mntmOpcion12);
		
		mntmOpcion2 = new JMenuItem("Opción 2");
		menuBar.add(mntmOpcion2);
	}

	public JMenuItem getMntmOpcion11() {
		return mntmOpcion11;
	}

	public JMenuItem getMntmOpcion12() {
		return mntmOpcion12;
	}

	public JMenuItem getMntmOpcion2() {
		return mntmOpcion2;
	}

	@Override
	public void crearComponentes() {
		getContentPane().setLayout(null);
		
		JScrollPane scrpTabla = new JScrollPane();
		scrpTabla.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpTabla.setBounds(92, 51, 806, 175);
		getContentPane().add(scrpTabla);
		
		tblAlumnos = new JTable();
		scrpTabla.setViewportView(tblAlumnos);
		
		configurarTabla();
		
		
		

	}

	private void configurarTabla() {
		dtmAlumnos = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// hacer editable la columna de la edad
				/*if (column == 3) {
					return true;
				} else {
					return false;
				}*/
				return false;
			}
		};
		
		tblAlumnos.setModel(dtmAlumnos);
		
		dtmAlumnos.addColumn(COLUMN_NOM);
		dtmAlumnos.addColumn(COLUMN_APE);
		dtmAlumnos.addColumn(COLUMN_DNI);
		dtmAlumnos.addColumn(COLUMN_EDAD);
		
		tblAlumnos.getColumn(COLUMN_NOM).setPreferredWidth(75);
		tblAlumnos.getColumn(COLUMN_APE).setPreferredWidth(100);
		tblAlumnos.getColumn(COLUMN_DNI).setPreferredWidth(75);
		tblAlumnos.getColumn(COLUMN_EDAD).setPreferredWidth(30);
	}

	@Override
	public void hacerVisible() {
		setVisible(true);

	}

	public void setControlador(ControladorPruebas control) {
		mntmOpcion11.addActionListener(control);
		mntmOpcion12.addActionListener(control);
		mntmOpcion2.addActionListener(control);
	}

	public String obtenerDatos() {
		return null;
	}

	public void cargarTabla(ArrayList<Alumno> listaAlumnos) {
		Object[] fila = new Object[4];
		
		for (Alumno alumno : listaAlumnos) {
			fila[0] = alumno.getNombre();
			fila[1] = alumno.getApellidos();
			fila[2] = alumno.getDni();
			fila[3] = alumno.getEdad();
			
			dtmAlumnos.addRow(fila);
			
		}
		
	}
}
