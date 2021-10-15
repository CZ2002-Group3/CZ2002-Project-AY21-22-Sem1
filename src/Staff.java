public class Staff {

	private String name;
	private long employeeID;
	private String jobTitle;

	public Staff(String name, long employeeID, String jobTitle) {
		this.name = name;
		this.employeeID = employeeID;
		this.jobTitle = jobTitle;
	}

	public String getStaffName() {
		return this.name;
	}

	public long getEmpolyeeID() {
		return this.employeeID;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}
}