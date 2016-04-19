package es.deusto.client;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class Basic_RestaurantWindow extends JFrame {
	
	private JTextField textField;
	private JTextField textField_1;
	protected String[] books = { "14:00","14:30", "15:00", "21:00","21:30", "22:00" };
	protected String[] booksTriki = { "Hour","14:00","14:30", "15:00", "21:00","21:30", "22:00" };
	protected String[] rates = { "1", "2", "3", "4", "5" };
	protected String[] ratesTriki = { "Rate","1", "2", "3", "4", "5" };
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public Basic_RestaurantWindow(){
		setSize(840,470);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 232, 114);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 193, 379, 249);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnName = new JTextPane();
		txtpnName.setText("Name:");
		txtpnName.setBounds(168, 11, 50, 20);
		panel_1.add(txtpnName);
		
		JTextPane txtpnLocation_1 = new JTextPane();
		txtpnLocation_1.setText("Location:");
		txtpnLocation_1.setBounds(168, 35, 50, 20);
		panel_1.add(txtpnLocation_1);
		
		JTextPane txtpnRate = new JTextPane();
		txtpnRate.setText("Rate:");
		txtpnRate.setBounds(168, 59, 50, 20);
		panel_1.add(txtpnRate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 90, 359, 148);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 147, 68);
		panel_1.add(panel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(228, 11, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(228, 35, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(228, 59, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(507, 193, 313, 249);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNombre = new JLabel("User name:");
		lblNombre.setBounds(10, 70, 71, 28);
		panel_2.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(68, 74, 86, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblComentarios = new JLabel("Comments");
		lblComentarios.setFont((new java.awt.Font("Tahoma", 0, 36)));
		lblComentarios.setBounds(10, 11, 255, 44);
		panel_2.add(lblComentarios);
		
		textField_2 = new JTextField();
		textField_2.setBounds(68, 117, 235, 121);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JTextPane txtpnComment = new JTextPane();
		txtpnComment.setText("Comment:");
		txtpnComment.setBounds(10, 117, 71, 28);
		panel_2.add(txtpnComment);
		
		JButton btnNewButton = new JButton("FIND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//It sends you to the principal window.
			}
		});
		btnNewButton.setBounds(10, 136, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// It introduces the data in the DB.
				
			}
		});
		btnNewButton_1.setBounds(731, 136, 89, 23);
		getContentPane().add(btnNewButton_1);
				final JComboBox<String> comboBoxBook = new JComboBox<String>();
		comboBoxBook.setBounds(261, 137, 96, 20);
		comboBoxBook.setModel(new DefaultComboBoxModel<String>(booksTriki));
		getContentPane().add(comboBoxBook);
		comboBoxBook.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				comboBoxBook.setModel(new DefaultComboBoxModel<String>(booksTriki));
				comboBoxBook.setSelectedIndex(0);
				repaint();
			}

			public void focusGained(FocusEvent e) {
				comboBoxBook.setModel(new DefaultComboBoxModel<String>(books));
				repaint();
			}
		});
		
		final JComboBox<String> comboBoxRate = new JComboBox<String>();
		comboBoxRate.setBounds(532, 137, 96, 20);
		comboBoxRate.setModel(new DefaultComboBoxModel<String>(ratesTriki));
		getContentPane().add(comboBoxRate);
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
		
		JTextPane txtpnNombreDelUsuario = new JTextPane();
		txtpnNombreDelUsuario.setText("User name");
		txtpnNombreDelUsuario.setBounds(601, 11, 106, 20);
		getContentPane().add(txtpnNombreDelUsuario);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.setBounds(731, 8, 89, 23);
		getContentPane().add(btnLogout);
		repaint();
		
	}


}
