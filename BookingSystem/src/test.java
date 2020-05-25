import sysfunction.SearchTrip;
import trip.Policy;

import java.util.Date;
import java.util.GregorianCalendar;
import sysfunction.GetTrvaelingCode;

public class test {

	public static void main(String[] args) {
		Policy policy =  new Policy("馬達加斯加", 0, 0, new GregorianCalendar(2020, 3, 7), new GregorianCalendar(2020, 3, 26), 5);
		SearchTrip.searchByPolicy(policy);
		
	}

}
