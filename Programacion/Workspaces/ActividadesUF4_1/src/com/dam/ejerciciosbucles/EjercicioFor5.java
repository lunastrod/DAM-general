package com.dam.ejerciciosbucles;

public class EjercicioFor5 {
	static final int INIT=1;
	static final int END=50;

	public static void main(String[] args) {
		int sumaPares=0;
		int sumaImpares=0;
		
		for(int i=INIT; i<=END; i++) {
			if(i%2==0) {
				sumaPares+=i;
			}
			else {
				sumaImpares+=i;
			}
		}
		System.out.println("Suma pares: "+sumaPares);
		System.out.println("Suma impares: "+sumaImpares);
	}

}
