import java.awt.EventQueue;

import com.dam.control.ControladorPruebas;
import com.dam.view.PanelAzul;
import com.dam.view.PanelRojo;
import com.dam.view.VentanaPrincipalPruebas;

public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VentanaPrincipalPruebas vp = new VentanaPrincipalPruebas();
				PanelRojo pr = new PanelRojo();
				PanelAzul pa = new PanelAzul();
				
				ControladorPruebas control = new ControladorPruebas(vp, pr, pa);
				
				vp.setControlador(control);
				pa.setControlador(control);
				
				vp.hacerVisible();
				
			}
		});

	}

}
