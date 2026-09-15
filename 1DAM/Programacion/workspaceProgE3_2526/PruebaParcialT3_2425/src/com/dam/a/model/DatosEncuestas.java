package com.dam.a.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class DatosEncuestas {
	
	private ArrayList<Encuesta> listaEncuestas;
	
	public DatosEncuestas() {
		listaEncuestas = new ArrayList<Encuesta>();
	}
	
	public void addEncuesta(Encuesta en) {
		listaEncuestas.add(en);
	}

	public ArrayList<Encuesta> getListaEncuestas() {
		return listaEncuestas;
	}
	
	public String realizarAnalisis() {
		String analisis = "";
		
		HashMap<String, Integer> contadorRangos = new HashMap<String, Integer>();
		for (String rango : Encuesta.RANGOS_EDAD) {
			contadorRangos.put(rango, 0);
		}
		
		HashMap<String, Integer> contadorFrec = new HashMap<String, Integer>();
		for (String frec : Encuesta.FRECUENCIAS) {
			contadorFrec.put(frec, 0);
		}
		
		HashMap<String, Integer> contadorSeries = new HashMap<String, Integer>();
		for (String serie : Encuesta.SERIES) {
			contadorSeries.put(serie, 0);
		}
		
		for (Encuesta encuesta : listaEncuestas) {
			contadorRangos.put(encuesta.getRangoEdad(), contadorRangos.get(encuesta.getRangoEdad()) + 1);
			
			contadorFrec.put(encuesta.getFrecuencia(), contadorFrec.get(encuesta.getFrecuencia()) + 1);
			
			for (String serie : encuesta.getListaSeriesVistas()) {
				contadorSeries.put(serie, contadorSeries.get(serie) + 1);
			}
		}
		
		analisis += "Encuestados por rango: \n";
		for (Entry<String, Integer> entry : contadorRangos.entrySet()) {
			analisis += "\t" + entry.getKey() + " - " + entry.getValue() + " encuestados\n";
		}
		
		analisis += "\nFrecuencia más usada: ";
		String frecMU = "";
		int mayorFrec = -1;
		for (Entry<String, Integer> entry : contadorFrec.entrySet()) {
			if (entry.getValue() > mayorFrec) {
				frecMU = entry.getKey();
				mayorFrec = entry.getValue();
			}
		}
		analisis += frecMU;
		
		analisis += "\n\nSerie más vista: ";
		String serieMV = "";
		int mayorVis = -1;
		for (Entry<String, Integer> entry : contadorSeries.entrySet()) {
			if (entry.getValue() > mayorVis) {
				serieMV = entry.getKey();
				mayorVis = entry.getValue();
			}
		}
		analisis += serieMV;
		
		return analisis;
	}

}
