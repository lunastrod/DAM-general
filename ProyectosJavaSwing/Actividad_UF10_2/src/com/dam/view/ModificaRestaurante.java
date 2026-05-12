package com.dam.view;


import java.awt.Font;

import javax.swing.*;

import com.dam.control.Controlador;
import com.dam.model.Restaurante;

public class ModificaRestaurante extends JPanel implements IPanel{
    public static final int ANCHO = 600;
    public static final int ALTO = 400;
    public static final String COMANDO_BTN_MODIFICAR="Modificar";
    public static final String COMANDO_BTN_CANCELAR="Cancelar";
    public static final String COMANDO_BTN_BUSCAR="Buscar";

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
    private int idRestaurante;
    private JTextField tfNombre;
    private JTextField tfDireccion;
    private JTextField tfTelefono;
    private JTextField tfCiudad;
    private JTextField tfWeb;
    private JTextField tfPrecioMinimo;
    private JTextField tfPrecioMaximo;
    JButton btnCancelar;
    JButton btnModificar;
    JButton btnBuscar;
    JSpinner spinnerDistincion;

    JComboBox<String> comboRegion;
    JComboBox<String> comboCocina;
    DefaultComboBoxModel<String> modelComboRegion;
    DefaultComboBoxModel<String> modelComboCocina;
    
    

    public ModificaRestaurante(){
        setSize(ANCHO,ALTO);
        setLayout(null);
        crearComponentes();
    }

