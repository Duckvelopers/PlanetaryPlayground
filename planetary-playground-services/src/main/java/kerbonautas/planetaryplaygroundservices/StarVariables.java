package kerbonautas.planetaryplaygroundservices;

public class StarVariables {
	public static class llamadas{
		public static String SEQUENCE		= "SEQUENCE";
		public static String CLASS			= "CLASS";
		public static String MASS			= "MASS";
		public static String RADIUS			= "RADIUS";
		public static String SOLAR			= "RADIUS";
		public static String CUSTOM			= "CUSTOM";
		public static String SUN			= "SUN";
		public static String PROXIMA		= "PROXIMA";
		public static String PEGASI			= "PEGASI";
	}
	public static class Secuencia{
		public static int SUPERGIGANTE		= 1;
		public static int GIGANTE			= 3;
		public static int SECUENCIAP		= 5;
		public static int ENANABLANCA		= 7;
	}
	
	public static class TipoEspectral{
		public static String O		= "O";
		public static String B		= "B";
		public static String A		= "A";
		public static String F		= "F";
		public static String G		= "G";
		public static String K		= "K";
		public static String M		= "M";
		public static String T		= "T";
		public static String L		= "L";
	}
	public static double masaPlaneta (double masa, int exponente) {
		return masa * Math.pow(10, exponente);
	}
	
	public static class nombrePlanetasSistemaSolar{
		public static String MERCURIO	= "Mercury";
		public static String VENUS		= "Venus";
		public static String TIERRA		= "Earth";
		public static String MARTE		= "Mars";
		public static String JUPITER	= "Jupiter";
		public static String SATURNO	= "Saturn";
		public static String URANO		= "Uranus";
		public static String NEPTUNO	= "Neptune";
		public static String PROXIMAB	= "Proxima B";
		public static String DIMIDIUM	= "Dimidium";
	}
}