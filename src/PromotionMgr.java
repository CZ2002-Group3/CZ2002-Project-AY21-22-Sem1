/**
 Represents the manager of promotion class.
 @author Chua Wen Rong, Jonathan
 @version 1.0
 @since 2021-10-25
*/

import java.util.List;
import java.util.Scanner;

public class PromotionMgr {
	/**
	 * Constructor to create promotion manager.
	 */
	public PromotionMgr() {
	}

	/**
	 * Function used when generating the list of ongoing promotions.
	 * Iterates through the list of promotions, and prints them out.
	 * @param Promotion This is the list of promotions.
	 */
	public void getPromotionList(List<Promotion> promotions) {
		System.out.println("The current promotions are: ");
		if (promotions.size() == 0) {
			System.out.println("There are currently no ongoing promotions!");
		} else {
			for(int i = 0; i < promotions.size(); i++){
				System.out.println("(" + (i+1) + ") " + promotions.get(i).getName() + ":");
				System.out.println("\tDescriptions: \n\t" + promotions.get(i).getDescription());
				System.out.println("\tPrice: $" +  String.format("%.2f",promotions.get(i).getPrice()));
				System.out.println();
			}
		}
	}

	
	/** 
	 * Function that performs the update on a particular promotion in the list of ongoing promotions.
	 * Updates current promotion by adding new menu items.
	 * Updates current promotion by deleting existing menu items.
	 * Updates the descriptions of existing promotion.
	 * Updates the price of the existing promotion.
	 * @param promotions This is the list of promotions.
	 * @param menuItems This is the list of menuItems.
	 */
	public void updatePromotion(List<Promotion> promotions, List<MenuItem> menuItems) {

		Scanner sc = new Scanner(System.in);
		int userInput;
		Promotion promotion;

		while (true) {
			System.out.println("The current ongoing promotions are: ");
			if (promotions.size() == 0) {
				System.out.println("There are currently no ongoing promotions!\n");
				return;
			} else {
				for (int i = 0; i < promotions.size(); i++) {
					System.out.printf("(%d) %s\n", i + 1, promotions.get(i).getName());
				}
				System.out.println("Enter the the promotion that you would like to update (-1 to quit):");

				int promoFound;
				do {
					while (!sc.hasNextInt()) {
						System.out.println("Input is invalid, try again!");
						System.out.println("Enter the the promotion that you would like to update (-1 to quit):");
						sc.next();
					}
					promoFound = sc.nextInt();
					break;
				} while (true);

				if (promoFound <= 0 || promoFound >= promotions.size() + 1) {
					if (promoFound == -1) {
						break;
					}
					System.out.println("Please enter a valid index.");
				} else {
					promoFound -= 1;
					for (int i = 0; i < promotions.size(); i++) {
						if (promoFound == i) {
							promotion = promotions.get(i);

							System.out.println("Current items in " + promotions.get(i).getName() + ":");

							for (int item = 0; item < promotion.getPromoList().size(); item++) {
								System.out.println(promotion.getPromoList().get(item).getName());
							}

							System.out.println("\nDescriptions:\n" + promotions.get(i).getDescription());
							System.out.println("\nPromotion price: $" +  String.format("%.2f",promotions.get(i).getPrice()));
							System.out.println();
						}
					}

					do {
						System.out.println("Please choose which of the following you would like to update: ");
						System.out.print("(1) Menu items\n" + "(2) Descriptions\n" + "(3) Price\n");
						System.out.print("Choice of which to update (-1 to quit): ");
						do {
							while (!sc.hasNextInt()) {
								System.out.println("Input is invalid, try again!");
								System.out.print("Choice of which to update (-1 to quit): ");
								sc.next();
							}
							userInput = sc.nextInt();
							break;
						} while (true);

						switch (userInput) {
						case 1:
							int userInp = 0;

							do {
								System.out.println("\nWhat would you like to do?");
								System.out.print("1. Add items\n" + "2. Delete items\n");
								System.out.print("Choice of action (-1 to quit): ");

								do {
									while (!sc.hasNextInt()) {
										System.out.println("Input is invalid, try again!");
										System.out.print("Choice of action (-1 to quit): ");
										sc.next();
									}
									userInp = sc.nextInt();
									break;
								} while (true);

								if (userInp == 1) {

									if (menuItems.size() == 0) {
										System.out.println("There is currently nothing in the menu!");
										break;
									} else {
										System.out.println("Choose a menu item to add: ");
										for (int i = 0; i < menuItems.size(); i++) {
											System.out.printf("(%d) %s\n", i + 1, menuItems.get(i).getName());
										}
									}
									int itemToAdd = 0;

									do {
										System.out.print("\nChoice of menu item to add (-1 to quit): ");

										do {
											while (!sc.hasNextInt()) {
												System.out.println("Input is invalid, try again!");
												System.out.print("\nChoice of menu item to add (-1 to quit): ");
												sc.next();
											}
											itemToAdd = sc.nextInt();
											break;
										} while (true);

										if (itemToAdd <= 0 || itemToAdd >= menuItems.size() + 1) {
											if (itemToAdd == -1) {
												System.out.println("No new item was added... Exiting...\n");
												break;
											}
											System.out.println("Please enter a valid index.");
										} else {
											itemToAdd -= 1;
											boolean existPromo = false;
											for (int item = 0; item < promotions.get(promoFound).getPromoList()
													.size(); item++) {
												if (menuItems.get(itemToAdd).getName() == promotions.get(promoFound)
														.getPromoList().get(item).getName()) {
													System.out.println("The menu item already exist in the promotion "
															+ promotions.get(promoFound).getName());
													existPromo = true;
													break;
												}
											}

											if (!existPromo) {
												System.out.println("Successfully added "
														+ menuItems.get(itemToAdd).getName() + " to promotion "
														+ promotions.get(promoFound).getName());
												promotions.get(promoFound).addMenuItem(menuItems.get(itemToAdd));
											}
										}
									} while (true);

								} else if (userInp == 2) {
									int itemToDelete = 0;
									do {
										System.out
											.println("Current items in " + promotions.get(promoFound).getName() + ":");
										if(promotions.get(promoFound).getPromoList().size() == 1){
											System.out.printf("(%d) %s\n", 1,
													promotions.get(promoFound).getPromoList().get(0).getName());
											System.out.println("There is only one item left in the promotion, add more menu items first before deleting!");
											break;
										}
										for (int item = 0; item < promotions.get(promoFound).getPromoList()
												.size(); item++) {
											System.out.printf("(%d) %s\n", item + 1,
													promotions.get(promoFound).getPromoList().get(item).getName());
										}
										System.out.print("Choice of menu item to remove (-1 to quit): ");

										do {
											while (!sc.hasNextInt()) {
												System.out.println("Input is invalid, try again!");
												System.out.print("Choice of menu item to remove (-1 to quit): ");
												sc.next();
											}
											itemToDelete = sc.nextInt();
											break;
										} while (true);

										if (itemToDelete <= 0
												|| itemToDelete >= promotions.get(promoFound).getPromoList().size() + 1) {
											if (itemToDelete == -1) {
												System.out.println("No item was deleted... Exiting...\n");
												return;
											} else {
												System.out.println("Please enter a valid index.\n");
											}

										} else {
											itemToDelete -= 1;
											System.out.println("Successfully deleted "
													+ promotions.get(promoFound).getPromoList().get(itemToDelete).getName()
													+ " in promotion " + promotions.get(promoFound).getName() + "\n");
											promotions.get(promoFound).removeMenuItem(itemToDelete);
										}
									} while(true);
								}
							} while (userInp != -1);
							break;

						case 2:
							sc.nextLine();
							System.out
									.println("\nCurrent descriptions:\n" + promotions.get(promoFound).getDescription());
							System.out.println("\nPlease enter the new description (-1 to quit): ");

							String description = sc.nextLine();
							if (description.charAt(0) != '-' && description.charAt(1) != '1') {
								promotions.get(promoFound).setDescription(description);
								System.out.println("\nSuccessfully updated description for promotion "
										+ promotions.get(promoFound).getName() + "\n");
							} else {
								System.out.println("Description is not updated... Exiting...\n");
							}

							break;

						case 3:
							System.out.println("\nCurrent promotion price: $" +  String.format("%.2f",promotions.get(promoFound).getPrice()));
							System.out.print("\nPlease enter the new price (-1 to quit): $");

							double price;

							do {
								while (!sc.hasNextDouble()) {
									System.out.println("Input is invalid, try again!");
									System.out.print("\nPlease enter the new price (-1 to quit): $");
									sc.next();
								}
								price = sc.nextDouble();
								break;

							} while (true);

							if (price != -1) {
								promotions.get(promoFound).setPrice(price);
								System.out.println("\nSuccessfully updated price for promotion "
										+ promotions.get(promoFound).getName() + "\n");
							} else {
								System.out.println("Price was not updated... Exiting...\n");
							}
							break;
						}
					} while (userInput != -1);
				}
			}
		}
	}

	
	/** 
	 * Function to create promotion to be added to the list of promotions
	 * Creates promotion by specifying the name, description, price and choice of menuItems.
	 * @param promotions This is the list of promotions.
	 * @param menuItems This is the list of menuItems.
	 */
	public void createPromotion(List<Promotion> promotions, List<MenuItem> menuItems) {
		Scanner sc = new Scanner(System.in);
		Promotion promotion = new Promotion();
		int userInput = 0;

		System.out.println("Current Items in the menu that you can add to promotion: ");

		if (menuItems.size() == 0) {
			System.out.println("There is currently nothing in the menu!");
			return;
		} else {
			for (int i = 0; i < menuItems.size(); i++) {
				System.out.printf("(%d) %s\n", i + 1, menuItems.get(i).getName());
			}
		}

		System.out.println("Please enter the items that you would like to add to the promotion: ");

		do {
			System.out.print("Enter menu items (-1 to quit): ");

			do {
				while (!sc.hasNextInt()) {
					System.out.println("Input is invalid, try again!");
					System.out.print("Enter menu items (-1 to quit):");
					sc.next();
				}
				userInput = sc.nextInt();
				break;

			} while (true);

			if (userInput <= 0 || userInput >= menuItems.size() + 1) {
				if (userInput == -1) {
					break;
				}
				System.out.println("Please enter a valid index.");
			} else {
				userInput -= 1;
				MenuItem itemToAdd;
				boolean existPromo = false;
				for (int i = 0; i < menuItems.size(); i++) {
					if (userInput == i) {
						itemToAdd = menuItems.get(i);
						for (int item = 0; item < promotion.getPromoList().size(); item++) {
							if (itemToAdd.getName() == promotion.getPromoList().get(item).getName()) {
								existPromo = true;
								break;
							}
						}
						if (!existPromo) {
							promotion.addMenuItem(itemToAdd);
							System.out.println("Successfully added " + itemToAdd.getName() + ".");
							break;
						} else {
							System.out.println("Menu item already exist.");
						}
					}
				}
			}
		} while (userInput >= 0);

		sc.nextLine();
		if (promotion.getPromoList().size() != 0) {
			// set name
			System.out.println("\nPlease set the name for this promotion package (-1 to quit):");
			System.out.print("Name: ");
			String name = sc.nextLine();
			if (name.charAt(0) != '-' && name.charAt(1) != '1') {
				promotion.setName(name);
			} else {
				System.out.println("Promotion not added... Exiting...\n");
				return;
			}

			// set descriptions
			System.out.println("\nPlease set the descriptions for this promotion package (-1 to quit):");
			System.out.print("Descriptions: ");
			String descriptions = sc.nextLine();
			if (descriptions.charAt(0) != '-' && descriptions.charAt(1) != '1') {
				promotion.setDescription(descriptions);
			} else {
				System.out.println("Promotion not added... Exiting...\n");
				return;
			}
			// Set price
			System.out.println("\nPlease set the price for this promotion package (-1 to quit):");
			System.out.print("Price: $");

			double price;
			do {
				while (!sc.hasNextDouble()) {
					System.out.println("Input is invalid, try again!");
					System.out.print("Price: $");
					sc.next();
				}
				price = sc.nextDouble();
				break;
			} while (true);

			if (price != -1) {
				promotion.setPrice(price);
			} else {
				System.out.println("Promotion not added... Exiting...\n");
				return;
			}

			promotions.add(promotion);
			System.out.println("Successfully added a new promotion.\n");

		} else {
			System.out.println("Please add at least one item!\n");
		}
	}

