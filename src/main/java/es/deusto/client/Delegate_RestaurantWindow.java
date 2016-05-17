package es.deusto.client;

import java.rmi.RemoteException;
import java.util.ArrayList;

import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.DTO.RestaurantDTO;
import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Member;
import es.deusto.server.jdo.Restaurant;

public class Delegate_RestaurantWindow extends Basic_RestaurantWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RestaurantDTO restaurantDTO;
	Restaurant restaurant;
	MemberDTO memberDTO;
	Member member;
	RMIServiceLocator rmi;
	String IP,port,serverName;
	boolean rate = false;

	public Delegate_RestaurantWindow(RestaurantDTO restaurantDTO, String IP, String port, String serverName, MemberDTO memberDTO) {
		this.restaurantDTO = restaurantDTO;
		this.memberDTO = memberDTO;
		this.member = new Member("", memberDTO.getName(), memberDTO.getPassword(), new ArrayList<Comment>(), 0);
		this.restaurant = new Restaurant(restaurantDTO.getNameR(),
											restaurantDTO.getRate(),
											restaurantDTO.getNumRates(),
											restaurantDTO.getCategory(),
											restaurantDTO.getStreet(),
											new ArrayList<Comment>(),
											restaurantDTO.getCity());
		this.IP = IP;
		this.port = port;
		this.serverName = serverName;
		rmi = new RMIServiceLocator(IP, port, serverName);
		putData();
	}

	private void getComboBoxe() {

		if (!comboBoxRate.getSelectedItem().equals("Rate"))
			rate = true;

	}

	@Override
	protected void rate() {
		getComboBoxe();
		if (rate) {
			try {
				rmi.getService().addRateToRestaurant(restaurantDTO, comboBoxRate.getSelectedItem().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void putData() {
		textField_Name.setText(restaurant.getNameR());
		textField_Location.setText("city: "
				+ restaurant.getCity().getNameCity() + ", street: " + restaurant.getStreet());
		textField_Description.setText(restaurant.getDescription());
		textField_Rate.setText(restaurant.getRate() + "   (" + restaurant.getNumRates() + " rates)");
		imgPhotoRestaurant = restaurant.getPathImagen();
//		textField_UserName.setText(user.getName());
//		textNombreDelUsuarioArriba.setText(user.getName());

	}

	@Override
	protected void comment() {
		String text = textField_CommentText.getText();
		Comment comment = new Comment(text, member, restaurant);
		try {
			rmi.getService().setComment(comment);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void logout() {
		this.dispose();
		new Delegate_MainWindow(IP, port, serverName, memberDTO);
	}

	@Override
	protected void goMainWindow() {
		super.goMainWindow();
	}
	
	
}
