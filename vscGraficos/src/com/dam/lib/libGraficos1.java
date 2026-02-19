package com.dam.lib;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;


import java.awt.Color;
import java.awt.Font;


public class libGraficos1 {
    private static Color defaultTextColor = new Color(220, 220, 220);
    private static Color defaultHoverColor = new Color(60, 60, 60);
    private static Color defaultBgColor = new Color(40, 40, 40);
    private static Font defaultFont = new Font("Verdana", Font.PLAIN, 20);

    public static JComponent confComp(JComponent c, JFrame marco, String texto, int x, int y, int width, int height, Font font, Color bgColor, Color fgColor) {
        if(c instanceof JLabel) {
            ((JLabel) c).setText(texto);
        } else if(c instanceof JButton) {
            ((JButton) c).setText(texto);
            ((JButton) c).setBorderPainted(false);
        }

        c.setBounds(x, y, width, height);
        if(bgColor != null) {
            c.setOpaque(true);
            c.setBackground(bgColor);
        } else {
            c.setBackground(defaultBgColor);
        }
        if(fgColor != null) {
            c.setForeground(fgColor);
        } else {
            c.setForeground(defaultTextColor);
        }
        if(font != null) {
            c.setFont(font);
        }else {
            c.setFont(defaultFont);
        }
        marco.getContentPane().add(c);
        return c;
    }
    public static JComponent confComp(JComponent c, JFrame marco, String texto, int x, int y, int width, int height) {
        return confComp(c, marco, texto, x, y, width, height, null, null, null);
    }

    public static JFrame confFrame(JFrame marco, String titulo, int width, int height, Color bgColor) {
        marco.setTitle(titulo);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLocationRelativeTo(null);
        marco.setSize(width, height);
        marco.getContentPane().setLayout(null);

        if(bgColor != null) {
            marco.getContentPane().setBackground(bgColor);
        } else {
            marco.getContentPane().setBackground(defaultBgColor);
        }
        return marco;
    }

}
