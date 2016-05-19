/**@package es.deusto.client
   @brief Package composed by the client class, and also by the packages basic, delegate and remote
 */

package es.deusto.client;

import java.rmi.RMISecurityManager;

import es.deusto.client.delegate.Delegate_LoginWindow;
import es.deusto.server.IServer;

public class Client {
	/**
	 * A client class.
	 * 
	 * @author Team 05
	 *

	 */
	public static void main(String[] args) {


		if (args.length != 3) {
			System.out.println("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			new Delegate_LoginWindow(args[0], args[1], args[2]);

		} catch (Exception e) {
			System.err.println("RMI Example exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}