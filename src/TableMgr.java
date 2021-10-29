/**
 Represents the manager of table class.
 @author Chiaw Yan Shiun
 @version 1.0
 @since 2021-10-24
*/

import java.util.ArrayList;
import java.util.List;

public class TableMgr {
	List<Table> tables;

	public TableMgr() {
	}

	
	/** Gets the status of all the tables in the restuarant
	 * @param i++ counter
	 */
	public void getTableStatus(List<Table> tables) {// pass in resturant.tables
		for (int i = 0; i < tables.size(); i++) {
			System.out.println("Table number " + tables.get(i).getTableNumber() + " is " + tables.get(i).getStatus());
		}
	}

	
	/** 
	 * @param tables list of tables on the restuarant
	 * @param custid Customer ID that is sitting at the table
	 * @param numOfPax Number of people with the customer
	 * @return Table Table that is assigned to the customer 
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
	 * @param tables list of tables on the restuarant
	 * @param numOfPax Number of people with the customer
	 * @return Table Table that is reserved for the customer
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
