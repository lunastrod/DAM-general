package com.dam.jan27;
/*
Desarrollar un programa para almacenar en dos HashMap, paisesCapitales y
paisesIntentos, los países de la UE con mejor calidad de vida y realizar un quiz de
capitales.

Contenido de paisesCapitales

"Alemania":0
"Austria":0
"Bélgica":0
"Dinamarca":0
"Eslovenia":0
"España":0
"Finlandia":0
"Francia":0
"Irlanda":0
"Italia":0
"Lituania":0
"Luxemburgo":0
"Países Bajos":0
"Portugal":0
"República Checa":0
"Suecia":0


"Alemania":"Berlín"
"Austria":"Viena"
"Bélgica":"Bruselas"
"Dinamarca":"Copenhague"
"Eslovenia":"Liubliana"
"España":"Madrid"
"Finlandia":"Helsinki"
"Francia":"París"
"Irlanda":"Dublín"
"Italia":"Roma"
"Lituania":"Vilna"
"Luxemburgo":"Luxemburgo"
"Países Bajos":"Ámsterdam"
"Portugal":"Lisboa"
"República Checa":"Praga"
"Suecia":"Estocolmo"
*/

import java.util.HashMap;

public class Ej1 {
    private static final String[] PAISES={"Alemania","Austria","Belgica","Dinamarca","Eslovenia","España","Finlandia","Francia","Irlanda","Italia","Lituania","Luxemburgo","Paises Bajos","Portugal","Republica Checa","Suecia"};
    private static final String[] CAPITALES={"Berlin","Viena","Bruselas","Copenhague","Liubliana","Madrid","Helsinki","Paris","Dublin","Roma","Vilna","Luxemburgo","Amsterdam","Lisboa","Praga","Estocolmo"};
    static HashMap <String,String> paisesCapitales;
    static HashMap <String,Integer> paisesIntentos;
    public static void main(String[] args) {
        paisesCapitales=new HashMap<>();
        paisesIntentos=new HashMap<>();
        rellenaPaises();
        System.out.println(paisesCapitales);
        System.out.println(paisesIntentos);
    }

    public static void rellenaPaises(){
        for (int i = 0; i < PAISES.length; i++) {
            paisesCapitales.put(PAISES[i], CAPITALES[i]);
            paisesIntentos.put(PAISES[i], 0);
        }
    }
}
