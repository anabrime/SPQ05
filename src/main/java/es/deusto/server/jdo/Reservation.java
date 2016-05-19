package es.deusto.server.jdo;

import java.io.Serializable;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/** A simple member class.
 * @author Team 05
 *
 */
@PersistenceCapable
public class Reservation implements Serializable{

	@PrimaryKey
	String time;
	String memberName;
	@PrimaryKey
	String restaurantName;
	
	/**
	 * Constructor method
	 */
	public Reservation(){
		this.memberName = "";
		this.restaurantName = "";
		this.time = "";
	}
	/**Constructor with parameters
	 * @param time
	 * @param memberName
	 * @param restaurantName
	 */
	public Reservation(String time, String memberName, String restaurantName){
		this.time = time;
		this.memberName = memberName;
		this.restaurantName = restaurantName;
	}
	/**
	 * @return time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the name of the member
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * @param memberName
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * @return the name of the restaurant
	 */
	public String getRestaurantName() {
		return restaurantName;
	}
	/**
	 * @param restaurantName
	 */
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
