package BookGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import BookGUI.FindGUI.BackListener;
import BookGUI.FindGUI.ConfirmListener;

/**
 * The GUI used in subGUI.
 * @author mealot
 *
 */
public class ErrorPageGUI {

	private ErrorPage frame;
    
    public ErrorPageGUI() {
        frame = new ErrorPage();
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
