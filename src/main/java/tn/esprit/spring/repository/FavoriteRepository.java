package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Favorite;

@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {
	
	
	
	@Modifying
	@Query(value = "insert into favorite(adresse,type,price,number_bathrooms,rooms,int_surface,ext_surface,number_garages) select adresse,type,price,number_bathrooms,rooms,int_surface,ext_surface,number_garages from pub where pub.id=?", nativeQuery = true)
	@Transactional
	public List<Favorite> Insert();

	

}
