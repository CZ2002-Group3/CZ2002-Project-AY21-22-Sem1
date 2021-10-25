import java.util.Date;
import java.util.List;

public class TimeMgr {

	
	/** 
	 * @param reservations
	 */
	public void checkExpired(List<Reservation> reservations) {
		Date newdate = new Date();
		int size = reservations.size();
		for (int i = 0; i < size; i++) {
			Reservation curr = reservations.get(i);
			//long time1 = curr.getdateTime().getTime();
			//long time2 = newdate.getTime();
			//long compare = time2-time1;
			
			long diff = newdate.getTime() - curr.getdateTime().getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.println(diffSeconds + " seconds.");
			
			//System.out.println("+++++++++++++++++++++++++++++++");
			if (diffDays == 0 && diffMinutes >= 10)
			{
				System.out.println("Time limit have reached, reserved table: "+ curr.getTableNumber()+" have been removed");
				reservations.remove(curr);
				size--;
			}
		}
	}

}