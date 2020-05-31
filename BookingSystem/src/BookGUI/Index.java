package BookGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * The frame used in the GUI.
 * @author mealot
 *
 */
public class Index extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_1_1_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		setTitle("\u9810\u7D04\u7CFB\u7D71\u9996\u9801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B61\u8FCE\u4F86\u5230\u9810\u7D04\u7CFB\u7D71 !");
		lblNewLabel.setFont(new Font("·s²Ó©úÅé", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 416, 15);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("\u67E5\u8A62\u53EF\u9810\u5B9A\u884C\u7A0B");
		btnNewButton.setBounds(10, 35, 416, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u9810\u7D04\u884C\u7A0B");
		btnNewButton_1.setBounds(10, 68, 416, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1_1 = new JButton("\u53D6\u6D88 / \u4FEE\u6539\u884C\u7A0B");
		btnNewButton_1_1.setBounds(10, 101, 416, 23);
		contentPane.add(btnNewButton_1_1);
		
		btnNewButton_1_1_1 = new JButton("\u6211\u7684\u884C\u7A0B");
		btnNewButton_1_1_1.setBounds(10, 134, 416, 23);
		contentPane.add(btnNewButton_1_1_1);
	}
	public JButton getFind() {
		return btnNewButton;
	}
	public JButton getReserve() {
		return btnNewButton_1;
	}
	public JButton getCancel() {
		return btnNewButton_1_1;
	}
	public JButton getMy() {
		return btnNewButton_1_1_1;
	}
	
	

}

