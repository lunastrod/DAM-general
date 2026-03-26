package com.dam.view;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.dam.control.Controlador;

public class VVerEncuestas extends JFrame implements IVentana {
    private static final String BTN_RESULTADOS="Ver Resultados";

    private static final String TITULO="ENCUESTAS";
    private static final int ANCHO=600;
    private static final int ALTO=400;
    JList<Object> lstEncuestas;
    DefaultListModel<Object> lstModel;
    JButton btnVer;
    



    public VVerEncuestas(){
        configurarVentana();
        crearComponentes();
    }

    public void configurarVentana(){
		setTitle(TITULO);
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
    }
	
	public void crearComponentes(){
        JLabel lblLista = new JLabel("Listado de Encuestas");
        lblLista.setBounds(25, 20, 160, 20);
        lblLista.setFont(new Font("Tahoma", Font.
        BOLD, 14));
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
        add(btnVer);
        
    }
	
	public void setControlador(Controlador ch){
        //TODO: configurar controlador (addActionListener)
    }
	
	public void hacerVisible(){
        this.setVisible(true);
    }

}
