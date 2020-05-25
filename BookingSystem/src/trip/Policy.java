package trip;

import java.util.Date;
import java.util.ArrayList; 

public class Policy implements Cloneable{
	private String title;
	private int priceUpperBound;
	private int priceLowerBound;
	private Date startDate;
	private Date endDate;
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
					Date startDate, Date endDate,int numberOfPeople) {
		this.title = title;
		this.priceUpperBound = priceUpperBound;
		this.priceLowerBound = priceLowerBound;
		this.startDate = (Date)startDate.clone();
		this.endDate = (Date)endDate.clone();
		this.numberOfPeople = numberOfPeople;
	}
	
	public Policy clone(){
		Policy rev = new Policy();
		rev.title = title;
		rev.priceUpperBound = this.priceUpperBound;
		rev.priceLowerBound = this.priceLowerBound;
		rev.startDate = (Date)this.startDate.clone();
		rev.endDate = (Date)this.endDate.clone();
		rev.numberOfPeople = this.numberOfPeople;
		return rev;
	}
	
}
