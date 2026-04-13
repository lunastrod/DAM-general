package com.dam.model;

import java.util.ArrayList;

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
	

}
