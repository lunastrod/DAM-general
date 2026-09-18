import java.util.ArrayList;

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
		// TODO:
		
		return null;
	}
}
