package p3mantenimiento;
//TERMINADA
/*
La práctica consiste en realizar un proyecto en java que realice las operaciones básicas para
realizar el mantenimiento de los datos de un fichero en formato binario y de acceso directo.
El fichero lo deberá definir el alumno y deberá contener como mínimo cuatro campos y entre
todos los campos tener un tamaño de registro de más de 50 bytes. Ejemplos de ficheros:
empleados, alumnos, películas, vehículos, clientes, vuelos, hospitales, etc. (poner la
descripción del fichero en los comentarios de la clase principal), no se puede utilizar el fichero
de empleados puesto que es con él que se han realizado los ejemplos en clase.
El proyecto deberá visualizar un menú con las siguientes opciones (suponiendo que fuera un
fichero de empleados):
1.- Anadir 15 empleados al final del fichero a partir de arays de datos.
2.- Añadir al final del fichero.
3.- Visualizar todos los datos del fichero de empleados.
4.- Visualizar los datos de un empleado.
5.- Visualizar todos los empleados de un departamento.
6.- Modificar un dato de un empleado (nombre o departamento o salario, etc).
7.- Eliminar un empleado.
8.- Salir
Se sustituirá el empleado por el alumno, película, vehículo, cliente vuelo o lo que el alumno
haya definido. Al igual con el departamento que se deberá sustituir por otra característica del
fichero, como puede ser el ciclo para un alumno, el concesionario para un vehículo, la ciudad
donde están los hospitales, el aeropuerto origen de un vuelo, etc.
Cada opción realizara lo siguiente:
1.- Añadir 15 elementos al fichero. Se añadirán 15 empleados al fichero utilizando arrays de
datos generados por la IA.
2.- Añadir elemento. Deberá añadir un registro al final del fichero. El código que identificará al
registro insertado será el último código del registro del fichero + 1 (si hay 34 empleados, el
siguiente será el 35).
3.- Visualizar todos los datos del fichero. Se visualizarán por pantalla todos los datos del fichero
que no estén borrados (borrado lógico).
4.- Visualizar los datos de un elemento por código. Para visualizar los datos de un empleado se
pedirá un código y se mostraran los datos o el mensaje de error correspondiente.
5.- Visualizar los elementos que tengan una característica. Para visualizar los datos de los
empleados de un departamento se pedirá un departamento por pantalla y se visualizarán
todos los datos de los empleados de ese departamento.
6.- Modificar un dato de un elemento. Para modificar el dato de un empleado, se pedirá un
código y se mostraran los datos o el mensaje de error correspondiente. Cuando exista el
empleado se pedirá el nuevo dato y se modificará en el fichero.
7.- Eliminar un elemento del fichero. Para eliminar un empleado, se pedirá un código y se
mostraran los datos o el mensaje de error correspondiente. Cuando exista el empleado se
pedirá si se quiere eliminar, se eliminará en caso de mensaje afirmativo.
*/

