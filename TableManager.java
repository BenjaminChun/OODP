import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a TableManager that will be in charge of the
 * operations done on Table objects.
 * @author Benjamin Chun Wei Jie
 * @version 13
 * @since 2021-11-13
 */
public class TableManager {
	
	/**
	 * ArrayList of Table objects
	 */
	private ArrayList<Table> tableList;

	/**
	 * Maximum capacity for a group of customer
	 */
	private static int maxCapacity = 10;

	/**
	 * Creates a TableManager object that has an ArrayList
	 * of Table objects.
	 */
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

	/**
	 * Creates a TableManager with an input Table ArrayList
	 * @param tableList This TableManager's tableList
	 */
	public TableManager(ArrayList<Table> tableList) {
		this.tableList = tableList;
	}
	
	/**
	 * Finds the tables that have Status.AVAILABLE and add
	 * them into a Table ArrayList to be returned.
	 * @return The Table ArrayList of available tables.
	 */
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

	/**
	 * Finds the tables that have Status.OCCUPIED and add
	 * them into a Table ArrayList to be returned.
	 * @return The Table ArrayList of occupied tables.
	 */
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

	/**
	 * Finds the tables that have Status.RESERVED and add
	 * them into a Table ArrayList to be returned.
	 * @return The Table ArrayList of reserved tables.
	 */
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

	/**
	 * Gets the user input for the number of seats required
	 * when they come to the restaurant.
	 * @return The minimum number of seats to fulfil
	 * 			the number of pax.
	 */
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
	 * Find an available Table that matches the minimum number of seats
	 * required by a customer.
	 * @param minSeats The minimum number of seats required.
	 * @return The tableID of the table found.
	 */
	public int findSuitableTableFromAvailable(int minSeats) {
		ArrayList<Table> availableTables = getAvailableTables();
		int chosenTableNo = -1; //set this to be updated, and returned
		if (minSeats > maxCapacity) {
			System.out.println("No suitable Table found, max Capacity per table is only 10!");
			return -1;
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
		System.out.println("Table " + availableTables.get(chosenTableNo).getId() + " found " + "with " + availableTables.get(chosenTableNo).getSeatingCapacity() + " seats");
		return availableTables.get(chosenTableNo).getId(); //returns tableNo or -1 when no tables are found
	}

	/**
	 * Find a reserved Table that matches the minimum 
	 * number of seats stated.
	 * @param minSeats The minimum number of seats.
	 * @return The tableID of the table found.
	 */
	public int findSuitableTableFromReserved(int minSeats) {
		ArrayList<Table> reservedTables = getReservedTables();
		int chosenTableNo = -1; //set this to be updated, and returned
		if (minSeats > maxCapacity) {
			System.out.println("No suitable Table found, max Capacity per table is only 10!");
			return -1;
		}
		for (int i = 0; i < reservedTables.size(); i++) {
			int seatingCapacity = reservedTables.get(i).getSeatingCapacity();
			if (seatingCapacity >= minSeats) {
				if (chosenTableNo == -1) {//guard against chosen == -1
					chosenTableNo = i;
				}
				else {
					int chosenTableSeatingCapacity = reservedTables.get(chosenTableNo).getSeatingCapacity();
					if (seatingCapacity < chosenTableSeatingCapacity) {
						chosenTableNo = i;
					}
				}
			}
		}
		if (chosenTableNo == -1) {
			System.out.println("No suitable Table for " + minSeats);
			return chosenTableNo;
		}
		else {
			System.out.println("Table " + reservedTables.get(chosenTableNo).getId() + " found " + "with " + reservedTables.get(chosenTableNo).getSeatingCapacity() + " seats");
			int tableID = reservedTables.get(chosenTableNo).getId(); //returns tableNo or -1 when no tables are found 
			return tableID;
		}
	}

	/**
	 * Find an occupied Table that matches the minimum 
	 * number of seats stated.
	 * @param minSeats The minimum number of seats.
	 * @return The tableID of the table found.
	 */
	public int findSuitableTableFromOccupied(int minSeats) {
		ArrayList<Table> occupiedTables = getOccupiedTables();
		int chosenTableNo = -1; //set this to be updated, and returned
		if (minSeats > maxCapacity) {
			System.out.println("No suitable Table found, max Capacity per table is only 10!");
			return -1;
		}
		for (int i = 0; i < occupiedTables.size(); i++) {
			if (occupiedTables.get(i).getSeatingCapacity() >= minSeats) {
				if (chosenTableNo == -1) {//guard against chosen == -1
					chosenTableNo = i;
				}
				else if (occupiedTables.get(i).getSeatingCapacity() < occupiedTables.get(chosenTableNo).getSeatingCapacity()){
					chosenTableNo = i; //it is more than seats required and less than prev chosen tables
				}
			}
		}
		if (chosenTableNo == -1) {
			System.out.println("No suitable Table for " + minSeats);
			return chosenTableNo;
		}
		System.out.println("Table " + occupiedTables.get(chosenTableNo).getId() + " found " + "with " + occupiedTables.get(chosenTableNo).getSeatingCapacity() + " seats");
		return occupiedTables.get(chosenTableNo).getId(); //returns tableNo or -1 when no tables are found
	}

	/**
	 * Set the Table's status to available.
	 * @param tableID The ID of the table to be changed to available.
	 */
	public void setTableToAvailable(int tableID) {
		Table table = tableList.get(tableID-1);
		table.setStatus(Status.AVAILABLE);
		System.out.println("Table "+ tableID + " set to Available");
		// TODO - implement TableManager.setTableToAvailable
		//throw new UnsupportedOperationException();
	}

	/**
	 * Set the Table's status to occupied.
	 * @param tableID The ID of the table to be changed to occupied.
	 */
	public void setTableToOccupied(int tableID) {
		tableList.get(tableID-1).setStatus(Status.OCCUPIED);
		System.out.println("Table "+ tableID + " set to Occupied");
		// TODO - implement TableManager.setTableToOccupied
		//throw new UnsupportedOperationException();
	}

	/**
	 * Set the Table's status to reserved.
	 * @param tableID The ID of the table to be changed to reserved.
	 */
	public void setTableToReserved(int tableID) {
		tableList.get(tableID-1).setStatus(Status.RESERVED);
		System.out.println("Table "+ tableID + " set to Reserved");
	}

	/**
	 * Prints the Tables in the tableList.
	 * @param tableList The tableList to be printed.
	 */
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