/**@package es.deusto.server
   @brief Package composed by classes CreateDB, Main and Server which inherit from IServer. And also by the packages DAO, DTO and jdo
*/
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
/**
 * Implements the interface IServer, it creates a new RestaurantAdvisorDAO and uses for all the methods.
 * 
 * @author Team 05
 * @param dao RestaurantAdvisorDAO
 */

public class Server extends UnicastRemoteObject implements IServer {

	protected Server() throws RemoteException {
		super();
//		createDatabase();
	}

	private static final long serialVersionUID = 1L;
	private RestaurantAdvisorDAO dao = new RestaurantAdvisorDAO();

	
	/** Get the restaurants by name
	 * @see es.deusto.server.IServer#getRestaurantByName(java.lang.String)
	 */
	public List<RestaurantDTO> getRestaurantByName(String text) throws RemoteException {
		return dao.getRestaurantByName(text);
	}

	/** Get the restaurant by category
	 * @see es.deusto.server.IServer#getRestaurantByCategory(java.lang.String)
	 */
	public List<RestaurantDTO> getRestaurantByCategory(String text)throws RemoteException  {
		return dao.getRestaurantByCategory(text);
	}

	/** Get the restaurant by place
	 * @see es.deusto.server.IServer#getRestaurantByPlace(java.lang.String)
	 */
	public List<RestaurantDTO> getRestaurantByPlace(String text) throws RemoteException {
		return dao.getRestaurantByPlace(text);
	}

	/** Get the restaurant by rate
	 * @see es.deusto.server.IServer#getRestaurantByRate(java.lang.String)
	 */
	public List<RestaurantDTO> getRestaurantByRate(String text) throws RemoteException {
		return dao.getRestaurantByRate(text);
	}

	/** Get the restaurant by name and category
	 * @see es.deusto.server.IServer#getRestaurantByNameAndCategory(java.lang.String, java.lang.String)
	 */
	public List<RestaurantDTO> getRestaurantByNameAndCategory(String text, String text1) throws RemoteException {
		return dao.getRestaurantByNameAndCategory(text,text1);
	}

	/** Get the restaurant by name and rate
	 * @see es.deusto.server.IServer#getRestaurantByNameAndRate(java.lang.String, java.lang.String)
	 */
	public List<RestaurantDTO> getRestaurantByNameAndRate(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByNameAndRate(text,text1);
	}

	/** Get the restaurant by name and place
	 * @see es.deusto.server.IServer#getRestaurantByNameAndPlace(java.lang.String, java.lang.String)
	 */
	public List<RestaurantDTO> getRestaurantByNameAndPlace(String text, String text1) throws RemoteException {
		return dao.getRestaurantByNameAndPlace(text,text1);
	}

	/** Get the restaurant by place and category
	 * @see es.deusto.server.IServer#getRestaurantByPlaceAndCategory(java.lang.String, java.lang.String)
	 */
	public List<RestaurantDTO> getRestaurantByPlaceAndCategory(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByPlaceAndCategory(text,text1);
	}

	/** Get the restaurant by place and rate
	 * @see es.deusto.server.IServer#getRestaurantByPlaceAndRate(java.lang.String, java.lang.String)
	 */
	public List<RestaurantDTO> getRestaurantByPlaceAndRate(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByPlaceAndRate(text,text1);
	}

	/** Get the restaurant by category and rate
	 * @see es.deusto.server.IServer#getRestaurantByCategoryAndRate(java.lang.String, java.lang.String)
	 */
	public List<RestaurantDTO> getRestaurantByCategoryAndRate(String text, String text1)throws RemoteException  {
		return dao.getRestaurantByCategoryAndRate(text,text1);
	}
	
	/**
	 * Create de DB
	 */
	public void createDatabase() {
		dao.createDatabase();
	}
	/** Store the comments
	 * @see es.deusto.server.IServer#storeComment(java.lang.String, es.deusto.server.DTO.RestaurantDTO, es.deusto.server.DTO.MemberDTO)
	 */
	public boolean storeComment(String text, RestaurantDTO restaurant, MemberDTO memberDTO)throws RemoteException  {
		return dao.storeComment(text, restaurant, memberDTO);
	}
	/** Add a rate to a restaurant
	 * @see es.deusto.server.IServer#addRateToRestaurant(es.deusto.server.DTO.RestaurantDTO, java.lang.String)
	 */
	public boolean addRateToRestaurant(RestaurantDTO restaurant, String newRate) throws RemoteException{
		return dao.addRateToRestaurant(restaurant, newRate);
	}
	/** Retrieve a member
	 * @see es.deusto.server.IServer#retrieveMember(java.lang.String)
	 */
	public MemberDTO retrieveMember(String name) throws RemoteException  {
		return dao.retrieveMember(name);
	}
	/** Add a member to the dao
	 * @see es.deusto.server.IServer#addMember(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean addMember(String name, String password, String email){
		return dao.addMember(name, password, email);
	}

	/** Add a payment
	 * @see es.deusto.server.IServer#addPay(es.deusto.server.DTO.MemberDTO, int)
	 */
	public MemberDTO addPay(MemberDTO memberDTO, int months)throws RemoteException  {
		return dao.addPay(memberDTO, months);
	}
	
	/** Put the time on the memberDTO
	 * @see es.deusto.server.IServer#time(es.deusto.server.DTO.MemberDTO)
	 */
	public boolean time(MemberDTO memberDTO)throws RemoteException{
		return dao.time(memberDTO);
	}
	
	/** Make a booking
	 * @see es.deusto.server.IServer#makeBook(java.lang.String, java.lang.String, es.deusto.server.DTO.RestaurantDTO)
	 */
	public Reservation makeBook(String time, String memberName, RestaurantDTO restaurantDTO)throws RemoteException{
		return dao.makeBook(time, memberName, restaurantDTO);
	}
	
	/** Get all the comments of a restaurant in a list
	 * @see es.deusto.server.IServer#getAllCommentsOfRestaurant(es.deusto.server.DTO.RestaurantDTO)
	 */
	public List<Comment> getAllCommentsOfRestaurant (RestaurantDTO restaurantDTO) throws RemoteException{
		return dao.getAllCommentsOfRestaurant(restaurantDTO);
	}
}
