import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

public class ej3 {
    public static void main(String[] args) throws Exception{
        BufferedReader fr;
        File f = new File("lineas.txt");
        fr=new BufferedReader(new FileReader(f));
        String linea;
        int numeroLinea=0;
        do{
            numeroLinea++;
            linea=fr.readLine();
            if(numeroLinea!=2 && linea!=null){
                System.out.println(linea);
            }
        }while(linea!=null);
        
        fr.close();

    }
}
