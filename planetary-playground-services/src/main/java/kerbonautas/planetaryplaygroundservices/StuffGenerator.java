package kerbonautas.planetaryplaygroundservices;

import java.util.Map;

public class StuffGenerator {
	public static Estrella generarEstrella(Map<String, Object> map) {
		int secuencia = Integer.parseInt(map.get(StarVariables.llamadas.SEQUENCE).toString());
		String espectral = map.get(StarVariables.llamadas.CLASS).toString();
		double mass = Double.parseDouble(map.get(StarVariables.llamadas.MASS).toString());
		double radius = Double.parseDouble(map.get(StarVariables.llamadas.RADIUS).toString());
		Estrella star = new Estrella(secuencia, espectral, mass, radius);
		return star;
	}
	public static Planeta generarPlanetaRandom() {
		//TODO haz tu puto trabajo Carlos!!!
		return null;
	}
}
