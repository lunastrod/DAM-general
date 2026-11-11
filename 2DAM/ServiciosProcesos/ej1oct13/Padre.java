package ej1oct13;

import java.io.*;

public class Padre {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "ej1oct13/hijo.jar");
        Process hijo = pb.start();
        System.out.println("Escribe una palabra o 'fin' para terminar.");

        try (BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter haciaHijo = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));
             BufferedReader desdeHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()))) {

            String linea;
            while ((linea = teclado.readLine()) != null) {
                if (linea.equalsIgnoreCase("fin")) {
                    break;
                }
                haciaHijo.write(linea+"\n");
                haciaHijo.flush();

                String numero = desdeHijo.readLine();
                System.out.println(numero);
            }
        }

        hijo.waitFor();
        System.out.println("fin");
    }
}