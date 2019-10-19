package predef;

import java.util.ArrayList;

import kerbonautas.planetaryplaygroundservices.Estrella;
import kerbonautas.planetaryplaygroundservices.Planeta;
import kerbonautas.planetaryplaygroundservices.SistemaEstelar;
import kerbonautas.planetaryplaygroundservices.StarVariables;

public class PredefSystem{
	private static SistemaEstelar SE;

	public static SistemaEstelar getSolarSystem(String solar) {
		switch(solar) {
		case "SUN": homeSistem();
		case "PROXIMA": break;
		}
		return SE;
	}
	public static SistemaEstelar homeSistem() {
		Float f=null;
		Estrella star = new Estrella(StarVariables.Secuencia.SECUENCIAP, StarVariables.TipoEspectral.G, 1.0d, f);
		SE = new SistemaEstelar(star,new ArrayList<Planeta>());
		Planeta mer =  new Planeta(2439, 440d, 0, true, StarVariables.masaPlaneta(3.2d, 23), false, "Mercurio", 0);
		Planeta ven =  new Planeta(6051, 722.15d, 0, true, StarVariables.masaPlaneta(4.87d, 24), true, "Venus", 0);
		Planeta tie =  new Planeta(6371, 280.2d, 0, true, StarVariables.masaPlaneta(5.9d, 24), true, "Tierra", 0);
		Planeta mar =  new Planeta(3389, 227, 0, true, StarVariables.masaPlaneta(6.42d, 23), true, "Marte", 0);
		Planeta jup =  new Planeta(69911, 120d, 0, false, StarVariables.masaPlaneta(1.9d, 27), true, "Jupiter", 0);
		Planeta sat =  new Planeta(58232, 89d, 0, false, StarVariables.masaPlaneta(5.68d, 26), true, "Saturno", 0);
		Planeta nep =  new Planeta(24622, 89d, 0, false, StarVariables.masaPlaneta(8.68d, 25), true, "Neptuno", 0);
		Planeta ura =  new Planeta(25362, 50.15d, 0, false, StarVariables.masaPlaneta(1.02d, 26), true, "Urano", 0);
		SE.addPlanet(mer);
		SE.addPlanet(ven);
		SE.addPlanet(tie);
		SE.addPlanet(mar);
		SE.addPlanet(jup);
		SE.addPlanet(sat);
		SE.addPlanet(nep);
		SE.addPlanet(ura);
		return SE;
	}
	
}
