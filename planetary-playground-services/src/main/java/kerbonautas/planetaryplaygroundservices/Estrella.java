package kerbonautas.planetaryplaygroundservices;

public class Estrella {

	public int secuencia;
	public String tipoEspectral;
	public double luminosidad;
	public double temperatura;
	public double magnitudAbsoluta;
	public double radio;
	public double masa;
	public double constanteSigma = 5.67 * Math.pow(10, -8);
	
	public Estrella(int secuencia, String tipoEspectral, double masa, double radio) {
		super();
		this.secuencia = secuencia;
		this.tipoEspectral = tipoEspectral;
		this.masa = masa;
		this.radio = radio;
		construirEstrella();
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

	public void construirEstrella() {
		if(radio > 0) {
			setMasa(calcularMasa());
		}
		else {
			setRadio(calcularRadio());
		}
		setTemperatura(calcularTemperatura());
		setLuminosidad(calcularLuminosidad());
		setMagnitudAbsoluta(calcularMagnitudAbsoluta());
	}
	
	public double calcularTemperatura() {
		
		return 0;
	}
	
	public double calcularMasa() {
		
		return 0;
	}
	
	public double calcularRadio() {
		
		return 0;
	}
	
	public double calcularLuminosidad() {
		
		return 0;
	}
	
	public double calcularMagnitudAbsoluta() {
		
		return 0;
	}
}
