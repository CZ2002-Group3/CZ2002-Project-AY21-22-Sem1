package restaurantReservation;

import java.util.Date;
import java.util.List;

/**
 Represents Time management in the restaurant.
 @author SS7_Grp3
 @version 1.0
 @since 2021-10-27
*/
public class TimeMgr {

	
	/** 
	 * Function used to remove expire reservation
	 * Iterates through the list of reservation, and check for any reservation that has expired and remove it.
	 * Reservation is expired after 10 minutes of the reserved time.
	 * @param reservation This is the list of reservation.
	 */
	public void checkExpired(List<Reservation> reservations) {
		Date currDate = new Date();
		int size = reservations.size();
		for (int i = 0; i < size; i++) {
			Reservation reservationDate = reservations.get(i);
			
			long diff = currDate.getTime() - reservationDate.getdateTime().getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.println(diffSeconds + " seconds.");

			if ((diffDays == 0 && diffHours > 0) || (diffDays == 0 && diffMinutes >= 10))
			{
				System.out.println("Time limit have reached, reserved table: "+ reservationDate.getTableNumber()+" have been removed");
				Table table = reservationDate.getTable();
				table.setStatus(0);
				reservations.remove(reservationDate);
				size--;
			}
		}
	}

}