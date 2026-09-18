//################################################################################
//@autor: Daniel Parra Segovia
//@revisor: Gabriel Fernández
//5 Diseñar un algoritmo que nos diga el dinero que tenemos (en euros y céntimos)
//después de pedirnos cuantas monedas tenemos de 2e, 1e, 50 céntimos, 20 céntimos
//o 10 céntimos).
//################################################################################
//Análisis
//Entradas: numero de monedas de cada tipo
//Salidas: total dinero
//Variables: numero de monedas de cada tipo, otra para guardar el total
//################################################################################
//Diseño
//Declaro variables
//Leo todas las monedas de cada tipo
//calculo dinero total multiplicando por valor de cada moneda
//Imprimo el total
//################################################################################


Proceso Secuenciales5
	//Declaro numero de monedas de cada tipo y total
	Definir m2,m1,m50c,m20c,m10c,totalCentimos Como Entero;
	//Leo todas las monedas de cada tipo
	Escribir "Monedas de 2 euros";
	Leer m2;
	Escribir "Monedas de 1 euro";
	Leer m1;
	Escribir "Monedas de 50 centimos";
	Leer m50c;
	Escribir "Monedas de 20 centimos";
	Leer m20c;
	Escribir "Monedas de 10 centimos";
	Leer m10c;
	//calculo dinero total multiplicando por valor de cada moneda
	totalCentimos:=m2*200+m1*100+m50c*50+m20c*20+m10c*10;
	//Imprimo el total
	Escribir totalCentimos/100," euros";

	
FinProceso
