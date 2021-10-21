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
		Scanner sc = new Scanner(System.in);
		int tableNo;
		int size = reservation.size();
		System.out.printf("Enter the table number to be removed: ");
		tableNo = sc.nextInt();
		for(int i =0; i< size; i++) {
			if(reservation.get(i).getTable() == tableNo) {
				boolean check = checkExpired(reservation.get(i));
				reservation.remove(i);
			}
			else
				System.out.println("Table not under reservation !! ");
		}
		//if(check == true)
	}

	public void createReservation(List<Reservation> reservation, List<Table> tables) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter number of Pax: ");
    	int numPax = sc.nextInt();
    	System.out.printf("Enter your contact number: ");
    	int contactNum = sc.nextInt();
    	System.out.printf("Enter your name: ");
    	String customerName = sc.next();
		Date dateTime = new Date();
		int custid = 1234;
		TableMgr TableMgr = new TableMgr();
		Table tableNO = TableMgr.assignTable(tables ,custid,numPax);
		reservation.add(new Reservation(dateTime, numPax, contactNum, tableNO.getTableNumber() ,customerName));
	}

}