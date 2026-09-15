package com.dam.ej1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ej1 {
    private static final int AFORO_MAX=50;
    private static final int MESAS_MAS_COMENSALES=2;
    private static int aforo_actual=AFORO_MAX;
    private static HashMap <String, Integer> tablaReservas;
    private static Scanner sc;
    public static void main(String[] args) {
        tablaReservas=new HashMap<>();
        sc=new Scanner(System.in);
        do{
            nuevaReserva();
        }while(aforo_actual>0);
        sc.close();
        System.out.println("¡AFORO COMPLETADO!\n");
        System.out.println("** Hay "+tablaReservas.size()+" mesas reservadas **");
        muestraReservasOrdenadas();
        System.out.println("\nHay "+cuentaMesasMasComensales(MESAS_MAS_COMENSALES)+" mesas con mas de "+MESAS_MAS_COMENSALES+" comensales");
    }

    private static void muestraReservasOrdenadas(){
        ArrayList <Entry<String,Integer>> l= new ArrayList<>(tablaReservas.entrySet());
        l.sort(Entry.comparingByValue());
        for (Entry<String,Integer> entry : l) {
            System.out.println(entry.getKey()+" - "+entry.getValue()+" comensales");
        }
    }

    private static int cuentaMesasMasComensales(int mayorQueComensales){
        int nMesas=0;
        for (Integer com : tablaReservas.values()) {
            if(com>mayorQueComensales){
                nMesas++;
            }
        }
        return nMesas;
    }

    private static void nuevaReserva(){
        String n=solicitaNombre();
        int c=solicitaNumComensales();
        if(c>aforo_actual){
            System.out.println("Lo sentimos, pero no tenemos mesa para "+c+" comensales\n");
        }
        else{
            aforo_actual-=c;
            tablaReservas.put(n,c);
            System.out.println("Reserva realizada a nombre de "+n+"\n");
        }
    }
    private static String solicitaNombre(){
        String nombre=null;
        do{
            if(nombre!=null){
                System.out.println("Ya existe una reserva a nombre de "+nombre+", por favor, indica otro nombre");
            }
            else{
                System.out.println("Introduce tu nombre");
            }
            nombre=sc.nextLine();
        }while(tablaReservas.containsKey(nombre));
        return nombre;
    }
    private static int solicitaNumComensales(){
        //Voy a suponer que debe ser un numero mayor que 0
        int com=-1;
        boolean valido=false;
        do{
            System.out.println("¿Para cuantos comensales querria hacer la reserva?");
            try{
                com=Integer.parseInt(sc.nextLine());
                if(com<=0){
                    System.out.println("Introduce un numero mayor que 0");
                }
                else{
                    valido=true;
                }
            }catch(NumberFormatException e){
                System.out.println("Introduce un numero valido");
            }
        }while(!valido);
        return com;
    }
}
