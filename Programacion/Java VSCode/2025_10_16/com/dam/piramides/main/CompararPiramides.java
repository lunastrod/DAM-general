package com.dam.piramides.main;

import java.util.Scanner;

import com.dam.piramides.Piramide;

public class CompararPiramides {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Piramide p1=creaPiramide(sc);
        Piramide p2=creaPiramide(sc);
        sc.close();
        double volumen1=p1.calculaVolumen();
        double volumen2=p2.calculaVolumen();
        System.out.println(p1+"\n\tvolumen="+volumen1);
        System.out.println(p2+"\n\tvolumen="+volumen2);
        if(volumen1>volumen2){
            System.out.println(p1.getNombre()+" tiene mayor volumen");
        }
        else if(volumen1==volumen2){
            System.out.println(p1.getNombre()+"y"+p2.getNombre()+" tienen el mismo volumen");
        }
        else{
            System.out.println(p2.getNombre()+" tiene mayor volumen");
        }

        if(p1.getAltura()>p2.getAltura()){
            System.out.println(p1.getNombre()+" tiene mayor altura");
        }
        else if(p1.getAltura()==p2.getAltura()){
            System.out.println(p1.getNombre()+"y"+p2.getNombre()+" tienen la misma altura");
        }
        else{
            System.out.println(p2.getNombre()+" tiene mayor altura");
        }


        

    }
    public static Piramide creaPiramide(Scanner sc){
        String n;
        double l;
        double a;
        System.out.println("Introduce nombre ");
        n=sc.nextLine();
        System.out.println("Introduce lado de la base ");
        l=Double.parseDouble(sc.nextLine());
        System.out.println("Introduce altura de la piramide ");
        a=Double.parseDouble(sc.nextLine());
        return new Piramide(n,l,a);
    }
}
