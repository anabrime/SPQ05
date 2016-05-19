package es.deusto.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**A simple restaurant class.
 * @author Team 05
 *
 */
@PersistenceCapable

public class Restaurant{

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
	City city = new City();
	//Cambios
	List<Reservation> reservation;

	@Persistent(mappedBy = "member", dependentElement = "true")
	@Join
	List<Comment> commentsR = new ArrayList<Comment>();
	
	/**
	 * Constructor method
	 */
	public Restaurant(){
		this.nameR="";
		this.rate="";
		this.numRates="";
		this.category="";
		this.street="";
		this.city=null;
		this.reservation = new ArrayList<Reservation>();
	}
	/** Constructor with parameters
	 * @param nameR
	 * @param rate
	 * @param numRates
	 * @param category
	 * @param street
	 * @param commentsR
	 * @param city
	 */
	public Restaurant(String nameR, String rate, String numRates,
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
	 * @return a name of a restaurant
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
	 * @return a list of comments of the restaurants
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
	 * @return a image
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
	 * @return a list of reservations
	 */
	public List<Reservation> getReservations() {
		return reservation;
	}

	/**
	 * @param reservation
	 */
	public void setReservations(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	/** Add a reservation
	 * @param reservation
	 */
	public void addReservation(Reservation reservation){
		this.reservation.add(reservation);	
	}

}
