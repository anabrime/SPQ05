package es.deusto.client.delegate;

import java.rmi.RemoteException;

import es.deusto.client.basic.Basic_RegistrationWindow;
import es.deusto.client.remote.RMIServiceLocator;

/**
 * A delegate registration window.
 * 
 * @author Team 05
 *
 * @param rmi RMIServiceLocator
 * @param name
 * @param password
 * @param email
 * @param nameS, passwordS, emailS
 * @param IP, port, serverName
 */
public class Delegate_RegistrationWindow extends Basic_RegistrationWindow {

	private static final long serialVersionUID = 1L;
	RMIServiceLocator rmi;
	Boolean name = false;
	Boolean password = false;
	Boolean email = false;
	String nameS, passwordS, emailS;
	String IP,port,serverName;

	/** Constructor method
	 * @param IP
	 * @param port
	 * @param serverName
	 */
	public Delegate_RegistrationWindow(String IP, String port, String serverName) {
		rmi = new RMIServiceLocator(IP, port, serverName);
		this.IP = IP;
		this.port = port;
		this.serverName = serverName;
	}

	/**
	 * Get the info for the registration
	 */
	private void getInfo() {
		if (!textField.getText().equals(null))
			name = true;

		if (!txtPassword.getText().equals(null))
			password = true;

		if (!txtEmail.getText().equals(null))
			email = true;
	}

	public void getData() {
		nameS = textField.getText();
		passwordS = txtPassword.getText();
		emailS = txtEmail.getText();
	}

	/**
	 * Subscribe a client
	 * @see es.deusto.client.basic.Basic_RegistrationWindow#suscribe()
	 */
	@Override

	protected void suscribe() {
		getInfo();
		if (name && password && email) {

			getData();
			try {
				rmi.getService().addMember(nameS, passwordS, emailS);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("You have not introduced the username, the password or the email.");
		}
		this.dispose();
		new Delegate_LoginWindow(IP, port, serverName);
	}
}
