package com.dam.programame;

import java.util.Scanner;
//wrong answer
public class p411 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int pesoMax=1;
        int elefante;
        int nElefantes;
        while(pesoMax!=0){
            pesoMax=sc.nextInt();
            nElefantes=0;
            elefante=1;
            if(pesoMax!=0){
                while(elefante!=0){
                    elefante=sc.nextInt();
                    if(elefante!=0){
                        pesoMax-=elefante;
                        if(pesoMax>=0){
                            nElefantes++;
                        }
                    }
                }
                System.out.println(nElefantes);
            }
            
        }
        sc.close();
    }
}
