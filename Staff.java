/**
 * Represents the Staff working at the restaurant.
 * @author Benjamin Chun Wei Jie
 * @version 13
 * @since 2021-11-13
 */
public class Staff {

	/**
	 * The name of the Staff.
	 */
	private String name;

	/**
	 * The gender of the Staff.
	 */
	private char gender;

	/**
	 * The ID of the staff.
	 */
	private int staffID;

	/**
	 * The job title of the Staff.
	 */
	private jobTitle job;

	/**
	 * Creates Staff with name, gender, jobPosition and staffID inputs.
	 * jobPosition must match the jobs in jobTitles class.
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
	 * Print this Staff's information (name, staffID, gender, job).
	 */
	public void printStaffInformation(){
		System.out.println("Staff information for " + name + ":\r\n"
				+ "Staff ID: " + staffID + "\r\n"
				+ "Gender: " + gender + "\r\n"
				+ "Job Title: " + job + "\r\n");
	}

	/**
	 * Get the name of this Staff.
	 * @return This Staff's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name of the Staff.
	 * @param name Name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the gender of the Staff.
	 * @return This Staff's gender.
	 */
	public char getGender() {
		return this.gender;
	}

	/**
	 * Set the gender of the Staff.
	 * @param gender Gender to be set.
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * 
	 * @return
	 */
	public int getStaffID() {
		return this.staffID;
	}

	/**
	 * 
	 * @param staffID
	 */
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public jobTitle getJobTitle() {
		return this.job;
	}

	/**
	 * 
	 * @param jobTitle
	 */
	public void setJobTitle(String jobPosition) {
		switch(jobPosition){
			case "MANAGER": this.job = jobTitle.MANAGER;
			case "CASHIER": this.job = jobTitle.CASHIER;
			case "SERVER": this.job = jobTitle.SERVER;
			case "CHEF": this.job = jobTitle.CHEF;
		}
	}
	public boolean checkID(int ID){
		boolean idMatch=false;
		if(this.staffID==ID){
			idMatch=true;
		}
		return idMatch;
	}

}