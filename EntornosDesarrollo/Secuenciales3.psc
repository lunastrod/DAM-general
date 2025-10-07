//################################################################################
//@autor: Daniel Parra Segovia
//Un ciclista parte de una ciudad A a las HH horas, MM minutos y SS segundos.
//El tiempo de viaje hasta llegar a otra ciudad B es de T segundos.
//Escribir un algoritmo que determine la hora de llegada a la ciudad B.
//################################################################################
//Análisis
//Entradas: hora actual y segundos de viaje
//Salidas: hora de llegada
//Variables: variables para hora actual, segundos de viaje, segundos de hora actual y variables para hora de llegada
//################################################################################
//Diseño
//Declaro variables
//Leo hora actual y segundos de viaje
//calculo segundos de hora actual
//sumo segundos de viaje a segundos actual para calcular segundos total
//calculo hora minuto segundo de llegada usando divisiones y restos de división
//Imprimo el total
//################################################################################

Proceso Secuenciales3
	//Declaro variables
	Definir actualH, actualM, actualS Como Entero;
	Definir llegadaH, llegadaM, llegadaS Como Entero;
	Definir segundosActual, segundosViaje Como Entero;
	Definir segundosTotal, minutosTotal, horasTotal Como Entero;
	//Leo hora actual y segundos de viaje
	Escribir "Hora actual";
	Leer actualH;
	Escribir "Minuto actual";
	Leer actualM;
	Escribir "Segundo actual";
	Leer actualS;
	Escribir "Segundos viaje";
	Leer segundosViaje;
	
	//sumo segundos de viaje a segundos actual para calcular segundos total
	segundosActual:=actualH*3600+actualM*60+actualS;
	segundosTotal:=segundosActual+segundosViaje;
	
	//calculo hora minuto segundo de llegada usando divisiones y restos de división
	llegadaS:=segundosTotal MOD 60;
	
	minutosTotal:=trunc(segundosTotal/60);
	llegadaM:=minutosTotal MOD 60;
	
	horasTotal:=trunc(minutosTotal/60);
	llegadaH:=horasTotal MOD 24;
	
	//Imprimo el total
	Escribir "Hora de llegada: ",llegadaH,"h ",llegadaM,"m ",llegadaS,"s ";
FinProceso
