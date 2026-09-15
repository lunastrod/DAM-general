// // ################################################################################
// Análisis
// Necesito generar un número aleatorio, lo guardo en variable entera
// Necesito un contador de 0 a 10, voy a crear 2 variables enteras,
//		el contador y una que actúe como constante para guardar el máximo de intentos
// Necesito una variable entera para guardar el número del usuario
// Mientras que mi contador sea <10 o el número aún no se haya adivinado, pido números al usuario
// Necesito una variable true/false para guardar si el usuario ha adivinado el número y poder cortar el bucle
// Cuando haya leído el número del usuario tengo que comprobar si es mayor, menor o igual al numero aleatorio
// ################################################################################
// Diseño
// Mis variables son:
// 		contador de intentos: intentos
//		constante numero de intentos:intentosMax
//		guardar numero aleatorio:nAleatorio
//		guardar input de usuario: intentoUsuario
// 		boolean para terminar: adivinado
// Asigno valores a las que haga falta
// Bucle mientras con condición NO adivinado Y intentos<intentosMax
// 		incremento contador de intentos
// 		leo valor de usuario
//		compruebo si es mayor, menor o igual (Dos if anidados)
//	Escribo en función de si ha adivinado o no
// ################################################################################

Proceso Examen1
	Definir intentos,intentosMax,nAleatorio,intentoUsuario Como Entero;
	Definir adivinado Como Logico;
	
	intentos<-0;
	intentosMax<-10;
	nAleatorio<-Aleatorio(0,100);
	adivinado<-Falso;
	
	Escribir "Intenta adivinar un número aleatorio entre 0 y 100";
	Mientras NO adivinado Y intentos<intentosMax Hacer
		intentos<-intentos+1;
		Escribir "Intento ",intentos;
		Escribir "Escribe un numero";
		Leer intentoUsuario;
		Si intentoUsuario=nAleatorio Entonces
			adivinado<-Verdadero;
		SiNo
			Si nAleatorio>intentoUsuario Entonces
				Escribir "El número aleatorio es mayor";
			SiNo
				Escribir "El número aleatorio es menor";
			FinSi
		FinSi
	FinMientras
	
	Si adivinado Entonces
		Escribir "¡Has adivinado el número!";
	SiNo
		Escribir "Has superado ",intentosMax," intentos, el número era ", nAleatorio;
	FinSi
	
FinProceso