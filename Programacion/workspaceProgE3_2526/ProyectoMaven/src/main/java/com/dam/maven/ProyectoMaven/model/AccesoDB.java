package com.dam.maven.ProyectoMaven.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {
	
	private String driver;
	private String url;
	
	public AccesoDB() {
		driver = "org.sqlite.JDBC";
		url = "jdbc:sqlite:DB/DATOS_PRUEBAS1.db";
	}
	
	public Connection getConexion() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url);
		
		return con;
	}

}
