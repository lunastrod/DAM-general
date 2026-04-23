package com.dam.view;


import java.awt.Font;

import javax.swing.*;

import com.dam.control.Controlador;
import com.dam.model.Entidad;

public class RegistraRestaurante extends JPanel implements IPanel{
    public static final int ANCHO = 600;
    public static final int ALTO = 400;
    public static final String COMANDO_BTN1="boton1";
    private JLabel lblNewLabel;
    private JLabel lblDireccin;
    private JLabel lblTelfono;
    private JLabel lblDistincin;
    private JLabel lblRegion;
    private JLabel lblWeb;
    private JLabel lblPrecioMnimo;
    private JLabel lblPrecioMximo;
    private JLabel lblCiudad;
    private JLabel lblCocina;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    

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
        lblTitulo.setBounds(25, 25, 269, 36);
        add(lblTitulo);
        
        lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setBounds(22, 88, 82, 14);
        add(lblNewLabel);
        
        lblDireccin = new JLabel("Dirección:");
        lblDireccin.setBounds(32, 162, 82, 14);
        add(lblDireccin);
        
        lblTelfono = new JLabel("Teléfono");
        lblTelfono.setBounds(51, 279, 82, 14);
        add(lblTelfono);
        
        lblDistincin = new JLabel("Distinción");
        lblDistincin.setBounds(25, 204, 82, 14);
        add(lblDistincin);
        
        lblRegion = new JLabel("Region:");
        lblRegion.setBounds(22, 121, 82, 14);
        add(lblRegion);
        
        lblWeb = new JLabel("Web");
        lblWeb.setBounds(201, 279, 82, 14);
        add(lblWeb);
        
        lblPrecioMnimo = new JLabel("Precio mínimo");
        lblPrecioMnimo.setBounds(238, 204, 82, 14);
        add(lblPrecioMnimo);
        
        lblPrecioMximo = new JLabel("máximo");
        lblPrecioMximo.setBounds(405, 204, 82, 14);
        add(lblPrecioMximo);
        
        lblCiudad = new JLabel("Ciudad");
        lblCiudad.setBounds(238, 121, 82, 14);
        add(lblCiudad);
        
        lblCocina = new JLabel("Cocina");
        lblCocina.setBounds(238, 88, 82, 14);
        add(lblCocina);
        
        textField = new JTextField();
        textField.setBounds(105, 85, 86, 20);
        add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(105, 159, 359, 20);
        add(textField_1);
        textField_1.setColumns(10);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(105, 200, 86, 22);
        add(comboBox);
        
        textField_2 = new JTextField();
        textField_2.setBounds(105, 276, 86, 20);
        add(textField_2);
        textField_2.setColumns(10);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(365, 84, 67, 22);
        add(comboBox_1);
        
        textField_3 = new JTextField();
        textField_3.setBounds(358, 118, 86, 20);
        add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(234, 276, 86, 20);
        add(textField_4);
        textField_4.setColumns(10);
        
        JButton btnNewButton = new JButton("Guardar Datos");
        btnNewButton.setBounds(103, 327, 108, 23);
        add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Limpiar Datos");
        btnNewButton_1.setBounds(234, 327, 115, 23);
        add(btnNewButton_1);
        
        textField_5 = new JTextField();
        textField_5.setBounds(311, 201, 86, 20);
        add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(456, 201, 86, 20);
        add(textField_6);
        textField_6.setColumns(10);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setBounds(105, 117, 86, 22);
        add(comboBox_2);
        
        ButtonGroup btngEdad = new ButtonGroup();
        

        String[] opciones = {"A", "B", "C"};
        DefaultComboBoxModel<String> cmbModel = new DefaultComboBoxModel<String>(opciones);

    }

    public void limpiarValores(){
    }


    public Entidad leerValores(){
        String texto1=textField.getText();



        String texto2=(String)cmbFrecuencia.getSelectedItem();



        String texto3="";
        if(rdbtn1.isSelected()){
            texto3=rdbtn1.getText();
        }
        else if(rdbtn2.isSelected()){
            texto3=rdbtn1.getText();
        }


        String texto4="";
        if(chkbox.isSelected()){
            if(!texto4.isEmpty()){
                texto4+=", ";
            }
            texto4+=chkbox.getText();
        }
        if(chkbox2.isSelected()){
            if(!texto4.isEmpty()){
                texto4+=", ";
            }
            texto4+=chkbox2.getText();
        }


        int numero=(int)spinner.getValue();

        System.out.println(texto1);
        System.out.println(texto2);
        System.out.println(texto3);
        System.out.println(texto4);
        System.out.println(numero);

        return new Entidad(texto1,texto2,texto3,texto4,numero);
    }

    @Override
    public void setControlador(Controlador c) {
        boton.addActionListener(c);
    }
}
