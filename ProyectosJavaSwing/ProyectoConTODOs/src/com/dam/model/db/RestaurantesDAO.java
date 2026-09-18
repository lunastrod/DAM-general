// LAS FUNCIONES DEL DAO SIEMPRE SE LLAMARAN EN EL CONTROLADOR

package com.dam.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dam.model.data.Restaurante;
import com.dam.model.data.Texto;

public class RestaurantesDAO {

	private AccesoDB acceso;

	public RestaurantesDAO() {
		acceso = new AccesoDB();
	}

	// TODO: implementar selectRegiones
	// SELECT DISTINCT de la columna REGION
	// Devuelve un ArrayList<String> con todas las regiones distintas de la tabla
	// Lo usa el controlador para rellenar el combo de regiones del panel de consulta
	public ArrayList<String> selectRegiones() {
		ArrayList<String> listaRegiones = new ArrayList<String>();

		// TODO: escribir la query con SELECT DISTINCT

		Connection con = null;
		Statement stmt = null;   // TODO: Statement porque no tiene "?"
		ResultSet rslt = null;

		try {
			// TODO: 1. establecer la conexión con acceso.getConexion()

			// TODO: 2. crear el Statement con con.createStatement()

			// TODO: 3. ejecutar la query con stmt.executeQuery() — es un SELECT

			// TODO: 4. recorrer el ResultSet con while(rslt.next()) y añadir cada región al ArrayList

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 5. liberar recursos en orden inverso: rslt, stmt, con
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRegiones;
	}

	// SELECT SIN FILTRO — devuelve todos los restaurantes
	public ArrayList<Restaurante> selectRestaurantes() {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();

		// TODO: escribir la query SELECT * FROM tabla

		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;

		try {
			// TODO: 1. establecer la conexión

			// TODO: 2. crear el Statement

			// TODO: 3. ejecutar la query

			// TODO: 4. recorrer el ResultSet con while(rslt.next()) y construir cada Restaurante
			//          new Restaurante(rslt.getInt(1), rslt.getString(COL_NOMBRE), ...)
			//          añadir cada restaurante al ArrayList

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 5. liberar recursos
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRestaurantes;
	}

	// SELECT CON UN FILTRO — devuelve los restaurantes de una región
	public ArrayList<Restaurante> selectRestaurantesReg(String reg) {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();

		// TODO: escribir la query SELECT * FROM tabla WHERE REGION = ?

		Connection con = null;
		PreparedStatement stmt = null;  // TODO: PreparedStatement porque tiene "?"
		ResultSet rslt = null;

		try {
			// TODO: 1. establecer la conexión

			// TODO: 2. preparar la sentencia con con.prepareStatement(query)

			// TODO: 2.1 asignar el parámetro con stmt.setString(1, reg)

			// TODO: 3. ejecutar con stmt.executeQuery() — sin parámetros porque ya se asignaron

			// TODO: 4. recorrer el ResultSet y construir cada Restaurante

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 5. liberar recursos
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRestaurantes;
	}

	// SELECT CON UN FILTRO — devuelve los restaurantes de una distinción
	public ArrayList<Restaurante> selectRestaurantesDist(int dist) {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();

		// TODO: escribir la query SELECT * FROM tabla WHERE DISTINCION = ?

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			// TODO: 1. establecer la conexión

			// TODO: 2. preparar la sentencia

			// TODO: 2.1 asignar el parámetro con stmt.setInt(1, dist)

			// TODO: 3. ejecutar la query

			// TODO: 4. recorrer el ResultSet y construir cada Restaurante

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 5. liberar recursos
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRestaurantes;
	}

	// SELECT CON DOS FILTROS — devuelve los restaurantes de una región y una distinción
	public ArrayList<Restaurante> selectRestaurantesFiltro(String reg, int dist) {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();

		// TODO: escribir la query SELECT * FROM tabla WHERE REGION = ? AND DISTINCION = ?

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			// TODO: 1. establecer la conexión

			// TODO: 2. preparar la sentencia

			// TODO: 2.1 asignar los parámetros: stmt.setString(1, reg) y stmt.setInt(2, dist)

			// TODO: 3. ejecutar la query

			// TODO: 4. recorrer el ResultSet y construir cada Restaurante

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 5. liberar recursos
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRestaurantes;
	}

	// SELECT CON TODOS LOS FILTROS EN UN SOLO MÉTODO
	// reg y dist llegan como String — si son "TODAS" no se aplica ese filtro
	public ArrayList<Restaurante> selectRestaurantesFiltro(String reg, String dist) {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();

		// TODO: construir la query base SELECT * FROM tabla
		//       y añadir el WHERE dinámicamente según si reg y dist son "TODAS" o no:
		//       si los dos tienen valor  --> WHERE REGION = ? AND DISTINCION = ?
		//       si solo reg tiene valor  --> WHERE REGION = ?
		//       si solo dist tiene valor --> WHERE DISTINCION = ?
		//       si los dos son TODAS     --> sin WHERE (devuelve todos)

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		try {
			// TODO: 1. establecer la conexión

			// TODO: 2. preparar la sentencia con con.prepareStatement(query)

			// TODO: 2.1 asignar los parámetros según los mismos if/else que construyeron la query
			//           para dist usar Character.getNumericValue(dist.charAt(0)) para convertir "1 estrella" a 1

			// TODO: 3. ejecutar la query

			// TODO: 4. recorrer el ResultSet y construir cada Restaurante

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 5. liberar recursos
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaRestaurantes;
	}

	// INSERT — inserta un nuevo restaurante en la tabla
	// Devuelve 1 si se insertó correctamente, 0 si hubo error
	public int insertRestaurante(Restaurante restaurante) {
		int res = 0;

		// TODO: escribir la query INSERT INTO tabla (COL1, COL2, ...) VALUES (?, ?, ...)
		//       las columnas son: NOMBRE, REGION, CIUDAD, DISTINCION, DIRECCION,
		//                         PRECIO_MIN, PRECIO_MAX, COCINA, TELEFONO, WEB

		Connection con = null;
		PreparedStatement stmt = null;
		// no hay ResultSet porque no es un SELECT

		try {
			// TODO: 1. establecer la conexión

			// TODO: 2. preparar la sentencia

			// TODO: 2.1 asignar los 10 parámetros con los getters del objeto restaurante:
			//           stmt.setString(1, restaurante.getNombre())
			//           stmt.setString(2, restaurante.getRegion())  ... etc.

			// TODO: 3. ejecutar con stmt.executeUpdate() — devuelve el número de filas insertadas

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 4. liberar recursos (no hay rslt aquí)
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return res;
	}

	// DELETE — borra el restaurante con el nombre indicado
	// Devuelve 1 si se borró, 0 si no se encontró
	public int deleteRestaurante(String nombre) {
		int res = 0;

		// TODO: escribir la query DELETE FROM tabla WHERE NOMBRE = ?

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			// TODO: 1. establecer la conexión

			// TODO: 2. preparar la sentencia

			// TODO: 2.1 asignar el parámetro con stmt.setString(1, nombre)

			// TODO: 3. ejecutar con stmt.executeUpdate()

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 4. liberar recursos
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return res;
	}

	// SELECT POR NOMBRE — busca un restaurante por nombre con LIKE
	// Devuelve el objeto Restaurante si lo encuentra, null si no existe
	// Lo usa el controlador para cargar los datos en el panel de modificación
	public Restaurante selectRestauranteNombre(String nombre) {
		Restaurante restaurante = null;

		// TODO: escribir la query SELECT * FROM tabla WHERE NOMBRE LIKE ?
		//       al asignar el parámetro usar: "%" + nombre + "%"
		//       para que encuentre aunque el usuario no escriba el nombre completo

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;

		try {
			// TODO: 1. establecer la conexión

			// TODO: 2. preparar la sentencia

			// TODO: 2.1 asignar el parámetro con pstmt.setString(1, "%" + nombre + "%")

			// TODO: 3. ejecutar la query

			// TODO: 4. como NOMBRE es UNIQUE solo puede devolver un resultado — usar IF en vez de while
			//          if (rslt.next()) { restaurante = new Restaurante(...) }

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 5. liberar recursos
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return restaurante;
	}

	// UPDATE — modifica los datos de un restaurante identificado por su ID
	// Devuelve 1 si se modificó correctamente, 0 si hubo error
	public int updateRestaurante(Restaurante restaurante) {
		int res = 0;

		// TODO: escribir la query UPDATE tabla SET COL1 = ?, COL2 = ?, ... WHERE ID = ?
		//       las columnas a actualizar son: REGION, CIUDAD, DISTINCION, DIRECCION,
		//                                      PRECIO_MIN, PRECIO_MAX, COCINA, TELEFONO, WEB
		//       el WHERE va por ID (no por nombre) para que sea más seguro

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// TODO: 1. establecer la conexión

			// TODO: 2. preparar la sentencia

			// TODO: 2.1 asignar los 9 parámetros del SET con los getters del objeto restaurante
			//           y el parámetro 10 (el WHERE) con pstmt.setInt(10, restaurante.getId())

			// TODO: 3. ejecutar con pstmt.executeUpdate()

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 4. liberar recursos
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return res;
	}

}
