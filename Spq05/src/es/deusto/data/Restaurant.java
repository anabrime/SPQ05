package es.deusto.data;

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
	String codR = null;
	String nameR = null;
	String codCiudad = null;
	String codComment = null;
	int rate = 0;
	int numRates = 0;
	String category = null;
	String street = null;

	@Persistent(defaultFetchGroup = "true", mappedBy = "user", dependentElement = "true")
	@Join
	List<Comment> commentsR = new ArrayList<Comment>();

	public Restaurant(String codR, String nameR, String codCiudad, String codComment, int rate, int numRates,
			String category, String street, List<Comment> commentsR) {
		super();
		this.codR = codR;
		this.nameR = nameR;
		this.codCiudad = codCiudad;
		this.codComment = codComment;
		this.rate = rate;
		this.numRates = numRates;
		this.category = category;
		this.street = street;
		this.commentsR = commentsR;
	}

	public String getNameR() {
		return nameR;
	}

	public void setNameR(String nameR) {
		this.nameR = nameR;
	}

	public String getCodCiudad() {
		return codCiudad;
	}

	public void setCodCiudad(String codCiudad) {
		this.codCiudad = codCiudad;
	}

	public String getCodComment() {
		return codComment;
	}

	public void setCodComment(String codComment) {
		this.codComment = codComment;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getNumRates() {
		return numRates;
	}

	public void setNumRates(int numRates) {
		this.numRates = numRates;
	}

	public String getCategpry() {
		return category;
	}

	public void setCategpry(String categpry) {
		this.category = categpry;
	}

	public String getCodR() {
		return codR;
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

	@Override
	public String toString() {
		return "Restaurant [codR=" + codR + ", nameR=" + nameR + ", codCiudad=" + codCiudad + ", codComment="
				+ codComment + ", rate=" + rate + ", numRates=" + numRates + ", category=" + category + ", street="
				+ street + ", commentsR=" + commentsR + "]";
	}

}
