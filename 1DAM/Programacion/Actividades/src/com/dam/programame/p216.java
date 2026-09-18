package com.dam.programame;

import java.util.Scanner;
//aceptado
public class p216 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nCasos=sc.nextInt();
        int h=0;
        int m=0;
        int s=0;
        for (int i = 0; i < nCasos; i++) {
            s=sc.nextInt();
            m=s/60;
            s=s%60;
            h=m/60;
            m=m%60;
            System.out.printf("%02d:%02d:%02d\n",h,m,s);
        }
        sc.close();
    }
}
