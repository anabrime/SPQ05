package es.deusto.data;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")

public class Province implements Serializable {

	/**
	 * User implements Serializable to be transferred to the RMI client
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String codP = null;
	String name = null;

	@Persistent(defaultFetchGroup = "true", mappedBy = "user", dependentElement = "true")
	@Join
	List<City> cities = new ArrayList<City>();

	public Province(String codP, String name, List<City> cities) {
		super();
		this.codP = codP;
		this.name = name;
		this.cities = cities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodP() {
		return codP;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Province [codP=" + codP + ", name=" + name + ", cities=" + cities + "]";
	}

}
