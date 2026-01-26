package com.dam.jan20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
- Clave: 1 -> Valor: Casillas
- Clave: 3 -> Valor: Pique
- Clave: 5 -> Valor: Puyol
- Clave: 6 -> Valor: Iniesta
- Clave: 7 -> Valor: Villa
- Clave: 8 -> Valor: Xavi Hernandez
- Clave: 11 -> Valor: Capdevila
- Clave: 14 -> Valor: Xabi Alonso
- Clave: 15 -> Valor: Ramos
- Clave: 16 -> Valor: Busquets
- Clave: 18 -> Valor: Pedrito
*/

public class PartidoFutbol {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        HashMap<Integer,String> campoHM = new HashMap<>();
        rellenaCampo(campoHM);
        jugadorCometeFalta(campoHM, sc);
        vaciaCampo(campoHM);

        System.out.println("=================================");

        TreeMap<Integer,String> campoTM = new TreeMap<>();
        rellenaCampo(campoTM);
        jugadorCometeFalta(campoTM, sc);
        vaciaCampo(campoTM);
    }

    public static void rellenaCampo(Map<Integer,String> campo){
        // podría hacer un array constante con estos valores pero meh
        jugadorEntraCampo(campo,1, "Casillas");
        jugadorEntraCampo(campo,3, "Pique");
        jugadorEntraCampo(campo,5, "Puyol");
        jugadorEntraCampo(campo,6, "Iniesta");
        jugadorEntraCampo(campo,7, "Villa");
        jugadorEntraCampo(campo,8, "Xavi Hernandez");
        jugadorEntraCampo(campo,11, "Capdevila");
        jugadorEntraCampo(campo,14, "Xabi Alonso");
        jugadorEntraCampo(campo,15, "Ramos");
        jugadorEntraCampo(campo,16, "Busquets");
        jugadorEntraCampo(campo,18, "Pedrito");
    }

    public static void jugadorEntraCampo(Map<Integer,String> campo,int n, String nombre){
        campo.put(n, nombre);
        System.out.println("Con el numero "+n+" ... "+nombre);
    }

    public static void jugadorSaleCampo(Map<Integer,String> campo,int n){
        System.out.println("El jugador "+campo.get(n)+" con numero "+n+" sale del campo");
        campo.remove(n);
        
    }

    public static void jugadorCometeFalta(Map<Integer,String> campo, Scanner sc){
        int n;
        do{
            System.out.println("Introduce el numero del jugador que ha cometido la falta");
            n=Integer.parseInt(sc.nextLine());
        }while(!campo.containsKey(n));
        System.out.print("Expulsado!: ");
        jugadorSaleCampo(campo,n);
    }

    public static void vaciaCampo(Map<Integer,String> campo){
        //Aqui tengo preguntas. Si ejecuto un foreach de campo.keySet() y elimino jugadores, me salta java.util.ConcurrentModificationException
        //Lo que se me ha ocurrido es copiar el keyset en otro set aparte y hacer un foreach de ese set.
        //No tengo claro cual sería la mejor manera de hacer esto
        //Se que creando un iterador se puede hacer, creo que Iterator.remove() no da error, el problema está en el iterador oculto que hace foreach
        System.out.println("-----");
        HashSet<Integer> numerosJugadores=new HashSet<>(campo.keySet());    
        for (Integer n : numerosJugadores) {
            jugadorSaleCampo(campo,n);
        }
        if(campo.isEmpty()){
            System.out.println("Final de partido");
        }
        else{
            System.out.println("¿Cómo hay jugadores en el campo?");
        }
    }

}
