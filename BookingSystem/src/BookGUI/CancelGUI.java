package BookGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;

import BookGUI.FindGUI.BackListener;
import BookGUI.FindGUI.ConfirmListener;
import BookGUI.ReserveGUI.ErrorListener;
import failure_exception.InsufficientPeopleException;
import failure_exception.NoOrderException;
import trip_function.ChangeOrder;

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
            	String revMsg = null;
            	String[] tmp = msg.split(" ");
            	if(tmp[2].equals("Cancel")){
            		try{
            			int userID = Integer.parseInt(tmp[0]);
            			int orderNumber = Integer.parseInt(tmp[1]);
            			ChangeOrder.cancel(userID, orderNumber);
            			revMsg = "退訂成功，已取消您的訂購紀錄";
            		}
            		catch(NoOrderException e){
            			revMsg = "退訂失敗，此訂單不存在";
            		}
            	}
            	else{
            		try{
            			int userID = Integer.parseInt(tmp[0]);
            			int orderNumber = Integer.parseInt(tmp[1]);
            			int adult = Integer.parseInt(tmp[3]);
            			int child = Integer.parseInt(tmp[4]);
            			ChangeOrder.change(userID, orderNumber, adult, child);
            			revMsg = "修改成功，已將您的訂購更改為大人" + adult + "人，小孩" + child + "人";
            		}
            		catch(NoOrderException e){
            			revMsg = "修改失敗，此訂單不存在";
            		}
            		catch(InsufficientPeopleException e){
            			revMsg = "修改失敗，超過人數上限";
            		}
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
            String Action = raw.nextToken();
            if(Action.equals("Cancel")) return true;
            if(Action.equals("Change")) {
            	String number1 = raw.nextToken();
            	String number2 = raw.nextToken();
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
