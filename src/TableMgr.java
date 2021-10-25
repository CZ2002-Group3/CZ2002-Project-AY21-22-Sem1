import java.util.ArrayList;
import java.util.List;

public class TableMgr {
	List<Table> tables;

	public TableMgr() {
	}

	
	/** 
	 * @param i++
	 */
	public void getTableStatus(List<Table> tables) {// pass in resturant.tables
		for (int i = 0; i < tables.size(); i++) {
			System.out.println("Table number " + tables.get(i).getTableNumber() + " is " + tables.get(i).getStatus());
		}
	}

	
	/** 
	 * @param tables
	 * @param custid
	 * @param numOfPax
	 * @return Table
	 */
	public Table assignTable(List<Table> tables, long custid, int numOfPax) {
		int flag; // to check if this customer has been allocated a table
		flag = 0;
		for (int i = 0; i < tables.size(); i++) {
			if ((tables.get(i).getCapacity() >= numOfPax) && (tables.get(i).checkTableAvailability() == true)) {
				flag = 1; // this customer has been assigned a table
				tables.get(i).setStatus(1);
				tables.get(i).setCustomerID(custid);
				System.out.println("Table number " + tables.get(i).getTableNumber() + " with a capacity of "
						+ tables.get(i).getCapacity() + " has been allocated to this customer");
				return tables.get(i);
			}
		}
		if (flag == 0) {
			System.out.println("This Customer has not been allocated a table");
			return null;
		}
		return null;
	}

	
	/** 
	 * @param tables
	 * @param numOfPax
	 * @return Table
	 */
	public Table reserveTable(List<Table> tables, int numOfPax) {
		int flag; // to check if this customer has been allocated a table
		flag = 0;
		for (int i = 0; i < tables.size(); i++) {
			if ((tables.get(i).getCapacity() >= numOfPax) && (tables.get(i).checkTableAvailability() == true)) {
				flag = 1; // this customer has been assigned a table
				tables.get(i).setStatus(2);
				System.out.println("Table number " + tables.get(i).getTableNumber() + " with a capacity of "
						+ tables.get(i).getCapacity() + " has been reserved for this customer.");
				return tables.get(i);
			}
		}
		if (flag == 0) {
			System.out.println("No avaliable table to be reserved for this customer.");
			return null;
		}
		return null;
	}

}