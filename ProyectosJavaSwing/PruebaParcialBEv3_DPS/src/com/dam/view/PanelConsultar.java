package com.dam.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.dam.control.Controlador;

public class PanelConsultar extends JPanel implements IPanel{
    public static final int ANCHO = 600;
    public static final int ALTO = 400;

    public static final String AC_BTN_VER="Visualizar Ranking";
    public static final String AC_BTN_ANALISIS="Realizar Análisis";
    private JTextArea taAlbumes;
    private JButton btnVer;
    private JScrollPane scrpAlbumes;
    private JButton btnAnalisis;

    public PanelConsultar(){
        setSize(ANCHO,ALTO);
        crearComponentes();
    }

    @Override
    public void crearComponentes() {
        setLayout(null);

		JLabel lblTitulo = new JLabel("Consultar Ranking");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(44, 33, 225, 22);
		add(lblTitulo);
		
		btnVer = new JButton(AC_BTN_VER);
		btnVer.setBounds(56, 79, 150, 22);
		add(btnVer);
		
		scrpAlbumes = new JScrollPane();
		scrpAlbumes.setVisible(false); 
		scrpAlbumes.setBounds(56, 132, 620, 320);
		add(scrpAlbumes);
		
		taAlbumes = new JTextArea();
        taAlbumes.setEditable(false);
		scrpAlbumes.setViewportView(taAlbumes);
		
		btnAnalisis = new JButton(AC_BTN_ANALISIS);
		btnAnalisis.setVisible(false);
        btnAnalisis.setBounds(56, 480, 150, 22);
		add(btnAnalisis);
    }

    public void mostrarBotonAnalisis(boolean visible){
        btnAnalisis.setVisible(visible);
        scrpAlbumes.setVisible(visible); 
    }

    public void escribirTextArea(String t){
        taAlbumes.setText(t);
    }

    public void mostrarAnalisis(String analisis){
        JOptionPane.showMessageDialog(this, analisis, "Análisis", 1);
    }

    public void mensajeSalir(){
        int opcion=JOptionPane.showConfirmDialog(this, "Va a salir de la aplicación ¿Desea continuar?", "Confirmación", 0,2);
        if(opcion==0){
            System.exit(0);
        }
    }

    @Override
    public void setControlador(Controlador c) {
        btnVer.addActionListener(c);
        btnAnalisis.addActionListener(c);
    }


}
