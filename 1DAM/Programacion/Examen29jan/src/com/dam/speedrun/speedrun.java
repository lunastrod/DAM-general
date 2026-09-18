package com.dam.speedrun;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class speedrun {
    static HashMap <String, Integer> tablaFlota;
    static Scanner sc;
    public static void main(String[] args) {
        tablaFlota =new HashMap<>();
        sc = new Scanner(System.in);
        System.out.println("Introduce numero de vehiculos que se van a introducir");
        int n=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            if(solicitaCoche(i)){
                i--;
            }
        }
        imprimeVehiculos();

        sc.close();
    }

    static boolean solicitaCoche(int i){
        boolean estaTabla=false;
        System.out.println("Indica la matricula del coche "+i);
        String m=sc.nextLine();
        System.out.println("Indica el porcentaje de bateria");
        int b=Integer.parseInt(sc.nextLine());
        if(tablaFlota.containsKey(m)){
            estaTabla=true;
            System.out.println("¡Este vehiculo ya esta registrado, se actualiza el porcentaje de bateria!");
        }
        if(b<=40){
            System.out.println("¡¡El vehiculo con matricula "+m+" debe ser recargado!!");
        }
        tablaFlota.put(m, b);
        return estaTabla;
    }

    static void imprimeVehiculos(){
        int menor40=0;
        TreeMap<String,Integer> t = new TreeMap<>(tablaFlota);
        for (Entry<String,Integer> e : t.entrySet()) {
            System.out.println(e.getKey()+" - "+e.getValue()+"%");
            if(e.getValue()<=40){
                menor40++;
            }
        }
        System.out.println("Hay "+menor40+" coches que tienen un porcentaje de bateria menor o igual a 40 por lo que no son aptos para el uso");
    }
    

}
