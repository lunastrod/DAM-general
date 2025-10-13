// ################################################################################
//@autor: Daniel Parra Segovia
//@Revisor: Zoe Jastreb
//Corrrección: Muy bien dani.
// Escribe un programa que pida una fecha (día, mes y año) y diga si es correcta.
// ################################################################################
// Análisis
// Entradas: día, mes y año
// Salidas: texto que indique si es correcta la fecha
// Variables: las 3 variables para la fecha
// ################################################################################
// Diseño
// Pido dia mes año
// ################################################################################
Proceso Tarea2_Ej5
	Definir day, month, year Como Entero;
	Escribir 'Introduce dia';
	Leer day;
	Escribir 'Introduce mes';
	Leer month;
	Escribir 'Introduce año';
	Leer year;
	Definir bisiesto, fechaCorrecta Como Logico;
	
	bisiesto:=Falso;
	Si year MOD 4=0 Entonces
		bisiesto:=Verdadero;
	FinSi
	Si year MOD 100=0 Entonces
		bisiesto:=Falso;
	FinSi
	Si year MOD 400=0 Entonces
		bisiesto:=Verdadero;
	FinSi
	
	fechaCorrecta:=Verdadero;
	Segun month Hacer
		1,3,5,7,8,10,12:
			Si day<1 O day>31 Entonces
				fechaCorrecta:=Falso;
			FinSi
		4,6,9,11:
			Si day<1 O day>30 Entonces
				fechaCorrecta:=Falso;
			FinSi
		2:
			Si bisiesto Entonces
				Si day<1 O day>29 Entonces
					fechaCorrecta:=Falso;
				FinSi
			SiNo
				Si day<1 O day>28 Entonces
					fechaCorrecta:=Falso;
				FinSi
			FinSi
		DeOtroModo:
			fechaCorrecta:=Falso;
	FinSegun
	
	Si fechaCorrecta Entonces
		Escribir "fecha correcta";
	SiNo
		Escribir "fecha incorrecta";
	FinSi
FinProceso
