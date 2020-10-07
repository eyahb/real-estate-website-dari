package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.coordinates;
@Repository
public interface coordinatesRepository extends CrudRepository<coordinates, Long> {
	List<coordinates> findAll();
	List<coordinates> findById(long l);
	
}
