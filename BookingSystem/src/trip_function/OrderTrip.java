package trip_function;

import database_utils.TourData;


import java.util.ArrayList;

import database_utils.OrderData;
import database_utils.OrderDataHandler;
import database_utils.TourDataHandler;

/**
 * OrderTrip will make order basically on tour and userID.
 * @author lijunyu
 *
 */
public class OrderTrip {
	
	
	public static boolean orderTrip(TourData td, int userID){
		OrderData od = new OrderData();
		int orderNumber = OrderNumberManager.newOrder(userID, td);
		od.setOrderNumber(orderNumber);
		od.setUserID(userID);
		od.setNumberOfAdults(2);
		od.setNumberOfBabies(1);
		od.setNumberOfChildren(1);
		od.setTotalPrice(11000);
		od.setStartDate(td.getStartDate());
		od.setEndDate(td.getEndDate());
		return OrderDataHandler.addOrderData(od);
	}
}
