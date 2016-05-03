package es.deusto.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable

public class Restaurant implements Serializable {

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */

	@PrimaryKey
	String nameR = null;
	String rate = null;
	String numRates = null;
	String category = null;
	String street = null;
<<<<<<< HEAD
	
	City city = new City();
=======
	String description = null;
	String pathImagen = null;
	@PrimaryKey
	City city = null;
>>>>>>> branch 'master' of https://github.com/jb25/spq

	@Persistent(mappedBy = "member", dependentElement = "true")
	@Join
	List<Comment> commentsR = new ArrayList<Comment>();

<<<<<<< HEAD
	
	public Restaurant(){
		this.nameR="";
		this.rate="";
		this.numRates="";
		this.category="";
		this.street="";
		this.city=null;
=======
	public Restaurant() {
		this.nameR = "";
		this.rate = "";
		this.numRates = "";
		this.category = "";
		this.street = "";
		this.city = null;
		this.description = "";
		this.pathImagen = "";
>>>>>>> branch 'master' of https://github.com/jb25/spq
	}
<<<<<<< HEAD
	public Restaurant(String nameR, String rate, String numRates,
			String category, String street, List<Comment> commentsR, City city) {
=======

	public Restaurant(String nameR, String rate, String numRates, String category, String street,
			List<Comment> commentsR, String description, String pathImagen) {
>>>>>>> branch 'master' of https://github.com/jb25/spq
		super();
		this.nameR = nameR;
		this.rate = rate;
		this.numRates = numRates;
		this.category = category;
		this.street = street;
		this.commentsR = commentsR;
<<<<<<< HEAD
		this.city=city;
	}
	private static final long serialVersionUID = 1L;
	
	public City getCity() {
		return city;
=======
		this.description = description;
		this.pathImagen = pathImagen;
>>>>>>> branch 'master' of https://github.com/jb25/spq
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

	public City getCity() {
		return city;
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

	@Override
	public String toString() {
<<<<<<< HEAD
		return getNameR();
=======
		return "Restaurant [nameR=" + nameR + ", codComment=" + codComment + ", rate=" + rate + ", numRates=" + numRates
				+ ", category=" + category + ", street=" + street + ", description=" + description + ", city=" + city
				+ ", commentsR=" + commentsR + "]";
>>>>>>> branch 'master' of https://github.com/jb25/spq
	}

}
