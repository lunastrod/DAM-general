package com.dam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RestauranteDAO {
    public static final String NOM_TABLA_RESTAURANTES = "RESTAURANTES";
	public static final String COL_ID = "ID";
	public static final String COL_NOMBRE = "NOMBRE";
    public static final String COL_REGION = "REGION";
    public static final String COL_CIUDAD = "CIUDAD";
    public static final String COL_DISTINCION = "DISTINCION";
    public static final String COL_DIRECCION = "DIRECCION";
    public static final String COL_PRECIO_MINIMO = "PRECIO_MIN";
    public static final String COL_PRECIO_MAXIMO = "PRECIO_MAX";
    public static final String COL_COCINA = "COCINA";
    public static final String COL_TELEFONO = "TELEFONO";
    public static final String COL_WEB = "WEB";

    public static final String[] FILTRO_ESTRELLAS={"1 estrella", "2 estrellas", "3 estrellas"};
    public static final String FILTRO_TODAS="TODAS";
	
	private AccesoDBProp acc;

    public RestauranteDAO(AccesoDBProp acc) {
        this.acc = acc;
    }

    public void modificaRestaurante(Restaurante r) {
        String sentencia = "UPDATE " + NOM_TABLA_RESTAURANTES + " SET " +
            COL_NOMBRE + " = ?, " +
            COL_REGION + " = ?, " +
            COL_CIUDAD + " = ?, " +
            COL_DISTINCION + " = ?, " +
            COL_DIRECCION + " = ?, " +
            COL_PRECIO_MINIMO + " = ?, " +
            COL_PRECIO_MAXIMO + " = ?, " +
            COL_COCINA + " = ?, " +
            COL_TELEFONO + " = ?, " +
            COL_WEB + " = ? " +
            "WHERE " + COL_ID + " = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = acc.getConexion();
            stmt = con.prepareStatement(sentencia);
            stmt.setString(1, r.getNombre());
            stmt.setString(2, r.getRegion());
            stmt.setString(3, r.getCiudad());
            stmt.setInt(4, r.getDistincion());
            stmt.setString(5, r.getDireccion());
            stmt.setDouble(6, r.getPrecioMinimo());
            stmt.setDouble(7, r.getPrecioMaximo());
            stmt.setString(8, r.getCocina());
            stmt.setString(9, r.getTelefono());
            stmt.setString(10, r.getWeb());
            stmt.setInt(11, r.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
    
    public Restaurante buscaRestauranteNombre(String nombre) {
        String sentencia = "SELECT * FROM " + NOM_TABLA_RESTAURANTES + " WHERE " + COL_NOMBRE + " = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        Restaurante restaurante = null;
        try {
            con = acc.getConexion();
            stmt = con.prepareStatement(sentencia);
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                restaurante = new Restaurante(
                    rs.getInt(COL_ID),
                    rs.getString(COL_NOMBRE),
                    rs.getString(COL_REGION),
                    rs.getString(COL_CIUDAD),
                    rs.getInt(COL_DISTINCION),
                    rs.getString(COL_DIRECCION),
                    rs.getDouble(COL_PRECIO_MINIMO),
                    rs.getDouble(COL_PRECIO_MAXIMO),
                    rs.getString(COL_COCINA),
                    rs.getString(COL_TELEFONO),
                    rs.getString(COL_WEB)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
        return restaurante;
    }

    public Restaurante buscaRestauranteNombreParecido(String nombre) {
        String sentencia = "SELECT * FROM " + NOM_TABLA_RESTAURANTES + " WHERE " + COL_NOMBRE + " LIKE ? ORDER BY LENGTH("+COL_NOMBRE+") ASC LIMIT 1";
        Connection con = null;
        PreparedStatement stmt = null;
        Restaurante restaurante = null;
        try {
            con = acc.getConexion();
            stmt = con.prepareStatement(sentencia);
            stmt.setString(1, "%"+nombre+"%");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                restaurante = new Restaurante(
                    rs.getInt(COL_ID),
                    rs.getString(COL_NOMBRE),
                    rs.getString(COL_REGION),
                    rs.getString(COL_CIUDAD),
                    rs.getInt(COL_DISTINCION),
                    rs.getString(COL_DIRECCION),
                    rs.getDouble(COL_PRECIO_MINIMO),
                    rs.getDouble(COL_PRECIO_MAXIMO),
                    rs.getString(COL_COCINA),
                    rs.getString(COL_TELEFONO),
                    rs.getString(COL_WEB)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
        return restaurante;
    }

    public void insertarRestaurante(Restaurante restaurante) {
        String sentencia = "INSERT INTO " + NOM_TABLA_RESTAURANTES + " (" +
            COL_NOMBRE + ", " +
            COL_REGION + ", " +
            COL_CIUDAD + ", " +
            COL_DISTINCION + ", " +
            COL_DIRECCION + ", " +
            COL_PRECIO_MINIMO + ", " +
            COL_PRECIO_MAXIMO + ", " +
            COL_COCINA + ", " +
            COL_TELEFONO + ", " +
            COL_WEB +
        ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = acc.getConexion();
            stmt = con.prepareStatement(sentencia);
            stmt.setString(1, restaurante.getNombre());
            stmt.setString(2, restaurante.getRegion());
            stmt.setString(3, restaurante.getCiudad());
            stmt.setInt(4, restaurante.getDistincion());
            stmt.setString(5, restaurante.getDireccion());
            stmt.setDouble(6, restaurante.getPrecioMinimo());
            stmt.setDouble(7, restaurante.getPrecioMaximo());
            stmt.setString(8, restaurante.getCocina());
            stmt.setString(9, restaurante.getTelefono());
            stmt.setString(10, restaurante.getWeb());
            
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }

    public void eliminarRestaurante(String nombre){
        String sentencia="DELETE FROM " + NOM_TABLA_RESTAURANTES + " WHERE " + COL_NOMBRE + " = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = acc.getConexion();
            stmt = con.prepareStatement(sentencia);
            stmt.setString(1, nombre);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }

    public ArrayList<String> consultarRegiones() {
        String sentencia = "SELECT DISTINCT " + COL_REGION + " FROM " + NOM_TABLA_RESTAURANTES;

        Connection con = null;
        Statement stmt = null;
        ResultSet rslt = null;

        ArrayList<String> regiones = new ArrayList<String>();

        try {
            con = acc.getConexion();
            stmt = con.createStatement();
            rslt = stmt.executeQuery(sentencia);
            while (rslt.next()) {
                regiones.add(rslt.getString(COL_REGION));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rslt != null) rslt.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
        return regiones;
    }

    public ArrayList<Restaurante> consultarRestaurantesFiltro(String distincion,String region) {
        String sentencia = "SELECT " + 
        COL_ID + ", " +
        COL_NOMBRE + ", "+
        COL_REGION + ", " +
        COL_CIUDAD + ", " +
        COL_DISTINCION + ", " +
        COL_DIRECCION + ", " +
        COL_PRECIO_MINIMO + ", " +
        COL_PRECIO_MAXIMO + ", " +
        COL_COCINA + ", " +
        COL_TELEFONO + ", " +
        COL_WEB +
        " FROM " + NOM_TABLA_RESTAURANTES;
        if(!distincion.equals(FILTRO_TODAS) && !region.equals(FILTRO_TODAS)){
            sentencia+=" WHERE " + COL_DISTINCION + " = ? AND " + COL_REGION + " = ?";
        } else if(!distincion.equals(FILTRO_TODAS)){
            sentencia+=" WHERE " + COL_DISTINCION + " = ?";
        } else if(!region.equals(FILTRO_TODAS)){
            sentencia+=" WHERE " + COL_REGION + " = ?";
        }

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rslt = null;

        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

        try {
            con = acc.getConexion();
            stmt = con.prepareStatement(sentencia);
            if(!distincion.equals(FILTRO_TODAS) && !region.equals(FILTRO_TODAS)){
                stmt.setInt(1, Integer.parseInt(distincion));
                stmt.setString(2, region);
            } else if(!distincion.equals(FILTRO_TODAS)){
                stmt.setString(1, distincion);
            } else if(!region.equals(FILTRO_TODAS)){
                stmt.setString(1, region);
            }
            rslt = stmt.executeQuery();
            Restaurante r;
            while (rslt.next()) {
                r = new Restaurante(
                    rslt.getInt(COL_ID),
                    rslt.getString(COL_NOMBRE),
                    rslt.getString(COL_REGION),
                    rslt.getString(COL_CIUDAD),
                    rslt.getInt(COL_DISTINCION),
                    rslt.getString(COL_DIRECCION),
                    rslt.getDouble(COL_PRECIO_MINIMO),
                    rslt.getDouble(COL_PRECIO_MAXIMO),
                    rslt.getString(COL_COCINA),
                    rslt.getString(COL_TELEFONO),
                    rslt.getString(COL_WEB)
                );
                restaurantes.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rslt != null) rslt.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
        return restaurantes;
    }

    
}