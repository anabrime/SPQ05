package es.deusto.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")

public class City implements Serializable {

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String codCity = null;
	String nameCity = null;
	String codP = null;
	String codPostal = null;

	@Persistent(defaultFetchGroup = "true", mappedBy = "user", dependentElement = "true")
	@Join
	List<Restaurant> restaurants = new ArrayList<Restaurant>();

	public City(String codCity, String nameCity, String codP, String codPostal, List<Restaurant> restaurants) {
		super();
		this.codCity = codCity;
		this.nameCity = nameCity;
		this.codP = codP;
		this.codPostal = codPostal;
		this.restaurants = restaurants;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public String getCodP() {
		return codP;
	}

	public void setCodP(String codP) {
		this.codP = codP;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getCodCity() {
		return codCity;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public String toString() {
		return "City [codCity=" + codCity + ", nameCity=" + nameCity + ", codP=" + codP + ", codPostal=" + codPostal
				+ ", restaurants=" + restaurants + "]";
	}

}
