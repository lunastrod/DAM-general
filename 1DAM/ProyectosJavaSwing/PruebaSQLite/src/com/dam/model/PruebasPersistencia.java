package com.dam.model;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PruebasPersistencia {
    static final String NOM_TABLA="TABLA_PRUEBA";
    static final String COL_ID="ID";
    static final String COL_DESCRIPCION="DESCRIPCION";
    
    private AccesoDBProp acc;

    public PruebasPersistencia() {
        acc = new AccesoDBProp();
    }

    public RegTablaPrueba realizarSelectId(int id) {
        //select id,descripcion from tabla_prueba where id=?
        String com="SELECT "+COL_ID+","+COL_DESCRIPCION+" FROM "+NOM_TABLA+" WHERE "+COL_ID+"=?";
        
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;

        RegTablaPrueba reg=null;

        try {
            con = acc.getConexion();
            pst = con.prepareStatement(com);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if(rs.next()){
                int idReg=rs.getInt(COL_ID);
                String desc=rs.getString(COL_DESCRIPCION);
                reg=new RegTablaPrueba(idReg,desc);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: SQL");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return reg;
    }

    public ArrayList<RegTablaPrueba> realizarSelect() {
        //select id,descripcion from tabla_prueba
        String com="SELECT "+COL_ID+","+COL_DESCRIPCION+" FROM "+NOM_TABLA;
        ArrayList<RegTablaPrueba> listaReg = new ArrayList<>();

        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            con = acc.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(com);

            int id;
            String desc;
            while (rs.next()) {
                id=rs.getInt(COL_ID);
                desc=rs.getString(COL_DESCRIPCION);
                listaReg.add(new RegTablaPrueba(id,desc));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: SQL");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listaReg;
    }

    public void cerrarRecurso(AutoCloseable recurso) {
        try {
            if (recurso != null) {
                recurso.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void realizarInsert(RegTablaPrueba reg) {
        //insert into tabla_prueba (id,descripcion) values (?,?)
        String com="INSERT INTO "+NOM_TABLA+" ("+COL_DESCRIPCION+") VALUES (?)";
        
        Connection con=null;
        PreparedStatement pst=null;

        try {
            con = acc.getConexion();
            pst = con.prepareStatement(com);
            pst.setString(1, reg.getDescripcion());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarRecurso(pst);
            cerrarRecurso(con);
        }
    }

    public void realizarUpdate(RegTablaPrueba reg) {
        //update tabla_prueba set descripcion=? where id=?
        String com="UPDATE "+NOM_TABLA+" SET "+COL_DESCRIPCION+"=? WHERE "+COL_ID+"=?";

        Connection con=null;
        PreparedStatement pst=null;

        try {
            con = acc.getConexion();
            pst = con.prepareStatement(com);
            pst.setString(1, reg.getDescripcion());
            pst.setInt(2, reg.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarRecurso(pst);
            cerrarRecurso(con);
        }
    }

    public void realizarDelete(RegTablaPrueba reg) {
        //delete from tabla_prueba where id=?
        String com="DELETE FROM "+NOM_TABLA+" WHERE "+COL_ID+"=?";

        Connection con=null;
        PreparedStatement pst=null;

        try {
            con = acc.getConexion();
            pst = con.prepareStatement(com);
            pst.setInt(1, reg.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarRecurso(pst);
            cerrarRecurso(con);
        }
    }
}
