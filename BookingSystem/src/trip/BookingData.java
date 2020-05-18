package trip;

public class BookingData {
	private TripData tripData;
	private int userID;
	private String orderNumber;
	private int numberOfAdult;
	private int numberOfChildren;
	
	public BookingData() {
		super();
		this.tripData = null;
		this.userID = 0;
		this.orderNumber = null;
		this.numberOfAdult = 0;
		this.numberOfChildren = 0;
	}
	
	public BookingData(TripData tripData, int userID, String orderNumber, 
						int numberOfAdult, int numberOfChildren) {
		super();
		this.tripData = tripData.clone();
		this.userID = userID;
		this.orderNumber = orderNumber;
		this.numberOfAdult = numberOfAdult;
		this.numberOfChildren = numberOfChildren;
	}
	
	public BookingData clone(){
		BookingData rev = new BookingData();
		rev.tripData = this.tripData.clone();
		rev.userID = this.userID;
		rev.orderNumber = this.orderNumber;
		rev.numberOfAdult = this.numberOfAdult;
		rev.numberOfChildren = this.numberOfChildren;
		return  rev;
	}
}
