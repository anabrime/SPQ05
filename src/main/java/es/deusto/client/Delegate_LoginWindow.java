package es.deusto.client;

import java.rmi.RemoteException;

import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.jdo.*;

public class Delegate_LoginWindow extends Basic_LoginWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RMIServiceLocator rmi;
	Boolean name = false;
	Boolean password = false;
	String username = "";
	String passwordS = "";
	String IP, port, serverName;

	public Delegate_LoginWindow(String IP, String port, String serverName) {
		rmi = new RMIServiceLocator(IP, port, serverName);
		this.IP = IP;
		this.port = port;
		this.serverName = serverName;
	}

	public void getInfo() {
		if (!textFieldUsername.getText().equals("Username"))
			name = true;

		if (!textFieldPassword.getText().equals("Password"))
			password = true;
	}

	public void getData() {

		username = textFieldUsername.getText();
		passwordS = textFieldPassword.getText();
	}

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
				System.out.println("EL USUARIO ES CORRECTO");
				this.dispose();
					new Delegate_MainWindow(IP, port, serverName, memberDTO);
			} else
				System.out.println("The password or the username are not correct.");
		} else {
			System.out.println("You have not introduced the username or the password.");
		}
	}
	
	@Override
	protected void register() {
		this.dispose();
		new Delegate_RegistrationWindow(IP, port, serverName);
	}
}
