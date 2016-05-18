package es.deusto.client.basic;
import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	protected JLabel userNameLabel;
	protected JButton logoutButton;
	protected JButton findButton;
	protected JButton openRestaurantButton;
	protected JButton premiumButton;
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
	protected JPanel panelBonito2;
	protected JPanel panelBonito3;

	public Basic_MainWindow() {
	    
		setResizable(false );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		userNameLabel = new JLabel("User A");
		userNameLabel.setBounds(469, 34, 54, 14);
		userNameLabel.setEnabled(false);
		panel.add(userNameLabel);

		logoutButton = new JButton();
		logoutButton.setBounds(542, 30, 35, 35);
		ImageIcon icon2 = new ImageIcon(new File("img/logoutB.png").getAbsolutePath());
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
		openRestaurantButton.setBounds(537, 110,50,50);
		ImageIcon icon3 = new ImageIcon(new File("img/openB.png").getAbsolutePath());
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
		
		premiumButton = new JButton();
		premiumButton.setBounds(590, 30, 75, 75);
		ImageIcon icon4 = new ImageIcon(new File("img/premiumB.png").getAbsolutePath());
		Image img4 = icon4.getImage() ; 
		Image newimg4 = img4.getScaledInstance( premiumButton.getWidth(), premiumButton.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon4 = new ImageIcon( newimg4 );
		premiumButton.setIcon(icon4);
		premiumButton.setBorderPainted(false);
		premiumButton.setContentAreaFilled(false); 
		premiumButton.setFocusPainted(false); 
		premiumButton.setOpaque(false);
		panel.add(premiumButton);
		premiumButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openPremium();			
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
		findButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		ImageIcon icon1 = new ImageIcon(new File("img/findB.png").getAbsolutePath());
		Image img1 = icon1.getImage() ;  
		Image newimg1 = img1.getScaledInstance( findButton.getWidth(),findButton.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg1 );
		findButton.setIcon(icon1);
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
		
		JPanel panelBonito = new JPanel();
		panelBonito.setBackground(Color.DARK_GRAY);
		panelBonito.setBounds(78, 91, 383, 89);
		panelBonito.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.add(panelBonito);
		
		panelBonito2 = new JPanel();
		panelBonito2.setBounds(537, 110, 50, 50);
		panelBonito2.setBackground(Color.DARK_GRAY);
		panelBonito2.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panel.add(panelBonito2);
		
		panelBonito3 = new JPanel();
		panelBonito3.setBounds(484, 133, 51, 2);
		panelBonito3.setBackground(Color.DARK_GRAY);
		panelBonito3.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panel.add(panelBonito3);
		
		
		
		this.setVisible(true);

	}
	
	protected void openPremium(){
		
	}
	
	
	protected void execute(){
		
	}
	
	@Override
	public void paint(Graphics g) {
	    Graphics2D g2d = (Graphics2D)g.create();
	    g2d.setColor(Color.RED);
	    g2d.drawLine(100, 100, 400, 100);
	}
	
	protected void logout(){
		
	}
	
	protected void openRestaurant() {
		
	}
}
