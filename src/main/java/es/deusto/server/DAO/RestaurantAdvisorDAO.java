/**@package es.deusto.server.DAO
   @brief Package composed by classes RestaurantAdvisorDAO and UserDAO which inherit from IUserDAO
*/
package es.deusto.server.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.swing.JOptionPane;

import es.deusto.server.DTO.CommentDTO;
import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.DTO.RestaurantDTO;
import es.deusto.server.jdo.*;

import es.deusto.server.jdo.*;

/**
 * DAO of the Restaurant Advisor, it contains the Load Persistence Manager Factory, the Persistence Manager and the Transaction to group DB operations.
 * 
 * @author Team 05
 */
public class RestaurantAdvisorDAO {
	// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	// Persistence Manager
	PersistenceManager pm = null;
	//Transaction to group DB operations
	Transaction tx = null;	

	/**
	 * @param text
	 * Get the information of the restaurant by name from the DB
	 * @return a list of restaurantDTO
	 */
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByName(String text) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getNameR().equals(text))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));				
			}
			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	/**
	 * @param text
	 * Get the information of the restaurant by category from the DB
	 * @return a list of restaurantDTO
	 */
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByCategory(String text) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getCategory().equals(text))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));				
			}
			System.out.println(r.get(0).toString());
			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	/**
	 * @param text
	 * Get the information of the restaurant by place from the DB
	 * @return a list of restaurantDTO
	 */
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByPlace(String text) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getCity().toString().equals(text))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));			
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	/**
	 * @param text
	 * Get the information of the restaurant by rate from the DB
	 * @return a list of restaurantDTO
	 */
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByRate(String text) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getRate().equals(text))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));			
			}
			System.out.println(r);

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	/**
	 * @param text
	 * @param text1
	 * Get the information of the restaurant by name and category from the DB
	 * @return a list of restaurantDTO
	 */
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByNameAndCategory(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getNameR().equals(text) && restaurant.getCategory().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));				
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	/**
	 * @param text
	 * @param text1
	 * Get the information of the restaurant by name and rate from the DB
	 * @return a list of restaurantDTO
	 */
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByNameAndRate(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getNameR().equals(text) && restaurant.getRate().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));				
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	/**
	 * @param text
	 * @param text1
	 * Get the information of the restaurant by name and place from the DB
	 * @return a list of restaurantDTO
	 */
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByNameAndPlace(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getNameR().equals(text) && restaurant.getCity().toString().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));					
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}


	}
	/**
	 * @param text
	 * @param text1
	 * Get the information of the restaurant by place and category from the DB
	 * @return a list of restaurantDTO
	 */

	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByPlaceAndCategory(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getCity().toString().equals(text) && restaurant.getCategory().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));					
			}

			tx.commit();
			System.out.println("Restaurant  retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	/**
	 * @param text
	 * @param text1
	 * Get the information of the restaurant by place and rate from the DB
	 * @return a list of restaurantDTO
	 */

	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByPlaceAndRate(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getCity().toString().equals(text) && restaurant.getRate().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));			
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}
	}
	/**
	 * @param text
	 * @param text1
	 * Get the information of the restaurant by category and rate from the DB
	 * @return a list of restaurantDTO
	 */
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByCategoryAndRate(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				
			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);
			for (Restaurant restaurant : extent) {
				if(restaurant.getCategory().equals(text) && restaurant.getRate().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));	
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	/**
	 * Store objects in the DB
	 */
	public void createDatabase(){
		try {
			System.out.println("- Store objects in the DB");
			City city = new City("Bilbao","49020",new ArrayList<Restaurant>());
			City city2 = new City("Londres","547978943",new ArrayList<Restaurant>());
			City city3 = new City("Valencia","345345",new ArrayList<Restaurant>());

			Restaurant restaurant1 = new Restaurant("Telepizza", "0", "0", "Italian", "", new ArrayList<Comment>(),city);
			//			Restaurant restaurant2 = new Restaurant("Telepizza", "0", "0", "Italian", "", new ArrayList<Comment>(), city2);
			//			Restaurant restaurant3 = new Restaurant("Telepizza", "0", "0", "Italian", "", new ArrayList<Comment>(),city3);
			Restaurant restaurant4 = new Restaurant("Deustoarrak", "0", "0", "Basque", "", new ArrayList<Comment>(), city);
			Restaurant restaurant5 = new Restaurant("Foster", "0", "0", "American", "", new ArrayList<Comment>(),city2);
			Restaurant restaurant6 = new Restaurant("MejicanoTere", "0", "0", "Mexican", "", new ArrayList<Comment>(), city);
			//			Restaurant restaurant7 = new Restaurant("MejicanoTere", "0", "0", "Mexican", "", new ArrayList<Comment>(),city2);
			//			Restaurant restaurant8 = new Restaurant("Smoking yewepe", "0", "0", "Asian", "", new ArrayList<Comment>(),city);
			Restaurant restaurant9 = new Restaurant("Smoking yewepe", "0", "0", "Asian", "", new ArrayList<Comment>(),city3);


			Member member = new Member("asd@asd","jon","jon",new ArrayList<Comment>(),0);
			Member member2 = new Member("asd@asd","ana","ana",new ArrayList<Comment>(),0);
			Member member3 = new Member("asd@asd","asier","asier",new ArrayList<Comment>(),0);
			Member member4 = new Member("asd@asd","gorka","gorka",new ArrayList<Comment>(),0);


			Comment comment = new Comment("Restaurante precioso", member, restaurant1.getNameR());
			Comment comment2 = new Comment("Nos han hecho descuento por ser guapos", member2, restaurant4.getNameR());
			Comment comment3 = new Comment("Me ha dado asco", member3, restaurant5.getNameR());
			Comment comment4 = new Comment("Hay un pelo en la sopa", member4, restaurant6.getNameR());
			Comment comment5 = new Comment("Una mierda", member, restaurant9.getNameR());
			Comment comment6 = new Comment("Se come dpm", member2, restaurant1.getNameR());

			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			System.out.println("Storing restaurants: ");

			pm.makePersistent(city);
			pm.makePersistent(city2);
			pm.makePersistent(city3);
			pm.makePersistent(restaurant1);
			//			pm.makePersistent(restaurant2);
			//			pm.makePersistent(restaurant3);
			pm.makePersistent(restaurant4);
			pm.makePersistent(restaurant5);
			pm.makePersistent(restaurant6);
			//			pm.makePersistent(restaurant7);
			//			pm.makePersistent(restaurant8);
			pm.makePersistent(restaurant9);

			pm.makePersistent(member);
			pm.makePersistent(member2);
			pm.makePersistent(member3);
			pm.makePersistent(member4);

			pm.makePersistent(comment);
			pm.makePersistent(comment2);
			pm.makePersistent(comment3);
			pm.makePersistent(comment4);
			pm.makePersistent(comment5);
			pm.makePersistent(comment6);


			//End the transaction
			tx.commit();	
			System.out.println("Data stored ok");
		} catch (Exception ex) {
			System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

	/** 
	 * @param restaurant
	 * @param newRate
	 * Add a rate to a restaurant
	 * @return true if it's right
	 */
	public boolean addRateToRestaurant(RestaurantDTO restaurant, String newRate) {
		RestaurantDTO r = restaurant;
		Restaurant restaurantTriki = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Updating a rate: " + newRate);

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);
			for (Restaurant restaurantT : extent) {
				if(restaurantT.getNameR().toString().equals(r.getNameR().toString())){
					//					pm.deletePersistent(restaurantT);
					restaurantTriki = restaurantT;
				}
			}
			restaurantTriki.setRate((Integer.parseInt(restaurantTriki.getRate())*Integer.parseInt(restaurantTriki.getNumRates()) 
					+ (Integer.parseInt(newRate))) / (Integer.parseInt(restaurantTriki.getNumRates()) + 1) +"");
			restaurantTriki.setNumRates(Integer.parseInt(restaurantTriki.getNumRates())+1+"");
			System.out.println("METIENDO EL RESTAURANTE OTRA VEZ EN LA BASE DE DATOS: "+restaurantTriki.getNameR());
			pm.makePersistent(restaurantTriki);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error updating a user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return true;

	}
	/** 
	 * @param name
	 * Retrieve a member
	 * @return MemberDTO
	 */
	@SuppressWarnings("finally")
	public MemberDTO retrieveMember(String name){
		Member m = new Member();
		MemberDTO memberDTO = new MemberDTO();
		try{
			System.out.println("INFO: Getting the member from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Member> extent = pm.getExtent(Member.class, true);
			for (Member member : extent) {
				System.out.println(member.getName());
				if(member.getName().equals(name)){
					System.out.println("ESTA DENTRO DEL IF");
					m = member;}
			}

			System.out.println(m.getName());
			System.out.println(m.getPassword());
			memberDTO = new MemberDTO(m.getName(), m.getPassword());

			tx.commit();
			System.out.println("Member retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return memberDTO;
	}

	/**
	 * @param name
	 * @param password
	 * @param email
	 * Add a member
	 * @return true if it's right
	 */
	public boolean addMember(String name, String password, String email){

		List<Comment> commentsM = new ArrayList<Comment>();
		Member member = new Member(email, name, password, commentsM, 0);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Updating a member: " + member.toString());

			pm.makePersistent(member);
			tx.commit();
			return true;
		} catch (Exception ex) {
			System.out.println("Error updating a user: " + ex.getMessage());
			return false;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	/**
	 * @param restaurantDTO
	 * Get all the comments of a restaurant
	 * @return a list of comments
	 */
	public List<Comment> getAllCommentsOfRestaurant(RestaurantDTO restaurantDTO) {
		List<Comment> r = new ArrayList<Comment>();
		try{
			System.out.println("INFO: Getting the comments from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Comment> extent = pm.getExtent(Comment.class, true);
			for (Comment comment : extent) {
				if(comment.getRestaurant().equals(restaurantDTO.getNameR()))
					r.add(comment);
					System.out.println(comment.getText());
			}
			tx.commit();
			System.out.println("Comments retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}

		return r;
	}

	/**
	 * @param text
	 * @param restaurant
	 * @param memberDTO
	 * Store comments from the restaurants
	 * @return true if it's right
	 */
	public boolean storeComment(String text, RestaurantDTO restaurant, MemberDTO memberDTO){
		Restaurant r = new Restaurant(restaurant.getNameR(),
				restaurant.getRate(),
				restaurant.getNumRates(),
				restaurant.getCategory(),
				restaurant.getStreet(),
				restaurant.getCommentsR(),
				restaurant.getCity());
		Member m = new Member();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Inserting a Comment into de Database " );
			Extent<Member> extent = pm.getExtent(Member.class, true);
			for (Member member : extent) {
				System.out.println(member.getName());
				if(member.getName().equals(memberDTO.getName())){
					System.out.println("ESTA DENTRO DEL IF EN EL STORECOMMENT");
					m = member;}
			}
			System.out.println("INSERTANDO EN COMENTARIO EN LA BASE DE DATOS: "+ text);
			Extent<Restaurant> extent2 = pm.getExtent(Restaurant.class, true);
			for (Restaurant restaurantT : extent2) {
				if(restaurant.getCategory().equals(restaurant.getNameR())){
					r = restaurantT;
					System.out.println("Restaurante nombre: "+r.getNameR());
				}
			}
			Comment comment = new Comment(text, m, r.getNameR());
			pm.makePersistent(comment);
			tx.commit();
			return true;
		} catch (Exception ex) {
			System.out.println("Error updating a user: " + ex.getMessage());
			return false;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	/**
	 * @param memberDTO
	 * @param months
	 * Add the payment of the client
	 * @return a memberDTO
	 */
	public MemberDTO addPay(MemberDTO memberDTO, int months){
		Member member = new Member("", memberDTO.getName(), memberDTO.getPassword(), new ArrayList<Comment>(), memberDTO.getPremium()+months);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Updating a member (premium): " + months);

			Extent<Member> extent = pm.getExtent(Member.class, true);
			for (Member member2 : extent) {
				if(member2.getName().toString().equals(memberDTO.getName().toString()))
				{
					member = member2;
					member.setPremium(member2.getPremium()+months);
//					pm.deletePersistent(member2);
					pm.makePersistent(member2);
				}
				}
			tx.commit();
			tx.begin();
			pm.makePersistent(member);
			tx.commit();
			memberDTO.setPremium(memberDTO.getPremium()+months);
		} catch (Exception ex) {
			System.out.println("Error updating a user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return memberDTO;
	}

	/**
	 * @param memberDTO
	 * Establish the time 
	 * @return true 
	 */
	public boolean time(MemberDTO memberDTO){
		if(memberDTO.getPremium()>0){
			Member member = new Member("", memberDTO.getName(), memberDTO.getPassword(), new ArrayList<Comment>(), memberDTO.getPremium()-1);
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();

			try {
				tx.begin();
				System.out.println("   * Updating a member (premiun): " + member.getPremium());

				Extent<Member> extent = pm.getExtent(Member.class, true);
				for (Member member2 : extent) {
					if(member2.getName().toString().equals(memberDTO.getName().toString()))
					{
						member = member2;
						member2.setPremium(120);
						pm.makePersistent(member2);
					}
				}
				pm.makePersistent(member);
				tx.commit();
				return true;
			} catch (Exception ex) {
				System.out.println("Error updating a user: " + ex.getMessage());
				return false;
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}

				pm.close();
			}
		}
		else
			return true;
	}
	/**
	 * @param time
	 * @param memberName
	 * @param restaurantDTO
	 * Make a book
	 * @return a reservation
	 */
	public Reservation makeBook(String time, String memberName, RestaurantDTO restaurantDTO){
		Reservation reservation = new Reservation(time, memberName, restaurantDTO.getNameR());
		Restaurant restaurant = new Restaurant(restaurantDTO.getNameR(), restaurantDTO.getRate(), restaurantDTO.getNumRates(), 
								restaurantDTO.getCategory(), restaurantDTO.getStreet(), restaurantDTO.getCommentsR(), restaurantDTO.getCity());
		restaurant.addReservation(reservation);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Updating a reservation: " + reservation);
			System.out.println("   * Updating a restaurant (reservation): " + reservation);
	
			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);
			for (Restaurant restaurant2 : extent) {
				if(restaurant2.getNameR().equals(restaurantDTO.getNameR()))
					pm.makePersistent(reservation);
			}
			tx.commit();
			return reservation;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "At this time there is already a reservation.");
			return null;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			pm.close();
		}
	}
	


}
