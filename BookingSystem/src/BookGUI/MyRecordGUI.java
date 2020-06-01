package BookGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;

import BookGUI.CancelGUI.ErrorListener;
import BookGUI.FindGUI.BackListener;
import BookGUI.FindGUI.ConfirmListener;
import failure_exception.NoOrderException;
import trip_function.SearchOrder;

/**
 * The GUI used in IndexGUI.
 * @author mealot
 *
 */
public class MyRecordGUI {

	private MyRecord frame;
	
	public MyRecordGUI() {
        frame = new MyRecord();
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
            	String[] tmp = msg.split(" ");
            	int userID = Integer.parseInt(tmp[0]);
            	int orderNumber = Integer.parseInt(tmp[1]);
            	System.out.printf("%d %d\n", userID, orderNumber);
            	String revMsg = null;
            	try{
            		revMsg = SearchOrder.search(userID, orderNumber);
            	}
            	catch(NoOrderException e){
            		revMsg = "查無此訂單";
            	}         
            	frame.setVisible(false);
            	OutputGUI gui =  new OutputGUI(revMsg);
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
            String Code = raw.nextToken();
            try {
            	int id = Integer.parseInt(ID);
            	int code = Integer.parseInt(Code);
            }
            catch(Exception e) {
            	return false;
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
