package com.dam.mar12;

import javax.swing.*;

import com.dam.lib.Graf1;
import com.dam.lib.Graf2;

/*Ejercicios con Interfaz gráfica III
En el view:

Solo para valientes:
El que se atreva que añada un botón para eliminar productos de la lista.
En la ventana, en la Lista solo se deberá poder seleccionar un elemento
(SelectionMode = SINGLE_SELECTION)

En el listener, habrá que diferenciar entre el botón añadir y el botón eliminar.
Si el evento se produce en el botón eliminar, se preguntará a la ventana por el
índice del producto seleccionado en la JList.

Si ese índice es -1 será porque no se ha seleccionado ningún elemento, no se
podrá eliminar nada y se mostrará un mensaje indicándolo.

Si el índice es distinto de -1 habrá que eliminar de la lista del modelo el
elemento en dicha posición y actualizar el contenido de la JList. */

public class VListaCompra extends JFrame {
    public VListaCompra(){
        configurarVentana();
        crearComponentes();
    }

    public void configurarVentana(){
        Graf2.estilo(this);
        setTitle("Lista de la compra");
        setSize(700, 500);
        setLayout(null);
    }

    public void crearComponentes(){
        //TODO
        /*
        JTextField para introducir el nombre de cada producto
        JSpinner para introducir la cantidad, que permita del 1 al 500
        JComboBox con las opciones: Kg, G (para gramos), L (para litros) y Ud (para unidades), 
        botón para añadir el producto introducido
        JList para mostrar los productos que se van añadiendo.
        */
        
        JLabel lblProducto = Graf2.estilo(new JLabel("Producto"), this);
        Graf2.posicion(lblProducto, 1, 0.5);
        JTextField txtNombre = Graf2.estilo(new JTextField(), this);
        Graf2.posicion(txtNombre, 2, 0.5);

        JLabel lblMedida = Graf2.estilo(new JLabel("Unidad de Medida"), this);
        Graf2.posicion(lblMedida, 3, 0.5);
        JComboBox<String> comboMedida = Graf2.estilo(new JComboBox<String>(new String[]{"Kg", "G", "L", "Ud"}), this);
        Graf2.posicion(comboMedida, 4, 0.5);

        JLabel lblCantidad = Graf2.estilo(new JLabel("Cantidad"), this);
        Graf2.posicion(lblCantidad, 5, 0.5);
        JSpinner spinner = Graf2.estilo(new JSpinner(), this);
        Graf2.posicion(spinner, 6, 0.5);

        JButton btnAgregar = Graf2.estilo(new JButton("Añadir"), this);
        Graf2.posicion(btnAgregar, 8, 0.5);

        JLabel lblLista = Graf2.estilo(new JLabel("Lista de la compra"), this);
        Graf2.posicion(lblLista, 1, 3);
        JScrollPane scrollLista = new JScrollPane();
        JList<String> lista = Graf2.estilo(new JList<String>(), scrollLista, this);
        
        Graf2.posicion(scrollLista, 2, 3);
        Graf2.dimensiones(scrollLista, 3, 8);
        
        
    }

    public void hacerVisible(){
        Graf1.show(this);
    }
}
