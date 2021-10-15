import java.util.*;

public class orderMgr {

	public orderMgr() {
	}

	/**
	 * 
	 * @param Order
	 */
	public void orderPaid(List<Order> order, int tableNumber) {
		int orderSize = order.size();
		Order found = null;
		for (int i = 0; i < orderSize; i++) {
			if (order.get(i).getTableNumber() == tableNumber) {
				found = order.get(i);
				break;
			}
		}
		if (found != null) {
			found.printOrderInvoice();
			Table table = found.getTable();
			table.setStatus(0);
			order.remove(found);
		}
		else{
			System.out.println("Order not found!");
		}
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
	public Order createOrder(List<MenuItem> MenuItem, List<Promotion> Promotion, Staff waiter, Table table) {
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

			System.out.printf("Enter the number of your choice: ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					int mLength = MenuItem.size();
					System.out.println("CHOICE NAME		FOOD CATEGORY		DESCRIPTION		PRICE");
					for (int i = 0; i < mLength; i++) {
						System.out.println("(" + (i + 1) + ") " + MenuItem.get(i).getName() + "		"
								+ MenuItem.get(i).getFoodCategory() + "		" + MenuItem.get(i).getDescription()
								+ "		$" + String.format("%.2f",MenuItem.get(i).getPrice()));
					}

					System.out.println("(0) Go back to selection");
					System.out.printf("Enter the number of your choice: ");
					choice = sc.nextInt();

					while (choice != 0) {
						orderedMenu.add(MenuItem.get(choice - 1));
						System.out.println(MenuItem.get(choice - 1).getName() + " Added!");

						System.out.printf("Enter the number of your choice: ");
						choice = sc.nextInt();
					}
					choice = 1;
					break;
				case 2:
					int pLength = Promotion.size();

					System.out.println("CHOICE NAME		FOOD CATEGORY		DESCRIPTION		PRICE");
					for (int i = 0; i < pLength; i++) {
						System.out.println("(" + (i + 1) + ") " + Promotion.get(i).getName() + " "
								+ Promotion.get(i).getDescription() + "				" + String.format("%.2f",Promotion.get(i).getPrice()));
					}

					System.out.println("(0) Go back to selection");
					System.out.printf("Enter the number of your choice: ");
					choice = sc.nextInt();

					while (choice != 0) {
						orderedPromo.add(Promotion.get(choice - 1));
						System.out.println(Promotion.get(choice - 1).getName() + " Added!");
						System.out.printf("Enter the number of your choice: ");
						choice = sc.nextInt();
					}
					choice = 1;
					break;
				case 3:
					if (orderedMenu.size() != 0 || orderedPromo.size() != 0) {
						Date timeStamp = new Date();
						order = new Order(timeStamp, waiter, orderedMenu, orderedPromo, true, (float) 0.5, table);
						choice = 0;
					} else {
						System.out.println("No items in the order!");
						choice = 1;
					}
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