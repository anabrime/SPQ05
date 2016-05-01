package es.deusto.server.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.server.jdo.Restaurant;

public class RestaurantAdvisorDAO {
	// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		// Persistence Manager
		PersistenceManager pm = null;
		//Transaction to group DB operations
		Transaction tx = null;	
		
		@SuppressWarnings("finally")
		public Restaurant getRestaurantByName(String text) {
			Restaurant r = new Restaurant();
			try{
				System.out.println("INFO: Getting the song from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				Query q = pm.newQuery("SELECT FROM "+Restaurant.class.getName()+" WHERE nameR == '"+text+"'");
				q.setUnique(true);
				r = (Restaurant)q.execute();
				
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
		public Restaurant getRestaurantByCategory(String text) {
			Restaurant r = new Restaurant();
			try{
				System.out.println("INFO: Getting the song from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				Query q = pm.newQuery("SELECT FROM "+Restaurant.class.getName()+" WHERE category == '"+text+"'");
				q.setUnique(true);
				r = (Restaurant)q.execute();
				
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
		public Restaurant getRestaurantByPlace(String text) {
			Restaurant r = new Restaurant();
			try{
				System.out.println("INFO: Getting the song from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				Query q = pm.newQuery("SELECT FROM "+Restaurant.class.getName()+" WHERE city == '"+text+"'");
				q.setUnique(true);
				r = (Restaurant)q.execute();
				
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
		public Restaurant getRestaurantByRate(String text) {
			Restaurant r = new Restaurant();
			try{
				System.out.println("INFO: Getting the song from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				Query q = pm.newQuery("SELECT FROM "+Restaurant.class.getName()+" WHERE rate == '"+text+"'");
				q.setUnique(true);
				r = (Restaurant)q.execute();
				
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
		public Restaurant getRestaurantByNameAndCategory(String text, String text1) {
			Restaurant r = new Restaurant();
			try{
				System.out.println("INFO: Getting the song from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				Query q = pm.newQuery("SELECT FROM "+Restaurant.class.getName()+" WHERE nameR == '"+text+"' "
						+ "AND category == '"+text1+"'");
				q.setUnique(true);
				r = (Restaurant)q.execute();
				
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
		public Restaurant getRestaurantByNameAndRate(String text, String text1) {
			Restaurant r = new Restaurant();
			try{
				System.out.println("INFO: Getting the song from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				Query q = pm.newQuery("SELECT FROM "+Restaurant.class.getName()+" WHERE nameR == '"+text+"' "
						+ "AND rate == '"+text1+"'");
				q.setUnique(true);
				r = (Restaurant)q.execute();
				
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
		public Restaurant getRestaurantByNameAndPlace(String text, String text1) {
			Restaurant r = new Restaurant();
			try{
				System.out.println("INFO: Getting the song from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				Query q = pm.newQuery("SELECT FROM "+Restaurant.class.getName()+" WHERE nameR == '"+text+"' "
						+ "AND city == '"+text1+"'");
				q.setUnique(true);
				r = (Restaurant)q.execute();
				
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
		public Restaurant getRestaurantByPlaceAndCategory(String text, String text1) {
			Restaurant r = new Restaurant();
			try{
				System.out.println("INFO: Getting the song from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				Query q = pm.newQuery("SELECT FROM "+Restaurant.class.getName()+" WHERE city == '"+text+"' "
						+ "AND category == '"+text1+"'");
				q.setUnique(true);
				r = (Restaurant)q.execute();
				
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
		public Restaurant getRestaurantByPlaceAndRate(String text, String text1) {
			Restaurant r = new Restaurant();
			try{
				System.out.println("INFO: Getting the song from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				Query q = pm.newQuery("SELECT FROM "+Restaurant.class.getName()+" WHERE city == '"+text+"' "
						+ "AND rate == '"+text1+"'");
				q.setUnique(true);
				r = (Restaurant)q.execute();
				
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
		public Restaurant getRestaurantByCategoryAndRate(String text, String text1) {
			Restaurant r = new Restaurant();
			try{
				System.out.println("INFO: Getting the song from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				Query q = pm.newQuery("SELECT FROM "+Restaurant.class.getName()+" WHERE category == '"+text+"' "
						+ "AND rate == '"+text1+"'");
				q.setUnique(true);
				r = (Restaurant)q.execute();
				
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
		
}

