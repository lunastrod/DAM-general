package com.dam.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.dam.control.Controlador;

public class PanelSolicitar extends JPanel implements IPanel{
    public static final int ANCHO = 600;
    public static final int ALTO = 400;

    public static final String COMANDO_BTN2="boton2";
    private JTextArea texto;
    private JButton boton;

    public PanelSolicitar(){
        setSize(ANCHO,ALTO);
        setLayout(null);
        crearComponentes();
    }

    @Override
    public void crearComponentes() {
        JLabel label=new JLabel("Solicitar");
        label.setBounds(0,0,100,100);
        add(label);

        texto=new JTextArea();
        texto.setBounds(0,20,200,200);
        add(texto);

        boton=new JButton(COMANDO_BTN2);
        boton.setActionCommand(COMANDO_BTN2);
        boton.setBounds(50,220,200,200);
        add(boton);
    }

    public void escribirTextArea(String t){
        texto.setText(t);
    }

    @Override
    public void setControlador(Controlador c) {
        boton.addActionListener(c);
    }


}
