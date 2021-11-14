/**
 * Represents the Staff working at the restaurant.
 * @author Tan Zheng Kai
 * @version 14.0
 * @since 2021-11-13
 */
public class Staff {

	/**
	 * The name of this Staff.
	 */
	private String name;

	/**
	 * The gender of this Staff.
	 */
	private char gender;

	/**
	 * The ID of this staff.
	 */
	private int staffID;

	/**
	 * The job title of this Staff.
	 */
	private jobTitle job;

	/**
	 * Creates a new Staff with the given name. 
	 * Job position of staff must be a valid position 
	 * present in the job title.
	 * @param name This Staff's name.
	 * @param gender This Staff's gender.
	 * @param jobPosition This Staff's job.
	 * @param staffID This Staff's ID.
	 */
	public Staff(String name, char gender, String jobPosition, int staffID ){
		this.name=name;
		this.gender=gender;
		setJobTitle(jobPosition);
		this.staffID=staffID;
	}

	/**
	 * Prints this Staff's information.
	 */
	public void printStaffInformation(){
		System.out.println("Staff information for " + name + ":\r\n"
				+ "Staff ID: " + staffID + "\r\n"
				+ "Gender: " + gender + "\r\n");
		switch(job){
			case MANAGER: System.out.println("Job Title: MANAGER"); break;
			case CASHIER:  System.out.println("Job Title: CASHIER"); break;
			case SERVER:  System.out.println("Job Title: SERVER"); break;
			case CHEF:  System.out.println("Job Title: CHEF"); break;
		}
		System.out.println();
	}

	/**
	 * Gets the name of this Staff.
	 * @return This Staff's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Changes the name of this Staff.
	 * @param name Name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the gender of this Staff.
	 * @return This Staff's gender.
	 */
	public char getGender() {
		return this.gender;
	}

	/**
	 * Set the gender of this Staff.
	 * @param gender Gender to be set.
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * Gets the staff ID of this Staff.
	 * @return This Staff's staff ID.
	 */
	public int getStaffID() {
		return this.staffID;
	}

	/**
	 * Changes the staffID of this Staff.
	 * @param staffID staffID to be set.
	 */
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	/**
	 * Gets the job of this Staff.
	 * @return This Staff's job.
	 */
	public jobTitle getJobTitle() {
		return this.job;
	}

	/**
	 * Changes the job of this Staff.
	 * @param jobPosition jobPosition to be set.
	 */
	public void setJobTitle(String jobPosition) {
		switch(jobPosition){
			case "MANAGER": this.job = jobTitle.MANAGER; break;
			case "CASHIER": this.job = jobTitle.CASHIER; break;
			case "SERVER": this.job = jobTitle.SERVER; break;
			case "CHEF": this.job = jobTitle.CHEF; break;
		}
	}

	/**
	 * Checks this Staff's ID with an ID the user input.
	 * @param ID ID to be compared with.
	 * @return true if the IDs match.
	 */
	public boolean checkID(int ID){
		boolean idMatch=false;
		if(this.staffID==ID){
			idMatch=true;
		}
		return idMatch;
	}

}