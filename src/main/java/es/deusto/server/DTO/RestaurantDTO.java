package es.deusto.server.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.server.jdo.City;
import es.deusto.server.jdo.Comment;

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

	@Persistent(mappedBy = "member", dependentElement = "true")
	@Join
	List<Comment> commentsR = new ArrayList<Comment>();
	public RestaurantDTO(){
		this.nameR="";
		this.rate="";
		this.numRates="";
		this.category="";
		this.street="";
		this.city=null;
	}
	public RestaurantDTO (String nameR, String rate, String numRates,
			String category, String street, List<Comment> commentsR, City city) {
		super();
		this.nameR = nameR;
		this.rate = rate;
		this.numRates = numRates;
		this.category = category;
		this.street = street;
		this.commentsR = commentsR;
		this.city=city;
	}
	private static final long serialVersionUID = 1L;
	
	public City getCity() {
		return city;
	}

	public String getNameR() {
		return nameR;
	}

	public void setNameR(String nameR) {
		this.nameR = nameR;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getNumRates() {
		return numRates;
	}

	public void setNumRates(String numRates) {
		this.numRates = numRates;
	}

	public String getCategpry() {
		return category;
	}

	public void setCategpry(String categpry) {
		this.category = categpry;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Comment> getCommentsR() {
		return commentsR;
	}

	public void setCommentsR(List<Comment> commentsR) {
		this.commentsR = commentsR;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public void setCity(City city) {
		this.city = city;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

}
