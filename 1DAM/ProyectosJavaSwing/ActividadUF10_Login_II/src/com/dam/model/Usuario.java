package com.dam.model;

// representa un registro de la tabla USUARIOS
public class Usuario {
	private String usuario;
	private String password;
	
	public Usuario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + "]";
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}
	
}
