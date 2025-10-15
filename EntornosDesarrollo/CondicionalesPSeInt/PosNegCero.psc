//@autor Damaga
//correcion Daniel Parra Segovia
//################################################################################
//Algoritmo que pida un n�mero y diga si es positivo, negativo o 0.
//################################################################################
//An�lisis
// El usuario introduce un numero y le devuelvo positivo negativo o cero
// El numero lo guardo en una variable
//################################################################################
//Dise�o
// Hago 3 ifs que comparan dicho numero con  0 positivos y negativos
//################################################################################
Proceso positivonegativocero
	Definir num Como Entero;
	Escribir "Introduce un numero";
	leer num;
	si num < 0 Entonces
		Escribir "negativo";
	FinSi
	si num > 0 Entonces
		Escribir "Positivo";
	FinSi
	si num = 0 Entonces
		Escribir "0";
	FinSi
	
FinProceso
