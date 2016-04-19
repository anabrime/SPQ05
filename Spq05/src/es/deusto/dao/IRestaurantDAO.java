package es.deusto.dao;

import es.deusto.data.Restaurant;

public interface IRestaurantDAO {

	public void storeRestaurant(Restaurant restaurant);
	public Restaurant retrieveRestaurantByCod(String codR);
	public Restaurant retrieveRestaurantByName(String nameR);
	public void updateRestraurant(Restaurant restaurant);	
	

}
