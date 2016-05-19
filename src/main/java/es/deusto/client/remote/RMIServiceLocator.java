/**@package es.deusto.client.remote
   @brief Package composed by the RMIServiceLocator class
*/

package es.deusto.client.remote;

import es.deusto.server.IServer;
import es.deusto.server.Server;

/**
 * The RMIServiceLocator class. 
 * 
 * @author Team 05
 *
 */
public class RMIServiceLocator {

	private IServer server; 

	/** Constructor class
	 * @param IP
	 * @param port
	 * @param name
	 */
	public RMIServiceLocator(String IP, String port, String name){
		this.setManager(IP,port,name);
	}

	/**
	 * Set the manager
	 */
	private void setManager(String IP, String port, String name) {

		String serverName="//"+ IP +":"+ port +"/"+ name ;
		try{
			this.server = (IServer) java.rmi.Naming.lookup(serverName);
		}catch(Exception e) {
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
	}
	 /** 
	  * Returns the instance of the server
	  */
	public IServer getService(){
		return server;
	}
}
