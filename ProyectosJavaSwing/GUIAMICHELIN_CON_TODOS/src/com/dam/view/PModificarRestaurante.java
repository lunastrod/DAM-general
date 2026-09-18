package com.dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import com.dam.control.RestaurantesListener;
import com.dam.model.data.Restaurante;

// Panel de modificación de restaurantes.
// El usuario busca un restaurante por nombre, se cargan sus datos,
// los modifica y los guarda.
public class PModificarRestaurante extends JPanel implements IVPanels {

	// ActionCommands de los botones — el controlador los usa para saber qué botón se pulsó
	public static final String AC_BTN_BUSCAR  = "Buscar";
	public static final String AC_BTN_GUARDAR = "Guardar Datos";
	public static final String AC_BTN_CANCELAR = "Cancelar";

	// Opciones fijas de los combos — igual que en PRegistrarRestaurante
	public static final String[] OPCIONES_REGION = {
		"Andalucía", "Aragón", "Asturias", "Islas Baleares", "Cantabria",
		"Islas Canarias", "Castilla - La Mancha", "Castilla y León",
		"Cataluña", "Galicia", "Extremadura", "Madrid", "Murcia",
		"Navarra", "País Vasco", "La Rioja", "Comunidad Valenciana"
	};

	public static final String[] OPCIONES_COCINA = {
		"Creativa", "Moderna", "Tradicional", "Regional", "Fusión"
	};

	// Campos de texto del formulario
	private JTextField txtFieldNombre;
	private JTextField txtFieldCiudad;
	private JTextField txtFieldDireccion;
	private JTextField txtFieldPrecioMin;
	private JTextField txtFieldPrecioMax;
	private JTextField txtFieldTelf;
	private JTextField txtFieldWeb;

	// Combos y spinner
	private JComboBox<String> cmbBoxRegion;
	private JComboBox<String> cmbBoxCocina;
	private JSpinner JSpinDistinc;

	// Modelos de los combos
	private DefaultComboBoxModel<String> dcbmodelRegion;
	private DefaultComboBoxModel<String> dcbmodelCocina;

	// Botones
	private JButton btnBuscar;
	private JButton btnGuardarDatos;
	private JButton btnCancelar;

	// Guardamos el id del restaurante buscado para usarlo en el UPDATE
	private int id;

	// Tamaño del panel ajustado al espacio disponible dentro de la ventana principal
	private static final int ANCHO = VPRestaurantes.ANCHO - VPRestaurantes.insetsL - VPRestaurantes.insetsR;
	private static final int ALTO  = VPRestaurantes.ALTO  - VPRestaurantes.insetsT - VPRestaurantes.insetsB - VPRestaurantes.menuH;

	public PModificarRestaurante() {
		setSize(ANCHO, ALTO);
		crearComponentes();
	}

