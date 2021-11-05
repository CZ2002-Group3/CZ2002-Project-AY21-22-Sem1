package restaurantReservation;

/**
 Represents Staff in the restaurant.
 @author SS7_Grp3
 @version 1.0
 @since 2021-10-27
*/
public class Staff {

	private String name;
	private long employeeID;
	private String jobTitle;

	/**
	 * Constructor to create Staff.
	 * @param name The name of the staff.
	 * @param employeeID staff employee ID.
	 * @param jobTitle The job title of the staff.
	 */
	public Staff(String name, long employeeID, String jobTitle) {
		this.name = name;
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
	}

	
	/** 
	 * Accessor method to get the staff name.
	 * @return the name of the staff
	 */
	public String getStaffName() {
		return this.name;
	}

	
	/** 
	 * Accessor method to get the employee ID.
	 * @return the employee ID of the staff
	 */
	public long getEmployeeID() {
		return this.employeeID;
	}

	
	/** 
	 * Accessor method to get the Job title.
	 * @return the job title of the staff
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}
}