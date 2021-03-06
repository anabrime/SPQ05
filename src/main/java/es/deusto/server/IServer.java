package es.deusto.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.jdo.Query;

import org.datanucleus.enhancer.methods.GetTransactionalObjectId;

import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.DTO.RestaurantDTO;
import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Member;
import es.deusto.server.jdo.Reservation;
import es.deusto.server.jdo.Restaurant;
/**
 * Interface of the Server class.
 * 
 * @author Team 05
 *
 */
public interface IServer extends Remote {
	
	public List<RestaurantDTO> getRestaurantByName(String text) throws RemoteException;
	public List<RestaurantDTO> getRestaurantByCategory(String text) throws RemoteException ;
	public List<RestaurantDTO> getRestaurantByPlace(String text)throws RemoteException ;
	public List<RestaurantDTO> getRestaurantByRate(String text)throws RemoteException ;
	public List<RestaurantDTO> getRestaurantByNameAndCategory(String text, String text1)throws RemoteException ;
	public List<RestaurantDTO> getRestaurantByNameAndRate(String text, String text1)throws RemoteException  ;
	public List<RestaurantDTO> getRestaurantByNameAndPlace(String text, String text1) throws RemoteException ;
	public List<RestaurantDTO> getRestaurantByPlaceAndCategory(String text, String text1)throws RemoteException ;
	public List<RestaurantDTO> getRestaurantByPlaceAndRate(String text, String text1)throws RemoteException ;
	public List<RestaurantDTO> getRestaurantByCategoryAndRate(String text, String text1)throws RemoteException ;
	public boolean storeComment(String text, RestaurantDTO restaurant, MemberDTO memberDTO)throws RemoteException;
	public boolean addRateToRestaurant(RestaurantDTO restaurant, String newRate) throws RemoteException;
	public MemberDTO retrieveMember(String name)throws RemoteException ;
	public boolean addMember(String name, String password, String email)throws RemoteException;
	public MemberDTO addPay(MemberDTO memberDTO, int months) throws RemoteException;
	public boolean time(MemberDTO memberDTO) throws RemoteException;
	public Reservation makeBook(String time, String memberName, RestaurantDTO restaurantDTO)throws RemoteException;
	public List<Comment> getAllCommentsOfRestaurant (RestaurantDTO restaurantDTO) throws RemoteException;
}
