import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the Staff Manager at the restaurant.
 * Manages the Staff in the restaurant.
 * @author Tan Zheng Kai
 * @version 16.0
 * @since 2021-11-13
 */
public class StaffManager {

	/**
	 * List of staffs working in the restaurant.
	 */
	private ArrayList<Staff> staffList;

	/**
	 * Creates the StaffManager storing the list of staff
	 * that works at the restaurant.
	 */
	public StaffManager() {
		this.staffList = new ArrayList<Staff>();
		Staff staff1 = new Staff("Han Kang", 'M', "MANAGER", 1);
		Staff staff2 = new Staff("Ming Jun", 'F', "CASHIER", 2);
		Staff staff3 = new Staff("Zheng Kai", 'F', "SERVER", 3);
		Staff staff4 = new Staff("Benjamin", 'M', "CHEF", 4);
		this.staffList.add(staff1);
		this.staffList.add(staff2);
		this.staffList.add(staff3);
		this.staffList.add(staff4);
	}
	
	/**
	 * Prints the interface for the user to interact with.
	 */
	public void printInterface(){
		Scanner sc = new Scanner(System.in);
		int staffID;
		int choice;
		do {
			System.out.println("(1) Add Staff");
			System.out.println("(2) Remove Staff");
			System.out.println("(3) Print Staff List");
			System.out.print("Enter the number of your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1: 
					System.out.println("Adding Staff ..");
					System.out.print("Please enter Name: ");
					String name = sc.nextLine();

					System.out.println("Please enter Staff ID: ");
					staffID = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Please enter gender");
					char gender = sc.nextLine().charAt(0);
					

					boolean validJob = false;
					String job = new String();
					while (validJob == false){
						System.out.println("Please enter job position: ");
						job = sc.nextLine();
						validJob = checkValidJob(job);
					}
					
					addStaff(name, gender, job, staffID);;
					break;
					
				case 2:
					System.out.println("Please enter staff ID of the staff you wish to remove: ");
					staffID = sc.nextInt();
					sc.nextLine();
					deleteStaff(staffID);
					break;
					
				case 3:
					displayList();
					break;
			}
		} while (choice < 3);
	}

	/**
	 * Check if the input job is a valid jobTitle.
	 * @param job The job that is provided as input.
	 * @return true if the job is valid.
	 */
	public boolean checkValidJob(String job){
		switch(job){
			case "MANAGER": return true;
			case "CASHIER": return true;
			case "SERVER": return true;
			case "CHEF": return true;
		}

		return false;
	}

	/**
	 * Add new Staff to the list of Staffs
	 * @param name The name of Staff to be added.
	 * @param gender The gender of Staff to be added.
	 * @param staffTitle The jobTitle of Staff to be added.
	 * @param ID The staffID of Staff to be added.
	 */
	public void addStaff(String name, char gender, String staffTitle, int ID) {
		Staff newStaff = new Staff(name, gender, staffTitle, ID);
		staffList.add(newStaff);
	}

	/**
	 * Delete Staff from the ArrayList of Staff.
	 * @param ID The staff ID of the Staff to be removed.
	 */
	public void deleteStaff(int ID) {
		Staff staffFound=checkExist(ID);
		if(staffFound==null){
			System.out.println("No such staff found!");
		}
		else{
			staffList.remove(staffFound);
			System.out.println("Staff removed");	
		}
	}

	/**
	 * Prints out the ArrayList of Staff.
	 */
	public void displayList() {
		System.out.println("Staff List:");
		int index = 1;
		for (Staff staff : staffList){
			System.out.println("Staff "+index+":");
			System.out.println("---------------------------------------");
			staff.printStaffInformation();
			index++;
		}
	}

	/**
	 * Checks if the Staff exists using the ID.
	 * ID used to check must match the ID of the staff in the list.
	 * @param ID ID used to check the list of staffs in this staff manager
	 * @return staff in the staff list.
	 */
	public Staff checkExist(int ID){
		Staff staffFound = null;
		boolean idMatch;
		for(Staff currentStaff : staffList){
			idMatch=currentStaff.checkID(ID);
			if(idMatch==true){
				staffFound=currentStaff;
				break;
			}
		}
		return staffFound;
	}
	/**
	 * Gets the staff of this staff manager.
	 * @param index Index to look for the specific staff.
	 * @return The Staff of this staff manager.
	 */
	public Staff getStaff(int index){
		return this.staffList.get(index);
	}

	/**
	 * Gets the size of the staff list.
	 * @return the size of the staff list of this staff manager.
	 */
	public int getSizeOfStaffList(){
		return this.staffList.size();
	}
}