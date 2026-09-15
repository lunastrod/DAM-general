package com.dam.view;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.dam.control.EncuestadorControlador;
import com.dam.model.Encuesta;
import com.dam.model.ListaEncuestas;

public class PVerEncuestas extends JPanel {
    public static final String BTN_RESULTADOS="Ver Resultados";

    private static final int ANCHO=600;
    private static final int ALTO=400;
    JList<Object> lstEncuestas;
    DefaultListModel<Object> lstModel;
    JButton btnVer;
    JLabel mensaje;
    

    public PVerEncuestas(){
        setLayout(null);
        setSize(ANCHO,ALTO);
        crearComponentes();
    }

    public void mostrarResultados(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarEncuestas(ListaEncuestas encuestas) {
        lstModel.clear();
        for (Encuesta encuesta : encuestas.getEncuestas()) {
            lstModel.addElement(encuesta);
        }
    }

    public void esconderBoton() {
        btnVer.setVisible(false);
        mensaje.setVisible(true);
    }

    public void mostrarBoton() {
        btnVer.setVisible(true);
        mensaje.setVisible(false);
    }

	public void crearComponentes(){
        JLabel lblLista = new JLabel("Listado de Encuestas");
        lblLista.setBounds(25, 20, 160, 20);
        lblLista.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblLista);
        JScrollPane scrpLista = new JScrollPane();
        scrpLista.setBounds(45, 55, 480, 200);
        add(scrpLista);
        lstEncuestas = new JList<Object>();
        scrpLista.setViewportView(lstEncuestas);
        lstModel = new DefaultListModel<Object>();
        lstEncuestas.setModel(lstModel);
        btnVer = new JButton(BTN_RESULTADOS);
        btnVer.setBounds(225, 275, 150, 22);
        btnVer.setActionCommand(BTN_RESULTADOS);
        add(btnVer);
        mensaje = new JLabel("");
        mensaje.setBounds(225, 275, 150, 22);
        mensaje.setText("Sin encuestas disponibles");
        add(mensaje);
        esconderBoton();
        
    }
	
	public void setControlador(EncuestadorControlador ch){
        btnVer.addActionListener(ch);
    }
	
	public void hacerVisible(){
        this.setVisible(true);
    }

}
