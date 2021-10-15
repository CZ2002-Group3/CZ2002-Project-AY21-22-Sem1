import java.util.Scanner;
import java.util.Date;
import java.util.*;

public class ReservationMgr extends TimeMgr{

	public void checkReservation(Restaurant list) {
		Scanner scan = new Scanner(System.in);
		String name;
		System.out.println("Enter your name");
		name = scan.nextLine();
		int size = list.reservation.size();
		for(int i = 0; i < size; i++) {
			if(name == list.reservation.customerName[i]) {
				
			}
		}
		
	}

	public void removeReservation(Reservation reserved) {
		boolean check = checkExpired(reserved);
		if(check == true)
			
			
	}

	public Reservation createReservation() {
		Scanner scan = new Scanner(System.in);
		int numPax, contactNum;
		System.out.println("Enter number of Pax: ");
		numPax = scan.nextInt();
		System.out.println("Enter your contact Number: ");
		contactNum = scan.nextInt();
		Date dateTime = new Date();
		Reservation reserve = new Reservation(dateTime, numPax, contactNum, TABLENUMBER ,contactNum);
		return reserve;
	}

}