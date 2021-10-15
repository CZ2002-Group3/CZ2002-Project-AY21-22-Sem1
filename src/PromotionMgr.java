import java.util.ArrayList;
import java.util.Scanner;

public class PromotionMgr {
	private Restaurant restaurant;

	public PromotionMgr(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	/**
	 * 
	 * @param Promotion
	 */
	public void getPromotionList() {
		System.out.println("The current promotions are: ");
		if(restaurant.promotions.size() == 0){
			System.out.println("There are currently no ongoing promotions!");
		} else {
			for(int i = 0; i < restaurant.promotions.size(); i++){
				System.out.println(restaurant.promotions.get(i).getName());
				System.out.println(restaurant.promotions.get(i).getDescription());
				System.out.println(restaurant.promotions.get(i).getPrice());
				System.out.println();
			}
		}
	}


	public void updatePromotion() {

		Scanner sc = new Scanner(System.in);
		int promoFound = 0;

		while(true){
			System.out.println("Enter the name of the promotion that you would like to update.");
			System.out.print("Name of Promo: ");
			String promoName = sc.nextLine();
			if(restaurant.promotions.size() == 0){
				System.out.println("There are currently no ongoing promotions!");
			} else {
				for(int i = 0; i < restaurant.promotions.size(); i++){
					if(promoName == restaurant.promotions.get(i).getName()){
						promoFound = i;
						break;
					} else {
						promoFound = -1;
					}
				}
			}

			if(promoFound == -1) {
				System.out.println("The promotion does not exist. Please try again!");
			} else {
				for(int i = 0; i < restaurant.promotions.size(); i++){
					if(promoFound == i) {
						Promotion promotion = restaurant.promotions.get(i); 
						System.out.println("Current items in " + restaurant.promotions.get(i).getName());

						for (int item = 0; item < promotion.getPromoList().size(); i++) {
							System.out.println(promotion.getPromoList().get(item));
						}

						System.out.println();
						System.out.println(restaurant.promotions.get(i).getDescription());
						System.out.println(restaurant.promotions.get(i).getPrice());
						System.out.println();
					}
				}

				System.out.println("Please choose which of the following you would like to update: ");
				System.out.print("1. Menu items\n" + "2. Descriptions\n" + "3. Price\n");
				int userInput = sc.nextInt();

				do {
					switch(userInput) {
						case 1:
							System.out.println("What would you like to do?");
<<<<<<< Updated upstream
							System.out.print("1. Add items" + "2. Delete items");
<<<<<<< HEAD
=======
							int userInp = sc.nextInt();
<<<<<<< HEAD
							// if ()
=======
							System.out.print("1. Add items\n" + "2. Delete items\n" + " Enter '-1' to exit.");
							do {

								int userInp = sc.nextInt();

								if (userInp == 1){
									String itemToAdd = sc.nextLine();
									if(restaurant.menuItems.size() == 0){
										System.out.println("There are currently no items in the menu.");
									} else {
										boolean existPromo = false;
										boolean existMenu = false;

										for (int item = 0; item < restaurant.promotions.get(promoFound).getPromoList().size(); item++){
											if(itemToAdd == restaurant.promotions.get(promoFound).getPromoList().get(item).getName()){
												System.out.println("The menu item already exist in the promotion: " + restaurant.promotions.get(promoFound).getName());
												existPromo = true;
												break;
											}
										}

										if(!existPromo){
											for (int i = 0; i < restaurant.menuItems.size(); i++){
												if (itemToAdd == restaurant.menuItems.get(i).getName()){
													System.out.println("Successfully added " + restaurant.menuItems.get(i).getName() + "to promotion " + restaurant.promotions.get(promoFound).getName());
													restaurant.promotions.get(promoFound).addMenuItem(restaurant.menuItems.get(i));
													existMenu = true;
													break;
												} 
											}
										}

										if(!existMenu){
											System.out.println("Item does not exist in the menu. Please try again.");
										}
									} 
								} else {
									String itemToDelete = sc.nextLine();
									boolean existPromo = false;
									for (int item = 0; item < restaurant.promotions.get(promoFound).getPromoList().size(); item++){
										if(itemToDelete == restaurant.promotions.get(promoFound).getPromoList().get(item).getName()){
											System.out.println("Successfully deleted " + restaurant.menuItems.get(item).getName() + "in promotion: " + restaurant.promotions.get(promoFound).getName());
											existPromo = true;
											break;
										}
									}
									if(!existPromo){
										System.out.println("Item does not exist in promotion: " + restaurant.promotions.get(promoFound).getName());
									} 
								}
							} while (userInput != -1);

>>>>>>> Stashed changes
=======
							if ()
>>>>>>> 12adf10fc053f409a2938cff28968ef7be578bb2
>>>>>>> a05da49db3fa8b165218b24503df9e0704938453
							break;

						case 2:
							System.out.println("Please enter the new description:");
							String description = sc.nextLine();
							restaurant.promotions.get(promoFound).setDescription(description);
							System.out.println("Successfully updated description for promotion: " + restaurant.promotions.get(promoFound).getName());
							break;
						case 3:
							System.out.print("Please enter the new price:");
							double price = sc.nextDouble();
							restaurant.promotions.get(promoFound).setPrice(price);
							System.out.println("Successfully updated price for promotion: " + restaurant.promotions.get(promoFound).getName());
							break;
					}
				} while (userInput != -1);
			}
		}
	}

	public void createPromotion(ArrayList<MenuItem> menuItem) {
		Scanner sc = new Scanner(System.in);
		Promotion promotion = new Promotion();

		System.out.println("Current Items in the menu that you can add to promotion: ");
		if(menuItem.size() == 0){
			System.out.println("There is currently nothing in the menu!");
				
		} else { 
			for (int i = 0; i < menuItem.size(); i++){
				System.out.println(menuItem.get(i));
			}
		}

		System.out.println("Please enter the items that you would like to add to the promotion: ");
		System.out.println("Enter menu items and 'c' to cancel");
		while(true){
			String userInput = sc.nextLine();
			if (userInput == "c"){
				break;
			}
			else {
				MenuItem itemToAdd;
				int failToFind = 0;
				for (int i = 0; i < restaurant.menuItems.size(); i++){
					if(userInput == restaurant.menuItems.get(i).getName()){
						itemToAdd = restaurant.menuItems.get(i);
						promotion.addMenuItem(itemToAdd);
						break;
					} else {
						failToFind++;
					}
				}
				if(failToFind == restaurant.menuItems.size() - 1){
					System.out.println("The menu item is not found. Please try again!");
				}
			}
		}


		// set name
		System.out.println("Please set the name for this promotion package!");
		System.out.print("Price: ");
		String name = sc.nextLine();
		promotion.setName(name);

		// set descriptions
		System.out.println("Please set the descriptions for this promotion package!");
		System.out.print("Descriptions: ");
		String descriptions = sc.nextLine();
		promotion.setDescription(descriptions);

		// Set price
		System.out.println("Please set the price for this promotion package!");
		System.out.print("Price: ");
		double price = sc.nextDouble();
		promotion.setPrice(price);

		restaurant.promotions.add(promotion);
	}

	/**
	 * 
	 * @param Promotion
	 */
	public void deletePromotion() {
		Scanner sc = new Scanner(System.in);
		boolean existPromo = false;
<<<<<<< HEAD

		System.out.println("The current ongoing promotions are: "); 
		if(restaurant.promotions.size() == 0){
			System.out.println("There are currently no ongoing promotions!");
		} else {
			for(int i = 0; i < restaurant.promotions.size(); i++){
				System.out.println(restaurant.promotions.get(i).getName());
			}
			System.out.println("\nWhich of the above promotions would you like to remove?");
			System.out.print("Enter promotion name: ");

			String promoToRemove = sc.nextLine();

=======

<<<<<<< HEAD
		System.out.println("The current ongoing promotions are: "); 
		if(restaurant.promotions.size() == 0){
			System.out.println("There are currently no ongoing promotions!");
		} else {
			for(int i = 0; i < restaurant.promotions.size(); i++){
				System.out.println(restaurant.promotions.get(i).getName());
			}
			System.out.println("\nWhich of the above promotions would you like to remove?");
			System.out.print("Enter promotion name: ");

			String promoToRemove = sc.nextLine();

>>>>>>> a05da49db3fa8b165218b24503df9e0704938453
			for(int item = 0; item < restaurant.promotions.size(); item++) {
				if (promoToRemove == restaurant.promotions.get(item).getName()) {
					restaurant.promotions.remove(item);
					existPromo = true;
					break;
				} 
			}

			if(!existPromo) {
				System.out.println("Promotion name not found. Please try again!");
			}
		}
	}
}
<<<<<<< HEAD
=======
=======
}
>>>>>>> 12adf10fc053f409a2938cff28968ef7be578bb2
>>>>>>> a05da49db3fa8b165218b24503df9e0704938453