	@Override
	public void crearComponentes() {
		setLayout(null);

		JLabel lblTitulo = new JLabel("Modificar Restaurante");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(33, 24, 199, 14);
		add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(33, 65, 46, 14);
		add(lblNombre);

		JLabel lblRegion = new JLabel("Región:");
		lblRegion.setBounds(33, 103, 46, 14);
		add(lblRegion);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(33, 143, 75, 14);
		add(lblDireccion);

		JLabel lblDistincion = new JLabel("Distinción:");
		lblDistincion.setBounds(33, 182, 75, 14);
		add(lblDistincion);

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(33, 229, 75, 14);
		add(lblTelefono);

		JLabel lblCocina = new JLabel("Cocina:");
		lblCocina.setBounds(266, 65, 75, 14);
		add(lblCocina);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(242, 103, 75, 14);
		add(lblCiudad);

		JLabel lblPrecioMin = new JLabel("Precio mínimo:");
		lblPrecioMin.setBounds(200, 182, 82, 14);
		add(lblPrecioMin);

		JLabel lblPrecioMax = new JLabel("máximo:");
		lblPrecioMax.setBounds(348, 182, 82, 14);
		add(lblPrecioMax);

		JLabel lblWeb = new JLabel("Web:");
		lblWeb.setBounds(212, 229, 46, 14);
		add(lblWeb);

		txtFieldNombre = new JTextField();
		txtFieldNombre.setBounds(83, 62, 173, 20);
		add(txtFieldNombre);
		txtFieldNombre.setColumns(10);

		cmbBoxRegion = new JComboBox<String>();
		cmbBoxRegion.setBounds(89, 99, 127, 22);
		add(cmbBoxRegion);
		dcbmodelRegion = new DefaultComboBoxModel<String>(OPCIONES_REGION);
		cmbBoxRegion.setModel(dcbmodelRegion);

		cmbBoxCocina = new JComboBox<String>();
		cmbBoxCocina.setBounds(317, 61, 113, 22);
		add(cmbBoxCocina);
		dcbmodelCocina = new DefaultComboBoxModel<String>(OPCIONES_COCINA);
		cmbBoxCocina.setModel(dcbmodelCocina);

		// SpinnerNumberModel(valorInicial, min, max, paso)
		JSpinDistinc = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));
		JSpinDistinc.setBounds(92, 179, 38, 20);
		add(JSpinDistinc);

		txtFieldDireccion = new JTextField();
		txtFieldDireccion.setBounds(99, 140, 253, 20);
		add(txtFieldDireccion);
		txtFieldDireccion.setColumns(10);

		txtFieldCiudad = new JTextField();
		txtFieldCiudad.setBounds(303, 100, 154, 20);
		add(txtFieldCiudad);
		txtFieldCiudad.setColumns(10);

		txtFieldPrecioMax = new JTextField();
		txtFieldPrecioMax.setBounds(401, 179, 56, 20);
		add(txtFieldPrecioMax);
		txtFieldPrecioMax.setColumns(10);

		txtFieldPrecioMin = new JTextField();
		txtFieldPrecioMin.setColumns(10);
		txtFieldPrecioMin.setBounds(285, 179, 56, 20);
		add(txtFieldPrecioMin);

		txtFieldWeb = new JTextField();
		txtFieldWeb.setBounds(242, 226, 215, 20);
		add(txtFieldWeb);
		txtFieldWeb.setColumns(10);

		txtFieldTelf = new JTextField();
		txtFieldTelf.setBounds(83, 226, 119, 20);
		add(txtFieldTelf);
		txtFieldTelf.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand(AC_BTN_BUSCAR);
		btnBuscar.setBounds(270, 60, 89, 23);
		add(btnBuscar);

		btnGuardarDatos = new JButton("Guardar Datos");
		btnGuardarDatos.setActionCommand(AC_BTN_GUARDAR);
		btnGuardarDatos.setBounds(127, 278, 131, 23);
		add(btnGuardarDatos);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand(AC_BTN_CANCELAR);
		btnCancelar.setBounds(285, 278, 113, 23);
		add(btnCancelar);

		// Al abrir el panel solo txtFieldNombre y btnBuscar están habilitados
		habilitarModif(false);
	}

	// Habilita o deshabilita los componentes del formulario.
	// false = estado inicial (solo nombre y buscar habilitados)
	// true  = tras encontrar el restaurante (todo habilitado menos nombre y buscar)
	public void habilitarModif(boolean b) {
		txtFieldNombre.setEnabled(!b);
		btnBuscar.setEnabled(!b);
		cmbBoxRegion.setEnabled(b);
		txtFieldCiudad.setEnabled(b);
		JSpinDistinc.setEnabled(b);
		txtFieldDireccion.setEnabled(b);
		txtFieldPrecioMin.setEnabled(b);
		txtFieldPrecioMax.setEnabled(b);
		cmbBoxCocina.setEnabled(b);
		txtFieldTelf.setEnabled(b);
		txtFieldWeb.setEnabled(b);
		btnGuardarDatos.setEnabled(b);
		btnCancelar.setEnabled(b);
	}

	// Carga los datos del restaurante encontrado en los componentes del formulario.
	// Guardamos el id para usarlo luego en el UPDATE (más seguro que usar el nombre)
	public void cargarRestaurante(Restaurante restaurante) {
		id = restaurante.getId();
		txtFieldNombre.setText(restaurante.getNombre());
		cmbBoxRegion.setSelectedItem(restaurante.getRegion());
		txtFieldCiudad.setText(restaurante.getCiudad());
		JSpinDistinc.setValue(restaurante.getDistincion());
		txtFieldDireccion.setText(restaurante.getDireccion());
		txtFieldPrecioMin.setText(String.valueOf(restaurante.getPrecioMin()));
		if (restaurante.getPrecioMax() != 0) {
			txtFieldPrecioMax.setText(String.valueOf(restaurante.getPrecioMax()));
		}
		cmbBoxCocina.setSelectedItem(restaurante.getCocina());
		txtFieldTelf.setText(restaurante.getTelefono());
		txtFieldWeb.setText(restaurante.getWeb());
	}

	// Deja todos los campos en su estado inicial
	public void limpiarFormulario() {
		txtFieldNombre.setText("");
		txtFieldCiudad.setText("");
		txtFieldDireccion.setText("");
		txtFieldTelf.setText("");
		txtFieldWeb.setText("");
		txtFieldPrecioMin.setText("");
		txtFieldPrecioMax.setText("");
		cmbBoxRegion.setSelectedIndex(0);
		cmbBoxCocina.setSelectedIndex(0);
		JSpinDistinc.setValue(1);
	}

	// Recoge y valida los datos del formulario.
	// Devuelve un objeto Restaurante si todo es correcto, null si hay algún error.
	public Restaurante obtenerDatos() {
		Restaurante restaurante = null;

		String nombre    = txtFieldNombre.getText().trim();
		String region    = (String) cmbBoxRegion.getSelectedItem();
		String ciudad    = txtFieldCiudad.getText().trim();
		int    distincion = (int) JSpinDistinc.getValue();
		String direccion = txtFieldDireccion.getText().trim();
		String sPrecMin  = txtFieldPrecioMin.getText().trim();
		String sPrecMax  = txtFieldPrecioMax.getText().trim();
		String cocina    = (String) cmbBoxCocina.getSelectedItem();
		String telefono  = txtFieldTelf.getText().trim();
		String web       = txtFieldWeb.getText().trim();
		double precioMin = 0.0;
		double precioMax = 0.0;

		// la ciudad no puede estar vacía
		if (ciudad.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Error. Debe introducir una ciudad.",
					"Error", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				// los precios son opcionales, pero si se introducen tienen que ser numéricos
				if (!sPrecMin.isEmpty()) {
					precioMin = Double.parseDouble(sPrecMin);
				}

				if (!sPrecMax.isEmpty()) {
					precioMax = Double.parseDouble(sPrecMax);
				}

				// si se han introducido los dos precios, el mínimo no puede superar al máximo
				if (precioMax != 0 && precioMin > precioMax) {
					JOptionPane.showMessageDialog(this, "Error. El precio mínimo no puede ser superior al máximo.",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {
					// construimos el objeto con el id guardado al buscar, para que el UPDATE vaya por ID
					restaurante = new Restaurante(id, nombre, region, ciudad, distincion,
							direccion, precioMin, precioMax, cocina, telefono, web);
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Error. El precio mínimo y el máximo deben ser valores numéricos.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		return restaurante;
	}

	// Getters para que el controlador pueda identificar los botones y leer el nombre
	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnGuardarDatos() {
		return btnGuardarDatos;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JTextField getTxtFieldNombre() {
		return txtFieldNombre;
	}

	// Registra el controlador como listener de los botones

	@Override
	public void setControlador(RestaurantesListener ctrl) {
		btnBuscar.addActionListener(ctrl);
		btnGuardarDatos.addActionListener(ctrl);
		btnCancelar.addActionListener(ctrl);		
	}
}
