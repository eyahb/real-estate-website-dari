package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Pub;

@Repository
public interface PubRepository extends CrudRepository<Pub, Integer> {

	@Query(value = "Select * from pub where adresse=? and ext_surface=? and int_surface=? and number_bathrooms=? and number_garages=? and price=? and rooms =? AND type=? ", nativeQuery = true)
	public List<Pub> RecherchePrimaireLocation(String adresse, int extSurface, int intSurface, Long numberBathrooms,
			Long numberGarages, float price, int rooms, String type);

	@Query(value = "Select avg(price) from pub where adresse=? and ext_surface<=? and int_surface<=? and number_bathrooms<=? and number_garages<=? and rooms <=? AND type=? ", nativeQuery = true)
	public float Estimer(String adresse, int extSurface, int intSurface, Long numberBathrooms, Long numberGarages,
			int rooms, String type);

	
}
