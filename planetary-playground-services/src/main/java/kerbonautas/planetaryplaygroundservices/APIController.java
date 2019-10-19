package kerbonautas.planetaryplaygroundservices;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import predef.PredefSystem;

@RestController
public class APIController {

	@RequestMapping(value = "/delPlanet",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deletePlanet(@RequestBody Map<String, Object> payload) 
	    throws Exception {
		Gson gson = new Gson();
		//TODO Eliminar del arrayList el planeta eliminado
	}
	@RequestMapping(value = "/secuencia",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String setSecuencia(@RequestBody Map<String, Object> payload) 
	    throws Exception {
		Gson gson = new Gson();
		return gson.toJson(null);
		//TODO Eliminar del arrayList el planeta eliminado
	}
	@RequestMapping(value = "/star",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getPredef(@RequestBody Map<String, Object> payload) 
	    throws Exception {
		SistemaEstelar se = null;
		String pre = payload.get("SOLAR").toString();
		if (!pre.equalsIgnoreCase("CUSTOM"))
			se = PredefSystem.getSolarSystem(pre);
		else
			return null;
		Gson gson = new Gson();
		return gson.toJson(se);
	}
}
