package trip_function;

import database_utils.OrderData;
import database_utils.OrderDataHandler;
import failure_exception.NoOrderException;

public class SearchOrder {
	public static String search(int userID, int orderNumber) throws NoOrderException{
		OrderData od = OrderDataHandler.getOrderData(userID, orderNumber);
		if(od == null){
			throw new NoOrderException();
		}
		return "行程編號: " + od.getTravelCode() + "\n" + 
				"人數: " + "大人" + od.getNumberOfAdults() + "人, 小孩" + od.getNumberOfChildren() + "人\n" + 
				"出發日: " + od.getStartDateYear() + "/" + od.getStartDateMonthValue() + "/" + od.getStartDateDay() + "\n" + 
				"抵台日: " + od.getEndDateYear() + "/" + od.getEndDateMonthValue() + "/" + od.getEndDateDay() + "\n" +
				"總價: " + od.getTotalPrice();
	}
}
