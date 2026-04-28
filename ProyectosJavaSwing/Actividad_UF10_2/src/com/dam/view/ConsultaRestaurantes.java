package com.dam.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.dam.control.Controlador;
import com.dam.model.Restaurante;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class ConsultaRestaurantes extends JPanel implements IPanel{
    public static final int ANCHO = 800;
    public static final int ALTO = 500;
    public static final String COMANDO_BTN_CONSULTAR="Consultar";
    public static final String COMANDO_BTN_ELIMINAR="Eliminar";

    private JTable tableRestaurantes;
    private DefaultTableModel tableModel;
    private JButton btnConsultar;
    private JButton btnEliminar;
    private JComboBox<String> comboBoxRegion;
    private DefaultComboBoxModel<String> modelComboRegion;
    private JComboBox<String> comboBoxDistincion;
    private JScrollPane scrollPane;
    private JLabel lblListado;


    public ConsultaRestaurantes(){
        setSize(ANCHO,ALTO);
        setLayout(null);
        
        crearComponentes();
    }

    public void actualizaTablaRestaurantes(ArrayList<Restaurante> r) {
        tableModel = new DefaultTableModel(Restaurante.COLUMNAS, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Restaurante restaurante : r) {
            tableModel.addRow(restaurante.getFila());
        }
        tableRestaurantes.setModel(tableModel);
    }

    public void actualizaComboRegion(ArrayList<String> regiones) {
        modelComboRegion.removeAllElements();
        modelComboRegion.addElement("TODAS");
        for (String region : regiones) {
            modelComboRegion.addElement(region);
        }
    }

    public void mostrarComponentesResultado(boolean mostrar) {
        tableRestaurantes.setVisible(mostrar);
        btnEliminar.setVisible(mostrar);
        scrollPane.setVisible(mostrar);
        lblListado.setVisible(mostrar);

    }

    public String getRegion() {
        return (String) comboBoxRegion.getSelectedItem();
    }

    public String getDistincion() {
        return (String) comboBoxDistincion.getSelectedItem();
    }

    public String getRestauranteSeleccionado() {//retorna nombre
        int fila = tableRestaurantes.getSelectedRow();
        String nombre=null;
        if(fila>=0){
            nombre = tableModel.getValueAt(fila, 0).toString();
        }
        return nombre;
    }

    @Override
    public void crearComponentes() {
        JLabel lblTitulo = new JLabel("Consulta de Restaurantes");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(51, 11, 269, 22);
        add(lblTitulo);
        
        JLabel lblRegion = new JLabel("Región:");
        lblRegion.setBounds(68, 69, 46, 14);
        add(lblRegion);
        
        JLabel lblDistincion = new JLabel("Distinción:");
        lblDistincion.setBounds(433, 69, 224, 14);
        add(lblDistincion);
        
        comboBoxRegion = new JComboBox<String>();
        comboBoxRegion.setBounds(124, 65, 147, 22);
        modelComboRegion = new DefaultComboBoxModel<String>();
        comboBoxRegion.setModel(modelComboRegion);
        add(comboBoxRegion);
        
        comboBoxDistincion = new JComboBox<String>();
        comboBoxDistincion.setModel(new DefaultComboBoxModel<String>(new String[] {"TODAS", "3 estrellas", "2 estrellas", "1 estrella"}));
        comboBoxDistincion.setBounds(560, 66, 145, 22);
        add(comboBoxDistincion);
        
        btnConsultar = new JButton(COMANDO_BTN_CONSULTAR);
        btnConsultar.setActionCommand(COMANDO_BTN_CONSULTAR);
        btnConsultar.setBounds(604, 99, 101, 23);
        add(btnConsultar);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(68, 182, 660, 204);
        add(scrollPane);
        
        tableRestaurantes = new JTable();
        scrollPane.setViewportView(tableRestaurantes);        
        
        JLabel lblFiltro = new JLabel("Filtro:");
        lblFiltro.setBounds(61, 44, 46, 14);
        add(lblFiltro);
        
        btnEliminar = new JButton(COMANDO_BTN_ELIMINAR);
        btnEliminar.setActionCommand(COMANDO_BTN_ELIMINAR);
        btnEliminar.setBounds(509, 397, 89, 23);
        add(btnEliminar);
        
        lblListado = new JLabel("Listado de Restaurantes");
        lblListado.setBounds(61, 141, 147, 14);
        add(lblListado);
    }


    @Override
    public void setControlador(Controlador c) {
        btnConsultar.addActionListener(c);
        btnEliminar.addActionListener(c);
    }
}
