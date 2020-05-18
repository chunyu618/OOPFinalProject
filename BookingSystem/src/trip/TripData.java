package trip;

import java.util.Date;

public class TripData implements Cloneable{
	private String title;
	private int travelCode;
	private String produckKey;
	private int price;
	private Date startData;
	private Date endDate;
	private int lowerBound;
	private int upperBound;
	
	public TripData(){
		this.title = null;
		this.travelCode = 0;
		this.produckKey = null;
		this.price = 0;
		this.startData = null;
		this.endDate = null;
		this.lowerBound = 0;
		this.upperBound = 0;
	}
	
	public TripData(String title, int travelCode, String produckKey, 
					int price, Date startData, Date endDate, 
					int lowerBound, int upperBound) {
		super();
		this.title = title;
		this.travelCode = travelCode;
		this.produckKey = produckKey;
		this.price = price;
		this.startData = (Date)startData.clone();
		this.endDate = (Date)endDate.clone();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public TripData clone(){
		TripData rev = new TripData();
		rev.title = this.title;
		rev.travelCode = this.travelCode;
		rev.produckKey = this.produckKey;
		rev.price = this.price;
		rev.startData = (Date)this.startData.clone();
		rev.endDate = (Date)this.endDate.clone();
		rev.lowerBound = this.lowerBound;
		rev.upperBound = this.upperBound;
		return rev;
	}
	
}
