public class MenuItem {

	private String name;
	private String description;
	private double price;
	private FoodCategory foodType;

	public MenuItem(String name, String description, double price, FoodCategory foodType) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.foodType = foodType;
	}

	
	/** 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	
	/** 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	
	/** 
	 * @return FoodCategory
	 */
	public FoodCategory getFoodCategory() {
		return foodType;
	}

	
	/** 
	 * @return Double
	 */
	public Double getPrice() {
		return price;
	}

	
	/** 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/** 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
	/** 
	 * @param foodType
	 */
	public void setFoodCategory(FoodCategory foodType) {
		this.foodType = foodType;
	}

}