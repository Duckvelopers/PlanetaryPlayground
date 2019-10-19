package kerbonautas.planetaryplaygroundservices;

public class estrella {

	public String secuencia;
	public String tipoEspectral;
	public int luminosidad;
	public int temperatura;
	public int magnitudAbsoluta;
	public int radio;

	public estrella(String secuencia, String tipoEspectral, int luminosidad, int temperatura, int magnitudAbsoluta,
			int radio) {
		super();
		this.secuencia = secuencia;
		this.tipoEspectral = tipoEspectral;
		this.luminosidad = luminosidad;
		this.temperatura = temperatura;
		this.magnitudAbsoluta = magnitudAbsoluta;
		this.radio = radio;
	}

	public String getTipoEspectral() {
		return tipoEspectral;
	}

	public void setTipoEspectral(String tipoEspectral) {
		this.tipoEspectral = tipoEspectral;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public int getLuminosidad() {
		return luminosidad;
	}

	public void setLuminosidad(int luminosidad) {
		this.luminosidad = luminosidad;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getMagnitudAbsoluta() {
		return magnitudAbsoluta;
	}

	public void setMagnitudAbsoluta(int magnitudAbsoluta) {
		this.magnitudAbsoluta = magnitudAbsoluta;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	
}
