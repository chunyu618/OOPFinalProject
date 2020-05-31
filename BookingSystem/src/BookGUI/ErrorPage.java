package BookGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class ErrorPage extends JFrame {

	private JPanel contentPane;
	
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorPage frame = new ErrorPage();
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
	public ErrorPage() {
		setTitle("\u932F\u8AA4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F38\u5165\u8A0A\u606F\u6709\u8AA4");
		lblNewLabel.setFont(new Font("·s²Ó©úÅé", Font.PLAIN, 14));
		lblNewLabel.setBounds(72, 25, 86, 26);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setBounds(72, 68, 85, 23);
		contentPane.add(btnNewButton);
	}
	public JButton getBack() {
		return btnNewButton;
	}

}
