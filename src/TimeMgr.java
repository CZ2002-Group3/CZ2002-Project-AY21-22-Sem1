import java.util.Date;
import java.util.List;

public  class TimeMgr {

	public boolean checkExpired(Reservation date) {
		Date newdate = new Date();
		Date olddate = date.getdateTime();
		//newdate.getTime();
		//olddate.getTime();
		long diff = newdate.getTime() - olddate.getTime();
		
		System.out.print(diff);
		
		int compare = newdate.compareTo(date.getdateTime());
		if(compare < 0)
			return false;
		else
			return true;
	}
	
}