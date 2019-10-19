package kerbonautas.planetaryplaygroundservices;

public class IngDefs {

	// Precisa que se le envia el booleano de si el planeta es gaseoso o no
	public static String explicacionDistancia(Boolean i) {
		StringBuilder str = new StringBuilder();
		if (i) {
			str.append("Gaseous planets are usually in regions far from their star. \n \n");
			str.append("A gaseous planet could be near the star because: \n");
			str.append("-a giant star that has evolved from the main sequence and has approached during its evolution the planet gas that was far away \n");
			str.append("-the planet was far away but gravitationally interacting with another planet catapulted it to a nearby orbit \n");
			str.append("-It was a wandering planet that was captured by the star's orbit");
		} else {
			str.append("Terrestrial planets are usually in regions near their star. \n \n");
			str.append("A terrestrial planet could be far from the star and / or in orbit of a supergiant or giant because: \n");
			str.append("-a star to evolve a giant destroyed the atmosphere of a gaseous planet and survived its terrestrial nucleus \n");
			str.append("-the planet was close but gravitationally interacting with another planet catapulted it to a distant orbit \n");
			str.append("-It was a wandering planet that was captured by the star's orbit");
		}
		
		return str.toString();
	}

	// Precisa que se le envia el booleano de si el planeta es gaseoso o no
	public static String explicacionGaseosoONo(Boolean i) {
		StringBuilder str = new StringBuilder();
		
		if (i) {
			str.append("The gaseous planets are formed by a large number of substances that under normal conditions are gaseous and in addition, we call them that because their outer appearance is that of a sea of clouds.\n");
			str.append("It is not known with certainty, but it is suspected that they have a solid core and between it and the clouds, liquid oceans.");
		} else {
			str.append("The terrestrial planets are mostly made up of substances that are not solid in normal conditions.\n");
			str.append("Their surfaces are usually solid and can be covered with liquid oceans and layers of gases that we call atmosphere.");
		}
		
		return str.toString();
	}
	
	// Precisa que se le envia el booleano de si el planeta es gaseoso o no
	public static String explicacionTamanho(Boolean i) {
		StringBuilder str = new StringBuilder();
		
		str.append("The reference size that is usually used, is in reference to Jupiter, talking about super Jupiters when they are many times larger.\n");
		
		if (i) {
			str.append("Gaseous planets tend to have a large size (several times the size of planet Earth) in part because of being gassed, their atmosphere extends over a much larger region. \n");
		} else {
			str.append("The terrestrial planets are very varied, being able to have the size of the planet Earth, several times less (Mercury) or tens of times greater (Supertierras). \n");
		}
		
		return str.toString();
	}
	
	public static String explicacionTemperatura() {
		StringBuilder str = new StringBuilder();
		
		str.append("The temperature of the planets depends on numerous factors, mainly on:\n");
		str.append("-star distance (hotter when closer)\n");
		str.append("-presence of atmosphere with greenhouse gases\n");
		
		return str.toString();
	}
	
	public static String explicacionMasa() {
		StringBuilder str = new StringBuilder();
		
		str.append("");
		
		return str.toString();
	}
	
	// Precisa que se le envie el booleano de si tiene o no atmósfera
	public static String explicacionTieneAtmosfera(Boolean i) {
		StringBuilder str = new StringBuilder();
		
		if (i) {
			str.append("");
		} else {
			str.append("");
		}
		
		return str.toString();
	}
	
	public static String explicacionNombre() {
		StringBuilder str = new StringBuilder();
		
		str.append("");
		
		return str.toString();
	}
	
	public static String explicacionPresion() {
		StringBuilder str = new StringBuilder();
		
		str.append("");
		
		return str.toString();
	}
	
	public static String explicacionCampoMagnetico() {
		StringBuilder str = new StringBuilder();
		
		str.append("");
		
		return str.toString();
	}
	
	public static String explicacionDistanciaAEstrella() {
		StringBuilder str = new StringBuilder();
		
		str.append("");
		
		return str.toString();
	}
	
	public static String explicacionPeriodoOrbital() {
		StringBuilder str = new StringBuilder();
		
		str.append("");
		
		return str.toString();
	}
	
	public static String explicacionDuracionDia() {
		StringBuilder str = new StringBuilder();
		
		str.append("");
		
		return str.toString();
	}
}

