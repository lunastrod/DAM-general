package com.dam.main;

import java.awt.EventQueue;

import com.dam.view.VentanaPrincipal;

public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Crear los objetos que van a formar parte de la aplicación con interfaz gráfica
				VentanaPrincipal vp = new VentanaPrincipal();
				vp.hacerVisible();
			}
		});

	}

}
