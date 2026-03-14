package com.dam.view;

import javax.swing.*;

import com.dam.control.CAgregarProducto;
import com.dam.control.CEliminarProducto;
import com.dam.lib.Graf2;
import com.dam.model.Producto;

public class VListaCompra extends JFrame implements IVentana {
    public static final String[] UNIDADES_MEDIDA={"Kg", "G", "L", "Ud"};

    private JButton btnAgregar;
    private JButton btnEliminar;
    private JTextField txtNombre;
    private JComboBox<String> comboMedida;
    private JSpinner spinnerCantidad;
    private JList<Producto> lista;
    private DefaultListModel<Producto> modeloLista;
    private JLabel lblError;


    public VListaCompra(){
        configurarVentana();
        crearComponentes();
    }

    public String getNombre(){
        return txtNombre.getText();
    }

    public String getUnidadMedida(){
        return (String) comboMedida.getSelectedItem();
    }

    public int getCantidad(){
        return (Integer) spinnerCantidad.getValue();
    }

    public void nuevoProducto(Producto p){
        modeloLista.addElement(p);
    }

    public void mostrarError(String s){
        lblError.setText(s);
    }

    public int getProductoSeleccionado(){
        return lista.getSelectedIndex();
    }

    public void eliminaProducto(int i){
        modeloLista.remove(i);
    }

    public void configurarVentana(){
        Graf2.estilo(this);
        setTitle("Lista de la compra");
        setSize(700, 500);
        setLayout(null);
    }

    public void crearComponentes(){
        JLabel lblProducto = Graf2.estilo(new JLabel("Producto"), this);
        Graf2.posicion(lblProducto, 1, 0.5);
        txtNombre = Graf2.estilo(new JTextField(), this);
        Graf2.posicion(txtNombre, 2, 0.5);

        JLabel lblMedida = Graf2.estilo(new JLabel("Unidad de Medida"), this);
        Graf2.posicion(lblMedida, 3, 0.5);
        comboMedida = Graf2.estilo(new JComboBox<String>(UNIDADES_MEDIDA), this);
        Graf2.posicion(comboMedida, 4, 0.5);

        JLabel lblCantidad = Graf2.estilo(new JLabel("Cantidad"), this);
        Graf2.posicion(lblCantidad, 5, 0.5);
        spinnerCantidad = Graf2.estilo(new JSpinner(new SpinnerNumberModel(1, 1, 500, 1)), this);
        Graf2.posicion(spinnerCantidad, 6, 0.5);

        lblError = Graf2.estilo(new JLabel(""), this);
        Graf2.posicion(lblError, 7, 0.5);

        btnAgregar = Graf2.estilo(new JButton("Añadir"), this);
        Graf2.posicion(btnAgregar, 8, 0.5);
        btnEliminar = Graf2.estilo(new JButton("Eliminar"), this);
        Graf2.posicion(btnEliminar, 8, 1.6);

        JLabel lblLista = Graf2.estilo(new JLabel("Lista de la compra"), this);
        Graf2.posicion(lblLista, 1, 3);
        JScrollPane scrollLista = new JScrollPane();
        modeloLista= new DefaultListModel<>();
        lista = Graf2.estilo(new JList<Producto>(modeloLista), scrollLista, this);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Graf2.posicion(scrollLista, 2, 3);
        Graf2.dimensiones(scrollLista, 3, 8);
    }

    public void setControlador(CAgregarProducto c){
        btnAgregar.addActionListener(c);
    }

    public void setControlador(CEliminarProducto c){
        btnEliminar.addActionListener(c);
    }

    public void hacerVisible(){
        setVisible(true);
    }
}
