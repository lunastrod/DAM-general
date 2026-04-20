import java.awt.EventQueue;

import com.dam.control.Controlador;
import com.dam.model.DatosAlbumes;
import com.dam.view.PanelConsultar;
import com.dam.view.VentanaPrincipal;

public class Inicio {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                VentanaPrincipal ventana=new VentanaPrincipal();
                PanelConsultar panel=new PanelConsultar();
                DatosAlbumes datos=new DatosAlbumes();
                System.out.println(datos);
                Controlador controlador=new Controlador(ventana,panel,datos);
                ventana.setControlador(controlador);
                panel.setControlador(controlador);
                ventana.hacerVisible();
            }
        });
    }
}
