package es.deusto.server.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.server.jdo.City;
import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Reservation;
import es.deusto.server.jdo.Restaurant;

/**
 * A simple restaurantDTO
 * 
 * @author Team 05
 *
 */
public class RestaurantDTO implements Serializable{

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */

	@PrimaryKey
	String nameR = null;
	String rate = null;
	String numRates = null;
	String category = null;
	String street = null;
	String description = null;
	String pathImagen = null;
	City city = null;

	List<Reservation> reservation;

	@Persistent(mappedBy = "member", dependentElement = "true")
	@Join
	List<Comment> commentsR = new ArrayList<Comment>();
	/**
	 * Constructor method
	 */
	public RestaurantDTO(){
		this.nameR="";
		this.rate="";
		this.numRates="";
		this.category="";
		this.street="";
		this.city=null;
	}
	/**
	 * @param restaurant
	 */
	public RestaurantDTO (Restaurant restaurant) {
		super();
		this.nameR = restaurant.getNameR();
		this.rate = restaurant.getRate();
		this.numRates = restaurant.getNumRates();
		this.category = restaurant.getCategory();
		this.street = restaurant.getStreet();
		this.commentsR = restaurant.getCommentsR();
		this.city= restaurant.getCity();
		this.reservation = new ArrayList<Reservation>();
	}
	
	/**
	 * @param nameR
	 * @param rate
	 * @param numRates
	 * @param category
	 * @param street
	 * @param commentsR
	 * @param city
	 */
	public RestaurantDTO(String nameR, String rate, String numRates,
			String category, String street, List<Comment> commentsR, City city) {
		super();
		this.nameR = nameR;
		this.rate = rate;
		this.numRates = numRates;
		this.category = category;
		this.street = street;
		this.commentsR = commentsR;
		this.city=city;
		this.reservation = new ArrayList<Reservation>();
	}
	private static final long serialVersionUID = 1L;
	
	/**
	 * @return city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @return name of the restaurant
	 */
	public String getNameR() {
		return nameR;
	}

	/**
	 * @param nameR
	 */
	public void setNameR(String nameR) {
		this.nameR = nameR;
	}

	/**
	 * @return rate
	 */
	public String getRate() {
		return rate;
	}

	/**
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}

	/**
	 * @return number of rates
	 */
	public String getNumRates() {
		return numRates;
	}

	/**
	 * @param numRates
	 */
	public void setNumRates(String numRates) {
		this.numRates = numRates;
	}

	/**
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return comments of the restaurants
	 */
	public List<Comment> getCommentsR() {
		return commentsR;
	}

	/**
	 * @param commentsR
	 */
	public void setCommentsR(List<Comment> commentsR) {
		this.commentsR = commentsR;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @param city
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the image
	 */
	public String getPathImagen() {
		return pathImagen;
	}

	/**
	 * @param pathImagen
	 */
	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
	
	//Cambios
	/**
	 * @return a reservation
	 */
	public List<Reservation> getReservations() {
		return reservation;
	}

	/**Change a reservation
	 * @param reservation
	 */
	public void setReservations(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	/**Add a reservation
	 * @param reservation
	 */
	public void addReservation(Reservation reservation){
		this.reservation.add(reservation);
	}

}
