

/**
 * 
 */
package es.deusto.server;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.client.basic.Basic_LoginWindow;
import es.deusto.client.basic.Basic_MainWindow;
import es.deusto.client.basic.Basic_PremiumWindow;
import es.deusto.client.basic.Basic_RegistrationWindow;
import es.deusto.client.delegate.Delegate_LoginWindow;
import es.deusto.client.delegate.Delegate_MainWindow;
import es.deusto.client.delegate.Delegate_PremiumWindow;
import es.deusto.client.delegate.Delegate_RegistrationWindow;
import es.deusto.server.DAO.UserDAO;
import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.DTO.RestaurantDTO;
import es.deusto.server.jdo.City;
import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Member;
import es.deusto.server.jdo.Restaurant;
import junit.framework.JUnit4TestAdapter;

/**
 * RMI Unit test for Simple Client / Server RMI Testing. Testing the only the
 * Remoteness
 */

@SuppressWarnings("deprecation")
public class RestaurantAdvisorTest {
	// Properties are hard-coded because we want the test to be executed without
	// external interaction

	private static String cwd = RestaurantAdvisorTest.class.getProtectionDomain().getCodeSource().getLocation()
			.getFile();
	private static Thread rmiRegistryThread = null;
	private static Thread rmiServerThread = null;

	private IServer server;

	Member m;

	List<RestaurantDTO> t = new ArrayList<RestaurantDTO>();

