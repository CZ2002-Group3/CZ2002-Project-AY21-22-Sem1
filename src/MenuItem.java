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

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public FoodCategory getFoodCategory() {
		return foodType;
	}

	public Double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setFoodCategory(FoodCategory foodType) {
		this.foodType = foodType;
	}

}