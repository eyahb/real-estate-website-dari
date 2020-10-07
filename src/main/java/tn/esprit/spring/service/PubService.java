package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Favorite;
import tn.esprit.spring.entity.Pub;
import tn.esprit.spring.repository.FavoriteRepository;
import tn.esprit.spring.repository.PubRepository;

@Service
public class PubService implements IPubService {

	@Autowired
	PubRepository pubrep;
	@Autowired
	FavoriteRepository favbrep;

	public static final Logger L = LogManager.getLogger(IPubService.class);

	@Override
	public List<Pub> getAllPubs() {
		return (List<Pub>) pubrep.findAll();
	}

	@Override
	public List<Pub> RecherchePrimaireLocation(String adresse, int extSurface, int intSurface, Long numberBathrooms,
			Long numberGarages, float price, int rooms, String type) {

		List<Pub> search = new ArrayList<>();
		search.addAll(pubrep.RecherchePrimaireLocation(adresse, extSurface, intSurface, numberBathrooms, numberGarages,
				price, rooms, type));

		return search;

	}

	@Override
	public float Estimer(String adresse, int extSurface, int intSurface, Long numberBathrooms, Long numberGarages,
			int rooms, String type) {

		float estimer;
		estimer = pubrep.Estimer(adresse, extSurface, intSurface, numberBathrooms, numberGarages, rooms, type);

		return estimer;

	}

	
		

	}

