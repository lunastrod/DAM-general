package com.dam.jan8;

import java.util.HashSet;
import java.util.Scanner;

public class ListaCompraHS {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        HashSet<Producto> lista = new HashSet<>();
        int opcion;

        do {
            opcion = solicitarOpcion();
            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = Integer.parseInt(sc.nextLine());
                    agregarProducto(lista, new Producto(nombre, cantidad));
                    break;
                case 2:
                    eliminarProducto(lista);
                    break;
                case 3:
                    mostrarLista(lista);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    public static int solicitarOpcion() {
        System.out.println("\n1 - Añadir producto");
        System.out.println("2 - Eliminar producto");
        System.out.println("3 - Mostrar lista");
        System.out.println("4 - Salir");
        System.out.print("Seleccione opción: ");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void agregarProducto(HashSet<Producto> lista, Producto p) {
        if (!lista.add(p)) {
            System.err.println("Error: El producto ya existe en la lista.");
        } else {
            System.out.println("Producto añadido correctamente.");
        }
    }

    public static void eliminarProducto(HashSet<Producto> lista) {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = sc.nextLine();
        System.out.print("Cantidad exacta: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        if (lista.remove(new Producto(nombre, cantidad))) {
            System.out.println("Producto eliminado");
        } else {
            System.out.println("No se encontró el producto");
        }
    }

    public static void mostrarLista(HashSet<Producto> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            for (Producto p : lista) {
                System.out.print(p);
            }
            System.out.println();
        }
    }
}