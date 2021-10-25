public class Customer {

	private long customerId;
	private String cutomerName;
	private Boolean isMember;
	private long contactNumber;

	public Customer(long customerId, String customerName, Boolean isMember, long contactNumber) {
		this.customerId = customerId;
		this.cutomerName = customerName;
		this.isMember = isMember;
		this.contactNumber = contactNumber;
	}

	
	/** 
	 * @return Boolean
	 */
	public Boolean getIsMember() {
		return this.isMember;
	}

	
	/** 
	 * @return String
	 */
	public String getCustomerName() {
		return this.cutomerName;
	}

	
	/** 
	 * @return long
	 */
	public long getContactNumber() {
		return this.contactNumber;
	}

	
	/** 
	 * @return long
	 */
	public long getCustomerID() {
		return this.customerId;
	}

	
	/** 
	 * @param isMember
	 */
	public void setIsMember(Boolean isMember) {
		this.isMember = isMember;
	}

	
	/** 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.cutomerName = customerName;
	}

	
	/** 
	 * @param contactNumber
	 */
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	/** 
	 * @param customerId
	 */
	public void setCustomerID(long customerId) {
		this.customerId = customerId;
	}
}