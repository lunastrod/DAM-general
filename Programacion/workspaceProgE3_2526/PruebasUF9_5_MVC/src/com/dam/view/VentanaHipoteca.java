package com.dam.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.dam.control.ControladorHipoteca;
import com.dam.model.DatosHipoteca;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class VentanaHipoteca extends JFrame implements IVentanaHipoteca {
	private static final double LIM_SUP_CANTIDAD = 20000000;
	private static final double LIM_INF_CANTIDAD = 1000;
	private static final int LIM_SUP_ANIOS = 50;
	private static final int LIM_INF_ANIOS = 0;
	private static final double LIM_SUP_INTERES = 15;
	private static final double LIM_INF_INTERES = 0;
	
	private JTextField txtCantidad;
	private JTextField txtAnios;
	private JTextField txtInteres;
	private JButton btnCalcular;
	private JLabel lblResultado;
	
	public VentanaHipoteca() {
		configurarVentana();
		
		crearComponentes();
		
	}

	
	@Override
	public void configurarVentana() {
		setTitle("Cálculo de la cuota mensual de una hipoteca");
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(500, 200);
		
		// provisional
		setLocationRelativeTo(null);

	}

	@Override
	public void crearComponentes() {
		getContentPane().setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(19, 23, 64, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(93, 20, 96, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblAnios = new JLabel("Años:");
		lblAnios.setBounds(217, 23, 48, 14);
		getContentPane().add(lblAnios);
		
		txtAnios = new JTextField();
		txtAnios.setBounds(275, 20, 39, 20);
		getContentPane().add(txtAnios);
		txtAnios.setColumns(10);
		
		JLabel lblInteres = new JLabel("Interés: ");
		lblInteres.setBounds(342, 23, 54, 14);
		getContentPane().add(lblInteres);
		
		txtInteres = new JTextField();
		txtInteres.setBounds(406, 20, 48, 20);
		getContentPane().add(txtInteres);
		txtInteres.setColumns(10);
		
		btnCalcular = new JButton("Calcular cuota");
		btnCalcular.setBounds(182, 59, 122, 22);
		getContentPane().add(btnCalcular);
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(75, 106, 332, 14);
		getContentPane().add(lblResultado);

	}

	@Override
	public void setControlador(ControladorHipoteca ch) {
		btnCalcular.addActionListener(ch);

	}

	@Override
	public void hacerVisible() {
		setVisible(true);

	}


	public DatosHipoteca getDatosHipoteca() {
		DatosHipoteca dh = null;
		
		String sCantidad = txtCantidad.getText();
		String sAnios = txtAnios.getText();
		String sInteres = txtInteres.getText();
		
		try {
			double cantidad = Double.parseDouble(sCantidad);
			int anios = Integer.parseInt(sAnios);
			double interes = Double.parseDouble(sInteres);
			
			if (cantidad <= LIM_INF_CANTIDAD || cantidad > LIM_SUP_CANTIDAD) {
				throw new Exception("Cantidad debe ser un valor entre " 
						+ LIM_INF_CANTIDAD + " y " + LIM_SUP_CANTIDAD);
				
			} else if (anios <= LIM_INF_ANIOS || anios > LIM_SUP_ANIOS) {
				throw new Exception("Años debe ser un valor entre " 
						+ LIM_INF_ANIOS + " y " + LIM_SUP_ANIOS);
				
			} else if (interes <= LIM_INF_INTERES || interes > LIM_SUP_INTERES) {
				throw new Exception("Interés debe ser un valor entre " 
						+ LIM_INF_INTERES + " y " + LIM_SUP_INTERES);
				
			} else {
				dh = new DatosHipoteca(cantidad, anios, interes);
				
			}
			
		} catch (NumberFormatException e) {
			mostrarError("Los valores deben ser numéricos");
		} catch (Exception e) {
			mostrarError(e.getMessage());
		}
		
		return dh;
	}


	private void mostrarError(String error) {
		lblResultado.setText(error);
		lblResultado.setForeground(Color.RED);
		
	}


	public void mostrarCuota(double cuotaM) {
		lblResultado.setText("Cuota mensual: " + cuotaM);
		lblResultado.setForeground(Color.BLUE);
		
	}
	
	
}
