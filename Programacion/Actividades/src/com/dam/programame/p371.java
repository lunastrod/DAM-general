package com.dam.programame;

import java.util.Scanner;
//aceptado
public class p371 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        boolean running=true;
        int cerillas;
        while(running){
            num=sc.nextInt();
            cerillas=0;
            if(num==0){
                running=false;
            }
            else{
                for (int i = 0; i < num; i++) {
                    cerillas+=3*(i+1);
                }
                System.out.println(cerillas);
            }
        }
        sc.close();
    }
}
