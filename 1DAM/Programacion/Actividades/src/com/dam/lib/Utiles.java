package com.dam.lib;

public class Utiles {
    public static void main(String[] args) {
        System.out.println(esPrimo(0));
    }
    public static boolean esPrimo(int n){
        boolean encontradoDivisores=false;
        if(n<2){
            encontradoDivisores=true;
        }
        for(int i=2; !encontradoDivisores&&i<=Math.sqrt(n); i++){
            if(n%i==0){
                encontradoDivisores=true;
            }
        }
        return !encontradoDivisores;
    }
}
