package BookGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The frame used in the GUI.
 * @author mealot
 *
 */
public class Reserve extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;
	private JComboBox comboBox_1_1_1;
	private JComboBox comboBox_1_2;
	private JComboBox comboBox_1_1_2;
	private JComboBox comboBox_1_1_1_1;
	private JComboBox comboBox_1_2_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserve frame = new Reserve();
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
	public Reserve() {
		setTitle("\u9810\u7D04\u884C\u7A0B\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4F7F\u7528\u8005ID :");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 67, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u51FA\u767C\u65E5\u671F :");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 39, 66, 15);
		contentPane.add(lblNewLabel_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021"}));
		comboBox_1.setBounds(88, 35, 58, 23);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(156, 39, 19, 15);
		contentPane.add(lblNewLabel_2);
		
		comboBox_1_1 = new JComboBox();
		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tmp = Integer.parseInt(String.valueOf(comboBox_1_1.getSelectedItem()));
				if (tmp == 2) {
					comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
				}
				else if (tmp == 4 || tmp == 6 || tmp == 9 || tmp == 11) {
					comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
				}
				else {
					comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				}
			}
		});
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1_1.setBounds(185, 35, 43, 23);
		contentPane.add(comboBox_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u6708");
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(238, 39, 19, 15);
		contentPane.add(lblNewLabel_2_1);
		
		comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1_1_1.setBounds(267, 35, 43, 23);
		contentPane.add(comboBox_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\u65E5");
		lblNewLabel_2_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(320, 39, 19, 15);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u62B5\u53F0\u65E5\u671F :");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 68, 66, 15);
		contentPane.add(lblNewLabel_1_1);
		
		comboBox_1_2 = new JComboBox();
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021"}));
		comboBox_1_2.setBounds(88, 64, 58, 23);
		contentPane.add(comboBox_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u5E74");
		lblNewLabel_2_2.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(156, 68, 19, 15);
		contentPane.add(lblNewLabel_2_2);
		
		comboBox_1_1_2 = new JComboBox();
		comboBox_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tmp = Integer.parseInt(String.valueOf(comboBox_1_1_2.getSelectedItem()));
				if (tmp == 2) {
					comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
				}
				else if (tmp == 4 || tmp == 6 || tmp == 9 || tmp == 11) {
					comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
				}
				else {
					comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				}
			}
		});
		comboBox_1_1_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1_1_2.setBounds(185, 64, 43, 23);
		contentPane.add(comboBox_1_1_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("\u6708");
		lblNewLabel_2_1_2.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(238, 68, 19, 15);
		contentPane.add(lblNewLabel_2_1_2);
		
		comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1_1_1_1.setBounds(267, 64, 43, 23);
		contentPane.add(comboBox_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("\u65E5");
		lblNewLabel_2_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(320, 68, 19, 15);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		textField = new JTextField();
		textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String msg = textField.getText();
				StringTokenizer raw = new StringTokenizer(msg);
				if (raw.hasMoreTokens()) {
					String tmp = raw.nextToken();
					if(raw.hasMoreTokens()) {
						lblNewLabel_3.setText("Hint...輸入不可包含空白字元");
					}
					else {
						lblNewLabel_3.setText("Hint...");
					}
				}
				else {
					lblNewLabel_3.setText("Hint...");
				}
			}
		});
		textField.setBounds(87, 7, 237, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u5165\u4F4F\u4EBA\u6578 :");
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 97, 66, 15);
		contentPane.add(lblNewLabel_1_1_1);
		
		comboBox_1_2_1 = new JComboBox();
		comboBox_1_2_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"}));
		comboBox_1_2_1.setBounds(88, 93, 58, 23);
		contentPane.add(comboBox_1_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("\u4EBA");
		lblNewLabel_2_2_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(156, 97, 19, 15);
		contentPane.add(lblNewLabel_2_2_1);
		
		btnNewButton = new JButton("\u78BA\u8A8D");
		btnNewButton.setBounds(341, 93, 85, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setBounds(341, 6, 85, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("Hint...");
		lblNewLabel_3.setBounds(10, 122, 329, 15);
		contentPane.add(lblNewLabel_3);
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
		msg += String.valueOf(comboBox_1.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_1.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_1_1.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_2.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_1_2.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_1_1_1.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_2_1.getSelectedItem()) + " ";
		return msg;
	}
}
