package database_utils;

import java.time.LocalDate;

public class CountingData {
	
	private String title;
	private int price;
	private int travelCode;
	
	private LocalDate startDate;
	private LocalDate endDate;

	private int peopleCount;
	
	
	public CountingData(String title, int price, int travelCode, LocalDate startDate,
			LocalDate endDate, int peopleCount) {
		
		this.title = title;
		this.price = price;
		this.travelCode = travelCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.peopleCount = peopleCount;
		
	}
	

	public CountingData() {
		this.title = " ";
		this.startDate = LocalDate.of(1, 1, 1);
		this.endDate = LocalDate.of(1, 1, 1);;
	}


	/** Getter of title.
	 * @return title, String
	 */
	public String getTitle() {
		return title;
	}

	/** Setter of title.
	 * @param title, String
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
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
	
	/** Getter of price.
	 * @return price, Integer
	 */
	public int getPrice() {
		return price;
	}

	/** Setter of price.
	 * @param price, Integer
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	// start date
	
	/** Getter of startDate
	 * @return startDate, java.time.LocalDate
	 */
	public LocalDate getStartDate() {
		return startDate;
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
	
	// end date
	
	/** Getter of endDate
	 * @return endDate, java.time.LocalDate
	 */
	public LocalDate getEndDate() {
		return endDate;
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
	
	
	// #people
	
	/** Getter of upperBound.
	 * @return upperBound, Integer
	 */
	public int getPeopleCount() {
		return peopleCount;
	}

	/** Setter of upperBound.
	 * @param upperBound, Integer
	 */
	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}

}
