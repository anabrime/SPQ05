package es.deusto.data;

import java.io.Serializable;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")

public class Comment implements Serializable {

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String codComent = null;
	String codR = null;
	String codM = null;
	String text = null;

	public Comment(String codComent, String codR, String codM, String text) {
		super();
		this.codComent = codComent;
		this.codR = codR;
		this.codM = codM;
		this.text = text;
	}

	public String getCodR() {
		return codR;
	}

	public void setCodR(String codR) {
		this.codR = codR;
	}

	public String getCodM() {
		return codM;
	}

	public void setCodM(String codM) {
		this.codM = codM;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCodComent() {
		return codComent;
	}

	@Override
	public String toString() {
		return "Comment [codComent=" + codComent + ", codR=" + codR + ", codM=" + codM + ", text=" + text + "]";
	}

}
