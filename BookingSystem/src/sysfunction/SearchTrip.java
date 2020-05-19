package sysfunction;

import java.util.ArrayList;
import trip.Policy;
import trip.TripInfo;
import trip.BookingInfo;
import database.DataBaseHandlerInterface;

public class SearchTrip {
	
	public static ArrayList<TripInfo> searchByPolicy(DataBaseHandlerInterface database, Policy policy){
		ArrayList<TripInfo> rev = database.readFromTripDatabese(policy);
		return rev;
	}

}
