package es.deusto.client;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Color;

public class Basic_RestaurantWindow extends JFrame {

	protected JTextField textField_UserName;
	protected JTextField textField_Description;
	protected String[] books = { "14:00", "14:30", "15:00", "21:00", "21:30", "22:00" };
	protected String[] booksTriki = { "Hour", "14:00", "14:30", "15:00", "21:00", "21:30", "22:00" };
	protected String[] rates = { "1", "2", "3", "4", "5" };
	protected String[] ratesTriki = { "Rate", "1", "2", "3", "4", "5" };
	protected JTextField textField_CommentText;
	protected JTextField textField_Name;
	protected JTextField textField_Location;
	protected JTextField textField_Rate;
	protected String imgLogo = "/home/gorka/Pictures/logo.png";
	protected String imgPhotoRestaurant;
	protected final JComboBox<String> comboBoxRate;

	public Basic_RestaurantWindow() {
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		setSize(840, 470);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);

		JButton btn_logo = new JButton();
		btn_logo.setIcon(new ImageIcon(imgLogo));
		btn_logo.setBounds(10, 10, 100, 75);
		
		ImageIcon icon2 = new ImageIcon("/home/gorka/Pictures/logo.png");
		Image img2 = icon2.getImage() ;  
		Image newimg2 = img2.getScaledInstance( btn_logo.getWidth(), btn_logo.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon2 = new ImageIcon( newimg2 );
		btn_logo.setBorderPainted(false);
		btn_logo.setContentAreaFilled(false);
		btn_logo.setFocusPainted(false);
		btn_logo.setOpaque(false);
		btn_logo.setIcon(icon2);
		
		getContentPane().add(btn_logo);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imgLogo));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(btn_logo.getWidth(), btn_logo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);

		btn_logo.setIcon(imageIcon);
		btn_logo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				goMainWindow();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(10, 193, 379, 249);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel txtpnName = new JLabel();
		txtpnName.setForeground(Color.WHITE);
		txtpnName.setText("Name:");
		txtpnName.setBounds(168, 11, 80, 20);
		panel_1.add(txtpnName);

		JLabel txtpnLocation_1 = new JLabel();
		txtpnLocation_1.setForeground(Color.WHITE);
		txtpnLocation_1.setText("Location:");
		txtpnLocation_1.setBounds(168, 35, 80, 20);
		panel_1.add(txtpnLocation_1);

		JLabel txtpnRate = new JLabel();
		txtpnRate.setForeground(Color.WHITE);
		txtpnRate.setText("Rate:");
		txtpnRate.setBounds(168, 59, 80, 20);
		panel_1.add(txtpnRate);

		textField_Description = new JTextField("Description");
		textField_Description.setBounds(10, 90, 359, 148);
		panel_1.add(textField_Description);

		JPanel panel_Photo = new JPanel();
		panel_Photo.setBounds(10, 11, 147, 68);
		panel_1.add(panel_Photo);

		JLabel lbl_photoRestaurant = new JLabel();
//		lbl_photoRestaurant.setIcon(new ImageIcon(imgPhotoRestaurant)); // falta
																		// poner
																		// la
		// referencia
		lbl_photoRestaurant.setBounds(10, 11, 147, 6);
		panel_Photo.add(lbl_photoRestaurant);

