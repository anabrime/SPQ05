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
	protected JTextPane textNombreDelUsuarioArriba;
	protected JTextPane txtpnComment;
	protected final JComboBox<String> comboBoxRate;

	public Basic_RestaurantWindow() {
		setSize(840, 470);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel_LogoRA = new JPanel();
		panel_LogoRA.setBounds(10, 11, 232, 114);
		getContentPane().add(panel_LogoRA);

		JButton btn_logo = new JButton();
		btn_logo.setIcon(new ImageIcon(imgLogo));
		btn_logo.setBounds(10, 11, 232, 114);
		panel_LogoRA.add(btn_logo);

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
		panel_1.setBounds(10, 193, 379, 249);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel txtpnName = new JLabel();
		txtpnName.setText("Name:");
		txtpnName.setBounds(168, 11, 50, 20);
		panel_1.add(txtpnName);

		JLabel txtpnLocation_1 = new JLabel();
		txtpnLocation_1.setText("Location:");
		txtpnLocation_1.setBounds(168, 35, 50, 20);
		panel_1.add(txtpnLocation_1);

		JLabel txtpnRate = new JLabel();
		txtpnRate.setText("Rate:");
		txtpnRate.setBounds(168, 59, 50, 20);
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
		textField_Name.setBounds(228, 11, 86, 20);
		panel_1.add(textField_Name);
		textField_Name.setColumns(10);

		textField_Location = new JTextField();
		textField_Location.setBounds(228, 35, 86, 20);
		panel_1.add(textField_Location);
		textField_Location.setColumns(10);

		textField_Rate = new JTextField();
		textField_Rate.setBounds(228, 59, 86, 20);
		panel_1.add(textField_Rate);
		textField_Rate.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(507, 193, 313, 249);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNombre = new JLabel("User name:");
		lblNombre.setBounds(10, 70, 71, 28);
		panel_2.add(lblNombre);

		textField_UserName = new JTextField("UserName");
		textField_UserName.setBounds(68, 74, 86, 20);
		panel_2.add(textField_UserName);

		JLabel lblComentarios = new JLabel("Comments");
		lblComentarios.setFont((new java.awt.Font("Tahoma", 0, 36)));
		lblComentarios.setBounds(10, 11, 255, 44);
		panel_2.add(lblComentarios);

		textField_CommentText = new JTextField();
		textField_CommentText.setBounds(68, 117, 235, 121);
		panel_2.add(textField_CommentText);
		textField_CommentText.setColumns(10);

		txtpnComment = new JTextPane();
		txtpnComment.setText("Comment:");
		txtpnComment.setBounds(10, 117, 71, 28);
		panel_2.add(txtpnComment);

		JButton btnComment = new JButton("COMMENT");
		btnComment.setBounds(214, 73, 89, 23);
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

		textNombreDelUsuarioArriba = new JTextPane();
		textNombreDelUsuarioArriba.setEditable(false);
		textNombreDelUsuarioArriba.setBounds(601, 11, 106, 20);
		getContentPane().add(textNombreDelUsuarioArriba);

		JButton btn_Logout = new JButton("LogOut");
		btn_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logout();
			}
		});
		btn_Logout.setBounds(731, 8, 89, 23);
		getContentPane().add(btn_Logout);
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
