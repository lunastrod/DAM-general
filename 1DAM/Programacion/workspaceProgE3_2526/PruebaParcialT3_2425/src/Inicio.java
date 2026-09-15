import java.awt.EventQueue;

import com.dam.a.control.ControladorEncuestas;
import com.dam.a.model.DatosEncuestas;
import com.dam.a.view.PRealizarEncuestas;
import com.dam.a.view.PVisualizarEncuestas;
import com.dam.a.view.VPrincipalEncuestas;


public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// Vista
				VPrincipalEncuestas vp = new VPrincipalEncuestas();
				PRealizarEncuestas pre = new PRealizarEncuestas();
				PVisualizarEncuestas pve = new PVisualizarEncuestas();
				
				// Modelo
				DatosEncuestas datos = new DatosEncuestas();
				
				// Control
				ControladorEncuestas control = new ControladorEncuestas(vp, pre, pve, datos);
				
				vp.setControlador(control);
				pre.setControlador(control);
				pve.setControlador(control);
				
				vp.hacerVisible();
				
			}
		});

	}

}
