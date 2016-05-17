package es.deusto.client;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Image;

public class Basic_RegistrationWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textField;
	protected JTextField txtPassword;
	protected JTextField txtEmail;
	protected JButton suscribeButton;
	protected JLabel txtpnIntroduceYourName;
	protected JLabel txtpnIntroducePassword;
	protected JLabel txtpnIntroduceEmail;

	public Basic_RegistrationWindow() {
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(407, 147);

		suscribeButton = new JButton();
		suscribeButton.setBounds(270, 37, 89, 35);
		ImageIcon icon1 = new ImageIcon(new File("img/registerB.png").getAbsolutePath());
		Image img1 = icon1.getImage() ;  
		Image newimg = img1.getScaledInstance( suscribeButton.getWidth(), suscribeButton.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg );
		suscribeButton.setIcon(icon1);
		suscribeButton.setBorderPainted(false);
		suscribeButton.setContentAreaFilled(false); 
		suscribeButton.setFocusPainted(false); 
		suscribeButton.setOpaque(false);
		getContentPane().add(suscribeButton);
		suscribeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				suscribe();
			}
		});

		txtpnIntroduceYourName = new JLabel("Username: ");
		txtpnIntroduceYourName.setForeground(Color.WHITE);
		txtpnIntroduceYourName.setBounds(10, 21, 136, 23);
		getContentPane().add(txtpnIntroduceYourName);

		textField = new JTextField();
		textField.setBounds(125, 21, 120, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		txtpnIntroducePassword = new JLabel("Password:");
		txtpnIntroducePassword.setForeground(Color.WHITE);
		txtpnIntroducePassword.setBounds(10, 55, 136, 20);
		getContentPane().add(txtpnIntroducePassword);

		txtPassword = new JTextField();
		txtPassword.setBounds(125, 55, 120, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);

		txtpnIntroduceEmail = new JLabel("");
		txtpnIntroduceEmail.setBounds(10, 55, 136, 20);
		getContentPane().add(txtpnIntroduceEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(156, 55, 86, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		repaint();
	}

	protected void suscribe() {

	}
}
