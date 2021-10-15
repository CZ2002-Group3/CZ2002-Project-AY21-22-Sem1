import java.util.*;

public class MenuItemMgr {

	ArrayList<MenuItem> menuItems;

	public MenuItemMgr() {
		// TODO - implement MenuItemMgr.MenuItemMgr
		// throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param MenuItem
	 */
	public void updateMenuItem(ArrayList<MenuItem> menuItems) {

		Scanner sc = new Scanner(System.in);
		int size = menuItems.size();

		for (int i = 0; i < size; i++) {
			System.out.println("Press (" + i + ") to update" + menuItems.get(i).getName());
		}

		int foodToUpdate = sc.nextInt();

		System.out.println("Press 0 if the food type is unchanged");
		System.out.println("Press 1 to change name of the food type");
		int usrInput = sc.nextInt();

		if (usrInput == 1) {
			System.out.println("Enter new name of the food");
			String foodName = sc.nextLine();
			menuItems.get(foodToUpdate).setName(foodName);

		}

		System.out.println("Enter 0 if the description of this food type is unchanged");
		System.out.println("Press 1 to change name of the food type");
		usrInput = sc.nextInt();

		if (usrInput == 1) {
			System.out.println("Enter new description of the food");
			String foodDescription = sc.nextLine();
			menuItems.get(foodToUpdate).setDescription(foodDescription);
		}

		System.out.println("Enter 0 if the price of this food type is unchanged");
		System.out.println("Press 1 to change name of the food type");
		usrInput = sc.nextInt();

		if (usrInput == 1) {
			System.out.println("Enter price of the food");
			double foodPrice = sc.nextDouble();
			menuItems.get(foodToUpdate).setPrice(foodPrice);

		}

	}

	public MenuItem createMenuItem() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Press (1) to add a Main course");
		System.out.println("Press (2) to add a Drink");
		System.out.println("Press (3) to add a Dessert");

		int foodChoice = sc.nextInt();

		FoodCategory foodCat = FoodCategory.MAIN_COURSE;
		if (foodChoice == 2) {
			foodCat = FoodCategory.DRINKS;
		} else if (foodChoice == 3) {
			foodCat = FoodCategory.DESSERT;
		}

		System.out.println("Enter the name of the food type");

		String foodName = sc.nextLine();

		System.out.println("Enter a description of this food type");

		String foodDescription = sc.nextLine();

		System.out.println("Enter the price of this food type");

		double foodPrice = sc.nextDouble();

		return new MenuItem(foodName, foodDescription, foodPrice, foodCat);
	}

	/**
	 * 
	 * @param MenuItem
	 */
	public void deleteMenuItem(ArrayList<MenuItem> menuItems) {
		Scanner sc = new Scanner(System.in);
		int size = menuItems.size();

		for (int i = 0; i < size; i++) {
			System.out.println("Press (" + i + ") to delete" + menuItems.get(i).getName());
		}

		int foodToDelete = sc.nextInt();

		menuItems.remove(foodToDelete);
	}

}