package trip;

import java.util.Calendar;

public class Policy implements Cloneable{
	private String title;
	private int priceUpperBound;
	private int priceLowerBound;
	private Calendar startDate;
	private Calendar endDate;
	private int numberOfPeople;
	
	public Policy() {
		this.title = null;
		this.priceUpperBound = 0;
		this.priceLowerBound = 0;
		this.startDate = null;
		this.endDate = null;
		this.numberOfPeople = 0;
	}
	
	public Policy(String title, int priceUpperBound, int priceLowerBound, 
					Calendar startDate, Calendar endDate, int numberOfPeople) {
		this.title = title;
		this.priceUpperBound = priceUpperBound;
		this.priceLowerBound = priceLowerBound;
		this.startDate = (Calendar)startDate.clone();
		this.endDate = (Calendar)endDate.clone();
		this.numberOfPeople = numberOfPeople;
	}
	
	public Policy clone(){
		Policy rev = new Policy();
		rev.title = title;
		rev.priceUpperBound = this.priceUpperBound;
		rev.priceLowerBound = this.priceLowerBound;
		rev.startDate = (Calendar)this.startDate.clone();
		rev.endDate = (Calendar)this.endDate.clone();
		rev.numberOfPeople = this.numberOfPeople;
		return rev;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPriceUpperBound() {
		return priceUpperBound;
	}

	public void setPriceUpperBound(int priceUpperBound) {
		this.priceUpperBound = priceUpperBound;
	}

	public int getPriceLowerBound() {
		return priceLowerBound;
	}

	public void setPriceLowerBound(int priceLowerBound) {
		this.priceLowerBound = priceLowerBound;
	}

	public Calendar getStartDate() {
		return (Calendar)startDate.clone();
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return (Calendar)endDate.clone();
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	
}
