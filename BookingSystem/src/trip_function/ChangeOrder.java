package trip_function;

import java.util.ArrayList;

import database_utils.OrderData;
import database_utils.OrderDataHandler;
import database_utils.TourData;
import database_utils.TourDataHandler;
import failure_exception.InsufficientPeopleException;
import failure_exception.NoOrderException;

/**
 * ChangeOrder class provide method to change or cancel the order by userID and order number
 * It will throw exception when there is no such order, or there is no enough people count in the tour.
 * @author lijunyu
 *
 */
public class ChangeOrder {
	
	/**
	 * cancel method will cancel the order according to the userID and oeder number,
	 * change the record in database,
	 * and throw NoOrderException when there is no such order.
	 * @param userID
	 * @param orderNumber
	 * @throws NoOrderException
	 */
	public static void cancel(int userID, int orderNumber) throws NoOrderException{
		
		// Use methed provided by OrderDataHandler to get the order data from database.
		OrderData tmp = OrderDataHandler.getOrderData(userID, orderNumber);
		
		// If tmp is null, then there is no such order.
		if(tmp == null){	
			throw new NoOrderException();
		}
		
		// Get tour data from database by method provided by TourDataHandler
		ArrayList<TourData> td = TourDataHandler.getResultFromDatabase(tmp.getTravelCode(), tmp.getStartDateYear(),
															tmp.getStartDateMonthValue(), tmp.getStartDateDay());
		
		// Delete order according to userID and order number in database
		OrderDataHandler.deleteOrderData(userID, orderNumber);
		
		// Change the people record in database
		TourDataHandler.changePeopleCount(tmp.getTravelCode(), tmp.getStartDateYear(), 
				tmp.getStartDateMonthValue(), tmp.getStartDateDay(), 
				td.get(0).getPeopleCount() - tmp.getTotalNumberOfPeople());
		
		return;
	}
	
	
	/**
	 * change method will change the order record in database in database, 
	 * it only support change people count.
	 * it will throw NoOrderException if there is no such order.
	 * it will throw InsufficientPeopleException id the people count of the tour is not enough. 
	 * @param userID
	 * @param orderNumber
	 * @param adult
	 * @param child
	 * @throws NoOrderException
	 * @throws InsufficientPeopleException
	 */
	public static void change(int userID, int orderNumber, int adult, int child) throws NoOrderException, InsufficientPeopleException{
		
		// Use methed provided by OrderDataHandler to get the order data from database.
		OrderData tmp = OrderDataHandler.getOrderData(userID, orderNumber);
		
		// If tmp is null, then there is no such order.
		if(tmp == null){	
			throw new NoOrderException();
		}
		
		// Get tour data from database by method provided by TourDataHandler
		ArrayList<TourData> td = TourDataHandler.getResultFromDatabase(tmp.getTravelCode(), tmp.getStartDateYear(),
															tmp.getStartDateMonthValue(), tmp.getStartDateDay());
		
		
		//System.out.printf("%d %d %d %d %d %d\n", td.get(0).getUpperBound(), td.get(0).getPeopleCount(), adult, child, tmp.getNumberOfAdults(), tmp.getNumberOfChildren());
		
		// to calculate if the remaining of people count is enough for the order to change the order.
		if(td.get(0).getUpperBound() - td.get(0).getPeopleCount() >= (adult + child - tmp.getNumberOfAdults() - tmp.getNumberOfChildren())){
			
			// If enough, change the perple count of the tour in database.
			TourDataHandler.changePeopleCount(tmp.getTravelCode(), tmp.getStartDateYear(), 
										tmp.getStartDateMonthValue(), tmp.getStartDateDay(), 
										td.get(0).getPeopleCount() + adult + child - tmp.getNumberOfAdults() - tmp.getNumberOfChildren());
			// Change the people count to desired number.
			tmp.setNumberOfAdults(adult);
			tmp.setNumberOfChildren(child);
			
			// write record to database.
			OrderDataHandler.changeOrderData(tmp);
		}	
		else{
			// If there is not enough, throw the exception.
			throw new InsufficientPeopleException();
		}
		return;
	}
}
