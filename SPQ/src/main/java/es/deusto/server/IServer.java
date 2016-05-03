package es.deusto.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jdo.Query;

import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Restaurant;

public interface IServer extends Remote {
	
	public Restaurant getRestaurantByName(String text) throws RemoteException;
	public Restaurant getRestaurantByCategory(String text) throws RemoteException ;
	public Restaurant getRestaurantByPlace(String text)throws RemoteException ;
	public Restaurant getRestaurantByRate(String text)throws RemoteException ;
	public Restaurant getRestaurantByNameAndCategory(String text, String text1)throws RemoteException ;
	public Restaurant getRestaurantByNameAndRate(String text, String text1)throws RemoteException  ;
	public Restaurant getRestaurantByNameAndPlace(String text, String text1) throws RemoteException ;
	public Restaurant getRestaurantByPlaceAndCategory(String text, String text1)throws RemoteException ;
	public Restaurant getRestaurantByPlaceAndRate(String text, String text1)throws RemoteException ;
	public Restaurant getRestaurantByCategoryAndRate(String text, String text1)throws RemoteException ;
	public boolean setComment(Comment comment)throws RemoteException;
	public boolean addRateToRestaurant(Restaurant restaurant, String newRate) throws RemoteException;
	public Member getMember(String name)throws RemoteException ;
	public void addMember(String name, String password, String email)throws RemoteException;
}
