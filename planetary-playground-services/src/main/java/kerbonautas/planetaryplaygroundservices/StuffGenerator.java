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
	
	public static Planeta generarPlanetaRandom(int secuencia, String tipoEspectral, double radioEstrella, double masaEstrella) {
		boolean auxEsTerrestre = esTerrestre(secuencia, tipoEspectral);
		double auxDistanciaEstrella = distanciaEstrella(auxEsTerrestre, radioEstrella, masaEstrella);
		double auxPeriodoOrbital = periodoOrbital(masaEstrella, auxDistanciaEstrella);
		int auxRadio = radio(auxEsTerrestre);
		return null;
	}
	
	public static boolean esTerrestre (int auxSecuencia, String auxTipoEspectral) {
		boolean auxEsTerrestre = false;
		String codigo = auxTipoEspectral + auxSecuencia;
		if(codigo.contains("1") && Math.random() > 0.9) auxEsTerrestre = true;
		else if (codigo.contains("3") && Math.random() > 0.8) auxEsTerrestre = true;
		else if ((codigo.equals("5O") || codigo.equals("5B")) && Math.random() > 0.85) auxEsTerrestre = true;
		else if ((codigo.equals("5A") || codigo.equals("5F")) && Math.random() > 0.65) auxEsTerrestre = true;
		else if (codigo.equals("5M") && Math.random() > 0.20) auxEsTerrestre = true;
		return auxEsTerrestre;
	}
	
	public static double distanciaEstrella(boolean auxEsTerrestre, double auxRadioEstrella, double auxMasaEstrella) {
		double auxDistanciaEstrella = 0;
		double distanciaMinima = auxRadioEstrella * 32;
		double distanciaMaxima = Math.pow(auxMasaEstrella, 2/3) * 50;
		double distanciaFactible = distanciaMaxima - distanciaMinima;
		if(auxEsTerrestre) {
			auxDistanciaEstrella = (Math.random() + 0.00000001) * distanciaFactible + distanciaMinima;
		} else {
			auxDistanciaEstrella = Math.random();
			if (auxDistanciaEstrella < 0.1) auxDistanciaEstrella = (auxDistanciaEstrella + 0.00000001) * distanciaFactible + distanciaMinima;
			else {
				if (auxDistanciaEstrella > 0.1 && auxDistanciaEstrella < 0.3) {
					auxDistanciaEstrella = (auxDistanciaEstrella + 0.00000001) * distanciaFactible + distanciaMinima + (0.3 * distanciaFactible);
				} else {
					auxDistanciaEstrella = (auxDistanciaEstrella + 0.00000001) * distanciaFactible + distanciaMinima;
				}
			}
		}
		return auxDistanciaEstrella;
	}
	
	public static double periodoOrbital(double auxMasaEstrella, double auxDistanciaSol) {
		double auxPeriodoOrbital = 0;
		int segundosDia = 86400;
		double constanteGravitacionUniversal = 8.874 * Math.pow(10, 26);
		auxPeriodoOrbital = 4 * Math.pow(Math.PI, 2) * Math.pow(auxDistanciaSol, 3);
		auxPeriodoOrbital = auxPeriodoOrbital / (constanteGravitacionUniversal * auxMasaEstrella);
		auxPeriodoOrbital = Math.sqrt(auxPeriodoOrbital) / segundosDia;
		return auxPeriodoOrbital;
	}
	
	public static int radio(boolean auxEsTerrestre) {
		int auxRadio = 0;
		int radioJupiter = 69911;
		double radioMinimo = 1200;
		if (auxEsTerrestre) {
			auxRadio = (int) ((Math.random() + 0.00000001) * (radioJupiter - radioMinimo) + radioMinimo);
		} else {
			auxRadio = (int) (((Math.random() * 14) + 1.00000001) * (radioJupiter - radioMinimo) + radioMinimo);
		}
		return auxRadio;
	}
	
	public static double duracionDia() {
		double auxDuracionDinero = 0;
		double duracionMinima = 0.1;
		return auxDuracionDinero;
	}
	
	public static double masa(boolean auxEsTerrestre) {
		double auxMasa = 0;
		return auxMasa;
	}
	
	public static double campoMagnetico(boolean ausExTerrestre) {
		double auxCampoMagnetico = 0;
		return auxCampoMagnetico;
	}
	
	public static boolean tieneAtmosfera(double auxCampoMagnetico) {
		boolean auxTieneAtmosfera = false;
		return auxTieneAtmosfera;
	}
	
	public static double presionAtmosferica(boolean auxTieneAtmosfera) {
		double auxPresionAtmosferica = 0;
		return auxPresionAtmosferica;
	}
	
	public static double temperaturaSuperficial(double auxDistanciaEstrella) {
		double auxTemperaturaSuperficial = 0;
		return auxTemperaturaSuperficial;
	}
}
