import java.util.*;

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
		table.setStatus(0);
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
		Order order = null;
		List<MenuItem> orderedMenu = new ArrayList<MenuItem>();
		List<Promotion> orderedPromo = new ArrayList<Promotion>();

		Scanner sc = new Scanner(System.in);
		int choice = 1;

		while (choice != 0) {
			System.out.println("(1) Choose Ala Carte Items");
			System.out.println("(2) Choose Promotions Items");
			System.out.println("(3) Send Order");
			System.out.println("(4) Cancel Ordering");

			choice = sc.nextInt();
			switch (choice) {
				case 1:
					int mLength = MenuItem.size();

					for (int i = 0; i < mLength; i++) {
						System.out.println('(' + i + 1 + ')' + MenuItem.get(i).getName() + "				"
								+ MenuItem.get(i).getPrice());
					}

					System.out.println("(0) Go back to selection");

					while (choice != 0) {
						choice = sc.nextInt();
						orderedMenu.add(MenuItem.get(choice - 1));
						System.out.println(MenuItem.get(choice - 1).getName() + " Added!");
					}
					choice = 1;
					break;
				case 2:
					int pLength = Promotion.size();

					for (int i = 0; i < pLength; i++) {
						System.out.println('(' + i + 1 + ')' + Promotion.get(i).getName() + " "
								+ Promotion.get(i).getDescription() + "				" + Promotion.get(i).getPrice());
					}

					System.out.println("(0) Go back to selection");

					while (choice != 0) {
						choice = sc.nextInt();
						orderedPromo.add(Promotion.get(choice - 1));
						System.out.println(Promotion.get(choice - 1).getName() + " Added!");
					}
					choice = 1;
					break;
				case 3:
					Date timeStamp = new Date();
					Table table = new Table();
					order = new Order(timeStamp, waiter, orderedMenu, orderedPromo, true, (float) 0.5, table);
					choice = 0;
					break;
				case 4:
					choice = 0;
					break;
				default:
					System.out.println("Invalid Choice!");
					break;
			}
		}
		return order;
	}

	/**
	 * 
	 * @param Order
	 * @param Integar
	 */
	public void generateSalesReport(int[] Order, int Integar) {

	}

}