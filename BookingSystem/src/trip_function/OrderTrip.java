package trip_function;

import database_utils.TourData;

import java.util.ArrayList;

import database_utils.OrderData;
import database_utils.OrderDataHandler;
import database_utils.TourDataHandler;
import failure_exception.InsufficientPeopleException;
import failure_exception.MoreThanOneResultException;
import failure_exception.NoTripException;

/**
 * OrderTrip will make order basically on tour and userID.
 * @author lijunyu
 *
 */
public class OrderTrip {
	
	
	public static String orderTrip(int userID, int travel_code, int adult, int child,
								int year1, int month1, int date1, int year2, int month2, int date2)
								throws InsufficientPeopleException, MoreThanOneResultException, NoTripException{
		// Ask databse
		ArrayList<TourData> a = TourDataHandler.getResultFromDatabaseWithInterval(travel_code, year1, month1, date1, year1, month1, date1);
		if(a == null || (year2 != a.get(0).getEndDateYear() || month2 != a.get(0).getEndDateMonthValue() || date2 != a.get(0).getEndDateDay())){
			throw new NoTripException();
		}
		if(a.size() != 1){
			throw new MoreThanOneResultException();
		}
		if(a.get(0).getUpperBound() - a.get(0).getPeopleCount() < adult + child){
			throw new InsufficientPeopleException();
		} 
		OrderData od = new OrderData();
		int price = a.get(0).getPrice();
		int orderNumber = OrderNumberManager.newOrder(userID, travel_code, year1, month1, date1, year2, month2, date2);
		od.setOrderNumber(orderNumber);
		od.setUserID(userID);
		od.setNumberOfAdults(adult);
		od.setNumberOfBabies(0);
		od.setNumberOfChildren(child);
		od.setTotalPrice(price * (adult + child));
		od.setStartDate(year1, month1, date1);
		od.setEndDate(year2, month2, date2);
		od.setTravelCode(travel_code);
		if(OrderDataHandler.addOrderData(od) == true){
			TourDataHandler.changePeopleCount(travel_code, year1, month1, date1, a.get(0).getPeopleCount() + adult + child);
			return "訂單編號: " + orderNumber + ", 使用者: " + userID + "\n" +
					"出發日期: " + year1 + "/" + month1 + "/" + date1 + "\n" + 
					"抵台日期: " + year2 + "/" + month2 + "/" + date2 + "\n" + 
					"總價: " + od.getTotalPrice() + "NT\n" + 
					"入住人數: " + "大人" + od.getNumberOfAdults() + "人, 小孩" + od.getNumberOfChildren() + "人\n";
		}
		else{
			return null;
		}
	}
}
