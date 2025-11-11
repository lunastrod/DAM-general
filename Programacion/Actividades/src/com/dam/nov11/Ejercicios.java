package com.dam.nov11;

import java.util.Scanner;

//5 Hacer un programa que reciba un string S y devuelva el mismo string S al cual se le han
//eliminado los espacios)

public class Ejercicios {
    public static void main(String[] args) {
        ej5();
    }
    public static void ej2(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un texto");
        String s=sc.nextLine();
        System.out.println("Introduce un caracter");
        String input=sc.nextLine();
        char c=input.charAt(0);//me quedo con el primer caracter
        System.out.println("buscando caracter "+c);

        int count=0;
        for(int i=0; i<s.length(); i++){
            if(c==s.charAt(i)){
                count++;
            }
        }
        System.out.println("He encontrado \""+c+"\" "+count+" veces en \""+s+"\"");

        sc.close();
    }

    public static void ej5(){
        final String ELIMINAR=" ";

        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un texto");
        String s=sc.nextLine();

        s=s.replace(ELIMINAR, "");
        System.out.println(s);

        sc.close();
    }


}
