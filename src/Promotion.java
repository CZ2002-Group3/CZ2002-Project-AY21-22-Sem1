import java.util.ArrayList;

public class Promotion {

	private double price;
	private ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>();
	private String description;
	private String name;

	/**
	 * 
	 * @param Double
	 * @param menuItem
	 */
	public Promotion() {
	}
	

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPromoPrice() {
		return this.price;
	}

	public void addMenuItem(MenuItem item) {
		menuItem.add(item);
	}

	public void removeMenuItem(MenuItem item) {
		menuItem.remove(item);
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	public ArrayList<MenuItem> getPromoList() {
		return(menuItem);
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}