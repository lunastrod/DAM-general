package com.dam.comparadores.main;

import java.util.Scanner;

import com.dam.comparadores.pojo.CampoFutbol;
import com.dam.comparadores.pojo.Helipuerto;

/*Crear una clase CampoFutbol:
- que tenga cuatro atributos nombre, largo y ancho (en metros), y capacidad (espectadores)
- añade los constructores y/o métodos de acceso que consideres. Intenta que no haya código
que no se ejecute.
- añade un método que calcule su perímetro y devuelva su valor.
- añade un método que calcule su área y devuelva su valor.
Crear una clase ejecutable CompararCamposF:
- donde se definan dos objetos de tipo CampoFutbol introduciendo los datos por teclado.
- que muestre la información de los objetos por medio de un println(objeto)
- que calcule el área y el perímetro de cada objeto
- indique cuál tiene mayor área de juego, cuál mayor perímetro del área de juego y cuál mayor
capacidad de espectadores.
 */

public class CompararCamposF {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CampoFutbol cf1=creaCampoFutbol(sc);
        CampoFutbol cf2=creaCampoFutbol(sc);
        sc.close();


        if(cf1.calculaArea()>cf2.calculaArea()){
            System.out.println(cf1+"\nes mas grande que\n"+cf2);
        }
        else{
            System.out.println(cf2+"\nes mas grande que\n"+cf1);
        }
        System.out.println();

        if(cf1.calculaPerimetro()>cf2.calculaPerimetro()){
            System.out.println(cf1+"\nntiene mas perimetro que\n"+cf2);
        }
        else{
            System.out.println(cf2+"\ntiene mas perimetro que\n"+cf1);
        }
        System.out.println();

        if(cf1.getCapacidad()>cf2.getCapacidad()){
            System.out.println(cf1+"\ntiene mas capacidad que\n"+cf2);
        }
        else{
            System.out.println(cf2+"\ntiene mas capacidad que\n"+cf1);
        }
        System.out.println();

        if(cf1.esOficial()){
            System.out.println(cf1+"\ntiene medidas oficiales");
        }
        else{
            System.out.println(cf1+"\nno tiene medidas oficiales");
        }
        System.out.println();

        if(cf2.esOficial()){
            System.out.println(cf2+"\ntiene medidas oficiales");
        }
        else{
            System.out.println(cf2+"\nno tiene medidas oficiales");
        }
    }

    public static CampoFutbol creaCampoFutbol(Scanner sc){
        String nombre;
        double largo;
        double ancho;
        int capacidad;
        System.out.println("Introduce nombre");
        nombre = sc.nextLine();
        System.out.println("Introduce largo");
        largo = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce ancho");
        ancho = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce capacidad");
        capacidad = Integer.parseInt(sc.nextLine());
        return new CampoFutbol(nombre,largo,ancho,capacidad);
    }
    



}
