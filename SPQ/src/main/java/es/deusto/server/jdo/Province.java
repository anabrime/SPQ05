package es.deusto.server.jdo;

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
	String name = null;

	@Persistent(mappedBy = "province", dependentElement = "true")
	@Join
	List<City> cities = new ArrayList<City>();

	public Province(String name, List<City> cities) {
		super();
		this.name = name;
		this.cities = cities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Province [name=" + name + ", cities=" + cities + "]";
	}

}
