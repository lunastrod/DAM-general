package com.dam.feb5;

import java.util.Scanner;

public class GestionEmpresa {
    public static final String [] OPCIONES_MENU={"A","M","S"};
    public static final String [] VALIDA_BOOLEAN={"Si", "No"};
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Empresa empresa = new Empresa(validaStrLen(sc, "nombre de la empresa", 1, 1000));
        
        String opcion;
        String tipoEmpleado;
        Empleado e=null;
        do{
            System.out.println("Introduce una de las siguientes opciones:");
            System.out.println("A) Añadir empleado");
            System.out.println("M) Mostrar empresa");
            System.out.println("S) Salir");
            opcion=validaStrOpciones(sc, "opcion", OPCIONES_MENU);
            
            switch (opcion) {
                case "A":
                    tipoEmpleado = validaStrOpciones(sc, "opcion", Empleado.tiposEmpleados);
                    String nombre=validaStrLen(sc, "nombre", 1, Integer.MAX_VALUE);
                    String dni=validaStrLen(sc, "dni", 1, 20);
                    double salario=validaDouble(sc, "salario", 0, Double.MAX_VALUE);
                    switch (tipoEmpleado) {
                        case "PRODUCCION":
                            String turno= validaStrOpciones(sc, "turno", EmpleadoProduccion.TURNOS_VALIDOS);
                            double plusNoct=0;
                            if(turno.equals("NOCHE")){
                                plusNoct=validaDouble(sc, "plus nocturnidad", 0, Double.MAX_VALUE);
                            }
                            e=new EmpleadoProduccion(nombre, dni, salario, turno, plusNoct);
                            break;
                        case "DISTRIBUCION":
                            String zona=validaStrLen(sc, "zona", 1, Integer.MAX_VALUE);
                            e=new EmpleadoDistribucion(nombre, dni, salario, zona);
                            break;
                    }
                    empresa.addEmpleado(e);
                    break;
                case "M":
                    System.out.println(empresa);
                    break;
            }
        }while(!opcion.equals("S"));
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
                if(resultado.equalsIgnoreCase(opciones[i])){
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
