package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.dam.view.PanelAzul;
import com.dam.view.PanelRojo;
import com.dam.view.VentanaPrincipalPruebas;

public class ControladorPruebas implements ActionListener {
	
	private VentanaPrincipalPruebas vp;	
	private PanelRojo pr;
	private PanelAzul pa;

	public ControladorPruebas(VentanaPrincipalPruebas vp, 
			PanelRojo pr, PanelAzul pa) {
		this.vp = vp;
		this.pr = pr;
		this.pa = pa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			
			if (e.getSource().equals(vp.getMntmRojo())) {
				vp.cargarPanel(pr);
				
			} else if (e.getSource().equals(vp.getMntmAzul())) {
				vp.cargarPanel(pa);
				
			} else if (e.getSource().equals(vp.getMntmAmarillo())) {
				
			}
			// TODO: añadir otro JMenuItems
			
		} else if (e.getSource() instanceof JButton) {
			
			if (e.getActionCommand().equals(PanelAzul.ACTION_COMMAND_SALUDAR)) {
				JOptionPane.showMessageDialog(vp, "Bienvenido al panel azul", "Saludo", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

}
