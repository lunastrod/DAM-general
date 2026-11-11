package tren;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteTren {

    public static void main(String[] args) {

        Tren[] trenes = new Tren[5];

        trenes[0] = new Tren("AVE S-103", 1, (short) 8, 404, 310.0, 250.0, "Electrico", true);
        trenes[1] = new Tren("Alvia S-730", 2, (short) 11, 299, 250.0, 200.0, "Hibrido", true);
        trenes[2] = new Tren("Civia", 3, (short) 5, 500, 160.0, 0.0, "Electrico", false);
        trenes[3] = new Tren("S-120", 4, (short) 4, 238, 250.0, 180.0, "Electrico", true);
        trenes[4] = new Tren("Talgo 250", 2, (short) 12, 320, 250.0, 0.0, "Diesel", false);

        try (DataOutputStream salida = new DataOutputStream(
                new FileOutputStream("trenes.dat"))) {

            for (Tren tren : trenes) {

                salida.writeUTF(tren.getModelo());
                salida.writeInt(tren.getFabricante());
                salida.writeShort(tren.getNumeroVagones());
                salida.writeInt(tren.getCapacidadPasajeros());
                salida.writeDouble(tren.getVelocidadMaxima());
                salida.writeDouble(tren.getVelocidadActual());
                salida.writeUTF(tren.getTipoCombustible());
                salida.writeBoolean(tren.isEnMarcha());
            }


            System.out.println("Los 5 trenes se han guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar los trenes: " + e.getMessage());
        }
    }
}