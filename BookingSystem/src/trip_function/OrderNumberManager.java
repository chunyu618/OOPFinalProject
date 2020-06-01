package trip_function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database_utils.TourData;

/**
 * OrderNumberManager will calculate a order number by userId and tour
 * it alse maintain every user ID and their oeder.
 * @author lijunyu
 *
 */
public class OrderNumberManager {
	public static Map<Integer, ArrayList<Integer>> orders = new HashMap<Integer, ArrayList<Integer>>();
	private static Map<String, Integer> map = GetTrvaelingCode.map; 
	private static final int MOD = 999983;
	
	/**
	 * newOrder will add a new order to record and return a calculated order number.
	 * @param userID
	 * @param td
	 * @return Order Number
	 */
	public static int newOrder(int userID, int travel_code, 
								int year1, int month1, int date1, 
								int year2, int month2, int date2){
		// create a list if it's the first time this user make order.
		if(!orders.containsKey(userID)){
			ArrayList<Integer> list = new ArrayList<Integer>();
			orders.put(userID, list);
		}
		
		// four elements to calculate order number.
		Integer user = userID;
		
		int orderNumber = countOrderNumber(travel_code, year1, month1, date1, year2, month2, date2, user);
		
		// add this record.
		orders.get(userID).add(orderNumber);
		return orderNumber;
	}
	
	/**
	 * countOrderNumber will calculate order number by travel_code, 
	 * start date, end date and userID.
	 * @param travel_code
	 * @param start
	 * @param end
	 * @param user
	 * @return Order Number
	 */
	public static int countOrderNumber(Integer travel_code, int year1, int month1, int date1, 
										int year2, int month2, int date2, Integer user){
		int tmp = 0;
		tmp += (travel_code + year1) % MOD;
		tmp += (month1 + date1) % MOD;
		tmp += (year2 + month2) % MOD;
		tmp += (date2 + user) % MOD;
		return tmp;
		
	}
	
}
