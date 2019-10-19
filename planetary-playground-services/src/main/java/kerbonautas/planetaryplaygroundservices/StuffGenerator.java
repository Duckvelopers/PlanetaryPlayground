package kerbonautas.planetaryplaygroundservices;

import java.util.Map;

public class StuffGenerator {
	public static Estrella generarEstrella(Map<String, Object> map) {
		int secuencia = Integer.parseInt(map.get("SEQUENCE").toString());
		String espectral = map.get("CLASS").toString();
		double mass = Double.parseDouble(map.get("MASS").toString());
		double radius = Double.parseDouble(map.get("RADIUS").toString());
		Estrella star = new Estrella(secuencia, espectral, mass, radius);
		return star;
	}
	public static Planeta generarPlanetaRandom() {
		//TODO haz tu puto trabajo Carlos!!!
		return null;
	}
}
