import java.util.ArrayList;

import com.dam.model.PruebasPersistencia;
import com.dam.model.RegTablaPrueba;

public class App 
{
    public static void main( String[] args ){
        PruebasPersistencia pp = new PruebasPersistencia();
        ArrayList<RegTablaPrueba> lista = pp.realizarSelect();
        for (RegTablaPrueba reg : lista) {
            System.out.println(reg);
        }
        RegTablaPrueba reg = pp.realizarSelectId(2);
        System.out.println(reg);
        pp.realizarInsert(new RegTablaPrueba("Nuevo registro"));
    }
}
