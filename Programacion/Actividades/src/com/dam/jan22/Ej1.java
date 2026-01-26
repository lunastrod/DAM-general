package com.dam.jan22;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ej1 {
    public static final int N_PALABRAS=10;
    public static void main(String[] args) {
        HashMap <String,Integer> tablaPalabras=new HashMap<>();   
        rellenaMapa(tablaPalabras);
        mostrarMapa(tablaPalabras);
    }

    public static String solicitaPalabra(Scanner sc,Map<String,Integer> m){
        String s;
        do{
            System.out.println("Introduce palabra:");
            s=sc.nextLine().toUpperCase();
        }while(m.containsKey(s));
        return s;
    }

    public static void rellenaMapa(Map<String,Integer> m){
        String p;
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < N_PALABRAS; i++) {
            p=solicitaPalabra(sc,m);
            m.put(p, p.length());
        }
        sc.close();
    }

    public static void mostrarMapa(Map<String,Integer> m){
        TreeMap<String,Integer> ordenado=new TreeMap<>(m);
        for (Map.Entry<String, Integer> e : ordenado.entrySet()) {
            System.out.println(e.getKey()+" con "+e.getValue()+" letras");
        }
    }
}
