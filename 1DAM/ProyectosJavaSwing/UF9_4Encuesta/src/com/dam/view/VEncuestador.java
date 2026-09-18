package com.dam.view;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.dam.control.EncuestadorControlador;
import com.dam.lib.Graf3;
import com.dam.model.Encuesta;
import com.dam.model.ListaEncuestas;

public class VEncuestador extends JFrame implements IVentana {
    private static final String TITULO="Encuestas COVID";
    private static final int ANCHO=1500;
    private static final int ALTO=580;

    public static final String TEXTO_BOTON_GUARDAR="Guardar";
    public static final String TEXTO_BOTON_LIMPIAR="Limpiar";
    public static final String TEXTO_BOTON_VER_ENCUESTAS="Ver encuestas";

    JSpinner spinnerEdad;
    JComboBox<String> comboCovid;
    JCheckBox[] checkSintomas;
    JRadioButton[] radioGravedad;
    JButton btnGuardar;
    JButton btnLimpiar;
    JButton btnVerEncuestas;
    DefaultListModel<Encuesta> modeloLista;
    JList<Encuesta> areaEncuestas;
    JLabel lblError;

    public VEncuestador(){
        configurarVentana();
        crearComponentes();
    }

    public Encuesta getEncuesta(){
        int edad = (Integer) spinnerEdad.getValue();
        String covid = (String) comboCovid.getSelectedItem();
        String sintomas = "";
        for(int i=0; i<checkSintomas.length; i++){
            if(checkSintomas[i].isSelected()){
                sintomas += checkSintomas[i].getText()+", ";
            }
        }
        String gravedad = "";
        for(int i=0; i<radioGravedad.length; i++){
            if(radioGravedad[i].isSelected()){
                gravedad = radioGravedad[i].getText();
            }
        }


        if(sintomas.length()==0 || gravedad.length()==0){
            mostrarError("Todos los campos son obligatorios.");
            return null;
        }

        return new Encuesta(edad, covid, sintomas, gravedad);
    }

    public void limpiaFormulario(){
        spinnerEdad.setValue(1);
        comboCovid.setSelectedIndex(0);
        for(int i=0; i<checkSintomas.length; i++){
            checkSintomas[i].setSelected(false);
        }
        radioGravedad[0].setSelected(true);
    }

    public void mostrarListaEncuestas(ListaEncuestas listaEncuestas){
        modeloLista.clear();
        for(Encuesta e: listaEncuestas.getLista()){
            modeloLista.addElement(e);
        }
    }

    public void mostrarError(String error){
        lblError.setForeground(Color.RED);
        lblError.setText(error);
    }

    public void mostrarMensaje(String error){
        lblError.setForeground(Color.BLACK);
        lblError.setText(error);
    }

    public void configurarVentana(){
		setTitle(TITULO);
        setSize(ANCHO, ALTO);
        setLayout(null);
        Graf3.estilo(this);
    }
	
	public void crearComponentes(){
        
        JLabel lblEdad=Graf3.estilo(new JLabel(Encuesta.PREGUNTAS[0]), this);
        Graf3.posicion(lblEdad, 0,0);
        spinnerEdad = Graf3.estilo(new JSpinner(new SpinnerNumberModel(1, 1, 120, 1)), this);
        Graf3.posicion(spinnerEdad, 0,2);

        JLabel lblCovid=Graf3.estilo(new JLabel(Encuesta.PREGUNTAS[1]), this);
        Graf3.posicion(lblCovid, 1,0);
        comboCovid = Graf3.estilo(new JComboBox<String>(Encuesta.RESPUESTAS_POSIBLES[1]), this);
        Graf3.posicion(comboCovid, 1,2);
        Graf3.dimensiones(comboCovid, 1, 1);

        JLabel lblSintomas=Graf3.estilo(new JLabel(Encuesta.PREGUNTAS[2]), this);
        Graf3.posicion(lblSintomas, 2,0);
        checkSintomas = new JCheckBox[8];
        for (int i = 0; i < checkSintomas.length; i++) {
            checkSintomas[i] = new JCheckBox(Encuesta.RESPUESTAS_POSIBLES[2][i]);
            Graf3.estilo(checkSintomas[i], this);
        }
        Graf3.posicion(checkSintomas[0], 3,0);
        Graf3.posicion(checkSintomas[1], 3,2);
        Graf3.posicion(checkSintomas[2], 4,0);
        Graf3.posicion(checkSintomas[3], 4,2);
        Graf3.posicion(checkSintomas[4], 5,0);
        Graf3.posicion(checkSintomas[5], 5,2);
        Graf3.posicion(checkSintomas[6], 6,0);
        Graf3.posicion(checkSintomas[7], 6,2);

        JLabel lblGravedad=Graf3.estilo(new JLabel(Encuesta.PREGUNTAS[3]), this);
        Graf3.posicion(lblGravedad, 7,0);

        radioGravedad = new JRadioButton[5];
        ButtonGroup grupoGravedad = new ButtonGroup();
        for (int i = 0; i < radioGravedad.length; i++) {
            radioGravedad[i] = new JRadioButton(Encuesta.RESPUESTAS_POSIBLES[3][i]);
            Graf3.estilo(radioGravedad[i], this);
            grupoGravedad.add(radioGravedad[i]);
        }
        Graf3.posicion(radioGravedad[0], 8,0);
        Graf3.posicion(radioGravedad[1], 8,1);
        Graf3.posicion(radioGravedad[2], 8,2);
        Graf3.posicion(radioGravedad[3], 9,0.5);
        Graf3.posicion(radioGravedad[4], 9,1.5);

        lblError = Graf3.estilo(new JLabel(""), this);
        Graf3.dimensiones(lblError, 4,1);
        Graf3.posicion(lblError, 10,0);

        btnGuardar = Graf3.estilo(new JButton(TEXTO_BOTON_GUARDAR), this);
        Graf3.posicion(btnGuardar, 11,1);

        btnLimpiar = Graf3.estilo(new JButton(TEXTO_BOTON_LIMPIAR), this);
        Graf3.posicion(btnLimpiar, 0,4);

        btnVerEncuestas = Graf3.estilo(new JButton(TEXTO_BOTON_VER_ENCUESTAS), this);
        Graf3.posicion(btnVerEncuestas, 0,6);
        Graf3.dimensiones(btnVerEncuestas, 2, 1);
        JScrollPane scrollEncuestas = new JScrollPane();

        modeloLista = new DefaultListModel<>();
        areaEncuestas = Graf3.estilo(new JList<Encuesta>(modeloLista), scrollEncuestas, this);
        Graf3.posicion(scrollEncuestas, 1.5,4);
        Graf3.dimensiones(scrollEncuestas, 10, 11);
    }
	
	public void setControlador(EncuestadorControlador ch){
        btnGuardar.addActionListener(ch);
        btnLimpiar.addActionListener(ch);
        btnVerEncuestas.addActionListener(ch);
    }
	
	public void hacerVisible(){
        this.setVisible(true);
    }

}
