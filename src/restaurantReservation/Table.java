package restaurantReservation;

/**
 Represents a table in the restaurant.
 @author SS7_Grp3
 @version 1.0
 @since 2021-10-24
*/
public class Table {

	private TableStatus status;
	private int tableNumber;
	private TableCapacity capacity;
	private long customerId;

	public Table(int tableNumber, int capacity) {
		this.status = TableStatus.VACATED;
		this.tableNumber = tableNumber;
		setCapacity(capacity);
	}

	
	/** sets the status of the table to either vacated, occupied, reserved based on scenario.
	 * @param SetTable choice input to set status
	 */
	public void setStatus(int SetTable) { // 0 set VACATED, 1 set OCCUPIED, 2 set RESERVED 
		while(SetTable>2 || SetTable<0)
		{
			System.out.println("Invalid input. Please Try again");
			
		}
		if(SetTable==0) // VACATED
			{
				this.status=TableStatus.VACATED;
				System.out.println("Table Status set to VACATED");
			}
			else if(SetTable==1) // OCCUPIED
			{
				this.status=TableStatus.OCCUPIED;
				System.out.println("Table Status set to OCCUPIED");
			}
			else if(SetTable==2) // RESERVED
			{
				this.status=TableStatus.RESERVED;
				System.out.println("Table Status set to RESERVED");
			}
	}

	
	/**  get the status of the table
	 * @return this is the status of the table 
	 */
	public TableStatus getStatus() {
		return this.status;
	}

	
	/** set the table number
	 * @param number
	 */
	public void setTableNumber(int number){
		this.tableNumber=number;
		System.out.println("Table number set to" + this.tableNumber);
	}

	
	/** get the table number
	 * @return table number
	 */
	public int getTableNumber() {
		return this.tableNumber;
	}
	
	/** Set the seating capacity of the table
	 * @param capNo10 the capacity to be set 
	 */
	public void setCapacity(int capNo) { // 0 set VACATED, 1 set OCCUPIED, 2 set RESERVED 
		while(capNo%2!=0 || capNo<0 || capNo>10)
		{
			System.out.println("Invalid input. Please Try again");
		}
		if(capNo==2)
		{
			this.capacity=TableCapacity.SIZE2;
			System.out.println("Table Number "+ this.getTableNumber() +" has a max capacity of "+ getCapacity());
		}
		else if (capNo==4)
		{
			this.capacity=TableCapacity.SIZE4;
			System.out.println("Table Number "+ this.getTableNumber() +" has a max capacity of "+ getCapacity());
		}
		else if (capNo==6)
		{
			this.capacity=TableCapacity.SIZE6;
			System.out.println("Table Number "+ this.getTableNumber() +" has a max capacity of "+ getCapacity());
		}
		else if (capNo==8)
		{
			this.capacity=TableCapacity.SIZE8;
			System.out.println("Table Number "+ this.getTableNumber() +" has a max capacity of "+ getCapacity());
		}
		else if (capNo==10)
		{
			this.capacity=TableCapacity.SIZE10;
			System.out.println("Table Number "+ this.getTableNumber() +" has a max capacity of "+ getCapacity());
		}
		
	}
	
	/** Get the capacity of the table 
	 * @return capacity of the table 
	 */
	public int getCapacity() {
		
		if(this.capacity == TableCapacity.SIZE2)
		{
			return 2;
		}
		else if(this.capacity == TableCapacity.SIZE4)
		{
			return 4;
		}
		else if(this.capacity == TableCapacity.SIZE6)
		{
			return 6;
		}
		else if(this.capacity == TableCapacity.SIZE8)
		{
			return 8;
		}
		else
		{
			return 10;
		}
	}


	
	/** Set the customer ID of the table 
	 * @param custid CustomerID to be seated at that table 
	 */
	public void setCustomerID(long custid){
		this.customerId=custid;
		System.out.println("CustomerID " + this.customerId +" sits at Table Number " + this.tableNumber);
	}

	
	/** returns True/ false based on the table status. if table is occupied return false, table is available return true.
	 * @return Boolean Availability of the table 
	 */
	public Boolean checkTableAvailability() {
		if (this.status == TableStatus.RESERVED || this.status == TableStatus.OCCUPIED)
		{
			System.out.println("Table Number "+ this.getTableNumber() +" is "+ this.status);
			return false;
		}
		else
		{
			System.out.println("Table Number "+ this.getTableNumber() +" is "+ this.status);
			return true;

		}
	}

}
