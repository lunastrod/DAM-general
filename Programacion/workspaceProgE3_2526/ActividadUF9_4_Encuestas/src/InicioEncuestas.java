import java.awt.EventQueue;

import com.dam.control.ControladorEncuestas;
import com.dam.model.DatosEncuestas;
import com.dam.view.PConsultarEncuestas;
import com.dam.view.PRealizarEncuesta;
import com.dam.view.VPrincipalEncuestas;

public class InicioEncuestas {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// Vista
				VPrincipalEncuestas vp = new VPrincipalEncuestas();
				PRealizarEncuesta pr = new PRealizarEncuesta();
				PConsultarEncuestas pc = new PConsultarEncuestas();
				
				// Modelo
				DatosEncuestas datos = new DatosEncuestas();
				
				// Control
				ControladorEncuestas control = new ControladorEncuestas(vp, pr, pc, datos);
				
				vp.setControlador(control);
				pr.setControlador(control);
				pc.setControlador(control);
				
				vp.hacerVisible();
				
			}
		});

	}

}
