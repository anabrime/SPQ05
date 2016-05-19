/**@package es.deusto.server.jdo
   @brief Package composed by classes City, Comment, Member, Reservation, Restaurant
 */
package es.deusto.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/** A simple city class.
 * @author Team 05
 * 
 */
@PersistenceCapable

public class City implements Serializable {

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String nameCity = "";
	String codPostal = "";

	@Persistent(mappedBy = "city", dependentElement = "true")
	@Join
	List<Restaurant> restaurants = new ArrayList<Restaurant>();

	/**
	 * Constructor method
	 */
	public City(){}
	/** Constructor with parameters
	 * @param nameCity
	 * @param codPostal
	 * @param restaurants
	 */
	public City( String nameCity, String codPostal, List<Restaurant> restaurants) {
		super();
		this.nameCity = nameCity;
		this.codPostal = codPostal;
		this.restaurants = restaurants;
	}

	/**
	 * @return name of the city
	 */
	public String getNameCity() {
		return nameCity;
	}

	/**
	 * @param nameCity
	 */
	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	/**
	 * @return postal code
	 */
	public String getCodPostal() {
		return codPostal;
	}

	/**
	 * @param codPostal
	 */
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	/**
	 * @return a list of restaurants
	 */
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	/**
	 * @param restaurants
	 */
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}



}
