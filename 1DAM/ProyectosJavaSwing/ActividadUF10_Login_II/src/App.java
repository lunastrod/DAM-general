import java.awt.EventQueue;
import java.util.ArrayList;

import com.dam.control.LoginControlador;
import com.dam.model.Usuario;
import com.dam.model.UsuariosDAO;
import com.dam.view.VLogin;
import com.dam.view.VPrincipal;
import com.dam.view.VRegistro;

public class App 
{
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VLogin v = new VLogin();
				VPrincipal vp = new VPrincipal();
				VRegistro vr = new VRegistro();
				
				LoginControlador lc = new LoginControlador(v, vp, vr);
				
				v.setControlador(lc);
				vr.setControlador(lc);				
				v.hacerVisible();
				
			}
			
		});
    	
    }

}
