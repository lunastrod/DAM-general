package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

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

public class VentanaPruebas extends JFrame implements IVentanaPruebas {
	
	private static final int ANCHO = 1000;
	private static final int ALTO = 800;
	private JComboBox<Alumno> cmbAlumnos;
	private DefaultComboBoxModel<Alumno> dcbmAlumnos;
	private JButton btnComprobarContenido;
	private JTextArea taComentarios;
	private JComboBox<String> cmbDias;
	private JCheckBox chckbxAcepta;
	private final ButtonGroup btngMusica = new ButtonGroup();
	private JRadioButton rdbtnPop;
	private JRadioButton rdbtnRock;
	private JRadioButton rdbtnTrap;
	private JRadioButton rdbtnRegaeton;
	private JRadioButton rdbtnJazz;
	private JPasswordField psswContrasenia;
	private JSpinner spnKm;
	private JList<Alumno> lstAlumnos;
	private DefaultListModel<Alumno> dlmAlumnos;

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

	}

	@Override
	public void crearComponentes() {
		getContentPane().setLayout(null);
		
		JScrollPane scrpTextArea = new JScrollPane();
		scrpTextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpTextArea.setBounds(54, 42, 888, 104);
		getContentPane().add(scrpTextArea);
		
		taComentarios = new JTextArea();
		taComentarios.setLineWrap(true);
		taComentarios.setEditable(false);  // para que no sea editable
		scrpTextArea.setViewportView(taComentarios);
		
		cmbDias = new JComboBox<String>();
		// se asigna el listado de datos que se van a mostrar
		String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		// cuando queramos cargar un comboBox desde fuera de la ventana necesitaremos hacer variable global o atributo al DefaultComboBoxModel
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>(dias);
		cmbDias.setModel(dcbm);
		
		cmbDias.setBounds(54, 183, 133, 22);
		getContentPane().add(cmbDias);
		
		cmbAlumnos = new JComboBox<Alumno>();
		cmbAlumnos.setBounds(316, 183, 265, 22);
		getContentPane().add(cmbAlumnos);
		
		dcbmAlumnos = new DefaultComboBoxModel<Alumno>();
		cmbAlumnos.setModel(dcbmAlumnos);
		
		btnComprobarContenido = new JButton("Comprobar Contenido");
		btnComprobarContenido.setBounds(376, 696, 234, 22);
		getContentPane().add(btnComprobarContenido);
		
		chckbxAcepta = new JCheckBox("Acepta las condiciones");
		chckbxAcepta.setBounds(54, 227, 234, 22);
		getContentPane().add(chckbxAcepta);
		
		rdbtnPop = new JRadioButton("Pop");
		rdbtnPop.setSelected(true);
		btngMusica.add(rdbtnPop);
		rdbtnPop.setBounds(54, 270, 110, 22);
		getContentPane().add(rdbtnPop);
		
		rdbtnRock = new JRadioButton("Rock");
		btngMusica.add(rdbtnRock);
		rdbtnRock.setBounds(195, 270, 110, 22);
		getContentPane().add(rdbtnRock);
		
		rdbtnTrap = new JRadioButton("Trap");
		btngMusica.add(rdbtnTrap);
		rdbtnTrap.setBounds(337, 270, 110, 22);
		getContentPane().add(rdbtnTrap);
		
		rdbtnRegaeton = new JRadioButton("Regaeton");
		btngMusica.add(rdbtnRegaeton);
		rdbtnRegaeton.setBounds(487, 270, 110, 22);
		getContentPane().add(rdbtnRegaeton);
		
		rdbtnJazz = new JRadioButton("Jazz");
		btngMusica.add(rdbtnJazz);
		rdbtnJazz.setBounds(668, 270, 110, 22);
		getContentPane().add(rdbtnJazz);
		
		psswContrasenia = new JPasswordField();
		psswContrasenia.setBounds(668, 184, 170, 20);
		getContentPane().add(psswContrasenia);
		
		spnKm = new JSpinner();
		spnKm.setModel(new SpinnerNumberModel(0, 0, 100, 5));
		spnKm.setBounds(316, 228, 76, 20);
		getContentPane().add(spnKm);
		
		JScrollPane scrpLista = new JScrollPane();
		scrpLista.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpLista.setBounds(54, 321, 888, 147);
		getContentPane().add(scrpLista);
		
		lstAlumnos = new JList<Alumno>();
		//lstAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstAlumnos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrpLista.setViewportView(lstAlumnos);
		
		dlmAlumnos = new DefaultListModel<Alumno>();
		lstAlumnos.setModel(dlmAlumnos);

	}
	
	public void cargarLstAlumnos(ArrayList<Alumno> listaAlumnos) {
		dlmAlumnos.addAll(listaAlumnos);
	}
	
	public void cargarCmbAlumnos(ArrayList<Alumno> listaAlumnos) {
		dcbmAlumnos.addAll(listaAlumnos);
	}

	@Override
	public void hacerVisible() {
		setVisible(true);

	}

	public void setControlador(ControladorPruebas control) {
		btnComprobarContenido.addActionListener(control);
		
	}

	public String obtenerDatos() {
		// recuperar los datos introducido o seleccionados en la ventana
		
		String datos = "*** DATOS INTRODUCIDOS ***";
		
		// cómo recuperamos el valor seleccionado en un combo. Dos formas:
		// 1. recuperando el elemento seleccionado
		String diaSel = (String) cmbDias.getSelectedItem();
		datos += "\n\n\tDía seleccionado: " + diaSel;
		
		// 2. recuperando el índice del elemento seleccionado
		int iAS = cmbAlumnos.getSelectedIndex();
		if (iAS == -1) {
			datos += "\n\tNo se ha seleccionado ningún alumno";
		} else {
			Alumno alumnoSel = (Alumno) cmbAlumnos.getSelectedItem();
			datos += "\n\tAlumno seleccionado: " + alumnoSel;
		}
		
		// recuperar si se ha seleccionado el check
		if (chckbxAcepta.isSelected()) {
			datos += "\n\tSe aceptan las condiciones";
		} else {
			datos += "\n\tNo se han aceptado las condiciones";
		}
		
		if (rdbtnPop.isSelected()) {
			datos += "\n\tSe ha seleccionado " + rdbtnPop.getText();
			
		} else if (rdbtnRock.isSelected()) {
			datos += "\n\tSe ha seleccionado " + rdbtnRock.getText();
			
		} else if (rdbtnTrap.isSelected()) {
			datos += "\n\tSe ha seleccionado " + rdbtnTrap.getText();
			
		} else if (rdbtnRegaeton.isSelected()) {
			datos += "\n\tSe ha seleccionado " + rdbtnRegaeton.getText();
			
		} else {
			datos += "\n\tSe ha seleccionado " + rdbtnJazz.getText();
			
		}
		
		datos += "\n\tValor seleccionado en el spinner: " + spnKm.getValue();
		
		// comprobamos si se ha seleccionado algo en la lista con SINGLE_SELECTION
		/*int iASL = lstAlumnos.getSelectedIndex();
		
		if (iASL == -1) {
			datos += "\n\tNo se ha seleccionado nada en la lista";
		} else {
			datos += "\n\tAlumno seleccionado en la lista: \n\t\t" + lstAlumnos.getSelectedValue();
			
		}*/
		
		// comprobamos si se ha seleccionado algo en la lista con MULTIPLE_INTERVAL_SELECTION
		int iASL = lstAlumnos.getSelectedIndex();
		
		if (iASL == -1) {
			datos += "\n\tNo se ha seleccionado nada en la lista";
		} else {
			datos += "\n\tAlumno seleccionado en la lista: ";
			// si el modo de selección es de intervalo
			ArrayList<Alumno> listaAlumnosSel = (ArrayList<Alumno>) lstAlumnos.getSelectedValuesList();
			for (Alumno alumno : listaAlumnosSel) {
				datos += "\n\t\t" + alumno;
			}
		}
		
		return datos;
	}

	public void mostrarDatosIntroducidos(String datos) {
		// mostrar en el TextArea los datos
		taComentarios.setText(datos);
	}
}
