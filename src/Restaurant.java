import java.text.*;
import java.util.*;

public class Restaurant {

	protected List<Table> table;
	protected List<Reservation> reservation;
	protected List<Staff> staff;
	protected List<Customer> customer;
	protected List<Order> order;
	protected List<Order> paidOrders;
	protected List<MenuItem> menuItems;
	protected List<Promotion> promotions;

	public Restaurant() throws ParseException {
		table = new ArrayList<Table>();
		reservation = new ArrayList<Reservation>();
		staff = new ArrayList<Staff>();
		customer = new ArrayList<Customer>();
		order = new ArrayList<Order>();
		paidOrders = new ArrayList<Order>();
		menuItems = new ArrayList<MenuItem>();
		promotions = new ArrayList<Promotion>();
		addMenuItem();
		addPromoItem();
		addTable();
		addCustomer();
		addStaff();
		addOrder();
	}

	private void addStaff(){
		staff.add(new Staff("Tom", 1234, "Manager"));
	}

	private void addTable() {
		table.add(new Table(1, 10));
		table.add(new Table(2, 10));
		table.add(new Table(3, 10));
		table.add(new Table(4, 10));
		table.add(new Table(5, 10));
	}

	private void addMenuItem() {
		menuItems.add(new MenuItem("Steak", "This is a Steak", 50, FoodCategory.MAIN_COURSE));
		menuItems.add(new MenuItem("Coke", "This is a Coke", 1, FoodCategory.DRINKS));
		menuItems.add(new MenuItem("Cake", "This is a Cake", 50, FoodCategory.DESSERT));
		menuItems.add(new MenuItem("Rice", "This is a Rice", 0.5, FoodCategory.MAIN_COURSE));
	}

	private void addPromoItem() {
		Promotion promo1 = new Promotion();
		promo1.addMenuItem(menuItems.get(0));
		promo1.addMenuItem(menuItems.get(1));
		promo1.setName("Promo 1");
		promo1.setPrice(50);
		promo1.setDescription("This is promotion set 1");
		promotions.add(promo1);
	}

	
	/** 
	 * @throws ParseException
	 */
	private void addOrder() throws ParseException {
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

	private void addCustomer() {
		long custID;
		custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		customer.add(new Customer(custID, "Tom", true, 12345));
		custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		customer.add(new Customer(custID, "John", false, 14224));
		custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		customer.add(new Customer(custID, "Tim", false, 1111));
	}
}