package com.dam.programame;

import java.util.Scanner;
//aceptado
public class p293 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nCasos=sc.nextInt();
        int ins;
        int art;
        int crus;
        int esc;
        int ani;
        for (int i = 0; i < nCasos; i++) {
            ins=sc.nextInt();
            art=sc.nextInt();
            crus=sc.nextInt();
            esc=sc.nextInt();
            ani=sc.nextInt();
            System.out.println(ins*6+art*8+crus*10+esc*ani*2);
        }
        sc.close();
    }
}
