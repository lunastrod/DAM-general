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
                AccesoDBProp acc=new AccesoDBProp();
                RestauranteDAO dao=new RestauranteDAO(acc);
                Controlador controlador=new Controlador(ventana,panel,panel2,panel3,dao);
                ventana.setControlador(controlador);
                panel.setControlador(controlador);
                panel2.setControlador(controlador);
                panel3.setControlador(controlador);
                ventana.hacerVisible();
            }
        });
    }
}
