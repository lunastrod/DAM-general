package ficherosAccesoDirecto;

import java.io.IOException;
import java.io.RandomAccessFile;

//tren:
//id (int):  4 bytes 
//modelo (String): 100 bytes (50 caracteres 2 bytes)
//numeroVagones (short): 2 bytes
//capacidadPasajeros (int): 4 bytes
//velocidadMaxima (double): 8 bytes
//velocidadActual (double): 8 bytes
//fabricante (int): 4 bytes (enlace a otro fichero)
//enMantenimiento (boolean): 1 byte
//total: 131 bytes



































































































































































































































































































































































public class Main {
    public static class Tren {
        static final int LONG_MODELO = 50;     // caracteres
        static final int TAM_REGISTRO = 131;   // bytes
        static final int ID_BORRADO = -1;      // marca de registro borrado

        public int id;
        public String modelo;            // 50 caracteres * 2 bytes = 100 bytes
        public short numeroVagones;
        public int capacidadPasajeros;
        public double velocidadMaxima;
        public double velocidadActual;
        public int fabricante;           // enlace a otro fichero
        public boolean enMantenimiento;
    }

    public static void escribirTren(RandomAccessFile raf, Tren t) throws IOException {
        raf.seek((long) (t.id - 1) * Tren.TAM_REGISTRO);

        raf.writeInt(t.id);                                   // 4

        // Modelo: se rellena con espacios / se trunca a 50 caracteres
        String modelo = String.format("%-" + Tren.LONG_MODELO + "s", t.modelo)
                              .substring(0, Tren.LONG_MODELO);
        raf.writeChars(modelo);                               // 100
        raf.writeShort(t.numeroVagones);                      // 2
        raf.writeInt(t.capacidadPasajeros);                   // 4
        raf.writeDouble(t.velocidadMaxima);                   // 8
        raf.writeDouble(t.velocidadActual);                   // 8
        raf.writeInt(t.fabricante);                           // 4
        raf.writeBoolean(t.enMantenimiento);                  // 1
    }

    /** Devuelve el tren con ese id, o null si no existe o esta borrado. */
    public static Tren leerTren(RandomAccessFile raf, int id) throws IOException {
        long pos = (long) (id - 1) * Tren.TAM_REGISTRO;
        if (pos < 0 || pos + Tren.TAM_REGISTRO > raf.length()) {
            return null;   // el registro no existe
        }
        raf.seek(pos);

        Tren t = new Tren();
        t.id = raf.readInt();                                  // 4
        if (t.id <= 0) {
            return null;   // borrado (-1) o hueco sin escribir (0)
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Tren.LONG_MODELO; i++) {
            sb.append(raf.readChar());                         // 100
        }
        t.modelo = sb.toString().trim();

        t.numeroVagones = raf.readShort();                     // 2
        t.capacidadPasajeros = raf.readInt();                  // 4
        t.velocidadMaxima = raf.readDouble();                  // 8
        t.velocidadActual = raf.readDouble();                  // 8
        t.fabricante = raf.readInt();                          // 4
        t.enMantenimiento = raf.readBoolean();                 // 1
        return t;
    }

    public static void imprimirTren(Tren t) {
        System.out.println("Tren " + t.id + ": " + t.modelo
                + " | vagones=" + t.numeroVagones
                + " | pasajeros=" + t.capacidadPasajeros
                + " | vmax=" + t.velocidadMaxima
                + " | vactual=" + t.velocidadActual
                + " | fabricante=" + t.fabricante
                + " | mantenimiento=" + t.enMantenimiento);
    }

    /** Añade un tren. Devuelve false si el id es invalido o ya existe. */
    public static boolean anadirTren(RandomAccessFile raf, Tren t) throws IOException {
        if (t.id < 1 || leerTren(raf, t.id) != null) {
            return false;
        }
        escribirTren(raf, t);
        return true;
    }

    /** Borrado logico: pone el id a -1. Devuelve false si no existe. */
    public static boolean eliminarTren(RandomAccessFile raf, int id) throws IOException {
        if (id < 1 || leerTren(raf, id) == null) {
            return false;
        }
        raf.seek((long) (id - 1) * Tren.TAM_REGISTRO);
        raf.writeInt(Tren.ID_BORRADO);
        return true;
    }

    /** Sobrescribe el tren con ese id. Devuelve false si no existe. */
    public static boolean modificarTren(RandomAccessFile raf, Tren t) throws IOException {
        if (t.id < 1 || leerTren(raf, t.id) == null) {
            return false;
        }
        escribirTren(raf, t);
        return true;
    }

    public static void leerTodos(RandomAccessFile raf) throws IOException {
        long numRegistros = raf.length() / Tren.TAM_REGISTRO;
        for (int id = 1; id <= numRegistros; id++) {
            Tren t = leerTren(raf, id);
            if (t != null) {
                imprimirTren(t);
            }
        }
    }

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("trenes.dat", "rw")) {
            leerTodos(raf);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void writeTodos(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("trenes.dat", "rw")) {

            for (int i = 1; i <= 10; i++) {
                Tren t = new Tren();
                t.id = i;
                t.modelo = "Modelo-" + i;
                t.numeroVagones = (short) (4 + i);
                t.capacidadPasajeros = 100 * (4 + i);
                t.velocidadMaxima = 250.0 + i * 5;
                t.velocidadActual = 0.0;
                t.fabricante = (i % 3) + 1;
                t.enMantenimiento = (i % 4 == 0);

                escribirTren(raf, t);
            }

            System.out.println("Trenes escritos en trenes.dat");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        
    }
}