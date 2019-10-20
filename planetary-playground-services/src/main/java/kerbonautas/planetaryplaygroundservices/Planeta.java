package kerbonautas.planetaryplaygroundservices;

import java.util.HashMap;

public class Planeta {

	private int radius;
	private double surfaceTemperature;
	private boolean isSolid;
	private double mass;
	private boolean haveAtmosphere;
	private String name;
	private double pressure;
	private double magneticField;
	private double starDistance;
	private double orbitalPeriod;
	private double dayDuration;
	private String imagen;
	private HashMap<String, String> descripciones = new HashMap <String, String>();

	public Planeta(int radius, double surfaceTemperature, boolean isSolid, double mass, boolean haveAtmosphere,
			String name, double pressure, double magneticField, double starDistance, double orbitalPeriod,
			double dayDuration) {
		super();
		this.radius = radius;
		this.surfaceTemperature = surfaceTemperature;
		this.isSolid = isSolid;
		this.mass = mass;
		this.haveAtmosphere = haveAtmosphere;
		this.name = name;
		this.pressure = pressure;
		this.magneticField = magneticField;
		this.starDistance = starDistance;
		this.orbitalPeriod = orbitalPeriod;
		this.dayDuration = dayDuration;
		setImagen();
		
		setDescripcion();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getSurfaceTemperature() {
		return surfaceTemperature;
	}

	public void setSurfaceTemperature(double surfaceTemperature) {
		this.surfaceTemperature = surfaceTemperature;
	}

	public boolean isSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public boolean isHaveAtmosphere() {
		return haveAtmosphere;
	}

	public void setHaveAtmosphere(boolean haveAtmosphere) {
		this.haveAtmosphere = haveAtmosphere;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getMagneticField() {
		return magneticField;
	}

	public void setMagneticField(double magneticField) {
		this.magneticField = magneticField;
	}

	public double getStarDistance() {
		return starDistance;
	}

	public void setStarDistance(double starDistance) {
		this.starDistance = starDistance;
	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public void setOrbitalPeriod(double orbitalPeriod) {
		this.orbitalPeriod = orbitalPeriod;
	}

	public double getDayDuration() {
		return dayDuration;
	}

	public void setDayDuration(double dayDuration) {
		this.dayDuration = dayDuration;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen() {
		StringBuilder str = new StringBuilder();
		if (isSolid) {
			str.append("t");
		} else {
			str.append("g");
		}
		int i = (int) (Math.random() * 5 + 1);
		str.append(i);
	}
	public void setMachacaImagen(String i) {
		this.imagen=i;
	}
	
	public void setDescripcion() {

		if (StarVariables.eng) {
			descripciones.put("CAMPOMAGNETICO", IngDefs.explicacionCampoMagnetico(isSolid));
			descripciones.put("DISTANCIA", IngDefs.explicacionDistancia(isSolid));
			descripciones.put("DURACIONDIA", IngDefs.explicacionDuracionDia());
			descripciones.put("GASEOSOONO", IngDefs.explicacionGaseosoONo(isSolid));
			descripciones.put("MASA", IngDefs.explicacionMasa());
			descripciones.put("NOMBRE", IngDefs.explicacionNombre());
			descripciones.put("PERIODOORBITAL", IngDefs.explicacionPeriodoOrbital());
			descripciones.put("PRESION", IngDefs.explicacionPresion());
			descripciones.put("TAMANHO", IngDefs.explicacionTamanho(isSolid));
			descripciones.put("TEMPERATURA", IngDefs.explicacionTemperatura());
			descripciones.put("ATMOSFERA", IngDefs.explicacionTieneAtmosfera(isSolid));
		} else {
			descripciones.put("CAMPOMAGNETICO", EsDefs.explicacionCampoMagnetico(isSolid));
			descripciones.put("DISTANCIA", EsDefs.explicacionDistancia(isSolid));
			descripciones.put("DURACIONDIA", EsDefs.explicacionDuracionDia());
			descripciones.put("GASEOSOONO", EsDefs.explicacionGaseosoONo(isSolid));
			descripciones.put("MASA", EsDefs.explicacionMasa());
			descripciones.put("NOMBRE", EsDefs.explicacionNombre());
			descripciones.put("PERIODOORBITAL", EsDefs.explicacionPeriodoOrbital());
			descripciones.put("PRESION", EsDefs.explicacionPresion());
			descripciones.put("TAMANHO", EsDefs.explicacionTamanho(isSolid));
			descripciones.put("TEMPERATURA", EsDefs.explicacionTemperatura());
			descripciones.put("ATMOSFERA", EsDefs.explicacionTieneAtmosfera(isSolid));
		}
		
	}
	
}
