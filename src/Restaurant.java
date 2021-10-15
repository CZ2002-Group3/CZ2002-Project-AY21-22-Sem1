import java.util.*;
import java.io.*;

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
		addMenuItem();
	}

	private void addMenuItem() {
		// try {
		// FileReader frStream = new FileReader("menuItems.txt");
		// BufferedReader brStream = new BufferedReader(frStream);
		// String inputLine;
		// int i;
		// System.out.println("The file contains:");
		// for (i = 0; i < 5; i++) {
		// inputLine = brStream.readLine(); // read in a line
		// System.out.println(inputLine);
		// }
		// brStream.close();
		// } catch (FileNotFoundException e) {
		// System.out.println("Error opening the input file!" + e.getMessage());
		// System.exit(0);
		// }
		menuItems.add(new MenuItem("Steak", "This is a Steak", 50, FoodCategory.MAIN_COURSE));
		menuItems.add(new MenuItem("Coke", "This is a Coke", 1, FoodCategory.DRINKS));
		menuItems.add(new MenuItem("Cake", "This is a Cake", 50, FoodCategory.DESSERT));
		menuItems.add(new MenuItem("Rice", "This is a Rice", 0.5, FoodCategory.MAIN_COURSE));
	}

	// public void updateMenuItem(MenuItem item) {
	// }

	// public void createMenuItem() {

	// }

	// public void deleteMenuItem(int MenuItem) {

	// }

}