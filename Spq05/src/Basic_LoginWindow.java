import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Rectangle;
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
	
	private JTextField textField;

	public Basic_LoginWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(434,300);
		setResizable(false);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(317, 236, 100, 25);
		panel.add(btnNewButton);
		
		/*JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:/Users/Jon/git/spq/Spq05/img/logo.png"));
		label.setBounds(0, 0, 434, 273);
		panel.add(label);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/Jon/git/spq/Spq05/img/logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
				Image.SCALE_SMOOTH);

		ImageIcon imageIcon = new ImageIcon(dimg);

		label.setIcon(imageIcon);*/

		textField = new JTextField();
		textField.setText("Username");
		textField.repaint();
		textField.setBounds(315, 205, 105, 19);
		panel.add(textField);
		textField.setColumns(10);
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().equals("")) {
				textField.setText("Username");
				repaint();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");
				repaint();
			}
		});
		textField.requestFocusInWindow();

		//NO MIRAR PLS
		JButton botonTriki = new JButton("");
		botonTriki.setBounds(new Rectangle(0, 0, 0, 0));
		botonTriki.requestFocus();
		panel.add(botonTriki);
		botonTriki.requestFocusInWindow();
		//MIRAR A PARTIR DE AKI xD
		revalidate();
		repaint();
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new Basic_LoginWindow();
	}
}
