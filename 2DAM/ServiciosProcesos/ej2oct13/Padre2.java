package ej2oct13;

import java.io.*;

public class Padre2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "ej2oct13/hijo2.jar");
        Process hijo = pb.start();
        System.out.println("Escribe una palabra o 'fin' para terminar.");

        try (BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter haciaHijo = new BufferedWriter(new OutputStreamWriter(hijo.getOutputStream()));
             BufferedReader desdeHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()))) {

            String linea;
            while ((linea = teclado.readLine()) != null) {
                if (linea.trim().equalsIgnoreCase("fin")) {
                    break;
                }
                haciaHijo.write(linea);
                haciaHijo.newLine();
                haciaHijo.flush();

                String respuesta = desdeHijo.readLine();
                System.out.println(respuesta);
            }
        }

        hijo.waitFor();
        System.out.println("Proceso padre finalizado.");
    }
}