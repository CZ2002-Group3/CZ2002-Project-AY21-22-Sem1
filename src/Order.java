import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Order {

	private int tableNumber;
	private Date timeStamp;
	private Staff waiter;
	private List<MenuItem> orderItem;
	private boolean type;
	private float discount;
	private Table table;
	private double totalPrice;
	private List<Promotion> promotionItem;

	/**
	 * 
	 * @param orderItem
	 */
	private void calculateTotal() {
		int oLength = orderItem.size();
		int pLength = promotionItem.size();

		for (int i = 0; i < oLength; i++) {
			this.totalPrice += orderItem.get(i).getPrice();
		}

		for (int i = 0; i < pLength; i++) {
			this.totalPrice += promotionItem.get(i).getPrice();
	}

	public Order(int tableNumber, Date timeStamp, Staff waiter, List<MenuItem> orderItems, boolean type, float discount,
			Table table, List<Promotion> promotionItems) {
				
		this.totalPrice = 0;
		this.tableNumber = tableNumber;
		this.timeStamp = timeStamp;
		this.orderItem = new ArrayList<MenuItem>();
		this.orderItem.addAll(orderItems);
		this.type = type;
		this.discount = discount;
		this.table = table;
		this.promotionItem = new ArrayList<Promotion>();
		this.promotionItem.addAll(promotionItems);
	}

	public String printOrderInvoice() {
		calculateTotal();
		int oLength = orderItem.size();
		int pLength = promotionItem.size();

		System.out.println("Sever: " + waiter.getStaffName());
		System.out.println("Table: " + table.getTableNumber());
		System.out.println("Date: " + timeStamp);

		for (int i = 0; i < oLength; i++) {
			System.out.println(orderItem.get(i).getName() + "				" + orderItem.get(i).getPrice());
		}

		for (int i = 0; i < pLength; i++) {
			System.out.println(promotionItem.get(i).getName() + "				" + promotionItem.get(i).getPrice());
		}

		double servieCharge = totalPrice * 0.1;
		double gst = totalPrice * 0.07;
		double finalTotal = totalPrice + servieCharge + gst;

		System.out.println("Subtotal: " + totalPrice);
		System.out.println("10% Service Charge: " + servieCharge);
		System.out.println("7% GST: " + gst);
		System.out.println("Total: " + finalTotal);
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

	public Table getTable(){
		return this.table;
	}

	public Double getTotalPrice() {
		calculateTotal();
		return totalPrice;
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