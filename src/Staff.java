public class Staff {

	private String name;
	private long employeeID;
	private String jobTitle;

	public Staff(String name, long employeeID, String jobTitle) {
		this.name = name;
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
	}

	
	/** 
	 * @return String
	 */
	public String getStaffName() {
		return this.name;
	}

	
	/** 
	 * @return long
	 */
	public long getEmpolyeeID() {
		return this.employeeID;
	}

	
	/** 
	 * @return String
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}
}