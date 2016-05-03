package es.deusto.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import es.deusto.server.DAO.RestaurantAdvisorDAO;
import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Restaurant;


public class Server extends UnicastRemoteObject implements IServer {

	protected Server() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;
	private RestaurantAdvisorDAO dao;

	
	public Restaurant getRestaurantByName(String text) throws RemoteException {
		dao.getRestaurantByName(text);
		return null;
	}

	public Restaurant getRestaurantByCategory(String text)throws RemoteException  {
		dao.getRestaurantByCategory(text);
		return null;
	}

	public Restaurant getRestaurantByPlace(String text) throws RemoteException {
		dao.getRestaurantByPlace(text);
		return null;
	}

	public Restaurant getRestaurantByRate(String text) throws RemoteException {
		dao.getRestaurantByRate(text);
		return null;
	}

	public Restaurant getRestaurantByNameAndCategory(String text, String text1) throws RemoteException {
		dao.getRestaurantByNameAndCategory(text,text1);
		return null;
	}

	public Restaurant getRestaurantByNameAndRate(String text, String text1)throws RemoteException  {
		dao.getRestaurantByNameAndRate(text,text1);
		return null;
	}

	public Restaurant getRestaurantByNameAndPlace(String text, String text1) throws RemoteException {
		dao.getRestaurantByNameAndPlace(text,text1);
		return null;
	}

	public Restaurant getRestaurantByPlaceAndCategory(String text, String text1)throws RemoteException  {
		dao.getRestaurantByPlaceAndCategory(text,text1);
		return null;
	}

	public Restaurant getRestaurantByPlaceAndRate(String text, String text1)throws RemoteException  {
		dao.getRestaurantByPlaceAndRate(text,text1);
		return null;
	}

	public Restaurant getRestaurantByCategoryAndRate(String text, String text1)throws RemoteException  {
		dao.getRestaurantByCategoryAndRate(text,text1);
		return null;
	}
	public boolean setComment(Comment comment)throws RemoteException  {
		return dao.storeComment(comment);
	}
	public boolean addRateToRestaurant(Restaurant restaurant, String newRate) throws RemoteException{
		return dao.addRateToRestaurant(restaurant, newRate);
	}
	public Member getMember(String name)throws RemoteException  {
		dao.getMember(name);
		return null;
	}
	public void addMember(String name, String password, String email){
		dao.addMember(name, password, email);
	}
	
	
}
