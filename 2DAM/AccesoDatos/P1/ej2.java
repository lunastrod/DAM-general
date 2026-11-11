import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ej2 {
    public static void main(String[] args) throws Exception{
        FileReader fr;
        File f = new File("fic.txt");
        fr=new FileReader(f);

        File out = new File("out.txt");
        FileWriter fw;
        fw=new FileWriter(out);

        int v;
        do {
            v=fr.read();
            System.out.print((char)v);
            if(((char)v)=='a'){
                fw.write('e');
            }else if(v==-1){
                
            }
            else{
                fw.write(v);
            }
        } while (v!=-1);
        fw.close();
        fr.close();
    }
}