	RestaurantDTO r;

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(RestaurantAdvisorTest.class);
	}

	@BeforeClass
	static public void setUp() {
		System.out.println("------->QUE ESTO EMPIEZAAA");
		// Launch the RMI registry
		class RMIRegistryRunnable implements Runnable {

			public void run() {
				try {
					java.rmi.registry.LocateRegistry.createRegistry(1099);
					System.out.println("BeforeClass: RMI registry ready.");
				} catch (Exception e) {
					System.out.println("Exception starting RMI registry:");
					e.printStackTrace();
				}
			}
		}

		rmiRegistryThread = new Thread(new RMIRegistryRunnable());
		rmiRegistryThread.start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		class RMIServerRunnable implements Runnable {

			public void run() {
				System.out.println(
						"This is a test to check how mvn test executes this test without external interaction; JVM properties by program");
				System.out.println("**************: " + cwd);
				System.setProperty("java.rmi.server.codebase", "file:" + cwd);
				System.setProperty("java.security.policy", "target\\test-classes\\security\\java.policy");

				if (System.getSecurityManager() == null) {
					System.setSecurityManager(new RMISecurityManager());
				}

				String name = "//127.0.0.1:1099/RestaurantAdvisor";
				System.out.println("BeforeClass - Setting the server ready TestServer name: " + name);

				try {

					IServer server = new Server();
					Naming.rebind(name, server);
				} catch (RemoteException re) {
					System.err.println(" # Messenger RemoteException: " + re.getMessage());
					re.printStackTrace();
					System.exit(-1);
				} catch (MalformedURLException murle) {
					System.err.println(" # Messenger MalformedURLException: " + murle.getMessage());
					murle.printStackTrace();
					System.exit(-1);
				}
			}
		}
		rmiServerThread = new Thread(new RMIServerRunnable());
		rmiServerThread.start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

	@Before
	public void setUpDatabase() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			System.out.println("Deleting test members from persistence. Cleaningup.");
			Query q1 = pm.newQuery(Member.class);
			long numberInstancesDeleted = q1.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted + " user");

			System.out.println("Deleting test restaurants from persistence. Cleaningup.");
			Query q4 = pm.newQuery(Comment.class);
			long numberInstancesDeleted4 = q4.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted4 + " user");

			System.out.println("Deleting test restaurants from persistence. Cleaningup.");
			Query q2 = pm.newQuery(Restaurant.class);
			long numberInstancesDeleted2 = q2.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted2 + " user");

			System.out.println("Deleting test restaurants from persistence. Cleaningup.");
			Query q3 = pm.newQuery(City.class);
			long numberInstancesDeleted3 = q3.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted3 + " user");

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		IServer server;
		try {
			server = new Server();
			((Server) server).createDatabase();

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Before
	public void setUpClient() {
		try {
			System.setProperty("java.security.policy", "target\\test-classes\\security\\java.policy");

			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			String name = "//127.0.0.1:1099/RestaurantAdvisor";
			System.out.println("BeforeTest - Setting the client ready for calling TestServer name: " + name);
			server = (IServer) java.rmi.Naming.lookup(name);
		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
			re.printStackTrace();
			System.exit(-1);
		}

	}

	@Before
	public void setUpData() {

		m = new Member("ana", "ana", "ana", null, 0);
		t.add(new RestaurantDTO("Foster", "0", "0", "American", "", null, new City("Bilbao", null, null)));

		City city = new City();
		new Comment("a", m, "Foster");
		city.getCodPostal();
		// try {
		// server.addMember("jb", "123", "asddf");
		// } catch (RemoteException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//

	}

	/*
	 * @Test public void registerNewUserTest() { try{ System.out.println(
	 * "Test 1 - Register new user"); server.registerUser("ipina", "ipina"); }
	 * catch (Exception re) { System.err.println(
	 * " # Messenger RemoteException: " + re.getMessage()); }
	 * 
	 * Very simple test, inserting a valid new user
	 * 
	 * assertTrue( true ); }
	 */
	@Test
	public void getRestaurantByNameTest() {
		boolean test = false;
		int cont = 0;
		try {
			System.out.println("Test 2 - Get a Restaurant by Name");
			t = server.getRestaurantByName("Foster");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */

		for (int i = 0; i < t.size(); i++) {
			if ("Foster".equals(t.get(i).getNameR()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);

	}

	@Test
	public void getRestaurantByCategoryTest() {
		boolean test = false;
		int cont = 0;
		try {
			System.out.println("Test 3 - Get a Restaurant by Category");
			t = server.getRestaurantByCategory("Mexican");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */
		for (int i = 0; i < t.size(); i++) {
			if ("Foster".equals(t.get(i).getCategory()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);
	}

	@Test
	public void getRestaurantByRateTest() {
		boolean test = false;
		int cont = 0;

		try {
			System.out.println("Test 4 - Get a Restaurant by Rate");
			t = server.getRestaurantByRate("3");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		for (int i = 0; i < t.size(); i++) {
			if ("3".equals(t.get(i).getRate()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);
	}

	@Test
	public void getRestaurantByNameAndCategoryTest() {
		boolean test = false;
		int cont = 0;
		try {
			System.out.println("Test 5 - Get a Restaurant by Name and Category");
			t = server.getRestaurantByNameAndCategory("Foster", "Mexican");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */

		for (int i = 0; i < t.size(); i++) {
			if ("Foster".equals(t.get(i).getNameR()) && "Mexican".equals(t.get(i).getCategory()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);

	}

	@Test
	public void getRestaurantByNameAndRateTest() {
		boolean test = false;
		int cont = 0;

		try {
			System.out.println("Test 6 - Get a Restaurant by Name and Rate");
			t = server.getRestaurantByNameAndRate("Foster", "5");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */
		for (int i = 0; i < t.size(); i++) {
			if ("Foster".equals(t.get(i).getNameR()) && "5".equals(t.get(i).getRate()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);
	}

	@Test
	public void getRestaurantByNameAndPlaceTest() {
		boolean test = false;
		int cont = 0;

		try {
			System.out.println("Test 7 - Get a Restaurant by Name and City");
			t = server.getRestaurantByNameAndPlace("Foster", "Bilbao");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */
		for (int i = 0; i < t.size(); i++) {
			if ("Foster".equals(t.get(i).getNameR()) && "Bilbao".equals(t.get(i).getCity()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);
	}

	@Test
	public void getRestaurantByPlaceAndCategoryTest() {
		boolean test = false;
		int cont = 0;

		try {
			System.out.println("Test 8 - Get a Restaurant by City and Category");
			t = server.getRestaurantByPlaceAndCategory("Bilbao", "Mexican");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */
		for (int i = 0; i < t.size(); i++) {
			if ("Mexican".equals(t.get(i).getCategory()) && "Bilbao".equals(t.get(i).getCity()))
				;
			cont++;

			System.out.println("Mexican".equals(t.get(i).getCategory()) + "-" + "Bilbao".equals(t.get(i).getCity()));
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);
	}

	@Test
	public void getRestaurantByPlaceAndRateTest() {
		boolean test = false;
		int cont = 0;

		try {
			System.out.println("Test 9 - Get a Restaurant by Place and Rate");
			t = server.getRestaurantByPlaceAndRate(null, "5");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */
		for (int i = 0; i < t.size(); i++) {
			if ("Bilbao".equals(t.get(i).getCity()) && "5".equals(t.get(i).getRate()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);
	}

	@Test
	public void getRestaurantByCategoryAndRateTest() {
		boolean test = false;
		int cont = 0;
		try {
			System.out.println("Test 10 - Get a Restaurant by Category and Rate");
			t = server.getRestaurantByCategoryAndRate("Mexican", "5");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */
		for (int i = 0; i < t.size(); i++) {
			if ("Mexican".equals(t.get(i).getCategory()) && "5".equals(t.get(i).getRate()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);
	}

	@Test
	public void setCommentTest() {
		boolean test = false;
		RestaurantDTO rest = new RestaurantDTO(
				new Restaurant("Foster", "0", "0", "American", null, null, new City("Bilbao", null, null)));
		System.out.println("------------------------------------------------" + test);

		try {
			System.out.println("Test 11 - set a comment");
			test = server.storeComment("new comment", rest, (new MemberDTO(m.getName(), m.getPassword())));
			System.out.println("------------------------------------------------" + test);
		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */

		assertTrue(test);
	}

	@Test
	public void addRateToRestaurantTest() {
		boolean test = false;

		try {
			System.out.println("Test 12 - set a rate to a restaurant");
			test = server.addRateToRestaurant(
					new RestaurantDTO(
							new Restaurant("Foster", "0", "0", "American", null, null, new City("Bilbao", null, null))),
					"2");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */
		assertTrue(test);
	}

	@Test
	public void addMemberTest() {
		boolean test = false;
		try {
			System.out.println("Test 13 - sget a member");
			test = server.addMember("test", "1234", "gaizkatetts");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Very simple test
		 */
		assertTrue(test);

	}

	@Test
	public void getMemberTest() {
		boolean test = false;
		MemberDTO m = new MemberDTO();
		try {
			System.out.println("Test 13 - sget a member");

			m = server.retrieveMember(this.m.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (m.getName().equals(this.m.getName())) {
			test = true;
		}

		/*
		 * Very simple test
		 */
		assertTrue(test);
	}

	@Test
	public void MemberDAOTest() {
		MemberDTO mdto = new MemberDTO("manolo", "33");
		mdto.getName();
		mdto.getPassword();
		if (mdto.getName() == "manolo") {
			assertTrue(true);
		} else
			assertTrue(false);

	}

	@Test
	public void UserDAOTest() {

		UserDAO udao = new UserDAO();
		udao.storeUser(new Member());
		udao.retrieveUser("ana");
		udao.updateUser(m);
		if (m.getEmail() == "ana") {
			assertTrue(true);
		} else
			assertTrue(false);
	}

	@Test
	public void RestaurantDAOTest() {
		RestaurantDTO rdto = new RestaurantDTO("casaPaco", "5", "4455643", "rico", "asdf", new ArrayList<Comment>(),
				new City());
		new RestaurantDTO();
		Restaurant r = new Restaurant();
		r.setCategory(rdto.getCategory());
		r.setCity(rdto.getCity());
		r.setCommentsR(rdto.getCommentsR());
		r.setNameR(rdto.getNameR());
		r.setRate(rdto.getNumRates());
		r.setStreet(rdto.getStreet());
		if (rdto.getNameR().equals(r.getNameR()) && rdto.getCategory().equals(r.getCategory())) {
			assertTrue(true);
		} else
			assertTrue(false);

	}

	@Test
	public void WindowsTest() {

		new Basic_LoginWindow();
		new Basic_MainWindow();
		new Basic_RegistrationWindow();
		new Basic_PremiumWindow();
		Delegate_PremiumWindow pw = new Delegate_PremiumWindow("127.0.0.1", "1099", "RestaurantAdvisor",
				new MemberDTO(m.getName(), m.getPassword()));
		// Basic_RestaurantWindow brw = new Basic_RestaurantWindow();
		Delegate_LoginWindow dlw = new Delegate_LoginWindow("127.0.0.1", "1099", "RestaurantAdvisor");
		// Delegate_RestaurantWindow drw=new
		// Delegate_RestaurantWindow(r,"127.0.0.1", "1099", "RestaurantAdvisor",
		// new MemberDTO(m.getName(), m.getPassword()));
		Delegate_RegistrationWindow dr = new Delegate_RegistrationWindow("127.0.0.1", "1099", "RestaurantAdvisor");
		new Delegate_MainWindow("127.0.0.1", "1099", "RestaurantAdvisor", new MemberDTO(m.getName(), m.getPassword()));
		pw.putText();
		pw.makePay();
		dlw.getInfo();
		// dlw.getData();

		// dr.getData();
	}

	@After
	public void RestoreDatabase() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			System.out.println("Deleting test members from persistence. Cleaningup.");
			Query q1 = pm.newQuery(Member.class);
			long numberInstancesDeleted = q1.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted + " user");

			System.out.println("Deleting test restaurants from persistence. Cleaningup.");
			Query q4 = pm.newQuery(Comment.class);
			long numberInstancesDeleted4 = q4.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted4 + " user");

			System.out.println("Deleting test restaurants from persistence. Cleaningup.");
			Query q2 = pm.newQuery(Restaurant.class);
			long numberInstancesDeleted2 = q2.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted2 + " user");

			System.out.println("Deleting test restaurants from persistence. Cleaningup.");
			Query q3 = pm.newQuery(City.class);
			long numberInstancesDeleted3 = q3.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted3 + " user");

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		IServer server;
		try {
			server = new Server();
			((Server) server).createDatabase();

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	static public void tearDown() {
		try {
			rmiServerThread.join();
			rmiRegistryThread.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
