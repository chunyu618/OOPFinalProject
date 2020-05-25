package sysfunction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database_utils.TourData;
import trip.Policy;
import trip.TripInfo;
import trip.BookingInfo;

import database_utils.*;

public class SearchTrip {
	public static Map<String, Integer> map = GetTrvaelingCode.convert(); 
	
	public static void searchByPolicy(Policy policy){
		try{
			int travel_code = map.get(policy.getTitle());
			//System.out.println("year : " + policy.getStartDate().get(Calendar.YEAR) + "month : " + policy.getStartDate().get(Calendar.MONTH) + "day : " + policy.getStartDate().get(Calendar.DAY_OF_MONTH));
			ArrayList<TourData> a = TourDataHandler.getResultFromDatabase(travel_code, policy.getStartDate().get(Calendar.YEAR), policy.getStartDate().get(Calendar.MONTH), policy.getStartDate().get(Calendar.DAY_OF_MONTH));
			for (TourData td : a) {
				System.out.println(td.getTitle());
				System.out.println(td.getStartDateYear() +" " + td.getStartDateMonthValue() + " " + td.getStartDateDay());
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

	
}
