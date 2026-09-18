package com.dam.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.dam.control.ControladorListaCompra;
import com.dam.model.Producto;

public class VListaCompra extends JFrame implements IVListaCompra {
	
	private static final int ANCHO = 400;
	private static final int ALTO = 600;
	public static final String BTN_ADD = "Añadir producto";
	public static final String BTN_DEL = "Eliminar producto";
	
	private JTextField txtProducto;
	private JSpinner spnCantidad;
	private JComboBox<String> cmbUnidad;
	private JButton btnAniadir;
	private JList<Producto> lstProductos;
	private DefaultListModel<Producto> dlm;
	private JLabel lblError;
	private JButton btnEliminar;

	public VListaCompra() {
		configurarVentana();
		crearComponentes();
	}

	@Override
	public void configurarVentana() {
		setTitle("Lista de la compra");
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		// centrar la ventana en la pantalla
		centrarVentana();
		
	}

	private void centrarVentana() {
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
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(33, 32, 82, 20);
		getContentPane().add(lblProducto);
		
		txtProducto = new JTextField();
		txtProducto.setBounds(148, 29, 196, 26);
		getContentPane().add(txtProducto);
		txtProducto.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(33, 83, 82, 20);
		getContentPane().add(lblCantidad);
		
		spnCantidad = new JSpinner();
		spnCantidad.setEditor(new JSpinner.DefaultEditor(spnCantidad));
		spnCantidad.setModel(new SpinnerNumberModel(1, 1, 500, 1));
		spnCantidad.setBounds(148, 80, 65, 26);
		spnCantidad.setValue(1);
		getContentPane().add(spnCantidad);
		
		cmbUnidad = new JComboBox<String>();
		cmbUnidad.setModel(new DefaultComboBoxModel<String>(Producto.UNIDADES));
		cmbUnidad.setBounds(238, 80, 76, 26);
		getContentPane().add(cmbUnidad);
		
		btnAniadir = new JButton(BTN_ADD);
		btnAniadir.setBounds(30, 142, 147, 29);
		getContentPane().add(btnAniadir);
		
		JLabel lblListaDeProductos = new JLabel("Lista de Productos");
		lblListaDeProductos.setBounds(33, 203, 180, 20);
		getContentPane().add(lblListaDeProductos);
		
		JScrollPane scrpLista = new JScrollPane();
		scrpLista.setBounds(33, 251, 312, 214);
		getContentPane().add(scrpLista);
		
		lstProductos = new JList<Producto>();
		lstProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dlm = new DefaultListModel<Producto>();
		lstProductos.setModel(dlm);
		scrpLista.setViewportView(lstProductos);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(Color.RED);
		lblError.setBounds(33, 491, 311, 20);
		getContentPane().add(lblError);
		
		btnEliminar = new JButton(BTN_DEL);
		btnEliminar.setBounds(207, 142, 147, 29);
		getContentPane().add(btnEliminar);
		
	}

	@Override
	public void setControlador(ControladorListaCompra ch) {
		btnAniadir.addActionListener(ch);
		btnEliminar.addActionListener(ch);
		
	}

	@Override
	public void hacerVisible() {
		setVisible(true);
		
	}

	public Producto obtenerProducto() {
		Producto prod = null;
		
		String nom = txtProducto.getText().trim();
		
		if (nom.isEmpty()) {
			// mostrar error
			// lblError.setText("ERROR: El nombre es obligatorio");
			mostrarError("El nombre es obligatorio");
			
		} else {
			int cant = (int) spnCantidad.getValue();
			String unid = (String) cmbUnidad.getSelectedItem();
			
			prod = new Producto(nom, cant, unid);
			
		}
		
		return prod;
	}

	public void mostrarLista(ArrayList<Producto> listaProductos) {
		dlm.clear();
		
		for (Producto producto : listaProductos) {
			dlm.addElement(producto);
		}
		
	}

	public void limpiarComponentes() {
		txtProducto.setText("");
		spnCantidad.setValue(1);
		cmbUnidad.setSelectedIndex(0);
		
		// limpiar el label que muestra errores
		lblError.setText("");
		
	}

	public int getIndiceProdSelec() {
		return lstProductos.getSelectedIndex();
	}

	public JLabel getLblError() {
		return lblError;
	}
	
	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "ERROR", JOptionPane.ERROR_MESSAGE);	
	}
	
	public void mostrarInfo(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
	

}
