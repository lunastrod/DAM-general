import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejecuta {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error: debes indicar un comando.");
            return;
        }

        try {
            ProcessBuilder pb = new ProcessBuilder(args);
            Process proceso = pb.start();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();

            int codigo = proceso.waitFor();

            if (codigo != 0) {
                System.err.println(
                    "El proceso terminó con errores. Código: " + codigo
                );
            }

        } catch (Exception e) {
            System.err.println(
                "Error al ejecutar el comando: " + e.getMessage()
            );
        }
    }
}
