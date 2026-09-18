package com.dam.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.dam.control.EncuestadorControlador;

public class VPrincipal extends JFrame implements IVentana{

    private static final String TITULO="E N C U E S T A S";
    private static final int ANCHO=600;
    private static final int ALTO=400;
    public static final String REALIZAR_ENCUESTA="Realizar Encuesta";
    public static final String VISUALIZAR_ENCUESTAS="Visualizar Encuestas";


    private JMenuItem itemRealizar;
    private JMenuItem itemVisualizar;


    private PAddEncuesta pAddEncuesta;
    private PVerEncuestas pVerEncuestas;

    public VPrincipal() {
        configurarVentana();
        crearComponentes();
    }

    public PAddEncuesta getPAddEncuesta() {
        return pAddEncuesta;
    }
    public PVerEncuestas getPVerEncuestas() {
        return pVerEncuestas;
    }

    public void cargarPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }


    public void configurarVentana() {
        setTitle(TITULO);
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
    }

    public void crearComponentes() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuEncuestas = new JMenu("Encuestas A");
        menuBar.add(menuEncuestas);

        itemRealizar = new JMenuItem(REALIZAR_ENCUESTA);
        itemVisualizar = new JMenuItem(VISUALIZAR_ENCUESTAS);
        itemRealizar.setActionCommand(REALIZAR_ENCUESTA);
        itemVisualizar.setActionCommand(VISUALIZAR_ENCUESTAS);
        menuEncuestas.add(itemRealizar);
        menuEncuestas.add(itemVisualizar);

        pAddEncuesta = new PAddEncuesta();
        cargarPanel(pAddEncuesta);
        pVerEncuestas = new PVerEncuestas();
    }

    public void setControlador(EncuestadorControlador ch) {
        itemRealizar.addActionListener(ch);
        itemVisualizar.addActionListener(ch);
        pAddEncuesta.setControlador(ch);
        pVerEncuestas.setControlador(ch);
    }

    public void hacerVisible() {
        this.setVisible(true);
    }
}
