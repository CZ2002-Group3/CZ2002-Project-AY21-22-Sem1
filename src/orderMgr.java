import java.util.List;

public class orderMgr {

	public orderMgr() {

	}

	/**
	 * 
	 * @param Order
	 */
	public void orderPaid(Order order) {
		order.printOrderInvoice();
		Table table = order.getTable();
		table.setStatus(TableStatus.VACATED);
	}

	/**
	 * 
	 * @param Order
	 */
	public void viewOrder(Order order) {
		order.printOrderInvoice();
	}

	/**
	 * 
	 * @param MenuItem
	 * @param Promotion
	 */
	public Order createOrder(List<MenuItem> MenuItem, List<Promotion> Promotion, Staff waiter) {

	}

	/**
	 * 
	 * @param Order
	 * @param Integar
	 */
	public void generateSalesReport(int[] Order, int Integar) {

	}

}