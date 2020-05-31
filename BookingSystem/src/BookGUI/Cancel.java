package BookGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

/**
 * The frame used in the GUI.
 * @author mealot
 *
 */
public class Cancel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JComboBox comboBox_1_2_1;
	
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
					Cancel frame = new Cancel();
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
	public Cancel() {
		setTitle("\u9000\u8A02\u8207\u4FEE\u6539");
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
						lblNewLabel_2.setText("Hint...輸入不可包含空白字元");
						flag = true;
					}
				}
				msg = textField_1.getText();
				raw = new StringTokenizer(msg);
				if (raw.hasMoreTokens()) {
					String tmp = raw.nextToken();
					if(raw.hasMoreTokens()) {
						lblNewLabel_2.setText("Hint...輸入不可包含空白字元");
						flag = true;
					}
				}
				if(flag == true) {
					lblNewLabel_2.setText("Hint...輸入不可包含空白字元");
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
		
		JLabel lblNewLabel_1 = new JLabel("\u8A02\u4F4D\u4EE3\u865F :");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 43, 67, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				boolean flag = false;
				String msg = textField.getText();
				StringTokenizer raw = new StringTokenizer(msg);
				if (raw.hasMoreTokens()) {
					String tmp = raw.nextToken();
					if(raw.hasMoreTokens()) {
						lblNewLabel_2.setText("Hint...輸入不可包含空白字元");
						flag = true;
					}
				}
				msg = textField_1.getText();
				raw = new StringTokenizer(msg);
				if (raw.hasMoreTokens()) {
					String tmp = raw.nextToken();
					if(raw.hasMoreTokens()) {
						lblNewLabel_2.setText("Hint...輸入不可包含空白字元");
						flag = true;
					}
				}
				if(flag == true) {
					lblNewLabel_2.setText("Hint...輸入不可包含空白字元");
				}
				else {
					lblNewLabel_2.setText("Hint...");
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(87, 40, 237, 21);
		contentPane.add(textField_1);
		
		rdbtnNewRadioButton = new JRadioButton("\u53D6\u6D88\u8A02\u55AE");
		rdbtnNewRadioButton.addActionListener(new CancelListener());
		rdbtnNewRadioButton.setFont(new Font("新細明體", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(10, 73, 105, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("\u66F4\u6539\u70BA");
		rdbtnNewRadioButton_1.addActionListener(new ChangeListener());
		rdbtnNewRadioButton_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(10, 101, 69, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		btnNewButton = new JButton("\u78BA\u8A8D");
		btnNewButton.setBounds(341, 101, 85, 23);
		contentPane.add(btnNewButton);
		
		comboBox_1_2_1 = new JComboBox();
		comboBox_1_2_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"}));
		comboBox_1_2_1.setBounds(87, 101, 58, 23);
		contentPane.add(comboBox_1_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u4EBA");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(155, 105, 22, 15);
		contentPane.add(lblNewLabel_1_1);
		
		lblNewLabel_2 = new JLabel("Hint...");
		lblNewLabel_2.setBounds(10, 130, 329, 15);
		contentPane.add(lblNewLabel_2);
	}
	
	class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        	rdbtnNewRadioButton_1.setSelected(false);
        }
    }
	class ChangeListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        	rdbtnNewRadioButton.setSelected(false);
        }
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
		if(rdbtnNewRadioButton.isSelected()) {
			msg += "Cancel";
		}
		else if(rdbtnNewRadioButton_1.isSelected()) {
			msg += "Change ";
			msg += String.valueOf(comboBox_1_2_1.getSelectedItem());
		}
		return msg;
	}
}
