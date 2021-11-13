import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class TableManager {
	
	private ArrayList<Table> tableList;
	private static int maxCapacity = 10;
	public TableManager() {
		
		ArrayList<Table> tableList = new ArrayList<Table>();
		tableList.add(new Table(1, 2, Status.AVAILABLE));
		tableList.add(new Table(2, 4, Status.AVAILABLE));
		tableList.add(new Table(3, 6, Status.AVAILABLE));
		tableList.add(new Table(4, 6, Status.AVAILABLE));
		tableList.add(new Table(5, 8, Status.AVAILABLE));
		tableList.add(new Table(6, 8, Status.AVAILABLE));
		tableList.add(new Table(7, 10, Status.AVAILABLE));
		tableList.add(new Table(8, 10, Status.AVAILABLE));
		tableList.add(new Table(9, 10, Status.AVAILABLE));
		this.tableList = tableList;
	}
	public TableManager(ArrayList<Table> tableList) {
		this.tableList = tableList;
	}
	
	public ArrayList<Table> getAvailableTables() {
		ArrayList<Table> toReturnList = new ArrayList<Table>();
		//loop thru all tables to get available ones
		for (int i=0; i<tableList.size(); i++) {
			if (tableList.get(i).getStatus() == Status.AVAILABLE) {
				toReturnList.add(tableList.get(i));
			}
		}
		return toReturnList;
		// TODO - implement TableManager.getAvailableTables
		//throw new UnsupportedOperationException();
	}

	public ArrayList<Table> getOccupiedTables() {
		ArrayList<Table> toReturnList = new ArrayList<Table>();
		//loop thru all tables to get available ones
		for (int i=0; i<tableList.size(); i++) {
			if (tableList.get(i).getStatus() == Status.OCCUPIED) {
				toReturnList.add(tableList.get(i));
			}
		}
		return toReturnList;
		// TODO - implement TableManager.getOccupiedTables
		//throw new UnsupportedOperationException();
	}

	public ArrayList<Table> getReservedTables() {
		ArrayList<Table> toReturnList = new ArrayList<Table>();
		//loop thru all tables to get available ones
		for (int i=0; i<tableList.size(); i++) {
			if (tableList.get(i).getStatus() == Status.RESERVED) {
				toReturnList.add(tableList.get(i));
			}
		}
		return toReturnList;
		// TODO - implement TableManager.getReservedTables
		//throw new UnsupportedOperationException();
	}
	public int getUserInput(){
		System.out.println("How many seats required?");
		Scanner sc = new Scanner(System.in);
		int minSeats = sc.nextInt();
		while(minSeats > 10){
			System.out.println("Sorry at most 10 seats only.");
			minSeats = sc.nextInt();
		}
		return minSeats;
	}
	/**
	 * 
	 * @param minSeats
	 */
	public int findSuitableTableFromAvailable(int minSeats) {
		ArrayList<Table> availableTables = getAvailableTables();
		int chosenTableNo = -1; //set this to be updated, and returned
		if (minSeats > maxCapacity) {
			System.out.println("No suitable Table found, max Capacity per table is only 10!");
		}
		for (int i = 0; i < availableTables.size(); i++) {
			if (availableTables.get(i).getSeatingCapacity() >= minSeats) {
				if (chosenTableNo == -1) {//guard against chosen == -1
					chosenTableNo = i;
				}
				else if (availableTables.get(i).getSeatingCapacity() < availableTables.get(chosenTableNo).getSeatingCapacity()){
					chosenTableNo = i; //it is more than seats required and less than prev chosen tables
				}
			}
		}
		if (chosenTableNo == -1) {
			System.out.println("No suitable Table for " + minSeats);
			return chosenTableNo;
		}
		System.out.println("Table " + availableTables.get(chosenTableNo).getId() + " found " + "with " + availableTables.get(chosenTableNo).getSeatingCapacity() + " seats\n");
		return availableTables.get(chosenTableNo).getId(); //returns tableNo or -1 when no tables are found
	}

	public int findSuitableTableFromReserved(int minSeats) {
		ArrayList<Table> reservedTables = getReservedTables();
		int chosenTableNo = -1; //set this to be updated, and returned
		if (minSeats > maxCapacity) {
			System.out.println("No suitable Table found, max Capacity per table is only 10!");
		}
		for (int i = 0; i < reservedTables.size(); i++) {
			if (reservedTables.get(i).getSeatingCapacity() >= minSeats) {
				if (chosenTableNo == -1) {//guard against chosen == -1
					chosenTableNo = i;
				}
				else if (reservedTables.get(i).getSeatingCapacity() < reservedTables.get(chosenTableNo).getSeatingCapacity()){
					chosenTableNo = i; //it is more than seats required and less than prev chosen tables
				}
			}
		}
		if (chosenTableNo == -1) {
			System.out.println("No suitable Table for " + minSeats);
			return chosenTableNo;
		}
		System.out.println("Table " + reservedTables.get(chosenTableNo).getId() + " found " + "with " + reservedTables.get(chosenTableNo).getSeatingCapacity() + " seats\n");
		return reservedTables.get(chosenTableNo).getId(); //returns tableNo or -1 when no tables are found
	}

	public int findSuitableTableFromOccupied(int minSeats) {
		ArrayList<Table> occupiedTables = getOccupiedTables();
		int chosenTableNo = -1; //set this to be updated, and returned
		if (minSeats > maxCapacity) {
			System.out.println("No suitable Table found, max Capacity per table is only 10!");
		}
		for (int i = 0; i < reservedTables.size(); i++) {
			if (reservedTables.get(i).getSeatingCapacity() >= minSeats) {
				if (chosenTableNo == -1) {//guard against chosen == -1
					chosenTableNo = i;
				}
				else if (reservedTables.get(i).getSeatingCapacity() < reservedTables.get(chosenTableNo).getSeatingCapacity()){
					chosenTableNo = i; //it is more than seats required and less than prev chosen tables
				}
			}
		}
		if (chosenTableNo == -1) {
			System.out.println("No suitable Table for " + minSeats);
			return chosenTableNo;
		}
		System.out.println("Table " + reservedTables.get(chosenTableNo).getId() + " found " + "with " + reservedTables.get(chosenTableNo).getSeatingCapacity() + " seats\n");
		return reservedTables.get(chosenTableNo).getId(); //returns tableNo or -1 when no tables are found
	}

	/**
	 * 
	 * @param tableID
	 */
	public void setTableToAvailable(int tableID) {
		tableList.get(tableID-1).setStatus(Status.AVAILABLE);
		System.out.println("Table "+ tableID + " set to Available");
		// TODO - implement TableManager.setTableToAvailable
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tableID
	 */
	public void setTableToOccupied(int tableID) {
		tableList.get(tableID-1).setStatus(Status.OCCUPIED);
		System.out.println("Table "+ tableID + " set to Occupied");
		// TODO - implement TableManager.setTableToOccupied
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tableID
	 */
	public void setTableToReserved(int tableID) {
		tableList.get(tableID-1).setStatus(Status.RESERVED);
		System.out.println("Table "+ tableID + " set to Reserved");
	}
	
	public void printTables(ArrayList<Table> tableList){
		if (tableList.isEmpty()){
			System.out.println("No Tables found\n");
			return;
		}
		else{
			System.out.println("\nHere is the list of " + tableList.get(0).getStatus() + " tables : ");
			for (int i=0; i<tableList.size(); i++){
				System.out.println("Table " + tableList.get(i).getId());
			}
			
		}
		System.out.println("\n");
	}
}