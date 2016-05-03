package es.deusto.server.jdo;

import java.io.Serializable;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable

public class Comment implements Serializable {

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	@PrimaryKey
	String codR = null;
	String codM = null;
=======
>>>>>>> branch 'master' of https://github.com/jb25/spq
	String text = null;
	@PrimaryKey
	Member member = null;
	@PrimaryKey
	Restaurant restaurant = null;

	public Comment(String text, Member member, Restaurant restaurant) {
		super();
<<<<<<< HEAD
		this.codR = codR;
		this.codM = codM;
=======

>>>>>>> branch 'master' of https://github.com/jb25/spq
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
<<<<<<< HEAD
		return null;
=======
		return "Comment [text=" + text + ", member=" + member + ", restaurant=" + restaurant + "]";
>>>>>>> branch 'master' of https://github.com/jb25/spq
	}

}
