package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.dam.view.RegistraRestaurante;
import com.dam.model.Restaurante;
import com.dam.model.RestauranteDAO;
import com.dam.view.ConsultaRestaurantes;
import com.dam.view.ModificaRestaurante;
import com.dam.view.VentanaPrincipal;

public class Controlador implements ActionListener {
    private VentanaPrincipal v;
    private ConsultaRestaurantes p1;
    private RegistraRestaurante p2;
    private ModificaRestaurante p3;
    private RestauranteDAO dao;

    public Controlador(VentanaPrincipal v, ConsultaRestaurantes p1,RegistraRestaurante p2, ModificaRestaurante p3, RestauranteDAO dao) {
        this.v = v;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.dao = dao;
    }

    private void actualizaTablaRestaurantes(String d,String p){
        ArrayList<Restaurante> r = dao.consultarRestaurantesFiltro(d, p);
        if(r.isEmpty()){
            p1.mostrarComponentesResultado(false);
            v.mensajeInfo("No se han encontrado datos para el filtro introducido","Resultado de Consulta");
        }
        else{
            p1.mostrarComponentesResultado(true);
            p1.actualizaTablaRestaurantes(r);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String comando= e.getActionCommand();
        
        System.out.println(comando);
        if(e.getSource() instanceof JMenuItem){
            switch (comando) {
                case VentanaPrincipal.COMANDO_MENU_CONSULTA:
                    p1.actualizaComboRegion(dao.consultarRegiones());
                    p1.mostrarComponentesResultado(false);
                    v.cargarPanel(p1);
                    break;
                case VentanaPrincipal.COMANDO_MENU_REGISTRO:
                    v.cargarPanel(p2);
                    break;
                case VentanaPrincipal.COMANDO_MENU_MODIFICACION:
                    p3.limpiarValores();
                    p3.mostrarDatos(false);
                    p3.bloqueaBusqueda(false);
                    v.cargarPanel(p3);
                    break;
                case VentanaPrincipal.COMANDO_MENU_SALIR:
                    if(v.mensajeConfirmacion("Se va a cerrar la aplicación, ¿desea continuar?", "Confirmación")){
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Comando no reconocido");
                    break;
            }
        }
        else if(e.getSource() instanceof JButton){
            Restaurante r;
            switch (comando) {
                case ConsultaRestaurantes.COMANDO_BTN_CONSULTAR:
                    actualizaTablaRestaurantes(p1.getDistincion(),p1.getRegion());
                    break;
                case ConsultaRestaurantes.COMANDO_BTN_ELIMINAR:
                    String nombreRestaurante=p1.getRestauranteSeleccionado();
                    if(nombreRestaurante!=null){
                        if(v.mensajeConfirmacion("Se va a eliminar el registro seleccionado, ¿desea continuar?", "Confirmación")){
                            dao.eliminarRestaurante(nombreRestaurante);
                            v.mensajeInfo("Se ha eliminado el restaurante con éxito","Resultado de operación");
                            actualizaTablaRestaurantes(p1.getDistincion(),p1.getRegion());
                        }
                    }
                    else{
                        v.mensajeError("Debe seleccionar el registro a eliminar","Error de Selección");
                    }

                    break;
                case ModificaRestaurante.COMANDO_BTN_BUSCAR:
                    String nombre=p3.getNombre();
                    if(nombre!=null){
                        r=dao.buscaRestauranteNombreParecido(nombre);
                        if(r!=null){
                            p3.cargarValores(r);
                            p3.mostrarDatos(true);
                            p3.bloqueaBusqueda(true);
                        }
                        else{
                            v.mensajeInfo("No se ha encontrado ningún restaurante para el dato introducido","Información de Consulta");
                            p3.mostrarDatos(false);
                        }
                    }
                    
                    break;
                case ModificaRestaurante.COMANDO_BTN_MODIFICAR:
                    r=p3.leerValores();
                    if(r!=null){
                        dao.modificaRestaurante(r);
                        v.mensajeInfo("Se ha modificado el restaurante con éxito","Resultado de operación");
                        p3.mostrarDatos(false);
                        p3.bloqueaBusqueda(false);
                        System.out.println(r);
                    }
                    break;
                case ModificaRestaurante.COMANDO_BTN_CANCELAR:
                    p3.mostrarDatos(false);
                    p3.bloqueaBusqueda(false);
                    p3.limpiarValores();
                    break;
                case RegistraRestaurante.COMANDO_BTN_GUARDAR:
                    r=p2.leerValores();
                    if(r!=null){
                        p2.limpiarValores();
                        if(dao.buscaRestauranteNombre(r.getNombre())!=null){
                            v.mensajeError("Ya existe un restaurante con el nombre introducido","Resultado de operación");
                        }
                        else{
                            System.out.println(r);
                            dao.insertarRestaurante(r);
                            v.mensajeInfo("Se ha registrado el restaurante con éxito","Resultado de operación");
                        }
                    }
                    break;
                case RegistraRestaurante.COMANDO_BTN_LIMPIAR:
                    p2.limpiarValores();
                    break;
                default:
                    System.out.println("Comando no reconocido");
                    break;
            }
        }
        else{
            System.out.println("Fuente no reconocida");
        }
    }

}
