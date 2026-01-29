package com.dam.jan8;

import java.util.ArrayList;
import java.util.Scanner;

import com.dam.lib.Validacion;

public class ListaCompra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean terminado=false;
        ArrayList<Producto> listaCompra = new ArrayList<Producto>();
        while(!terminado){
            int opcion=solicitarOpcion(sc);
            switch (opcion) {
                case 1:
                    agregarProducto(listaCompra, sc);
                break;
                case 2:
                    
                break;
                case 3:
                    mostrarLista(listaCompra);
                break;
                case 4:
                    terminado=true;
                break;
            }
        }
    }

    private static void mostrarLista(ArrayList<Producto> l){
        for (Producto producto : l) {
            System.out.println(l);
        }
    }

    private static void agregarProducto(ArrayList<Producto> l, Scanner sc){
        Producto p;
        String n=Validacion.validaStrLen(sc, "Introduce nombre de producto", 1, 100);
        int c=Validacion.validaInt(sc, "Introduce cantidad de producto", 1, Integer.MAX_VALUE);
        p=new Producto(n, c);
        l.add(p);
        System.out.println("Producto agregado a la lista");
    }




    private static int solicitarOpcion(Scanner sc){
        int opcion=0;
        while(opcion==0){
            try{
                System.out.println("1 - Añadir producto a la lista de la compra");
                System.out.println("2 - Eliminar producto de la lista de la compra");
                System.out.println("3 - Mostrar la lista de la compra");
                System.out.println("4 - Para terminar");
                opcion=Integer.parseInt(sc.nextLine());
                if(opcion<1&&opcion>4){
                    throw new Exception("El valor debe estar entre 1 y 4");
                }
                
            }catch(NumberFormatException e){
                System.err.println("Error, introduzca un valor entero");
            }
            catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        return opcion;
    }
}
