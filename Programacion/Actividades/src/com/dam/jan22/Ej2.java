package com.dam.jan22;

import java.util.ArrayList;
import java.util.Scanner;

import com.dam.lib.Validacion;

/*Necesitamos realizar un programa para almacenar una playlist de canciones. De cada
canción se deberá conocer el título, el grupo o solista y la duración en segundos.
El programa debe mostrar un menú que permita:
- Añadir una canción a la playlist
- Eliminar una canción por nombre y grupo/solista
- Mostrar las canciones de la lista
- Reproducir una canción por posición
- Reproducir toda la lista
- Indicar tiempo total de la playlist
- Salir de la playlist
Controlar los datos introducidos con excepciones:
- La opción introducida para indicar la acción a llevar a cabo debe encontrarse
entre las opciones indicadas.
- La duración debe ser un valor entero comprendido entre 10 y 600.
- La posición para reproducir una canción deber ser un número entre 1 y el
tamaño de la lista.*/

public class Ej2 {
    public static void main(String[] args) {
        ArrayList<Song> playlist=new ArrayList<>();
        menu(playlist);
    }

    public static Song pideUsuarioCancion(Scanner sc){
        System.out.println("Introduce titulo de cancion");
        String title=sc.nextLine();
        System.out.println("Introduce grupo o solista de cancion");
        String author=sc.nextLine();
        int length=Validacion.validaInt(sc, "Introduce duracion en segundos",10,600);
        return new Song(title, author, length);
    }

    public static Song pideUsuarioCancionSinDuracion(Scanner sc){
        System.out.println("Introduce titulo de cancion");
        String title=sc.nextLine();
        System.out.println("Introduce grupo o solista de cancion");
        String author=sc.nextLine();
        return new Song(title, author, 50);
    }

    public static void menu(ArrayList<Song> playlist){

        boolean on=true;
        Scanner sc=new Scanner(System.in);
        
        while (on) {
            System.out.println("\n\n"+ //
                "1 Añadir una canción a la playlist\n" + //
                "2 Eliminar una canción por nombre y grupo/solista\r\n" + //
                "3 Mostrar las canciones de la lista\n" + //
                "4 Reproducir una canción por posición\n" + //
                "5 Reproducir toda la lista\n" + //
                "6 Indicar tiempo total de la playlist\n" + //
                "7 Salir de la playlist"
            );
            switch (Validacion.validaInt(sc, "opcion", 1, 7)) {
                case 1:
                    System.out.println("Añadiendo cancion:");
                    playlist.add(pideUsuarioCancion(sc));
                    break;
                case 2:
                    System.out.println("Eliminando cancion:");
                    if(playlist.remove(pideUsuarioCancionSinDuracion(sc))){
                        System.out.println("Cancion eliminada");
                    }
                    else{
                        System.out.println("La cancion no esta en la lista");
                    }
                    break;
                case 3:
                    System.out.println(playlist);
                    break;
                case 4:
                    if(playlist.size()==0){
                        System.out.println("La playlist esta vacia");
                    }
                    else{
                        int i=Validacion.validaInt(sc, "la posicion de la cancion", 1, playlist.size());
                        System.out.println("reproduciendo "+playlist.get(i-1));
                    }
                    break;
                case 5:
                    for (Song song : playlist) {
                        System.out.println("reproduciendo "+song);
                    }
                    break;
                case 6:
                    int tiempo=0;
                    for (Song song : playlist) {
                        tiempo+=song.getLength();
                    }
                    System.out.println("tiempo total: "+tiempo+"s");
                    break;
                case 7:
                    on=false;
                    break;
            }
        }
    }
}
