package com.dam.lib;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;


import java.awt.Color;
import java.awt.Font;

/*
todo: borders
factories for every object
*/

public class Graf1 {
    private static Color defaultTextColor = new Color(220, 220, 220);
    private static Color defaultBgColor = new Color(40, 40, 40);
    private static Font defaultFont = new Font("Verdana", Font.PLAIN, 20);
    private static Color defaultButtonBgColor = new Color(70, 70, 70);
    

    public static void setDefaults(Color textColor, Color bgColor, Font font, Color buttonBgColor) {
        if(textColor != null) defaultTextColor = textColor;
        if(bgColor != null) defaultBgColor = bgColor;
        if(font != null) defaultFont = font;
        if(buttonBgColor != null) defaultButtonBgColor = buttonBgColor;
    }

    public static void show(JFrame marco) {
        marco.revalidate();
        marco.repaint();
        marco.setVisible(true);
    }

    public static JComponent newC(JComponent c, JFrame marco, String texto, int x, int y, int width, int height, Font font, Color bgColor, Color fgColor, boolean transparent) {
        if(c instanceof JLabel) {
            ((JLabel) c).setText(texto);
            c.setBackground(bgColor != null ? bgColor : defaultBgColor);
            //((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
        } else if(c instanceof JButton) {
            c.setBackground(bgColor != null ? bgColor : defaultButtonBgColor);
            ((JButton) c).setText(texto);
            ((JButton) c).setBorderPainted(false);
            ((JButton) c).setFocusPainted(false);
            ((JButton) c).setContentAreaFilled(false);
            ((JButton) c).addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    c.setBackground(bgColor != null ? bgColor.darker() : defaultButtonBgColor.darker());
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    c.setBackground(bgColor != null ? bgColor : defaultButtonBgColor);
                }
            });
        }
        else{
            c.setBackground(bgColor != null ? bgColor : defaultBgColor);
        }

        c.setBounds(x, y, width, height);
        c.setOpaque(!transparent);
        
        c.setForeground(fgColor != null ? fgColor : defaultTextColor);
        c.setFont(font != null ? font : defaultFont);
        marco.getContentPane().add(c);
        return c;
    }
    public static JComponent newC(JComponent c, JFrame marco, String texto, int x, int y, int width, int height) {
        return newC(c, marco, texto, x, y, width, height, null, null, null, false);
    }

    public static JComponent newC(JComponent c, JFrame marco, String texto) {
        return newC(c, marco, texto,0,0);
    }

    public static void moveBelow(JComponent c, JComponent reference, int gap) {
        int x = reference.getX();
        int y = reference.getY() + reference.getHeight() + gap;
        c.setLocation(x, y);
    }

    public static JComponent newC(JComponent c, JFrame marco, String texto, int x, int y) {
        newC(c, marco, texto, x, y, 0, 0, null, null, null, false);
        marco.revalidate();
        c.setSize(c.getPreferredSize());
        return c;
    }

    public static JFrame newF(JFrame marco, String titulo, int width, int height, Color bgColor) {
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

    public static JFrame newF(JFrame marco, String titulo, int width, int height) {
        return newF(marco, titulo, width, height, null);
    }

}
