package BookGUI;

import database_utils.OrderDataHandler;
import database_utils.TourDataHandler;

/**
 * Demo program. Shows the default interface. 
 * @author mealot
 *
 */
public class Demo {
    public static void main(String[] args) {
    	//TourDataHandler.setAllPeopleCountToZero();
    	OrderDataHandler.createOrderDataTable();
    	IndexGUI gui = new IndexGUI();
        gui.run();
    }
}  