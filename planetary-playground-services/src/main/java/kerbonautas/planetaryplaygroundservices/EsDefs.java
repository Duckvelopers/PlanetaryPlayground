package kerbonautas.planetaryplaygroundservices;

public class EsDefs {

	// Precisa que se le envia el booleano de si el planeta es gaseoso o no
	public static String explicacionDistancia(Boolean i) {
		StringBuilder str = new StringBuilder();
		if (!i) {
			str.append("Los planetas gaseosos suelen estar en regiones lejanas de su estrella. \n \n");
			str.append("Un planeta gaseoso podria estar cerca de la estrella porque: \n");
			str.append("-una estrella gigante que haya evolcionado de la secuencia principal y se haya acercado durante su evolucion al planeta gaseosso que estaba lejos \n");
			str.append("-el planeta estaba lejos pero al interactuar gravitatoriamente con otro planeta lo catapulto a una orbita cercana \n");
			str.append("-era un planeta errante que fue captado por la gravedad de la estrella");
		} else {
			str.append("Los planetas terrestres suelen estar en regiones cercanas a su estrella. \n \n");
			str.append("Un planeta terrestre podria estar lejos de la estrella y/o en orbita de una supergigante o gigante porque: \n");
			str.append("-una estrella al evolucionar a gigante destruyo la atmosfera de un planeta gaseoso y sobrevivió su nucleo terrestre \n");
			str.append("-el planeta estaba cerca pero al interactuar gravitatoriamente con otro planeta lo catapulto a una orbita lejana \n");
			str.append("-era un planeta errante que fue captado por la gravedad de la estrella");
		}
		
		return str.toString();
	}

	// Precisa que se le envia el booleano de si el planeta es gaseoso o no
	public static String explicacionGaseosoONo(Boolean i) {
		StringBuilder str = new StringBuilder();
		
		if (!i) {
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
		
		if (!i) {
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
	
	// Precisa que se le envie el booleano de si es o no gaseoso
	public static String explicacionTieneAtmosfera(Boolean i) {
		StringBuilder str = new StringBuilder();
		
		if (!i) {
			str.append("Los planetas gaseosos tienen una atmósfera muy compleja y activa en su mayoría. Están cubiertos por nubes de gases de cientos de kilómetros de altura que dificultan obtener información del interior.");
		} else {
			str.append("Los planetas terrestres pueden estar rodeados de una capa de gases llamada atmósfera que puede variar mucho de unos planetas a otros y a lo largo de la vida del planeta.");
		}
		
		return str.toString();
	}
	
	public static String explicacionNombre() {
		StringBuilder str = new StringBuilder();
		
		str.append("Aunque algunos planetas tienen nombre propio (cono los del sistema solar), existe una forma sistemática de nombrar planetas extrasolares.\n");
		str.append("Se les nombra por el mismo nombre que su estrella, añadiendo una letra minúscula en orden de más cercanos a más lejanos de la estrella empezando por “b” y en orden alfabético, reservándose la letra “a” para la estrella.");
		
		return str.toString();
	}
	
	public static String explicacionPresion() {
		StringBuilder str = new StringBuilder();
		
		str.append("");
		
		return str.toString();
	}
	
	public static String explicacionCampoMagnetico(Boolean i) {
		StringBuilder str = new StringBuilder();
		
		if (!i) {
			str.append("El campo magnético de los planetas terrestres está generado por la rotación de un núcleo metálico en estado líquido, para lo cual se suelen necesitar elevadas temperaturas internas, por lo que se sospecha que los planetas pequeños suelen carecer de campo magnético porque se han enfriado y han perdido su núcleo líquido. El campo magnético protege al planeta del viento solar, una característica muy importante para la existencia de atmósfera y vida.");
		} else {
			str.append("El campo magnético de los planetas gaseosos suele ser extraño y diferente en cada caso.\n");
			str.append("Pueden llegar a ser extremadamente potentes comparados al de la Tierra, o tener geometrías extrañas difíciles de explicar.\n");
			str.append("Encontrar explicaciones no es fácil debido a la dificultad de explorar estos planetas más allá de la capa de nubes que les envuelve.");
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
		
		str.append("Es el tiempo que tarda el planeta en dar una vuelta completa alrededor de su estrella. \n");
		str.append("Este tiempo es proporcional a la distancia a la estrella y la masa de esta (su atracción gravitatoria) siguiendo una ley común para todos los planetas del universo llamada Tercera Ley de Kepler.");
		
		return str.toString();
	}
	
	public static String explicacionDuracionDia() {
		StringBuilder str = new StringBuilder();
		
		str.append("Es el tiempo que tarda en dar una vuelta completa sobre sí mismo.\n");
		str.append("Los planetas suelen girar sobre sí mismos en el mismo sentido en el que giran en torno a su estrella, pero hay situaciones especiales por las que pueden adquirir giros anómalos.\n");
		str.append("Los impactos de meteoritos y otros cuerpos más grandes pueden acelerar o frenar esta rotaciones e incluso invertirla.\n");
		str.append("Si el planeta está muy cerca de su estrella puede darse “Acoplamiento de Marea”, por la cual un planeta muestra siempre la misma cara a su estrella (igual que la Luna a la Tierra).");
		
		return str.toString();
	}
}

