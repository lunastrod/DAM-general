import java.io.File;
//import java.util.Scanner;
import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {
        //introduce nombre de fichero o directorio
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre de fichero o directorio");
        File f = new File(sc.nextLine());

        //si no existe aparecera fichero inexistente
        if(f.exists() == false){
            System.out.println("Fichero inexistente");
            sc.close();
            return;
        }
        //si es ficheromuestra su nombre  y si es ejecutable o no, tamaño y path
        if(f.isFile()){
            System.out.println("Fichero: " + f.getName());
            System.out.println("Ejecutable: " + f.canExecute());
            System.out.println("Tamaño: " + f.length());
            System.out.println("Path: " + f.getPath());
        }
        //si es directorio muestra todos los directorios dentro de el y todos los ficheros con su tamaño
        else if(f.isDirectory()){
            System.out.println("Directorio: " + f.getName());
            File[] ficheros = f.listFiles();
            for(File f2 : ficheros){
                System.out.println("Fichero: " + f2.getName());
                System.out.println("Tamaño: " + f2.length());
            }
        }
        sc.close();
    }
}
