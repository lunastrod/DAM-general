package com.dam.feb17;

import java.awt.EventQueue;

public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Vista v=new Vista();
			}
		});

	}

}