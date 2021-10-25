/**
 * Represents a menu item in the restaurant.
 * @author Lee Yew Chuan Michael
 * @version 1.0
 * @since 2021-10-25
 */
public class MenuItem {

	private String name;
	private String description;
	private double price;
	private FoodCategory foodType;

	/**
	 * Create a new MenuItem according to the name of menu item, menu item desciption, menu item price, menu item food category 
	 * @param name        This is the name of the menu Item
	 * @param description This is description of the menu item
	 * @param price       This is the price ie. the unit cost of a menu item
	 * @param foodType    This is an enumeration. Ir refers to the food category of a menu item. It can only be 1 of the 3 food categories (1) MAIN COURSE, 2) DRINKS, 3) DESSERT
	 */
	public MenuItem(String name, String description, double price, FoodCategory foodType) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.foodType = foodType;
	}

	/**
	 * Gets the name attribute of the menu item
	 * @return name of the menu item
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name attribute of the menu item
	 * @param name This is the name of a menu item
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description attribute of the menu item
	 * @return description of the menu item
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description attribute of the menu item
	 * @param description This is the description of a menu item
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the price attribute of the menu item
	 * @return price of the menu item
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price attribute of the menu item
	 * @param price This is the price of the menu item
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the FoodCategory which the menu item belongs to
	 * @return FoodCategory of the menu item
	 */
	public FoodCategory getFoodCategory() {
		return foodType;
	}

	/**
	 * Sets the FoodCategory of the menu item
	 * @param foodType This is the FoodCategory of the menu item. It is an enumeration.
	 */
	public void setFoodCategory(FoodCategory foodType) {
		this.foodType = foodType;
	}

}
