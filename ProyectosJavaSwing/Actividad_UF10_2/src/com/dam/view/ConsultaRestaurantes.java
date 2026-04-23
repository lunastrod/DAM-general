package com.dam.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.dam.control.Controlador;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class ConsultaRestaurantes extends JPanel implements IPanel{
    public static final int ANCHO = 600;
    public static final int ALTO = 400;
    public static final String COMANDO_BTN_CONSULTAR="Consultar";
    public static final String COMANDO_BTN_ELIMINAR="Eliminar";

    private JTable tableRestaurantes;
    private JButton btnConsultar;
    private JButton btnEliminar;
    private JComboBox<String> comboBoxRegion;
    private JComboBox<String> comboBoxDistincion;


    public ConsultaRestaurantes(){
        setSize(ANCHO,ALTO);
        setLayout(null);
        
        crearComponentes();
    }

    @Override
    public void crearComponentes() {
        JLabel lblTitulo = new JLabel("Consulta de Restaurantes");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(51, 59, 269, 22);
        add(lblTitulo);
        
        JLabel lblRegion = new JLabel("Región:");
        lblRegion.setBounds(51, 136, 46, 14);
        add(lblRegion);
        
        JLabel lblDistincion = new JLabel("Distinción:");
        lblDistincion.setBounds(274, 136, 69, 14);
        add(lblDistincion);
        
        comboBoxRegion = new JComboBox<String>();
        comboBoxRegion.setModel(new DefaultComboBoxModel<String>(new String[] {"TODAS", "Region1", "Region2"}));
        comboBoxRegion.setBounds(139, 132, 80, 22);
        add(comboBoxRegion);
        
        comboBoxDistincion = new JComboBox<String>();
        comboBoxDistincion.setModel(new DefaultComboBoxModel<String>(new String[] {"TODAS", "3 estrellas", "2 estrellas", "1 estrella"}));
        comboBoxDistincion.setBounds(353, 132, 66, 22);
        add(comboBoxDistincion);
        
        btnConsultar = new JButton(COMANDO_BTN_CONSULTAR);
        btnConsultar.setActionCommand(COMANDO_BTN_CONSULTAR);
        btnConsultar.setBounds(429, 132, 89, 23);
        add(btnConsultar);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(68, 182, 439, 176);
        add(scrollPane);
        
        tableRestaurantes = new JTable();
        scrollPane.setViewportView(tableRestaurantes);
        tableRestaurantes.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"New column", "New column", "New column", "New column", "New column", "New column"
        	}
        ));
        
        JLabel lblFiltro = new JLabel("Filtro:");
        lblFiltro.setBounds(51, 104, 46, 14);
        add(lblFiltro);
        
        btnEliminar = new JButton(COMANDO_BTN_ELIMINAR);
        btnEliminar.setActionCommand(COMANDO_BTN_ELIMINAR);
        btnEliminar.setBounds(78, 366, 89, 23);
        add(btnEliminar);
    }


    @Override
    public void setControlador(Controlador c) {
        btnConsultar.addActionListener(c);
        btnEliminar.addActionListener(c);
    }
}
