package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.dam.control.LoginControlador;
import com.dam.model.Usuario;

public class VRegistro extends JFrame {
	
	private static final int ANCHO = 350;
	private static final int ALTO = 200;
	
	// definir constantes para los ActionCommand de los botones
	public static final String AC_BTN_NUEVA_CUENTA = "Nueva Cuenta";
	
	// declarar los componentes que formen la IG 
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnNewButton;
	
	public VRegistro() {
		configurarVentana();
		
		crearComponentes();
	}

	private void crearComponentes() {
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(30, 30, 120, 20);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(170, 28, 120, 25);
		txtUsuario.setToolTipText("Introduce el usuario");
		getContentPane().add(txtUsuario);
		
		JLabel lblPassword = new JLabel("Contraseña: ");
		lblPassword.setBounds(30, 65, 120, 20);
		getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(170, 63, 120, 25);
		// txtPassword.setEchoChar('*');
		txtPassword.setToolTipText("Introduce la contraseña");
		getContentPane().add(txtPassword);
		
		btnNewButton = new JButton(AC_BTN_NUEVA_CUENTA);
		btnNewButton.setBounds(170, 99, 120, 23);
		getContentPane().add(btnNewButton);
		
	}

	private void configurarVentana() {
		setTitle("R E G I S T R O");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(ANCHO, ALTO);
		centrarVentana();
	}
	
	private void centrarVentana() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

    public void ocultar() {
		setVisible(false);
	}

	public void setControlador(LoginControlador lc) {
        btnNewButton.addActionListener(lc);
	}

	public Usuario obtenerDatosUsuario() {
		String usuario = txtUsuario.getText().trim();
		String password = "";
		Usuario user = null;
		
		if (usuario.isEmpty()) {
			// error de datos
			mostrarError("El usuario es un dato obligatorio");
		} else {
			password = txtPassword.getText();
			
			if (password.isEmpty()) {
				// error de datos
				mostrarError("La password es un dato obligatorio");
			} else {
				user = new Usuario(usuario, password);
			}
		}
		
		return user;
	}

	public void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, 
				"ERROR DE DATOS", JOptionPane.ERROR_MESSAGE);
		
	}
}
