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
                    v.cargarPanel(p3);
                    break;
                case VentanaPrincipal.COMANDO_MENU_SALIR:
                    System.exit(0);
                default:
                    System.out.println("Comando no reconocido");
                    break;
            }
        }
        else if(e.getSource() instanceof JButton){
            switch (comando) {
                case ConsultaRestaurantes.COMANDO_BTN_CONSULTAR:
                    String d="TODAS";
                    if(p1.getDistincion().equals("1 estrella")){
                        d="1";
                    }
                    else if(p1.getDistincion().equals("2 estrellas")){
                        d="2";
                    }
                    else if(p1.getDistincion().equals("3 estrellas")){
                        d="3";
                    }
                    ArrayList<Restaurante> r = dao.consultarRestaurantesFiltro(d, p1.getRegion());
                    if(r.isEmpty()){
                        p1.mostrarComponentesResultado(false);
                        v.mensajeInfo("No se han encontrado datos para el filtro introducido","Resultado de Consulta");
                    }
                    else{
                        p1.mostrarComponentesResultado(true);
                        p1.actualizaTablaRestaurantes(r);
                    }
                    break;
                case ConsultaRestaurantes.COMANDO_BTN_ELIMINAR:
                    p1.getRestauranteSeleccionado();
                    if(p1.getRestauranteSeleccionado()>=0){
                        v.mensajeInfo("Restaurante eliminado correctamente","Eliminación");
                    }
                    else{
                        v.mensajeAlerta("Debe seleccionar un restaurante para eliminarlo","Alerta de Eliminación");
                    }
                    break;
                case ModificaRestaurante.COMANDO_BTN_BUSCAR:
                    System.out.println("Buscar");
                    break;
                case ModificaRestaurante.COMANDO_BTN_MODIFICAR:
                    System.out.println("Modificar");
                    break;
                case ModificaRestaurante.COMANDO_BTN_CANCELAR:
                    System.out.println("Cancelar");
                    break;
                case RegistraRestaurante.COMANDO_BTN_GUARDAR:
                    System.out.println("Guardar");
                    break;
                case RegistraRestaurante.COMANDO_BTN_LIMPIAR:
                    System.out.println("Limpiar");
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
