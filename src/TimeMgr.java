import java.util.Date;
import java.util.List;

public class TimeMgr {

	public void checkExpired(List<Reservation> reservations) {
		Date newdate = new Date();
		int size = reservations.size();
		for (int i = 0; i < size; i++) {
			Reservation curr = reservations.get(i);
			int compare = newdate.compareTo(curr.getdateTime());
			if (compare > 0)
			{
				reservations.remove(curr);
				size--;
			}
		}
	}

}