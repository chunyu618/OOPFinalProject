package database;

import java.util.ArrayList;

import trip.BookingData;
import trip.TripData;

public interface DataBaseHandlerInterface {
	public ArrayList<TripData> readFromTripDatabese();
	public ArrayList<BookingData> readFromBookingDatabese();
	public void writeToBookingDataBase(ArrayList<BookingData> bookingData);
}
