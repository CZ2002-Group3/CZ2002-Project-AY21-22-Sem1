import java.util.ArrayList;
import java.util.List;

public class Restaurant {

	protected List<Table> table;
	protected List<Reservation> reservation;
	protected Staff[] staff;
	protected Customer[] customer;
	protected ArrayList<Reservation> order;
	protected ArrayList<MenuItem> menuItems;
	protected ArrayList<Promotion> promotions;

	public Restaurant() {
		// table = new Table[6];
		menuItems = new ArrayList<MenuItem>();
		reservation = new ArrayList<Reservation>();
		promotions = new ArrayList<Promotion>();
		// table[0] = new Table(1, 10);
		// table[1] = new Table(2, 8);
		// table[2] = new Table(3, 6);
		// table[3] = new Table(4, 4);
		// table[4] = new Table(5, 2);
		// table[5] = new Table(6, 10);
	}

	public void updateMenuItem(MenuItem item) {
	}

	public void createMenuItem() {

	}

	public void deleteMenuItem(int MenuItem) {

	}

}