/*
 * DESCRIPCIÓN DEL FICHERO TRENES.DAT
 *
 * Cada registro ocupa 123 bytes y almacena los atributos
 * de la clase Tren:
 *
 * - id: int (4 bytes).
 * - modelo: 30 caracteres (60 bytes).
 * - fabricante: int (4 bytes).
 * - numeroVagones: short (2 bytes).
 * - capacidadPasajeros: int (4 bytes).
 * - velocidadMaxima: double (8 bytes).
 * - tipoCombustible: 20 caracteres (40 bytes).
 * - borrado: boolean (1 byte).
 *
 * Total: 123 bytes por registro.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class P3Mantenimiento {
    private static final int TAM_REGISTRO = 123;

    private static final Tren[] trenes = {
            new Tren(1, "AVE S103", 1, (short) 8, 404, 350.0, "Electrico", false),
            new Tren(2, "Alvia S120", 2, (short) 4, 238, 250.0, "Electrico", false),
            new Tren(3, "Avant S104", 3, (short) 4, 237, 250.0, "Electrico", false),
            new Tren(4, "Talgo Avril", 1, (short) 12, 581, 330.0, "Electrico", false),
            new Tren(5, "Civia 463", 4, (short) 3, 169, 120.0, "Electrico", false),
            new Tren(6, "Civia 465", 4, (short) 5, 280, 120.0, "Electrico", false),
            new Tren(7, "Alvia S130", 2, (short) 11, 299, 250.0, "Electrico", false),
            new Tren(8, "Euromed S130", 2, (short) 11, 299, 250.0, "Electrico", false),
            new Tren(9, "S449 Regional", 5, (short) 3, 185, 160.0, "Electrico", false),
            new Tren(10, "S599 Diesel", 6, (short) 3, 186, 160.0, "Diesel", false),
            new Tren(11, "S730 Hybrid", 1, (short) 11, 265, 240.0, "Hibrido", false),
            new Tren(12, "S112 AVE", 1, (short) 8, 365, 330.0, "Electrico", false),
            new Tren(13, "TRD 594", 6, (short) 2, 124, 160.0, "Diesel", false),
            new Tren(14, "Alstom Coradia", 7, (short) 4, 220, 160.0, "Electrico", false),
            new Tren(15, "Stadler Flirt", 8, (short) 4, 250, 160.0, "Electrico", false)
    };

    public static void main(String[] args) {
        try {
            RandomAccessFile fichero = new RandomAccessFile("trenes.dat", "rw");
            menu(fichero);
            fichero.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida");
        }
    }


    public static void menu(RandomAccessFile fichero) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU MANTENIMIENTO DE TRENES =====");
            System.out.println("1. Añadir 15 trenes al fichero");
            System.out.println("2. Añadir un tren");
            System.out.println("3. Visualizar todos los trenes");
            System.out.println("4. Visualizar un tren por ID");
            System.out.println("5. Visualizar trenes por capacidad");
            System.out.println("6. Modificar un tren");
            System.out.println("7. Eliminar un tren");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    anadir15Trenes(fichero);
                    break;

                case 2:
                        try {
                            int ultimoId = buscarUltimoId(fichero);
                            Tren nuevoTren = pedirDatosTren(sc, ultimoId + 1);
                            fichero.seek(fichero.length());
                            escribirTren(fichero, nuevoTren);
                        } catch (IOException e) {
                            System.out.println("Error al añadir el tren: " + e.getMessage());
                        }

                    break;
                case 3:
                    visualizarTrenes(fichero, false);
                    break;

                case 4:
                    System.out.print("Introduce el ID del tren: ");
                    int idBuscado = sc.nextInt();

                    TrenEncontrado resultado = buscarTrenPorId(fichero, idBuscado);

                    if (resultado != null) {
                        System.out.println("Datos del tren:");
                        System.out.println(resultado.getTren());
                    } else {
                        System.out.println("No existe ningun tren con ese ID.");
                    }

                    break;

                case 5:
                    System.out.print("Introduce la capacidad minima de pasajeros: ");
                    int capacidadMinima = sc.nextInt();

                    ArrayList<Tren> listaTrenes = buscarTrenesPorCapacidad(fichero, capacidadMinima);
                    
                    if (!listaTrenes.isEmpty()) {
                        System.out.println("\nTrenes con capacidad superior a " + capacidadMinima + ":");
                        for (Tren t : listaTrenes) {
                            System.out.println(t);
                        }
                    } else {
                        System.out.println("No hay trenes con esa capacidad.");
                    }

                    break;
                
            case 6:
                try {
                    System.out.print("Introduce el ID del tren que quieres modificar: ");
                    int idModificar = sc.nextInt();

                    modificarTren(fichero, idModificar, sc);

                } catch (IOException e) {
                    System.out.println("Error al modificar el tren: " + e.getMessage());
                }
                break;


            case 7:
                System.out.println("Introduce el ID del tren que quieres eliminar: ");
                int idEliminar = sc.nextInt();

                TrenEncontrado resultadobuscar = buscarTrenPorId(fichero, idEliminar);

                if (resultadobuscar != null) {
                    System.out.println("Datos del tren:");
                    System.out.println(resultadobuscar.getTren());

                    System.out.println("¿Estas seguro de que quieres eliminarlo?");
                    System.out.println("1. Si");
                    System.out.println("2. No");

                    int confirmar = sc.nextInt();

                    if (confirmar == 1) {
                        eliminarTren(fichero, idEliminar, true);
                    } else {
                        eliminarTren(fichero, idEliminar, false);
                    }

                } else {
                    System.out.println("No existe ningun tren con ese ID.");
                }

                break;

                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 8);
        sc.close();
    }


    public static Tren pedirDatosTren(Scanner sc, int id) {

        System.out.println("\n--- INTRODUCIR DATOS DEL TREN ---");
        sc.nextLine();
        System.out.print("Introduce el modelo: ");
        String modelo = sc.nextLine();

        int fabricante = 0;
        boolean correcto = false;

        while (!correcto) {
            try {
                System.out.print("Introduce el fabricante (numero): ");
                fabricante = sc.nextInt();
                correcto = true;

            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un numero entero.");
                sc.nextLine();
            }
        }
        sc.nextLine();

        short numeroVagones = 0;
        correcto = false;

        while (!correcto) {
            try {
                System.out.print("Introduce el numero de vagones: ");
                numeroVagones = sc.nextShort();
                correcto = true;

            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un numero valido.");
                sc.nextLine();
            }
        }
        sc.nextLine();

        int capacidadPasajeros = 0;
        correcto = false;

        while (!correcto) {
            try {
                System.out.print("Introduce la capacidad de pasajeros: ");
                capacidadPasajeros = sc.nextInt();
                correcto = true;

            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un numero entero.");
                sc.nextLine();
            }
        }
        sc.nextLine();

        double velocidadMaxima = 0;
        correcto = false;

        while (!correcto) {
            try {
                System.out.print("Introduce la velocidad maxima: ");
                velocidadMaxima = sc.nextDouble();
                correcto = true;

            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un numero decimal.");
                sc.nextLine();
            }
        }
        sc.nextLine();

        System.out.print("Introduce el tipo de combustible: ");
        String tipoCombustible = sc.nextLine();

        return new Tren(id, modelo, fabricante,
                numeroVagones, capacidadPasajeros,
                velocidadMaxima, tipoCombustible, false);
    }


    public static int buscarUltimoId(RandomAccessFile fichero) {

        int ultimoId = 0;

        try {
            fichero.seek(0);

            while (fichero.getFilePointer() < fichero.length()) {

                Tren t = leerTren(fichero);

                if (t.getId() > ultimoId) {
                    ultimoId = t.getId();
                }
            }

        } catch (IOException e) {
            System.out.println("Error al buscar el ultimo ID: " + e.getMessage());
        }

        return ultimoId;
    }


    public static void escribirTren(RandomAccessFile fichero, Tren t) throws IOException {
        fichero.writeInt(t.getId());
        fichero.writeChars(String.format("%-30.30s", t.getModelo()));
        fichero.writeInt(t.getFabricante());
        fichero.writeShort(t.getNumeroVagones());
        fichero.writeInt(t.getCapacidadPasajeros());
        fichero.writeDouble(t.getVelocidadMaxima());
        fichero.writeChars(String.format("%-20.20s", t.getTipoCombustible()));
        fichero.writeBoolean(t.isBorrado());
    }

    public static void anadir15Trenes(RandomAccessFile fichero) {
        try {
            int ultimoId = buscarUltimoId(fichero);
            fichero.seek(fichero.length());
            for (Tren t : trenes) {
                t.setId(ultimoId + 1);
                escribirTren(fichero, t);
                ultimoId++;
            }
            System.out.println("15 trenes añadidos correctamente.");
        } catch (IOException e) {
            System.out.println("Error al añadir los trenes: " + e.getMessage());
        }
    }


    public static Tren leerTren(RandomAccessFile fichero) throws IOException {

        long bytesRestantes = fichero.length() - fichero.getFilePointer();

        if (bytesRestantes == 0) {
            return null;
        }

        if (bytesRestantes < TAM_REGISTRO) {
            throw new IOException("El fichero contiene un registro incompleto.");
        }

        int id = fichero.readInt();

        String modelo = "";

        for (int i = 0; i < 30; i++) {
            modelo += fichero.readChar();
        }

        int fabricante = fichero.readInt();
        short numeroVagones = fichero.readShort();
        int capacidadPasajeros = fichero.readInt();
        double velocidadMaxima = fichero.readDouble();

        String tipoCombustible = "";

        for (int i = 0; i < 20; i++) {
            tipoCombustible += fichero.readChar();
        }

        boolean borrado = fichero.readBoolean();

        return new Tren(id, modelo.trim(), fabricante, numeroVagones,
                capacidadPasajeros, velocidadMaxima,
                tipoCombustible.trim(), borrado);
    }

    public static void visualizarTrenes(RandomAccessFile fichero, boolean mostrarBorrados) {

        try {
            fichero.seek(0);

            while (fichero.getFilePointer() < fichero.length()) {

                Tren t = leerTren(fichero);

                if (t != null && (mostrarBorrados || !t.isBorrado())) {
                    System.out.println(t);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al visualizar los trenes: " + e.getMessage());
        }
    }

    public static TrenEncontrado buscarTrenPorId(RandomAccessFile fichero, int idBuscado) {
        try {
            fichero.seek(0);

            while (fichero.getFilePointer() < fichero.length()) {

                long posicion = fichero.getFilePointer();

                Tren t = leerTren(fichero);

                if (t == null) {
                    break;
                }

                if (t.getId() == idBuscado && !t.isBorrado()) {
                    return new TrenEncontrado(t, posicion);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al buscar el tren: " + e.getMessage());
        }

        return null;
    }

    public static ArrayList<Tren> buscarTrenesPorCapacidad(RandomAccessFile fichero, int capacidadMinima) {

        ArrayList<Tren> listaTrenes = new ArrayList<>();

        try {
            fichero.seek(0);

            while (fichero.getFilePointer() < fichero.length()) {

                Tren t = leerTren(fichero);

                if (t != null
                        && t.getCapacidadPasajeros() > capacidadMinima
                        && !t.isBorrado()) {

                    listaTrenes.add(t);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al buscar los trenes: " + e.getMessage());
        }

        return listaTrenes;
    }


    public static void modificarTren(RandomAccessFile fichero, int idModificar, Scanner sc) throws IOException {

        // Buscamos el tren por su ID
        TrenEncontrado resultado = buscarTrenPorId(fichero, idModificar);

        if (resultado != null) {

            // Mostramos los datos del tren encontrado
            Tren t = resultado.getTren();

            System.out.println("\nDatos del tren:");
            System.out.println(t);

            // Pedimos el nuevo dato
            System.out.print("Introduce la nueva capacidad de pasajeros: ");
            int nuevaCapacidad = sc.nextInt();

            // Modificamos el atributo
            t.setCapacidadPasajeros(nuevaCapacidad);

            // Volvemos a escribir el registro en su posición
            fichero.seek(resultado.getPosicion());
            escribirTren(fichero, t);

            System.out.println("Tren modificado correctamente.");

        } else {
            System.out.println("No existe ningún tren con ese ID.");
        }
    }


    public static void eliminarTren(RandomAccessFile fichero, int idBuscado, boolean confirmar) {

        try {
            TrenEncontrado resultado = buscarTrenPorId(fichero, idBuscado);

            if (resultado != null) {

                Tren t = resultado.getTren();

                System.out.println("Datos del tren que quieres eliminar:");
                System.out.println(t);

                if (confirmar) {

                    t.setBorrado(true);

                    fichero.seek(resultado.getPosicion());
                    escribirTren(fichero, t);

                    System.out.println("Tren eliminado correctamente.");

                } else {
                    System.out.println("Se ha cancelado la eliminación.");
                }

            } else {
                System.out.println("No existe ningún tren con ese ID.");
            }

        } catch (IOException e) {
            System.out.println("Error al eliminar el tren: " + e.getMessage());
        }
    }
}
