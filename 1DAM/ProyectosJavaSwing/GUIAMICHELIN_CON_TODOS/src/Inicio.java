
import java.awt.EventQueue;

import com.dam.control.*;
import com.dam.model.*;
import com.dam.model.db.AccesoDB;
import com.dam.model.db.RestaurantesDAO;
import com.dam.view.*;

public class Inicio {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                VPRestaurantes ventana=new VPRestaurantes();
                PConsultarRestaurantes panel=new PConsultarRestaurantes();
                PRegistrarRestaurante panel2=new PRegistrarRestaurante();
                PModificarRestaurante panel3=new PModificarRestaurante();

                AccesoDB acc=new AccesoDB();
                RestaurantesDAO dao=new RestaurantesDAO();
                RestaurantesListener controlador=new RestaurantesListener(ventana, panel, panel2, panel3, dao);
                ventana.setControlador(controlador);
                panel.setControlador(controlador);
                panel2.setControlador(controlador);
                panel3.setControlador(controlador);
                ventana.hacerVisible();
            }
        });
    }
}
