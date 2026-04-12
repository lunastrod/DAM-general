package com.dam.model;

public class Encuesta {
	
	public static final String[] PREGUNTAS = {
			"Edad",
			"¿Ha pasado usted el COVID-19?",
			"¿Qué síntomas padeció?",
			"Nivel de gravedad:"
			};

	/*public static final String[][] RESPUESTAS_POSIBLES = {
			{""},
			{"SI", "NO"},
			{"Síntomas respiratorios", "Cansancio/Malestar", "Pérdida de olfato","Pérdida de gusto","Dolor de cabeza", "Fiebre", "Sin síntomas","Tos seca"},
			{"1 - Ninguna", "2 - Leve", "3 - Media", "4 - Alta", "5 - Hospitalización"}
			};*/
	
	public static final String[] POSIBLES_SINTOMAS = {
			"Síntomas respiratorios","Perdida del olfato", 
			"Dolor de cabeza", "Sin sintomas" ,
			"Cansancio/Malestar","Perdida del gusto", 
			"Fiebre","Tos seca"};

	public static final int[] NIVELES_DE_GRAVEDAD = {1,2,3,4,5};
	public static final String[] NIVELES_DE_GRAVEDAD_S = {
			"Ninguna", "Leve", "Media", "Alta", "Hospitalización"};

	public static final String[] HA_PASADO_COVID_RESP= {"SI", "NO"};

	//Atributos
	private int edad;
	private String haPasadoCovid;
	private String sintomas;
	private int nivelGravedad;
	
	public Encuesta(int edad, String haPasadoCovid, String sintomas, int nivelGravedad) {
		this.edad = edad;
		this.haPasadoCovid = haPasadoCovid;
		this.sintomas = sintomas;
		this.nivelGravedad = nivelGravedad;
	}

	@Override
	public String toString() {
		return PREGUNTAS[0] + ": " + edad + " años \n" 
				+ PREGUNTAS[1] + " " + haPasadoCovid + "\n" 
				+ PREGUNTAS[2] + " " + sintomas + "\n"
				+ PREGUNTAS[3] + ": " + NIVELES_DE_GRAVEDAD_S[nivelGravedad - 1];
	}
	
	

}
