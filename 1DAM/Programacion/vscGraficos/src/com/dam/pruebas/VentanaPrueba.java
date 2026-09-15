package com.dam.pruebas;
import com.dam.lib.Graf2;
import javax.swing.*;

public class VentanaPrueba extends JFrame {
    public VentanaPrueba() {
        setTitle("Prueba Graf2");
        setSize(1000, 1000);
        setLayout(null);

        Graf2.estilo(this);

        JButton btn = Graf2.estilo(new JButton("Hola"), this);
        Graf2.posicion(btn, 0, 0);

        JLabel lbl = Graf2.estilo(new JLabel("Hola"), this);
        Graf2.posicion(lbl, 1, 0);

        JTextField txf = Graf2.estilo(new JTextField("Hola"), this);
        Graf2.posicion(txf, 2, 0);

        DefaultListModel<String> modelo = new DefaultListModel<>();
        modelo.addElement("Manzana");
        modelo.addElement("Leche");
        JScrollPane scrollLista = new JScrollPane();
        JList<String> lista = Graf2.estilo(new JList<>(modelo), scrollLista, this);
        Graf2.posicion(scrollLista, 3, 0);

        JSpinner spinner = Graf2.estilo(new JSpinner(new SpinnerNumberModel(1, 1, 500, 1)), this);
        Graf2.posicion(spinner, 9, 0);

        JComboBox<String> combo = Graf2.estilo(new JComboBox<>(new String[]{"Kg", "G", "L", "Ud"}), this);
        Graf2.posicion(combo, 10, 0);

        JScrollPane scrollArea = new JScrollPane();
        JTextArea area = Graf2.estilo(new JTextArea(), scrollArea, this);
        Graf2.posicion(scrollArea, 11, 0);

        JCheckBox check = Graf2.estilo(new JCheckBox("Activo"), this);
        Graf2.posicion(check, 17, 0);

        JPasswordField pass = Graf2.estilo(new JPasswordField(), this);
        Graf2.posicion(pass, 18, 0);

        JRadioButton r1 = new JRadioButton("Opción 1");
        JRadioButton r2 = new JRadioButton("Opción 2");
        JRadioButton r3 = new JRadioButton("Opción 3");
        ButtonGroup grupo = Graf2.estiloGrupoRadioButton(new JRadioButton[]{r1, r2, r3}, 19, 0, this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaPrueba();
    }
}