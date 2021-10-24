/**
 Represents the manager of order class.
 @author Thai Wei Cheng
 @version 1.0
 @since 2021-10-24
*/
import java.util.*;

public class OrderMgr {

	/**
	 * Create an order manager.
	 */
	public OrderMgr() {
	}

	/**
	 * Function used when an order is paid.
	 * Find the order according to the table number.
	 * Changes the status of the table.
	 * @param order This is the list of orders.
	 * @param paidOrder This is the list of paid orders.
	 * @param tableNumber This is the table number of the order being paid.
	 */
	public void orderPaid(List<Order> order, List<Order> paidOrder, int tableNumber) {
		int orderSize = order.size();
		Order found = null;
		Scanner sc = new Scanner(System.in);
		Boolean discount = false;

		for (int i = 0; i < orderSize; i++) {
			if (order.get(i).getTableNumber() == tableNumber) {
				found = order.get(i);
				break;
			}
		}
		if (found != null) {
			Table table = found.getTable();

			Customer cust = found.getCustomer();
			if (cust.getIsMember()) {
				System.out.printf("Does the customer want a discount? ");
				discount = sc.nextBoolean();
			}

			found.printOrderInvoice(discount);
			table.setStatus(0);
			paidOrder.add(found);
			order.remove(found);
		} else {
			System.out.println("Order not found!");
		}
	}

	/**
	 * Viewing of order invoice before paying.
	 * @param order this is the order to view.
	 * @param discounted this indicate if there is a discount.
	 */
	public void viewOrder(Order order, boolean discounted) {
		order.printOrderInvoice(discounted);
	}

