package es.deusto.client.basic;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Image;

public class Basic_PremiumWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected JButton btnPay;
	protected JComboBox<String> comboBox;
	protected JTextPane textPane;
	protected String[] pays = {"1 Month", "3 Months", "6 Months", "12 Months"};
	protected String[] paysTriki = {"Months", "1 Month", "3 Months", "6 Months", "12 Months"};
	
	public Basic_PremiumWindow() {
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setSize(270, 120);
		setResizable(false);
		btnPay = new JButton();
		btnPay.setBounds(146, 50, 25, 25);
		ImageIcon icon1 = new ImageIcon(new File("img/payB.png").getAbsolutePath());
		Image img1 = icon1.getImage() ;  
		Image newimg = img1.getScaledInstance( btnPay.getWidth(), btnPay.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg );
		btnPay.setIcon(icon1);
		btnPay.setBorderPainted(false);
		btnPay.setContentAreaFilled(false); 
		btnPay.setFocusPainted(false); 
		btnPay.setOpaque(false);
		add(btnPay);
		btnPay.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				makePay();
			}
		});
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(25, 45, 89, 22);
		comboBox.setModel(new DefaultComboBoxModel<String>(paysTriki));
		add(comboBox);
		
		textPane = new JTextPane();
		textPane.setBounds(25, 11, 212, 23);
		putText();
		textPane.setEditable(false);
		add(textPane);
		
		this.setVisible(true);
		repaint();
	}
	
	protected void makePay(){}
	
	protected void putText(){}
}