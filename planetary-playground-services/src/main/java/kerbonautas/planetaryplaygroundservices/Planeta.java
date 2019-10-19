package kerbonautas.planetaryplaygroundservices;

public class Planeta {

	private int radius;
	private double temperature;
	private int numberOfSatellites;
	private boolean isSolid;
	private double mass;
	private boolean haveAtmosphere;
	private String name;
	private double pressure;
	
	public Planeta(int rad, double temp, int sat, boolean solid, double mass, boolean haveAtmosphere, String name, double pressure) {
		setRadius(rad);
		setTemperature(temp);
		setNumberOfSatellites(sat);
		setIsSolid(solid);
		setMass(mass);
		setAtmosphere(haveAtmosphere);
		setName(name);
		setPressure(pressure);
	}
	
	public void setRadius(int i) {radius = i;}
	public void setTemperature(double i) {temperature = i;}
	public void setNumberOfSatellites(int i) {numberOfSatellites = i;}
	public void setIsSolid(boolean i) {isSolid = i;}
	public void setMass(double i) {mass = i;}
	public void setAtmosphere(boolean i) {haveAtmosphere = i;}
	public void setName(String i) {name = i;}
	public void setPressure(double i) {pressure = i;}
	
	public int getRadius() {return radius;}
	public double getTemperature() {return temperature;}
	public int getNumberOfSatellites() {return numberOfSatellites;}
	public boolean getIsSolid() {return isSolid;}
	public double getMass() {return mass;}
	public boolean getAtmosphere() {return haveAtmosphere;}
	public String getName() {return name;}
	public double getPressure() {return pressure;}
}
