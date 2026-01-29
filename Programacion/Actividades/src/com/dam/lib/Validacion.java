package com.dam.lib;
import java.util.Scanner;

public class Validacion {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        validaInt(sc, "longitud de array", 0, Integer.MAX_VALUE);
        //String[]opts={"matematicas","lengua","historia"};
        //validaStrOpciones(sc,"asignaturas",opts);
        
        //validaInt(sc, "numero de expectadores", -3, 20);
        //validaDouble(sc, "distancia", -3, 20.5);

        //validaStrLen(sc,"texto", 0, 16);
        //validaStrLen(sc,"texto", 16, 16);
        //validaStrLen(sc,"texto", 5, 16);

        sc.close();
    }

    public static Scanner newScanner(){
        return new Scanner(System.in);

        
    }

    public static int validaInt(Scanner sc, String msg, int min, int max){
        /*
            Valida que un int esté entre [min,max]
            si max vale Integer.MAX_VALUE no imprime max
        */
        int resultado=0;
        boolean valid=false;
        do{
            if(max==Integer.MAX_VALUE){
                System.out.println("Introduce "+msg+" (entero mayor que "+min+")");
            }else{
                System.out.println("Introduce "+msg+" (entero entre "+min+" y "+max+")");
            }
            try{
                resultado=Integer.parseInt(sc.nextLine());
                if(resultado<min||resultado>max){
                    System.err.println("Error: Entero fuera de rango ("+resultado+")");
                }
                else{
                    valid=true;
                }
            }
            catch(NumberFormatException e){
                System.err.println("Error: Formato de numero no reconocido");
            }
        }while(!valid);
        return resultado;
    }

    public static double validaDouble(Scanner sc, String msg, double min, double max){
        /*
            Valida que un double esté entre [min,max]
        */
        double resultado=0;
        boolean valid=false;
        do{
            System.out.println("Introduce "+msg+" (numero entre "+min+" y "+max+")");
            try{
                resultado=Double.parseDouble(sc.nextLine());
                if(resultado<min||resultado>max){
                    System.err.println("Error: Numero fuera de rango ("+resultado+")");
                }
                else{
                    valid=true;
                }
            }
            catch(NumberFormatException e){
                System.err.println("Error: Formato de numero no reconocido");
            }
        }while(!valid);
        return resultado;
    }

    public static String validaStrOpciones(Scanner sc, String msg, String[] opciones){
        /*
            Valida que un string es una de las opciones
        */
        String resultado;
        boolean valid=false;
        do{
            System.out.println("Introduce "+msg+" (opciones: "+String.join(", ", opciones)+")");
            resultado=sc.nextLine();
            for(int i=0; i<opciones.length; i++){
                if(resultado.equals(opciones[i])){
                    valid=true;
                }
            }
            if(!valid){
                System.err.println("Error: opcion no reconocida: "+resultado);
            }
        }while(!valid);

        return resultado;
    }

    public static String validaStrLen(Scanner sc,String msg,int minLen, int maxLen){
        /*
            Valida que la longitud de un string está entre [minLen,maxLen]
        */
        String resultado;
        do{
            if(minLen==maxLen){
                System.out.println("Introduce "+msg+" ("+minLen+" caracteres)");
            }
            else if(minLen==0){
                System.out.println("Introduce "+msg+" (maximo "+maxLen+" caracteres)");
            }
            else{
                System.out.println("Introduce "+msg+" (entre "+minLen+" y "+maxLen+" caracteres)");
            }
            resultado=sc.nextLine();
            if(resultado.length()<minLen||resultado.length()>maxLen){
                System.err.println("Error: Numero de caracteres incorrecto ("+resultado.length()+")");
            }
        }while(resultado.length()<minLen||resultado.length()>maxLen);
        return resultado;
    }
}
