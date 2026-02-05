package com.dam.feb3;

import java.util.Scanner;

public class GestionArq {
    static Casa casa;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        casa = new Casa(validaStrLen(sc, "Introduce la direccion", 1, 1000));
        String opcion;
        do{
            System.out.println("Introduce una de las siguientes opciones:");
            System.out.println("A) Añadir estancia");
            System.out.println("M) Mostrar casa");
            System.out.println("S) Salir");
    
    
            opcion=validaStrOpciones(sc, "Introduce opcion:",new String[] {"A","M","S"});
            switch (opcion) {
                case "A":
                    String tipoEstancia=validaStrOpciones(sc, "el tipo de estancia", Estancia.TIPOS_ESTANCIA);
                    Estancia estancia=null;
                    double m2=validaDouble(sc, "los metros cuadrados", 0, Double.MAX_VALUE);
                    int numPuertas=validaInt(sc, "el numero de puertas", 1, Integer.MAX_VALUE);
                    int numVentanas=validaInt(sc, "el numero de ventanas", 0, Integer.MAX_VALUE);
                    switch (tipoEstancia) {
                        case "Hall":
                            boolean puertaBlind=validaStrOpciones(sc, "Tiene puerta blindada?", new String[] {"Si","No"}).equals("Si");
                            estancia=new Hall(tipoEstancia, m2, numPuertas, numVentanas, puertaBlind);
                            break;
                        case "Cocina":
                            boolean tieneTend=validaStrOpciones(sc, "Tiene tendedero?", new String[] {"Si","No"}).equals("Si");
                            double m2Tend=0;
                            if(tieneTend){
                                m2Tend=validaDouble(sc, "los metros cuadrados del tendedero", 0, Double.MAX_VALUE);
                            }
                            estancia=new Cocina(tipoEstancia, m2, numPuertas, numVentanas, tieneTend, m2Tend);
                            break;
                        case "Habitacion":
                            boolean accesoBanio=validaStrOpciones(sc, "Tiene acceso a baño?", new String[] {"Si","No"}).equals("Si");
                            estancia=new Habitacion(tipoEstancia, m2, numPuertas, numVentanas, numPuertas, accesoBanio);
                            break;
                        case "Banio":
                                boolean tieneBanera=validaStrOpciones(sc, "Tiene bañera?", new String[] {"Si","No"}).equals("Si");
                                boolean tieneDucha=validaStrOpciones(sc, "Tiene ducha?", new String[] {"Si","No"}).equals("Si");
                                estancia=new Banio(tipoEstancia, m2, numPuertas, numVentanas, tieneDucha, tieneBanera);
                            break;
                        case "Salon":
                            boolean tieneTerraza=validaStrOpciones(sc, "Tiene terraza?", new String[] {"Si","No"}).equals("Si");
                            double m2Terraza=0;
                            if(tieneTerraza){
                                m2Terraza=validaDouble(sc, "los metros cuadrados de la terraza", 0, Double.MAX_VALUE);
                            }
                            int numPuntosRed=validaInt(sc, "el numero de puntos de red", 1, Integer.MAX_VALUE);
                            estancia=new Salon(tipoEstancia, m2, numPuertas, numVentanas, numPuntosRed, tieneTerraza, m2Terraza);
                            break;
                    }
                    System.out.println("Estancia creada: "+estancia);
                    casa.addEstancia(estancia);
                    break;
                case "M":
                    System.out.println(casa);
                    break;
            }
        }while(opcion.equals("S"));

        
    
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

}
