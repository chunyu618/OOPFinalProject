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
	public static int newOrder(int userID, TourData td){
		// create a list if it's the first time this user make order.
		if(!orders.containsKey(userID)){
			ArrayList<Integer> list = new ArrayList<Integer>();
			orders.put(userID, list);
		}
		
		// four elements to calculate order number.
		Integer travel_code = map.get("馬達加斯加");
		Integer user = userID;
		String start = td.getStartDate().toString();
		String end = td.getEndDate().toString();
		
		int orderNumber = countOrderNumber(travel_code, start, end, user);
		
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
	public static int countOrderNumber(Integer travel_code, String start, String end, Integer user){
		String[] s = start.split("-");
		String[] e = end.split("-");
		int tmp = 0;
		tmp += Integer.parseInt(travel_code + s[0]) % MOD;
		tmp += Integer.parseInt(s[1] + s[2]) % MOD;
		tmp += Integer.parseInt(e[0] + e[1]) % MOD;
		tmp += Integer.parseInt(e[2] + user) % MOD;
		return tmp;
		
	}
	
}
