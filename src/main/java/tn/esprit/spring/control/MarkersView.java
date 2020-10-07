package tn.esprit.spring.control;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.coordinates;
import tn.esprit.spring.repository.coordinatesRepository;

@Named
@RequestScoped
public class MarkersView implements Serializable {

	@Autowired
	coordinatesRepository cor;

	private MapModel simpleModel;
	private String centerGeoMap = "41.850033, -87.6500523";
	private List<coordinates> items = null;
	private static final long serialVersionUID = -1396669830860400871L;
	private long l;

	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();
		items = cor.findAll();

		for (coordinates coor : items) {
			LatLng coord1 = new LatLng(coor.getLat(), coor.getLang());
			simpleModel.addOverlay(new Marker(coord1, coor.getAddress()));
		}
	}
	public void onGeocode(GeocodeEvent event) {
		
        List<GeocodeResult> results = event.getResults();
         
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();
             
            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                simpleModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
            }
        }
    }
	public String getCenterGeoMap() {
        return centerGeoMap;
    }
	/*
	 * // Shared coordinates LatLng coord1 = new LatLng(36.879466, 30.667648);
	 * LatLng coord2 = new LatLng(36.883707, 30.689216); LatLng coord3 = new
	 * LatLng(36.879703, 30.706707); LatLng coord4 = new LatLng(36.885233,
	 * 30.702323);
	 * 
	 * // Basic marker simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
	 * simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
	 * simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
	 * simpleModel.addOverlay(new Marker(coord4, "Kaleici")); }
	 */

	public MapModel getSimpleModel() {
		return simpleModel;}

}
