import java.awt.EventQueue;

import com.dam.control.ControladorHipoteca;
import com.dam.view.VentanaHipoteca;

public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VentanaHipoteca vh = new VentanaHipoteca();
				
				ControladorHipoteca ch = new ControladorHipoteca(vh);
				
				vh.setControlador(ch);
				
				vh.hacerVisible();
				
			}
		});

	}

}
