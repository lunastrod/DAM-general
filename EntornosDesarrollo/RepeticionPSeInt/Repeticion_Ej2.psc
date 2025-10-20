//@autor: Daniel Parra Segovia
//@corrección:
// ################################################################################
// Algoritmo que pida números hasta que se introduzca un cero. Debe imprimir la suma
// y la media de todos los números introducidos.
// ################################################################################
// Análisis
// Entrada: numeros enteros
// deja de solicitar numeros enteros cuando se introduce un 0
// Cálculo de la suma
// Necesito una variable acumuladora que vaya sumando todos los numeros introducidos
// Cálculo de la media
// Necesito un contador de cuántos números se han introducido y la suma de todos ellos
// Presentación de resultado: suma total y media
// ################################################################################
// Diseño
// Variables:
// n: Entero, numero del usuario
// nNums: variable contador
// suma: variable acumuladora
// media: suma/nNums, es un numero decimal
// Cálculo:
// Un bucle for i desde 2 hasta n que acumule factorial*=i;
// ################################################################################
Proceso sin_titulo
	Definir n,nNums,suma Como Entero;
	Definir media Como Real;
	suma:=0;
	nNums:=0;
	Repetir
		Escribir "Introduzca numero (0 para parar)";
		Leer n;
		nNums:=nNums+1;
		suma:=suma+n;
		
	Hasta Que n==0
	nNums:=nNums-1;//para que el ultimo 0 no cuente
	media:=suma/nNums;
	Escribir "Suma= " ,suma;
	Escribir  "Media= ",media;
FinProceso
