package trip_function;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Policy is used to search some trips.
 * Someone can search trips by title, priceUpperBound,
 * priceLowerBound, startDate interval.
 * @author lijunyu
 *
 */
public class Policy implements Cloneable{
	private String destination;
	private Calendar[] startDate;
	
	/**
	 * Default constructor, it is not recommend to use.
	 */
	public Policy() {
		this.destination = null;
		this.startDate = null;
	}
	
	/**
	 * Constructor that can make a complete policy.
	 */
	public Policy(String title, Calendar startDate1, Calendar startDate2) {
		this.destination = title;
		this.startDate = new Calendar[2];
		this.startDate[0] = (Calendar)startDate1.clone();
		this.startDate[1] = (Calendar)startDate2.clone();
	}
	
	
	/**
	 * Deep clone of policy.
	 */
	public Policy clone(){
		Policy rev = new Policy();
		rev.destination = destination;
		rev.startDate = (Calendar[])this.startDate.clone();
		return rev;
	}
	
	/**
	 * @return title.
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * set title of policy.
	 * @param title
	 */
	public void setDestination(String title) {
		this.destination = title;
	}
	
	/**
	 * @return start date interval
	 */
	public Calendar[] getStartDate() {
		return (Calendar[])startDate.clone();
	}

	
	/**
	 * set start date interval
	 * @param startDate
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = (Calendar[])startDate.clone();
	}
	
}
