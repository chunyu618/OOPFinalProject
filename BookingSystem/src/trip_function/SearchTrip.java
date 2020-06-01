package trip_function;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import failure_exception.NoTripException;
import trip.TripInfo;
import trip.BookingInfo;
import database_utils.*;

/**
 * SearchTrip will search trip by policy.
 * @author lijunyu
 *
 */
public class SearchTrip {
	// mapping from destination to travel code.
	public static Map<String, Integer> map = GetTrvaelingCode.map; 
	
	
	/**
	 * searching by policy
	 * @param policy
	 * @return A list of suitable trips
	 * @throws NoTripException
	 */
	public static ArrayList<Object[]> searchByPolicy(Policy policy) throws NoTripException{
		// convert destination to travel code.
		int travel_code = map.get(policy.getDestination());
		//System.out.println("year : " + policy.getStartDate().get(Calendar.YEAR) + "month : " + policy.getStartDate().get(Calendar.MONTH) + "day : " + policy.getStartDate().get(Calendar.DAY_OF_MONTH));
		
		
		// set start date interval
		int year1, year2 = 0;
		int month1, month2 = 0;
		int date1, date2 = 0;
		year1 = policy.getStartDate()[0].get(Calendar.YEAR);
		month1 = policy.getStartDate()[0].get(Calendar.MONTH);
		date1 = policy.getStartDate()[0].get(Calendar.DAY_OF_MONTH);
		if(policy.getStartDate()[1] == null){
			year1 = year2;
			month1 = month2;
			date1 = date2;
		}
		else{
			year2 = policy.getStartDate()[1].get(Calendar.YEAR);
			month2 = policy.getStartDate()[1].get(Calendar.MONTH);
			date2 = policy.getStartDate()[1].get(Calendar.DAY_OF_MONTH);
		}
		
		// Ask databse
		ArrayList<TourData> a = TourDataHandler.getResultFromDatabaseWithInterval(travel_code, year1, month1, date1, year2, month2, date2);
		
		// If a is null, then there is no such trip.
		if(a == null){
			throw new NoTripException();
		}
		
		ArrayList<Object[]> rev = new ArrayList<Object[]>();
		for(TourData td : a){
			String[] tmp = new String[7];
			tmp[0] = td.getTitle();
			tmp[1] = td.getPrice() + "";
			tmp[2] = td.getLowerBound() + "";
			tmp[3] = td.getUpperBound() + "";
			tmp[4] = td.getStartDateYear() + "-" + td.getStartDateMonthValue() + "-" + td.getStartDateDay();
			tmp[5] = td.getEndDateYear() + "-" + td.getEndDateMonthValue() + "-" + td.getEndDateDay();
			tmp[6] = td.getTravelCode() + "";
			rev.add(tmp);
		}
		return rev;
	}
	

	
}
