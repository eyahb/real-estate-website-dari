package tn.esprit.spring.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Location;
import tn.esprit.spring.service.ILocationService;

@RestController
@ManagedBean(name = "locationRestController", eager = true)
@RequestScoped
public class LocationRestContoller {

	@Autowired
	ILocationService ils;

	// http://localhost:8081/SpringMVC/servlet/addloc
	@PostMapping("/addloc")
	@ResponseBody
	public Location ajouterLocation(@RequestBody Location location) {
		ils.addLoc(location);
		return location;
	}

	// http://localhost:8081/SpringMVC/servlet/delete-loc/{loc-id}
	@DeleteMapping("/delete-loc/{loc-id}")
	@ResponseBody
	public void deleteLoc(@PathVariable("loc-id") String LocationId) {
		ils.deleteLoc(LocationId);
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-locations
	@GetMapping("/retrieve-all-locations")
	@ResponseBody
	public List<Location> getUsers() {
		List<Location> list = ils.retrieveAllLocations();
		return list;
	}

	// http://localhost:8081/SpringMVC/servlet/modify-Location
	@PutMapping("/modify-Location")
	@ResponseBody
	public Location updateLoc(@RequestBody Location loc) {
		return ils.updateLoc(loc);
	}

}
