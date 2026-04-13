import java.util.ArrayList;

import com.dam.model.RegTablaPrueba;
import com.dam.model.TablaPruebaPersistencia;

/**
 * Probar la ejecución de distintas sentencias SQL
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // queremos consultar el contenido de la tabla TABLA_PRUEBA
    	TablaPruebaPersistencia tpp = new TablaPruebaPersistencia();
    	
    	consultarTabla(tpp);
    	
    	/*
    	int posId = listaReg.size() + 1;
    	String desc = "Desc " + posId;
    	RegTablaPrueba regInsert = new RegTablaPrueba(desc);
    	int result = tpp.realizarInsert(regInsert);
    	
    	if (result == 1) {
    		System.out.println("Se ha insertado el registro con éxito");
    	}
    	
    	// queremos consultar un registro filtrando por el id
    	RegTablaPrueba reg = tpp.realizarSelectId(posId);
    	System.out.println("El registro correspondiente al id " + posId + " es: \n" + reg);
    	*/
    	
    	
    	// queremos modificar la descripción de algunos registros de la tabla TABLA_PRUEBA
    	
    	String modif = " modificación";
    	String filtro = "rip";
    	int resultModif = tpp.realizarUpdate(modif, filtro);
    	
    	if (resultModif > 0) {
    		System.out.println("Se ha realizado la modificación de " + resultModif + " registros");
    	}
    	  	
    	/*
    	String modif = "Descripción ";
    	String filtro = "0";
    	int resultModif = tpp.realizarUpdate(modif, filtro);
    	
    	if (resultModif > 0) {
    		System.out.println("Se ha realizado la modificación de " + resultModif + " registros");
    	}
    	*/
    	
    	consultarTabla(tpp);
    	
    }

	private static void consultarTabla(TablaPruebaPersistencia tpp) {
		ArrayList<RegTablaPrueba> listaReg = tpp.realizarSelect();
    	
    	System.out.println("Registro de la tabla TABLA_PRUEBA");
    	for (RegTablaPrueba regTablaPrueba : listaReg) {
			System.out.println(regTablaPrueba);
		}
	}
}
