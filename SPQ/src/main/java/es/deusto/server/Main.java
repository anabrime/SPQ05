package es.deusto.server;

import java.rmi.Naming;


public class Main {
	public static void main(String[] args) {
		if(System.getSecurityManager()==null){
			System.setSecurityManager(new SecurityManager());
		}
		
		String serverName = "//"+args[0]+":"+args[1]+"/"+args[2];
		
		try{
			IServer server = new Server();
			Naming.rebind(serverName, server);
			System.out.println(" Server "+serverName+" active and waiting...");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}