package restaurantReservation;

import java.text.*;
import java.util.*;

/**
 Represents the manager of Reservation class.
 @author SS7_Grp3
 @version 1.0
 @since 2021-10-27
*/
public class ReservationMgr {
	
	/**
	 * Create a Reservation manager.
	*/
	public ReservationMgr() {
	}

	
	/**
	 * Function used when needed to check the reservation list.
	 * Iterates through the list of reservation, and prints them out.
	 * @param reservation This is the list of reservation.
	 */
	public void checkReservation(List<Reservation> reservation) {
		Scanner sc = new Scanner(System.in);
		int size = reservation.size();
		int tableNo, choice;

		if (size == 0) {
			System.out.printf("ERROR: There are no reservations at the moment");
			return;
		}

		System.out.println("(1) Check Single reservation");
		System.out.println("(2) Check All reservation");
		System.out.println("(-1) Exit Check reservation");
		System.out.printf("Enter your Choices: ");

		do {

			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!");
				sc.next(); // this is important!
			}

			choice = sc.nextInt();
			if (choice == 1 || choice == 2 || choice == -1) {
				break;
			}
			System.out
					.println("Input entered is either not an integer, or is not in the valid range. Please try again!");

		} while (choice <= 0 || choice > 2);
		sc.nextLine();

		if (choice == 1) {
			System.out.printf("Enter your Table Number: ");

			do {

				while (!sc.hasNextInt()) {
					System.out.println("That's not a number!");
					sc.next(); // this is important!
				}

				tableNo = sc.nextInt();
				break;

			} while (true);
			sc.nextLine();

			for (int i = 0; i < size; i++) {
				if (reservation.get(i).getTableNumber() == tableNo) {
					reservation.get(i).printReservation();
					return;
				}
			}
			System.out.println("RESERVATION NOT FOUND!!");

		} else if (choice == 2) {
			for (int i = 0; i < size; i++)
				reservation.get(i).printReservation();
		} else
			return;

	}

	
	/** 
	 * Function used to check if the customer comes under reservation.
	 * @param reservation This is the list of reservation.
	 * @param contactNumber customer contact number
	 * @return Reservation - customer under the reservation.
	 */
	public Reservation checkReservation(List<Reservation> reservation, long contactNumber) {
		Scanner sc = new Scanner(System.in);
		int size = reservation.size();

		for (int i = 0; i < size; i++) {
			Reservation curr = reservation.get(i);
			if (curr.getCustomer().getContactNumber() == contactNumber) {
				return curr;
			}
		}
		return null;
	}

	
	/** 
	 * Function used when removing a reservation.
	 * Iterates through the list of reservation, and find the table to be removed.
	 * Update the Status accordingly.
	 * @param reservation This is the list of reservation.
	 */
	public void removeReservation(List<Reservation> reservation) {
		Scanner sc = new Scanner(System.in);
		int tableNo;
		int size = reservation.size();

		if (size == 0) {
			System.out.printf("ERROR: There are no reservations at the moment");
			return;
		}
		System.out.printf("Enter the table number to be removed: ");
		do {

			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!");
				sc.next(); // this is important!
			}

			tableNo = sc.nextInt();
			break;

		} while (true);
		sc.nextLine();

		for (int i = 0; i < size; i++) {
			if (reservation.get(i).getTableNumber() == tableNo) {
				reservation.get(i).getTable().setStatus(0);
				reservation.remove(i);
				return;
			}
		}
		System.out.println("Table not under reservation !! ");
	}

	
	/** 
	 * Function used when creating a new reservation, adding to the reservation list.
	 * Ask for the number of people, name of the customer, contact number and date/time of reservation.
	 * Check whether the customer is under membership and Update accordingly base on the customerID.
	 * Get the next available table and set to reserved.
	 * Update reservation accordingly with the information.
	 * @param reservation This is the list of reservation.
	 * @param tables This is the list of tables
	 * @param customers This is the list of customer
	 * @throws ParseException
	 */
	public void createReservation(List<Reservation> reservation, List<Table> tables, List<Customer> customers)
			throws ParseException {
		Scanner sc = new Scanner(System.in);
		TableMgr tableMgr = new TableMgr();
		CustomerMgr customerMgr = new CustomerMgr();

		System.out.printf("Enter number of Pax: ");
		int numPax;
		do {

			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!");
				sc.next(); // this is important!
			}

			numPax = sc.nextInt();
			if (numPax >= 1 && numPax <= 10) {
				break;
			}
			System.out
					.println("Input entered is either not an integer, or is not in the valid range. Please try again!");

		} while (true);
		sc.nextLine();

		Table table = tableMgr.reserveTable(tables, numPax);

		if (table != null) {
			System.out.println("Enter Customer Contact Number: ");
			int contactNo = sc.nextInt();
			Customer cust = customerMgr.findCustomer(customers, contactNo);

			if (cust == null) {
				System.out.println("Enter Customer Name: ");
				String custName = sc.next();

				sc.nextLine();
				char member_str;

				while (true) {
					System.out.println("Membership? Enter (Y/N)");
					member_str = sc.nextLine().charAt(0);
					if (member_str == 'y' || member_str == 'Y' || member_str == 'n' || member_str == 'N') {
						break;
					}
				}

				boolean member = true;
				if (member_str == 'y' || member_str == 'Y') {
					member = true;
				} else if (member_str == 'n' || member_str == 'N') {
					member = false;
				}

				long custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
				cust = new Customer(custID, custName, member, contactNo);
				customers.add(cust);
			} else {
				sc.nextLine();
			}
			table.setCustomerID(cust.getCustomerID());

			System.out.println("Enter Reservation date and time (Format: dd/MM/yyyy HH:mm): ");
			String dateString = sc.nextLine();
			Date dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateString);
			reservation.add(new Reservation(dateTime, numPax, cust, table));
		}
		return;
	}

}