import java.util.Date;

public class Reservation {

	private Date dateTime;
	private int numPax;
	private int contactNumber;
	private int tableNumber;
	private String customerName;

	/**
	 * 
	 * @param Date
	 * @param Integar
	 * @param Int
	 */
	public Reservation(Date Datee, int numPax, int contactNumber, int tableNumber, String customerName) {
		this.dateTime = Datee;
		this.numPax = numPax;
		this.contactNumber = contactNumber;
		this.tableNumber = tableNumber;
		this.customerName = customerName;
	}

	public void allocateTable(int Integar) {
		// TODO - implement Reservation.allocateTable
		throw new UnsupportedOperationException();
	}

	public void deleteReservation() {
			
	}

	public void printReservation() {
		System.out.println("===========================================================");
		System.out.println("Date and Time of reservation: "+ dateTime);
		System.out.println("Number of Pax: "+ numPax);
		System.out.println("Customer contact number: "+ contactNumber);
		System.out.println("Table assigned: "+ tableNumber);
		System.out.println("Customer Name: "+ customerName);
		System.out.println(" ");
	}

	public Date getdateTime() {
		return dateTime;
	}
	
	public String getcustomerName() {
		return customerName;
	}

	public int getTable() {
		return tableNumber;
	}

}