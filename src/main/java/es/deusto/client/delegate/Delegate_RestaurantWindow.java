package es.deusto.client.delegate;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import es.deusto.client.basic.Basic_RestaurantWindow;
import es.deusto.client.remote.RMIServiceLocator;
import es.deusto.server.DTO.CommentDTO;
import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.DTO.RestaurantDTO;
import es.deusto.server.jdo.Comment;
import es.deusto.server.jdo.Member;
import es.deusto.server.jdo.Restaurant;

/**
 * A delegate restaurant window.
 *
 * @author Team 05
 *
 * @param restaurantDTO
 * @param restaurant
 * @param IP, port, serverName
 * @param memberDTO
 * @param member
 * @param rmi RMIServiceLocator
 * @param rate
 * @param hour
 */
public class Delegate_RestaurantWindow extends Basic_RestaurantWindow {

	private static final long serialVersionUID = 1L;
	RestaurantDTO restaurantDTO;
	Restaurant restaurant;
	MemberDTO memberDTO;
	Member member;
	RMIServiceLocator rmi;
	String IP,port,serverName;
	boolean rate = false;
	boolean hour = false;

	/**
	 * Constructor method
	 * @param restaurantDTO 
	 * @param IP
	 * @param port
	 * @param serverName
	 * @param memberDTO
	 */
	public Delegate_RestaurantWindow(RestaurantDTO restaurantDTO, String IP, String port, String serverName, MemberDTO memberDTO) {
		this.restaurantDTO = restaurantDTO;
		this.memberDTO = memberDTO;
		this.member = new Member("", memberDTO.getName(), memberDTO.getPassword(), new ArrayList<Comment>(), memberDTO.getPremium());
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

	/**
	 * Get the rate and the hour of the restaurant
	 */
	private void getComboBoxe() {

		if (!comboBoxRate.getSelectedItem().equals("Rate"))
			rate = true;

		if (!comboBoxBook.getSelectedItem().equals("Hour"))
			hour = true;

	}

	/** Add a rate to a restaurant
	 * @see es.deusto.client.basic.Basic_RestaurantWindow#rate()
	 */
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

	/** Put all the information of the restaurant
	 * @see es.deusto.client.basic.Basic_RestaurantWindow#putData()
	 */
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
		setCommentsInTextField();
		System.out.println("PREMIUM DEL MEMBER: " + member.getPremium());
		if(member.getPremium()<=0) 
			bookButton.setEnabled(false);
		else
			bookButton.setEnabled(true);
	}

	/** Make a comment
	 * @see es.deusto.client.basic.Basic_RestaurantWindow#comment()
	 */
	@Override
	protected void comment() {
		String text = textField_CommentText.getText();
		try {
			rmi.getService().storeComment(text, new RestaurantDTO(restaurant), memberDTO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** Logout from the application 
	 * @see es.deusto.client.basic.Basic_RestaurantWindow#logout()
	 */
	@Override
	protected void logout() {
		this.dispose();
		new Delegate_MainWindow(IP, port, serverName, memberDTO);
	}

	/** Go to tha main window
	 * @see es.deusto.client.basic.Basic_RestaurantWindow#goMainWindow()
	 */
	@Override
	protected void goMainWindow() {
		super.goMainWindow();
	}

	/**
	 * Change the comments, or introduce more comments to the restaurantDTO
	 */
	private void setCommentsInTextField(){
		try {
			for (Comment comment : rmi.getService().getAllCommentsOfRestaurant(restaurantDTO)) {
				textField_Description.setText(comment.getText()+"\n");
				System.out.println(comment.getText());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/** Book a restaurant, if at the time that you want to book is another reservation, we will notice you.
	 * @see es.deusto.client.basic.Basic_RestaurantWindow#book()
	 */
	protected void book(){
		getComboBoxe();
		boolean reserved = false;
		if(hour){
			for(int i=0; i<restaurantDTO.getReservations().size() && !reserved; i++){
				if (restaurantDTO.getReservations().get(i).equals(comboBoxBook.getSelectedItem().toString()))
					JOptionPane.showMessageDialog(null, "At this time there is already a reservation.");
				reserved = true;
			}
			if(!reserved)
				try {
					restaurantDTO.addReservation(rmi.getService().makeBook(comboBoxBook.getSelectedItem().toString(), memberDTO.getName(), restaurantDTO));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
