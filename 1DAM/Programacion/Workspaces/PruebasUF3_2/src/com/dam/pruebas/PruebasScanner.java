package com.dam.pruebas;

import java.util.Scanner;

public class PruebasScanner {

	public static void main(String[] args) {
		String texto="124234";
		Scanner sc = new Scanner(System.in);
		System.out.println("numero entero");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		sc.nextLine();
		System.out.println(a+" "+b+" "+c);
		
		
		System.out.println("numero entero");
		int d=Integer.parseInt(sc.nextLine());
		System.out.println(d);
		

		sc.close();

	}

}
