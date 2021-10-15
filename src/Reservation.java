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

	public void printReservation(int Int) {
		// TODO - implement Reservation.printReservation
		throw new UnsupportedOperationException();
	}

	public Date getdateTime() {
		return dateTime;
	}
	
	public String getcustomerName() {
		return this.customerName;
	}

	public Table getTable() {
		// TODO - implement Reservation.getTable
		throw new UnsupportedOperationException();
	}

}