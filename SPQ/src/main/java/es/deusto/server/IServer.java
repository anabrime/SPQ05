package es.deusto.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.jdo.Query;

import es.deusto.server.jdo.Restaurant;

public interface IServer extends Remote {
	
	public List<Restaurant> getRestaurantByName(String text) throws RemoteException;
	public List<Restaurant> getRestaurantByCategory(String text) throws RemoteException ;
	public List<Restaurant> getRestaurantByPlace(String text)throws RemoteException ;
	public List<Restaurant> getRestaurantByRate(String text)throws RemoteException ;
	public List<Restaurant> getRestaurantByNameAndCategory(String text, String text1)throws RemoteException ;
	public List<Restaurant> getRestaurantByNameAndRate(String text, String text1)throws RemoteException  ;
	public List<Restaurant> getRestaurantByNameAndPlace(String text, String text1) throws RemoteException ;
	public List<Restaurant> getRestaurantByPlaceAndCategory(String text, String text1)throws RemoteException ;
	public List<Restaurant> getRestaurantByPlaceAndRate(String text, String text1)throws RemoteException ;
	public List<Restaurant> getRestaurantByCategoryAndRate(String text, String text1)throws RemoteException ;
	
}
