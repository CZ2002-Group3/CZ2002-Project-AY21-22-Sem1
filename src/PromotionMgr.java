import java.util.List;
import java.util.Scanner;

public class PromotionMgr {

	public PromotionMgr() {}

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
		int userInput;
		Promotion promotion;

		while(true){
			System.out.println("The current ongoing promotions are: "); 
			if(promotions.size() == 0){
				System.out.println("There are currently no ongoing promotions!\n");
				return;
			} else {
				for(int i = 0; i < promotions.size(); i++){
					System.out.printf("%d: %s\n", i + 1,  promotions.get(i).getName());
				}
				System.out.println("Enter the the promotion that you would like to update.");
				int promoFound = sc.nextInt();
				if (promoFound <= 0 || promoFound >= promotions.size() + 1) {
					if(promoFound == -1){
						break;
					}
					System.out.println("Please enter a valid index.");
				} else {
					promoFound -= 1;
					for(int i = 0; i < promotions.size(); i++){
						if(promoFound == i) {
							promotion = promotions.get(i); 

							System.out.println("Current items in " + promotions.get(i).getName() + ":");

							for (int item = 0; item < promotion.getPromoList().size(); item++) {
								System.out.println(promotion.getPromoList().get(item).getName());
							}

							System.out.println("Descriptions:\n" + promotions.get(i).getDescription());
							System.out.println("Promotion price:\n" + promotions.get(i).getPrice());
							System.out.println();
						}
					}

					System.out.println("Please choose which of the following you would like to update: ");
					System.out.print("1. Menu items\n" + "2. Descriptions\n" + "3. Price\n");
					
					do {
						System.out.print("Choice of which to update: ");
						userInput = sc.nextInt();
						switch(userInput) {
							case 1:
								int userInp = 0;
								System.out.println("What would you like to do?");
								System.out.print("1. Add items\n" + "2. Delete items\n" + "Enter '-1' to exit.\n");
								do {
									System.out.print("Choice: ");
									userInp = sc.nextInt();

									if (userInp == 1){
										if(menuItems.size() == 0){
											System.out.println("There is currently nothing in the menu!");
											break;				
										} else { 
											for (int i = 0; i < menuItems.size(); i++){
												System.out.printf("%d: %s\n", i + 1, menuItems.get(i).getName());
											}
										}
										int itemToAdd = 0;
										System.out.println("Choose a menu item to add: ");
										do {
											System.out.print("Choice of menu item to add: ");
											itemToAdd = sc.nextInt();
											if(itemToAdd <= 0 || itemToAdd >= menuItems.size() + 1){
												if (itemToAdd == -1){
													break;
												}
												System.out.println("Please enter a valid index.");
											} else {
												itemToAdd -= 1;
												boolean existPromo = false;
												for (int item = 0; item < promotions.get(promoFound).getPromoList().size(); item++){
													if(menuItems.get(itemToAdd).getName() == promotions.get(promoFound).getPromoList().get(item).getName()){
														System.out.println("The menu item already exist in the promotion " + promotions.get(promoFound).getName());
														existPromo = true;
														break;
													}
												}

												if(!existPromo){	
													System.out.println("Successfully added " + menuItems.get(itemToAdd).getName() + " to promotion " + promotions.get(promoFound).getName());
													promotions.get(promoFound).addMenuItem(menuItems.get(itemToAdd));																							 
												}
											}
										}while(true);

									} else if (userInp == 2){
										int itemToDelete = 0;

										System.out.println("Current items in " + promotions.get(promoFound).getName() + ":");

										for (int item = 0; item < promotions.get(promoFound).getPromoList().size(); item++) {
											System.out.printf("%d: %s\n", item + 1, promotions.get(promoFound).getPromoList().get(item).getName());
										} 
										System.out.print("Choice of menu item to remove: ");
										itemToDelete = sc.nextInt();

										if(itemToDelete <= 0 || itemToDelete >= promotions.get(promoFound).getPromoList().size() + 1){
											System.out.println("Please enter a valid index.");
										} else {
											itemToDelete -= 1;
											System.out.println("Successfully deleted " + promotions.get(promoFound).getPromoList().get(itemToDelete).getName() + " in promotion " + promotions.get(promoFound).getName());
											promotions.get(promoFound).removeMenuItem(itemToDelete);
										}
									}
								} while (userInput != -1);
								break;

							case 2:
								sc.nextLine();
								System.out.println("Please enter the new description: ");
								String description = sc.nextLine();
								promotions.get(promoFound).setDescription(description);
								System.out.println("Successfully updated description for promotion " + promotions.get(promoFound).getName());
								break;

							case 3:
								System.out.print("Please enter the new price: ");
								double price = sc.nextDouble();
								promotions.get(promoFound).setPrice(price);
								System.out.println("Successfully updated price for promotion " + promotions.get(promoFound).getName());
								break;
						}
					} while (userInput != -1);
				}
			}
		}
	}

	public void createPromotion(List<Promotion> promotions, List<MenuItem> menuItems) {
		Scanner sc = new Scanner(System.in);
		Promotion promotion = new Promotion();
		int userInput = 0;

		System.out.println("Current Items in the menu that you can add to promotion: ");

		if(menuItems.size() == 0){
			System.out.println("There is currently nothing in the menu!");
			return;				
		} else { 
			for (int i = 0; i < menuItems.size(); i++){
				System.out.printf("%d: %s\n", i + 1, menuItems.get(i).getName());
			}
		}
		

		System.out.println("Please enter the items that you would like to add to the promotion: ");
		System.out.println("Enter menu items ('-1' to cancel):");
		do{
			userInput = sc.nextInt();
			if (userInput <= 0 || userInput >= menuItems.size() + 1) {
				if(userInput == -1){
					break;
				}
				System.out.println("Please enter a valid index.");
			} else {
				userInput -= 1;
				MenuItem itemToAdd;
				boolean existPromo = false;
				for (int i = 0; i < menuItems.size(); i++){
					if(userInput == i){
						itemToAdd = menuItems.get(i);
						for (int item = 0; item < promotion.getPromoList().size(); item++){
							if (itemToAdd.getName() == promotion.getPromoList().get(item).getName()){
								existPromo = true;
								break;
							}
						}
						if(!existPromo){
							promotion.addMenuItem(itemToAdd);
							System.out.println("Successfully added " + itemToAdd.getName() + ".");
							break;
						} else {
							System.out.println("Menu item already exist.");
						}
					} 
				}
			}
		} while(userInput >= 0);

		sc.nextLine();
		if(promotion.getPromoList().size() != 0){
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
			System.out.println("Successfully added a new promotion.\n");

		} else {
			System.out.println("Please add at least one item!\n");
		}
	}

	/**
	 * 
	 * @param Promotion
	 */
	public void deletePromotion(List<Promotion> promotions) {
		Scanner sc = new Scanner(System.in);

		System.out.println("The current ongoing promotions are: "); 
		if(promotions.size() == 0){
			System.out.println("There are currently no ongoing promotions!\n");
		} else {
			for(int i = 0; i < promotions.size(); i++){
				System.out.printf("%d: %s\n", i + 1,  promotions.get(i).getName());
			}
			do {
				System.out.println("Which of the above promotions would you like to remove?");
				System.out.print("Enter number: ");
				int promoToRemove = sc.nextInt();
				if(promoToRemove <= 0 || promoToRemove >= promotions.size() + 1){
					if(promoToRemove == -1){
						break;
					}
					System.out.println("Please enter a valid number!");
				} else{
					promoToRemove -= 1;
					System.out.println("Successfully removed promotion " + promotions.get(promoToRemove).getName() + "!\n");
					promotions.remove(promoToRemove);
					break;
				}
			} while(true);
		}
	}
}


