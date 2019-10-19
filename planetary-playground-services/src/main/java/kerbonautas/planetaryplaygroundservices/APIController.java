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
		return "Pampi es gayer";
	}
	@RequestMapping(value = "/secuencia",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String setSecuencia(@RequestBody Map<String, Object> payload) 
	    throws Exception {
		//TODO devolver los tipos espectrales en un Gson gson = new Gson();
		//return gson.toJson(Objeto a pasar);
		return null;
	}
	@RequestMapping(value = "/star",
			method = RequestMethod.POST,
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
