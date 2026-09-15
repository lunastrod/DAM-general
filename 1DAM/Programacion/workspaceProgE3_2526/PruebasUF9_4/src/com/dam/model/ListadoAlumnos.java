package com.dam.model;

import java.util.ArrayList;

public class ListadoAlumnos {
	
	private ArrayList<Alumno> listaAlumnos;

	public ListadoAlumnos() {
		listaAlumnos = new ArrayList<Alumno>();
		rellenarLista();
	}

	private void rellenarLista() {
		listaAlumnos.add(new Alumno("Jorge", "García Pérez", "12345678Z", 20));
		listaAlumnos.add(new Alumno("Fernando", "García Pérez", "12345679P", 21));
		listaAlumnos.add(new Alumno("Sara", "García Pérez", "22345678B", 19));
		listaAlumnos.add(new Alumno("Ana", "García Pérez", "32345678R", 20));
		listaAlumnos.add(new Alumno("Juan", "García Pérez", "42345678Z", 20));
		listaAlumnos.add(new Alumno("Pedro", "García Pérez", "52345679P", 21));
		listaAlumnos.add(new Alumno("Alicia", "García Pérez", "62345678B", 19));
		listaAlumnos.add(new Alumno("Carmen", "García Pérez", "72345678R", 20));
		
	}

	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}
	
	

}
