package kerbonautas.planetaryplaygroundservices;

import java.util.ArrayList;
import java.util.HashMap;

public class Limitador {

	private static HashMap<String, double[]> tablaValores;
	private double constanteRadioSol = 6.957 * Math.pow(10, 8);
	private double constanteSigma = 5.67 * Math.pow(10, -8);
	private double constanteMasaSolar = 1.989 * Math.pow(10, 30);
	
	public Limitador() {
		super();
		insertarValores();
	}
	
	public void insertarValores() {
		tablaValores = new HashMap<String, double[]>();
		tablaValores.put("1B", new double[]{10,100,calcularMasaMinima(10d, "B"),calcularMasaMaxima(100d, "B")});
		tablaValores.put("1A", new double[]{10,200,calcularMasaMinima(10d, "A"),calcularMasaMaxima(200d, "A")});
		tablaValores.put("1F", new double[]{20,300,calcularMasaMinima(20d, "F"),calcularMasaMaxima(300d, "F")});
		tablaValores.put("1G", new double[]{60,800,calcularMasaMinima(60d, "G"),calcularMasaMaxima(800d, "G")});
		tablaValores.put("1K", new double[]{100,1000,calcularMasaMinima(100d, "K"),calcularMasaMaxima(1000d, "K")});
		tablaValores.put("1M", new double[]{200,1000,calcularMasaMinima(200d, "M"),calcularMasaMaxima(1000d, "M")});
		tablaValores.put("3A", new double[]{2,10,calcularMasaMinima(2d, "A"),calcularMasaMaxima(10d, "A")});
		tablaValores.put("3F", new double[]{2,20,calcularMasaMinima(2d, "F"),calcularMasaMaxima(20d, "F")});
		tablaValores.put("3G", new double[]{3,20,calcularMasaMinima(3d, "G"),calcularMasaMaxima(20d, "G")});
		tablaValores.put("3K", new double[]{10,80,calcularMasaMinima(10d, "K"),calcularMasaMaxima(80d, "K")});
		tablaValores.put("3M", new double[]{15,100,calcularMasaMinima(15d, "M"),calcularMasaMaxima(100d, "M")});
		tablaValores.put("5O", new double[]{1.2,3,calcularMasaMinima(1.2d, "O"),calcularMasaMaxima(3d, "O")});
		tablaValores.put("5B", new double[]{0.9,2,calcularMasaMinima(0.9d, "B"),calcularMasaMaxima(2d, "B")});
		tablaValores.put("5A", new double[]{0.8,1.5,calcularMasaMinima(0.8d, "A"),calcularMasaMaxima(1.5d, "A")});
		tablaValores.put("5F", new double[]{0.8,1.5,calcularMasaMinima(0.8d, "F"),calcularMasaMaxima(1.5d, "F")});
		tablaValores.put("5G", new double[]{0.7,1.25,calcularMasaMinima(0.7d, "G"),calcularMasaMaxima(1.25d, "G")});
		tablaValores.put("5K", new double[]{0.2,1,calcularMasaMinima(0.2d, "K"),calcularMasaMaxima(1d, "K")});
		tablaValores.put("5M", new double[]{0.1,1,calcularMasaMinima(0.1d, "M"),calcularMasaMaxima(1d, "M")});
		tablaValores.put("7B", new double[]{1,2,calcularMasaMinima(1d, "B"),calcularMasaMaxima(2d, "B")});
		tablaValores.put("7A", new double[]{1,2,calcularMasaMinima(1d, "A"),calcularMasaMaxima(2d, "A")});
		tablaValores.put("7F", new double[]{1,2,calcularMasaMinima(1d, "F"),calcularMasaMaxima(2d, "F")});
		tablaValores.put("7G", new double[]{1,2,calcularMasaMinima(1d, "G"),calcularMasaMaxima(2d, "G")});
	}
	public double[] getValores(String val) {
		return tablaValores.get(val);
	}
	
	public static ArrayList<String> tiposEspectralesPosibles (int secuencia){
		ArrayList<String> arrayTiposEspectrales = new ArrayList<String>();
		if (secuencia == 1) {
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.B);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.A);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.F);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.G);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.K);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.M);
		} else if (secuencia == 3) {
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.A);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.F);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.G);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.K);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.M);
		} else if (secuencia == 5) {
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.O);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.B);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.A);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.F);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.G);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.K);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.M);
		} else {
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.B);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.A);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.F);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.G);
		}
		return arrayTiposEspectrales;
	}
	
	public double[] masaRadiosPosibles(int secuencia, String tipoEspectral){
		String codigo = tipoEspectral + secuencia;
		return tablaValores.get(codigo);
	}
	
	public double calcularMasaMinima(double auxRadioMinimo, String auxTipoEspectral) {
		double auxMasaMinima = 0;
		auxMasaMinima = 4 * Math.PI * constanteSigma * Math.pow(constanteRadioSol, 2) * Math.pow(auxRadioMinimo, 2) * Math.pow(calcularTemperatura(auxTipoEspectral), 4);
		auxMasaMinima = Math.pow(auxMasaMinima, 2/7);
		auxMasaMinima = auxMasaMinima / constanteMasaSolar;
		return auxMasaMinima;
	}
	
	public double calcularMasaMaxima(double auxRadioMaximo, String auxTipoEspectral) {
		double auxMasaMaxima = 0;
		auxMasaMaxima = 4 * Math.PI * constanteSigma * Math.pow(constanteRadioSol, 2) * Math.pow(auxRadioMaximo, 2) * Math.pow(calcularTemperatura(auxTipoEspectral), 4);
		auxMasaMaxima = Math.pow(auxMasaMaxima, 2/7);
		auxMasaMaxima = auxMasaMaxima / constanteMasaSolar;
		return auxMasaMaxima;
	}
	
	public double calcularTemperatura(String tipoEspectral) {
		double auxTemperatura = 0;
		if (tipoEspectral.equals(StarVariables.TipoEspectral.O)) {
			auxTemperatura = 30000;
		} else if (tipoEspectral.equals(StarVariables.TipoEspectral.B)) {
			auxTemperatura = 15000;
		} else if (tipoEspectral.equals(StarVariables.TipoEspectral.A)) {
			auxTemperatura = 10000;
		} else if (tipoEspectral.equals(StarVariables.TipoEspectral.F)) {
			auxTemperatura = 7000;
		} else if (tipoEspectral.equals(StarVariables.TipoEspectral.G)) {
			auxTemperatura = 5200;
		} else if (tipoEspectral.equals(StarVariables.TipoEspectral.K)) {
			auxTemperatura = 4200;
		} else if (tipoEspectral.equals(StarVariables.TipoEspectral.M)) {
			auxTemperatura = 3100;
		} else if (tipoEspectral.equals(StarVariables.TipoEspectral.L)) {
			auxTemperatura = 2000;
		} else if (tipoEspectral.equals(StarVariables.TipoEspectral.T)) {
			auxTemperatura = 1000;
		}
		return auxTemperatura;
	}
}
