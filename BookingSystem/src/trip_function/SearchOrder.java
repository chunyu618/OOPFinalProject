package trip_function;

import database_utils.OrderData;
import database_utils.OrderDataHandler;
import failure_exception.NoOrderException;

/**
 * SearchOrder class will search the order according to the userID and order number.
 * It will throw NoOrderException if there is no such order.
 * @author lijunyu
 *
 */
public class SearchOrder {
	
	/**
	 * search method will search the order according to the userID and order number.
	 * It will throw NoOrderException if there is no such order.
	 * @param userID
	 * @param orderNumber
	 * @return Order information
	 * @throws NoOrderException
	 */
	public static String search(int userID, int orderNumber) throws NoOrderException{
		
		// Get the order from database.
		OrderData od = OrderDataHandler.getOrderData(userID, orderNumber);
		// If od is null, then there is no such order.
		if(od == null){
			throw new NoOrderException();
		}
		// return the order information.
		return "行程編號: " + od.getTravelCode() + "\n" + 
				"人數: " + "大人" + od.getNumberOfAdults() + "人, 小孩" + od.getNumberOfChildren() + "人\n" + 
				"出發日: " + od.getStartDateYear() + "/" + od.getStartDateMonthValue() + "/" + od.getStartDateDay() + "\n" + 
				"抵台日: " + od.getEndDateYear() + "/" + od.getEndDateMonthValue() + "/" + od.getEndDateDay() + "\n" +
				"總價: " + od.getTotalPrice();
	}
}
