package kerbonautas.planetaryplaygroundservices;

public class Planeta {

	private int ID;
	private int radious;
	private int temperature;
	private int numberOfSatellites;
	private boolean isSolid;
	private int mass;
	private boolean haveAtmosphere;
	private String name;
	private double pressure;
	
	public Planeta(int ID, int rad, int temp, int sat, boolean solid, int mass, boolean haveAtmosphere, String name, double pressure) {
		setID(ID);
		setRadious(rad);
		setTemperature(temp);
		setNumberOfSatellites(sat);
		setIsSolid(solid);
		setMass(mass);
		setAtmosphere(haveAtmosphere);
		setName(name);
		setPressure(pressure);
	}
	
	public void setRadious(int i) {radious = i;}
	public void setTemperature(int i) {temperature = i;}
	public void setNumberOfSatellites(int i) {numberOfSatellites = i;}
	public void setIsSolid(boolean i) {isSolid = i;}
	public void setMass(int i) {mass = i;}
	public void setID(int i) {ID = i;}
	public void setAtmosphere(boolean i) {haveAtmosphere = i;}
	public void setName(String i) {name = i;}
	public void setPressure(double i) {pressure = i;}
	
	public int getRadious() {return radious;}
	public int getTemperature() {return temperature;}
	public int getNumberOfSatellites() {return numberOfSatellites;}
	public boolean getIsSolid() {return isSolid;}
	public int getMass() {return mass;}
	public int getID() {return ID;}
	public boolean getAtmosphere() {return haveAtmosphere;}
	public String getName() {return name;}
	public double getPressure() {return pressure;}
}
