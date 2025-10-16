package com.dam.piramides;

/*Crear una clase Piramide:
- que tenga tres atributos nombre, lado (en centímetros) de la base cuadrángular, y altura (en centímetros)
- añade los constructores y/o métodos de acceso que consideres. Intenta que no haya código que no se ejecute.
- añade un método que calcule su volumen (area de la base x altura / 3) y devuelva su valor.
Crear una clase ejecutable CompararPiramides:
- donde se definan dos objetos de tipo Pirámide introduciendo los datos por teclado.
- que muestre la información de los objetos por medio de un println(objeto)
- que calcule el volumen de cada objeto
- indique cuál tiene mayor volumen y cuál mayor altura. */

public class Piramide {
    private String nombre;
    private double lado;//cm de un cuadrado
    private double altura;//cm de la piramide
    public Piramide(String n, double l, double a){
        this.nombre=n;
        this.lado=l;
        this.altura=a;
    }

    public double calculaVolumen(){
        return lado*lado*altura/3;
    }

    public String toString(){
        return "Piramide "+nombre+": base cuadrada lado="+lado+" altura="+altura;
    }

}
