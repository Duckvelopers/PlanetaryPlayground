package kerbonautas.planetaryplaygroundservices;

import java.util.ArrayList;
import java.util.HashMap;

public class Limitador {

	private static HashMap<String, int[]> tablaValores;
	
	public Limitador() {
		super();
		insertarValores();
	}
	
	public void insertarValores() {
		tablaValores.put("1B", new int[]{1,2,3,4});
		tablaValores.put("1A", new int[]{1,2,3,4});
		tablaValores.put("1F", new int[]{1,2,3,4});
		tablaValores.put("1G", new int[]{1,2,3,4});
		tablaValores.put("1K", new int[]{1,2,3,4});
		tablaValores.put("1M", new int[]{1,2,3,4});
		tablaValores.put("3F", new int[]{1,2,3,4});
		tablaValores.put("3G", new int[]{1,2,3,4});
		tablaValores.put("3K", new int[]{1,2,3,4});
		tablaValores.put("3M", new int[]{1,2,3,4});
		tablaValores.put("5O", new int[]{1,2,3,4});
		tablaValores.put("5B", new int[]{1,2,3,4});
		tablaValores.put("5A", new int[]{1,2,3,4});
		tablaValores.put("5F", new int[]{1,2,3,4});
		tablaValores.put("5G", new int[]{1,2,3,4});
		tablaValores.put("5K", new int[]{1,2,3,4});
		tablaValores.put("5M", new int[]{1,2,3,4});
		tablaValores.put("7B", new int[]{1,2,3,4});
		tablaValores.put("7A", new int[]{1,2,3,4});
		tablaValores.put("7F", new int[]{1,2,3,4});
		tablaValores.put("7G", new int[]{1,2,3,4});
	}
	
	public ArrayList<String> tiposEspectralesPosibles (int secuencia){
		ArrayList<String> arrayTiposEspectrales = new ArrayList<String>();
		if (secuencia == 1) {
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.B);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.A);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.F);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.G);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.K);
			arrayTiposEspectrales.add(StarVariables.TipoEspectral.M);
		} else if (secuencia == 3) {
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
	
	public int[] masaRadiosPosibles(int secuencia, String tipoEspectral){
		String codigo = tipoEspectral + secuencia;
		return tablaValores.get(codigo);
	}
}
