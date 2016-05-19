package es.deusto.server.DAO;

import es.deusto.server.jdo.Member;

/**
 * The interface of the class UserDAO
 * @author Team 05
 *
 */
public interface IUserDAO {
	public void storeUser (Member u);
	public Member retrieveUser (String login);
	public void updateUser (Member u);

}
