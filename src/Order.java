import java.util.*;

public class Order {

	private static double discount = 0.15;
	private int tableNumber;
	private Date timeStamp;
	private Staff waiter;
	private List<MenuItem> orderItem;
	private boolean discounted;
	private Table table;
	private double totalPrice;
	private List<Promotion> promotionItem;
	private Customer customer;

	private void calculateTotal() {
		int oLength = orderItem.size();
		int pLength = promotionItem.size();
		this.totalPrice = 0;

		for (int i = 0; i < oLength; i++) {
			this.totalPrice += orderItem.get(i).getPrice();
		}

		for (int i = 0; i < pLength; i++) {
			this.totalPrice += promotionItem.get(i).getPrice();
		}
	}

	public Order(Date timeStamp, Staff waiter, List<MenuItem> orderItems, List<Promotion> promotionItems,
			Customer customer, Table table) {

		this.totalPrice = 0;
		this.tableNumber = table.getTableNumber();
		this.timeStamp = timeStamp;
		this.orderItem = new ArrayList<MenuItem>();
		this.orderItem.addAll(orderItems);
		this.waiter = waiter;
		this.customer = customer;
		this.table = table;
		this.promotionItem = new ArrayList<Promotion>();
		this.promotionItem.addAll(promotionItems);
	}

public void printOrderInvoice(boolean haveDiscount) {
		calculateTotal();
		this.discounted = haveDiscount;
		int oLength = orderItem.size();
		int pLength = promotionItem.size();
		int no = 1;

		System.out.println("Sever: " + waiter.getStaffName());
		System.out.println("Table: " + table.getTableNumber());
		System.out.println("Date: " + timeStamp);

		Map<MenuItem, Integer> totalMenuItem = new HashMap<MenuItem, Integer>();
		Map<Promotion, Integer> totalPromoItem = new HashMap<Promotion, Integer>();

		for (int i = 0; i < oLength; i++) {
			MenuItem item = orderItem.get(i);
			if (totalMenuItem.containsKey(item)) {
				totalMenuItem.put(item, totalMenuItem.get(item) + 1);

			} else {
				totalMenuItem.put(item, 1);
			}
		}
		for (int i = 0; i < pLength; i++) {
			Promotion item = promotionItem.get(i);
			if (totalPromoItem.containsKey(item)) {
				totalPromoItem.put(item, totalPromoItem.get(item) + 1);

			} else {
				totalPromoItem.put(item, 1);
			}
		}

		for (MenuItem key : totalMenuItem.keySet()) {
			MenuItem item = key;
			int amount = totalMenuItem.get(item);
			double totalPrice = amount * item.getPrice();
			System.out.println(
					no + ". " + item.getName() + " Qty: " + amount + " Price: $" + String.format("%.2f", totalPrice));
			no++;
		}

		for (Promotion key : totalPromoItem.keySet()) {
			Promotion item = key;
			int amount = totalPromoItem.get(item);
			double totalPrice = amount * item.getPrice();
			List<MenuItem> promoList = item.getPromoList();
			int promoSize = promoList.size();

			System.out.println(no + ". " + item.getName() + " -");
			for (int i = 0; i < promoSize; i++) {
				System.out.println(no + "." + (i + 1) + ". " + promoList.get(i).getName());
			}
			System.out.println("Qty: " + amount + " Price: $" + String.format("%.2f", totalPrice));
			no++;
		}

		double servieCharge = totalPrice * 0.1;
		double gst = totalPrice * 0.07;
		double finalTotal = totalPrice + servieCharge + gst;

		System.out.println("Subtotal: $" + String.format("%.2f", totalPrice));
		System.out.println("10% Service Charge: $" + String.format("%.2f", servieCharge));
		System.out.println("7% GST: $" + String.format("%.2f", gst));
		if (this.discounted) {
			double memberDiscount = totalPrice * discount;
			double memberFinal = (totalPrice + servieCharge + gst) - memberDiscount;
			System.out.println("15% Member Discount: -$" + String.format("%.2f", memberDiscount));
			System.out.println("Total: $" + String.format("%.2f", memberFinal));
			totalPrice = memberFinal;
		} else {
			System.out.println("Total: $" + String.format("%.2f", finalTotal));
			totalPrice = finalTotal;
		}
	}
	
	public Table getTable() {
		return this.table;
	}

	public Double getTotalPrice() {
		if (this.totalPrice == 0)
			calculateTotal();
		return this.totalPrice;
	}

	public Date getDate() {
		return this.timeStamp;
	}

	public int getTableNumber() {
		return this.tableNumber;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public List<MenuItem> getOrderItems(){
		return this.orderItem;
	}

	public List<Promotion> getPromotions(){
		return this.promotionItem;
	}

	public void removeOrderItem(MenuItem orderItem) {
		this.orderItem.remove(orderItem);

	}

	public void removeOrderItem(Promotion promotionItem) {
		this.promotionItem.remove(promotionItem);
	}

	public void addOrderItem(MenuItem orderItem) {
		this.orderItem.add(orderItem);
	}

	public void addOrderItem(Promotion promotionItem) {
		this.promotionItem.add(promotionItem);
	}
}