	/**
	 * Creates a new order object.
	 * @param MenuItem This is a list of a le carte items avaliable in the restaurant.
	 * @param Promotion This is a list of promotion set items avaliable in the restaurant.
	 * @param waiter This is the waiter making the order.
	 * @param table This is the table where the customer is sitting.
	 * @param customer This is the customer making the order.
	 * @return
	 */
	public Order createOrder(List<MenuItem> MenuItem, List<Promotion> Promotion, Staff waiter, Table table,
			Customer customer) {
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

			do {
				while (!sc.hasNextInt()) {
					System.out.println("Input is invalid, try again!");
					System.out.printf("Enter the number of your choice: ");
					sc.next();
				}
				choice = sc.nextInt();
				break;

			} while (true);

			switch (choice) {
			case 1:
				int mLength = MenuItem.size();
				System.out.println("CHOICE NAME		FOOD CATEGORY		DESCRIPTION		PRICE");
				for (int i = 0; i < mLength; i++) {
					System.out.println("(" + (i + 1) + ") " + MenuItem.get(i).getName() + "		"
							+ MenuItem.get(i).getFoodCategory() + "		" + MenuItem.get(i).getDescription()
							+ "		$" + String.format("%.2f", MenuItem.get(i).getPrice()));
				}

				System.out.println("(0) Go back to selection");
				System.out.printf("Enter the number of your choice: ");

				do {
					while (!sc.hasNextInt()) {
						System.out.println("Input is invalid, try again!");
						System.out.printf("Enter the number of your choice: ");
						sc.next();
					}
					choice = sc.nextInt();
					break;

				} while (true);

				while (choice != 0) {
					orderedMenu.add(MenuItem.get(choice - 1));
					System.out.println(MenuItem.get(choice - 1).getName() + " Added!");

					System.out.printf("Enter the number of your choice: ");

					do {
						while (!sc.hasNextInt()) {
							System.out.println("Input is invalid, try again!");
							System.out.printf("Enter the number of your choice: ");
							sc.next();
						}
						choice = sc.nextInt();
						break;

					} while (true);

				}
				choice = 1;
				break;
			case 2:
				int pLength = Promotion.size();

				System.out.println("CHOICE NAME		DESCRIPTION		PRICE");
				for (int i = 0; i < pLength; i++) {
					System.out.println("(" + (i + 1) + ") " + Promotion.get(i).getName() + "		"
							+ Promotion.get(i).getDescription() + "				"
							+ String.format("%.2f", Promotion.get(i).getPrice()));
				}

				System.out.println("(0) Go back to selection");
				System.out.printf("Enter the number of your choice: ");

				do {
					while (!sc.hasNextInt()) {
						System.out.println("Input is invalid, try again!");
						System.out.printf("Enter the number of your choice: ");
						sc.next();
					}
					choice = sc.nextInt();
					break;

				} while (true);

				while (choice != 0) {
					orderedPromo.add(Promotion.get(choice - 1));
					System.out.println(Promotion.get(choice - 1).getName() + " Added!");

					do {
						while (!sc.hasNextInt()) {
							System.out.println("Input is invalid, try again!");
							System.out.printf("Enter the number of your choice: ");
							sc.next();
						}
						choice = sc.nextInt();
						break;

					} while (true);
				}
				choice = 1;
				break;
			case 3:
				if (orderedMenu.size() != 0 || orderedPromo.size() != 0) {
					Date timeStamp = new Date();
					order = new Order(timeStamp, waiter, orderedMenu, orderedPromo, customer, table);
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
	 * Function to remove an ordered item in the order.
	 * Item can be a le carte or promotion set.
	 * @param order This is the list of orders.
	 * @param tableNumber This is the table number of the order being paid.
	 */
	public void removeOrderItem(List<Order> order, int tableNumber) {
		int orderSize = order.size();
		Order found = null;
		Scanner sc = new Scanner(System.in);
		int choice = -1;

		for (int i = 0; i < orderSize; i++) {
			if (order.get(i).getTableNumber() == tableNumber) {
				found = order.get(i);
				break;
			}
		}
		if (found != null) {
			List<MenuItem> menuItems = found.getOrderItems();
			List<Promotion> promoItems = found.getPromotions();

			while (choice != 0) {

				int mSize = menuItems.size();
				int pSize = promoItems.size();

				System.out.println("CHOICE NAME		FOOD CATEGORY		DESCRIPTION		PRICE");
				for (int j = 0; j < mSize; j++) {
					System.out.println("(" + (j + 1) + ") " + menuItems.get(j).getName() + "		"
							+ menuItems.get(j).getFoodCategory() + "		" + menuItems.get(j).getDescription()
							+ "		$" + String.format("%.2f", menuItems.get(j).getPrice()));
				}

				System.out.println("CHOICE NAME		DESCRIPTION		PRICE");
				for (int j = 0; j < pSize; j++) {
					System.out.println("(" + (mSize + j + 1) + ") " + promoItems.get(j).getName() + "		"
							+ promoItems.get(j).getDescription() + "				$"
							+ String.format("%.2f", promoItems.get(j).getPrice()));
				}

				System.out.println("(0) Go back to selection");
				System.out.printf("Enter the number of your choice: ");
				choice = sc.nextInt();

				if (choice <= mSize && choice > 0) {
					if ((pSize == 0 && (mSize - 1) != 0) || pSize > 0) {
						MenuItem delMenuItem = menuItems.get(choice - 1);
						System.out.println(delMenuItem.getName() + " Removed!");
						menuItems.remove(delMenuItem);
					} else {
						System.out.println("You must have at least one item in your order!");
					}
				} else if (choice > mSize) {
					if ((mSize == 0 && (pSize - 1) != 0) || mSize > 0) {
						Promotion delPromotion = promoItems.get(choice - 1 - mSize);
						System.out.println(delPromotion.getName() + " Removed!");
						promoItems.remove(delPromotion);
					} else {
						System.out.println("You must have at least one item in your order!");
					}
				}
			}

		} else {
			System.out.println("Order not found!");
		}
	}

	/**
	 * Function to add an item in the order.
	 * Item can be a le carte or promotion set.
	 * @param order This is the list of orders.
	 * @param MenuItem This is a list of a le carte items avaliable in the restaurant.
	 * @param Promotion This is a list of promotion set items avaliable in the restaurant.
	 * @param tableNumber This is the table number of the order being paid.
	 */
	public void addOrderItem(List<Order> order, List<MenuItem> MenuItem, List<Promotion> Promotion, int tableNumber) {
		int orderSize = order.size();
		Order found = null;
		Scanner sc = new Scanner(System.in);
		int choice = -1;

		for (int i = 0; i < orderSize; i++) {
			if (order.get(i).getTableNumber() == tableNumber) {
				found = order.get(i);
				break;
			}
		}
		if (found != null) {
			while (choice != 0) {
				System.out.println("(1) Add Ala Carte Items");
				System.out.println("(2) Add Promotions Items");
				System.out.println("(3) Done/Cancel Adding Items");

				System.out.printf("Enter the number of your choice: ");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					int mLength = MenuItem.size();
					System.out.println("CHOICE NAME		FOOD CATEGORY		DESCRIPTION		PRICE");
					for (int i = 0; i < mLength; i++) {
						System.out.println("(" + (i + 1) + ") " + MenuItem.get(i).getName() + "		"
								+ MenuItem.get(i).getFoodCategory() + "		" + MenuItem.get(i).getDescription()
								+ "		$" + String.format("%.2f", MenuItem.get(i).getPrice()));
					}

					System.out.println("(0) Go back to selection");
					System.out.printf("Enter the number of your choice: ");
					choice = sc.nextInt();

					while (choice != 0) {
						found.addOrderItem(MenuItem.get(choice - 1));
						System.out.println(MenuItem.get(choice - 1).getName() + " Added!");

						System.out.printf("Enter the number of your choice: ");
						choice = sc.nextInt();
					}
					choice = 1;
					break;
				case 2:
					int pLength = Promotion.size();

					System.out.println("CHOICE NAME		DESCRIPTION		PRICE");
					for (int i = 0; i < pLength; i++) {
						System.out.println("(" + (i + 1) + ") " + Promotion.get(i).getName() + "		"
								+ Promotion.get(i).getDescription() + "				"
								+ String.format("%.2f", Promotion.get(i).getPrice()));
					}

					System.out.println("(0) Go back to selection");
					System.out.printf("Enter the number of your choice: ");
					choice = sc.nextInt();

					while (choice != 0) {
						found.addOrderItem(Promotion.get(choice - 1));
						System.out.println(Promotion.get(choice - 1).getName() + " Added!");
						System.out.printf("Enter the number of your choice: ");
						choice = sc.nextInt();
					}
					choice = 1;
					break;
				case 3:
					choice = 0;
					break;
				default:
					System.out.println("Invalid Choice!");
					break;
				}
			}
		} else {
			System.out.println("Order not found!");
		}
	}

}