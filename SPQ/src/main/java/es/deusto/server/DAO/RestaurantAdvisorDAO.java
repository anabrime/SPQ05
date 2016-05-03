package es.deusto.server.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import es.deusto.server.jdo.*;

<<<<<<< HEAD
import es.deusto.server.jdo.City;
=======
import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Member;
>>>>>>> branch 'master' of https://github.com/jb25/spq
import es.deusto.server.jdo.Restaurant;

public class RestaurantAdvisorDAO {
<<<<<<< HEAD
	// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	// Persistence Manager
	PersistenceManager pm = null;
	//Transaction to group DB operations
	Transaction tx = null;	
=======
	// Load Persistence Manager Factory - referencing the Persistence Unit
	// defined in persistence.xml
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	// Persistence Manager
	PersistenceManager pm = null;
	// Transaction to group DB operations
	Transaction tx = null;
>>>>>>> branch 'master' of https://github.com/jb25/spq

	@SuppressWarnings("finally")
<<<<<<< HEAD
	public List<Restaurant> getRestaurantByName(String text) {
		List<Restaurant> r = new ArrayList<Restaurant>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant Restaurant : extent) {
				if(Restaurant.getNameR().equals(text))
					r.add(Restaurant);				
			}
			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
=======
	public Restaurant getRestaurantByName(String text) {
		Restaurant r = new Restaurant();
		try {
			System.out.println("INFO: Getting the song from the db: ");
			pm = pmf.getPersistenceManager();
			// Obtain the current transaction
			tx = pm.currentTransaction();
			// Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM " + Restaurant.class.getName() + " WHERE nameR == '" + text + "'");
			q.setUnique(true);
			r = (Restaurant) q.execute();

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		} finally {
>>>>>>> branch 'master' of https://github.com/jb25/spq
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
<<<<<<< HEAD

	@SuppressWarnings("finally")
	public List<Restaurant> getRestaurantByCategory(String text) {
		List<Restaurant> r = new ArrayList<Restaurant>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant Restaurant : extent) {
				if(Restaurant.getCategory().equals(text))
					r.add(Restaurant);				
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
	@SuppressWarnings("finally")
	public List<Restaurant> getRestaurantByPlace(String text) {
		List<Restaurant> r = new ArrayList<Restaurant>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant Restaurant : extent) {
				if(Restaurant.getCity().toString().equals(text))
					r.add(Restaurant);				
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
	@SuppressWarnings("finally")
	public List<Restaurant> getRestaurantByRate(String text) {
		List<Restaurant> r = new ArrayList<Restaurant>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant Restaurant : extent) {
				if(Restaurant.getRate().equals(text))
					r.add(Restaurant);				
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
	@SuppressWarnings("finally")
	public List<Restaurant> getRestaurantByNameAndCategory(String text, String text1) {
		List<Restaurant> r = new ArrayList<Restaurant>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant Restaurant : extent) {
				if(Restaurant.getNameR().equals(text) && Restaurant.getCategory().equals(text1))
					r.add(Restaurant);				
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
	@SuppressWarnings("finally")
	public List<Restaurant> getRestaurantByNameAndRate(String text, String text1) {
		List<Restaurant> r = new ArrayList<Restaurant>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant Restaurant : extent) {
				if(Restaurant.getNameR().equals(text) && Restaurant.getRate().equals(text1))
					r.add(Restaurant);				
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
	@SuppressWarnings("finally")
	public List<Restaurant> getRestaurantByNameAndPlace(String text, String text1) {
		List<Restaurant> r = new ArrayList<Restaurant>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant Restaurant : extent) {
				if(Restaurant.getNameR().equals(text) && Restaurant.getCity().toString().equals(text1))
					r.add(Restaurant);				
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
	@SuppressWarnings("finally")
	public List<Restaurant> getRestaurantByPlaceAndCategory(String text, String text1) {
		List<Restaurant> r = new ArrayList<Restaurant>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant Restaurant : extent) {
				if(Restaurant.getCity().toString().equals(text) && Restaurant.getCategory().equals(text1))
					r.add(Restaurant);				
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

	@SuppressWarnings("finally")
	public List<Restaurant> getRestaurantByPlaceAndRate(String text, String text1) {
		List<Restaurant> r = new ArrayList<Restaurant>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant Restaurant : extent) {
				if(Restaurant.getCity().toString().equals(text) && Restaurant.getRate().equals(text1))
					r.add(Restaurant);				
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
	@SuppressWarnings("finally")
	public List<Restaurant> getRestaurantByCategoryAndRate(String text, String text1) {
		List<Restaurant> r = new ArrayList<Restaurant>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				
			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);
			for (Restaurant Restaurant : extent) {
				if(Restaurant.getCategory().equals(text) && Restaurant.getRate().equals(text1))
					r.add(Restaurant);				
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

	public void createDatabase(){
		try {
			System.out.println("- Store objects in the DB");
			City city = new City("Bilbao","49020",new ArrayList<Restaurant>());
			Restaurant restaurant1 = new Restaurant("Telepizza", "0", "0", "Italian", "", new ArrayList<Comment>(),city);
//			Restaurant restaurant2 = new Restaurant("Telepizza", "0", "0", "Italian", "", new ArrayList<Comment>(), new City("Madrid","123123",new ArrayList<Restaurant>()));
//			Restaurant restaurant3 = new Restaurant("Telepizza", "0", "0", "Italian", "", new ArrayList<Comment>(), new City("Barcelona","12345",new ArrayList<Restaurant>()));
//			Restaurant restaurant4 = new Restaurant("Deustoarrak", "0", "0", "Basque", "", new ArrayList<Comment>(), new City("Bilbao","2378",new ArrayList<Restaurant>()));
//			Restaurant restaurant5 = new Restaurant("Foster", "0", "0", "American", "", new ArrayList<Comment>(), new City("Bilbao","1254",new ArrayList<Restaurant>()));
//			Restaurant restaurant6 = new Restaurant("MejicanoTere", "0", "0", "Mexican", "", new ArrayList<Comment>(), new City("Bilbao","98765",new ArrayList<Restaurant>()));
//			Restaurant restaurant7 = new Restaurant("MejicanoTere", "0", "0", "Mexican", "", new ArrayList<Comment>(), new City("Valencia","345345",new ArrayList<Restaurant>()));
//			Restaurant restaurant8 = new Restaurant("Smoking yewepe", "0", "0", "Asian", "", new ArrayList<Comment>(), new City("Bilbao","65443",new ArrayList<Restaurant>()));
//			Restaurant restaurant9 = new Restaurant("Smoking yewepe", "0", "0", "Asian", "", new ArrayList<Comment>(), new City("Londres","547978943",new ArrayList<Restaurant>()));
			System.out.println(city);
			System.out.println(restaurant1);
			System.out.println(new ArrayList<Comment>());
			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			System.out.println("Storing restaurants: ");

//			pm.makePersistent(city);
			pm.makePersistent(restaurant1);
//			pm.makePersistent(restaurant2);
//			pm.makePersistent(restaurant3);
//			pm.makePersistent(restaurant4);
//			pm.makePersistent(restaurant5);
//			pm.makePersistent(restaurant6);
//			pm.makePersistent(restaurant7);
//			pm.makePersistent(restaurant8);
//			pm.makePersistent(restaurant9);
			

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
	public static void main(String[] args) {
		RestaurantAdvisorDAO dao = new RestaurantAdvisorDAO();
		System.out.println(dao.getRestaurantByName("Bilbao"));
	}

}
=======
>>>>>>> branch 'master' of https://github.com/jb25/spq

	@SuppressWarnings("finally")
	public Restaurant getRestaurantByCategory(String text) {
		Restaurant r = new Restaurant();
		try {
			System.out.println("INFO: Getting the song from the db: ");
			pm = pmf.getPersistenceManager();
			// Obtain the current transaction
			tx = pm.currentTransaction();
			// Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM " + Restaurant.class.getName() + " WHERE category == '" + text + "'");
			q.setUnique(true);
			r = (Restaurant) q.execute();

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	@SuppressWarnings("finally")
	public Restaurant getRestaurantByPlace(String text) {
		Restaurant r = new Restaurant();
		try {
			System.out.println("INFO: Getting the song from the db: ");
			pm = pmf.getPersistenceManager();
			// Obtain the current transaction
			tx = pm.currentTransaction();
			// Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM " + Restaurant.class.getName() + " WHERE city == '" + text + "'");
			q.setUnique(true);
			r = (Restaurant) q.execute();

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	@SuppressWarnings("finally")
	public Restaurant getRestaurantByRate(String text) {
		Restaurant r = new Restaurant();
		try {
			System.out.println("INFO: Getting the song from the db: ");
			pm = pmf.getPersistenceManager();
			// Obtain the current transaction
			tx = pm.currentTransaction();
			// Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM " + Restaurant.class.getName() + " WHERE rate == '" + text + "'");
			q.setUnique(true);
			r = (Restaurant) q.execute();

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	@SuppressWarnings("finally")
	public Restaurant getRestaurantByNameAndCategory(String text, String text1) {
		Restaurant r = new Restaurant();
		try {
			System.out.println("INFO: Getting the song from the db: ");
			pm = pmf.getPersistenceManager();
			// Obtain the current transaction
			tx = pm.currentTransaction();
			// Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM " + Restaurant.class.getName() + " WHERE nameR == '" + text + "' "
					+ "AND category == '" + text1 + "'");
			q.setUnique(true);
			r = (Restaurant) q.execute();

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	@SuppressWarnings("finally")
	public Restaurant getRestaurantByNameAndRate(String text, String text1) {
		Restaurant r = new Restaurant();
		try {
			System.out.println("INFO: Getting the song from the db: ");
			pm = pmf.getPersistenceManager();
			// Obtain the current transaction
			tx = pm.currentTransaction();
			// Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM " + Restaurant.class.getName() + " WHERE nameR == '" + text + "' "
					+ "AND rate == '" + text1 + "'");
			q.setUnique(true);
			r = (Restaurant) q.execute();

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	@SuppressWarnings("finally")
	public Restaurant getRestaurantByNameAndPlace(String text, String text1) {
		Restaurant r = new Restaurant();
		try {
			System.out.println("INFO: Getting the song from the db: ");
			pm = pmf.getPersistenceManager();
			// Obtain the current transaction
			tx = pm.currentTransaction();
			// Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM " + Restaurant.class.getName() + " WHERE nameR == '" + text + "' "
					+ "AND city == '" + text1 + "'");
			q.setUnique(true);
			r = (Restaurant) q.execute();

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	@SuppressWarnings("finally")
	public Restaurant getRestaurantByPlaceAndCategory(String text, String text1) {
		Restaurant r = new Restaurant();
		try {
			System.out.println("INFO: Getting the song from the db: ");
			pm = pmf.getPersistenceManager();
			// Obtain the current transaction
			tx = pm.currentTransaction();
			// Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM " + Restaurant.class.getName() + " WHERE city == '" + text + "' "
					+ "AND category == '" + text1 + "'");
			q.setUnique(true);
			r = (Restaurant) q.execute();

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	@SuppressWarnings("finally")
	public Restaurant getRestaurantByPlaceAndRate(String text, String text1) {
		Restaurant r = new Restaurant();
		try {
			System.out.println("INFO: Getting the song from the db: ");
			pm = pmf.getPersistenceManager();
			// Obtain the current transaction
			tx = pm.currentTransaction();
			// Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM " + Restaurant.class.getName() + " WHERE city == '" + text + "' "
					+ "AND rate == '" + text1 + "'");
			q.setUnique(true);
			r = (Restaurant) q.execute();

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}
	}

	@SuppressWarnings("finally")
	public Restaurant getRestaurantByCategoryAndRate(String text, String text1) {
		Restaurant r = new Restaurant();
		try {
			System.out.println("INFO: Getting the song from the db: ");
			pm = pmf.getPersistenceManager();
			// Obtain the current transaction
			tx = pm.currentTransaction();
			// Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM " + Restaurant.class.getName() + " WHERE category == '" + text + "' "
					+ "AND rate == '" + text1 + "'");
			q.setUnique(true);
			r = (Restaurant) q.execute();

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	public boolean storeComment(Comment comment) {
		boolean ok = false;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing a user: " + comment);
			pm.makePersistent(comment);
			tx.commit();
			ok = true;
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return ok;
	}

	public boolean addRateToRestaurant(Restaurant restaurant, String newRate) {
		boolean ok = false;
		int newRate2 = Integer.parseInt(newRate);
		int mediaRates = Integer.parseInt(restaurant.getRate());
		int numRates = Integer.parseInt(restaurant.getNumRates());
		int newMediaRates = ((mediaRates * numRates) + newRate2) / (numRates + 1);
		restaurant.setRate(String.valueOf(newMediaRates));
		restaurant.setNumRates(String.valueOf((numRates) + 1));
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Updating a restaurant (mediaRate): " + newMediaRates);

			pm.makePersistent(restaurant);
			tx.commit();
			ok = true;

		} catch (Exception ex) {
			System.out.println("Error updating a user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	    return ok;

	}
	@SuppressWarnings("finally")
	public Member getMember(String name){
		Member m = null;
		try{
			System.out.println("INFO: Getting the member from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			Query q = pm.newQuery("SELECT FROM "+Member.class.getName()+" WHERE nameM == '"+name+"'");
			q.setUnique(true);
			m = (Member)q.execute();
			
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
			return m;
		}
	}
	
	public void addMember(String name, String password, String email){
		
		List<Comment> commentsM = new ArrayList<Comment>();
		Member member = new Member(email, name, password, commentsM);
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
		       System.out.println("   * Updating a member: " + member.toString());

	    	pm.makePersistent(member);
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("Error updating a user: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}
}
