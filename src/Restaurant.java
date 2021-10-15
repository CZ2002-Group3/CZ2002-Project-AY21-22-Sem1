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
		table =new ArrayList<Table>();
		reservation = new ArrayList<Reservation>();
	}

	public void updateMenuItem(MenuItem item) {
	}

	public void createMenuItem() {

	}

	public void deleteMenuItem(int MenuItem) {

	}

}