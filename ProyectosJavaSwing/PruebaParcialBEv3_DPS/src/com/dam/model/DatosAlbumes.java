package com.dam.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class DatosAlbumes {
	
	private ArrayList<Album> listaAlbumes;
	
	public DatosAlbumes() {
		listaAlbumes = new ArrayList<Album>();
		cargaInicial();
	}
	
	private void cargaInicial() {
		listaAlbumes.add(new Album("Thriller", "Michael Jackson", 1982, "Pop", 70));
		listaAlbumes.add(new Album("Back in Black", "AC/DC", 1980, "Rock", 50));
		listaAlbumes.add(new Album("The Dark Side of the Moon", "Pink Floyd", 1973, "Rock progresivo", 45));
		listaAlbumes.add(new Album("Bad", "Michael Jackson", 1987, "Pop", 45));
		listaAlbumes.add(new Album("The Bodyguard (B.S.O.)", "Whitney Houston", 1992, "Pop / Soul", 45));
		listaAlbumes.add(new Album("Bat Out of Hell", "Meat Loaf", 1977, "Rock", 43));
		listaAlbumes.add(new Album("Their Greatest Hits (1971–1975)", "Eagles", 1976, "Rock", 42));
		listaAlbumes.add(new Album("Hotel California", "Eagles", 1976, "Rock", 42));
		listaAlbumes.add(new Album("Saturday Night Fever (B.S.O.)", "Bee Gees / Varios", 1977, "Disco", 40));
		listaAlbumes.add(new Album("Rumours", "Fleetwood Mac", 1977, "Rock", 40));
		listaAlbumes.add(new Album("Come On Over", "Shania Twain", 1997, "Country pop", 40));
		listaAlbumes.add(new Album("Millennium", "Backstreet Boys", 1999, "Pop", 40));
		listaAlbumes.add(new Album("Led Zeppelin IV", "Led Zeppelin", 1971, "Hard rock", 37));
		listaAlbumes.add(new Album("The Wall", "Pink Floyd", 1979, "Rock progresivo", 33));
		listaAlbumes.add(new Album("Metallica (Black Album)", "Metallica", 1991, "Heavy metal", 33));
		listaAlbumes.add(new Album("Jagged Little Pill", "Alanis Morissette", 1995, "Rock alternativo", 33));
		listaAlbumes.add(new Album("Gold: Greatest Hits", "ABBA", 1992, "Pop", 32));
		listaAlbumes.add(new Album("Falling Into You", "Céline Dion", 1996, "Pop", 32));
		listaAlbumes.add(new Album("The Marshall Mathers LP", "Eminem", 2000, "Hip‑hop", 32));
		listaAlbumes.add(new Album("1", "The Beatles", 2000, "Rock", 32));
		
	}

	public void addAlbum(Album al) {
		listaAlbumes.add(al);
	}

	public ArrayList<Album> getListaAlbumes() {
		return listaAlbumes;
	}
	
	public String realizarAnalisis() {
		int mas40M=0;
		String tituloMasLargo="";
		Album a;

		HashMap<String,Integer> generos=new HashMap<>();
		String clave;
		int valor;
		for (int i=0; i<listaAlbumes.size();i++) {
			a=listaAlbumes.get(i);
			if(a.getMillonesCopias()>40){
				mas40M++;
			}
			if(tituloMasLargo.length()<=a.getTitulo().length()){
				tituloMasLargo=a.getTitulo();
			}
			clave=a.getGenero();
			if(generos.containsKey(clave)){
				valor=generos.get(clave);
				generos.put(clave,valor+1);
			}
			else{
				generos.put(clave,1);
			}
		}

		StringBuilder sb=new StringBuilder();
		sb.append("Número de álbumes por género:\n");
		for (Entry<String,Integer> e:generos.entrySet()){
			sb.append(e.getKey()).append(": ").append(e.getValue());
			sb.append("\n");
		}
		sb.append("\n");
		sb.append(mas40M).append(" álbumes han vendido más de 40M de copias\n");
		sb.append("El álbum con el título más largo es ").append(tituloMasLargo);
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("#RANKING ÁLBUMES\n\n");
		for (int i=0; i<listaAlbumes.size();i++) {
			sb.append(i+1).append(". ");
			sb.append(listaAlbumes.get(i)).append("\n\n");
		}
		return sb.toString();
	}
}
