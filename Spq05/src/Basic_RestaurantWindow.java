import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class Basic_RestaurantWindow extends JFrame {
	
	private JTextField textField;
	
	
	public Basic_RestaurantWindow(){
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 232, 114);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 193, 220, 249);
		getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(507, 220, 313, 222);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(41, 117, 224, 94);
		panel_2.add(editorPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 70, 71, 28);
		panel_2.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(68, 74, 86, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblComentarios = new JLabel("Comentarios");
		lblComentarios.setFont((new java.awt.Font("Tahoma", 0, 36)));
		lblComentarios.setBounds(10, 11, 255, 44);
		panel_2.add(lblComentarios);
		
		JButton btnNewButton = new JButton("FIND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 136, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerform3d(ActionEvent arg0) {
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1.setBounds(741, 122, 89, 23);
		getContentPane().add(btnNewButton_1);
				JComboBox comboBox = new JComboBox();
		comboBox.setBounds(248, 123, 97, 20);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(507, 123, 89, 20);
		getContentPane().add(comboBox_1);
		
		JTextPane txtpnNombreDelUsuario = new JTextPane();
		txtpnNombreDelUsuario.setText("Nombre del usuario");
		txtpnNombreDelUsuario.setBounds(601, 11, 106, 20);
		getContentPane().add(txtpnNombreDelUsuario);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.setBounds(731, 8, 89, 23);
		getContentPane().add(btnLogout);
		
		
	}


	public static void main(String[] args) {
		
		new Basic_RestaurantWindow();
	}
}
