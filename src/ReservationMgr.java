import java.text.*;
import java.util.*;

public class ReservationMgr extends TimeMgr {

	public void checkReservation(List<Reservation> reservation) {
		Scanner scan = new Scanner(System.in);
		String name;
		int size = reservation.size();
		int tableNo, choice;

		System.out.println("(1)Check Single reservation");
		System.out.println("(2)Check All reservation");
		System.out.printf("Enter your Choices: ");
		choice = scan.nextInt();
		if (choice == 1) {
			System.out.printf("Enter your Table Number: ");
			tableNo = scan.nextInt();
			System.out.printf("Enter your Name: ");
			name = scan.next();
			for (int i = 0; i < size; i++) {
				if (reservation.get(i).getcustomerName().equals(name) && reservation.get(i).getTable() == tableNo) {
					reservation.get(i).printReservation();
					return;
				}
			}
			System.out.println("NOT FOUND!!");

		} else if (choice == 2) {
			for (int i = 0; i < size; i++)
				reservation.get(i).printReservation();
		} else
			return;

	}

	public void removeReservation(List<Reservation> reservation) {
		Scanner sc = new Scanner(System.in);
		int tableNo;
		int size = reservation.size();
		System.out.printf("Enter the table number to be removed: ");
		tableNo = sc.nextInt();
		for (int i = 0; i < size; i++) {
			if (reservation.get(i).getTable() == tableNo) {
				boolean check = checkExpired(reservation.get(i));
				reservation.remove(i);
			} else
				System.out.println("Table not under reservation !! ");
		}
		// if(check == true)
	}

	public void createReservation(List<Reservation> reservation, List<Table> tables, List<Customer> customers)
			throws ParseException {
		Scanner sc = new Scanner(System.in);
		TableMgr tableMgr = new TableMgr();
		CustomerMgr customerMgr = new CustomerMgr();

		System.out.printf("Enter number of Pax: ");
		int numPax = sc.nextInt();

		Table table = tableMgr.reverseTable(tables, numPax);

		if (table != null) {
			System.out.println("Enter Customer Contact Number: ");
			int contactNo = sc.nextInt();
			Customer cust = customerMgr.findCustomer(customers, contactNo);
			if (cust == null) {
				System.out.println("Enter Customer Name: ");
				String custName = sc.next();
				System.out.println("Membership?: ");
				boolean member = sc.nextBoolean();
				long custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
				cust = new Customer(custID, custName, member, contactNo);
			}
			table.setCustomerID(cust.getCustomerID());

			System.out.println("Enter Reservation date and time (Format: dd/MM/yyyy HH:mm): ");
			String dateString = sc.next();
			Date dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateString);
			reservation
					.add(new Reservation(dateTime, numPax, contactNo, table.getTableNumber(), cust.getCustomerName()));
		}

	}

}