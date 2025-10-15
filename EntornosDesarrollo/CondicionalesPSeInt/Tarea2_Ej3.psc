//################################################################################
//@autor: Daniel Parra Segovia
//@Correccion David Mart�nez
//Algoritmo que pida tres n�meros y los muestre ordenados (de mayor a menor);
//################################################################################
//An�lisis
//Entradas: los 3 numeros
//Salidas: los 3 numeros ordenados
//Variables: 3 numeros de entrada y variable temporal de swap
//############################################################################
//Dise�o:
//Despues de pedir las variables
//Tengo que ordenar de mayor a menor
//Para eso voy a hacer varios swaps en n1 n2 y n3 para ordenarlos poco a poco
//hago el swap si la primera es mayor que la segunda (desordenados)
//############################################################################


Proceso Tarea2_Ej3
	Definir n1,n2,n3 Como Entero;
	Definir temp Como Entero;
	Escribir "Introduce n1";
	Leer n1;
	Escribir "Introduce n2";
	Leer n2;
	Escribir "Introduce n3";
	Leer n3;
	
	si n1<n2 Entonces
		temp:=n2;
		n2:=n1;
		n1:=temp;
	FinSi
	si n2<n3 Entonces
		temp:=n3;
		n3:=n2;
		n2:=temp;
	FinSi
	si n1<n2 Entonces
		temp:=n2;
		n2:=n1;
		n1:=temp;
	FinSi
	
	Escribir n1,", ",n2,", ",n3;
	

FinProceso
// Keep up the good work :)