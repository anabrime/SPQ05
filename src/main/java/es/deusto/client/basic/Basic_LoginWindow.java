/**@package es.deusto.client.basic
   @brief Package composed by classes Basic_LoginWindow, Basic_MainWindow, Basic_PremiumWindow, Basic_RegistrationWindow and Basic_RestaurantWindow
 */
package es.deusto.client.basic;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Label;
/**
 * A basic login window.
 * 
 * @author Team 05
 * 
 * @param textFieldUsername To write your username
 * @param textFieldPassword To write your password
 * @param panel Basic panel
 * @param loginButton In order you have an account
 * @param registerButton In order you need an account 
 */
public class Basic_LoginWindow extends JFrame{

	protected JTextField textFieldUsername, textFieldPassword;
	protected JPanel panel;
	protected JButton loginButton;
	protected JButton registerButton;

	public Basic_LoginWindow() {
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(434,300);
		setResizable(false);
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);

		registerButton = new JButton();
		registerButton.setBounds(100, 190, 100, 25);
		ImageIcon icon1 = new ImageIcon(new File("img/registerB.png").getAbsolutePath());
		Image img1 = icon1.getImage() ;  
		Image newimg = img1.getScaledInstance( registerButton.getWidth(), registerButton.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg );
		registerButton.setIcon(icon1);
		registerButton.setBorderPainted(false);
		registerButton.setContentAreaFilled(false); 
		registerButton.setFocusPainted(false); 
		registerButton.setOpaque(false);
		registerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		panel.setLayout(null);
		panel.add(registerButton);		

		loginButton = new JButton("Login");
		ImageIcon icon2 = new ImageIcon(new File("img/loginB.png").getAbsolutePath());
		Image img2 = icon2.getImage() ;  
		Image newimg2 = img2.getScaledInstance( registerButton.getWidth(), registerButton.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon2 = new ImageIcon( newimg2 );
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setFocusPainted(false);
		loginButton.setOpaque(false);
		loginButton.setIcon(icon2);
		loginButton.setBounds(210, 185, 140, 35);
		panel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(145, 80, 150, 19);
		textFieldUsername.setText("Username");
		textFieldUsername.repaint();
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(145, 130, 150, 19);
		textFieldPassword.setText("Password");
		textFieldPassword.repaint();
		panel.add(textFieldPassword);
		textFieldPassword.setColumns(10);

		JLabel label = new JLabel();
		label.setBounds(10, 10, 100, 75);
		panel.add(label);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("/home/gorka/Pictures/logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		label.setIcon(imageIcon);

		revalidate();
		repaint();
		setVisible(true);
	}
	protected void login(){

	}

	protected void register() {

	}
}
