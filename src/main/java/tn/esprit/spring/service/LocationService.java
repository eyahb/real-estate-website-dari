package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Location;
import tn.esprit.spring.repository.LocationRepository;

@Service
public class LocationService implements ILocationService {

	@Autowired
	LocationRepository locrep;
	public static final Logger L = LogManager.getLogger(ILocationService.class);

	@Override
	public List<Location> retrieveAllLocations() {
		List<Location> users = (List<Location>) locrep.findAll();

		for (Location user : users) {
			L.info("user +++ : " + user);
		}
		return users;
	}

	@Override
	public Location updateLoc(Location loc) {
		return locrep.save(loc);

	}

	@Override
	public long addOrUpdateLocation(Location location) {
		locrep.save(location);
		return location.getId();
	}

	@Override
	public List<Location> getAllLocations() {
		return (List<Location>) locrep.findAll();
	}

	public void deleteLocationById(String locationId) {

		// Location location = locrep.findById(locationId).get();

		// locrep.delete(location);
		// annRepository.deleteById(Long.parseLong(id));
		locrep.deleteById(Long.parseLong(locationId));
	}

	public Long addLoc(Location loc) {
		locrep.save(loc);
		return loc.getId();
	}

	@Override
	public void deleteLoc(String id) {
		locrep.deleteById(Long.parseLong(id));
	}

}