//		BufferedImage img_Restaurant = null;
//		try {
////			img_Restaurant = ImageIO.read(new File(imgPhotoRestaurant)); // falta
//																			// poner
//																			// la
//			// referencia
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		Image dimg_Restaurant = img_Restaurant.getScaledInstance(lbl_photoRestaurant.getWidth(),
//				lbl_photoRestaurant.getHeight(), Image.SCALE_SMOOTH);

//		ImageIcon imageIcon_Restaurant = new ImageIcon(dimg_Restaurant);

//		lbl_photoRestaurant.setIcon(imageIcon_Restaurant);

		textField_Name = new JTextField();
		textField_Name.setBounds(250, 11, 115, 20);
		panel_1.add(textField_Name);
		textField_Name.setColumns(10);

		textField_Location = new JTextField();
		textField_Location.setBounds(250, 35, 115, 20);
		panel_1.add(textField_Location);
		textField_Location.setColumns(10);

		textField_Rate = new JTextField();
		textField_Rate.setBounds(250, 59, 115, 20);
		panel_1.add(textField_Rate);
		textField_Rate.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setForeground(Color.DARK_GRAY);
		panel_2.setBounds(507, 193, 313, 249);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNombre = new JLabel("Username:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(10, 70, 81, 28);
		panel_2.add(lblNombre);

		textField_UserName = new JTextField("");
		textField_UserName.setBounds(110, 74, 110, 20);
		panel_2.add(textField_UserName);

		JLabel lblComentarios = new JLabel("Comments");
		lblComentarios.setForeground(Color.WHITE);
		lblComentarios.setFont((new java.awt.Font("Tahoma", 0, 36)));
		lblComentarios.setBounds(10, 11, 255, 44);
		panel_2.add(lblComentarios);

		textField_CommentText = new JTextField();
		textField_CommentText.setBounds(68, 117, 235, 121);
		panel_2.add(textField_CommentText);
		textField_CommentText.setColumns(10);

		JButton btnComment = new JButton();
		btnComment.setBounds(230, 60, 40, 40);
		ImageIcon icon1 = new ImageIcon(new File("img/addB.png").getAbsolutePath());
		Image img1 = icon1.getImage() ;  
		Image newimg1 = img1.getScaledInstance( btnComment.getWidth(),btnComment.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg1 );
		btnComment.setIcon(icon1);
		btnComment.setBorderPainted(false);
		btnComment.setContentAreaFilled(false); 
		btnComment.setFocusPainted(false); 
		btnComment.setOpaque(false);
		panel_2.add(btnComment);

		btnComment.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				comment();
			}
		});

		JButton btn_Rate = new JButton("RATE");
		btn_Rate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				rate();
			}
		});
		btn_Rate.setBounds(697, 136, 89, 23);
		getContentPane().add(btn_Rate);

	/*	final JComboBox<String> comboBoxBook = new JComboBox<String>();
		comboBoxBook.setBounds(261, 137, 96, 20);
		comboBoxBook.setModel(new DefaultComboBoxModel<String>(booksTriki));
		getContentPane().add(comboBoxBook);
		comboBoxBook.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				comboBoxBook.setModel(new DefaultComboBoxModel<String>(booksTriki));
				comboBoxBook.setSelectedIndex(0);
				repaint();
			}

			public void focusGained(FocusEvent e) {
				comboBoxBook.setModel(new DefaultComboBoxModel<String>(books));
				repaint();
			}
		});*/

		comboBoxRate = new JComboBox<String>();
		comboBoxRate.setBounds(570, 137, 96, 20);
		comboBoxRate.setModel(new DefaultComboBoxModel<String>(ratesTriki));
		getContentPane().add(comboBoxRate);

		JButton logoutButton = new JButton();
		logoutButton.setBounds(742, 30, 35, 35);
		ImageIcon icon3 = new ImageIcon(new File("img/logoutB").getAbsolutePath());
		Image img3 = icon3.getImage() ;  
		Image newimg3 = img3.getScaledInstance( logoutButton.getWidth(),logoutButton.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon3 = new ImageIcon( newimg3 );
		logoutButton.setIcon(icon3);
		logoutButton.setBorderPainted(false);
		logoutButton.setContentAreaFilled(false); 
		logoutButton.setFocusPainted(false); 
		logoutButton.setOpaque(false);
		add(logoutButton);
		logoutButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		repaint();

	}

	protected void putData() {
	}

	protected void rate() {
	}

	protected void comment() {
	}

	protected void logout() {
	}
	
	protected void goMainWindow() {
	}
}
