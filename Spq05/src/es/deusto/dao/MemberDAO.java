package es.deusto.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.data.Member;


public class MemberDAO implements IMemberDAO{


	private PersistenceManagerFactory pmf;
	
	public MemberDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	public void storeMember(Member member) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
	    try {
	       tx.begin();
	       System.out.println("   * Storing a user: " + member.getName());
		       pm.makePersistent(member);
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


	public Member retrieveMemberByCod(String cod) {
		Member member = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			member = pm.getObjectById(Member.class, cod);
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

		return member;
	}

	public Member retrieveMemberByName(String name) {
		Member member = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			member = pm.getObjectById(Member.class, name);
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

		return member;
	}
	
	
	public void updateMember(Member member) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
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
