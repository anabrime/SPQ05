package es.deusto.client.delegate;

import java.rmi.RemoteException;

import es.deusto.client.basic.Basic_PremiumWindow;
import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.jdo.Member;

/**
 * A delegate premium window.
 *
 * @author Team 05
 *
 * @param rmi RMIServiceLocator
 * @param pay
 * @param IP, port, serverName
 * @param memberDTO
 */
public class Delegate_PremiumWindow extends Basic_PremiumWindow{

	private static final long serialVersionUID = 1L;
	
	RMIServiceLocator rmi;
	Boolean pay = false;
	String IP,port,serverName;
	MemberDTO memberDTO;
	
	/** Constructor method
	 * @param IP
	 * @param port
	 * @param serverName
	 * @param memberDTO
	 */
	public Delegate_PremiumWindow(String IP, String port, String serverName, MemberDTO memberDTO) {
		rmi = new RMIServiceLocator(IP, port, serverName);
		this.IP = IP;
		this.port = port;
		this.serverName = serverName;
		System.out.println(memberDTO.toString());
		this.memberDTO = memberDTO;  
	}

	/**
	 * Get the number of months you want to pay for been premium
	 */
	private void getComboBox(){
		pay = false;
		if(!comboBox.getSelectedItem().equals("Months"))
			pay = true;
	}
	
	/** Once you have the number of months, make the payment
	 * @see es.deusto.client.basic.Basic_PremiumWindow#makePay()
	 */
	public void makePay(){
		getComboBox();
		if(pay){
			try {
				if(comboBox.getSelectedItem().equals("1 Month"))
					memberDTO = rmi.getService().addPay(memberDTO, 30);
				else if(comboBox.getSelectedItem().equals("3 Months"))
					memberDTO = rmi.getService().addPay(memberDTO, 90);
				else if(comboBox.getSelectedItem().equals("6 Months"))
					memberDTO = rmi.getService().addPay(memberDTO, 180);
				else if(comboBox.getSelectedItem().equals("12 Months"))
					memberDTO = rmi.getService().addPay(memberDTO, 360);
				else
					System.out.println("No coge bien los datos");
				new Delegate_MainWindow(IP, port, serverName, memberDTO);
				this.dispose();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void putText(){
		//String mesage = "You have "+memberDTO.getPremiun()+" days of premiun.";
		//textPane.setText(mesage);	
	}
}