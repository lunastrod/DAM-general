package com.astrod.segundoproyecto.pojo;

import java.util.ArrayList;

public class DataManager {
    private ArrayList<Lenguaje> listaLenguajes;

    private int index;

    public DataManager(){
        index=0;
        listaLenguajes=new ArrayList<Lenguaje>();
        listaLenguajes.add(new Lenguaje("Java","Lenguaje de programación orientado a objetos"));
        listaLenguajes.add(new Lenguaje("Python","Lenguaje de programación interpretado"));
        listaLenguajes.add(new Lenguaje("C++","Lenguaje de programación de bajo nivel"));
        listaLenguajes.add(new Lenguaje("Javascript","Lenguaje de programación para web"));
    }

    public Lenguaje getLenguaje(){
        return listaLenguajes.get(index);
    }

    public void siguienteLenguaje(){
        index=(index+1)%listaLenguajes.size();
    }
}
