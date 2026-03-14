import java.awt.EventQueue;

import com.dam.control.CAgregarProducto;
import com.dam.control.CEliminarProducto;
import com.dam.model.ListaCompra;
import com.dam.view.VListaCompra;

public class Inicio {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                VListaCompra ventana=new VListaCompra();
                ListaCompra modelo=new ListaCompra();
                CAgregarProducto controlador=new CAgregarProducto(modelo, ventana);
                CEliminarProducto controlador2=new CEliminarProducto(modelo, ventana);
                ventana.setControlador(controlador);
                ventana.setControlador(controlador2);
                ventana.hacerVisible();
            }
        });
    }
}
