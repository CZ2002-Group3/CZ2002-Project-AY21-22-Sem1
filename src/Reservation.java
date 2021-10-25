import java.util.Date;

public class Reservation {

	private Date dateTime;
	private int numPax;
	private long contactNumber;
	private int tableNumber;
	private String customerName;
	private Table table;
	private Customer cust;

	public Reservation(Date Datee, int numPax, Customer cust, Table table) {
		this.dateTime = Datee;
		this.numPax = numPax;
		this.contactNumber = cust.getContactNumber();
		this.tableNumber = table.getTableNumber();
		this.customerName = cust.getCustomerName();
		this.cust = cust;
		this.table = table;
	}

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
	 * @return Date
	 */
	public Date getdateTime() {
		return dateTime;
	}

	
	/** 
	 * @return String
	 */
	public String getcustomerName() {
		return customerName;
	}

	
	/** 
	 * @return int
	 */
	public int getTableNumber() {
		return tableNumber;
	}

	
	/** 
	 * @return Table
	 */
	public Table getTable() {
		return table;
	}

	
	/** 
	 * @return Customer
	 */
	public Customer getCustomer() {
		return cust;
	}
}