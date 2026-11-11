package p1encriptacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class P1Encriptacion {
    private static final String ENTRADA="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String SALIDA= "jklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi5678901234";
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            try{
                System.out.println("\n===== MENU =====");
                System.out.println("1. Encriptar un fichero");
                System.out.println("2. Desencriptar un fichero");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        opcionEncriptar(sc);
                        break;

                    case 2:
                        opcionDesencriptar(sc);
                        break;

                    case 3:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
                opcion=0;
                sc.nextLine();
            }
        } while (opcion != 3);

        sc.close();
    }

    public static void opcionEncriptar(Scanner sc) {

        System.out.print("Introduce el nombre del fichero: ");
        String nombreFichero = sc.nextLine().strip();
        //System.out.println("nombre: "+nombreFichero);

        File fichero = new File(nombreFichero);

        if (!fichero.isFile()) {
            System.out.println("Error: el fichero no existe.");
            return;
        }

        System.out.print("Introduce una contraseña: ");
        String contrasenia = sc.nextLine().strip();

        File salida = new File("encriptado.txt");

        try {
            FileReader lector = new FileReader(fichero);
            FileWriter escritor = new FileWriter(salida);
            escritor.write("Contrasenia:" + contrasenia);
            escritor.write("\n");
            int caracter = lector.read();
            int i=0;
            while (caracter != -1) {
                i=ENTRADA.indexOf(caracter);
                if(i==-1){
                    escritor.write(caracter);
                }else{
                    escritor.write(SALIDA.charAt(i));
                }
                caracter = lector.read();
            }
            lector.close();
            escritor.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
            return;
        }

        System.out.println("Fichero encriptado.txt creado correctamente.");
    }

    public static void opcionDesencriptar(Scanner sc) {

        System.out.print("Introduce el nombre del fichero: ");
        String nombreFichero = sc.nextLine();

        File fichero = new File(nombreFichero);

        if (!fichero.exists()) {
            System.out.println("Error: el fichero no existe.");
            return;
        }

        System.out.print("Introduce una contraseña: ");
        String contrasenia = sc.nextLine();

        try {
            FileReader lector = new FileReader(fichero);
            BufferedReader bufferedReader = new BufferedReader(lector);
            String linea = bufferedReader.readLine();
            if(!linea.startsWith("Contrasenia:")){
                System.out.println("Error: el fichero no es un fichero encriptado.");
                lector.close();
                return;
            }
            String contraseniaFichero = linea.substring(12);
            //System.out.println("Contrasenia: "+contraseniaFichero);
            if (!contraseniaFichero.equals(contrasenia)) {
                System.out.println("Error: la contraseña es incorrecta.");
                lector.close();
                return;
            }
            System.out.println("Contrasenia correcta. Desencriptando...\n");
            int caracter = bufferedReader.read();
            int i=0;
            while (caracter != -1) {
                i=SALIDA.indexOf((char)caracter);
                if(i==-1){
                    System.out.print((char)caracter);
                }else{
                    System.out.print(ENTRADA.charAt(i));
                }
                caracter = bufferedReader.read();
            }
            lector.close();
            System.out.println("\n");

        } catch (IOException e) {
            System.out.println("Error: " + e);
            return;
        }
    }

}