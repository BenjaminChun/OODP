import java.util.ArrayList;
import java.util.Scanner;

public class StaffManager {

	private ArrayList<Staff> staffList;

	public StaffManager() {
		// TODO - implement StaffManager.StaffManager
		//throw new UnsupportedOperationException();
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
	

	public void printInterface(){
		Scanner sc = new Scanner(System.in);
		int staffID;
		int choice;
		do {
			System.out.println("(1) Add Staff");
			System.out.println("(2) Remove Staff");
			System.out.println("(3) Print Staff List");
			System.out.print("\t Enter the number of your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1: 
					System.out.println("\t Adding Staff ..");
					System.out.print("\t Please enter Name: ");
					String name = sc.nextLine();

					System.out.println("\t Please enter Staff ID: ");
					staffID = sc.nextInt();
					sc.nextLine();
					
					System.out.println("\t Please enter gender");
					char gender = sc.nextLine().charAt(0);
					

					boolean validJob = false;
					String job = new String();
					while (validJob == false){
						System.out.println("\t Please enter job position: ");
						job = sc.nextLine();
						validJob = checkValidJob(job);
					}
					
					addStaff(name, gender, job, staffID);;
					break;
					
				case 2:
					System.out.println("\t Please enter staff ID of the staff you wish to remove: ");
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
	 * 
	 * @param name
	 * @param gender
	 * @param staffTitle
	 * @param ID
	 */
	public void addStaff(String name, char gender, String staffTitle, int ID) {
		// TODO - implement StaffManager.addStaff
		//throw new UnsupportedOperationException();
		Staff newStaff = new Staff(name, gender, staffTitle, ID);
		staffList.add(newStaff);
	}

	

	/**
	 * 
	 * @param ID
	 */
	public void deleteStaff(int ID) {
		// TODO - implement StaffManager.deleteStaff
		Staff staffFound=checkExist(ID);
		if(staffFound==null){
			System.out.println("No such staff found!");
		}
		else{
			staffList.remove(staffFound);
			System.out.println("Staff removed");	
		}
		//throw new UnsupportedOperationException();
	}

	public void displayList() {
		// TODO - implement StaffManager.displayList
		//throw new UnsupportedOperationException();
		System.out.println("Staff List:");
		int index = 1;
		for (Staff staff : staffList){
			System.out.println("Staff "+index+":");
			System.out.println("---------------------------------------");
			staff.printStaffInformation();
			index++;
		}
	}

	public Staff checkExist(int ID){
		// TODO - implement ReservationManager.checkExist
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

	public Staff getStaff(int index){
		return this.staffList.get(index);
	}

	public int getSizeOfStaffList(){
		return this.staffList.size();
	}
}