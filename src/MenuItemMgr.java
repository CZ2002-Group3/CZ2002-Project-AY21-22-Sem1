import java.util.*;

public class MenuItemMgr {

	public MenuItemMgr() {
	}

	public void updateMenuItem(List<MenuItem> menuItems) {

		Scanner sc = new Scanner(System.in);
		int size = menuItems.size();
		System.out.println(size);
		if (size == 0) {
			System.out.println("ERROR: No items on menu to update at the moment");
			return;
		}

		for (int i = 0; i < size; i++) {
			System.out.println("Press (" + i + ") to update " + menuItems.get(i).getName() + " | Costs: $"
					+ menuItems.get(i).getPrice());
		}
		System.out.println("Press (-1) to exit update");

		int foodToUpdate;
		do {

			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!");
				sc.next(); // this is important!
			}

			foodToUpdate = sc.nextInt();
			if (foodToUpdate < size) {
				break;
			}
			System.out
					.println("Input entered is either not an integer, or is not in the valid range. Please try again!");

		} while (foodToUpdate >= size || foodToUpdate <= -2);

		while (foodToUpdate != -1) {

			System.out.println("Press (0) if name of food is unchanged");
			System.out.println("Press (1) to change name of food");

			int usrInput;
			do {

				while (!sc.hasNextInt()) {
					System.out.println("That's not a number!");
					sc.next(); // this is important!
				}
				usrInput = sc.nextInt();

				if (usrInput == 0 || usrInput == 1) {
					break;
				}
				System.out.println(
						"Input entered is either not an integer, or is not in the valid range. Please try again!");

			} while (usrInput < 0 || usrInput >= 2);
			sc.nextLine();

			// int usrInput = sc.nextInt();
			// sc.nextLine();
			// while (usrInput < 0 || usrInput >= 2) {
			// System.out.println("Incorrect value entered. Please try again!");
			// usrInput = sc.nextInt();
			// sc.nextLine();
			// }

			if (usrInput == 1) {
				System.out.println("Enter new name of the food");
				String foodName = sc.nextLine();
				menuItems.get(foodToUpdate).setName(foodName);
			}

			System.out.println("Enter 0 if the description of food is unchanged");
			System.out.println("Press 1 to change description of the food");
			usrInput = sc.nextInt();
			sc.nextLine();
			while (usrInput < 0 || usrInput >= 2) {
				System.out.println("Incorrect value entered. Please try again!");
				usrInput = sc.nextInt();
				sc.nextLine();
			}

			if (usrInput == 1) {
				System.out.println("Enter new description of the food");
				String foodDescription = sc.nextLine();
				menuItems.get(foodToUpdate).setDescription(foodDescription);
			}

			System.out.println("Enter 0 if the price of this food type is unchanged");
			System.out.println("Press 1 to change price of the food");
			usrInput = sc.nextInt();
			sc.nextLine();
			while (usrInput < 0 || usrInput >= 2) {
				System.out.println("Incorrect value entered. Please try again!");
				usrInput = sc.nextInt();
				sc.nextLine();
			}

			if (usrInput == 1) {
				System.out.println("Enter new price of the food");
				double foodPrice = sc.nextDouble();
				menuItems.get(foodToUpdate).setPrice(foodPrice);
			}

			System.out.println("Selected menu item has been updated to " + menuItems.get(foodToUpdate).getName()
					+ " | Costs: $" + menuItems.get(foodToUpdate).getPrice());

			for (int i = 0; i < size; i++) {
				System.out.println("Press (" + i + ") to update " + menuItems.get(i).getName());
			}
			System.out.println("Press (-1) to exit update");

			sc.nextLine();
			do {
				System.out.println(
						"Input entered is either not an integer, or is not in the valid range. Please try again!");
				while (!sc.hasNextInt()) {
					System.out.println("That's not a number!");
					sc.next(); // this is important!
				}
				foodToUpdate = sc.nextInt();
			} while (foodToUpdate >= size);

			// foodToUpdate = sc.nextInt();
			// sc.nextLine();

			// while (foodToUpdate >= size) {
			// System.out.println("Incorrect value entered. Please try again!");
			// foodToUpdate = sc.nextInt();
			// sc.nextLine();
			// }

		}
	}

	public MenuItem createMenuItem() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Press (1) to add a Main course");
		System.out.println("Press (2) to add a Drink");
		System.out.println("Press (3) to add a Dessert");

		int foodChoice = sc.nextInt();
		sc.nextLine();
		while (foodChoice < 0 || foodChoice >= 4) {
			System.out.println("Incorrect value entered. Please try again!");
			foodChoice = sc.nextInt();
			sc.nextLine();
		}

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
		sc.nextLine();

		System.out.println("Added " + foodName + " | Costs: $" + foodPrice);
		return new MenuItem(foodName, foodDescription, foodPrice, foodCat);
	}

	/**
	 * 
	 * @param MenuItem
	 */
	public void deleteMenuItem(List<MenuItem> menuItems) {
		Scanner sc = new Scanner(System.in);
		int size = menuItems.size();

		if (size == 0) {
			System.out.println("ERROR: There are no menu items at the moment");
			return;
		}

		for (int i = 0; i < size; i++) {
			System.out.println("Press (" + i + ") to delete " + menuItems.get(i).getName());
		}
		System.out.println("Press (-1) to exit delete");

		int foodToDelete = sc.nextInt();
		sc.nextLine();

		while (foodToDelete >= size) {
			System.out.println("Incorrect value entered. Please try again!");
			foodToDelete = sc.nextInt();
			sc.nextLine();
		}

		while (foodToDelete != -1) {

			menuItems.remove(foodToDelete);

			for (int i = 0; i < menuItems.size(); i++) {
				System.out.println("Press (" + i + ") to delete " + menuItems.get(i).getName());
			}
			System.out.println("Press (-1) to exit delete");

			foodToDelete = sc.nextInt();
			sc.nextLine();

			while (foodToDelete >= menuItems.size()) {
				System.out.println("Incorrect value entered. Please try again!");
				foodToDelete = sc.nextInt();
				sc.nextLine();
			}
		}

	}

	public void printMenuItemList(List<MenuItem> menuItems) {
		Scanner sc = new Scanner(System.in);

		int size = menuItems.size();

		if (size == 0) {
			System.out.println("ERROR: No items are on the menu at the moment");
			return;
		}

		System.out.println("Items on the menu at the moment are as shown");

		for (int i = 0; i < size; i++) {
			System.out
					.println("(" + i + ") " + menuItems.get(i).getName() + " | Costs: $" + menuItems.get(i).getPrice());
		}
	}

}