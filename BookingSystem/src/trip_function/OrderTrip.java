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
 * OrderTrip will make order basically on travel_code, date, and userID.
 * @author lijunyu
 *
 */
public class OrderTrip {
	
	
	/**
	 * orderTrip method will make a order according to userID, travel_code and date.
	 * When makeing order, it will check three following things, 
	 * If there is no such tour, it will throw NoTripException
	 * If there is more than one result, it will throw MoreThanOneResultException
	 * If there is no ehough people count remaining in the tour, it will throw InsufficientPeopleException.
	 * 
	 * @param userID
	 * @param travel_code
	 * @param adult
	 * @param child
	 * @param year1
	 * @param month1
	 * @param date1
	 * @param year2
	 * @param month2
	 * @param date2
	 * @return Order information
	 * @throws InsufficientPeopleException
	 * @throws MoreThanOneResultException
	 * @throws NoTripException
	 */
	public static String orderTrip(int userID, int travel_code, int adult, int child,
								int year1, int month1, int date1, int year2, int month2, int date2)
								throws InsufficientPeopleException, MoreThanOneResultException, NoTripException{
		// Get the tour from database
		ArrayList<TourData> a = TourDataHandler.getResultFromDatabaseWithInterval(travel_code, year1, month1, date1, year1, month1, date1);
		if(a == null || (year2 != a.get(0).getEndDateYear() || month2 != a.get(0).getEndDateMonthValue() || date2 != a.get(0).getEndDateDay())){
			// If a is null, then there is no such tour.
			throw new NoTripException();
		}
		if(a.size() != 1){
			// If the size of a is larger then 1, then there is more than one result.
			throw new MoreThanOneResultException();
		}
		if(a.get(0).getUpperBound() - a.get(0).getPeopleCount() < adult + child){
			// If the people count remaining in the tour is smaller than desired number.
			throw new InsufficientPeopleException();
		} 
		
		// A new order
		OrderData od = new OrderData();
		int price = a.get(0).getPrice();
		int orderNumber = OrderNumberManager.newOrder(userID, travel_code, year1, month1, date1, year2, month2, date2);
		// Fill the order according the information provided by user.
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
			// Successfully order, and change the people count in database.
			TourDataHandler.changePeopleCount(travel_code, year1, month1, date1, a.get(0).getPeopleCount() + adult + child);
			// return the order information
			return "訂單編號: " + orderNumber + ", 使用者: " + userID + "\n" +
					"出發日期: " + year1 + "/" + month1 + "/" + date1 + "\n" + 
					"抵台日期: " + year2 + "/" + month2 + "/" + date2 + "\n" + 
					"總價: " + od.getTotalPrice() + "NT\n" + 
					"入住人數: " + "大人" + od.getNumberOfAdults() + "人, 小孩" + od.getNumberOfChildren() + "人\n";
		}
		else{
			// return null if fail the order.
			return null;
		}
	}
}
