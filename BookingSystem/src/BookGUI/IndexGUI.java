package BookGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

/**
 * 
 * The GUI used in Demo.
 * @author mealot
 *
 */
public class IndexGUI {

    private Index frame;

    public IndexGUI() {
        frame = new Index();
    }
     
    // make the window
    /**
     * To start the GUI program.
     */
    public void run() {
         
        // Components handles events
        frame.getFind().addActionListener(new FindListener());
        frame.getReserve().addActionListener(new ReserveListener());
        frame.getCancel().addActionListener(new CancelListener());
        frame.getMy().addActionListener(new MyListener());

        frame.setVisible(true);
    }

     
    // Find available trips
    class FindListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        	frame.setVisible(false);
        	FindGUI gui = new FindGUI();
        	gui.run();
        	JButton b = gui.getBackButton();
            b.addActionListener(new BackListener());
        }
    }
     
    // Book a trip
    class ReserveListener implements ActionListener {
    	public void actionPerformed(ActionEvent event) {
    		frame.setVisible(false);
        	ReserveGUI gui = new ReserveGUI();
        	gui.run();
        	JButton b = gui.getBackButton();
            b.addActionListener(new BackListener());
        }
    }
     
    // Cancel or modify
    class CancelListener implements ActionListener {
    	public void actionPerformed(ActionEvent event) {
    		frame.setVisible(false);
        	CancelGUI gui = new CancelGUI();
        	gui.run();
        	JButton b = gui.getBackButton();
            b.addActionListener(new BackListener());
        }
    }
     
    // My trips
    class MyListener implements ActionListener {
    	public void actionPerformed(ActionEvent event) {
    		frame.setVisible(false);
        	MyRecordGUI gui = new MyRecordGUI();
        	gui.run();
        	JButton b = gui.getBackButton();
            b.addActionListener(new BackListener());
        }
    }
    class BackListener implements ActionListener {
    	public void actionPerformed(ActionEvent event) {
        	frame.setVisible(true);
        }
    }

}