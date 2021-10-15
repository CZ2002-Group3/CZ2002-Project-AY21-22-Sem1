import java.util.*;

public class ReservationMgr extends TimeMgr{

	public void checkReservation(List<Reservation> reservation) {
		Scanner scan = new Scanner(System.in);
		String name;
		int size = reservation.size();
		int tableNo, choice;
		
		System.out.println("(1)Check Single reservation");
		System.out.println("(2)Check All reservation");
		System.out.printf("Enter your Choices: ");
		choice = scan.nextInt();
		if(choice == 1) {
			System.out.printf("Enter your Table Number: ");
			tableNo = scan.nextInt();
			System.out.printf("Enter your Name: ");
			name = scan.next();
			for(int i =0; i< size; i++) {
				System.out.println("========="+reservation.get(i).getTable());
				//System.out.println("========="+reservation.get(i).getcustomerName());
				if(reservation.get(i).getcustomerName().equals(name) && reservation.get(i).getTable() == tableNo) {
					reservation.get(i).printReservation();
					return;
				}
			}
			System.out.println("NOT FOUND!!");
			
		}else if(choice == 2) {
			for(int i =0; i< size; i++)
				reservation.get(i).printReservation();
		}else
			return;
		
	}

	public void removeReservation(List<Reservation> reservation) {
		boolean check = checkExpired(reserved);
		if(check == true)
			
			
	}

	public void createReservation(List<Reservation> reservation) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter number of Pax: ");
    	int numPax = sc.nextInt();
    	System.out.printf("Enter your contact number: ");
    	int contactNum = sc.nextInt();
    	System.out.printf("Enter your name: ");
    	String customerName = sc.next();
		Date dateTime = new Date();
		int TABLENUMBER = 6;
		reservation.add(new Reservation(dateTime, numPax, contactNum, TABLENUMBER ,customerName));
	}

}