    @Override
    public void crearComponentes() {
        JLabel lblTitulo = new JLabel("Modificar Restaurante");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(22, 11, 269, 36);
        add(lblTitulo);
        
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(32, 58, 82, 14);
        add(lblNombre);
        
        lblDireccin = new JLabel("Dirección:");
        lblDireccin.setBounds(32, 195, 82, 14);
        add(lblDireccin);
        
        lblTelfono = new JLabel("Teléfono");
        lblTelfono.setBounds(32, 280, 82, 14);
        add(lblTelfono);
        
        lblDistincin = new JLabel("Distinción");
        lblDistincin.setBounds(32, 236, 82, 14);
        add(lblDistincin);
        
        lblRegion = new JLabel("Region:");
        lblRegion.setBounds(32, 154, 82, 14);
        add(lblRegion);
        
        lblWeb = new JLabel("Web");
        lblWeb.setBounds(234, 280, 82, 14);
        add(lblWeb);
        
        lblPrecioMnimo = new JLabel("Precio mínimo:");
        lblPrecioMnimo.setBounds(160, 236, 108, 14);
        add(lblPrecioMnimo);
        
        lblPrecioMximo = new JLabel("máximo:");
        lblPrecioMximo.setBounds(359, 236, 108, 14);
        add(lblPrecioMximo);
        
        lblCiudad = new JLabel("Ciudad");
        lblCiudad.setBounds(234, 154, 82, 14);
        add(lblCiudad);
        
        lblCocina = new JLabel("Cocina");
        lblCocina.setBounds(32, 109, 82, 14);
        add(lblCocina);
        
        tfNombre = new JTextField();
        tfNombre.setBounds(101, 55, 190, 20);
        add(tfNombre);
        tfNombre.setColumns(10);
        
        tfDireccion = new JTextField();
        tfDireccion.setBounds(101, 192, 420, 20);
        add(tfDireccion);
        tfDireccion.setColumns(10);
        
        tfTelefono = new JTextField();
        tfTelefono.setBounds(101, 277, 119, 20);
        add(tfTelefono);
        tfTelefono.setColumns(10);
        
        comboCocina = new JComboBox<String>();
        comboCocina.setBounds(101, 105, 119, 22);
        modelComboCocina = new DefaultComboBoxModel<String>(Restaurante.COCINAS);
        comboCocina.setModel(modelComboCocina);
        add(comboCocina);
        
        tfCiudad = new JTextField();
        tfCiudad.setBounds(311, 151, 214, 20);
        add(tfCiudad);
        tfCiudad.setColumns(10);
        
        tfWeb = new JTextField();
        tfWeb.setBounds(263, 277, 262, 20);
        add(tfWeb);
        tfWeb.setColumns(10);
        
        btnModificar = new JButton(COMANDO_BTN_MODIFICAR);
        btnModificar.setActionCommand(COMANDO_BTN_MODIFICAR);
        btnModificar.setBounds(160, 327, 136, 23);
        add(btnModificar);
        
        btnCancelar = new JButton(COMANDO_BTN_CANCELAR);
        btnCancelar.setActionCommand(COMANDO_BTN_CANCELAR);
        btnCancelar.setBounds(311, 327, 136, 23);
        add(btnCancelar);
        
        tfPrecioMinimo = new JTextField();
        tfPrecioMinimo.setBounds(257, 233, 92, 20);
        add(tfPrecioMinimo);
        tfPrecioMinimo.setColumns(10);
        
        tfPrecioMaximo = new JTextField();
        tfPrecioMaximo.setBounds(433, 233, 92, 20);
        add(tfPrecioMaximo);
        tfPrecioMaximo.setColumns(10);
        
        comboRegion = new JComboBox<String>();
        comboRegion.setBounds(101, 150, 119, 22);
        modelComboRegion = new DefaultComboBoxModel<String>(Restaurante.REGIONES);
        comboRegion.setModel(modelComboRegion);
        add(comboRegion);
        
        spinnerDistincion = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));
        spinnerDistincion.setBounds(101, 233, 45, 20);
        add(spinnerDistincion);    
        
        btnBuscar = new JButton(COMANDO_BTN_BUSCAR);
        btnBuscar.setActionCommand(COMANDO_BTN_BUSCAR);
        btnBuscar.setBounds(311, 54, 136, 23);
        add(btnBuscar);}

    public void cargarValores(Restaurante r){
        idRestaurante=r.getId();
        tfNombre.setText(r.getNombre());
        tfDireccion.setText(r.getDireccion());
        tfTelefono.setText(r.getTelefono());
        tfCiudad.setText(r.getCiudad());
        tfWeb.setText(r.getWeb());
        comboCocina.setSelectedItem(r.getCocina());
        comboRegion.setSelectedItem(r.getRegion());
        spinnerDistincion.setValue(r.getDistincion());
        tfPrecioMinimo.setText(String.valueOf(r.getPrecioMinimo()));
        tfPrecioMaximo.setText(String.valueOf(r.getPrecioMaximo()));
    }

    public void mostrarDatos(boolean mostrar){
        tfDireccion.setEnabled(mostrar);
        tfTelefono.setEnabled(mostrar);
        tfCiudad.setEnabled(mostrar);
        tfWeb.setEnabled(mostrar);
        comboCocina.setEnabled(mostrar);
        comboRegion.setEnabled(mostrar);
        spinnerDistincion.setEnabled(mostrar);
        tfPrecioMinimo.setEnabled(mostrar);
        tfPrecioMaximo.setEnabled(mostrar);
        btnCancelar.setEnabled(mostrar);
        btnModificar.setEnabled(mostrar);
        
        lblDireccin.setEnabled(mostrar);
        lblTelfono.setEnabled(mostrar);
        lblDistincin.setEnabled(mostrar);
        lblRegion.setEnabled(mostrar);
        lblWeb.setEnabled(mostrar);
        lblPrecioMnimo.setEnabled(mostrar);
        lblPrecioMximo.setEnabled(mostrar);
        lblCiudad.setEnabled(mostrar);
        lblCocina.setEnabled(mostrar);
    }

    public void bloqueaBusqueda(boolean bloquear){
        lblNombre.setEnabled(!bloquear);
        tfNombre.setEnabled(!bloquear);
        btnBuscar.setEnabled(!bloquear);
    }

    public String getNombre() {
        String nombre=tfNombre.getText().trim();
        if(nombre.isEmpty()){
            mensajeError("Debe introducir un nombre","Error de datos");
            return null;
        }
        return nombre;
    }


    public Restaurante leerValores(){
        String nombre=tfNombre.getText().trim();
        if(nombre.isEmpty()){
            mensajeError("Debe introducir un nombre","Error de datos");
            return null;
        }
        String direccion=tfDireccion.getText().trim();
        String telefono=tfTelefono.getText().trim();
        String ciudad=tfCiudad.getText().trim();
        if(ciudad.isEmpty()){
            mensajeError("Debe introducir una ciudad","Error de datos");
            return null;
        }
        String web=tfWeb.getText().trim();
        String cocina=(String)comboCocina.getSelectedItem();
        String region=(String)comboRegion.getSelectedItem();
        int distincion=(int)spinnerDistincion.getValue();
        double precioMinimo=0;
        double precioMaximo=0;
        String precioMaximoString=tfPrecioMaximo.getText().trim();
        try{
            precioMinimo=Double.parseDouble(tfPrecioMinimo.getText().trim());
            if(precioMaximoString.isEmpty()){
                precioMaximo=0;
            }
            else{
                precioMaximo=Double.parseDouble(precioMaximoString);
            }
        }catch(NumberFormatException e){
            mensajeError("El precio debe ser un valor numérico","Error de datos");
            return null;
        }
        if(precioMinimo<0 || precioMaximo<0 || precioMinimo>precioMaximo && precioMaximo!=0){
            mensajeError("El precio minimo no puede ser mayor que el máximo","Error de datos");
            return null;
        }
        Restaurante r=new Restaurante(idRestaurante,nombre,region,ciudad,distincion,direccion,precioMinimo,precioMaximo,cocina,telefono,web);
        return r;
    }

    public void mensajeError(String mensaje,String titulo){
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public void limpiarValores(){
        tfNombre.setText("");
        tfDireccion.setText("");
        tfTelefono.setText("");
        tfCiudad.setText("");
        tfWeb.setText("");
        tfPrecioMinimo.setText("");
        tfPrecioMaximo.setText("");
        comboCocina.setSelectedIndex(0);
        comboRegion.setSelectedIndex(0);
        spinnerDistincion.setValue(1);
    }

    @Override
    public void setControlador(Controlador c) {
        btnModificar.addActionListener(c);
        btnCancelar.addActionListener(c);
        btnBuscar.addActionListener(c);
    }
}
