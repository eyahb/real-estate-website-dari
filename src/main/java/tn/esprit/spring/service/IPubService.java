package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Favorite;
import tn.esprit.spring.entity.Pub;



public interface IPubService {
	
	
	public List<Pub> getAllPubs();
	//public List<Pub> RecherchePrimaireLocation(String adresse, int extSurface , int intSurface, float price, int rooms, String type);
	public List<Pub> RecherchePrimaireLocation(String adresse ,int extSurface, int intSurface,Long numberBathrooms, Long numberGarages, float price,int rooms, String type); 
	public float Estimer(String adresse, int extSurface, int intSurface, Long numberBathrooms,
			Long numberGarages, int rooms, String type);
	
	
	
	
}
