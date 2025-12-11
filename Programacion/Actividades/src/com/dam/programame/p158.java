package com.dam.programame;

import java.util.Scanner;
//aceptado
public class p158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos=sc.nextInt();
        int up;
        int down;
        int alturaActual;
        int muroActual;
        for(int i=0; i<casos; i++){
            int muros=sc.nextInt();
            up=0;
            down=0;
            alturaActual=0;
            muroActual=0;
            for(int j=0; j<muros; j++){
                muroActual=sc.nextInt();
                if(j==0){
                    alturaActual=muroActual;
                }
                if(alturaActual<muroActual){
                    up++;
                }
                if(alturaActual>muroActual){
                    down++;
                }
                alturaActual=muroActual;
            }
            System.out.println(up+" "+down);
        }

        sc.close();
    }
}
