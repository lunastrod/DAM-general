import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ej1 {
    public static void main(String[] args) {
        leeFichero();
    }

    public static void leeFichero(){
        FileReader fr;
        FileWriter fw;
        File f = new File("fic.txt");
        try {
            f.createNewFile();
            fw=new FileWriter(f);
            
            fw.write("Prueba para escribir una cadena de caracteres en un fichero");
            fw.close();

            fr=new FileReader(f);
            int v;
            do {
                v=fr.read();
                System.out.print((char)v);
            } while (v!=-1);
            fr.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
