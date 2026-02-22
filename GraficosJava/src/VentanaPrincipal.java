import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {
	public VentanaPrincipal() {
		configurarVentana();
	}
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	private void configurarVentana() {
		setTitle("Primera Prueba de IG");
		getContentPane().setBackground(new Color(250, 230, 255));
		getContentPane().setLayout(null);
		
		configurarLabel();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		setSize(300,200);
		setVisible(true);
	}
	
	private void configurarLabel() {
		JLabel lblNewLabel = new JLabel("miau");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(40, 56, 157, 28);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(68, 108, 111, 42);
		textField.setColumns(10);
		getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(142, 56, 89, 23);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				lblNewLabel.setText("miau "+nombre);
			}
		});
	}
}
