package database_utils;

import java.time.LocalDate;


public class OrderData {

	private int orderNumber;
	private int userID;
	private int totalPrice;
	
	private int numberOfAdults;
	private int numberOfChildren;
	private int numberOfBabies;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	// orderNumber
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	// userID
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	// totalPrice
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	// numberOfPeople
	
	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public int getNumberOfBabies() {
		return numberOfBabies;
	}

	public void setNumberOfBabies(int numberOfBabies) {
		this.numberOfBabies = numberOfBabies;
	}
	
	public int getTotalNumberOfPeople() {
		return numberOfAdults + numberOfChildren + numberOfBabies;
	}
	
	
	// startDate
	
	public LocalDate getStartDate() {
		return startDate;
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

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public void setStartDate(int year, int month, int dayOfMonth) {
		this.startDate = LocalDate.of(year, month, dayOfMonth);
	}

	// endDate
	
	public LocalDate getEndDate() {
		return endDate;
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
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public void setEndDate(int year, int month, int dayOfMonth) {
		this.endDate = LocalDate.of(year, month, dayOfMonth);
	}
	
}
