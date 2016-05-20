/**@package es.deusto.client.delegate
   @brief Package composed by classes Delegate_LoginWindow, Delegate_MainWindow, Delegate_PremiumWindow, Delegate_RegistrationWindow and Delegate_RestaurantWindow
*/
package es.deusto.client.delegate;

import java.rmi.RemoteException;

import es.deusto.client.basic.Basic_LoginWindow;
import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.jdo.*;

/**
 * A delegate login window.
 *  
 * @author Team 05
 *
 * @param rmi RMIServiceLocator
 * @param name 
 * @param password
 * @param username
 * @param passwordS
 * @param IP, port, serverName
 */
public class Delegate_LoginWindow extends Basic_LoginWindow {

	private static final long serialVersionUID = 1L;
	RMIServiceLocator rmi;
	Boolean name = false;
	Boolean password = false;
	String username = "";
	String passwordS = "";
	String IP, port, serverName;

	/**
	 * For the RMIServiceLocator:
	 * @param IP 
	 * @param port
	 * @param serverName
	 */
	public Delegate_LoginWindow(String IP, String port, String serverName) {
		rmi = new RMIServiceLocator(IP, port, serverName);
		this.IP = IP;
		this.port = port;
		this.serverName = serverName;
	}

	/**
	 * Check the information of the client
	 */
	public void getInfo() {
		if (!textFieldUsername.getText().equals("Username"))
			name = true;

		if (!textFieldPassword.getText().equals("Password"))
			password = true;
	}

	/**
	 * Get the information of the client
	 */
	private void getData() {

		username = textFieldUsername.getText();
		passwordS = textFieldPassword.getText();
	}
	/**
	 * Login method, creates a MemberDTO. 
	 * @see es.deusto.client.basic.Basic_LoginWindow#login()
	 */
	@Override
	protected void login() {
		getInfo();
		getData();
		MemberDTO memberDTO = new MemberDTO("", "");
		try {
			memberDTO = rmi.getService().retrieveMember(username);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if (name && password) {
			if (memberDTO.getPassword().equals(passwordS)) {
				System.out.println("THE USER IS CORRECT");
				this.dispose();
				new Delegate_MainWindow(IP, port, serverName, memberDTO);
			} else
				System.out.println("The password or the username are not correct.");
		} else {
			System.out.println("You have not introduced the username or the password.");
		}
	}

	/**
	 * Register method. Open the Delegate_RegistrationWindow.
	 * 	@see es.deusto.client.basic.Basic_LoginWindow#register()
	 */
	@Override
	protected void register() {
		this.dispose();
		new Delegate_RegistrationWindow(IP, port, serverName);
	}
}
