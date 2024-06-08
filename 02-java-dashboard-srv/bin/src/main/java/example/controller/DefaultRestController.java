package example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import example.model.*;
import example.repository.*;

@RestController
public class DefaultRestController {

  @Autowired
	private PortalRepository portalRepository;

	@RequestMapping(path="/portal", method=RequestMethod.GET)
	public String getAll(){
		Iterable<Portal> itr = portalRepository.findAll();
  	Gson gson = new Gson();
    return gson.toJson(itr);
	}
}
