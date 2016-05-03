package es.deusto.client;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.jdo.*;

public class Delegate_MainWindow extends Basic_MainWindow{

	RMIServiceLocator rmi;
	Boolean name = false;
	Boolean category = false;
	Boolean rate = false;
	Boolean place = false;
	List<Restaurant> list;
	int contadorFilas = 0;
	
	public Delegate_MainWindow(String IP, String port, String serverName) {
		rmi = new RMIServiceLocator(IP, port, serverName);
		list = new ArrayList<Restaurant>();
	}
	private void getComboBoxes(){
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
				list = rmi.getService().getRestaurantByCategory(comboBoxCategory.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && name && !place && !rate)
			try {
				list = rmi.getService().getRestaurantByName(comboBoxName.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && !name && place && !rate)
			try {
				list = rmi.getService().getRestaurantByPlace(comboBoxPlace.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && !name && !place && rate)
			try {
				list = rmi.getService().getRestaurantByRate(comboBoxRate.getSelectedItem().toString());
				System.out.println(list.toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && name && !place && ! rate)
			try {
				list = rmi.getService().getRestaurantByNameAndCategory(comboBoxName.getSelectedItem().toString()
						, comboBoxCategory.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && name && place && !rate)
			try {
				list = rmi.getService().getRestaurantByNameAndPlace(comboBoxName.getSelectedItem().toString()
						, comboBoxPlace.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && name && !place && rate)
			try {
				list = rmi.getService().getRestaurantByNameAndRate(comboBoxName.getSelectedItem().toString()
						, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && !name && !place && rate)
			try {
				list = rmi.getService().getRestaurantByCategoryAndRate(comboBoxCategory.getSelectedItem().toString()
						, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && !name && place && !rate)
			try {
				list = rmi.getService().getRestaurantByPlaceAndCategory(comboBoxPlace.getSelectedItem().toString()
						, comboBoxCategory.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && !name && place && !rate)
			try {
				list = rmi.getService().getRestaurantByPlaceAndRate(comboBoxPlace.getSelectedItem().toString()
						, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	private void addToTable () {
		find();
		for (Restaurant rest : list) {
		    table.setValueAt(rest.getNameR(), contadorFilas, 0);
		    table.setValueAt(rest.getCategory(), contadorFilas, 1);
		    table.setValueAt(rest.getRate(), contadorFilas, 2);
		    contadorFilas++;
		}
		scrollPane.repaint();
	
	}
	
	protected void execute(){
		addToTable();
		scrollPane.repaint();
		this.repaint();
	}
	
}
