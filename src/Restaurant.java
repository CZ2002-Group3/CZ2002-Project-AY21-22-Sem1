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
		table = new ArrayList<Table>();
		reservation = new ArrayList<Reservation>();
		staff = new ArrayList<Staff>();
		staff.add(new Staff("Tom", 1234, "Manager"));
		customer = new ArrayList<Customer>();
		order = new ArrayList<Order>();
		menuItems = new ArrayList<MenuItem>();
		promotions = new ArrayList<Promotion>();
		addMenuItem();
		addTable();
	}

	private void addTable(){
		table.add(new Table(1, 10));
		table.add(new Table(1, 10));
		table.add(new Table(1, 10));
		table.add(new Table(1, 10));
		table.add(new Table(1, 10));
	}

	private void addMenuItem() {
		menuItems.add(new MenuItem("Steak", "This is a Steak", 50, FoodCategory.MAIN_COURSE));
		menuItems.add(new MenuItem("Coke", "This is a Coke", 1, FoodCategory.DRINKS));
		menuItems.add(new MenuItem("Cake", "This is a Cake", 50, FoodCategory.DESSERT));
		menuItems.add(new MenuItem("Rice", "This is a Rice", 0.5, FoodCategory.MAIN_COURSE));
	}
}