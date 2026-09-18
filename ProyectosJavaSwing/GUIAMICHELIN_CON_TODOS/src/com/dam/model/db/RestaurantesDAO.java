package com.dam.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dam.model.data.Restaurante;

public class RestaurantesDAO {

	private static final String NOM_TABLA         = "RESTAURANTES";
	private static final String COLUMN_ID         = "ID";
	private static final String COLUMN_NOM        = "NOMBRE";
	private static final String COLUMN_REGION     = "REGION";
	private static final String COLUMN_CIUDAD     = "CIUDAD";
	private static final String COLUMN_DISTINCION = "DISTINCION";
	private static final String COLUMN_DIRECCION  = "DIRECCION";
	private static final String COLUMN_PRECIO_MIN = "PRECIO_MIN";
	private static final String COLUMN_PRECIO_MAX = "PRECIO_MAX";
	private static final String COLUMN_COCINA     = "COCINA";
	private static final String COLUMN_TELEFONO   = "TELEFONO";
	private static final String COLUMN_WEB        = "WEB";

	private AccesoDB acc;

	public RestaurantesDAO() {
		acc = new AccesoDB();
	}

	// metodo que devuelva las regiones (hacer consulta de bases de datos). Con esto
	// relleno el comboBox regiones
	public ArrayList<String> consultarRegiones() { // no le paso nada por parametro, no hace falta. Quiero devolver
													// todas las regiones de nada, no le paso nada por parametro.

		String consultaRegion = "SELECT DISTINCT " + COLUMN_REGION + " FROM " + NOM_TABLA;

		ArrayList<String> listaRegiones = new ArrayList<>();

		Connection con  = null;
		Statement stmt  = null;
		ResultSet rslt  = null;

		try {
			// 1. establecer la conexión
			con  = acc.getConexion();

			// 2. crear el objeto que nos permitirá ejecutar una sentencia SQL
			stmt = con.createStatement();

			// 3. ejecutamos la sentencia y como es una sentencia SELECT usamos executeQuery
			// que retorna un ResultSet
			// Un ResultSet es una "colección" que contiene los registros resultado de la select
			rslt = stmt.executeQuery(consultaRegion);

			// 4. recorremos el resultSet para recuperar cada registro. IF si quiero una
			// cosa, y un while si quiero muchas
			while (rslt.next()) {
				listaRegiones.add(rslt.getString(COLUMN_REGION));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");

		} finally {

			// 5. liberamos los recursos
			try {
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con  != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRegiones;
	}

	// metodo que devuelva los restaurantes (hacer consulta de bases de datos)
	// restaurante tiene muchos campos, tengo que crear un arrayList de restaurantes
	// (tiene ciudad, region, cocina, etc)
	public ArrayList<Restaurante> consultarRestaurantes() { // sacar todos los restaurantes. ArrayList de objeto
															// restaurante. No le paso nada por parametro

		String consultaRestaurante = "SELECT " + "*" + " FROM " + NOM_TABLA;

		ArrayList<Restaurante> listaRestaurante = new ArrayList<>();

		Connection con  = null;
		Statement stmt  = null;
		ResultSet rslt  = null;

		try {
			// 1. establecer la conexión
			con  = acc.getConexion();

			// 2. crear el objeto que nos permitirá ejecutar una sentencia SQL
			stmt = con.createStatement();

			// 3. ejecutamos la sentencia y como es una sentencia SELECT usamos executeQuery
			// que retorna un ResultSet
			rslt = stmt.executeQuery(consultaRestaurante);

			// 4. recorremos el resultSet para recuperar cada registro. IF si quiero una
			// cosa, y un while si quiero muchas
			while (rslt.next()) {
				listaRestaurante.add(new Restaurante(rslt.getInt(COLUMN_ID), rslt.getString(COLUMN_NOM),
						rslt.getString(COLUMN_REGION), rslt.getString(COLUMN_CIUDAD), rslt.getInt(COLUMN_DISTINCION),
						rslt.getString(COLUMN_DIRECCION), rslt.getDouble(COLUMN_PRECIO_MIN),
						rslt.getDouble(COLUMN_PRECIO_MAX), rslt.getString(COLUMN_COCINA),
						rslt.getString(COLUMN_TELEFONO), rslt.getString(COLUMN_WEB)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");

		} finally {

			// 5. liberamos los recursos
			try {
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con  != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRestaurante;
	}

	public ArrayList<Restaurante> consultarRestaurantesRegion(String region) {

		String consultaRestaurante = "SELECT * FROM " + NOM_TABLA + " WHERE " + COLUMN_REGION + " = ?";

		ArrayList<Restaurante> listaRestaurante = new ArrayList<>();

		Connection con         = null;
		PreparedStatement stmt = null; // porque tengo interrogacion. Lo tengo que completar antes de ejecutar
		ResultSet rslt         = null;

		try {
			// 1. establecer la conexión
			con  = acc.getConexion();

			// 2. crear el objeto que nos permitirá ejecutar una sentencia SQL
			stmt = con.prepareStatement(consultaRestaurante);

			// 2.1 configurar la sentencia — el 1 hace referencia a la primera interrogacion
			stmt.setString(1, region);

			// 3. ejecutamos la sentencia. Antes ya hemos preparado la sentencia, y pasamos
			// a ejecutarla sin pasarle nada por parametro (lo pasamos antes)
			rslt = stmt.executeQuery(); // aqui no hace falta pasarle consultaRestaurante

			// 4. recorremos el resultSet para recuperar cada registro
			while (rslt.next()) {
				listaRestaurante.add(new Restaurante(rslt.getInt(COLUMN_ID), rslt.getString(COLUMN_NOM),
						rslt.getString(COLUMN_REGION), rslt.getString(COLUMN_CIUDAD), rslt.getInt(COLUMN_DISTINCION),
						rslt.getString(COLUMN_DIRECCION), rslt.getDouble(COLUMN_PRECIO_MIN),
						rslt.getDouble(COLUMN_PRECIO_MAX), rslt.getString(COLUMN_COCINA),
						rslt.getString(COLUMN_TELEFONO), rslt.getString(COLUMN_WEB)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");

		} finally { // si todo ha ido bien, y se han creado los recursos, liberamos en orden inverso

			try {
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con  != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRestaurante;
	}

	public ArrayList<Restaurante> consultarRestaurantesDistincion(int distincion) {

		String consultaRestaurante = "SELECT * FROM " + NOM_TABLA + " WHERE " + COLUMN_DISTINCION + " = ?";

		ArrayList<Restaurante> listaRestaurante = new ArrayList<>();

		Connection con         = null;
		PreparedStatement stmt = null;
		ResultSet rslt         = null; // porque es un select, que devuelve una fila de datos (ResultSet es el objeto
									   // que contiene esas filas, y la recorremos con next)

		try {
			// 1. establecer la conexión
			con  = acc.getConexion();

			// 2. crear el objeto que nos permitirá ejecutar una sentencia SQL
			stmt = con.prepareStatement(consultaRestaurante);

			// 2.1 configurar la sentencia — el 1 hace referencia a la primera interrogacion
			stmt.setInt(1, distincion);

			// 3. ejecutamos la sentencia
			rslt = stmt.executeQuery();

			// 4. recorremos el resultSet para recuperar cada registro
			while (rslt.next()) {
				listaRestaurante.add(new Restaurante(rslt.getInt(COLUMN_ID), rslt.getString(COLUMN_NOM),
						rslt.getString(COLUMN_REGION), rslt.getString(COLUMN_CIUDAD), rslt.getInt(COLUMN_DISTINCION),
						rslt.getString(COLUMN_DIRECCION), rslt.getDouble(COLUMN_PRECIO_MIN),
						rslt.getDouble(COLUMN_PRECIO_MAX), rslt.getString(COLUMN_COCINA),
						rslt.getString(COLUMN_TELEFONO), rslt.getString(COLUMN_WEB)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");

		} finally {

			// 5. liberamos los recursos
			try {
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con  != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRestaurante;
	}

	public ArrayList<Restaurante> consultarRestaurantesRegionDistincion(String region, int distincion) {

		String consultaRestaurante = "SELECT * FROM " + NOM_TABLA + " WHERE " + COLUMN_REGION + " = ?" + " AND "
				+ COLUMN_DISTINCION + " = ?";

		ArrayList<Restaurante> listaRestaurante = new ArrayList<>();

		Connection con         = null;
		PreparedStatement stmt = null;
		ResultSet rslt         = null;

		try {
			// 1. establecer la conexión
			con  = acc.getConexion();

			// 2. crear el objeto que nos permitirá ejecutar una sentencia SQL.
			// PreparedStatement porque hay interrogaciones "?"
			stmt = con.prepareStatement(consultaRestaurante);

			// 2.1 configurar la sentencia
			stmt.setString(1, region);   // el 1 hace referencia a la primera interrogacion de la consulta
			stmt.setInt(2, distincion);  // el 2 hace referencia a la segunda interrogacion de la consulta

			// 3. ejecutamos la sentencia
			rslt = stmt.executeQuery();

			// 4. recorremos el resultSet para recuperar cada registro
			while (rslt.next()) {
				listaRestaurante.add(new Restaurante(rslt.getInt(COLUMN_ID), rslt.getString(COLUMN_NOM),
						rslt.getString(COLUMN_REGION), rslt.getString(COLUMN_CIUDAD), rslt.getInt(COLUMN_DISTINCION),
						rslt.getString(COLUMN_DIRECCION), rslt.getDouble(COLUMN_PRECIO_MIN),
						rslt.getDouble(COLUMN_PRECIO_MAX), rslt.getString(COLUMN_COCINA),
						rslt.getString(COLUMN_TELEFONO), rslt.getString(COLUMN_WEB)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");

		} finally {

			// 5. liberamos los recursos
			try {
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con  != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRestaurante;
	}

	// Busca un restaurante por nombre exacto.
	// Devuelve el objeto Restaurante si lo encuentra, o null si no existe.
	// Lo usa el controlador antes de insertar para comprobar si el nombre ya está en la BBDD.
	public Restaurante consultarRestaurantePorNombre(String nombre) {

		String consultaRestaurante = "SELECT * FROM " + NOM_TABLA + " WHERE " + COLUMN_NOM + " = ?";

		Restaurante restaurante = null; // si no encuentra nada, devuelve null

		Connection con         = null;
		PreparedStatement stmt = null;
		ResultSet rslt         = null;

		try {
			// 1. establecer la conexión
			con  = acc.getConexion();

			// 2. crear el objeto que nos permitirá ejecutar una sentencia SQL
			stmt = con.prepareStatement(consultaRestaurante);

			// 2.1 configurar la sentencia — el 1 hace referencia a la primera interrogacion
			stmt.setString(1, nombre);

			// 3. ejecutamos la sentencia
			rslt = stmt.executeQuery();

			// 4. como solo puede haber un resultado (NOMBRE es UNIQUE), usamos IF en vez de while
			if (rslt.next()) {
				restaurante = new Restaurante(rslt.getInt(COLUMN_ID), rslt.getString(COLUMN_NOM),
						rslt.getString(COLUMN_REGION), rslt.getString(COLUMN_CIUDAD), rslt.getInt(COLUMN_DISTINCION),
						rslt.getString(COLUMN_DIRECCION), rslt.getDouble(COLUMN_PRECIO_MIN),
						rslt.getDouble(COLUMN_PRECIO_MAX), rslt.getString(COLUMN_COCINA),
						rslt.getString(COLUMN_TELEFONO), rslt.getString(COLUMN_WEB));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");

		} finally {

			// 5. liberamos los recursos
			try {
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con  != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return restaurante;
	}

	// parte del ejercicio 2
	// Elimina el restaurante con el nombre indicado.
	// Devuelve 1 si se borró una fila, 0 si no se encontró el registro.
	public int realizarDelete(String nombre) {

		String sentencia = "DELETE FROM " + NOM_TABLA + " WHERE " + COLUMN_NOM + " = ?";

		Connection con          = null;
		PreparedStatement pstmt = null;
		int result = 0; // declarada aquí, fuera del try. DELETE, INSERT y UPDATE no devuelven filas,
						// devuelven un entero que indica cuántas filas fueron afectadas

		try {
			con   = acc.getConexion();
			pstmt = con.prepareStatement(sentencia);
			pstmt.setString(1, nombre);
			result = pstmt.executeUpdate(); // asignamos directamente a result

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con   != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result; // devuelve cuantas filas se borraron. Puede ser 0 (no se encontro nada) o 1 (se borro una fila)
	} // en el controlador decido que hacer con cada resultado

	// parte del ejercicio 3
	// Inserta un nuevo restaurante en la tabla.
	// Devuelve 1 si la inserción fue correcta, 0 si hubo algún error.
	public int realizarInsert(Restaurante res) {

		String sentencia = "INSERT INTO " + NOM_TABLA + " ("
				+ COLUMN_NOM        + ", "
				+ COLUMN_REGION     + ", "
				+ COLUMN_CIUDAD     + ", "
				+ COLUMN_DISTINCION + ", "
				+ COLUMN_DIRECCION  + ", "
				+ COLUMN_PRECIO_MIN + ", "
				+ COLUMN_PRECIO_MAX + ", "
				+ COLUMN_COCINA     + ", "
				+ COLUMN_TELEFONO   + ", "
				+ COLUMN_WEB
				+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection con          = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con   = acc.getConexion();
			pstmt = con.prepareStatement(sentencia);

			// completamos cada interrogacion con el dato correspondiente del objeto Restaurante
			pstmt.setString(1, res.getNombre());
			pstmt.setString(2, res.getRegion());
			pstmt.setString(3, res.getCiudad());
			pstmt.setInt   (4, res.getDistincion());
			pstmt.setString(5, res.getDireccion());

			// Los precios son opcionales: si valen 0.0 es que el usuario los dejó en blanco,
			// así que guardamos NULL en la BBDD en vez de un 0 que podría confundir
			if (res.getPrecioMin() == 0.0) {
				pstmt.setNull(6, java.sql.Types.REAL);
			} else {
				pstmt.setDouble(6, res.getPrecioMin());
			}

			if (res.getPrecioMax() == 0.0) {
				pstmt.setNull(7, java.sql.Types.REAL);
			} else {
				pstmt.setDouble(7, res.getPrecioMax());
			}

			pstmt.setString(8,  res.getCocina());
			pstmt.setString(9,  res.getTelefono());
			pstmt.setString(10, res.getWeb());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");

		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con   != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// parte del ejercicio 4
	// Modifica los datos de un restaurante identificado por su ID.
	// Devuelve 1 si la modificación fue correcta, 0 si hubo algún error.
	public int realizarUpdate(Restaurante res) {

		// UPDATE tabla SET col1 = ?, col2 = ?, ... WHERE ID = ?
		// no modificamos el NOMBRE porque es la clave candidata que usamos para buscar
		String sentencia = "UPDATE " + NOM_TABLA + " SET "
				+ COLUMN_REGION     + " = ?, "
				+ COLUMN_CIUDAD     + " = ?, "
				+ COLUMN_DISTINCION + " = ?, "
				+ COLUMN_DIRECCION  + " = ?, "
				+ COLUMN_PRECIO_MIN + " = ?, "
				+ COLUMN_PRECIO_MAX + " = ?, "
				+ COLUMN_COCINA     + " = ?, "
				+ COLUMN_TELEFONO   + " = ?, "
				+ COLUMN_WEB        + " = ? "
				+ "WHERE " + COLUMN_ID + " = ?"; // identificamos por ID, más seguro que por nombre

		Connection con          = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con   = acc.getConexion();
			pstmt = con.prepareStatement(sentencia);

			// completamos cada interrogacion con el dato correspondiente del objeto Restaurante
			pstmt.setString(1, res.getRegion());
			pstmt.setString(2, res.getCiudad());
			pstmt.setInt   (3, res.getDistincion());
			pstmt.setString(4, res.getDireccion());

			// los precios son opcionales: guardamos NULL si el usuario los dejó en blanco
			if (res.getPrecioMin() == 0.0) {
				pstmt.setNull(5, java.sql.Types.REAL);
			} else {
				pstmt.setDouble(5, res.getPrecioMin());
			}

			if (res.getPrecioMax() == 0.0) {
				pstmt.setNull(6, java.sql.Types.REAL);
			} else {
				pstmt.setDouble(6, res.getPrecioMax());
			}

			pstmt.setString(7, res.getCocina());
			pstmt.setString(8, res.getTelefono());
			pstmt.setString(9, res.getWeb());
			pstmt.setInt   (10, res.getId()); // el WHERE va por ID (posición 10, la última interrogacion)

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: se ha producido un error en la comunicación con la base de datos");

		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con   != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
