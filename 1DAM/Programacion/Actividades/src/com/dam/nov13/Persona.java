package com.dam.nov13;

import java.util.Random;

public class Persona {
    private int sexo;//1 o 2
    private int trabaja;// 1 o 2
    private int sueldo;// entre 600 y 2000

    public void generaPersonaAleatoria(){
        Random rd=new Random();
        sexo=rd.nextInt(1,2+1);
        trabaja=rd.nextInt(1,2+1);
        //no pongo constantes porque meh
        sueldo=rd.nextInt(600,2000+1);
    }
    public boolean esHombre(){
        return sexo==1;
    }
    public boolean esMujer(){
        return sexo==2;
    }
    public boolean esTrabajador(){
        return trabaja==1;
    }
    public int getSueldo(){
        return sueldo;
    }
}
