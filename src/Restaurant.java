import java.util.ArrayList;
import java.util.List;

public class Restaurant {

	protected List<Table> table;
	protected List<Reservation> reservation;
	protected List<Staff> staff;
	protected List<Customer> customer;
	protected List<Order> order;
	protected List<MenuItem> menuItems;
	protected List<Promotion> promotions;

	public Restaurant() {
<<<<<<< HEAD
		//table = new Table[6];
		menuItems = new ArrayList<MenuItem>();
=======
		table = new ArrayList<Table>();
>>>>>>> d559030e53dc699eb2acfcc8b74d1641467893d5
		reservation = new ArrayList<Reservation>();
		staff = new ArrayList<Staff>();
		staff.add(new Staff("Tom", 1234, "Manager"));
		customer = new ArrayList<Customer>();
		order = new ArrayList<Order>();
		menuItems = new ArrayList<MenuItem>();
		promotions = new ArrayList<Promotion>();
	}

	// public void updateMenuItem(MenuItem item) {
	// }

	// public void createMenuItem() {

	// }

	// public void deleteMenuItem(int MenuItem) {

	// }

}