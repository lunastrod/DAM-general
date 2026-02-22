package com.dam.pruebas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class HolaMundoGraf {

	public static void main(String[] args) throws InterruptedException {
		JFrame marco = new JFrame("Ventana Hola Mundo");
		marco.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//marco.setLocationRelativeTo(null);//donde esta la pantalla
		marco.setVisible(true);
		marco.setSize(1000, 1000);
		
		JLabel lblSaludo=new JLabel("Hola Zoe!");
		marco.getContentPane().add(lblSaludo);
		while(true) {
			for(int i=-500; i<500; i++) {
				lblSaludo.setBorder(new EmptyBorder(i,150,0,0));
				Thread.sleep(2);
			}
		}


		
		//marco.pack();//tamaño en funcion de lo que contenga
		
		
		

	}

}
