package kerbonautas.planetaryplaygroundservices;

import java.util.ArrayList;

public class SistemaEstelar {
	public Estrella star;
	public ArrayList<Planeta> ArrayPlanets;
	
	public SistemaEstelar(Estrella star, ArrayList<Planeta> arrayPlanets) {
		this.star = star;
		ArrayPlanets = arrayPlanets;
	}

	public Estrella getStar() {
		return star;
	}

	public void setStar(Estrella star) {
		this.star = star;
	}
	
	public void addPlanet(Planeta p) {
		ArrayPlanets.add(p);
	}
}
