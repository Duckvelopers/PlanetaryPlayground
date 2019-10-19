package kerbonautas.planetaryplaygroundservices;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class APIController {

	@RequestMapping(value = "/newStar",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String newStar(@RequestBody Map<String, Object> payload) 
	    throws Exception {
		//TODO recibir la estrella creada y devolver el sistema solar
		Gson gson = new Gson();
		return gson.toJson("");
	}
	@RequestMapping(value = "/delPlanet",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deletePlanet(@RequestBody Map<String, Object> payload) 
	    throws Exception {
		Gson gson = new Gson();
		//TODO Eliminar del arrayList el planeta eliminado
	}
}
