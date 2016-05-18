package es.deusto.client.delegate;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import es.deusto.client.basic.Basic_MainWindow;
import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.DTO.RestaurantDTO;
import es.deusto.server.jdo.*;

public class Delegate_MainWindow extends Basic_MainWindow{

	RMIServiceLocator rmi;
	Boolean name = false;
	Boolean category = false;
	Boolean rate = false;
	Boolean place = false;
	List<RestaurantDTO> list;
	int contadorFilas = 0;
	MemberDTO memDTO;
	String IP,port,serverName;
	
	public Delegate_MainWindow(String IP, String port, String serverName, MemberDTO memberDTO) {
		rmi = new RMIServiceLocator(IP, port, serverName);
		this.IP = IP;
		this.memDTO = memberDTO;
		this.port = port;
		this.serverName = serverName;
		userNameLabel.setText(memberDTO.getName());
		list = new ArrayList<RestaurantDTO>();
	}
	private void getComboBoxes(){
		name = false;
		category = false;
		rate = false;
		place = false;
		if(!comboBoxCategory.getSelectedItem().equals("Category"))
			category = true;

		if(!comboBoxName.getSelectedItem().equals("Name"))
			name = true;

		if(!comboBoxPlace.getSelectedItem().equals("Place"))
			place = true;

		if(!comboBoxRate.getSelectedItem().equals("Rate"))
			rate = true;
	}
	private void find(){
		getComboBoxes();
		if(category && !name && !place && !rate)
			try {
				System.out.println("CATEGORIA");
				list = rmi.getService().getRestaurantByCategory(comboBoxCategory.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && name && !place && !rate)
			try {
				System.out.println("NAME");
				list = rmi.getService().getRestaurantByName(comboBoxName.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && !name && place && !rate)
			try {
				System.out.println("PLACE");
				list = rmi.getService().getRestaurantByPlace(comboBoxPlace.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && !name && !place && rate)
			try {
				System.out.println("RATE");
				list = rmi.getService().getRestaurantByRate(comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && name && !place && ! rate)
			try {
				System.out.println("NAME Y CATEGORIA");
				list = rmi.getService().getRestaurantByNameAndCategory(comboBoxName.getSelectedItem().toString()
						, comboBoxCategory.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && name && place && !rate)
			try {
				System.out.println("NAME Y PLACE");
				list = rmi.getService().getRestaurantByNameAndPlace(comboBoxName.getSelectedItem().toString()
						, comboBoxPlace.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && name && !place && rate)
			try {
				System.out.println("NAME AND RATE");
				list = rmi.getService().getRestaurantByNameAndRate(comboBoxName.getSelectedItem().toString()
						, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && !name && !place && rate)
			try {
				System.out.println("CATEGORIA Y RATE");
				list = rmi.getService().getRestaurantByCategoryAndRate(comboBoxCategory.getSelectedItem().toString()
						, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && !name && place && !rate)
			try {
				System.out.println("CATEGORIA Y PLACE");
				list = rmi.getService().getRestaurantByPlaceAndCategory(comboBoxPlace.getSelectedItem().toString()
						, comboBoxCategory.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && !name && place && rate)
			try {
				System.out.println("PLACE Y RATE");
				list = rmi.getService().getRestaurantByPlaceAndRate(comboBoxPlace.getSelectedItem().toString()
						, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	private void addToTable () {
		deleteFromTable();
		find();
		for (RestaurantDTO rest : list) {
		    table.setValueAt(rest.getNameR(), contadorFilas, 0);
		    table.setValueAt(rest.getCategory(), contadorFilas, 1);
		    table.setValueAt(rest.getRate(), contadorFilas, 2);
		    contadorFilas++;
		}
		scrollPane.repaint();
	
	}
	
	private void deleteFromTable() {
		
		for (int i = 0; i < 10; i++) {
		    table.setValueAt("", i, 0);
		    table.setValueAt("", i, 1);
		    table.setValueAt("", i, 2);
		}
		contadorFilas = 0;
		this.repaint();
	}
	
	protected void execute(){
		addToTable();
		this.repaint();
	}
	
	@Override
	protected void openPremium(){
		new Delegate_PremiumWindow(IP, port, serverName, memDTO);
		this.dispose();
	}
	
	@Override
	protected void openRestaurant(){
		new Delegate_RestaurantWindow(list.get(table.getSelectedRow()), IP,port,serverName,memDTO);
		this.dispose();
	}
	
	protected void logout(){
		try {
			rmi.getService().time(memDTO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();
	}
	
}
