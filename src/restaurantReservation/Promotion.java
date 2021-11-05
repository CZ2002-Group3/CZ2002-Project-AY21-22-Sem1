package restaurantReservation;
import java.util.ArrayList;

/**
 Represents a promotion in the restaurant.
 @author SS7_Grp3  
 @version 1.0
 @since 2021-10-25
*/

public class Promotion {

	private double price;
	private ArrayList<MenuItem> menuItem;
	private String description;
	private String name;

	/**
	 * Constructor to create promotion.
	 * Initialise array list of menuItems to store menuItems.
	 */
	public Promotion() {
		menuItem = new ArrayList<MenuItem>();
	}
	
	
	/** 
	 * Accessor method to get the description of this promotion.
	 * @return String - this description.
	 */
	public String getDescription() {
		return this.description;
	}

	
	/** 
	 * Mutator method to set the description of this promotion.
	 * @param description Description of this promotion.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/** 
	 * Mutator method to add menuItem to the list of menuItems.
	 * @param item MenuItem to add
	 */
	public void addMenuItem(MenuItem item) {
		menuItem.add(item);
	}

	
	/** 
	 * Mutator method to remove menuItem from the array list.
	 * Specify the index of the menuItem to be removed.
	 * @param index index of menuItem to remove
	 */
	public void removeMenuItem(int index) {
		menuItem.remove(index);
	}

	
	/** 
	 * Mutator method to set the price of this promotion.
	 * @param price price of the promotion
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
	/** 
	 * Accessor method to get the price of this promotion
	 * @return double - this promotion price
	 */
	public double getPrice() {
		return this.price;
	}

	
	/** 
	 * Accessor method to get the array list of menuItems that belong to this promotion
	 * @return ArrayList<MenuItem> - this promotion menuItems
	 */
	public ArrayList<MenuItem> getPromoList() {
		return(menuItem);
	}

	
	/** 
	 * Mutator method to set the name of this promotion
	 * @param name name of this promotion
	 */
	public void setName(String name){
		this.name = name;
	}

	
	/** 
	 * Accessor method to get the name of this promotion.
	 * @return String - this promotion name
	 */
	public String getName() {
		return this.name;
	}

}