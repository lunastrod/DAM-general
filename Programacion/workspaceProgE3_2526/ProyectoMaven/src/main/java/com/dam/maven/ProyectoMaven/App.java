package com.dam.maven.ProyectoMaven;

import java.sql.Connection;
import java.sql.SQLException;

//import com.dam.maven.ProyectoMaven.model.AccesoDB;
import com.dam.maven.ProyectoMaven.model.AccesoDBProp;

/**
 * Probar la conexión con la base de datos
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AccesoDBProp acceso = new AccesoDBProp();
        try {
        	Connection con = acceso.getConexion();
        	
        	System.out.println("Conexión establecida");
        	
        	con.close();
        	
        	System.out.println("Conexión cerrada");
        	
        } catch (ClassNotFoundException e) {
			System.out.println("El driver no es correcto");
		} catch (SQLException e) {
			System.out.println("La url no es correcta o hay algún problema con la base de datos");
		}
    }
}
