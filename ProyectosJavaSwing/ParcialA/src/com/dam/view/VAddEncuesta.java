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

public class VAddEncuesta extends JFrame implements IVentana {
    private static final String[] FRECUENCIAS = {"Ninguna", "1 o 2 veces por semana", "3 o 4 veces por semana", "5 o 6 veces por semana", "Todos los dias"};
    private static final String BTN_ADD_PRODUCTO = "Guardar Encuesta";

    private static final String TITULO="ENCUESTAS";
    private static final int ANCHO=600;
    private static final int ALTO=400;
    JRadioButton rdbtn517, rdbtn1830, rdbtn3140, rdbtn4165, rdbtn65;
    ButtonGroup btngEdad = new ButtonGroup();
    JComboBox<String> cbxSeries;
    JList<String> lstSeries;
    JScrollPane scrollPane;
    JCheckBox chckJdT, chckV, chckBB, chckST, chckECdlC, chckDB, chck7V;
    JButton btnGuardarEncuesta, btnAddProducto, btnVer;
    Controlador controlador;
    JComboBox<String> cmbFrecuencia;



    public VAddEncuesta(){
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
        
        JLabel lblTitulo = new JLabel("Realizar encuesta");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setBounds(25, 20, 150, 25);
        add(lblTitulo);
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(45, 55, 70, 14);
        add(lblEdad);
        rdbtn517 = new JRadioButton("Entre 5 y 17");
        btngEdad.add(rdbtn517);
        rdbtn517.setBounds(125, 53, 100, 20);
        add(rdbtn517);
        rdbtn1830 = new JRadioButton("Entre 18 y 30");
        btngEdad.add(rdbtn1830);
        rdbtn1830.setBounds(235, 53, 100, 20);
        add(rdbtn1830);
        rdbtn3140 = new JRadioButton("Entre 31 y 40");
        btngEdad.add(rdbtn3140);
        rdbtn3140.setBounds(345, 53, 100, 20);
        add(rdbtn3140);
        rdbtn4165 = new JRadioButton("Entre 41 y 65");
        btngEdad.add(rdbtn4165);
        rdbtn4165.setBounds(125, 80, 100, 20);
        add(rdbtn4165);
        rdbtn65 = new JRadioButton("Más de 65");
        btngEdad.add(rdbtn65);
        rdbtn65.setBounds(235, 80, 100, 20);
        add(rdbtn65);
        JLabel lblFrecuencia = new JLabel("Frecuencia:");
        lblFrecuencia.setBounds(45, 115, 80, 14);
        add(lblFrecuencia);
        cmbFrecuencia = new JComboBox<String>();
        DefaultComboBoxModel<String> cmbModel = new
        DefaultComboBoxModel<String>(FRECUENCIAS);
        cmbFrecuencia.setModel(cmbModel);
        cmbFrecuencia.setBounds(150, 113, 175, 20);
        add(cmbFrecuencia);
        JLabel lblSeries = new JLabel("Series:");
        lblSeries.setBounds(45, 150, 80, 14);
        add(lblSeries);
        chckJdT = new JCheckBox("Juego de Tronos");
        chckJdT.setBounds(125, 148, 150, 22);
        add(chckJdT);
        chckV = new JCheckBox("Vikingos");
        chckV.setBounds(305, 148, 150, 22);
        add(chckV);
        chckBB = new JCheckBox("Breaking Bad");
        chckBB.setBounds(125, 175, 150, 22);
        add(chckBB);
        chckST = new JCheckBox("Stranger Things");
        chckST.setBounds(305, 175, 150, 22);
        add(chckST);
        chckECdlC = new JCheckBox("El Cuento de la Criada");
        chckECdlC.setBounds(125, 202, 175, 22);
        add(chckECdlC);
        chckECdlC = new JCheckBox("El Juego del Calamar");
        chckECdlC.setBounds(305, 202, 150, 22);
        add(chckECdlC);
        chckDB = new JCheckBox("Dragon Ball");
        chckDB.setBounds(125, 229, 150, 22);
        add(chckDB);
        chck7V = new JCheckBox("7 Vidas");
        chck7V.setBounds(305, 229, 150, 22);
        add(chck7V);
        btnAddProducto = new JButton(BTN_ADD_PRODUCTO);
        btnAddProducto.setBounds(225, 275, 150, 22);
        add(btnAddProducto);
        /*
        PVerEncuestas:
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
        */
    }
	
	public void setControlador(Controlador ch){
        //TODO: configurar controlador (addActionListener)
    }
	
	public void hacerVisible(){
        this.setVisible(true);
    }

}
