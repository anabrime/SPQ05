package es.deusto.server.DAO;

import es.deusto.server.jdo.Member;

public interface IUserDAO {
	public void storeUser (Member u);
	public Member retrieveUser (String login);
	public void updateUser (Member u);

}
