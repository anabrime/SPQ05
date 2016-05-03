package es.deusto.client;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Basic_RegistrationWindow extends JFrame{
	private JTextField textField;
	private JTextField txtPassword;
	private JTextField txtEmail;
	protected JButton suscriveButton;
	protected JTextPane txtpnIntroduceYourName;
	protected JTextPane txtpnIntroducePassword;
	protected JTextPane txtpnIntroduceEmail;
	
	public Basic_RegistrationWindow() {
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(407, 147);
		
		suscriveButton = new JButton("Suscrive");
		suscriveButton.setBounds(252, 37, 89, 23);
		getContentPane().add(suscriveButton);
		suscriveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				suscrive();
			}
		});
		
		txtpnIntroduceYourName = new JTextPane();
		txtpnIntroduceYourName.setText("Introduce user name:");
		txtpnIntroduceYourName.setBounds(10, 21, 136, 23);
		getContentPane().add(txtpnIntroduceYourName);
		
		textField = new JTextField();
		textField.setBounds(156, 21, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		txtpnIntroducePassword = new JTextPane();
		txtpnIntroducePassword.setText("Introduce password:");
		txtpnIntroducePassword.setBounds(10, 55, 136, 20);
		getContentPane().add(txtpnIntroducePassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(156, 55, 86, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtpnIntroduceEmail = new JTextPane();
		txtpnIntroduceEmail.setText("Introduce email:");
		txtpnIntroduceEmail.setBounds(10, 55, 136, 20);
		getContentPane().add(txtpnIntroduceEmail);
		
		txtEnail = new JTextField();
		txtEmail.setBounds(156, 55, 86, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		repaint();
	}
	protected void suscrive(){
		
	}
}
