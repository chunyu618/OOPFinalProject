package BookGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import BookGUI.FindGUI.BackListener;
import BookGUI.FindGUI.ConfirmListener;
import BookGUI.FindGUI.ErrorListener;

import java.io.*;

/**
 * The GUI used in IndexGUI.
 * @author mealot
 *
 */
public class ReserveGUI {
   
    private Reserve frame;
    
    public ReserveGUI() {
        frame = new Reserve();
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
            if (ID.equals("null")) return false;
            String Year = raw.nextToken();
            String Month = raw.nextToken();
            int m = Integer.parseInt(Month);
            String Day = raw.nextToken();
            int d = Integer.parseInt(Day);
            if (m == 2 && d > 28) return false;
            if ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30) return false;
            Year = raw.nextToken();
            Month = raw.nextToken();
            m = Integer.parseInt(Month);
            Day = raw.nextToken();
            d = Integer.parseInt(Day);
            if (m == 2 && d > 28) return false;
            if ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30) return false;
            String number = raw.nextToken();
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
