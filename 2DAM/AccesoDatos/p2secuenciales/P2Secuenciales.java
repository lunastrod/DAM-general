package p2secuenciales;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class P2Secuenciales {
    private static final Tren[] trenes = {
        new Tren("AVE S-102", 1, (short) 12, 316, 330.0, "Electrico", false),
        new Tren("AVE S-103", 2, (short) 8, 404, 350.0, "Electrico", false),
        new Tren("Alvia S-130", 3, (short) 11, 299, 250.0, "Electrico", false),
        new Tren("Talgo Avril", 4, (short) 12, 521, 330.0, "Electrico", false),
        new Tren("Civia 463", 3, (short) 3, 180, 120.0, "Electrico", false),
        new Tren("Euromed S-101", 1, (short) 9, 316, 220.0, "Electrico", false),
        new Tren("Alstom Coradia", 2, (short) 5, 250, 160.0, "Electrico", false),
        new Tren("CAF Civity", 3, (short) 4, 220, 160.0, "Diesel", false),
        new Tren("Talgo Intercity", 4, (short) 10, 350, 200.0, "Electrico", false),
        new Tren("Siemens Vectron", 1, (short) 6, 200, 200.0, "Electrico", false)
    };
    public static void main(String[] args) {
        escribirTrenesBinario(trenes, "trenes.dat", false);
        ArrayList<Tren> listaTrenes = leerTrenesBinario("trenes.dat");
        //System.out.println(listaTrenes);
        Tren[] trenesBinarios = listaTrenes.toArray(new Tren[listaTrenes.size()]);

        escribirTrenesTXT(trenesBinarios, "trenes.txt", false);
        ArrayList<Tren> listaTrenesTXT = leerTrenesTXT("trenes.txt");
        //System.out.println(listaTrenesTXT);
        Tren[] trenesTXT = listaTrenesTXT.toArray(new Tren[listaTrenesTXT.size()]);

        escribirTrenesObjetos(trenesTXT, "trenes.obj");
        //ArrayList<Tren> listaTrenesObjetos = leerTrenesObjetos("trenes.obj");
        //System.out.println(listaTrenesObjetos);

        System.out.println("Introduzca la capacidad de pasajeros necesaria: ");
        int capacidad = 0;
        try{
            Scanner sc = new Scanner(System.in);
            capacidad = Integer.parseInt(sc.nextLine());
            sc.close();
        } catch (NumberFormatException e) {
            System.out.println("Error al introducir la capacidad de pasajeros, mostrando todos los trenes.");
        }
        ArrayList<Tren> listaTrenesObjetosCapacidad = leerTrenesPorCapacidad("trenes.obj", capacidad);
        System.out.println("Los trenes con capacidad mayor a " + capacidad + " pasajeros son: ");
        for (Tren tren : listaTrenesObjetosCapacidad) {
            System.out.println(tren);
        }

    }

    public static void escribirTrenBinario(Tren tren, String nombreFichero, boolean anadir) {
        DataOutputStream salida = null;

        try {
            salida = new DataOutputStream(
                    new FileOutputStream(nombreFichero, anadir));

            salida.writeUTF(tren.getModelo());
            salida.writeInt(tren.getFabricante());
            salida.writeShort(tren.getNumeroVagones());
            salida.writeInt(tren.getCapacidadPasajeros());
            salida.writeDouble(tren.getVelocidadMaxima());
            salida.writeUTF(tren.getTipoCombustible());
            salida.writeBoolean(tren.isBorrado());

        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());

        } finally {
            try {
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }
    }

    public static void escribirTrenesBinario(Tren[] trenes, String nombreFichero, boolean anadir) {

        for (Tren tren : trenes) {
            escribirTrenBinario(tren, nombreFichero, anadir);
            anadir = true;
        }
    }

    public static ArrayList<Tren> leerTrenesBinario(String nombreFichero) {
        DataInputStream entrada = null;
        ArrayList<Tren> listaTrenes = new ArrayList<>();

        try {
            entrada = new DataInputStream(new FileInputStream(nombreFichero));

            while (true) {
                String modelo = entrada.readUTF();
                int fabricante = entrada.readInt();
                short numeroVagones = entrada.readShort();
                int capacidadPasajeros = entrada.readInt();
                double velocidadMaxima = entrada.readDouble();
                String tipoCombustible = entrada.readUTF();
                boolean borrado = entrada.readBoolean();

                Tren tren = new Tren(modelo, fabricante, numeroVagones,
                        capacidadPasajeros, velocidadMaxima,
                        tipoCombustible, borrado);

                listaTrenes.add(tren);
            }

        } catch (EOFException e) {
            // Fin del fichero

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());

        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }

        return listaTrenes;
    }

    public static void escribirTrenTXT(Tren tren, String nombreFichero, boolean anadir) {
        BufferedWriter salida = null;

        try {
            salida = new BufferedWriter(
                    new FileWriter(nombreFichero, anadir));

            salida.write(tren.getModelo() + ";");
            salida.write(tren.getFabricante() + ";");
            salida.write(tren.getNumeroVagones() + ";");
            salida.write(tren.getCapacidadPasajeros() + ";");
            salida.write(tren.getVelocidadMaxima() + ";");
            salida.write(tren.getTipoCombustible() + ";");
            salida.write(tren.isBorrado() + "");

            salida.newLine();

        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        } finally {
            try {
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }
    }

    public static void escribirTrenesTXT(Tren[] trenes, String nombreFichero, boolean anadir) {
        for (Tren tren : trenes) {
            escribirTrenTXT(tren, nombreFichero, anadir);
            anadir = true;
        }
    }

    public static ArrayList<Tren> leerTrenesTXT(String nombreFichero) {
        BufferedReader entrada = null;
        ArrayList<Tren> listaTrenes = new ArrayList<>();

        try {
            entrada = new BufferedReader(new FileReader(nombreFichero));

            String linea;

            while ((linea = entrada.readLine()) != null) {

                String[] campos = linea.split(";");

                String modelo = campos[0];
                int fabricante = Integer.parseInt(campos[1]);
                short numeroVagones = Short.parseShort(campos[2]);
                int capacidadPasajeros = Integer.parseInt(campos[3]);
                double velocidadMaxima = Double.parseDouble(campos[4]);
                String tipoCombustible = campos[5];
                boolean borrado = Boolean.parseBoolean(campos[6]);

                Tren tren = new Tren(modelo, fabricante, numeroVagones,
                        capacidadPasajeros, velocidadMaxima,
                        tipoCombustible, borrado);

                listaTrenes.add(tren);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: El fichero no tiene el formato correcto: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: El fichero no tiene el formato correcto: " + e.getMessage());
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }

        return listaTrenes;
    }

    public static void escribirTrenesObjetos(Tren[] trenes, String nombreFichero) {
        ObjectOutputStream salida = null;

        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreFichero));
            for (Tren tren : trenes) {
                salida.writeObject(tren);
            }

        } catch (IOException e) {
            System.out.println("Error al escribir objetos: " + e.getMessage());

        } finally {
            try {
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }
    }
    public static ArrayList<Tren> leerTrenesObjetos(String nombreFichero) {
        ObjectInputStream entrada = null;
        ArrayList<Tren> listaTrenes = new ArrayList<>();
        try {
            entrada = new ObjectInputStream(new FileInputStream(nombreFichero));

            while (true) {
                Tren tren = (Tren) entrada.readObject();
                listaTrenes.add(tren);
            }

        } catch (EOFException e) {
            // Fin del fichero
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase Tren.");

        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }

        return listaTrenes;
    }

    public static ArrayList<Tren> leerTrenesPorCapacidad(String nombreFichero, int capacidadMinima) {
        ObjectInputStream entrada = null;
        ArrayList<Tren> listaTrenes = new ArrayList<>();

        try {
            entrada = new ObjectInputStream(new FileInputStream(nombreFichero));

            while (true) {
                Tren tren = (Tren) entrada.readObject();
                if (tren.getCapacidadPasajeros() >= capacidadMinima) {
                    listaTrenes.add(tren);
                }
            }

        } catch (EOFException e) {
            // Fin del fichero

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase Tren.");

        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }

        return listaTrenes;
    }
}
