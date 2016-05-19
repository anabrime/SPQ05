package es.deusto.server.DAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.server.jdo.*;

/**
 * A userDAO class.
 * @author Team 05
 * 
 * @param pmf PersistenceManagerFactory
 *
 */
public class UserDAO implements IUserDAO {
	
	private PersistenceManagerFactory pmf;
	
	/**
	 * Constructor method
	 */
	public UserDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	/** Store the user
	 * @see es.deusto.server.DAO.IUserDAO#storeUser(es.deusto.server.jdo.Member)
	 */
	public void storeUser(Member u) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
	    try {
	       tx.begin();
		       pm.makePersistent(u);
		       tx.commit();
		    } catch (Exception ex) {
		    	System.out.println("   $ Error storing an object: " + ex.getMessage());
		    } finally {
		    	if (tx != null && tx.isActive()) {
		    		tx.rollback();
		    	}
					
	    		pm.close();
		    }
		}


	/** Retrieve the user
	 * @return a member
	 * @see es.deusto.server.DAO.IUserDAO#retrieveUser(java.lang.String)
	 */
	public Member retrieveUser(String login) {
		Member user = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			user = pm.getObjectById(Member.class, login);
			tx.commit();
		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			System.out.println("User does not exist: " + jonfe.getMessage());
		}
		
		finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }

		return user;
	}

	/** Update the user
	 * @see es.deusto.server.DAO.IUserDAO#updateUser(es.deusto.server.jdo.Member)
	 */
	public void updateUser(Member u) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(u);
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
