package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Location implements Serializable {

	private static final long serialVersionUID = -1396669830860400871L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long id;
	//private int id; // Identifiant formation (Clé primaire)
	@Temporal(TemporalType.DATE)
	private Date DateDepart;
	@Temporal(TemporalType.DATE)
	private Date DateArrivee;
	private int nbPersonne;

	public Location() {
	}

	public Location(long id, Date dateDepart, Date dateArrivee, int nbPersonne) {
		super();
		this.id = id;
		this.DateDepart = dateDepart;
		this.DateArrivee = dateArrivee;
		this.nbPersonne = nbPersonne;
	}

	public Location(Date dateDepart, Date dateArrivee, int nbPersonne) {
		this.DateDepart = dateDepart;
		this.DateArrivee = dateArrivee;
		this.nbPersonne = nbPersonne;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return DateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.DateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return DateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.DateArrivee = dateArrivee;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", DateDepart=" + DateDepart + ", DateArrivee=" + DateArrivee + ", nbPersonne="
				+ nbPersonne + "]";
	}

}
