package kerbonautas.planetaryplaygroundservices;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import predef.PredefSystem;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class APIController {

	@RequestMapping(value = "/prueba",
			method = RequestMethod.GET)
	@ResponseBody
	public String prueba() throws Exception {
		return "Hey Rick! It's another Cronenberg's world!";
	}
	@RequestMapping(value = "/secuencia",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String setSecuencia(@RequestBody Map<String, Object> payload) throws Exception {
		int secuencia = Integer.parseInt(payload.get(StarVariables.llamadas.SEQUENCE).toString());
		Gson gson = new Gson();
		return gson.toJson(Limitador.tiposEspectralesPosibles(secuencia));
	}
	@RequestMapping(value = "/espectral",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String setEspectral(@RequestBody Map<String, Object> payload) throws Exception {
		String secuencia = payload.get(StarVariables.llamadas.SEQUENCE).toString();
		String espectral = payload.get(StarVariables.llamadas.CLASS).toString();
		Gson gson = new Gson();
		Limitador limit = new Limitador();
		String val = secuencia+espectral;
		return gson.toJson(limit.getValores(val));
	}
	@RequestMapping(value = "/star",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getPredef(@RequestBody Map<String, Object> payload) 
	    throws Exception {
		SistemaEstelar se = null;
		String pre = payload.get(StarVariables.llamadas.SOLAR).toString();
		if (!pre.equalsIgnoreCase(StarVariables.llamadas.CUSTOM))
			se = PredefSystem.getSolarSystem(pre);
		else
			return null;
		Gson gson = new Gson();
		return gson.toJson(se);
	}
	@RequestMapping(value = "/custGen",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String custGen(@RequestBody Map<String, Object> payload) 
	    throws Exception {
		String secuencia = payload.get(StarVariables.llamadas.SEQUENCE).toString();
		String espectral = payload.get(StarVariables.llamadas.CLASS).toString();
		String masa = payload.get(StarVariables.llamadas.MASS).toString();
		String radio = payload.get(StarVariables.llamadas.RADIUS).toString();
		SistemaEstelar se = null;
		//se = StuffGenerator.generarSistemaRandom(secuencia,espectral,masa,radio);
		Gson gson = new Gson();
		return gson.toJson(se);
	}
}
