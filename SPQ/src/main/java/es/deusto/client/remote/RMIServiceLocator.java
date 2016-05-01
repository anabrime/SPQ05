package es.deusto.client.remote;

import es.deusto.server.Server;

public class RMIServiceLocator {

	private Server server; 

	public RMIServiceLocator(String IP, String port, String name){
		this.setManager(IP,port,name);
	}

	private void setManager(String IP, String port, String name) {

		String serverName="//"+ IP +":"+ port +"/"+ name ;
		try{
			System.out.println("Estoy RMI");
			this.server = (Server) java.rmi.Naming.lookup(serverName);
			System.out.println("He conectado");
		}catch(Exception e) {
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Server getService(){
		return server;
	}
}
