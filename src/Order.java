
/**
 Represents an order in the restaurant.
 @author Thai Wei Cheng
 @version 1.0
 @since 2021-10-24
*/
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

	/**
	 * Create a new order according to the table number and customer.
	 * An order must have aleast an a le carte item or promotion set.
	 * @param timeStamp This is the time when the order is made.
	 * @param waiter This is the waiter who made the order.
	 * @param orderItems This is a list of a le carte items ordered.
	 * @param promotionItems This is a list of promotion set ordered.
	 * @param customer This is the customer who made the order.
	 * @param table This is the table where the customer is sitting.
	 */
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

	/**
	 * This is a function to calculate the total price from the order.
	 */
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

	/**
	 * Print the Invoice of the order.
	 * An order can have a discount or not discount depending on if the customer is a member or not.
	 * @param haveDiscount This is to indicate if the order have a discount.
	 */
	public void printOrderInvoice(boolean haveDiscount) {
		calculateTotal();
		this.discounted = haveDiscount;
		int oLength = orderItem.size();
		int pLength = promotionItem.size();
		int no = 1;

		System.out.println("Server: " + waiter.getStaffName());
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

	/**
	 * Get the Table.
	 * @return this is the table where the order is made.
	 */
	public Table getTable() {
		return this.table;
	}

	/**
	 * Get the total price of the order.
	 * @return this Total Price.
	 */
	public Double getTotalPrice() {
		if (this.totalPrice == 0)
			calculateTotal();
		return this.totalPrice;
	}

	/**
	 * Get the time when the order is made.
	 * @return this TimeStamp.
	 */
	public Date getDate() {
		return this.timeStamp;
	}

	/**
	 * Get table number.
	 * @return this is the table number where the order is made.
	 */
	public int getTableNumber() {
		return this.tableNumber;
	}

	/**
	 * Get customer.
	 * @return this is the customer who made the order.
	 */
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Get a le carte item list.
	 * @return this is the list of a le carte item made.
	 */
	public List<MenuItem> getOrderItems() {
		return this.orderItem;
	}

	/**
	 * Get promotion set item list.
	 * @return this is the list of promotion set item made.
	 */
	public List<Promotion> getPromotions() {
		return this.promotionItem;
	}

	/**
	 * Remove an a le carte item from list.
	 * @param orderItem a le carte item to be removed.
	 */
	public void removeOrderItem(MenuItem orderItem) {
		this.orderItem.remove(orderItem);

	}

	/**
	 * Remove a promotion set item from list.
	 * @param promotionItem promotion set item to be removed.
	 */
	public void removeOrderItem(Promotion promotionItem) {
		this.promotionItem.remove(promotionItem);
	}

	/**
	 * Add an a le carte item from list.
	 * @param orderItem a le carte item to be added.
	 */
	public void addOrderItem(MenuItem orderItem) {
		this.orderItem.add(orderItem);
	}

	/**
	 * Add a promotion set item from list.
	 * @param promotionItem promotion set item to be added.
	 */
	public void addOrderItem(Promotion promotionItem) {
		this.promotionItem.add(promotionItem);
	}
}