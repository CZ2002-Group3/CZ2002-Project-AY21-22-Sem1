import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PromotionMgr {

<<<<<<< Updated upstream
	public PromotionMgr(Restaurant restaurant) {
		// TODO - implement PromotionMgr.PromotionMgr
		this.restaurant = restaurant;
=======
	public PromotionMgr() {
>>>>>>> Stashed changes
	}

	/**
	 * 
	 * @param Promotion
	 */
	public void getPromotionList(List<Promotion> promotions) {
		System.out.println("The current promotions are: ");
		if(promotions.size() == 0){
			System.out.println("There are currently no ongoing promotions!");
		} else {
			for(int i = 0; i < promotions.size(); i++){
				System.out.println(promotions.get(i).getName());
				System.out.println(promotions.get(i).getDescription());
				System.out.println(promotions.get(i).getPrice());
				System.out.println();
			}
		}
	}


	public void updatePromotion(List<Promotion> promotions, List<MenuItem> menuItems) {

		Scanner sc = new Scanner(System.in);
		int promoFound = 0;

		while(true){
			System.out.println("Enter the name of the promotion that you would like to update.");
			System.out.print("Name of Promo: ");
			String promoName = sc.nextLine();
			if(promotions.size() == 0){
				System.out.println("There are currently no ongoing promotions!");
			} else {
				for(int i = 0; i < promotions.size(); i++){
					if(promoName == promotions.get(i).getName()){
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
				for(int i = 0; i < promotions.size(); i++){
					if(promoFound == i) {
						Promotion promotion = promotions.get(i); 
						System.out.println("Current items in " + promotions.get(i).getName());

						for (int item = 0; item < promotion.getPromoList().size(); i++) {
							System.out.println(promotion.getPromoList().get(item));
						}

						System.out.println();
						System.out.println(promotions.get(i).getDescription());
						System.out.println(promotions.get(i).getPrice());
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
=======
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
>>>>>>> Stashed changes
							System.out.print("1. Add items" + "2. Delete items");
<<<<<<< HEAD
=======
							int userInp = sc.nextInt();
							// if ()
<<<<<<< Updated upstream
							break;
						case 2:
							break;
						case 3:
=======
=======
>>>>>>> cad58e0c802a23181162462d3156a3b600a71883
							System.out.print("1. Add items\n" + "2. Delete items\n" + " Enter '-1' to exit.");
							do {

								int userInp = sc.nextInt();

								if (userInp == 1){
									String itemToAdd = sc.nextLine();
									if(menuItems.size() == 0){
										System.out.println("There are currently no items in the menu.");
									} else {
										boolean existPromo = false;
										boolean existMenu = false;

										for (int item = 0; item < promotions.get(promoFound).getPromoList().size(); item++){
											if(itemToAdd == promotions.get(promoFound).getPromoList().get(item).getName()){
												System.out.println("The menu item already exist in the promotion: " + promotions.get(promoFound).getName());
												existPromo = true;
												break;
											}
										}

										if(!existPromo){
											for (int i = 0; i < menuItems.size(); i++){
												if (itemToAdd == menuItems.get(i).getName()){
													System.out.println("Successfully added " + menuItems.get(i).getName() + "to promotion " + promotions.get(promoFound).getName());
													promotions.get(promoFound).addMenuItem(menuItems.get(i));
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
									for (int item = 0; item < promotions.get(promoFound).getPromoList().size(); item++){
										if(itemToDelete == promotions.get(promoFound).getPromoList().get(item).getName()){
											System.out.println("Successfully deleted " + menuItems.get(item).getName() + "in promotion: " + promotions.get(promoFound).getName());
											existPromo = true;
											break;
										}
									}
									if(!existPromo){
										System.out.println("Item does not exist in promotion: " + promotions.get(promoFound).getName());
									} 
								}
							} while (userInput != -1);

<<<<<<< HEAD
=======
>>>>>>> Stashed changes
=======
							if ()
>>>>>>> 12adf10fc053f409a2938cff28968ef7be578bb2
>>>>>>> a05da49db3fa8b165218b24503df9e0704938453
							break;

>>>>>>> cad58e0c802a23181162462d3156a3b600a71883
						case 2:
							System.out.println("Please enter the new description:");
							String description = sc.nextLine();
							promotions.get(promoFound).setDescription(description);
							System.out.println("Successfully updated description for promotion: " + promotions.get(promoFound).getName());
							break;
						case 3:
							System.out.print("Please enter the new price:");
							double price = sc.nextDouble();
							promotions.get(promoFound).setPrice(price);
							System.out.println("Successfully updated price for promotion: " + promotions.get(promoFound).getName());
>>>>>>> Stashed changes
							break;
					}
				} while (userInput != -1);
				

			}
		}
	}

	public void createPromotion(List<Promotion> promotions, List<MenuItem> menuItems) {
		Scanner sc = new Scanner(System.in);
		Promotion promotion = new Promotion();

		System.out.println("Current Items in the menu that you can add to promotion: ");
<<<<<<< Updated upstream
		if(menuItem.size() == 0){
			System.out.println("There is currently nothing in the Menu!");
=======
		if(menuItems.size() == 0){
			System.out.println("There is currently nothing in the menu!");
			//return;
>>>>>>> Stashed changes
				
		} else { 
			for (int i = 0; i < menuItems.size(); i++){
				System.out.println(menuItems.get(i));
			}
		}
		

		System.out.println("Please enter the items that you would like to add to the promotion: ");
		System.out.println("Enter menu items and 'c' to cancel");
		while(true){
			String userInput = sc.nextLine();
			if (userInput.charAt(0) == 'c'){
				break;
			}
			else {
				MenuItem itemToAdd;
				int failToFind = 0;
				for (int i = 0; i < menuItems.size(); i++){
					if(userInput == menuItems.get(i).getName()){
						itemToAdd = menuItems.get(i);
						promotion.addMenuItem(itemToAdd);
						break;
					} else {
						failToFind++;
					}
				}
				if(failToFind == menuItems.size() - 1){
					System.out.println("The menu item is not found. Please try again!");
				}
			}
		}


		// set name
		System.out.println("Please set the name for this promotion package!");
		System.out.print("Name: ");
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

		promotions.add(promotion);
		System.out.println("Successfully added a new promotion");
	}

	/**
	 * 
	 * @param Promotion
	 */
<<<<<<< Updated upstream
	public void deletePromotion(int Promotion) {
		// TODO - implement PromotionMgr.deletePromotion
		
	}

}
=======
	public void deletePromotion(List<Promotion> promotions) {
		Scanner sc = new Scanner(System.in);
		boolean existPromo = false;
<<<<<<< HEAD
		int itemToRemove = 0;
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

=======

<<<<<<< HEAD
>>>>>>> cad58e0c802a23181162462d3156a3b600a71883
		System.out.println("The current ongoing promotions are: "); 
		if(promotions.size() == 0){
			System.out.println("There are currently no ongoing promotions!");
		} else {
<<<<<<< HEAD
			for(int i = 0; i < promotions.size(); i++){
				itemToRemove = i;
				System.out.printf("%d: %s\n", i + 1, promotions.get(i).getName());
=======
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
>>>>>>> cad58e0c802a23181162462d3156a3b600a71883
			}
			do {
				System.out.println("\nWhich of the above promotions would you like to remove?");
				System.out.print("Enter number: ");
				int promoToRemove = sc.nextInt();
				if(promoToRemove == 0 || promoToRemove >= promotions.size() + 1){
					System.out.println("Please enter a valid number!");
				} else{
					promotions.remove(promoToRemove - 1);
					System.out.println("Successfully removed promotion: " + promotions.get(itemToRemove).getName());
					return;
				}
			} while(true);
		}
	}
}
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
}
>>>>>>> 12adf10fc053f409a2938cff28968ef7be578bb2
>>>>>>> a05da49db3fa8b165218b24503df9e0704938453
>>>>>>> cad58e0c802a23181162462d3156a3b600a71883
>>>>>>> Stashed changes
