package BookGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.table.*;

import trip_function.GetTrvaelingCode;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;

/**
 * The frame used in the GUI.
 * @author mealot
 *
 */
public class Find extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;
	private JComboBox comboBox_1_1_1;
	private JComboBox comboBox_1_2;
	private JComboBox comboBox_1_1_2;
	private JComboBox comboBox_1_1_1_1;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	
	private String[] columns;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find frame = new Find();
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
	public Find() {
		setTitle("\u67E5\u8A62\u53EF\u9810\u8A02\u884C\u7A0B");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u76EE\u7684\u5730 :");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 58, 15);
		contentPane.add(lblNewLabel);
		
		Map<String, Integer> map = GetTrvaelingCode.map;
		Set<String> dest = map.keySet();
		Object[] destString = dest.toArray();
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(destString));
		comboBox.setBounds(88, 6, 948, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("\u51FA\u767C\u65E5\u671F :");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 39, 66, 15);
		contentPane.add(lblNewLabel_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tmp = Integer.parseInt(String.valueOf(comboBox_1_1.getSelectedItem()));
				if (tmp == 2) {
					if (Integer.parseInt(String.valueOf(comboBox_1.getSelectedItem())) == 2020) {
						comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
					}
					else {
						comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
					}
				}
				else if (tmp == 4 || tmp == 6 || tmp == 9 || tmp == 11) {
					comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
				}
				else {
					comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021"}));
		comboBox_1.setBounds(88, 37, 88, 23);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(186, 39, 19, 15);
		contentPane.add(lblNewLabel_2);
		
		comboBox_1_1 = new JComboBox();
		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tmp = Integer.parseInt(String.valueOf(comboBox_1_1.getSelectedItem()));
				if (tmp == 2) {
					if (Integer.parseInt(String.valueOf(comboBox_1.getSelectedItem())) == 2020) {
						comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
					}
					else {
						comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
					}
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
		comboBox_1_1.setBounds(215, 37, 68, 23);
		contentPane.add(comboBox_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u6708");
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(293, 39, 19, 15);
		contentPane.add(lblNewLabel_2_1);
		
		comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1_1_1.setBounds(322, 37, 68, 23);
		contentPane.add(comboBox_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\u65E5  \u5230");
		lblNewLabel_2_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(408, 39, 43, 15);
		contentPane.add(lblNewLabel_2_1_1);
		
		btnNewButton = new JButton("\u78BA\u5B9A");
		btnNewButton.setBounds(1291, 35, 85, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setBounds(1291, 330, 85, 23);
		contentPane.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 1366, 256);
		contentPane.add(scrollPane);

		//sample
		columns = new String[] {
				"行程", "價格", "最少出團人數", "最多出團人數", "出發日期", "回台抵達日期"
	        };

	    Object[][] data = new Object[0][6];
		table = new JTable(data, columns);
		resizeColumnWidth(table);
		scrollPane.setViewportView(table);
		
		comboBox_1_2 = new JComboBox();
		comboBox_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tmp = Integer.parseInt(String.valueOf(comboBox_1_1_2.getSelectedItem()));
				if (tmp == 2) {
					if (Integer.parseInt(String.valueOf(comboBox_1_2.getSelectedItem())) == 2020) {
						comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
					}
					else {
						comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
					}
				}
				else if (tmp == 4 || tmp == 6 || tmp == 9 || tmp == 11) {
					comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
				}
				else {
					comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				}
			}
		});
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021"}));
		comboBox_1_2.setBounds(461, 37, 88, 23);
		contentPane.add(comboBox_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u5E74");
		lblNewLabel_2_2.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(559, 39, 19, 15);
		contentPane.add(lblNewLabel_2_2);
		
		comboBox_1_1_2 = new JComboBox();
		comboBox_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tmp = Integer.parseInt(String.valueOf(comboBox_1_1_2.getSelectedItem()));
				if (tmp == 2) {
					if (Integer.parseInt(String.valueOf(comboBox_1_2.getSelectedItem())) == 2020) {
						comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
					}
					else {
						comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
					}
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
		comboBox_1_1_2.setBounds(588, 37, 68, 23);
		contentPane.add(comboBox_1_1_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("\u6708");
		lblNewLabel_2_1_2.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(666, 39, 19, 15);
		contentPane.add(lblNewLabel_2_1_2);
		
		comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1_1_1_1.setBounds(695, 37, 68, 23);
		contentPane.add(comboBox_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("\u65E5 \u4E4B\u9593");
		lblNewLabel_2_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(773, 39, 47, 15);
		contentPane.add(lblNewLabel_2_1_1_1);
	}
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 80; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 800)
	            width=800;
	        columnModel.getColumn(column).setPreferredWidth(width);
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
		msg += String.valueOf(comboBox.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_1.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_1_1.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_2.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_1_2.getSelectedItem()) + " ";
		msg += String.valueOf(comboBox_1_1_1_1.getSelectedItem());
		return msg;
	}
	public void setTable(Object[][] tmp) {
		table = new JTable(tmp, columns);
		resizeColumnWidth(table);
		scrollPane.setViewportView(table);
	}
}
