package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Location;

public interface ILocationService {

	public List<Location> retrieveAllLocations();

	Location updateLoc(Location loc);

	public Long addLoc(Location loc);

	public void deleteLoc(String id);

	public long addOrUpdateLocation(Location location);

	public List<Location> getAllLocations();

	public void deleteLocationById(String locationId);

}
