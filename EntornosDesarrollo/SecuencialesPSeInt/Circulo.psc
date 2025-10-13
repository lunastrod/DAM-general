Algoritmo Circulo
	Definir radio, area, perimetro Como Real;
	Escribir "Introduce radio";
	Leer radio;
	area <- PI*radio^2;
	perimetro := 2*PI*radio;
	Escribir "El area es ", area;
	Escribir "El perimetro es ",perimetro;
	Mientras 1>0 Hacer
		Escribir Sin Saltar trunc(HoraActual()/10000);
		Esperar 1 Segundos;
	FinMientras
FinAlgoritmo