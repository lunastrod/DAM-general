package com.dam.abr22;

public class pruebas {
    public static final String CONSTANTE1="CONSTANTE1";
    public static final String CONSTANTE2="CONSTANTE2";

    public static void main(String[] args) {
        switch ("CONSTANTE1") {
            case CONSTANTE1:
                System.out.println("Es CONSTANTE1");
                break;
            case CONSTANTE2:
                System.out.println("Es CONSTANTE2");
                break;
            default:
                System.out.println("No es ninguna constante");
        }    
    }
}
