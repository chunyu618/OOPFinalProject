package database_utils;

import java.time.LocalDate;


public class OrderData {

	private int orderNumber;
	private int userID;
	private int travelCode;
	private int totalPrice;
	
	private int numberOfAdults;
	private int numberOfChildren;
	private int numberOfBabies;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	// orderNumber
	
	/** Getter of orderNumber.
	 * @return OrderNumber, Integer
	 */
	public int getOrderNumber() {
		return orderNumber;
	}
	
	
	/** Setter of orderNumber.
	 * @param orderNumber, Integer
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	// userID
	
	/** Getter of userID.
	 * @return userID, Integer
	 */
	public int getUserID() {
		return userID;
	}

	/** Setter of userID.
	 * @param userID, Integer
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	// travelCode
	
	/** Getter of travelCode.
	 * @return travelCode, Integer
	 */
	public int getTravelCode() {
		return travelCode;
	}

	/** Setter of travelCode.
	 * @param travelCode, Integer
	 */
	public void setTravelCode(int travelCode) {
		this.travelCode = travelCode;
	}
	
	// totalPrice
	
	/** Getter of totalPrice.
	 * @return totalPrice, Integer
	 */
	public int getTotalPrice() {
		return totalPrice;
	}

	/** Setter of totalPrice.
	 * @param totalPrice, Integer
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	// numberOfPeople
	
	/** Getter of numberOfAdults.
	 * @return numberOfAdults, Integer
	 */
	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	/** Setter of numberOfAdults.
	 * @param numberOfAdults, Integer
	 */
	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	/** Getter of numberOfChildren.
	 * @return numberOfChildren, Integer
	 */
	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	/** Setter of numberOfChildren.
	 * @param numberOfChildren, Integer
	 */
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	/** Getter of getNumberOfBabies.
	 * @return getNumberOfBabies, Integer
	 */
	public int getNumberOfBabies() {
		return numberOfBabies;
	}

	/** Setter of getNumberOfBabies.
	 * @param getNumberOfBabies, Integer
	 */
	public void setNumberOfBabies(int numberOfBabies) {
		this.numberOfBabies = numberOfBabies;
	}
	
	/** Gets total number of people (numberOfAdults + numberOfChildren + numberOfBabies).
	 * @return Total number of people, Integer
	 */
	public int getTotalNumberOfPeople() {
		return numberOfAdults + numberOfChildren + numberOfBabies;
	}
	
	
	// startDate
	
	/** Getter of startDate
	 * @return startDate, java.time.LocalDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	
	/** Gets year of startDate
	 * @return Integer
	 */
	public int getStartDateYear() {
		return startDate.getYear();
	}
	
	/** Gets integer value of month of startDate
	 * @return Integer
	 */
	public int getStartDateMonthValue() {
		return startDate.getMonthValue();
	}
	
	/** Gets day of month of startDate
	 * @return Integer
	 */
	public int getStartDateDay() {
		return startDate.getDayOfMonth();
	}

	/** Setter of startDate.
	 * @param startDate, java.time.LocalDate
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	/** Setter of startDate, another way.
	 * @param year Integer
	 * @param month Integer
	 * @param dayOfMonth Integer
	 */
	public void setStartDate(int year, int month, int dayOfMonth) {
		this.startDate = LocalDate.of(year, month, dayOfMonth);
	}

	// endDate
	
	/** Getter of endDate
	 * @return endDate, java.time.LocalDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/** Gets year of endDate
	 * @return Integer
	 */
	public int getEndDateYear() {
		return endDate.getYear();
	}
	
	/** Gets integer value of month of endDate
	 * @return Integer
	 */
	public int getEndDateMonthValue() {
		return endDate.getMonthValue();
	}
	
	/** Gets day of month of endDate
	 * @return Integer
	 */
	public int getEndDateDay() {
		return endDate.getDayOfMonth();
	}
	
	/** Setter of endDate.
	 * @param endDate, java.time.LocalDate
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	/** Setter of endDate, another way.
	 * @param year Integer
	 * @param month Integer
	 * @param dayOfMonth Integer
	 */
	public void setEndDate(int year, int month, int dayOfMonth) {
		this.endDate = LocalDate.of(year, month, dayOfMonth);
	}
	
}
