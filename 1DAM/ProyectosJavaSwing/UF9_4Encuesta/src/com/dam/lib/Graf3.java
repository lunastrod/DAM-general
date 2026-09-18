package com.dam.lib;

import javax.swing.*;
import java.awt.*;

public class Graf3 {
    private static final int CELDA_ALTO = 40;
    private static final int CELDA_ANCHO = 100;
    private static final int ALTURA_LISTA = CELDA_ALTO * 5;
    private static final int ANCHO_CAMPO = CELDA_ANCHO * 2;
    private static final int ANCHO_BOTON = CELDA_ANCHO;
    private static final int MARGEN_IZQUIERDA = 30;
    private static final int MARGEN_DERECHA = 20;

    private Graf3() {}

    public static void posicion(JComponent c, double fila, double columna) {
        c.setBounds(MARGEN_IZQUIERDA+(int)(columna * CELDA_ANCHO), MARGEN_DERECHA+(int)(fila * CELDA_ALTO), c.getPreferredSize().width, c.getPreferredSize().height);
    }

    public static void dimensiones(JComponent c, double celdas_ancho, double celdas_alto) {
        c.setPreferredSize(new Dimension((int)celdas_ancho * CELDA_ANCHO, (int)celdas_alto * CELDA_ALTO));
        c.setSize(c.getPreferredSize());
    }

    public static JButton estilo(JButton btn, JFrame ventana) {
        btn.setPreferredSize(new Dimension(ANCHO_BOTON, CELDA_ALTO));
        ventana.getContentPane().add(btn);
        return btn;
    }

    public static JLabel estilo(JLabel lbl, JFrame ventana) {
        lbl.setPreferredSize(new Dimension(ANCHO_CAMPO, CELDA_ALTO));
        ventana.getContentPane().add(lbl);
        return lbl;
    }

    public static JTextField estilo(JTextField txf, JFrame ventana) {
        txf.setPreferredSize(new Dimension(ANCHO_CAMPO, CELDA_ALTO));
        ventana.getContentPane().add(txf);
        return txf;
    }

    public static JPasswordField estilo(JPasswordField pass, JFrame ventana) {
        pass.setPreferredSize(new Dimension(ANCHO_CAMPO, CELDA_ALTO));
        ventana.getContentPane().add(pass);
        return pass;
    }

    public static JCheckBox estilo(JCheckBox check, JFrame ventana) {
        ventana.getContentPane().add(check);
        return check;
    }

    public static JRadioButton estilo(JRadioButton radio, JFrame ventana) {
        ventana.getContentPane().add(radio);
        return radio;
    }

    public static ButtonGroup estiloGrupoRadioButton(JRadioButton[] botones, double filaInicial, double columna, JFrame ventana) {
        ButtonGroup grupo = new ButtonGroup();
        for (int i = 0; i < botones.length; i++) {
            estilo(botones[i], ventana);
            posicion(botones[i], filaInicial + i, columna);
            grupo.add(botones[i]);
        }
        return grupo;
    }

    public static <E> JList<E> estilo(JList<E> list, JScrollPane scroll, JFrame ventana) {
        scroll.setViewportView(list);
        scroll.setPreferredSize(new Dimension(ANCHO_CAMPO, ALTURA_LISTA));
        ventana.getContentPane().add(scroll);
        return list;
    }

    public static JTextArea estilo(JTextArea area, JScrollPane scroll, JFrame ventana) {
        scroll.setViewportView(area);
        scroll.setPreferredSize(new Dimension(ANCHO_CAMPO * 2, ALTURA_LISTA));
        ventana.getContentPane().add(scroll);
        return area;
    }

    public static <E> JComboBox<E> estilo(JComboBox<E> combo, JFrame ventana) {
        combo.setPreferredSize(new Dimension(ANCHO_CAMPO, CELDA_ALTO));
        ventana.getContentPane().add(combo);
        return combo;
    }

    public static JSpinner estilo(JSpinner spinner, JFrame ventana) {
        spinner.setPreferredSize(new Dimension(ANCHO_BOTON, CELDA_ALTO));
        ventana.getContentPane().add(spinner);
        return spinner;
    }

    public static void estilo(JFrame ventana) {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}