import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;

public class ej4Encriptar {
    private static Scanner sc;
    private static final String texto=     "abcdefghijklmnñopqrstuvwxyz1234567890ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private static final String encriptado="fghijklmnñopqrstuvwxyz1234567890ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcde";
    public static void main(String[] args) throws Exception{
        sc= new Scanner(System.in);

        //fichero encriptado.txt
        System.out.println("1. Encriptar un fichero\n2. Desencriptar un fichero\n3. Salir");
        int menu=sc.nextInt();
        if(menu==1){
            encriptar();
        }else if(menu==2){
            desencriptar();
        }
        System.out.println();
    }

    public static void encriptar(){
        int v;
        do{

        }while();
    }

    public static void desencriptar(){
        //pedir nombre fichero
        //si existe pedir contraseña


    }
}