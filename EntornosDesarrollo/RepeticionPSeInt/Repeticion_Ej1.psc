//@autor: Daniel Parra Segovia
//@corrección:
//################################################################################
//Crea una aplicación que pida un número y calcule su factorial (El factorial de
//un número es el producto de todos los enteros entre 1 y el propio número y se
//representa por el número seguido de un signo de exclamación.
//Por ejemplo 5! = 1x2x3x4x5=120)
//################################################################################
//Análisis
// Solicitud de entrada: numero entero mayor que 1
// Cálculo del factorial
//		Entrada: el numero entero 
//		Proceso: acumular la multiplicacion de todos los enteros anteriores en una variable
//		Salida: la variable acumuladora
// Presentación de resultado: resultado del factorial
//################################################################################
//Diseño
// Variables:
//		n: Entero, lectura por teclado
//		factorial: variable acumuladora, inicializada en 1
//		i: variable que valdrá cada numero entero mayor que 1 menor o igual que n en el bucle
// Cálculo:
//		Un bucle for i desde 2 hasta n que acumule factorial*=i;
//################################################################################ 

Algoritmo sin_titulo
	Definir n,factorial,i Como Entero;
	Escribir "Introduce n";
	Leer n;
	factorial:=1;
	Para i<-2 Hasta n Con Paso 1 Hacer
		factorial:=factorial*i;
	FinPara
	Escribir n,"! = ",factorial;
FinAlgoritmo
