package tn.esprit.spring.control;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Favorite;
import tn.esprit.spring.entity.Pub;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.FavoriteRepository;
import tn.esprit.spring.repository.PubRepository;
import tn.esprit.spring.service.IPubService;

@Scope(value = "session")
@ELBeanName(value = "pubController")
@Controller(value = "pubController")
public class PubController {

	@Autowired
	private IPubService pubservice;
	@Autowired
	PubRepository pubrepo;
	@Autowired
	FavoriteRepository favrepo;
	
	@Autowired
	UserController usercontroller;
	
	

	private String adresse;
	private String type;
	private float price;
	private int intSurface;
	private int extSurface;
	private int rooms;
	private int id;
	private Long numberGarages;
	private Long numberBathrooms;
	private float esti;
	private List<Favorite> favs;
	public Long getNumberGarages() {
		return numberGarages;
	}

	public void setNumberGarages(Long numberGarages) {
		this.numberGarages = numberGarages;
	}

	public Long getNumberBathrooms() {
		return numberBathrooms;
	}

	public void setNumberBathrooms(Long numberBathrooms) {
		this.numberBathrooms = numberBathrooms;
	}

	private List<Pub> search;
	private List<Pub> pubs;
	private List<Pub> filtredpubs;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Pub> getFiltredpubs() {
		return filtredpubs;
	}

	public void setFiltredpubs(List<Pub> filtredpubs) {
		this.filtredpubs = filtredpubs;
	}

	public List<Pub> getPubs() {

		pubs = pubservice.getAllPubs();
		return pubs;

	}

	public String getSearch1() {

		search = pubservice.RecherchePrimaireLocation(adresse, extSurface, intSurface, numberBathrooms, numberGarages, price, rooms, type);
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Successful", "Your message: " + message));
		return "/pages/user/ResultSearch.xhtml?faces-redirect=true";
	}
	public String displayPub(Pub empl) {
		this.setId(empl.getId());
		this.setAdresse(empl.getAdresse());
		this.setExtSurface(empl.getExtSurface());
		this.setIntSurface(empl.getIntSurface());
		this.setNumberBathrooms(empl.getNumberBathrooms());
		this.setNumberGarages(empl.getNumberGarages());
		this.setPrice(empl.getPrice());
		this.setRooms(empl.getRooms());
		this.setType(empl.getType());
		return "/pages/user/Details.xhtml?faces-redirect=true";

			
		}
	public void saveFavs(){
favrepo.Insert();		
	} 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String gotoFilter() {
		return "/pages/user/Filter.xhtml?faces-redirect=true";
		
	}
	public String gotoSearch() {
		return "/pages/user/eyarecherche.xhtml?faces-redirect=true";
		
	}
	public String gotoSearchmap() {
		return "/pages/user/map.xhtml?faces-redirect=true";
		
	}
	public String gotoEstimer() {
		return "/pages/user/map3.xhtml?faces-redirect=true";
		
	}
	public String gotoContact() {
		
		return  "/pages/user/ayoutaa.xhtml?faces-redirect=true";   }
		
			
		
		
	public String gotoEstimate() {
		return "/pages/user/estimate.xhtml?faces-redirect=true";
		
	}
	public String gotoMap3() {
		return "/pages/user/map3.xhtml?faces-redirect=true";
		
	}
	
	
	public float Estimer(){
		esti= pubservice.Estimer(adresse, extSurface, intSurface, numberBathrooms, numberGarages, rooms, type);
		System.out.println(esti);
		return esti;
	}
	
	
	

	public float getEsti() {
		return esti;
	}

	public void setEsti(float esti) {
		this.esti = esti;
	}

	public List<Pub> getSearch() {
		return search;
	}

	public void setSearch(List<Pub> search) {
		this.search = search;
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

	@PostConstruct
	public void init() {
		pubs = pubservice.getAllPubs();
		filtredpubs = pubservice.getAllPubs();
	}

	public boolean filterByPrice(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		if (value == null) {
			return false;
		}

		return ((Comparable) value).compareTo(getInteger(filterText)) > 0;
	}

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (filterText == null || filterText.equals("")) {
			return true;
		}
		int filterInt = getInteger(filterText);

		Pub pub = (Pub) value;
		return pub.getAdresse().toLowerCase().contains(filterText) || pub.getType().toLowerCase().contains(filterText)
				|| pub.getExtSurface() < filterInt || pub.getIntSurface() < filterInt || pub.getRooms() < filterInt
				|| pub.getPrice() < filterInt;
	}

	private int getInteger(String string) {
		try {
			return Integer.valueOf(string);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	public IPubService getPubservice() {
		return pubservice;
	}

	public void setPubservice(IPubService pubservice) {
		this.pubservice = pubservice;
	}

	public void setPubs(List<Pub> pubs) {
		this.pubs = pubs;
	}

}
