package com.dam.pruebas;

import java.awt.Color;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.dam.lib.libGraficos1;

public class PruebasLib {

	public static void main(String[] args) throws InterruptedException {
		JFrame marco = libGraficos1.confFrame(new JFrame(), "Ventana Hola Mundo", 1000, 1000, null);
        JLabel lblSaludo=(JLabel) libGraficos1.confComp(new JLabel(), marco,"Hola!", 150, 150, 200, 50);
        JLabel lblSaludo2=(JLabel) libGraficos1.confComp(new JLabel(), marco,"Hola!", 200, 200, 200, 50);
        JButton lblSaludo3=(JButton) libGraficos1.confComp(new JButton(), marco,"Hola!", 250, 250, 200, 50);

        marco.setVisible(true);
	}

}
