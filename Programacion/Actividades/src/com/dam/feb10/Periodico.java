package com.dam.feb10;

import java.util.ArrayList;
import java.util.Scanner;

import com.dam.lib.Validacion;

public class Periodico {
    public static void main(String[] args) {
        ArrayList<Noticia> noticias=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int opcion;
        String titulo;
        String fecha;
        Noticia n;
        do{
            System.out.println("Menu de noticias");
            System.out.println("1. Crear noticia");
            System.out.println("2. Cambiar estado noticia");
            System.out.println("3. Mostrar iniciales partido");
            System.out.println("4. Mostrar noticias");
            System.out.println("5. Salir");
            opcion=Validacion.validaInt(sc, "opcion", 1, 5);
            switch (opcion) {
                case 1:
                    String tipo=Validacion.validaStrOpciones(sc, "tipo de noticia", Noticia.TIPOS);
                    titulo=Validacion.validaStrLen(sc, "titulo", 1, Integer.MAX_VALUE);
                    fecha=Validacion.validaStrLen(sc, "fecha", 10, 10);
                    if(tipo.equals(Noticia.TIPOS[0])){
                        String partido=Validacion.validaStrOpciones(sc, "partido", NoticiaPolitica.PARTIDOS);
                        noticias.add(new NoticiaPolitica(titulo, fecha, partido));
                    }
                    else if(tipo.equals(Noticia.TIPOS[1])){
                        System.out.println("Introduce sector");
                        String sector=sc.nextLine();
                        noticias.add(new NoticiaEconomia(titulo, fecha, sector));
                    }
                    else if(tipo.equals(Noticia.TIPOS[2])){
                        System.out.println("Introduce deporte");
                        String deporte=sc.nextLine();
                        noticias.add(new NoticiaDeportes(titulo, fecha, deporte));
                    }
                    break;
                case 2:
                    titulo=Validacion.validaStrLen(sc, "titulo", 1, Integer.MAX_VALUE);
                    fecha=Validacion.validaStrLen(sc, "fecha", 10, 10);    
                    n=buscaNoticia(noticias, titulo, fecha);
                    if(n!=null){
                        if(n.cambiarEstado()){
                            System.out.println("Estado cambiado a "+n.estado);
                        }else{
                            System.out.println("No se puede cambiar el estado");
                        }
                    }
                    break;
                case 3:
                    titulo=Validacion.validaStrLen(sc, "titulo", 1, Integer.MAX_VALUE);
                    fecha=Validacion.validaStrLen(sc, "fecha", 10, 10);
                    n=buscaNoticia(noticias, titulo, fecha);
                    if(n!=null){
                        if(n instanceof NoticiaPolitica){
                            System.out.println("Partido: "+((NoticiaPolitica)n).obtenerInicialesPartido());
                        }else{
                            System.out.println("No es una noticia politica");
                        }
                    }
                    break;
                case 4:
                    if(noticias.size()==0){
                        System.out.println("No hay noticias");
                    }else{
                        System.out.println("Noticias:");
                        for(int i=0; i<noticias.size(); i++){
                            System.out.println("  "+(i+1)+". "+noticias.get(i));
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }
        }
        while(opcion!=5);
        sc.close();
    }

    public static Noticia buscaNoticia(ArrayList<Noticia> noticias, String titulo, String fecha){
        try{
            return noticias.get(noticias.indexOf(new Noticia(titulo, fecha)));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Error: No se ha encontrado la noticia");
        }
        return null;//si no se encuentra la noticia devuelve null
    }



}
