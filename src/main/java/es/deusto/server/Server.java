package es.deusto.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.server.DAO.RestaurantAdvisorDAO;
import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.DTO.RestaurantDTO;
import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Member;
import es.deusto.server.jdo.Reservation;
import es.deusto.server.jdo.Restaurant;


public class Server extends UnicastRemoteObject implements IServer {

	protected Server() throws RemoteException {
		super();
//		createDatabase();
	}

	private static final long serialVersionUID = 1L;
	private RestaurantAdvisorDAO dao = new RestaurantAdvisorDAO();

	
	public List<RestaurantDTO> getRestaurantByName(String text) throws RemoteException {
		return dao.getRestaurantByName(text);
	}

	public List<RestaurantDTO> getRestaurantByCategory(String text)throws RemoteException  {
		return dao.getRestaurantByCategory(text);
	}

	public List<RestaurantDTO> getRestaurantByPlace(String text) throws RemoteException {
		return dao.getRestaurantByPlace(text);
	}

	public List<RestaurantDTO> getRestaurantByRate(String text) throws RemoteException {
		return dao.getRestaurantByRate(text);
	}

	public List<RestaurantDTO> getRestaurantByNameAndCategory(String text, String text1) throws RemoteException {
		return dao.getRestaurantByNameAndCategory(text,text1);
	}

	public List<RestaurantDTO> getRestaurantByNameAndRate(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByNameAndRate(text,text1);
	}

	public List<RestaurantDTO> getRestaurantByNameAndPlace(String text, String text1) throws RemoteException {
		return dao.getRestaurantByNameAndPlace(text,text1);
	}

	public List<RestaurantDTO> getRestaurantByPlaceAndCategory(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByPlaceAndCategory(text,text1);
	}

	public List<RestaurantDTO> getRestaurantByPlaceAndRate(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByPlaceAndRate(text,text1);
	}

	public List<RestaurantDTO> getRestaurantByCategoryAndRate(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByCategoryAndRate(text,text1);
	}
	
	public void createDatabase() {
		dao.createDatabase();
	}
	public boolean storeComment(String text, RestaurantDTO restaurant, MemberDTO memberDTO)throws RemoteException  {
		return dao.storeComment(text, restaurant, memberDTO);
	}
	public boolean addRateToRestaurant(RestaurantDTO restaurant, String newRate) throws RemoteException{
		return dao.addRateToRestaurant(restaurant, newRate);
	}
	public MemberDTO retrieveMember(String name) throws RemoteException  {
		return dao.retrieveMember(name);
	}
	public boolean addMember(String name, String password, String email){
		return dao.addMember(name, password, email);
	}

	public MemberDTO addPay(MemberDTO memberDTO, int months)throws RemoteException  {
		return dao.addPay(memberDTO, months);
	}
	
	public boolean time(MemberDTO memberDTO)throws RemoteException{
		return dao.time(memberDTO);
	}
	
	public Reservation makeBook(String time, String memberName, RestaurantDTO restaurantDTO)throws RemoteException{
		return dao.makeBook(time, memberName, restaurantDTO);
	}
	
	public List<Comment> getAllCommentsOfRestaurant (RestaurantDTO restaurantDTO) throws RemoteException{
		return dao.getAllCommentsOfRestaurant(restaurantDTO);
	}
}
