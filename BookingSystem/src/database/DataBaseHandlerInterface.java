package database;

import java.util.ArrayList;
import trip.BookingInfo;
import trip.TripInfo;
import trip.Policy;

public interface DataBaseHandlerInterface {
	public ArrayList<TripInfo> readFromTripDatabese(Policy policy);
	public ArrayList<BookingInfo> readFromBookingDatabese();
	public void writeToBookingDataBase(ArrayList<BookingInfo> bookingData);
}
