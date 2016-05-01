package es.deusto.client;

import java.rmi.RemoteException;

import es.deusto.client.remote.RMIServiceLocator;

public class Delegate_MainWindow extends Basic_MainWindow{

	RMIServiceLocator rmi;
	Boolean name = false;
	Boolean category = false;
	Boolean rate = false;
	Boolean place = false;
	
	public Delegate_MainWindow(String IP, String port, String serverName) {
		rmi = new RMIServiceLocator(IP, port, serverName);
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
	@Override
	protected void find(){
		if(category && !name && !place && !rate)
			try {
				rmi.getService().getRestaurantByCategory(comboBoxCategory.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && name && !place && !rate)
			try {
				rmi.getService().getRestaurantByName(comboBoxName.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && !name && place && !rate)
			try {
				rmi.getService().getRestaurantByPlace(comboBoxPlace.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && !name && !place && rate)
			try {
				rmi.getService().getRestaurantByRate(comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && name && !place && ! rate)
			try {
				rmi.getService().getRestaurantByNameAndCategory(comboBoxName.getSelectedItem().toString()
						, comboBoxCategory.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && name && place && !rate)
			try {
				rmi.getService().getRestaurantByNameAndPlace(comboBoxName.getSelectedItem().toString()
						, comboBoxPlace.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(!category && name && !place && rate)
			try {
				rmi.getService().getRestaurantByNameAndRate(comboBoxName.getSelectedItem().toString()
						, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && !name && !place && rate)
			try {
				rmi.getService().getRestaurantByCategoryAndRate(comboBoxCategory.getSelectedItem().toString()
						, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && !name && place && !rate)
			try {
				rmi.getService().getRestaurantByPlaceAndCategory(comboBoxPlace.getSelectedItem().toString()
						, comboBoxCategory.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(category && !name && place && !rate)
			try {
				rmi.getService().getRestaurantByPlaceAndRate(comboBoxPlace.getSelectedItem().toString()
						, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else{
			System.out.println("ERROR");
		}
			
	}
	
}
