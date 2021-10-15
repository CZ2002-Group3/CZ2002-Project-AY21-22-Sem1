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
		// TODO - implement Promotion.Promotion
		// this.price = price;
		// this.description = description;
		// for (int i = 0; i < items.length; i++) {
		// menuItem.add(items[i]);
	}

	public String getDescription() {
		// TODO - implement Promotion.getDescription
		return this.description;
	}

	public void setDescription(String description) {
		// TODO - implement Promotion.getDescription
		this.description = description;
	}

	public Double getPromoPrice() {
		// TODO - implement Promotion.getPromoPrice
		return this.price;
	}

	public void addMenuItem(MenuItem item) {
		// TODO - implement Promotion.addMenuItem
		menuItem.add(item);
	}

	public void removeMenuItem(MenuItem item) {
		// TODO - implement Promotion.removeMenuItem
		menuItem.remove(item);
	}

	public void setPrice(double price) {
		// TODO - implement Promotion.setPrice
		this.price = price;
	}

	public double getPrice() {
		// TODO - implement Promotion.setPrice
		return this.price;
	}

	public ArrayList<MenuItem> getPromoList() {
		return (menuItem);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}