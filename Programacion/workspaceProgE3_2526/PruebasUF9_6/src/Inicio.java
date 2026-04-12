import java.awt.EventQueue;

import com.dam.control.ControladorPruebas;
import com.dam.model.ListadoAlumnos;
import com.dam.view.VentanaPruebas;

public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VentanaPruebas vp = new VentanaPruebas();
				ListadoAlumnos laModel = new ListadoAlumnos();
				
				ControladorPruebas control = new ControladorPruebas(vp);
				
				vp.cargarTabla(laModel.getListaAlumnos());
				
				vp.setControlador(control);
				
				vp.hacerVisible();
				
			}
		});

	}

}
