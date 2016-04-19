package es.deusto.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")

public class Member implements Serializable {

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String codM = null;
	String email = null;
	String name = null;
	String password = null;

	@Persistent(defaultFetchGroup = "true", mappedBy = "user", dependentElement = "true")
	@Join
	List<Comment> commentsM = new ArrayList<Comment>();

	public Member(String codM, String email, String name, String password, List<Comment> commentsM) {
		super();
		this.codM = codM;
		this.email = email;
		this.name = name;
		this.password = password;
		this.commentsM = commentsM;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCod() {
		return codM;
	}

	@Override
	public String toString() {
		return "Member [codM=" + codM + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", commentsM=" + commentsM + "]";
	}

}
