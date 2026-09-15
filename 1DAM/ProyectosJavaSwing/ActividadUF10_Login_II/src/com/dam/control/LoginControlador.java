package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dam.model.Usuario;
import com.dam.model.UsuariosDAO;
import com.dam.view.VLogin;
import com.dam.view.VPrincipal;
import com.dam.view.VRegistro;

public class LoginControlador implements ActionListener {

	public static final int MAX_INTENTOS = 3;
	private VLogin vl;
	private VPrincipal vp;
	private VRegistro vr;
	private UsuariosDAO datosUsuarios;
	private int intentos = 0;
	
	public LoginControlador(VLogin vl, VPrincipal vp, VRegistro vr) {
		this.vl = vl;
		this.vp = vp;
		this.vr = vr;
		this.datosUsuarios = new UsuariosDAO();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Acción: " + e.getActionCommand());
		if (e.getActionCommand().equals(VLogin.AC_BTN_ACCEDER)) {
			// Validar el acceso :
			// Solicitar los datos a la ventana
			Usuario user = vl.obtenerDatosUsuario();
			
			if (user != null) {
				// Comprobar que el usuario existe en la tabla USUARIOS
				// Comprobar que la password almacenada coincide con la password introducida
				String pwd = datosUsuarios.consultarPassword(user.getUsuario());
				intentos++;
				
				int intentosRest = MAX_INTENTOS - intentos;
				if (pwd == null) {
					if (intentosRest > 0) {
						vl.mostrarError("El usuario es incorrecto. Tienes " 
								+ intentosRest);
					} else {
						vl.mostrarError("El usuario es incorrecto. Has agotado intentos");
						vl.dispose();
					}
				} else {
					if (pwd.equals(user.getPassword())) {
						// accede
						vl.dispose();
						vr.dispose();
						vp.hacerVisible();
					} else {
						if (intentosRest > 0) {
							vl.mostrarError("La contraseña es incorrecta. Tienes " 
									+ intentosRest);
						} else {
							vl.mostrarError("La contraseña es incorrecta. Has agotado intentos");
							vl.dispose();
						}
					}
				}
			}
		}
		else if (e.getActionCommand().equals(VLogin.AC_BTN_REGISTRO)) {
			// Mostrar la ventana de registro
			vl.ocultar();
			vr.hacerVisible();
		}
		else if (e.getActionCommand().equals(VRegistro.AC_BTN_NUEVA_CUENTA)) {
			// Registrar un nuevo usuario
			Usuario user = vr.obtenerDatosUsuario();
			
			if (user != null) {
				// Comprobar que el usuario no existe en la tabla USUARIOS
				String pwd = datosUsuarios.consultarPassword(user.getUsuario());
				
				if (pwd == null) {
					// Insertar el nuevo usuario en la tabla USUARIOS
					datosUsuarios.insertarUsuario(user);
					
					vr.ocultar();
					vl.hacerVisible();
				} else {
					vr.mostrarError("El usuario ya existe. Elige otro nombre de usuario");
				}
			}
		}	

	}

}
