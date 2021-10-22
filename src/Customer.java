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

	public Boolean getIsMember() {
		return this.isMember;
	}

	public String getCustomerName(){
		return this.cutomerName;
	}

	public long getContactNumber(){
		return this.contactNumber;
	}

	public long getCustomerID(){
		return this.customerId;
	}
}