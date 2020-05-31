package BookGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

/**
 * The frame used in the GUI.
 * @author mealot
 *
 */
public class Output extends JFrame {

	private JPanel contentPane;
	
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Output frame = new Output();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Output() {
		setTitle("\u7D50\u679C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea lblNewLabel = new JTextArea("Ochinchin\r\nOchinpo\r\nChinchin\r\nChinco");
		lblNewLabel.setBounds(5, 5, 426, 215);
		lblNewLabel.setEditable(false);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setBounds(181, 230, 85, 23);
		contentPane.add(btnNewButton);
	}
	public Output(String msg) {
		setTitle("\u7D50\u679C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea lblNewLabel = new JTextArea(msg);
		lblNewLabel.setBounds(5, 5, 426, 215);
		lblNewLabel.setEditable(false);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setBounds(181, 230, 85, 23);
		contentPane.add(btnNewButton);
	}
	public JButton getBack() {
		return btnNewButton;
	}

}
