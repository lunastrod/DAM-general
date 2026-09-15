package com.dam.nov18;
/*Crea un paquete dam.ej2.main y dentro crea una clase
ejecutable, Encuestador, en la que:
- Se le pida al usuario cuántas encuestas se van a realizar
-  Para cada encuesta se realizarán, una a una, las tres preguntas y el usuario introducirá las respuestas.
- Y cuando se haya acabado de introducir encuestas el programa deberá informar de cuántos de los encuestados han pasado el COVID-19, y
cuántos han padecido tres o más síntomas o la gravedad haya sido mayor que 3.
- Mostrar la encuesta del encuestado más mayor y que haya pasado la enfermedad con menor gravedad.*/

import java.util.Scanner;

public class Encuestador {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("¿Cuántas encuestas va a realizar?");
        int nEncuestas=Integer.parseInt(sc.nextLine());
        Encuesta[] encuestas=new Encuesta[nEncuestas];
        for(int i=0;i<nEncuestas;i++){
            System.out.println("Encuesta "+(i+1));
            encuestas[i]=nuevaEncuesta(sc);
            System.out.println("-------------------");
        }
        sc.close();

        int encuestasMas3Sintomas=0;
        int gravedadMayor3=0;
        int covid=0;
        Encuesta masMayor=new Encuesta(Integer.MIN_VALUE,false,"ERROR",0);
        Encuesta menorGravedad=new Encuesta(0,false,"ERROR",Integer.MAX_VALUE);
        for(int i=0;i<nEncuestas;i++){
            System.out.println("1");
            if(encuestas[i].isCovid()){
                covid++;
            }
            System.out.println("2");
            if(encuestas[i].getGravedad()>3){
                gravedadMayor3++;
            }
            System.out.println("3");
            if(encuestas[i].numSintomas()>=3){
                encuestasMas3Sintomas++;
            }
            System.out.println("4");
            if(encuestas[i].getEdad()>masMayor.getEdad()){
                masMayor=encuestas[i];
            }
            System.out.println("5");
            if(encuestas[i].getGravedad()<menorGravedad.getGravedad()){
                menorGravedad=encuestas[i];
            }
            System.out.println("6");
        }

        System.out.println("Han pasado el COVID-19: "+covid);
        System.out.println("Han padecido 3 o más síntomas: "+encuestasMas3Sintomas);
        System.out.println("Han tenido gravedad mayor que 3: "+gravedadMayor3);
        System.out.println("Encuestado más mayor que ha pasado la enfermedad:");
        System.out.println(masMayor);
        System.out.println("Encuestado con menor gravedad que ha pasado la enfermedad:");
        System.out.println(menorGravedad);
    }
    
    private static Encuesta nuevaEncuesta(Scanner sc){
        System.out.println("Edad");
        int edad=Integer.parseInt(sc.nextLine());

        System.out.println("¿Ha pasado usted el COVID-19? SI/NO");
        boolean covid=sc.nextLine().equals("SI");

        System.out.println("¿Qué síntomas padeció?");
        String sintomas=sc.nextLine();

        System.out.println("Nivel de gravedad 1-5");
        int gravedad=Integer.parseInt(sc.nextLine());

        Encuesta e=new Encuesta(edad, covid, sintomas, gravedad);
        return e;
    }
}
