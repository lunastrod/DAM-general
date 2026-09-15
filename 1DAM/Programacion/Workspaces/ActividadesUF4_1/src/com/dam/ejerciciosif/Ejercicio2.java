package com.dam.ejerciciosif;

import java.util.Scanner;

//Dados 5 números, detectar cuál de los 5 es mayor y escribirlo por pantalla.

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce n1");
		int n1=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce n2");
		int n2=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce n3");
		int n3=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce n4");
		int n4=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce n5");
		int n5=Integer.parseInt(sc.nextLine());
		sc.close();
		
		if(n1>n2 && n1>n3 && n1>n4 && n1>n5) {
			System.out.println("El numero mayor es "+ n1);
		}
		else if(n2>n3 && n3>n4 && n3>n5) {
			System.out.println("El numero mayor es "+ n2);
		}
		else if(n3>n4 && n3>n5) {
			System.out.println("El numero mayor es "+ n3);
		}
		else if(n4>n5) {
			System.out.println("El numero mayor es "+ n4);
		}
		else {
			System.out.println("El numero mayor es "+ n5);
		}
		
		
		
		

	}

}
