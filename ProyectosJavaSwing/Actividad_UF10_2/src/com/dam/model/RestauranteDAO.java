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
                stmt.setString(1, distincion);
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