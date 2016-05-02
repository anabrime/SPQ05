package es.deusto.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")

public class Restaurant implements Serializable {

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String nameR = null;
	String codComment = null;
	String rate = null;
	String numRates = null;
	String category = null;
	String street = null;
	String description = null;
	String pathImagen = null;
	@PrimaryKey
	City city = null;

	@Persistent(mappedBy = "member", dependentElement = "true")
	@Join
	List<Comment> commentsR = new ArrayList<Comment>();

	public Restaurant() {
		this.nameR = "";
		this.codComment = "";
		this.rate = "";
		this.numRates = "";
		this.category = "";
		this.street = "";
		this.city = null;
		this.description = "";
		this.pathImagen = "";
	}

	public Restaurant(String nameR, String codComment, String rate, String numRates, String category, String street,
			List<Comment> commentsR, String description, String pathImagen) {
		super();
		this.nameR = nameR;
		this.codComment = codComment;
		this.rate = rate;
		this.numRates = numRates;
		this.category = category;
		this.street = street;
		this.commentsR = commentsR;
		this.description = description;
		this.pathImagen = pathImagen;
	}

	public String getNameR() {
		return nameR;
	}

	public void setNameR(String nameR) {
		this.nameR = nameR;
	}

	public String getCodComment() {
		return codComment;
	}

	public void setCodComment(String codComment) {
		this.codComment = codComment;
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
		return "Restaurant [nameR=" + nameR + ", codComment=" + codComment + ", rate=" + rate + ", numRates=" + numRates
				+ ", category=" + category + ", street=" + street + ", description=" + description + ", city=" + city
				+ ", commentsR=" + commentsR + "]";
	}

}
