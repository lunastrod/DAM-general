package com.dam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
select puede devolver 1 valor o varios (if o while)
select puede tener argumentos o no (prepare statement)
insert, update, delete no devuleven nada

*/

// clase para manejar la información de la tabla USUARIOS
public class DAO {
	static final String NOM_TABLA = "USUARIOS";
	static final String COL_USUARIO = "USUARIO";
	static final String COL_PWD = "PASSWORD";
	
	private AccesoDBProp acc;
	
	public DAO() {
		acc = new AccesoDBProp();
	}

	public ArrayList<Restaurante> selectSinArgumentos() {
		/* Cuando el select no tiene ?  */
		String sentencia = "SELECT * FROM " + NOM_TABLA;
		ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;

		try {
			con = acc.getConexion();
			stmt = con.createStatement();
			rslt = stmt.executeQuery(sentencia);
			Restaurante restaurante = null;
			while (rslt.next()) {
				restaurante = new Restaurante(
						rslt.getInt(COL_ID),
						rslt.getString(COL_NOMBRE),
						rslt.getString(COL_REGION),
						rslt.getString(COL_CIUDAD),
						rslt.getString(COL_DISTINCION),
						rslt.getString(COL_DIRECCION),
						rslt.getInt(COL_PRECIO_MINIMO),
						rslt.getInt(COL_PRECIO_MAXIMO),
						rslt.getString(COL_COCINA),
						rslt.getString(COL_TELEFONO),
						rslt.getString(COL_WEB)
					);
				restaurantes.add(restaurante);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            try {
                if (rslt != null) rslt.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
			try {
                if (stmt != null) stmt.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
			try {
                if (con != null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
        }

		return restaurantes;
	}

	public ArrayList<Restaurante> selectWhere(int distincion) {
		/* Cuando el select tiene ?  */
		String sentencia = "SELECT * FROM " + NOM_TABLA + " WHERE " + COL_DISTINCION + " = ?";		
		ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			con = acc.getConexion();
			stmt = con.prepareStatement(sentencia);
			stmt.setInt(1, distincion);
			rslt = stmt.executeQuery();
			Restaurante restaurante = null;
			while (rslt.next()) {
				restaurante = new Restaurante(
						rslt.getInt(COL_ID),
						rslt.getString(COL_NOMBRE),
						rslt.getString(COL_REGION),
						rslt.getString(COL_CIUDAD),
						rslt.getString(COL_DISTINCION),
						rslt.getString(COL_DIRECCION),
						rslt.getInt(COL_PRECIO_MINIMO),
						rslt.getInt(COL_PRECIO_MAXIMO),
						rslt.getString(COL_COCINA),
						rslt.getString(COL_TELEFONO),
						rslt.getString(COL_WEB));
				restaurantes.add(restaurante);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            try {
                if (rslt != null) rslt.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
			try {
                if (stmt != null) stmt.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
			try {
                if (con != null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
        }

		return restaurantes;
	}

	public void Insert(Restaurante r) {
		/* Insert */
		String sentencia = "INSERT INTO " + NOM_TABLA + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";//VALUES (null,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = acc.getConexion();
			stmt = con.prepareStatement(sentencia);
			stmt.setString(1, r.getNombre());
			stmt.setString(2, r.getRegion());
			stmt.setString(3, r.getCiudad());
			stmt.setString(4, r.getDistincion());
			stmt.setString(5, r.getDireccion());
			stmt.setInt(6, r.getPrecioMinimo());
			stmt.setInt(7, r.getPrecioMaximo());
			stmt.setString(8, r.getCocina());
			stmt.setString(9, r.getTelefono());
			stmt.setString(10, r.getWeb());
			stmt.executeUpdate();
			/*execute update devuelve el numero de filas modificadas
			por ejemplo, insert, devuelve cuantas filas insertadas
			delete, devuelve cuantas filas borradas
			update, devuelve cuantas filas actualizadas
			*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
			try {
				if (con != null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
		}
	}

	public void Delete(int id) {
		/* Delete */
		String sentencia = "DELETE FROM " + NOM_TABLA + " WHERE " + COL_ID + " = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = acc.getConexion();
			stmt = con.prepareStatement(sentencia);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
			try {
				if (con != null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
		}
	}


	public void update(){
		/* Update */
		String sentencia="UPDATE " + NOM_TABLA + " SET " +
		COL_NOMBRE + " = ?, " +
		COL_REGION + " = ?, " +
		COL_CIUDAD + " = ?, "+
		COL_DISTINCION + " = ?, " +
		COL_DIRECCION + " = ?, " +
		COL_PRECIO_MINIMO + " = ?, " +
		COL_PRECIO_MAXIMO + " = ?, "+
		COL_COCINA + " = ?, " +
		COL_TELEFONO + " = ?, " +
		COL_WEB + " = ?" +
		" WHERE " +COL_ID + " = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = acc.getConexion();
			stmt = con.prepareStatement(sentencia);
			stmt.setString(1, restaurante.getNombre());
			stmt.setString(2, restaurante.getRegion());
			stmt.setString(3, restaurante.getCiudad());
			stmt.setString(4, restaurante.getDistincion());
			stmt.setString(5, restaurante.getDireccion());
			stmt.setInt(6, restaurante.getPrecioMinimo());
			stmt.setInt(7, restaurante.getPrecioMaximo());
			stmt.setString(8, restaurante.getCocina());
			stmt.setString(9, restaurante.getTelefono());
			stmt.setString(10, restaurante.getWeb());
			stmt.setInt(11, restaurante.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
			try {
				if (con != null) con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
		}
	}



	
	

}
