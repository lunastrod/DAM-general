import java.awt.EventQueue;

import com.dam.control.*;
import com.dam.model.*;
import com.dam.view.*;

public class Inicio {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                VentanaPrincipal ventana=new VentanaPrincipal();
                ConsultaRestaurantes panel=new ConsultaRestaurantes();
                RegistraRestaurante panel2=new RegistraRestaurante();
                ModificaRestaurante panel3=new ModificaRestaurante();
                ListaEntidad modelo=new ListaEntidad();
                Controlador controlador=new Controlador(ventana,panel,panel2,panel3,modelo);
                ventana.setControlador(controlador);
                panel.setControlador(controlador);
                panel2.setControlador(controlador);
                panel3.setControlador(controlador);
                ventana.hacerVisible();
            }
        });
    }
}
