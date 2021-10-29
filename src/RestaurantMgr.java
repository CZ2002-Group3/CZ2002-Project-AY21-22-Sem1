import java.text.*;
import java.util.*;

public class RestaurantMgr {

	protected List<Table> table;
	protected List<Reservation> reservation;
	protected List<Staff> staff;
	protected List<Customer> customer;
	protected List<Order> order;
	protected List<Order> paidOrders;
	protected List<MenuItem> menuItems;
	protected List<Promotion> promotions;

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

	public List<Table> getTable(){
			return this.table;
	};
	public List<Reservation> getReservation(){
		return this.reservation;
	}
	public List<Staff> getStaff(){
		return this.staff;
	}
	public List<Customer> getCustomer()
	{
		return this.customer;
	}
	public List<Order> getOrder(){
		return this.order;
	}
	public List<Order> getPaidOrders(){
		return this.paidOrders;
	}
	public List<MenuItem> getMenuItems(){
		return this.menuItems;
	}
	public List<Promotion> getPromotions(){
		return this.promotions;
	}
	
}