/**@package es.deusto.server.DTO
   @brief Package composed by classes CommentDTO, MemberDTO and RestaurantDTO
 */
package es.deusto.server.DTO;

import javax.jdo.annotations.PrimaryKey;

import es.deusto.server.jdo.Member;
import es.deusto.server.jdo.Restaurant;

/** A simple commentDTO class
 * 
 * @author Team 05
 *
 */
public class CommentDTO {
	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String text = null;
	Member member = null;
	Restaurant restaurant = null;

	/** Constructor class
	 * @param text
	 * @param member
	 * @param restaurant
	 */
	public CommentDTO(String text, Member member, Restaurant restaurant) {
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

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return null;
	}

	/**
	 * @return restaurant
	 */
	public Restaurant getRestaurant(){
		return this.restaurant;
	}

}
