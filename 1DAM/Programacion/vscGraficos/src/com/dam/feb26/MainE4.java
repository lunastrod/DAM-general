package com.dam.feb26;

import java.awt.EventQueue;

public class MainE4 {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                E4 ventana=new E4();
                ventana.hacerVisible();
            }
        });
    }
}
