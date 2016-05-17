package es.deusto.client;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

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
		getContentPane().setLayout(null);
		setSize(270, 120);
		
		btnPay = new JButton("Pay");
		btnPay.setBounds(148, 45, 89, 23);
		getContentPane().add(btnPay);
		btnPay.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				makePay();
			}
		});
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(25, 45, 89, 22);
		comboBox.setModel(new DefaultComboBoxModel<String>(paysTriki));
		getContentPane().add(comboBox);
		
		textPane = new JTextPane();
		textPane.setBounds(25, 11, 212, 23);
		putText();
		textPane.setEditable(false);
		getContentPane().add(textPane);
		
		this.setVisible(true);
		repaint();
	}
	
	protected void makePay(){}
	
	protected void putText(){}
}