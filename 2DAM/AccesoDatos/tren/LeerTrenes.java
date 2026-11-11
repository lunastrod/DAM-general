package tren;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerTrenes {

    public static void main(String[] args) {

        try (DataInputStream entrada = new DataInputStream(
                new FileInputStream("trenes.dat"))) {

            for (int i = 0; i < 5; i++) {

                String modelo = entrada.readUTF();
                int fabricante = entrada.readInt();
                short numeroVagones = entrada.readShort();
                int capacidadPasajeros = entrada.readInt();
                double velocidadMaxima = entrada.readDouble();
                double velocidadActual = entrada.readDouble();
                String tipoCombustible = entrada.readUTF();
                boolean enMarcha = entrada.readBoolean();

                Tren tren = new Tren(
                        modelo,
                        fabricante,
                        numeroVagones,
                        capacidadPasajeros,
                        velocidadMaxima,
                        velocidadActual,
                        tipoCombustible,
                        enMarcha
                );

                System.out.println(tren);
            }

        } catch (IOException e) {
            System.out.println("Error al leer los trenes: " + e.getMessage());
        }
    }
}