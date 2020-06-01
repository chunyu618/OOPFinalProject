package test;

import trip_function.GetTrvaelingCode;
import trip_function.OrderNumberManager;
import trip_function.Policy;
import trip_function.SearchTrip;
import trip_function.OrderTrip;

import database_utils.TourData;
import database_utils.OrderData;
import database_utils.OrderDataHandler;
import database_utils.TourDataHandler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;


public class Test {

	public static void main(String[] args) {
		OrderDataHandler.createOrderDataTable();
		Map<String, Integer> map = GetTrvaelingCode.map;
		
		
		// Search Trip
		String dest = "馬達加斯加";
		Calendar day1 = new GregorianCalendar(2020, 3, 12);
		Calendar day2 = new GregorianCalendar(2020, 10, 12);
		Policy policy =  new Policy(dest, day1, day2);
		try{
			ArrayList<Object[]> a = SearchTrip.searchByPolicy(policy);
			
			/*
			TourData td = new TourData();
			td.setTitle((String)a.get(0)[0]);
			td.setPrice(Integer.parseInt((String)a.get(0)[1]));
			td.setLowerBound(Integer.parseInt((String)a.get(0)[2]));
			td.setUpperBound(Integer.parseInt((String)a.get(0)[3]));
			td.setStartDateYear() + "-" + td.getStartDateMonthValue() + "-" + td.getStartDate();
			tmp[5] = td.getEndDateYear() + "-" + td.getEndDateMonthValue() + "-" + td.getEndDate();
			System.out.println(t.getEndDate());
			OrderData od = new OrderData();
			System.out.println(OrderTrip.orderTrip(t, 987));
			System.out.println("Order added");
			// Test
			Iterator<TourData> iterator = a.iterator();
			while(iterator.hasNext()){
				TourData tour = iterator.next();
				//System.out.println("Title " + tour.getTitle() + " Price " + tour.getPrice() + " Start date " + tour.getStartDate() + " End Date " + tour.getEndDate());
				//System.out.println("OrderNumber " + OrderNumberManager.countOrderNumber(map.get(dest), tour.getStartDate().toString(), tour.getEndDate().toString(), 123));
			}
			*/
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		

		
		
	}

}