	/**
	 * Function to delete ongoing promotion from the list of promotions.
	 * Specify which promotion to be deleted from the list
	 * Deletes the promotion specified.
	 * @param Promotion This is the list of promotions.
	 */
	public void deletePromotion(List<Promotion> promotions) {
		Scanner sc = new Scanner(System.in);

		System.out.println("The current ongoing promotions are: ");
		if (promotions.size() == 0) {
			System.out.println("There are currently no ongoing promotions!\n");
		} else {
			do{
				System.out.println("The current ongoing promotions are: ");
				for (int i = 0; i < promotions.size(); i++) {
					System.out.printf("(%d) %s\n", i + 1, promotions.get(i).getName());
				}
				do {
					System.out.println("Which of the above promotions would you like to remove?");
					System.out.print("Enter number (-1 to quit): ");
	
					int promoToRemove;
	
					do {
						while (!sc.hasNextInt()) {
							System.out.println("Input is invalid, try again!");
							System.out.print("Enter number (-1 to quit): ");
							sc.next();
						}
						promoToRemove = sc.nextInt();
						break;
	
					} while (true);
	
					if (promoToRemove <= 0 || promoToRemove >= promotions.size() + 1) {
						if (promoToRemove == -1) {
							System.out.println("No existing promotion removed... Exiting...\n");
							return;
						}
						System.out.println("Please enter a valid index.");
					} else {
						promoToRemove -= 1;
						System.out.println("Successfully removed promotion " + promotions.get(promoToRemove).getName() + ".\n");
						promotions.remove(promoToRemove);
						break;
					}
				} while (true);
			} while(promotions.size() != 0);
		}
	}
}