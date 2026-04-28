package com.dam.model;

import java.awt.Taskbar.State;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RestauranteDAO {
    static final String NOM_TABLA_RESTAURANTES = "RESTAURANTES";
	static final String COL_ID = "ID";
	static final String COL_NOMBRE = "NOMBRE";
    static final String COL_REGION = "REGION";
    static final String COL_CIUDAD = "CIUDAD";
    static final String COL_DISTINCION = "DISTINCION";
    static final String COL_DIRECCION = "DIRECCION";
    static final String COL_PRECIO_MINIMO = "PRECIO_MIN";
    static final String COL_PRECIO_MAXIMO = "PRECIO_MAX";
    static final String COL_COCINA = "COCINA";
    static final String COL_TELEFONO = "TELEFONO";
    static final String COL_WEB = "WEB";

    static final String[] FILTRO_ESTRELLAS={"1 estrella", "2 estrellas", "3 estrellas"};
    static final String FILTRO_TODAS="TODAS";
	
	private AccesoDBProp acc;

    public RestauranteDAO(AccesoDBProp acc) {
        this.acc = acc;
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