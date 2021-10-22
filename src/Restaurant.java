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

	public void generateSalesReport(int days) {
		List<Order> ordersInPeriod = new ArrayList<Order>();
		Date today = new Date();
		Map<MenuItem, Integer> totalMenuItem = new HashMap<MenuItem, Integer>();
		Map<Promotion, Integer> totalPromoItem = new HashMap<Promotion, Integer>();
		double total = 0;
		double totalActual = 0;

		int totalMSize = menuItems.size();
		int totalPSize = promotions.size();
		for (int i = 0; i < totalMSize; i++) {
			totalMenuItem.put(menuItems.get(i), 0);
		}
		for (int i = 0; i < totalPSize; i++) {
			totalPromoItem.put(promotions.get(i), 0);
		}

		int oSize = paidOrders.size();
		for (int i = 0; i < oSize; i++) {
			Order curr = paidOrders.get(i);

			long diff = today.getTime() - curr.getDate().getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);

			if (diffDays <= 50) {
				ordersInPeriod.add(curr);
			}
		}

		int oIPSize = ordersInPeriod.size();
		for (int i = 0; i < oIPSize; i++) {
			Order curr = ordersInPeriod.get(i);
			List<MenuItem> currOrderItems = curr.getOrderItems();
			List<Promotion> currPromotionItems = curr.getPromotions();

			int mSize = currOrderItems.size();
			int pSize = currPromotionItems.size();

			for (int j = 0; j < mSize; j++) {
				MenuItem item = currOrderItems.get(j);
				totalMenuItem.put(item, totalMenuItem.get(item) + 1);
			}

			for (int j = 0; j < pSize; j++) {
				Promotion item = currPromotionItems.get(j);
				totalPromoItem.put(item, totalPromoItem.get(item) + 1);
			}

			totalActual += curr.getTotalPrice();
		}

		long DAY_IN_MS = 1000 * 60 * 60 * 24;
		Date before = new Date(today.getTime() - (days * DAY_IN_MS));

		System.out.println("Sales Report");
		System.out.println(before + " to " + today);

		for (MenuItem key : totalMenuItem.keySet()) {
			MenuItem item = key;
			int amount = totalMenuItem.get(item);
			if (amount > 0) {
				double totalPrice = amount * item.getPrice();
				total += totalPrice;
				System.out.println(item.getName() + ": Qty: " + amount + "Total: $" + String.format("%.2f", totalPrice));
			}
		}

		for (Promotion key : totalPromoItem.keySet()) {
			Promotion item = key;
			int amount = totalPromoItem.get(item);
			if (amount > 0) {
				double totalPrice = amount * item.getPrice();
				total += totalPrice;
				System.out.println(item.getName() + ": Qty: " + amount + "Total: $" + String.format("%.2f", totalPrice));
			}
		}

		double servieCharge = total * 0.1;
		double gst = total * 0.07;
		double finalTotal = total + servieCharge + gst;

		System.out.println("Total Revenue: $" + String.format("%.2f", total));
		System.out.println("Total Revenue (After 7% GST and 10% Service Charge): $" + String.format("%.2f", finalTotal));
		System.out.println("Total Revenue (After 15% Member Discount): $" + String.format("%.2f", totalActual));
	}
}