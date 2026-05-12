import java.awt.EventQueue;
import java.util.ResourceBundle.Control;

import com.dam.control.*;
import com.dam.model.*;
import com.dam.view.*;

public class Inicio {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                VentanaPrincipal ventana=new VentanaPrincipal();
                PanelSolicitar panel=new PanelSolicitar();
                PanelMostrar panel2=new PanelMostrar();
                ListaEntidad modelo=new ListaEntidad();
                Controlador controlador=new Controlador(ventana,panel,panel2,modelo);
                ventana.setControlador(controlador);
                panel.setControlador(controlador);
                panel2.setControlador(controlador);
                ventana.hacerVisible();
            }
        });
    }
}
