
package restaurantReservation;
import java.util.Date;

/**
 Represents Reservation in the restaurant.
 @author SS7_Grp3
 @version 1.0
 @since 2021-10-27
*/

public class Reservation {

	private Date dateTime;
	private int numPax;
	private long contactNumber;
	private int tableNumber;
	private String customerName;
	private Table table;
	private Customer cust;
	

	/**
	 * Constructor to create Reservation.
	 */
	public Reservation(Date Datee, int numPax, Customer cust, Table table) {
		this.dateTime = Datee;
		this.numPax = numPax;
		this.contactNumber = cust.getContactNumber();
		this.tableNumber = table.getTableNumber();
		this.customerName = cust.getCustomerName();
		this.cust = cust;
		this.table = table;
	}

	/**
	 * Function to print out all the details of the reservation.
	 */
	public void printReservation() {
		System.out.println("===========================================================");
		System.out.println("Date and Time of reservation: " + dateTime);
		System.out.println("Number of Pax: " + numPax);
		System.out.println("Customer contact number: " + contactNumber);
		System.out.println("Table assigned: " + tableNumber);
		System.out.println("Customer Name: " + customerName);
		System.out.println(" ");
	}

	
	/** 
	 * Accessor method to get the date and time of the reservation.
	 * @return Date - dateTime of the reservation made.
	 */
	public Date getdateTime() {
		return dateTime;
	}

	
	/** 
	 * Accessor method to get the Customer Name of the reservation.
	 * @return String - customerName customer name that make the reservation.
	 */
	public String getcustomerName() {
		return customerName;
	}

	
	/** 
	 * Accessor method to get the Table Number of the reservation.
	 * @return Int - tableNumber table number under the reservation.
	 */
	public int getTableNumber() {
		return tableNumber;
	}

	
	/** 
	 * Accessor method to get the Table of the reservation.
	 * @return Table - table.
	 */
	public Table getTable() {
		return table;
	}

	
	/** 
	 * Accessor method to get the Customer of the reservation.
	 * @return Customer - cust customer details.
	 */
	public Customer getCustomer() {
		return cust;
	}
}