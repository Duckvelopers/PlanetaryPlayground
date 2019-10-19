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
		case "SUN": homeSistem();break;
		case "PROXIMA": proximaSystem();break;
		case "PEGASI": pegasiSistem();break;
		}
		return SE;
	}
	
	public static SistemaEstelar homeSistem() {
		Estrella star = new Estrella(StarVariables.Secuencia.SECUENCIAP, StarVariables.TipoEspectral.G, 1.0d, 0.0d);
		SE = new SistemaEstelar(star,new ArrayList<Planeta>());
		Planeta mer =  new Planeta(2439, 440d, true, StarVariables.masaPlaneta(3.2d, 23), false,
				StarVariables.nombrePlanetasSistemaSolar.MERCURIO, 0.0d,0.0d,0.387d,87.96d,58.7d);
		mer.setMachacaImagen("t1");
		Planeta ven =  new Planeta(6051, 722.15d, true, StarVariables.masaPlaneta(4.87d, 24), true,
				StarVariables.nombrePlanetasSistemaSolar.VENUS, 92.8d,0.0d,0.72d,224.701d,243.01d);
		ven.setMachacaImagen("t6");
		Planeta tie =  new Planeta(6371, 280.2d, true, StarVariables.masaPlaneta(5.9d, 24), true,
				StarVariables.nombrePlanetasSistemaSolar.TIERRA, 1.0d,30.5d,1.0d,365.25d,0.9972d);
		tie.setMachacaImagen("tierra");
		Planeta mar =  new Planeta(3389, 227, true, StarVariables.masaPlaneta(6.42d, 23), true,
				StarVariables.nombrePlanetasSistemaSolar.MARTE, 0.0079d,0.0d,1.523d,686.971d,1.025d);
		mar.setMachacaImagen("t3");
		Planeta jup =  new Planeta(69911, 120d, false, StarVariables.masaPlaneta(1.9d, 27), true,
				StarVariables.nombrePlanetasSistemaSolar.JUPITER, 0.0d,305d,5.2d,4330.045d,0.39d);
		jup.setMachacaImagen("g2");
		Planeta sat =  new Planeta(58232, 89d, false, StarVariables.masaPlaneta(5.68d, 26), true,
				StarVariables.nombrePlanetasSistemaSolar.SATURNO, 0.0d,101.6d,9.537d,10752.279d,0.43d);
		sat.setMachacaImagen("g4");
		Planeta ura =  new Planeta(25362, 50.15d, false, StarVariables.masaPlaneta(1.02d, 26), true,
				StarVariables.nombrePlanetasSistemaSolar.URANO, 0.0d,23.0d,19.19d,30799.095d,0.714d);
		ura.setMachacaImagen("g1");
		Planeta nep =  new Planeta(24622, 89d, false, StarVariables.masaPlaneta(8.68d, 25), true,
				StarVariables.nombrePlanetasSistemaSolar.NEPTUNO, 0.0d,14.0d,30.06d,60190.0d,0.671d);
		nep.setMachacaImagen("g6");
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
	
	public static SistemaEstelar proximaSystem() {
		Estrella star = new Estrella(StarVariables.Secuencia.SECUENCIAP, StarVariables.TipoEspectral.M, 0.1221d, 0.0d);
		SE = new SistemaEstelar(star,new ArrayList<Planeta>());
		Planeta pro =  new Planeta(2439, 234d, true, StarVariables.masaPlaneta(7.5d, 24), false,
				StarVariables.nombrePlanetasSistemaSolar.PROXIMAB, 0.0d,0.0d,0.05d,11.18d,0.0d);
		pro.setMachacaImagen("g3");
		SE.addPlanet(pro);
		return SE;
	}
	
	public static SistemaEstelar pegasiSistem() {
		Float f=null;
		Estrella star = new Estrella(StarVariables.Secuencia.SECUENCIAP, StarVariables.TipoEspectral.G, 1.11d, 0.0d);
		SE = new SistemaEstelar(star,new ArrayList<Planeta>());
		Planeta dim =  new Planeta(135830, 1284d, false, StarVariables.masaPlaneta(0.89d, 27), true,
				StarVariables.nombrePlanetasSistemaSolar.DIMIDIUM, 0.0d,0.0d,0.0527d,4.23d,0.0d);
		dim.setMachacaImagen("t6");
		SE.addPlanet(dim);
		return SE;
	}
}
