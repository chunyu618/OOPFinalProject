package trip_function;

import java.util.ArrayList;

import database_utils.OrderData;
import database_utils.OrderDataHandler;
import database_utils.TourData;
import database_utils.TourDataHandler;
import failure_exception.InsufficientPeopleException;
import failure_exception.NoOrderException;

public class ChangeOrder {
	public static void cancel(int userID, int orderNumber) throws NoOrderException{
		OrderData tmp = OrderDataHandler.getOrderData(userID, orderNumber);
		if(tmp == null){	
			throw new NoOrderException();
		}
		ArrayList<TourData> td = TourDataHandler.getResultFromDatabase(tmp.getTravelCode(), tmp.getStartDateYear(),
															tmp.getStartDateMonthValue(), tmp.getStartDateDay());
		OrderDataHandler.deleteOrderData(userID, orderNumber);
		TourDataHandler.changePeopleCount(tmp.getTravelCode(), tmp.getStartDateYear(), 
				tmp.getStartDateMonthValue(), tmp.getStartDateDay(), 
				td.get(0).getPeopleCount() - tmp.getTotalNumberOfPeople());
	}
	public static void change(int userID, int orderNumber, int adult, int child) throws NoOrderException, InsufficientPeopleException{
		OrderData tmp = OrderDataHandler.getOrderData(userID, orderNumber);
		if(tmp == null){	
			throw new NoOrderException();
		}
		ArrayList<TourData> td = TourDataHandler.getResultFromDatabase(tmp.getTravelCode(), tmp.getStartDateYear(),
															tmp.getStartDateMonthValue(), tmp.getStartDateDay());
		System.out.printf("%d %d %d %d %d %d\n", td.get(0).getUpperBound(), td.get(0).getPeopleCount(), adult, child, tmp.getNumberOfAdults(), tmp.getNumberOfChildren());
		if(td.get(0).getUpperBound() - td.get(0).getPeopleCount() >= (adult + child - tmp.getNumberOfAdults() - tmp.getNumberOfChildren())){
			tmp.setNumberOfAdults(adult);
			tmp.setNumberOfChildren(child);
			OrderDataHandler.changeOrderData(tmp);
			TourDataHandler.changePeopleCount(tmp.getTravelCode(), tmp.getStartDateYear(), 
										tmp.getStartDateMonthValue(), tmp.getStartDateDay(), 
										td.get(0).getPeopleCount() + adult + child - tmp.getNumberOfAdults() - tmp.getNumberOfChildren());
		}	
		else{
			throw new InsufficientPeopleException();
		}
	}
}
