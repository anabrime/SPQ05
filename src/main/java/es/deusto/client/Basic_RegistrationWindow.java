package es.deusto.client;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;

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
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(407, 147);

		suscribeButton = new JButton("Suscrive");
		suscribeButton.setBounds(252, 37, 89, 23);
		getContentPane().add(suscribeButton);
		suscribeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				suscribe();
			}
		});

		txtpnIntroduceYourName = new JLabel("Introduce user name:");
		txtpnIntroduceYourName.setBounds(10, 21, 136, 23);
		getContentPane().add(txtpnIntroduceYourName);

		textField = new JTextField();
		textField.setBounds(156, 21, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		txtpnIntroducePassword = new JLabel("Introduce password:");
		txtpnIntroducePassword.setBounds(10, 55, 136, 20);
		getContentPane().add(txtpnIntroducePassword);

		txtPassword = new JTextField();
		txtPassword.setBounds(156, 55, 86, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);

		txtpnIntroduceEmail = new JLabel("Introduce email:");
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
