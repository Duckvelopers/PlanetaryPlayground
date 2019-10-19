package kerbonautas.planetaryplaygroundservices;

public class StarVariables {
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
		return Math.pow(masa, exponente);
	}
}