import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class HolaMundoGraf {

	public static void main(String[] args) {
		JFrame marco = new JFrame("Ventana Hola Mundo");
		marco.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JLabel lblSaludo = new JLabel("¡¡ Hola Mundo !!");
		
		marco.getContentPane().add(lblSaludo);
		
		marco.pack();
		marco.setLocationRelativeTo(null);
		
		marco.setVisible(true);
	}

}
