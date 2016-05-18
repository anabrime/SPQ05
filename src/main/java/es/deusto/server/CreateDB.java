package es.deusto.server;

import java.rmi.Naming;

public class CreateDB {
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String serverName = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			
			IServer server = new Server();
			((Server) server).createDatabase();
		
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
