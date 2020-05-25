package database_utils;

import java.time.LocalDate;

public class TourData {
	
	private String title;
	private int price;
	private LocalDate startDate;
	private LocalDate endDate;
	private int upperBound;
	private int lowerBound;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	// start date
	
	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public int getStartDateYear() {
		return startDate.getYear();
	}
	
	public int getStartDateMonthValue() {
		return startDate.getMonthValue();
	}
	
	public int getStartDateDay() {
		return startDate.getDayOfMonth();
	}
	
	
	// end date
	
	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public int getEndDateYear() {
		return endDate.getYear();
	}
	
	public int getEndDateMonthValue() {
		return endDate.getMonthValue();
	}
	
	public int getEndDateDay() {
		return endDate.getDayOfMonth();
	}
	
	
	// #people bounds
	
	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	
	
	
}
