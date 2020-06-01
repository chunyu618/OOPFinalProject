package BookGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

/**
 * The frame used in the GUI.
 * @author mealot
 *
 */
public class MyRecord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyRecord frame = new MyRecord();
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
	public MyRecord() {
		setTitle("\u6211\u7684\u884C\u7A0B");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4F7F\u7528\u8005ID :");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 14, 67, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				boolean flag = false;
				String msg = textField.getText();
				StringTokenizer raw = new StringTokenizer(msg);
				if (raw.hasMoreTokens()) {
					String tmp = raw.nextToken();
					if(raw.hasMoreTokens()) {
						flag = true;
					}
					else {
						try {
							int ID = Integer.parseInt(tmp);
						}
						catch(Exception ex) {
							flag = true;
						}
					}
				}
				msg = textField_1.getText();
				raw = new StringTokenizer(msg);
				if (raw.hasMoreTokens()) {
					String tmp = raw.nextToken();
					if(raw.hasMoreTokens()) {
						flag = true;
					}
					else {
						try {
							int ID = Integer.parseInt(tmp);
						}
						catch(Exception ex) {
							flag = true;
						}
					}
				}
				if(flag == true) {
					lblNewLabel_2.setText("Hint...請輸入一個整數");
				}
				else {
					lblNewLabel_2.setText("Hint...");
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(87, 11, 237, 21);
		contentPane.add(textField);
		
		btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setBounds(341, 10, 85, 23);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				boolean flag = false;
				String msg = textField.getText();
				StringTokenizer raw = new StringTokenizer(msg);
				if (raw.hasMoreTokens()) {
					String tmp = raw.nextToken();
					if(raw.hasMoreTokens()) {
						flag = true;
					}
					else {
						try {
							int ID = Integer.parseInt(tmp);
						}
						catch(Exception ex) {
							flag = true;
						}
					}
				}
				msg = textField_1.getText();
				raw = new StringTokenizer(msg);
				if (raw.hasMoreTokens()) {
					String tmp = raw.nextToken();
					if(raw.hasMoreTokens()) {
						flag = true;
					}
					else {
						try {
							int ID = Integer.parseInt(tmp);
						}
						catch(Exception ex) {
							flag = true;
						}
					}
				}
				if(flag == true) {
					lblNewLabel_2.setText("Hint...請輸入一個整數");
				}
				else {
					lblNewLabel_2.setText("Hint...");
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(87, 40, 237, 21);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u8A02\u55AE\u7DE8\u865F :");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 43, 67, 15);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("\u78BA\u8A8D");
		btnNewButton.setBounds(341, 101, 85, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Hint...");
		lblNewLabel_2.setBounds(10, 71, 329, 15);
		contentPane.add(lblNewLabel_2);
	}
	public JButton getBack() {
		return btnNewButton_1;
	}
	public JButton getConfirm() {
		return btnNewButton;
	}
	public String getMessage() {
		String msg = "";
		msg += textField.getText() + " ";
		msg += textField_1.getText() + " ";
		return msg;
	}
}
