package com.dam.model;

import java.util.ArrayList;
import java.util.HashMap;


public class ListaEncuestas {
    ArrayList<Encuesta> encuestas=new ArrayList<>();
    public void addEncuesta(Encuesta encuesta) {
        encuestas.add(encuesta);
    }
    public ArrayList<Encuesta> getEncuestas() {
        return encuestas;
    }
    /*o Cuántas personas se han encuestado de cada rango de edad.
    o Cuál es la frecuencia más usada.
    o Cuál es la serie más vista */
    public String analisis(){
        HashMap<String,Integer> edades=new HashMap<>();
        HashMap<String,Integer> frecuencias=new HashMap<>();
        HashMap<String,Integer> series=new HashMap<>();
        String clave;
        for(Encuesta e: encuestas){
            clave=e.getEdad();
            if(edades.containsKey(clave)){
                edades.put(clave, edades.get(clave)+1);
            }
            else{
                edades.put(clave,1);
            }
            clave=e.getFrecuencia();
            if(frecuencias.containsKey(clave)){
                frecuencias.put(clave, frecuencias.get(clave)+1);
            }
            else{
                frecuencias.put(clave,1);
            }
            for(String s: e.getSeries()){
                clave=s;
                if(series.containsKey(clave)){
                    series.put(clave, series.get(clave)+1);
                }
                else{
                    series.put(clave,1);
                }
            }
        }

        String s="";
        s+="Edades\n";
        for(String e: edades.keySet()){
            s+="- "+e+": "+edades.get(e)+"\n";
        }
        String frecuenciaMasUsada=null;
        for(String f: frecuencias.keySet()){
            if(frecuenciaMasUsada==null || frecuencias.get(f)>frecuencias.get(frecuenciaMasUsada)){
                frecuenciaMasUsada=f;
            }
        }
        s+="Frecuencia más usada: "+frecuenciaMasUsada+"\n";
        String serieMasVista=null;
        for(String s1: series.keySet()){
            if(serieMasVista==null || series.get(s1)>series.get(serieMasVista)){
                serieMasVista=s1;
            }
        }
        s+="Serie más vista: "+serieMasVista+"\n";
        return s;
    }
}
