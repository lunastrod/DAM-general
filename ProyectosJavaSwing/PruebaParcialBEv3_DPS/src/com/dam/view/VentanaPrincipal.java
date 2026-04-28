package com.dam.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.dam.control.Controlador;



public class VentanaPrincipal extends JFrame implements IVentana{
    public static final int ANCHO = 800;
    public static final int ALTO = 600;

    public static final String MENU_CONSULTAR="Consultar Ranking";
    public static final String MENU_SALIR="Salir";
    
    public static int insetsR;
    public static int insetsL;
    public static int insetsT;
    public static int insetsB;
    public static int menuH;

    private JScrollPane panelPrincipal;

    private JMenuItem mntmItem1;
    private JMenuItem mntmItem2;

    public VentanaPrincipal() {
        configurarVentana();
        crearComponentes();
    }

    public void configurarVentana(){
        setTitle("# Ranking Álbumes más vendidos"); //TODO titulo ventana
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
        
        mntmItem1 = new JMenuItem(MENU_CONSULTAR);
        mntmItem1.setActionCommand(MENU_CONSULTAR);
        menuBar.add(mntmItem1);
        menuH = menuBar.getHeight();

        mntmItem2 = new JMenuItem(MENU_SALIR);
        mntmItem2.setActionCommand(MENU_SALIR);
        menuBar.add(mntmItem2);
        menuH = menuBar.getHeight();
    }

	public void crearComponentes(){
        getContentPane().setLayout(new BorderLayout(0,0));
        panelPrincipal = new JScrollPane();
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);
    }

	public void setControlador(Controlador c){
        mntmItem1.addActionListener(c);
        mntmItem2.addActionListener(c);
    }

    public void cargarPanel(JPanel panel){
        panelPrincipal.setViewportView(panel);
    }

	public void hacerVisible(){
        setVisible(true);
    }


}
