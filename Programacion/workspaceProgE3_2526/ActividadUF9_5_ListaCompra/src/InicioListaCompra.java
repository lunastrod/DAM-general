import java.awt.EventQueue;

import com.dam.control.ControladorListaCompra;
import com.dam.model.ListaCompra;
import com.dam.view.VListaCompra;

public class InicioListaCompra {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// Crear los objetos que representan los actores de la aplicación
				VListaCompra vlc = new VListaCompra();
				ListaCompra lc = new ListaCompra();
				
				ControladorListaCompra clc = new ControladorListaCompra(vlc, lc);
				
				vlc.setControlador(clc);
				
				vlc.hacerVisible();
				
			}
		});

	}

}
