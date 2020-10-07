package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "favorite")
public class Favorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	private String adresse;
	private String type;
	private float price;
	private int intSurface;
	private int extSurface;
	private int rooms;
	private Long numberGarages;
	private Long numberBathrooms;

	public Long getNumberBathrooms() {
		return numberBathrooms;
	}

	public void setNumberBathrooms(Long numberBathrooms) {
		this.numberBathrooms = numberBathrooms;
	}

	public Long getNumberGarages() {
		return numberGarages;
	}

	public void setNumberGarages(Long numberGarages) {
		this.numberGarages = numberGarages;
	}

	public Favorite() {

	}

	public Favorite(String adresse, String type, float price, int intSurface, int extSurface, int rooms,
			Long numberGarages, Long numberBathrooms) {
		
		this.adresse = adresse;
		this.type = type;
		this.price = price;
		this.intSurface = intSurface;
		this.extSurface = extSurface;
		this.rooms = rooms;
		this.numberGarages = numberGarages;
		this.numberBathrooms = numberBathrooms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getIntSurface() {
		return intSurface;
	}

	public void setIntSurface(int intSurface) {
		this.intSurface = intSurface;
	}

	public int getExtSurface() {
		return extSurface;
	}

	public void setExtSurface(int extSurface) {
		this.extSurface = extSurface;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

}
