
import java.util.Date;

public  class TimeMgr {

	public boolean checkExpired(Reservation date) {
		Date newdate = new Date();
		int compare = newdate.compareTo(date.getdateTime());
		if(compare < 0)
			return false;
		else
			return true;
	}
	
}