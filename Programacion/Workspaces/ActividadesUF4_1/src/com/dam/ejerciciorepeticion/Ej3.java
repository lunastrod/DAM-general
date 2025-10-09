package com.dam.ejerciciorepeticion;
/*
 * (while o for) Escribir un programa que imprima todos los números pares entre dos
números que se le pidan al usuario.
 * */

import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nMayor=Integer.parseInt(sc.nextLine());
		int nMenor=Integer.parseInt(sc.nextLine());
		if(nMayor<nMenor) {// el usuario me los introduce al reves, swap
			int temp=nMenor;
			nMenor=nMayor;
			nMayor=temp;
		}
		
		
		for(int i=nMenor; i<nMayor; i++) {
			
		}

	}

}
