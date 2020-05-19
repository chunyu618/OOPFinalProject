package trip;

import database.DataBaseHandlerInterface;

public class BookingInfo {
	private TripInfo tripData;
	private int userID;
	private String orderNumber;
	private int numberOfAdult;
	private int numberOfChildren;
	
	public BookingInfo() {
		super();
		this.tripData = null;
		this.userID = 0;
		this.orderNumber = null;
		this.numberOfAdult = 0;
		this.numberOfChildren = 0;
	}
	
	public BookingInfo(TripInfo tripData, int userID, String orderNumber, 
						int numberOfAdult, int numberOfChildren) {
		super();
		this.tripData = tripData.clone();
		this.userID = userID;
		this.orderNumber = orderNumber;
		this.numberOfAdult = numberOfAdult;
		this.numberOfChildren = numberOfChildren;
	}
	
	public BookingInfo clone(){
		BookingInfo rev = new BookingInfo();
		rev.tripData = this.tripData.clone();
		rev.userID = this.userID;
		rev.orderNumber = this.orderNumber;
		rev.numberOfAdult = this.numberOfAdult;
		rev.numberOfChildren = this.numberOfChildren;
		return  rev;
	}
	
	
	
	
}
