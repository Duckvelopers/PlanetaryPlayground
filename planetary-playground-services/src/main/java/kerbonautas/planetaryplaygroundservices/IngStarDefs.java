package kerbonautas.planetaryplaygroundservices;

public class IngStarDefs {
	
	public static String explicacionsecuencia(int i) {
		StringBuilder str = new StringBuilder();
		switch(i) {
		case 1:str.append("The stars of the I and II sequence, known as \"Supergigants\", are the bigest stars (mostly 100 to 1000 solar radius) that are cold and hot and always very bright. "
				+ "This stars are in final phases of theirs lives, and many of them will die fast and violently: "
				+ "a supernova explosion that forms heavy elements beyonds iron (Fe) and leave behind exotic stellar bodies like pulsars, magnetars and dark holes.");break;
				
		case 3:str.append("The stars of the III and IV sequence, known as \"Gigants\", are big stars (mostly 10 to 100 solar radius) that usually are cold and bright. "
				+ "This stars are in final phases of theirs lives, they produce heavy elements until iron (Fe), and most of them will die slowly: "
				+ "its outer layers will come off forming a nebula while its core survive as a white darf.");break;
				
		case 5:str.append("The main sequence (V) stars are the most abundant stars (90%). "
				+ "Their sizes are mostly between 0,1 and 10 solar radius and may be hot and brighter or cold and faint going through estates more balanced (like the Sun). "
				+ "This stars are in intermediate phases of theirs lives.");break;
		}
		return str.toString();
	}

	public static String explicacionclasespectral(String i) {
		StringBuilder str = new StringBuilder();
		switch(i) {
		case "O":str.append("The O spectral type stars are violet-blue bright stars with very high temperatures (30000-5000K). "
				+ "This stars emits large ultraviolet radiation very dangerous for live.");break;
				
		case "B":str.append("The spectral type B stars are blue-white bright stars with very high temperatures (11000-30000K). "
				+ "This stars emits a lote of ultraviolet radiation very dangerous for live.");break;
				
		case "A":str.append("The spectral type A stars are white stars with temperatures high temperatures (7500-11000K). "
				+ "This stars are seen like very bright because emits mostly in visible light.");break;
				
		case "F":str.append("The spectral type F stars are white-yellow stars with average temperatures (5900-7500K).");break;
				
		case "G":str.append("The spectral type G stars are yellow stars with average temperatures (5200-5900K). The Sun is a G spectral type star.");break;
				
		case "K":str.append("The spectral type K stars are faint orange stars with low temperatures (3900-5200K).");break;
				
		case "M":str.append("The spectral type M stars are very faint red stars with very low temperatures (2500-3900K) "
				+ "that are in the limit conditions to be able to perform the nuclear fusion of hydrogen in thir cores.");break;
		}
		
		return str.toString();
	}
}
