import java.util.ArrayList;

public class Promotion {

	private double price;
	private ArrayList<MenuItem> menuItem;
	private String description;
	private String name;
	
	public Promotion() {
		menuItem = new ArrayList<MenuItem>();
	}
	
	
	/** 
	 * @return String
	 */
	public String getDescription() {
		return this.description;
	}

	
	/** 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/** 
	 * @param item
	 */
	public void addMenuItem(MenuItem item) {
		menuItem.add(item);
	}

	
	/** 
	 * @param index
	 */
	public void removeMenuItem(int index) {
		menuItem.remove(index);
	}

	
	/** 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
	/** 
	 * @return double
	 */
	public double getPrice() {
		return this.price;
	}

	
	/** 
	 * @return ArrayList<MenuItem>
	 */
	public ArrayList<MenuItem> getPromoList() {
		return(menuItem);
	}

	
	/** 
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}

	
	/** 
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

}