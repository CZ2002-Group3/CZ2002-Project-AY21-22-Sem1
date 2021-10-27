/**
 Represents Staff in the restaurant.
 @author Thai Wei Cheng
 @version 1.0
 @since 2021-10-27
*/

public class Staff {

	private String name;
	private long employeeID;
	private String jobTitle;

	/**
	 * Constructor to create Staff.
	 */
	public Staff(String name, long employeeID, String jobTitle) {
		this.name = name;
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
	}

	
	/** 
	 * Accessor method to get the staff name.
	 * @return String - this name.
	 */
	public String getStaffName() {
		return this.name;
	}

	
	/** 
	 * Accessor method to get the employee ID.
	 * @return long - this employeeID
	 */
	public long getEmpolyeeID() {
		return this.employeeID;
	}

	
	/** 
	 * Accessor method to get the Job title.
	 * @return String - this jobtitle.
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}
}