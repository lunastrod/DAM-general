package com.dam.main;

import java.awt.EventQueue;

import com.dam.view.VentanaEj4;

public class Ejercicio4_Capicua {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// crear los objetos que representen nuestra aplicación
				VentanaEj4 vEj4 = new VentanaEj4();
				vEj4.hacerVisible();
			}
		});

	}

}
