package es.deusto.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.server.DAO.RestaurantAdvisorDAO;
import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Member;
import es.deusto.server.jdo.Restaurant;


public class Server extends UnicastRemoteObject implements IServer {

	protected Server() throws RemoteException {
		super();
//		createDatabase();
	}

	private static final long serialVersionUID = 1L;
	private RestaurantAdvisorDAO dao = new RestaurantAdvisorDAO();

	
	public List<Restaurant> getRestaurantByName(String text) throws RemoteException {
		return dao.getRestaurantByName(text);
	}

	public List<Restaurant> getRestaurantByCategory(String text)throws RemoteException  {
		return dao.getRestaurantByCategory(text);
	}

	public List<Restaurant> getRestaurantByPlace(String text) throws RemoteException {
		return dao.getRestaurantByPlace(text);
	}

	public List<Restaurant> getRestaurantByRate(String text) throws RemoteException {
		return dao.getRestaurantByRate(text);
	}

	public List<Restaurant> getRestaurantByNameAndCategory(String text, String text1) throws RemoteException {
		return dao.getRestaurantByNameAndCategory(text,text1);
	}

	public List<Restaurant> getRestaurantByNameAndRate(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByNameAndRate(text,text1);
	}

	public List<Restaurant> getRestaurantByNameAndPlace(String text, String text1) throws RemoteException {
		return dao.getRestaurantByNameAndPlace(text,text1);
	}

	public List<Restaurant> getRestaurantByPlaceAndCategory(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByPlaceAndCategory(text,text1);
	}

	public List<Restaurant> getRestaurantByPlaceAndRate(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByPlaceAndRate(text,text1);
	}

	public List<Restaurant> getRestaurantByCategoryAndRate(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByCategoryAndRate(text,text1);
	}
	
	public void createDatabase() {
		dao.createDatabase();
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
