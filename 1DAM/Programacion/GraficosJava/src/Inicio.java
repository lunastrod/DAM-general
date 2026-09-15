import java.awt.EventQueue;

public class Inicio {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				VentanaPrincipal vp = new VentanaPrincipal();
			}
		});
	}
}