package com.dam.lib;
import javax.swing.*;
import java.awt.*;

public class Graf2 {
    private static final Color PRIMARIO = new Color(31, 106, 165);
    private static final Color TEXTO = new Color(220, 228, 238);
    private static final Color FONDO = new Color(33, 33, 33);
    private static final Font FUENTE = new Font("SansSerif", Font.PLAIN, 15);

    private static final int CELDA_ALTO = 40;
    private static final int CELDA_ANCHO = 100;
    private static final int ALTURA_LISTA = CELDA_ALTO * 5;
    private static final int ANCHO_CAMPO = CELDA_ANCHO * 2;
    private static final int ANCHO_BOTON = CELDA_ANCHO;

    private Graf2() {}

    private static void aplicarBase(JComponent c) {
        c.setBackground(FONDO);
        c.setForeground(TEXTO);
        c.setFont(FUENTE);
        c.setOpaque(true);
    }

    // setBounds es necesario con absolute layout (setLayout(null))
    public static void posicion(JComponent c, double fila, double columna) {
        c.setBounds((int)(columna * CELDA_ANCHO), (int)(fila * CELDA_ALTO), c.getPreferredSize().width, c.getPreferredSize().height);
    }

    public static void dimensiones(JComponent c, double celdas_ancho, double celdas_alto) {
        c.setPreferredSize(new Dimension((int)celdas_ancho * CELDA_ANCHO,(int)celdas_alto * CELDA_ALTO));
        c.setSize(c.getPreferredSize());
    }

    public static JButton estilo(JButton btn, JFrame ventana) {
        aplicarBase(btn);
        btn.setBackground(PRIMARIO);
        btn.setPreferredSize(new Dimension(ANCHO_BOTON, CELDA_ALTO));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        ventana.getContentPane().add(btn);
        return btn;
    }

    public static JLabel estilo(JLabel lbl, JFrame ventana) {
        aplicarBase(lbl);
        lbl.setPreferredSize(new Dimension(ANCHO_CAMPO, CELDA_ALTO));
        ventana.getContentPane().add(lbl);
        return lbl;
    }

    public static JTextField estilo(JTextField txf, JFrame ventana) {
        aplicarBase(txf);
        txf.setPreferredSize(new Dimension(ANCHO_CAMPO, CELDA_ALTO));
        txf.setBorder(BorderFactory.createLineBorder(PRIMARIO));
        txf.setCaretColor(TEXTO);
        ventana.getContentPane().add(txf);
        return txf;
    }

    public static JPasswordField estilo(JPasswordField pass, JFrame ventana) {
        aplicarBase(pass);
        pass.setPreferredSize(new Dimension(ANCHO_CAMPO, CELDA_ALTO));
        pass.setBorder(BorderFactory.createLineBorder(PRIMARIO));
        pass.setCaretColor(TEXTO);
        ventana.getContentPane().add(pass);
        return pass;
    }

    public static JCheckBox estilo(JCheckBox check, JFrame ventana) {
        aplicarBase(check);
        ventana.getContentPane().add(check);
        return check;
    }

    public static JRadioButton estilo(JRadioButton radio, JFrame ventana) {
        aplicarBase(radio);
        ventana.getContentPane().add(radio);
        return radio;
    }

    public static ButtonGroup estiloGrupoRadioButton(JRadioButton[] botones, int filaInicial, int columna, JFrame ventana) {
        ButtonGroup grupo = new ButtonGroup();
        for (int i = 0; i < botones.length; i++) {
            estilo(botones[i], ventana);
            posicion(botones[i], filaInicial + i, columna);
            grupo.add(botones[i]);
        }
        return grupo;
    }

    // Al hacer quickfix para JList he descubierto que puedo escribir JList<E> para no indicar el tipo
    // Para hacer una lista necesito primero crear un modelo y ejecutar list.setModel(modelo).
    // Para agregar elementos al modelo necesito ejecutar modelo.addElement(elemento).
    public static <E> JList<E> estilo(JList<E> list, JScrollPane scroll, JFrame ventana) {
        aplicarBase(list);
        scroll.setViewportView(list);
        scroll.setBorder(BorderFactory.createLineBorder(PRIMARIO));
        scroll.setPreferredSize(new Dimension(ANCHO_CAMPO, ALTURA_LISTA));
        ventana.getContentPane().add(scroll);
        return list;
    }

    public static JTextArea estilo(JTextArea area, JScrollPane scroll, JFrame ventana) {
        aplicarBase(area);
        area.setCaretColor(TEXTO);
        scroll.setViewportView(area);
        scroll.setBorder(BorderFactory.createLineBorder(PRIMARIO));
        scroll.setPreferredSize(new Dimension(ANCHO_CAMPO * 2, ALTURA_LISTA));
        ventana.getContentPane().add(scroll);
        return area;
    }

    public static <E> JComboBox<E> estilo(JComboBox<E> combo, JFrame ventana) {
        aplicarBase(combo);
        combo.setBackground(PRIMARIO);
        combo.setPreferredSize(new Dimension(ANCHO_CAMPO, CELDA_ALTO));
        ventana.getContentPane().add(combo);
        return combo;
    }

    public static JSpinner estilo(JSpinner spinner, JFrame ventana) {
        aplicarBase(spinner);
        spinner.getEditor().getComponent(0).setBackground(FONDO);
        spinner.getEditor().getComponent(0).setForeground(TEXTO);
        spinner.setPreferredSize(new Dimension(ANCHO_BOTON, CELDA_ALTO));
        ventana.getContentPane().add(spinner);
        return spinner;
    }

    public static void estilo(JFrame ventana) {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setBackground(FONDO);
    }
}