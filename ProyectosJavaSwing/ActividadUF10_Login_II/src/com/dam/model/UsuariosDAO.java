package com.dam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// clase para manejar la información de la tabla USUARIOS
public class UsuariosDAO {
	
	static final String NOM_TABLA = "USUARIOS";
	static final String COL_USUARIO = "USUARIO";
	static final String COL_PWD = "PASSWORD";
	
	private AccesoDBProp acc;
	
	public UsuariosDAO() {
		acc = new AccesoDBProp();
	}

	public void insertarUsuario(Usuario u) {
		String sentencia = "INSERT INTO " + NOM_TABLA + " (" + COL_USUARIO + ", " + COL_PWD + ") VALUES (?, ?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// 1. establecer la conexión
			con = acc.getConexion();
			
			// 2. crear el objeto que nos permitirá ejecutar una sentencia SQL
			stmt = con.prepareStatement(sentencia);
			
			// 2.1 configurar la sentencia
			stmt.setString(1, u.getUsuario());
			stmt.setString(2, u.getPassword());
			
			// 3. ejecutamos la sentencia
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
			
	// un método que me devuelva la contraseña para un usuario
	public String consultarPassword(String usuario) {
		String pwd = null;
		// sentencia que queremos ejecutar: SELECT PASSWORD FROM USUARIOS WHERE USUARIO = usuario
		
		String sentencia = "SELECT " + COL_PWD + " FROM " + NOM_TABLA + " WHERE " + COL_USUARIO + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		try {
			// 1. establecer la conexión
			con = acc.getConexion();
			
			// 2. crear el objeto que nos permitirá ejecutar una sentencia SQL
			stmt = con.prepareStatement(sentencia);
			
			// 2.1 configurar la sentencia
			stmt.setString(1, usuario);
			
			// 3. ejecutamos la sentencia y como es una sentencia SELECT usamos executeQuery que retorna un ResultSet
			// Un ResultSet es una "colección" que contiene los registros resultado de la select
			rslt = stmt.executeQuery();
			
			// 4. recorremos el resultSet para recuperar cada registro
			if (rslt.next()) {
				pwd = rslt.getString(COL_PWD);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");
			
		} finally {
			
			// 5. liberamos los recursos
			try {
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return pwd;
	}
	
	

}
