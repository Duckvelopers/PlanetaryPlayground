package kerbonautas.planetaryplaygroundservices;

import java.util.HashMap;

public class Estrella {

	public int secuencia;
	public String tipoEspectral;
	public double luminosidad;
	public double temperatura;
	public double magnitudAbsoluta;
	public double radio;
	public double masa;
	private double constanteSigma = 5.67 * Math.pow(10, -8);
	private double constanteLuminosidadSol = 3.86 * Math.pow(10, 26);
	private double constanteRadioSol = 6.957 * Math.pow(10, 8);
	private String name;

	private HashMap<String, String> descripciones = new HashMap<String, String>();
	
	public Estrella(int secuencia, String tipoEspectral, double masa, double radio) {
		super();
		this.secuencia = secuencia;
		this.tipoEspectral = tipoEspectral;
		this.masa = masa;
		this.radio = radio;
		this.name = generarNombre();
		construirEstrella();
		setDescription();
	}
	
	private String generarNombre() {
		return "KBS "+(((int)(Math.random()*999999))+1)+" a";
	}

	public int getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(int secuencia) {
		this.secuencia = secuencia;
	}
	public String getTipoEspectral() {
		return tipoEspectral;
	}
	public void setTipoEspectral(String tipoEspectral) {
		this.tipoEspectral = tipoEspectral;
	}
	public double getLuminosidad() {
		return luminosidad;
	}
	public void setLuminosidad(double luminosidad) {
		this.luminosidad = luminosidad;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public double getMagnitudAbsoluta() {
		return magnitudAbsoluta;
	}
	public void setMagnitudAbsoluta(double magnitudAbsoluta) {
		this.magnitudAbsoluta = magnitudAbsoluta;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public double getMasa() {
		return masa;
	}
	public void setMasa(double masa) {
		this.masa = masa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void construirEstrella() {
		setTemperatura(calcularTemperatura(getTipoEspectral()));
		
		if(radio != 0) {
			setMasa(calcularMasa(getRadio(), getTemperatura()));
		}
		else {
			setRadio(calcularRadio(getMasa(), getTemperatura()));
		}
		
		setLuminosidad(calcularLuminosidad(getMasa()));
		setMagnitudAbsoluta(calcularMagnitudAbsoluta(getLuminosidad()));
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
	
	public double calcularMasa(double auxRadio, double auxTemperatura) {
		double auxMasa = 0;
		auxMasa = Math.pow(auxRadio, 0.571429) * Math.pow(auxTemperatura, 1.142857);
		auxMasa = auxMasa * 0.0000502812630636157;
		return auxMasa;
	}
	
	public double calcularRadio(double auxMasa, double auxTemperatura) {
		double auxRadio = 0;
		auxRadio = Math.pow(auxMasa, 1.75) / Math.pow(auxTemperatura, 2);
		auxRadio = auxRadio * 33307281.4906884;
		return auxRadio;
	}
	
	public double calcularLuminosidad(double auxMasa) {
		double auxLuminosidad = 0;
		auxLuminosidad = constanteLuminosidadSol * Math.pow(auxMasa, 7/2);
		return auxLuminosidad;
	}
	
	public double calcularMagnitudAbsoluta(double auxLuminosidad) {
		double auxMagnitudAbsoluta = 0;
		auxMagnitudAbsoluta = 4.75 - (2.5 * Math.log10(auxLuminosidad/constanteLuminosidadSol));
		return auxMagnitudAbsoluta;
	}
	
	public void setDescription() {
		if (StarVariables.eng) {
			
		} else {
			descripciones.put("LUMINOSIDAD", EsStarDefs.explicacionesLuminosidad());
			descripciones.put("MAGNITUD", EsStarDefs.explicacionesMagnitud());
			descripciones.put("MASA", EsStarDefs.explicacionesMasa());
			descripciones.put("RADIO", EsStarDefs.explicacionesRadio());
			descripciones.put("SECUENCIA", EsStarDefs.explicacionesSecuencia());
			descripciones.put("TEMPERATURA", EsStarDefs.explicacionesTemperatura());
			descripciones.put("TIPOESPECTRAL", EsStarDefs.explicacionesTipoEspectral());
		}
	}
}
