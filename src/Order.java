public class Order {

	private int tableNumber;
	private float timeStamp;
	private staff waiter;
	private MenuItem[] orderItem;
	private boolean type;
	private float discount;
	private Table table;
	private double totalPrice;
	private Promotion[] promotionItem;

	/**
	 * 
	 * @param orderItem
	 */
	private Double calculateTotal(int orderItem) {
		// TODO - implement Order.calculateTotal
		throw new UnsupportedOperationException();
	}

	public String printOrderInvoice() {
		// TODO - implement Order.printOrderInvoice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Promotion
	 * @param order
	 */
	public void createOrder(int Promotion, int order) {
		// TODO - implement Order.createOrder
		throw new UnsupportedOperationException();
	}

	public Double getTotalPrice() {
		// TODO - implement Order.getTotalPrice
		throw new UnsupportedOperationException();
	}

	public void removeOrderItem() {
		// TODO - implement Order.removeOrderItem
		throw new UnsupportedOperationException();
	}

	public void addOrderItem() {
		// TODO - implement Order.addOrderItem
		throw new UnsupportedOperationException();
	}

}