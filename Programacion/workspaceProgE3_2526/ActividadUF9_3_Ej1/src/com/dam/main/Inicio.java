package com.dam.main;

import java.awt.EventQueue;

import com.dam.view.VentanaEj1;

public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VentanaEj1 v = new VentanaEj1();
				v.hacerVisible();
				
			}
		});

	}

}
