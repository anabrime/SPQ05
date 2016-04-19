package es.deusto.client;

import java.rmi.RMISecurityManager;
import es.deusto.server.IServer;

public class Client {

	public static void main(String[] args) {
		new Basic_LoginWindow();
		new Basic_MainWindow();
		new Basic_RegistrationWindow();
		new Basic_RestaurantWindow();
		if (args.length != 3) {
			System.out.println("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			IServer objHello = (IServer) java.rmi.Naming.lookup(name);
			// Register to be allowed to send messages
			objHello.registerUser("dipina", "dipina");
			System.out.println("* Message coming from the server: '" + objHello.sayMessage("dipina", "dipina", "This is a test!") + "'");
			
		} catch (Exception e) {
			System.err.println("RMI Example exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}