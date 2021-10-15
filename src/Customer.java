public class Customer {

	private int customerId;
	private String cutomerName;
	private Boolean isMember;
	private int contactNumber;

	public Customer(int customerId, String customerName, Boolean isMember, int contactNumber) {
		this.customerId = customerId;
		this.cutomerName = customerName;
		this.isMember = isMember;
		this.contactNumber = contactNumber;
	}

	public Boolean getIsMember() {
		return this.isMember;
	}

}