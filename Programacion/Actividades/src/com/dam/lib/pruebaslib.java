package com.dam.lib;

import java.util.Random;
import java.util.Scanner;

public class pruebaslib {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rd=new Random();
        int[] nums=LibreriaArray.creaIntArray(sc, "numeros");

        sc.close();
    }
}
