package com.dam.view;


import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

import com.dam.control.Controlador;
import com.dam.model.Restaurante;

public class RegistraRestaurante extends JPanel implements IPanel{
    public static final int ANCHO = 600;
    public static final int ALTO = 400;
    public static final String COMANDO_BTN_GUARDAR="Guardar Datos";
    public static final String COMANDO_BTN_LIMPIAR="Limpiar Datos";
    private JLabel lblNombre;
    private JLabel lblDireccin;
    private JLabel lblTelfono;
    private JLabel lblDistincin;
    private JLabel lblRegion;
    private JLabel lblWeb;
    private JLabel lblPrecioMnimo;
    private JLabel lblPrecioMximo;
    private JLabel lblCiudad;
    private JLabel lblCocina;
    private JTextField tfNombre;
    private JTextField tfDireccion;
    private JTextField tfTelefono;
    private JTextField tfCiudad;
    private JTextField tfWeb;
    private JTextField tfPrecioMinimo;
    private JTextField tfPrecioMaximo;
    private JButton btnLimpiar;
    private JButton btnGuardar;
    private JSpinner spinnerDistincion;

    JComboBox<String> comboRegion;
    JComboBox<String> comboCocina;
    DefaultComboBoxModel<String> modelComboRegion;
    DefaultComboBoxModel<String> modelComboCocina;
    

    public RegistraRestaurante(){
        setSize(ANCHO,ALTO);
        setLayout(null);
        crearComponentes();
        limpiarValores();
    }

    @Override
    public void crearComponentes() {
        JLabel lblTitulo = new JLabel("Registrar Restaurante");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(22, 11, 269, 36);
        add(lblTitulo);
        
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(32, 91, 82, 14);
        add(lblNombre);
        
        lblDireccin = new JLabel("Dirección:");
        lblDireccin.setBounds(32, 177, 82, 14);
        add(lblDireccin);
        
        lblTelfono = new JLabel("Teléfono");
        lblTelfono.setBounds(32, 262, 82, 14);
        add(lblTelfono);
        
        lblDistincin = new JLabel("Distinción");
        lblDistincin.setBounds(32, 218, 82, 14);
        add(lblDistincin);
        
        lblRegion = new JLabel("Region:");
        lblRegion.setBounds(32, 136, 82, 14);
        add(lblRegion);
        
        lblWeb = new JLabel("Web");
        lblWeb.setBounds(234, 262, 82, 14);
        add(lblWeb);
        
        lblPrecioMnimo = new JLabel("Precio mínimo:");
        lblPrecioMnimo.setBounds(160, 218, 108, 14);
        add(lblPrecioMnimo);
        
        lblPrecioMximo = new JLabel("máximo:");
        lblPrecioMximo.setBounds(359, 218, 108, 14);
        add(lblPrecioMximo);
        
        lblCiudad = new JLabel("Ciudad");
        lblCiudad.setBounds(234, 136, 82, 14);
        add(lblCiudad);
        
        lblCocina = new JLabel("Cocina");
        lblCocina.setBounds(230, 91, 82, 14);
        add(lblCocina);
        
        tfNombre = new JTextField();
        tfNombre.setBounds(101, 88, 119, 20);
        add(tfNombre);
        tfNombre.setColumns(10);
        
        tfDireccion = new JTextField();
        tfDireccion.setBounds(101, 174, 420, 20);
        add(tfDireccion);
        tfDireccion.setColumns(10);
        
        tfTelefono = new JTextField();
        tfTelefono.setBounds(101, 259, 119, 20);
        add(tfTelefono);
        tfTelefono.setColumns(10);
        
        comboCocina = new JComboBox<String>();
        comboCocina.setBounds(307, 87, 119, 22);
        modelComboCocina = new DefaultComboBoxModel<String>();
        comboCocina.setModel(modelComboCocina);
        add(comboCocina);
        
        tfCiudad = new JTextField();
        tfCiudad.setBounds(311, 133, 214, 20);
        add(tfCiudad);
        tfCiudad.setColumns(10);
        
        tfWeb = new JTextField();
        tfWeb.setBounds(263, 259, 262, 20);
        add(tfWeb);
        tfWeb.setColumns(10);
        
        btnGuardar = new JButton("Guardar Datos");
        btnGuardar.setBounds(160, 327, 136, 23);
        add(btnGuardar);
        
        btnLimpiar = new JButton("Limpiar Datos");
        btnLimpiar.setBounds(311, 327, 136, 23);
        add(btnLimpiar);
        
        tfPrecioMinimo = new JTextField();
        tfPrecioMinimo.setBounds(257, 215, 92, 20);
        add(tfPrecioMinimo);
        tfPrecioMinimo.setColumns(10);
        
        tfPrecioMaximo = new JTextField();
        tfPrecioMaximo.setBounds(433, 215, 92, 20);
        add(tfPrecioMaximo);
        tfPrecioMaximo.setColumns(10);
        
        comboRegion = new JComboBox<String>();
        comboRegion.setBounds(101, 132, 119, 22);
        modelComboRegion = new DefaultComboBoxModel<String>();
        comboRegion.setModel(modelComboRegion);
        add(comboRegion);
        
        spinnerDistincion = new JSpinner();
        spinnerDistincion.setBounds(101, 215, 45, 20);
        add(spinnerDistincion);
    }

    public void limpiarValores(){

    }

    public void actualizaComboRegion(ArrayList<String> regiones){
        comboRegion.removeAllItems();
        comboRegion.addItem("TODAS");
        for (String region : regiones) {
            comboRegion.addItem(region);
        }
    }


    public Restaurante leerValores(){
        return null;
    }

    @Override
    public void setControlador(Controlador c) {
        btnGuardar.addActionListener(c);
        btnLimpiar.addActionListener(c);
        
    }
}
