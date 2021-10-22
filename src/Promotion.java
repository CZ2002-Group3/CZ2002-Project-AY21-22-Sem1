import java.util.ArrayList;

public class Promotion {

	private double price;
	private ArrayList<MenuItem> menuItem;
	private String description;
	private String name;
	
	public Promotion() {
		menuItem = new ArrayList<MenuItem>();
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addMenuItem(MenuItem item) {
		menuItem.add(item);
	}

	public void removeMenuItem(int index) {
		menuItem.remove(index);
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