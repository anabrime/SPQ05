package es.deusto.server.jdo;

import java.io.Serializable;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * A simple comment class.
 * @author Team 05
 * 
 *
 */
@PersistenceCapable

public class Comment implements Serializable {

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String text = null;
	Member member = null;
	String restaurant = null;

	/**Constructor with parameters
	 * @param text
	 * @param member
	 * @param restaurant
	 */
	public Comment(String text, Member member, String restaurant) {
		super();
		this.text = text;
		this.restaurant = restaurant;
		this.member = member;
	}

	/**
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/** Method toString
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return null;
	}
	
	/**
	 * @return a restaurant
	 */
	public String getRestaurant(){
		return this.restaurant;
	}

}
