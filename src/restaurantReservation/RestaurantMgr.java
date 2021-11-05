package restaurantReservation;
import java.text.*;
import java.util.*;

/**
 Stores all the variables needed for RRPSS to work.
 @author SS7_Grp3
 @version 1.0
 @since 2021-11-05
*/
public class RestaurantMgr {

	protected List<Table> table;
	protected List<Reservation> reservation;
	protected List<Staff> staff;
	protected List<Customer> customer;
	protected List<Order> order;
	protected List<Order> paidOrders;
	protected List<MenuItem> menuItems;
	protected List<Promotion> promotions;

	/**
	* Create a Restaurant manager.
	* Initializes all the array list and also add some initial data for testing purposes.
	*/
	public RestaurantMgr() throws ParseException {
		table = new ArrayList<Table>();
		reservation = new ArrayList<Reservation>();
		staff = new ArrayList<Staff>();
		customer = new ArrayList<Customer>();
		order = new ArrayList<Order>();
		paidOrders = new ArrayList<Order>();
		menuItems = new ArrayList<MenuItem>();
		promotions = new ArrayList<Promotion>();

		// add menu item
		menuItems.add(new MenuItem("Steak", "This is a Steak", 50, FoodCategory.MAIN_COURSE));
		menuItems.add(new MenuItem("Coke", "This is a Coke", 1, FoodCategory.DRINKS));
		menuItems.add(new MenuItem("Cake", "This is a Cake", 50, FoodCategory.DESSERT));
		menuItems.add(new MenuItem("Rice", "This is a Rice", 0.5, FoodCategory.MAIN_COURSE));

		// add promo items
		Promotion promo1 = new Promotion();
		promo1.addMenuItem(menuItems.get(0));
		promo1.addMenuItem(menuItems.get(1));
		promo1.setName("Promo 1");
		promo1.setPrice(50);
		promo1.setDescription("This is promotion set 1");
		promotions.add(promo1);

		// add table
		table.add(new Table(1, 10));
		table.add(new Table(2, 10));
		table.add(new Table(3, 10));
		table.add(new Table(4, 10));
		table.add(new Table(5, 10));

		// add customer
		long custID;
		custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		customer.add(new Customer(custID, "Tom", true, 12345));
		custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		customer.add(new Customer(custID, "John", false, 14224));
		custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		customer.add(new Customer(custID, "Tim", false, 1111));

		// add staff
		staff.add(new Staff("Tom", 1234, "Cleaner"));
		staff.add(new Staff("Dick", 5678, "Manager"));
		staff.add(new Staff("Harry", 8910, "Promoter"));

		// add order
		TableMgr tableMgr = new TableMgr();
		List<MenuItem> orderItems;
		List<Promotion> promotionItems;
		Date timeStamp;
		Customer cust;
		Table tables;
		Staff waiter = staff.get(0);

		cust = customer.get(0);
		tables = tableMgr.assignTable(table, cust.getCustomerID(), 5);
		timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/10/2021 10:50");
		orderItems = new ArrayList<MenuItem>();
		orderItems.add(menuItems.get(0));
		promotionItems = new ArrayList<Promotion>();
		order.add(new Order(timeStamp, waiter, orderItems, promotionItems, cust, tables));

		cust = customer.get(1);
		tables = tableMgr.assignTable(table, cust.getCustomerID(), 5);
		timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/10/2020 10:50");
		orderItems = new ArrayList<MenuItem>();
		orderItems.add(menuItems.get(0));
		orderItems.add(menuItems.get(1));
		promotionItems = new ArrayList<Promotion>();
		promotionItems.add(promotions.get(0));
		order.add(new Order(timeStamp, waiter, orderItems, promotionItems, cust, tables));

		cust = customer.get(1);
		tables = tableMgr.assignTable(table, cust.getCustomerID(), 5);
		timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("15/10/2021 10:50");
		orderItems = new ArrayList<MenuItem>();
		orderItems.add(menuItems.get(0));
		orderItems.add(menuItems.get(1));
		orderItems.add(menuItems.get(1));
		orderItems.add(menuItems.get(1));
		promotionItems = new ArrayList<Promotion>();
		promotionItems.add(promotions.get(0));
		promotionItems.add(promotions.get(0));
		order.add(new Order(timeStamp, waiter, orderItems, promotionItems, cust, tables));
	}

	/**
	 * Get the Table array list.
	 * @return this is the Table object array list.
	 */
	public List<Table> getTable(){
			return this.table;
	};

	/**
	 * Get the Reservation array list.
	 * @return this is the Reservation object array list.
	 */
	public List<Reservation> getReservation(){
		return this.reservation;
	}

	/**
	 * Get the Staff array list.
	 * @return this is the Staff object array list.
	 */
	public List<Staff> getStaff(){
		return this.staff;
	}

	/**
	 * Get the Customer array list.
	 * @return this is the Customer object array list.
	 */
	public List<Customer> getCustomer()
	{
		return this.customer;
	}

	/**
	 * Get the Order array list.
	 * @return this is the Order object array list.
	 */
	public List<Order> getOrder(){
		return this.order;
	}

	/**
	 * Get the Paid Orders array list.
	 * @return this is the Order object array list of Paid Orders.
	 */
	public List<Order> getPaidOrders(){
		return this.paidOrders;
	}

	/**
	 * Get the Menu Items array list.
	 * @return this is the Menu Items object array list.
	 */
	public List<MenuItem> getMenuItems(){
		return this.menuItems;
	}

	/**
	 * Get the Promotions array list.
	 * @return this is the Promotions object array list.
	 */
	public List<Promotion> getPromotions(){
		return this.promotions;
	}
	
}