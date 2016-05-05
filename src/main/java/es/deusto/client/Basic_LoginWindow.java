package es.deusto.client;
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

public class Basic_LoginWindow extends JFrame{
	
	protected JTextField textFieldUsername, textFieldPassword;
	protected JPanel panel;
	protected JButton loginButton;
	protected JButton registerButton;
	protected JLabel label;

	public Basic_LoginWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(434,300);
		setResizable(false);
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		registerButton = new JButton("Register");
		registerButton.setBounds(217, 236, 100, 25);
		registerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		panel.add(registerButton);		
		
		loginButton = new JButton("Login");
		loginButton.setBounds(317, 236, 100, 25);
		panel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});

		textFieldUsername = new JTextField();
		textFieldUsername.setText("Username");
		textFieldUsername.repaint();
		textFieldUsername.setBounds(317, 168, 105, 19);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		textFieldPassword = new JTextField();
		textFieldPassword.setText("Password");
		textFieldPassword.repaint();
		textFieldPassword.setBounds(315, 205, 105, 19);
		panel.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		label = new JLabel("");
		label.setIcon(new ImageIcon("/home/gorka/Pictures/logo.png"));
		label.setBounds(0, 0, 434, 273);
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
