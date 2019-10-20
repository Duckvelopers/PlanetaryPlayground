package kerbonautas.planetaryplaygroundservices;

import java.util.ArrayList;
import java.util.Map;

public class StuffGenerator {

	private static String[] letter = new String[] { "b", "c", "d", "e", "f", "g", "h" };

	public static SistemaEstelar generarSistemaRandom(int secuencia, String espectral, double masa, double radio) {
		Estrella star = new Estrella(secuencia, espectral, masa, radio);
		ArrayList<Planeta> arrPlanets = new ArrayList<Planeta>();
		int numPlanetas = ((int) (Math.random() * 6)) + 1;
		String starName = star.getName().substring(0, star.getName().length() - 1);
		for (int i = 0; i < numPlanetas; i++) {
			arrPlanets.add(generarPlanetaRandom(secuencia, espectral, star.getRadio(), star.getMasa(), star.getTemperatura(), star.getLuminosidad(), starName + letter[i]));
		}
		SistemaEstelar se = new SistemaEstelar(star, arrPlanets);
		return se;
	}

	public static Estrella generarEstrella(Map<String, Object> map) {
		int secuencia = Integer.parseInt(map.get(StarVariables.llamadas.SEQUENCE).toString());
		String espectral = map.get(StarVariables.llamadas.CLASS).toString();
		double mass = Double.parseDouble(map.get(StarVariables.llamadas.MASS).toString());
		double radius = Double.parseDouble(map.get(StarVariables.llamadas.RADIUS).toString());
		Estrella star = new Estrella(secuencia, espectral, mass, radius);
		return star;
	}

	public static Planeta generarPlanetaRandom(int secuencia, String tipoEspectral, double radioEstrella,
			double masaEstrella, double temperaturaEstrella, double luminosidadEstrella, String nombre) {
		boolean auxEsTerrestre = esTerrestre(secuencia, tipoEspectral);
		double auxDistanciaEstrella = distanciaEstrella(auxEsTerrestre, radioEstrella, masaEstrella);
		double auxPeriodoOrbital = periodoOrbital(masaEstrella, auxDistanciaEstrella);
		int auxRadio = radio(auxEsTerrestre);
		double auxDuracionDia = duracionDia(auxPeriodoOrbital);
		double auxMasa = masa(auxEsTerrestre, secuencia);
		double auxCampoMagnetico = campoMagnetico(auxEsTerrestre, auxMasa);
		boolean auxTieneAtmosfera = tieneAtmosfera(auxCampoMagnetico);
		double auxPresionAtmosferica = presionAtmosferica(auxTieneAtmosfera);
		double auxTemperaturaSuperficial = temperaturaSuperficial(auxDistanciaEstrella, temperaturaEstrella, luminosidadEstrella);
		Planeta planet = new Planeta(auxRadio, auxTemperaturaSuperficial, auxEsTerrestre, auxMasa, auxTieneAtmosfera,
				nombre, auxPresionAtmosferica, auxCampoMagnetico, auxDistanciaEstrella, auxPeriodoOrbital,
				auxDuracionDia);
		return planet;
	}

	public static boolean esTerrestre(int auxSecuencia, String auxTipoEspectral) {
		boolean auxEsTerrestre = false;
		String codigo = auxSecuencia + auxTipoEspectral;
		if (codigo.contains("1") && Math.random() > 0.9)
			auxEsTerrestre = true;
		else if (codigo.contains("3") && Math.random() > 0.8)
			auxEsTerrestre = true;
		else if ((codigo.equals("5O") || codigo.equals("5B")) && Math.random() > 0.85)
			auxEsTerrestre = true;
		else if ((codigo.equals("5A") || codigo.equals("5F")) && Math.random() > 0.65)
			auxEsTerrestre = true;
		else if ((codigo.equals("5G") || codigo.equals("5K")) && Math.random() > 0.5) 
				auxEsTerrestre = true;
		else if (codigo.equals("5M") && Math.random() > 0.20)
			auxEsTerrestre = true;
		return auxEsTerrestre;
	}

	public static double distanciaEstrella(boolean auxEsTerrestre, double auxRadioEstrella, double auxMasaEstrella) {
		double auxDistanciaEstrella = 0;
		double distanciaMinima = auxRadioEstrella * 32;
		double distanciaMaxima = Math.pow(auxMasaEstrella, 2 / 3) * 50;
		double distanciaFactible = distanciaMaxima - distanciaMinima;
		if (auxEsTerrestre) {
			auxDistanciaEstrella = Math.random() * distanciaFactible + distanciaMinima;
		} else {
			double variableRandom = Math.random();
			if (variableRandom < 0.1)
				auxDistanciaEstrella = auxDistanciaEstrella * distanciaFactible + distanciaMinima;
			else {
				if (variableRandom > 0.1 && variableRandom < 0.3) {
					auxDistanciaEstrella = auxDistanciaEstrella * distanciaFactible + distanciaMinima
							+ (0.3 * distanciaFactible);
				} else {
					auxDistanciaEstrella = auxDistanciaEstrella * distanciaFactible + distanciaMinima;
				}
			}
		}
		return auxDistanciaEstrella;
	}

