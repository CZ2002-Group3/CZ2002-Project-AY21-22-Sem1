import java.util.ArrayList;
import java.util.Scanner;

public class PromotionMgr {
	private Restaurant restaurant;

	public PromotionMgr(Restaurant restaurant) {
		// TODO - implement PromotionMgr.PromotionMgr
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
							System.out.print("1. Add items" + "2. Delete items");
							int userInp = sc.nextInt();
							if ()
							break;
						case 2:
							break;
						case 3:
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
			System.out.println("There is currently nothing in the Menu!");
				
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
	public void deletePromotion(int Promotion) {
		// TODO - implement PromotionMgr.deletePromotion
		
	}

}