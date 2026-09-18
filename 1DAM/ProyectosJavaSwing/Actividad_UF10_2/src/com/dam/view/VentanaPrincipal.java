package com.dam.view;

import javax.swing.*;

import com.dam.control.Controlador;

import java.awt.*;
import java.util.ArrayList;


public class VentanaPrincipal extends JFrame implements IVentana{
    public static final int ANCHO = 800;
    public static final int ALTO = 500;

    public static final String COMANDO_MENU_CONSULTA="Consulta de Restaurantes";
    public static final String COMANDO_MENU_REGISTRO="Registro de Restaurante";
    public static final String COMANDO_MENU_MODIFICACION="Modificación de Restaurante";
    public static final String COMANDO_MENU_SALIR="Salir";
    
    public static int insetsR;
    public static int insetsL;
    public static int insetsT;
    public static int insetsB;
    public static int menuH;

    private JScrollPane panelPrincipal;

    private JMenuItem mntmSalir;
    private JMenuItem mntmConsulta;
    private JMenuItem mntmRegistro;
    private JMenuItem mntmModificacion;

    public VentanaPrincipal() {
        configurarVentana();
        crearComponentes();
    }

    public void configurarVentana(){
        setTitle("Guia Michelin");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(ANCHO,ALTO);

        insetsR=this.getInsets().right;
        insetsL=this.getInsets().left;
        insetsT=this.getInsets().top;
        insetsB=this.getInsets().bottom;

        centrarVentana();
        cargarMenu();
    }

    public void centrarVentana(){
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = new Dimension(ANCHO,ALTO);
        setLocation((pantalla.width-ventana.width)/2,(pantalla.height-ventana.height)/2);
    }

    public void cargarMenu(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuH = menuBar.getHeight();
        
        JMenu menu = new JMenu("Mantenimiento Restaurantes");
        menuBar.add(menu);
        
        mntmConsulta = new JMenuItem(COMANDO_MENU_CONSULTA);
        mntmConsulta.setActionCommand(COMANDO_MENU_CONSULTA);
        menu.add(mntmConsulta);
        
        mntmRegistro = new JMenuItem(COMANDO_MENU_REGISTRO);
        mntmRegistro.setActionCommand(COMANDO_MENU_REGISTRO);
        menu.add(mntmRegistro);
        
        mntmModificacion = new JMenuItem(COMANDO_MENU_MODIFICACION);
        mntmModificacion.setActionCommand(COMANDO_MENU_MODIFICACION);
        menu.add(mntmModificacion);
        
        mntmSalir = new JMenuItem(COMANDO_MENU_SALIR);
        mntmSalir.setActionCommand(COMANDO_MENU_SALIR);
        menuBar.add(mntmSalir);
    }

	public void crearComponentes(){
        getContentPane().setLayout(new BorderLayout(0,0));
        panelPrincipal = new JScrollPane();
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);

    }
	public void setControlador(Controlador c){
        mntmConsulta.addActionListener(c);
        mntmRegistro.addActionListener(c);
        mntmModificacion.addActionListener(c);
        mntmSalir.addActionListener(c);
    }

    public void cargarPanel(JPanel panel){
        panelPrincipal.setViewportView(panel);
    }
	public void hacerVisible(){
        setVisible(true);
    }

    public void mensajeError(String mensaje,String titulo){
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public void mensajeInfo(String mensaje,String titulo){
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public void mensajeAlerta(String mensaje,String titulo){
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }

    public boolean mensajeConfirmacion(String mensaje,String titulo){
        return JOptionPane.showConfirmDialog(this, mensaje, titulo, JOptionPane.YES_NO_OPTION)==0;
    }
}
