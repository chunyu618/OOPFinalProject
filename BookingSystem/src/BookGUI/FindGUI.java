package BookGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import BookGUI.IndexGUI.BackListener;
import failure_exception.NoTripException;
import trip_function.Policy;
import trip_function.SearchTrip;

import java.io.*;

/**
 * The GUI used in IndexGUI.
 * @author mealot
 *
 */
public class FindGUI {

    private Find frame;
    
    public FindGUI() {
        frame = new Find();
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
            	String dest = tmp[0];
            	Calendar c1 = new GregorianCalendar(Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
            	Calendar c2 = new GregorianCalendar(Integer.parseInt(tmp[4]), Integer.parseInt(tmp[5]), Integer.parseInt(tmp[6]));
            	
            	Policy policy = new Policy(dest, c1, c2);
            	try{
            		ArrayList<Object[]> tmpList = SearchTrip.searchByPolicy(policy);
            		Object[][] tmpArray = new Object[tmpList.size()][7];
            		for(int i = 0; i < tmpList.size(); i++){
            			tmpArray[i] = tmpList.get(i);
            		}
            		frame.setTable(tmpArray);
            		return;
            	}
            	catch(NoTripException e){
            		frame.setVisible(false);
            		OutputGUI gui = new OutputGUI("無符合行程");
            		gui.run();
            		JButton b = gui.getBackButton();
            		b.addActionListener(new ErrorListener());
            		return;
            	}
            }
        }
    }
     
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        	frame.setVisible(false);
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
            String Dest = raw.nextToken();
            if (Dest.equals("null")) return false;
            String Year = raw.nextToken();
            String Month = raw.nextToken();
            int m = Integer.parseInt(Month);
            String Day = raw.nextToken();
            int d = Integer.parseInt(Day);
            Year = raw.nextToken();
            Month = raw.nextToken();
            m = Integer.parseInt(Month);
            Day = raw.nextToken();
            d = Integer.parseInt(Day);
            return true;
        }
    	catch(Exception e){
    		return false;
    	}
    }
}