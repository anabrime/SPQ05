package es.deusto.server.DTO;

import javax.jdo.annotations.PrimaryKey;

import es.deusto.server.jdo.Member;
import es.deusto.server.jdo.Restaurant;

public class CommentDTO {
	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String text = null;
	Member member = null;
	Restaurant restaurant = null;

	public CommentDTO(String text, Member member, Restaurant restaurant) {
		super();
		this.text = text;
		this.restaurant = restaurant;
		this.member = member;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return null;
	}
	
	public Restaurant getRestaurant(){
		return this.restaurant;
	}

}
