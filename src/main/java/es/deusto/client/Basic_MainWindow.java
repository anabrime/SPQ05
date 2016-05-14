package es.deusto.client;
import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Basic_MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JTable table;
	protected String[] names = {"Telepizza", "Deustoarrak", "Foster","MejicanoTere", "Smoking yewepe"};
	protected String[] places = {"Bilbao", "Gorliz ", "Getxo" };
	protected String[] categorys = {"Mexican", "Italian", "American", "Asian", "Basque" };
	protected String[] rates = {"1", "2", "3", "4", "5" };
	protected JLabel UserNameLabel;
	protected JButton logoutButton;
	protected JButton findButton;
	protected JButton openRestaurantButton;
	protected Panel panel;
	protected JComboBox<String> comboBoxName;
	protected JComboBox<String> comboBoxCategory;
	protected JComboBox<String> comboBoxPlace;
	protected JComboBox<String> comboBoxRate;
	protected JScrollPane scrollPane;
	protected JLabel logoLabel;
	

	protected String[] namesTriki = { "Name","Telepizza", "Deustoarrak", "Foster","MejicanoTere", "Smoking yewepe" };
	protected String[] placesTriki = { "Place","Bilbao", "Gorliz ", "Getxo" };
	protected String[] categorysTriki = { "Category","Mexican", "Italian", "American", "Asian" };
	protected String[] ratesTriki = { "Rate","1", "2", "3", "4", "5" };

	public Basic_MainWindow() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		UserNameLabel = new JLabel("User A");
		UserNameLabel.setBounds(469, 34, 54, 14);
		UserNameLabel.setEnabled(false);
		panel.add(UserNameLabel);

		logoutButton = new JButton();
		logoutButton.setBounds(542, 30, 35, 35);
		ImageIcon icon2 = new ImageIcon("/home/gorka/workspace/SPQ-05/SPQ/img/logoutB.png");
		Image img2 = icon2.getImage() ;  
		Image newimg2 = img2.getScaledInstance( logoutButton.getWidth(),logoutButton.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon2 = new ImageIcon( newimg2 );
		logoutButton.setIcon(icon2);
		logoutButton.setBorderPainted(false);
		logoutButton.setContentAreaFilled(false); 
		logoutButton.setFocusPainted(false); 
		logoutButton.setOpaque(false);
		panel.add(logoutButton);
		logoutButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});

		openRestaurantButton = new JButton();
		openRestaurantButton.setBounds(570, 250,40,40);
		ImageIcon icon3 = new ImageIcon("/home/gorka/workspace/SPQ-05/SPQ/img/openB.png");
		Image img3 = icon3.getImage() ;  
		Image newimg3 = img3.getScaledInstance( openRestaurantButton.getWidth(),openRestaurantButton.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon3 = new ImageIcon( newimg3 );
		openRestaurantButton.setIcon(icon3);
		openRestaurantButton.setBorderPainted(false);
		openRestaurantButton.setContentAreaFilled(false); 
		openRestaurantButton.setFocusPainted(false); 
		openRestaurantButton.setOpaque(false);
		panel.add(openRestaurantButton);
		openRestaurantButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openRestaurant();
			}
		});
		comboBoxName = new JComboBox<String>();
		comboBoxName.setBounds(93, 115, 120, 20);
		comboBoxName.setModel(new DefaultComboBoxModel<String>(namesTriki));
		panel.add(comboBoxName);

		comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.setBounds(278, 115, 96, 20);
		comboBoxCategory.setModel(new DefaultComboBoxModel<String>(categorysTriki));
		panel.add(comboBoxCategory);

		comboBoxPlace = new JComboBox<String>();
		comboBoxPlace.setBounds(93, 140, 120, 20);
		comboBoxPlace.setModel(new DefaultComboBoxModel<String>(placesTriki));
		panel.add(comboBoxPlace);

		comboBoxRate = new JComboBox<String>();
		comboBoxRate.setBounds(278, 140, 96, 20);
		comboBoxRate.setModel(new DefaultComboBoxModel<String>(ratesTriki));
		panel.add(comboBoxRate);
		table = new JTable(10,3);

		scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(60, 200, 477, 303);
//		scrollPane.setBorder(BorderFactory.createLineBorder(Color.RED));;
		panel.add(scrollPane);


		findButton = new JButton();
		findButton.setBounds(434, 110, 50, 50);
		ImageIcon icon1 = new ImageIcon("/home/gorka/workspace/SPQ-05/SPQ/img/findB.png");
		Image img1 = icon1.getImage() ;  
		Image newimg1 = img1.getScaledInstance( findButton.getWidth(),findButton.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg1 );
		findButton.setIcon(icon1);
		findButton.setBorderPainted(false);
		findButton.setContentAreaFilled(false); 
	    findButton.setFocusPainted(false); 
		findButton.setOpaque(false);
		panel.add(findButton);
		findButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						// TODO Auto-generated method stub
						execute();
					}
				});
			}
		});
				
		logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("/home/gorka/Pictures/logo.png"));
		logoLabel.setBounds(10, 10, 100, 75);
		panel.add(logoLabel);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("/home/gorka/Pictures/logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(),
				Image.SCALE_SMOOTH);

		ImageIcon imageIcon = new ImageIcon(dimg);

		logoLabel.setIcon(imageIcon);

		
		
		this.setVisible(true);

	}
	
	protected void execute(){
		
	}
	
	protected void logout(){
		
	}
	
	protected void openRestaurant() {
		
	}
}
