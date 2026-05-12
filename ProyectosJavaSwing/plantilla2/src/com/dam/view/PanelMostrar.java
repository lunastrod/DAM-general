package com.dam.view;


import javax.swing.*;

import com.dam.control.Controlador;
import com.dam.model.Entidad;

public class PanelMostrar extends JPanel{
    public static final int ANCHO = 600;
    public static final int ALTO = 400;
    public static final String COMANDO_BTN1="boton1";

    private JRadioButton rdbtn1;
    private JRadioButton rdbtn2;
    private JTextField textField;
    private JCheckBox chkbox;
    private JCheckBox chkbox2;
    private JSpinner spinner;
    private JButton boton;
    private JComboBox<String> cmbFrecuencia;
    

    public PanelMostrar(){
        setSize(ANCHO,ALTO);
        setLayout(null);
        crearComponentes();
        limpiarValores();
    }

    @Override
    public void crearComponentes() {
        JLabel label=new JLabel("Mostrar");
        label.setBounds(100,100,100,20);
        add(label);

        textField=new JTextField();
        textField.setBounds(100,120,100,20);
        add(textField);

        boton=new JButton(COMANDO_BTN1);
        boton.setActionCommand(COMANDO_BTN1);
        boton.setBounds(100,140,100,20);
        add(boton);

        
        chkbox=new JCheckBox("check1");
        chkbox.setBounds(100,160,100,20);
        add(chkbox);

        chkbox2=new JCheckBox("check2");
        chkbox2.setBounds(100,180,100,20);
        add(chkbox2);

        spinner=new JSpinner();
        spinner.setBounds(200,180,100,20);
        spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        add(spinner);
        
        ButtonGroup btngEdad = new ButtonGroup();
        rdbtn1 = new JRadioButton("radio1");
        btngEdad.add(rdbtn1);
        rdbtn1.setBounds(345, 53, 100, 20);
        add(rdbtn1);

        rdbtn2 = new JRadioButton("radio2");
        btngEdad.add(rdbtn2);
        rdbtn2.setBounds(345, 73, 100, 20);
        add(rdbtn2);
        

        String[] opciones = {"A", "B", "C"};
        DefaultComboBoxModel<String> cmbModel = new DefaultComboBoxModel<String>(opciones);
        cmbFrecuencia= new JComboBox<String>();
        cmbFrecuencia.setModel(cmbModel);
        cmbFrecuencia.setBounds(150, 100, 175, 20);
        add(cmbFrecuencia);

    }

    public void limpiarValores(){
        textField.setText("");
        rdbtn1.setSelected(true);
        rdbtn2.setSelected(false);
        chkbox.setSelected(false);
        chkbox2.setSelected(false);
        spinner.setValue(0);
        cmbFrecuencia.setSelectedIndex(0);
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
