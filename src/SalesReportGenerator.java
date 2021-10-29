/**
 Represents Sales report Generator.
 @author Thai Wei Cheng
 @version 1.0
 @since 2021-10-29
*/

import java.util.*;

public class SalesReportGenerator {

	/**
	 * Constructor for sales report
	 */
	public SalesReportGenerator(){
	}

	/**
	 * Function to generate sales report.
	 * @param paidOrders This is the list of paid orders.
	 * @param menuItems This is the list of menu items.
	 * @param promotions This is the list of promotion set items
	 * @param days This is the number of days to generate for the sales report.
	 */
	public void generateSalesReport(List<Order> paidOrders, List<MenuItem> menuItems, List<Promotion> promotions, int days) {
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
				System.out
						.println(item.getName() + ": Qty: " + amount + "Total: $" + String.format("%.2f", totalPrice));
			}
		}

		for (Promotion key : totalPromoItem.keySet()) {
			Promotion item = key;
			int amount = totalPromoItem.get(item);
			if (amount > 0) {
				double totalPrice = amount * item.getPrice();
				total += totalPrice;
				System.out
						.println(item.getName() + ": Qty: " + amount + "Total: $" + String.format("%.2f", totalPrice));
			}
		}

		double servieCharge = total * 0.1;
		double gst = total * 0.07;
		double finalTotal = total + servieCharge + gst;

		System.out.println("Total Revenue: $" + String.format("%.2f", total));
		System.out
				.println("Total Revenue (After 7% GST and 10% Service Charge): $" + String.format("%.2f", finalTotal));
		System.out.println("Total Revenue (After 15% Member Discount): $" + String.format("%.2f", totalActual));
	}
}