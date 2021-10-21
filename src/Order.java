import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Order {

	private static double discount = 0.15;
	private int tableNumber;
	private Date timeStamp;
	private Staff waiter;
	private List<MenuItem> orderItem;
	private boolean type;
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

	public void printOrderInvoice(boolean discounted) {
		calculateTotal();
		int oLength = orderItem.size();
		int pLength = promotionItem.size();

		System.out.println("Sever: " + waiter.getStaffName());
		System.out.println("Table: " + table.getTableNumber());
		System.out.println("Date: " + timeStamp);

		for (int i = 0; i < oLength; i++) {
			System.out.println(orderItem.get(i).getName() + "				$"
					+ String.format("%.2f", orderItem.get(i).getPrice()));
		}

		for (int i = 0; i < pLength; i++) {
			System.out.println(promotionItem.get(i).getName() + " " + promotionItem.get(i).getDescription()
					+ "				$" + String.format("%.2f", promotionItem.get(i).getPrice()));
		}

		double servieCharge = totalPrice * 0.1;
		double gst = totalPrice * 0.07;
		double finalTotal = totalPrice + servieCharge + gst;

		System.out.println("Subtotal: $" + String.format("%.2f", totalPrice));
		System.out.println("10% Service Charge: $" + String.format("%.2f", servieCharge));
		System.out.println("7% GST: $" + String.format("%.2f", gst));
		if (discounted) {
			double memberDiscount = totalPrice * discount;
			double memberFinal = totalPrice + servieCharge + gst - memberDiscount;
			System.out.println("15% Member Discount: -$" + String.format("%.2f", gst));
			System.out.println("Total: $" + String.format("%.2f", memberFinal));
		} else {
			System.out.println("Total: $" + String.format("%.2f", finalTotal));
		}
	}

	// /**
	// *
	// * @param Promotion
	// * @param order
	// */
	// public void createOrder(int Promotion, int order) {
	// // TODO - implement Order.createOrder
	// throw new UnsupportedOperationException();
	// }

	public Table getTable() {
		return this.table;
	}

	public Double getTotalPrice() {
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