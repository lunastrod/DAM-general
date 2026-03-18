import java.awt.EventQueue;

import com.dam.control.EncuestadorControlador;
import com.dam.model.ListaEncuestas;
import com.dam.view.VEncuestador;


public class Inicio {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                VEncuestador ventana=new VEncuestador();
                ListaEncuestas modelo=new ListaEncuestas();
                EncuestadorControlador controlador=new EncuestadorControlador(ventana,modelo);
                ventana.setControlador(controlador);
                ventana.hacerVisible();
            }
        });
    }
}