	public static double periodoOrbital(double auxMasaEstrella, double auxDistanciaSol) {
		double auxPeriodoOrbital = 0;
		int segundosDia = 86400;
		double constanteGravitacionUniversal = 6.674 * Math.pow(10, -11);
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
			auxRadio = (int) (Math.random() * (radioJupiter - radioMinimo) + radioMinimo);
		} else {
			auxRadio = (int) (((Math.random() * 14) + 1) * (radioJupiter - radioMinimo) + (radioJupiter / 2));
		}
		return auxRadio;
	}

	public static double duracionDia(double auxPeriodoOrbital) {
		double auxDuracionDia = 0;
		auxDuracionDia = Math.random() * (auxPeriodoOrbital - 0.1) + 0.1;
		if (Math.random() < 0.05) {
			auxDuracionDia = -auxDuracionDia;
		}
		return auxDuracionDia;
	}

	public static double masa(boolean auxEsTerrestre, int auxSecuencia) {
		double auxMasa = 0;
		double masaMinima = 0;
		double masaMaximo = 0;
		if (!auxEsTerrestre) {
			if (auxSecuencia == 1 || auxSecuencia == 3) {
				masaMinima = (1.9 * Math.pow(10, 27)) / 2;
				masaMaximo = (1.9 * Math.pow(10, 27)) * 15;
				auxMasa = Math.random() * (masaMaximo - masaMinima) + masaMinima;
			} else {
				masaMinima = (5.9 * Math.pow(10, 24)) * 5;
				masaMaximo = (1.9 * Math.pow(10, 27)) * 2;
				auxMasa = Math.random() * (masaMaximo - masaMinima) + masaMinima;
			}
		} else {
			masaMinima = (5.9 * Math.pow(10, 24)) * 0.05;
			masaMaximo = (5.9 * Math.pow(10, 24)) * 10;
			auxMasa = Math.random() * (masaMaximo - masaMinima) + masaMinima;
		}

		return auxMasa;
	}

	public static double campoMagnetico(boolean auxEsTerrestre, double auxMasa) {
		double auxCampoMagnetico = 0;
		double campoMagneticoMinimo = 15;
		double campoMagneticoMaximo = 350;
		if (auxEsTerrestre) {
			double variableRandom = Math.random();
			if (variableRandom > 0.2 && auxMasa > (5 * Math.pow(10, 24))) {
				auxCampoMagnetico = Math.random() * (campoMagneticoMaximo - campoMagneticoMinimo)
						+ campoMagneticoMinimo;
			} else if (variableRandom > 0.6 && auxMasa > (5 * Math.pow(10, 23))) {
				auxCampoMagnetico = Math.random() * (campoMagneticoMaximo - campoMagneticoMinimo)
						+ campoMagneticoMinimo;
			}
		} else {
			auxCampoMagnetico = Math.random() * (campoMagneticoMaximo - campoMagneticoMinimo) + campoMagneticoMinimo;
		}
		return auxCampoMagnetico;
	}

	public static boolean tieneAtmosfera(double auxCampoMagnetico) {
		boolean auxTieneAtmosfera = false;
		double variableRandom = Math.random();
		if (auxCampoMagnetico > 0 && variableRandom > 0.1)
			auxTieneAtmosfera = true;
		else if (auxCampoMagnetico == 0 && variableRandom <= 0.1)
			auxTieneAtmosfera = true;
		return auxTieneAtmosfera;
	}

	public static double presionAtmosferica(boolean auxTieneAtmosfera) {
		double auxPresionAtmosferica = 0;
		if (auxTieneAtmosfera) {
			double variableRandom = Math.random();
			if (variableRandom > 0.9)
				auxPresionAtmosferica = (variableRandom * 149) + 1;
			else
				auxPresionAtmosferica = (variableRandom * 149) + 0.5;
		} else {
			auxPresionAtmosferica = 0.001;
		}
		return auxPresionAtmosferica;
	}

	public static double temperaturaSuperficial(double auxDistanciaEstrella, double auxTemperaturaEstrella, double auxLuminosidadEstrella) {
		double auxTemperaturaSuperficial = 0;
		double limiteInferior = (0.72 - ((2.7619 * Math.pow(10, -5)) * (auxTemperaturaEstrella - 5700)) - ((3.8095 * Math.pow(10, -9)) * Math.pow((auxTemperaturaEstrella - 5700), 2))) * Math.sqrt(auxLuminosidadEstrella);
		double limiteSuperior = (1.77 - ((1.3786 * Math.pow(10, -4)) * (auxTemperaturaEstrella - 5700)) - ((1.4286 * Math.pow(10, -9)) * Math.pow((auxTemperaturaEstrella - 5700), 2))) * Math.sqrt(auxLuminosidadEstrella);
		double variableRandom = Math.random();
		if(auxDistanciaEstrella > limiteInferior && auxDistanciaEstrella < limiteSuperior) {
			auxTemperaturaSuperficial = (variableRandom * 155) + 245;
		} else if(auxDistanciaEstrella < limiteInferior) {
			auxTemperaturaSuperficial = (variableRandom * 250) + 350;
		} else {
			auxTemperaturaSuperficial = (variableRandom * 170) + 100;
		}
		return auxTemperaturaSuperficial;
	}
}
