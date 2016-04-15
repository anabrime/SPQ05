import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Basic_LoginWindow extends JFrame{
	public Basic_LoginWindow() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(109, 199, 117, 25);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 10, 10);
		panel.add(panel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/gorka/Pictures/logo.png"));
		label.setBounds(12, 72, 431, 266);
		panel.add(label);
	}
}
