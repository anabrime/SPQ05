package es.deusto.client;
import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Basic_MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable table;
	protected String[] names = {"Telepizza", "Deustoarrak ", "Foster" };
	protected String[] places = {"Bilbao", "Gorliz ", "Getxo" };
	protected String[] categorys = {"Mexican", "Italian ", "American", "Asian" };
	protected String[] rates = {"1", "2", "3", "4", "5" };

	protected String[] namesTriki = { "Name","Telepizza", "Deustoarrak ", "Foster" };
	protected String[] placesTriki = { "Place","Bilbao", "Gorliz ", "Getxo" };
	protected String[] categorysTriki = { "Category","Mexican", "Italian ", "American", "Asian" };
	protected String[] ratesTriki = { "Rate","1", "2", "3", "4", "5" };

	public Basic_MainWindow() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		Panel panel = new Panel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel UserNameLabel = new JLabel("User A");
		UserNameLabel.setBounds(469, 34, 54, 14);
		UserNameLabel.setEnabled(false);
		panel.add(UserNameLabel);

		JButton LogoutButton = new JButton("Logout");
		LogoutButton.setBounds(542, 30, 81, 23);
		panel.add(LogoutButton);

		final JComboBox<String> comboBoxName = new JComboBox<String>();
		comboBoxName.setBounds(93, 88, 120, 20);
		comboBoxName.setModel(new DefaultComboBoxModel<String>(namesTriki));
		panel.add(comboBoxName);
		comboBoxName.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				comboBoxName.setModel(new DefaultComboBoxModel<String>(namesTriki));
				comboBoxName.setSelectedIndex(0);
				repaint();
			}

			public void focusGained(FocusEvent e) {
				comboBoxName.setModel(new DefaultComboBoxModel<String>(names));
				repaint();
			}
		});

		final JComboBox<String> comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.setBounds(278, 88, 96, 20);
		comboBoxCategory.setModel(new DefaultComboBoxModel<String>(categorysTriki));
		panel.add(comboBoxCategory);
		comboBoxCategory.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				comboBoxCategory.setModel(new DefaultComboBoxModel<String>(categorysTriki));
				comboBoxCategory.setSelectedIndex(0);
				repaint();
			}

			public void focusGained(FocusEvent e) {
				comboBoxCategory.setModel(new DefaultComboBoxModel<String>(categorys));
				repaint();
			}
		});

		final JComboBox<String> comboBoxPlace = new JComboBox<String>();
		comboBoxPlace.setBounds(93, 113, 120, 20);
		comboBoxPlace.setModel(new DefaultComboBoxModel<String>(placesTriki));
		panel.add(comboBoxPlace);
		comboBoxPlace.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				comboBoxPlace.setModel(new DefaultComboBoxModel<String>(placesTriki));
				comboBoxPlace.setSelectedIndex(0);
				repaint();
			}

			public void focusGained(FocusEvent e) {
				comboBoxPlace.setModel(new DefaultComboBoxModel<String>(places));
				repaint();
			}
		});

		final JComboBox<String> comboBoxRate = new JComboBox<String>();
		comboBoxRate.setBounds(278, 113, 96, 20);
		comboBoxRate.setModel(new DefaultComboBoxModel<String>(ratesTriki));
		panel.add(comboBoxRate);
		comboBoxRate.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				comboBoxRate.setModel(new DefaultComboBoxModel<String>(ratesTriki));
				comboBoxRate.setSelectedIndex(0);
				repaint();
			}

			public void focusGained(FocusEvent e) {
				comboBoxRate.setModel(new DefaultComboBoxModel<String>(rates));
				repaint();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 168, 477, 303);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(434, 97, 89, 23);
		panel.add(btnFind);
				
		/*JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("C:\\Users\\Jon\\git\\spq\\Spq05\\img\\logo.png"));
		labelLogo.setBounds(10, 11, 228, 73);
		panel.add(labelLogo);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\Jon\\git\\spq\\Spq05\\img\\logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(),
				Image.SCALE_SMOOTH);

		ImageIcon imageIcon = new ImageIcon(dimg);

		labelLogo.setIcon(imageIcon);*/

		
		
		this.setVisible(true);

	}
}
