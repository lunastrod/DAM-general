import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class aa {
    public static void main(String[] args) {
        
        try {
            FileReader re;
            File miau=new File("miau.txt");
            re=new FileReader(miau);
            int i;
            char[]contenido=new char[100];
            re.read(contenido);
            System.out.println(contenido);
            re.close();

            FileWriter wr;
            wr=new FileWriter(miau,true);
            for (int j = 0; j < 10000000; j++) {
                wr.write("a");
                if((j+1)%50==0){
                    wr.write("\n");
                }
            }
            
            wr.close();

        } catch (Exception e) {
            System.out.println("fichero no existe");
        }
        


    }
}
