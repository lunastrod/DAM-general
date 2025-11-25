package dam.ej2.main;

import java.util.Scanner;

import dam.ej2.pojo.Aplicacion;

/*
Prepare un array para almacenar las 6 primeras aplicaciones del ranking.

Para cada aplicación se solicitarán por teclado los datos necesarios con los que crear los objetos y rellenar el array.

Y cuando se haya acabado de introducir los datos de las aplicaciones, muestre dichos datos para poder comprobar el resultado. Para cada aplicación es de tipo red social o de mensajería.

El programa deberá informar de cuántas aplicaciones llevan en uso menos de 18 años, cuántas son de mensajería y cuántas son red social

Mostrar la aplicación que lleva menos años de uso de entre las 3 primeras y cuántos caracteres suman entre los nombres de las 3 primeras. (No suponer que están ordenados en el array)
*/

public class GestionRanking {
    static final int N_APPS=6;
    static final int ANALIZA_N_APPS=3;
    static final int ANIO_ACTUAL=2025;
    public static void main(String[] args) {
        Aplicacion apps[]=initApps(N_APPS);
        solicitaDatos(apps);
        //rellenaDatosPrueba(apps);
        imprimeApps(apps);

        ordenaRanking(apps);
        System.out.println("\n\narray ordenado:");
        imprimeApps(apps);

        analizaApps(apps);
        analizaNPrimerasApps(apps,ANALIZA_N_APPS);

    }
    private static Aplicacion[] initApps(int numeroApps){
        return new Aplicacion[numeroApps];
    }

    private static void rellenaDatosPrueba(Aplicacion[] aplicaciones){
        aplicaciones[2]=new Aplicacion("TikTok", "Es una red social para compartir videos cortos y en formato vertical que pueden tener una duración desde 1 segundo hasta 10 minutos.", "ByteDance", "Septiembre de 2016", 1);
        aplicaciones[4]=new Aplicacion("Instagram", "Es una aplicación y red social, que permite mensajería instantánea, y una función para publicar fotografías y vídeos temporales, agregando variados filtros y efectos, con una duración máxima de permanencia de 24 horas.", "Meta Platforms", "6 de octubre de 2010", 2);
        aplicaciones[3]=new Aplicacion("Facebook", "Es una red social.", "Meta Platforms", "4 de febrero de 2004", 3);
        aplicaciones[5]=new Aplicacion("WhatsApp", "Es una aplicación de mensajería instantánea. Permite enviar y recibir mensajes, además de imágenes, videos, audios, grabaciones de audio (notas de voz), documentos, ubicaciones, contactos, gifs, stickers, así como llamadas y videollamadas con varios participantes a la vez", "Meta Platforms", "22 de enero de 2009", 4);
        aplicaciones[1]=new Aplicacion("Telegram", "Es una plataforma de mensajería instantánea, el envío de varios archivos y la comunicación en masa.", "Telegram FZ-LLC", "14 de agosto de 2013", 5);
        aplicaciones[0]=new Aplicacion("Snapchat", "Es una aplicación de mensajería con soporte multimedia de imagen, vídeo y filtros para fotos de realidad aumentada. Las imágenes y mensajes pueden ser accesibles solo durante un tiempo determinado, como 24 horas, elegido por los usuarios.", "Snap Inc.", "1 de septiembre de 2011", 6);
    }

    private static void solicitaDatos(Aplicacion[] apps){
        Scanner sc=new Scanner(System.in);
        String n;
        String d;
        String e;
        String f;
        int r;
        for(int i=0; i<apps.length;i++){
            System.out.println();
            System.out.println("Introduce el nombre de la "+(i+1)+"ª aplicación");
            n=sc.nextLine();
            System.out.println("Introduce la descripción");
            d=sc.nextLine();
            System.out.println("Introduce la empresa a la que pertenece");
            e=sc.nextLine();
            System.out.println("Introduce fecha de lanzamiento");
            f=sc.nextLine();
            System.out.println("Introduce la posición en el ranking");
            r=Integer.parseInt(sc.nextLine());
            apps[i]=new Aplicacion(n, d, e, f, r);
        }
        sc.close();
    }

    private static void analizaApps(Aplicacion[] apps){
        //informa cuántas aplicaciones llevan en uso menos de 18 años, cuántas son de mensajería y cuántas son red social
        int menos18=0;
        int mensaje=0;
        int redSocial=0;
        for(int i=0; i<apps.length;i++){
            if(apps[i].aniosEnUso(ANIO_ACTUAL)<18){
                menos18++;
            }
            if(apps[i].descripcionContiene("mensajería")){
                mensaje++;
            }
            if(apps[i].descripcionContiene("red social")){
                redSocial++;
            }
        }
        System.out.println("\nANÁLISIS DE APLICACIONES:\nDe "+apps.length+" aplicaciones, "
            +menos18+" llevan en uso menos de 18 años, "
            +mensaje+" son de mensajería y "
            +redSocial+" son red social."
        );
    }

    private static void ordenaRanking(Aplicacion[] apps){
        //bubblesort :D
        //Tenía pensado hacer una función que me devuelva un array de 3 posiciones ordenado pero ordenar el array es más divertido
        Aplicacion temp;//para hacer swap
        for(int veces=0; veces<apps.length; veces++){
            for(int i=0; i<apps.length-1; i++){
                //si encuentro una pareja desordenada, swap
                if(apps[i].getRanking()>apps[i+1].getRanking()){
                    temp=apps[i];
                    apps[i]=apps[i+1];
                    apps[i+1]=temp;
                }
            }
        }
    }

    private static void analizaNPrimerasApps(Aplicacion[] apps, int n){
        //Muestra la aplicación que lleva menos años de uso de entre las 3 primeras y cuántos caracteres suman entre los nombres de las 3 primeras.
        // Necesita que el array esté ordenado
        // voy a asumir que apps tiene valores, no está vacía.
        Aplicacion menosUso=apps[0];
        int nCaracteresNombres=0;
        for(int i=0; i<n; i++){
            if(apps[i].aniosEnUso(ANIO_ACTUAL)<menosUso.aniosEnUso(ANIO_ACTUAL)){
                menosUso=apps[i];
            }
            nCaracteresNombres+=apps[i].getNombre().length();
        }
        System.out.println("\nLa aplicación que lleva menos años de uso de entre las "+n+" primeras es: \n"+menosUso+
                        "\n\nY entre los nombres de las 3 primeras suman: "+nCaracteresNombres+" caracteres\n"
        );

    }

    private static void imprimeApps(Aplicacion[] aplicaciones){
        System.out.println();
        for(int i=0; i<aplicaciones.length; i++){
            System.out.println(aplicaciones[i]);
        }
    }
}
