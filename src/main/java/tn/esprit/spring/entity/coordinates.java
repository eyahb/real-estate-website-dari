package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Coordinates")
public class coordinates implements Serializable {

	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private Float lang;
	@Column
	private Float lat;
	@Column
	private String name;
	@Column
	private String type;
	@Column
	private String address;

	@Override
	public String toString() {
		return "coordinates [id=" + id + ", lang=" + lang + ", lat=" + lat + ", name=" + name + ", type=" + type
				+ ", address=" + address + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getLang() {
		return lang;
	}

	public void setLang(Float lang) {
		this.lang = lang;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public coordinates() {

	}

	
}