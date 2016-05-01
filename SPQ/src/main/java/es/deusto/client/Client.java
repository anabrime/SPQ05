package es.deusto.client;

import java.rmi.RMISecurityManager;
import es.deusto.server.IServer;

public class Client {

	public static void main(String[] args) {
		
		
		if (args.length != 3) {
			System.out.println("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			new Delegate_MainWindow(args[0], args[1], args[2]);
			
		} catch (Exception e) {
			System.err.println("RMI Example exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}