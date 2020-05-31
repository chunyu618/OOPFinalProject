package BookGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;

import BookGUI.FindGUI.BackListener;
import BookGUI.FindGUI.ConfirmListener;
import BookGUI.ReserveGUI.ErrorListener;

/**
 * The GUI used in IndexGUI.
 * @author mealot
 *
 */
public class CancelGUI {
	
	private Cancel frame;
	
	public CancelGUI() {
        frame = new Cancel();
    }
	
	/**
     * run to show the window
     */
    public void run() {
    	frame.getConfirm().addActionListener(new ConfirmListener());
    	frame.getBack().addActionListener(new BackListener());
         
        frame.setVisible(true);
    }
    
    protected JButton getBackButton() {
    	return frame.getBack();
    }
     
    class ConfirmListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String msg = frame.getMessage();
            if (isLegal(msg) == false) {
            	frame.setVisible(false);
            	ErrorPageGUI gui =  new ErrorPageGUI();
            	gui.run();
            	JButton b = gui.getBackButton();
                b.addActionListener(new ErrorListener());
            	return;
            }
            else {
            	/*
            	 * Do things here
            	 */
            	String result = "Oppai\n(.)(.)";
            	frame.setVisible(false);
            	OutputGUI gui =  new OutputGUI(result);
            	gui.run();
            	JButton b = gui.getBackButton();
                b.addActionListener(new ErrorListener());
            	return;
            }
        }
    }
    class ErrorListener implements ActionListener {
    	public void actionPerformed(ActionEvent event) {
        	frame.setVisible(true);
        }
    }
    private boolean isLegal(String msg) {
    	StringTokenizer raw = new StringTokenizer(msg);
    	try{
    		String ID = raw.nextToken();
            String code = raw.nextToken();
            String Action = raw.nextToken();
            if(Action.equals("Cancel")) return true;
            if(Action.equals("Change")) {
            	String number = raw.nextToken();
            }
            if (raw.hasMoreTokens()) return false;
            return true;
        }
    	catch(Exception e){
    		return false;
    	}
    }
     
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        	frame.setVisible(false);
        }
    }
}
