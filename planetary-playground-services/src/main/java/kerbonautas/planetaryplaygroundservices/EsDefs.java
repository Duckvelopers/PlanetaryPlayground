package kerbonautas.planetaryplaygroundservices;

public class EsDefs {

	// Precisa que se le envia el booleano de si el planeta es gaseoso o no
	public static String explicacionDistancia(Boolean i) {
		StringBuilder str = new StringBuilder();
		if (i) {
			str.append("Los planetas gaseosos suelen estar en regiones lejanas de su estrella. \n \n");
			str.append("Un planeta gaseoso podria estar cerca de la estrella porque: \n");
			str.append("-una estrella gigante que haya evolcionado de la secuencia principal y se haya acercado durante su evolucion al planeta gaseosso que estaba lejos \n");
			str.append("-el planeta estaba lejos pero al interactuar gravitatoriamente con otro planeta lo catapulto a una orbita cercana \n");
			str.append("-era un planeta errante que fue captado por la orbita de la estrella");
		} else {
			str.append("Los planetas terrestres suelen estar en regiones cercanas a su estrella. \n \n");
			str.append("Un planeta terrestre podria estar lejos de la estrella y/o en orbita de una supergigante o gigante porque: \n");
			str.append("-una estrella al evolucionar a gigante destruyo la atmosfera de un planeta gaseoso y sobrevivió su nucleo terrestre \n");
			str.append("-el planeta estaba cerca pero al interactuar gravitatoriamente con otro planeta lo catapulto a una orbita lejana \n");
			str.append("-era un planeta errante que fue captado por la orbita de la estrella");
		}
		
		return str.toString();
	}

	// Precisa que se le envia el booleano de si el planeta es gaseoso o no
	public static String explicacionGaseosoONo(Boolean i) {
		StringBuilder str = new StringBuilder();
		
		if (i) {
			str.append("Los planetas gaseoso están formados por una gran cantidad de sustancias que en condiciones normales son gaseosos y además, los llamamos así porque su aspecto exterior es el de un mar de nubes.\n");
			str.append("No se sabe con certeza, pero se sospecha que tienen un núcleo sólido y entre este y las nubes, océanos líquidos.");
		} else {
			str.append("Los planetas terrestres están formados en su mayoría por sustancias que ne condiciones normales son sólidos.\n");
			str.append("Sus superfecies suelen ser sólidas y pueden estar cubiertas de océanos líquidos y capas de gases que llamamos atmosfera.");
		}
		
		return str.toString();
	}
	
	// Precisa que se le envia el booleano de si el planeta es gaseoso o no
	public static String explicacionTamanho(Boolean i) {
		StringBuilder str = new StringBuilder();
		
		str.append("El tamaño de referencia que se suele emplear, es en referencia a Júpiter, hablando de súper Júpiters cuando son muchas veces más grandes. \n");
		
		if (i) {
			str.append("Los planetas gaseosos suelen tener un gran tamaño (varias veces el tamaño del planeta Tierra) en parte debido a que al estar echos de gases, su atmósfera se extiende en una región mucho mayor. \n");
		} else {
			str.append("Los planetas terrestres son muy variados, pudiendo tener el tamaño del planeta Tierra, varias veces menos (Mercurio) o decenas de veces mayor (Supertierras). \n");
		}
		
		return str.toString();
	}
	
	public static String explicacionTemperatura() {
		StringBuilder str = new StringBuilder();
		
		str.append("La temperatura de los planetas depende de numerosos factores, principalmente de:\n");
		str.append("-distancia a la estrella (más caliente cuando más cerca)\n");
		str.append("-presencia de atmósfera con gases invernadero\n");
		
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
	
	// Precia que se el envie el booleano de si tiene o no campo magnetico
	public static String explicacionCampoMagnetico(Boolean i) {
		StringBuilder str = new StringBuilder();
		
		if(i) {
			str.append("");
		} else {
			str.append("");
		}
		
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

