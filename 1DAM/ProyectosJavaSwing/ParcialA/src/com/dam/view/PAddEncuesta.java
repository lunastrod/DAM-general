package com.dam.view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.dam.control.EncuestadorControlador;
import com.dam.model.Encuesta;

public class PAddEncuesta extends JPanel {
    
    public static final String BTN_ADD_PRODUCTO = "Guardar Encuesta";
    private static final int ANCHO=600;
    private static final int ALTO=400;
    private JRadioButton rdbtn517, rdbtn1830, rdbtn3140, rdbtn4165, rdbtn65;
    private ButtonGroup btngEdad = new ButtonGroup();
    private JCheckBox chckJdT, chckV, chckBB, chckST, chckECdlC, chckEJdC, chckDB, chck7V;
    private JButton btnAddProducto;
    private JComboBox<String> cmbFrecuencia;
    private JLabel mensaje;

    public PAddEncuesta(){
        setLayout(null);
        setSize(ANCHO,ALTO);
        crearComponentes();
    }

    public void mostrarMensaje(String mensaje) {
        this.mensaje.setText(mensaje);
    }

    public Encuesta getEncuesta() {
        String edad = "";
        if(rdbtn517.isSelected()) edad = Encuesta.EDAD[0];
        else if(rdbtn1830.isSelected()) edad = Encuesta.EDAD[1];
        else if(rdbtn3140.isSelected()) edad = Encuesta.EDAD[2];
        else if(rdbtn4165.isSelected()) edad = Encuesta.EDAD[3];
        else if(rdbtn65.isSelected()) edad = Encuesta.EDAD[4];
        String frecuencia = cmbFrecuencia.getSelectedItem().toString();

        ArrayList<String> series = new ArrayList<>();
        if(chckJdT.isSelected()) series.add(Encuesta.SERIES[0]);
        if(chckV.isSelected()) series.add(Encuesta.SERIES[1]);
        if(chckBB.isSelected()) series.add(Encuesta.SERIES[2]);
        if(chckST.isSelected()) series.add(Encuesta.SERIES[3]);
        if(chckECdlC.isSelected()) series.add(Encuesta.SERIES[4]);
        if(chckEJdC.isSelected()) series.add(Encuesta.SERIES[5]);
        if(chckDB.isSelected()) series.add(Encuesta.SERIES[6]);
        if(chck7V.isSelected()) series.add(Encuesta.SERIES[7]);

        return new Encuesta(edad, frecuencia, series);
    }

    public void limpiarFormulario() {
        btngEdad.setSelected(rdbtn517.getModel(),true);
        cmbFrecuencia.setSelectedIndex(0);
        chckJdT.setSelected(false);
        chckV.setSelected(false);
        chckBB.setSelected(false);
        chckST.setSelected(false);
        chckECdlC.setSelected(false);
        chckEJdC.setSelected(false);
        chckDB.setSelected(false);
        chck7V.setSelected(false);
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
        DefaultComboBoxModel<String>(Encuesta.FRECUENCIAS);
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
        chckEJdC = new JCheckBox("El Juego del Calamar");
        chckEJdC.setBounds(305, 202, 150, 22);
        add(chckEJdC);
        chckDB = new JCheckBox("Dragon Ball");
        chckDB.setBounds(125, 229, 150, 22);
        add(chckDB);
        chck7V = new JCheckBox("7 Vidas");
        chck7V.setBounds(305, 229, 150, 22);
        add(chck7V);
        btnAddProducto = new JButton(BTN_ADD_PRODUCTO);
        btnAddProducto.setBounds(225, 275, 150, 22);
        btnAddProducto.setActionCommand(BTN_ADD_PRODUCTO);
        add(btnAddProducto);
        btngEdad.setSelected(rdbtn517.getModel(),true);
        mensaje = new JLabel();
        mensaje.setBounds(225, 300, 150, 22);
        add(mensaje);
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
	
	public void setControlador(EncuestadorControlador ch){
        btnAddProducto.addActionListener(ch);
    }
	
	public void hacerVisible(){
        this.setVisible(true);
    }

}
