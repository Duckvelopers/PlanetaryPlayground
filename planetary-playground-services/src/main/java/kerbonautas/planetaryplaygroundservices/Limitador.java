package kerbonautas.planetaryplaygroundservices;

import java.util.ArrayList;
import java.util.HashMap;

public class Limitador {

	private static HashMap<String, double[]> tablaValores;
	
	public Limitador() {
		super();
		insertarValores();
	}
	
	public void insertarValores() {
		tablaValores.put("1B", new double[]{10,100,11.1,41.4});
		tablaValores.put("1A", new double[]{10,200,7,38.7});
		tablaValores.put("1F", new double[]{20,300,6.9,38.7});
		tablaValores.put("1G", new double[]{60,800,9.2,40.5});
		tablaValores.put("1K", new double[]{100,1000,9.7,36});
		tablaValores.put("1M", new double[]{200,1000,10.1,25.5});
		tablaValores.put("3A", new double[]{2,10,2.8,7});
		tablaValores.put("3F", new double[]{2,20,1.9,6.9});
		tablaValores.put("3G", new double[]{3,20,1.7,4.9});
		tablaValores.put("3K", new double[]{10,80,2.6,8.5});
		tablaValores.put("3M", new double[]{15,100,2.3,6.8});
		tablaValores.put("5O", new double[]{1.2,3,7.3,12.3});
		tablaValores.put("5B", new double[]{0.9,2,2.8,4.4});
		tablaValores.put("5A", new double[]{0.8,1.5,1.6,2.4});
		tablaValores.put("5F", new double[]{0.8,1.5,1.1,1.6});
		tablaValores.put("5G", new double[]{0.7,1.25,0.7,1});
		tablaValores.put("5K", new double[]{0.2,1,0.3,0.7});
		tablaValores.put("5M", new double[]{0.1,1,0.1,0.5});
		tablaValores.put("7B", new double[]{1,2,3,4});
		tablaValores.put("7A", new double[]{1,2,3,4});
		tablaValores.put("7F", new double[]{1,2,3,4});
		tablaValores.put("7G", new double[]{1,2,3,4});
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
}
