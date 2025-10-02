package com.dam.pruebas;

import java.util.Scanner;

public class PruebasIf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero");
		
		String input=sc.nextLine();
		int n = Integer.parseInt(input);
		sc.close();
		
		if(n%2==0) {
			System.out.println("Es par");
		}
		else {
			System.out.println("Es impar");
		}
		
		if(n>0) {
			System.out.println("Es positivo");
		}
		else if(n==0){
			System.out.println("Es cero");
		}
		else {
			System.out.println("Es negativo");
		}
		
		int a=0;
		switch(a){
			case 0:
				System.out.println("-");
				break;
			case 1:
				System.out.println("--");
				break;
			default:
				System.out.println("---");
				break;
		}


	}

}
