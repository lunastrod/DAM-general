import java.awt.EventQueue;

import com.dam.control.Ecuacion2GListener;
import com.dam.view.VEcuacion2G;

public class Ejercicio3_Ecuacion {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// crear los objetos que actúan en nuestra aplicación
				VEcuacion2G v = new VEcuacion2G();
				
				Ecuacion2GListener e2gl = new Ecuacion2GListener(v);
				
				v.setListener(e2gl);
				
				v.hacerVisible();
				
			}
		});

	}

}
