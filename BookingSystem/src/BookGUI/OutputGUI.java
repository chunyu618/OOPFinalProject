package BookGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import BookGUI.ErrorPageGUI.BackListener;

/**
 * The GUI used in subGUI.
 * @author mealot
 *
 */
public class OutputGUI {
	
	private Output frame;
    
	public OutputGUI() {
        frame = new Output();
    }
	public OutputGUI(String msg) {
        frame = new Output(msg);
    }
	public void run() {
    	frame.getBack().addActionListener(new BackListener());
         
        frame.setVisible(true);
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        	frame.setVisible(false);
        }
    }
    protected JButton getBackButton() {
    	return frame.getBack();
    }
}
