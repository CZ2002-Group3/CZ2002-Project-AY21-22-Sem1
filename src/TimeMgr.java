import java.util.Date;

public  class TimeMgr {

	public boolean checkExpired(Reservation date) {
		Date newdate = new Date();
		Date olddate = date.getdateTime();
		newdate.getTime();
		olddate.getTime();
		int compare = newdate.compareTo(date.getdateTime());
		if(compare < 0)
			return false;
		else
			return true;
	}
	
}