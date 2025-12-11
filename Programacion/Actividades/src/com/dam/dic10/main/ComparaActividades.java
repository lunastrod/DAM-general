package com.dam.dic10.main;

import java.util.Scanner;

import com.dam.dic10.pojos.ActividadDeportiva;

public class ComparaActividades {
    private static final int N_ACTS=8;
    public static void main(String[] args) {
        ActividadDeportiva[] acts=new ActividadDeportiva[N_ACTS];
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<acts.length; i++){
            acts[i]=solicitaActividad(sc);
            System.out.println(acts[i]);
        }
        sc.close();

        int totalDistancia=0;
        for(int i=0; i<acts.length; i++){
            totalDistancia+=acts[i].getDistancia();
        }
        System.out.println("Total de distancia: "+totalDistancia);
    }

    private static ActividadDeportiva solicitaActividad(Scanner sc){
        String disciplina;
        int distancia=0;//m
        double tiempo=0;//min
        String fecha;

        boolean valid;
        valid=false;
        do{
            System.out.println("Introduce disciplina: ["+String.join(", ",ActividadDeportiva.DISCIPLINAS)+"]");
            disciplina=sc.nextLine();
            for(int i=0; i<ActividadDeportiva.DISCIPLINAS.length; i++){
                if(disciplina.equals(ActividadDeportiva.DISCIPLINAS[i])){
                    valid=true;
                }
            }
        }while(!valid);
        do{
            System.out.println("Introduce fecha (16 caracteres)");
            fecha=sc.nextLine();
        }while(fecha.length()!=ActividadDeportiva.CHAR_FECHA);

        do{
            try{
                System.out.println("Introduce distancia (entero entre "+60+" y "+100000+")");
                distancia=Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Introduce un numero valido");
            }
        }while(distancia<ActividadDeportiva.MIN_DISTANCIA||distancia>ActividadDeportiva.MAX_DISTANCIA);

        do{
            try{
                System.out.println("Introduce tiempo (entre "+0.5+" y "+2880+")");
                tiempo=Double.parseDouble(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Introduce un numero valido");
            }
        }while(tiempo<ActividadDeportiva.MIN_TIEMPO||tiempo>ActividadDeportiva.MAX_TIEMPO);
        
        return new ActividadDeportiva(disciplina,distancia,tiempo,fecha);
    }
}
