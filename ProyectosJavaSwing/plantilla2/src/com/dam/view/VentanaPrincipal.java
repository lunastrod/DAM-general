package com.dam.view;

import javax.swing.*;

import com.dam.control.Controlador;

import java.awt.*;


public class VentanaPrincipal extends JFrame{
    public static final int ANCHO = 600;
    public static final int ALTO = 400;

    public static final String COMANDO_MENU1="TituloItem1";
    public static final String COMANDO_MENU2="TituloItem2";
    
    public static int insetsR;
    public static int insetsL;
    public static int insetsT;
    public static int insetsB;
    public static int menuH;

    private JScrollPane panelPrincipal;

    JMenuItem item1;
    JMenuItem item2;

    public VentanaPrincipal() {
        configurarVentana();
        crearComponentes();
    }

    public void configurarVentana(){
        setTitle("Mi primera ventana"); //TODO titulo ventana
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

        JMenu menu = new JMenu("TituloMenu"); //TODO titulo menu
        menuBar.add(menu);

        item1 = new JMenuItem(COMANDO_MENU1); //TODO titulo item
        item1.setActionCommand(COMANDO_MENU1);
        menu.add(item1);

        item2 = new JMenuItem(COMANDO_MENU2); //TODO titulo item
        item2.setActionCommand(COMANDO_MENU2);
        menu.add(item2);
    }

	public void crearComponentes(){
        getContentPane().setLayout(new BorderLayout(0,0));
        panelPrincipal = new JScrollPane();
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);

    }
	public void setControlador(Controlador c){
        item1.addActionListener(c);
        item2.addActionListener(c);
    }
    public void cargarPanel(JPanel panel){
        panelPrincipal.setViewportView(panel);
    }
	public void hacerVisible(){
        setVisible(true);
    }


}
