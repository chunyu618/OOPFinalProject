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
	private String title;
	private int priceUpperBound;
	private int priceLowerBound;
	private Calendar[] startDate;
	
	private int numberOfPeople;
	
	/**
	 * Default constructor, it is not recommend to use.
	 */
	public Policy() {
		this.title = null;
		this.priceUpperBound = 0;
		this.priceLowerBound = 0;
		this.startDate = null;
		this.numberOfPeople = 0;
	}
	
	/**
	 * Constructor that can make a complete policy.
	 */
	public Policy(String title, int priceUpperBound, int priceLowerBound, 
					Calendar startDate1, Calendar startDate2, int numberOfPeople) {
		this.title = title;
		this.priceUpperBound = priceUpperBound;
		this.priceLowerBound = priceLowerBound;
		this.startDate = new Calendar[2];
		this.startDate[0] = (Calendar)startDate1.clone();
		this.startDate[1] = (Calendar)startDate2.clone();
		this.numberOfPeople = numberOfPeople;
	}
	
	
	/**
	 * Deep clone of policy.
	 */
	public Policy clone(){
		Policy rev = new Policy();
		rev.title = title;
		rev.priceUpperBound = this.priceUpperBound;
		rev.priceLowerBound = this.priceLowerBound;
		rev.startDate = (Calendar[])this.startDate.clone();
		rev.numberOfPeople = this.numberOfPeople;
		return rev;
	}
	
	/**
	 * @return title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * set title of policy.
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return upper bound of price
	 */
	public int getPriceUpperBound() {
		return priceUpperBound;
	}

	/**
	 * set upper bound of price
	 * @param upper bound of price
	 */
	public void setPriceUpperBound(int priceUpperBound) {
		this.priceUpperBound = priceUpperBound;
	}

	/**
	 * @return lower bound of price
	 */
	public int getPriceLowerBound() {
		return priceLowerBound;
	}
	
	
	/**
	 * set upper bound of price
	 * @param lower bound of price
	 */
	public void setPriceLowerBound(int priceLowerBound) {
		this.priceLowerBound = priceLowerBound;
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

	/**
	 * @return number of people
	 */
	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	/**
	 * set number of people
	 * @param numberOfPeople
	 */
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	
}
