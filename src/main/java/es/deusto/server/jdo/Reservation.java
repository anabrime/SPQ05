package es.deusto.server.jdo;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reservation {

	@PrimaryKey
	String time;
	String memberName;
	String restaurantName;
	
	public Reservation(){
		this.memberName = "";
		this.restaurantName = "";
		this.time = "";
	}
	public Reservation(String time, String memberName, String restaurantName){
		this.time = time;
		this.memberName = memberName;
		this.restaurantName = restaurantName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
