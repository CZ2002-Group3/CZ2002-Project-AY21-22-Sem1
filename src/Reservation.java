import java.util.Date;

public class Reservation {

	private Date dateTime;
	private int numPax;
	private int contactNumber;
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

	public int getTableNumber() {
		return tableNumber;
	}

	public Table getTable(){
		return table;
	}

	public Customer getCustomer(){
		return cust;
	}
}