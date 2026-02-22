package com.dam.pruebas;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.dam.lib.Graf1;

public class PruebasLib {

	public static void main(String[] args) throws InterruptedException {
		JFrame marco = Graf1.newF(new JFrame(), "Ventana Hola Mundo", 1000, 1000);
        JLabel lblSaludo=(JLabel) Graf1.newC(new JLabel(), marco,"Hola!");
        JLabel lblSaludo2=(JLabel) Graf1.newC(new JLabel(), marco,"Hola!");
        JButton lblSaludo3=(JButton) Graf1.newC(new JButton(), marco,"H");
        JButton autosize=(JButton) Graf1.newC(new JButton(), marco,"aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Graf1.moveBelow(lblSaludo3, autosize, 0);
        Graf1.moveBelow(lblSaludo, lblSaludo3, 0);
        Graf1.moveBelow(lblSaludo2, lblSaludo, 0);

        Graf1.show(marco);
	}

}
