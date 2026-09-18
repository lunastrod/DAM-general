package com.dam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// clase para manejar la información de la tabla TABLA_PRUEBA
public class TablaPruebaPersistencia {
	
	static final String NOM_TABLA = "TABLA_PRUEBA";
	static final String COL_ID = "ID";
	static final String COL_DESC = "DESCRIPCION";
	
	private AccesoDBProp acc;
	
	public TablaPruebaPersistencia() {
		acc = new AccesoDBProp();
	}
	
	public ArrayList<RegTablaPrueba> realizarSelect() {
		ArrayList<RegTablaPrueba> listaReg = new ArrayList<RegTablaPrueba>();
		// sentencia que queremos ejecutar: SELECT ID, DESCRIPCION FROM TABLA_PRUEBA
		String sentencia = "SELECT " + COL_ID + "," + COL_DESC + " FROM " + NOM_TABLA;
		System.out.println("### " +sentencia);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		try {
			// 1. establecer la conexión
			con = acc.getConexion();
			
			// 2. crear el objeto que nos permitirá ejecutar una sentencia SQL
			stmt = con.createStatement();
			
			// 3. ejecutamos la sentencia y como es una sentencia SELECT usamos executeQuery que retorna un ResultSet
			// Un ResultSet es una "colección" que contiene los registros resultado de la select
			rslt = stmt.executeQuery(sentencia);
			
			int id;
			String desc;
			RegTablaPrueba reg;
			
			// 4. recorremos el resultSet para recuperar cada registro
			while (rslt.next()) {
				// id = rslt.getInt(1); // posición que ocupa la columna en la sentencia
				id = rslt.getInt(COL_ID);
				// desc = rslt.getString(2);
				desc = rslt.getString(COL_DESC);
				
				reg = new RegTablaPrueba(id, desc);
				listaReg.add(reg);
			}
			
			// liberar los recursos, pero no lo podemos hacer aquí porque si ocurre una excepción en cualquier punto del código anterior, los recursos 
			// se quedarían sin liberar --> hacerlo en un finally --> declarar las variables fuera del try
			
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
		
		return listaReg;
	}
	
	public RegTablaPrueba realizarSelectId(int id) {
		RegTablaPrueba reg = null;
		
		// SELECT ID, DESCRIPCION FROM TABLA_PRUEBA WHERE ID = id
		String sentencia = "SELECT " + COL_ID + "," + COL_DESC + " FROM " + NOM_TABLA + " WHERE " + COL_ID + " = ?";
		// esta sentencia solo puede retornar un registro porque estamos filtrando por la clave primaria
		
		// String sentencia2 = "SELECT " + COL_ID + "," + COL_DESC + " FROM " + NOM_TABLA + " WHERE " + COL_DESC + " LIKE ?";
		// Esta sentencia podría retornar más de un registro
		
		Connection con = null;
		PreparedStatement pstmt = null; // usamos PreparedStatement porque nuestra sentencia depende el valor que venga como parámetro y
		// por esta razón contendrá interrogaciones
		ResultSet rslt = null;
		
		try {
			con = acc.getConexion();
			
			pstmt = con.prepareStatement(sentencia);
			
			// 2.1 completar la sentencia
			pstmt.setInt(1, id);
			// suponiendo la sentencia2
			// pstmt.setString(1, "%" + desc + "%"); // filtrado porque contenga lo que nos llegue por parámetro
			
			rslt = pstmt.executeQuery();
			
			if (rslt.next()) {
				reg = new RegTablaPrueba(rslt.getInt(1), rslt.getString(2));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");
			
		} finally {
			// liberamos los recursos en orden inverso a como se han creado
			try {
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return reg;
	}
	
	// método para insertar un registro en la tabla TABLA_PRUEBA
	public int realizarInsert(RegTablaPrueba reg) {
		int result = 0;
		// INSERT INTO TABLA_PRUEBA (DESCRIPCION) VALUES (?)
		String sentencia = "INSERT INTO " + NOM_TABLA + " (" + COL_DESC + ") VALUES (?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// no necesito ResultSet porque la sentencia no es SELECT
		
		try {
			con = acc.getConexion();
			
			pstmt = con.prepareStatement(sentencia);
			
			// 2.1 completar la sentencia
			pstmt.setString(1, reg.getDesc());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");
			
		} finally {
			// liberamos los recursos en orden inverso a como se han creado
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// método de modificación de una reg de la tabla TABLA_PRUEBA
	public int realizarUpdate(String modifDesc, String filtro) {
		int result = 0;
		// UPDATE TABLA_PRUEBA SET DESCRIPCION = ? WHERE ID = ?
		// UPDATE TABLA_PRUEBA SET DESCRIPCION = DESCRIPCION + ? WHERE DESCRIPCION LIKE ?
		/*String sentencia = "UPDATE " + NOM_TABLA + " SET " + COL_DESC + " = ? || " + COL_ID 
				+ " WHERE " + COL_DESC + " LIKE ?";*/
		String sentencia = "UPDATE " + NOM_TABLA + " SET " + COL_DESC + " = " + COL_DESC +" || ? " 
				+ " WHERE " + COL_DESC + " LIKE ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// no necesito ResultSet porque la sentencia no es SELECT
		
		try {
			con = acc.getConexion();
			
			pstmt = con.prepareStatement(sentencia);
			
			// 2.1 completar la sentencia
			pstmt.setString(1, modifDesc);
			pstmt.setString(2, "%" + filtro + "%");
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");
			
		} finally {
			// liberamos los recursos en orden inverso a como se han creado
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	public int realizarDelete(int id) {
		int result = 0;
		
		// DELETE FROM TABLA_PRUEBA WHERE ID = ?
		String sentencia = "DELETE FROM " + NOM_TABLA + " WHERE " + COL_ID + " = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = acc.getConexion();
			
			pstmt = con.prepareStatement(sentencia);
			
			pstmt.setInt(1, id);
			
			result = pstmt.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// liberamos los recursos en orden inverso a como se han creado
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return result;
	}

}
