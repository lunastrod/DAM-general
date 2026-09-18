package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.dam.view.VentanaPruebas;

public class ControladorPruebas implements ActionListener {
	
	private VentanaPruebas vp;	

	public ControladorPruebas(VentanaPruebas vp) {
		this.vp = vp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			if (e.getSource().equals(vp.getMntmOpcion11())) {
				JOptionPane.showMessageDialog(vp, "Se ha seleccionado opción 1.1", "Información del menú", JOptionPane.INFORMATION_MESSAGE);
				
			} else if (e.getSource().equals(vp.getMntmOpcion12())) {
				JOptionPane.showMessageDialog(vp, "Se ha seleccionado opción 1.2", "Información del menú", JOptionPane.INFORMATION_MESSAGE);
				
			} else if (e.getSource().equals(vp.getMntmOpcion2())) {
				JOptionPane.showMessageDialog(vp, "Se ha seleccionado opción 2", "Información del menú", JOptionPane.INFORMATION_MESSAGE);
				
			}
		}

	}

}
