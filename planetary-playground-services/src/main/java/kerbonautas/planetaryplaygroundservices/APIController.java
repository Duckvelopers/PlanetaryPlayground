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
	public String process(@RequestBody Map<String, Object> payload) 
	    throws Exception {
		Gson gson = new Gson();
		Planeta p = new Planeta(1, 1, 1, 1, true, 1, true, "Culomon", 1.1d);
		return gson.toJson(p);
	}
}
