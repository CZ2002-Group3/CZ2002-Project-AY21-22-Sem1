/**
 Represents a customer in the restaurant.
 @author Thai Wei Cheng
 @version 1.0
 @since 2021-10-29
*/

public class Customer {

	private long customerId;
	private String cutomerName;
	private Boolean isMember;
	private long contactNumber;

	/**
	 * Constructor to create Customer.
	 * @param customerId The id of the customer.
	 * @param customerName The name of the customer.
	 * @param isMember The boolean to show if the customer is a member or not.
	 * @param contactNumber The customer number of the customer
	 */
	public Customer(long customerId, String customerName, Boolean isMember, long contactNumber) {
		this.customerId = customerId;
		this.cutomerName = customerName;
		this.isMember = isMember;
		this.contactNumber = contactNumber;
	}

	
	/** 
	 * Get the boolean isMember.
	 * @return this customer isMember boolean.
	 */
	public Boolean getIsMember() {
		return this.isMember;
	}

	
	/** 
	 * Get the customer name.
	 * @return this customer name.
	 */
	public String getCustomerName() {
		return this.cutomerName;
	}

	
	/** 
	 * Get the customer contact number.
	 * @return this contact number.
	 */
	public long getContactNumber() {
		return this.contactNumber;
	}

	
	/** 
	 * Get the customer ID.
	 * @return this customer id
	 */
	public long getCustomerID() {
		return this.customerId;
	}

	
	/** 
	 * Set the customer isMember boolean.
	 * @param isMember The boolean to show if the customer is a member or not.
	 */
	public void setIsMember(Boolean isMember) {
		this.isMember = isMember;
	}

	
	/** 
	 * Set the customer name.
	 * @param customerName The name of the customer.
	 */
	public void setCustomerName(String customerName) {
		this.cutomerName = customerName;
	}

	
	/** 
	 * Set the customer contact number.
	 * @param contactNumber The customer number of the customer
	 */
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	/** 
	 * Set the customer customer id.
	 * @param customerId The id of the customer.
	 */
	public void setCustomerID(long customerId) {
		this.customerId = customerId;
	}
}