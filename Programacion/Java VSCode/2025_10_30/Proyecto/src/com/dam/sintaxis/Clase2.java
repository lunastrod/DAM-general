package com.dam.sintaxis;

public class Clase2 {
    int p1,p2;
    public Clase2(int i, int j) {
        p1=i;
        p2=j;
    }
    public int modificar(int i) {
        p1=p1+i;
        p2=p2+i;
        System.out.print(p2+"(clase) ");
        return p1;
    }
}
